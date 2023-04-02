package rbdiang.resolve.client;

import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;
import rbdiang.resolve.gprc.NormalizeRequest;
import rbdiang.resolve.gprc.ResolveServiceGrpc.ResolveServiceBlockingStub;

@Slf4j
@Service
public class ResolverClient {

    @GrpcClient("rbdiang-resolve-grpc-server")
    private ResolveServiceBlockingStub resolverStub;

    public String normalizeAddress(String raw) {
        var normalRequest = NormalizeRequest.newBuilder().setRaw(raw).build();
        var normalResponse = resolverStub.normalize(normalRequest);
        return normalResponse.getNormalized();
    }

}
