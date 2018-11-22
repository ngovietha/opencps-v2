package org.graphql.api.controller.impl;

import com.liferay.petra.string.StringPool;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import javax.annotation.PostConstruct;

import org.apache.commons.io.IOUtils;
import org.graphql.api.controller.deliverable.crud.CreateDeliverableType;
import org.graphql.api.controller.deliverable.crud.GetDeliverableType;
import org.graphql.api.controller.deliverable.crud.GetDeliverableTypes;
import org.graphql.api.controller.utils.GraphQLUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

/**
 * Created binhth
 */
@Service
public class DeliverableService {

	private GraphQL graphQL;

	@PostConstruct
	public void loadGraphQLSchema() throws IOException {

		String schema = StringPool.BLANK;

		schema = GraphQLUtils.readGrapQL("deliverable.graphql");
		
		TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(schema);

		RuntimeWiring runtimeWiring = initWiring();
		GraphQLSchema graphQLSchema = new SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);
		graphQL = GraphQL.newGraphQL(graphQLSchema).build();

	}

	public GraphQL getGraphQL() {
		return graphQL;
	}

	private RuntimeWiring initWiring() {

		return RuntimeWiring.newRuntimeWiring()
				.type("Query",
						typeWiring -> typeWiring.dataFetcher("getDeliverableTypes", getDeliverableTypes)
								.dataFetcher("getDeliverableType", getDeliverableType))
				.type("Mutation", typeWiring -> typeWiring.dataFetcher("createDeliverableType", createDeliverableType))
				.build();
	}

	// DELIVERABLE
	@Autowired
	private GetDeliverableTypes getDeliverableTypes;
	@Autowired
	private GetDeliverableType getDeliverableType;
	@Autowired
	private CreateDeliverableType createDeliverableType;

}