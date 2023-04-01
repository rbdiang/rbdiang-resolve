# rbdiang-resolve

A simple demonstration using grpc and spring boot cache abstraction.

## Running application

1. Start rbdiang-resolve-grpc-hazelcast to start a GrpcServer on localhost listening on default port 6565
2. Start rbdiang-resolve-grpc-rest.
3. Access swagger page at
    http://localhost:8081/swagger-ui/

## Module descriptions

A list of the various modules are below

| Module Name | Description | status |
| ---- | ---- | ---- |
| rbdiang-resolve-backend | Contains backend resolver code common to redis or hazelcast | initial creation |
| rbdiang-resolve-common | Contains resolve.proto and generates the gRPC base ResolveServiceGrpc and client stubs | initial with 1 rpc method, normalize |
| rbdiang-resolve-grpc-cache | Contains the GrpcService that provides implementation for ResolveServiceGrpcImpl  | initial creation |
| rbdiang-resolve-grpc-client | Creates a ResolverClient service connecting the ResolveServiceGrpc.newBlockingStub on standard gRPC port 6565  | initial creation |
| rbdiang-resolve-grpc-hazelcast | Spring boot application running GrpcService listening on port 6565 with a Spring Cache Manager backed by hazelcast  | initial creation, need to add embedded hazelcast |
| rbdiang-resolve-grpc-redis | Spring boot application running GrpcService listening on port 6565 with a Spring Cache Manager backed by redis  | Does not exist yet |
| rbdiang-resolve-grpc-rest | Spring boot application containing swagger-ui listening on port 8081  | Initial implementation |
