package com.phisher98;

import com.lagradost.nicehttp.NiceResponse;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import org.jsoup.nodes.Document;

/* JADX INFO: compiled from: StreamPlayExtractor.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lorg/jsoup/nodes/Document;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeRiveStream$document$1", f = "StreamPlayExtractor.kt", i = {}, l = {3068}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
final class StreamPlayExtractor$invokeRiveStream$document$1 extends SuspendLambda implements Function1<Continuation<? super Document>, Object> {
    final /* synthetic */ Map<String, String> $headers;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreamPlayExtractor$invokeRiveStream$document$1(Map<String, String> map, Continuation<? super StreamPlayExtractor$invokeRiveStream$document$1> continuation) {
        super(1, continuation);
        this.$headers = map;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new StreamPlayExtractor$invokeRiveStream$document$1(this.$headers, continuation);
    }

    public final Object invoke(Continuation<? super Document> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object objSafeGet$default;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                objSafeGet$default = StreamPlayUtilsKt.safeGet$default(StreamPlay.RiveStreamAPI, this.$headers, null, Boxing.boxLong(20L), null, false, 0, (Continuation) this, 116, null);
                if (objSafeGet$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                objSafeGet$default = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return ((NiceResponse) objSafeGet$default).getDocument();
    }
}
