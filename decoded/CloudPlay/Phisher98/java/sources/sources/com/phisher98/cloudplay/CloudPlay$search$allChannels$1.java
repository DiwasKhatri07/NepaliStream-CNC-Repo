package com.phisher98.cloudplay;

import com.lagradost.cloudstream3.SearchResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: CloudPlayProvider.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/CloudPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "stream", "Lcom/phisher98/cloudplay/CloudPlay$CloudPlayStream;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.cloudplay.CloudPlay$search$allChannels$1", f = "CloudPlayProvider.kt", i = {0}, l = {271}, m = "invokeSuspend", n = {"stream"}, nl = {-1}, s = {"L$0"}, v = 2)
final class CloudPlay$search$allChannels$1 extends SuspendLambda implements Function2<CloudPlay.CloudPlayStream, Continuation<? super List<? extends SearchResponse>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CloudPlay this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CloudPlay$search$allChannels$1(CloudPlay cloudPlay, Continuation<? super CloudPlay$search$allChannels$1> continuation) {
        super(2, continuation);
        this.this$0 = cloudPlay;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> cloudPlay$search$allChannels$1 = new CloudPlay$search$allChannels$1(this.this$0, continuation);
        cloudPlay$search$allChannels$1.L$0 = obj;
        return cloudPlay$search$allChannels$1;
    }

    public final Object invoke(CloudPlay.CloudPlayStream cloudPlayStream, Continuation<? super List<? extends SearchResponse>> continuation) {
        return create(cloudPlayStream, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        CloudPlay.CloudPlayStream stream = (CloudPlay.CloudPlayStream) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.L$0 = SpillingKt.nullOutSpilledVariable(stream);
                this.label = 1;
                Object objFetchChannels = this.this$0.fetchChannels(stream.getUrl(), stream.getLogo(), (Continuation) this);
                if (objFetchChannels == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return objFetchChannels;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
