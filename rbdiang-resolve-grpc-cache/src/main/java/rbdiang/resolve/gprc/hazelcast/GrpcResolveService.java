package rbdiang.resolve.gprc.hazelcast;

import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import rbdiang.resolve.api.Normalized;
import rbdiang.resolve.gprc.*;
import rbdiang.resolve.service.NormalizeService;

@Slf4j
@AllArgsConstructor
@GrpcService(interceptors = LogInterceptor.class)
@Import({
        NormalizeService.class
})
@Component
public class GrpcResolveService extends ResolveServiceGrpc.ResolveServiceImplBase {

    private NormalizeService normalizeService;
    @Override
    public void resolveGroup(GroupRequest request, StreamObserver<GroupResponse> responseObserver) {
        super.resolveGroup(request, responseObserver);
    }

    @Override
    public void normalize(NormalizeRequest request, StreamObserver<NormalizeResponse> responseObserver) {
        Normalized normalResult = normalizeService.normalize(request.getRaw());
        responseObserver.onNext(
        NormalizeResponse.newBuilder()
                .setRaw(normalResult.getRaw())
                .setNormalized(normalResult.getNormalized())
                .build());
        responseObserver.onCompleted();
        log.info("returning: {}", normalResult);
    }
}
