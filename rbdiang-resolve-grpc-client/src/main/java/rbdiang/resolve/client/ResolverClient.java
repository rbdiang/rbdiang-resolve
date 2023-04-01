package rbdiang.resolve.client;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import rbdiang.resolve.gprc.NormalizeRequest;
import rbdiang.resolve.gprc.ResolveServiceGrpc;
import rbdiang.resolve.gprc.ResolveServiceGrpc.ResolveServiceBlockingStub;

import javax.annotation.PreDestroy;

@Slf4j
@Component
public class ResolverClient {

    private final ResolveServiceBlockingStub resolverStub;
    private final ManagedChannel managedChannel;

    public ResolverClient() {
        log.info("Connecting to: 127.0.0.1:6565");
        managedChannel = ManagedChannelBuilder.forTarget("127.0.0.1:6565")
                .usePlaintext()
                .build();
        resolverStub = ResolveServiceGrpc.newBlockingStub(managedChannel);
    }

    public String normalizeAddress(String raw) {
        var normalRequest = NormalizeRequest.newBuilder().setRaw(raw).build();
        var normalResponse = resolverStub.normalize(normalRequest);
        return normalResponse.getNormalized();
    }

    @PreDestroy
    public void shutdown() {
        log.info("Shutting down channel");
        if(managedChannel != null) {
            managedChannel.shutdown();
        }
    }
}
