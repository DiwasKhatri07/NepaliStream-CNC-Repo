package com.phisher98;

import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.ResponseParser;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: compiled from: StreamPlayExtractor.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Lcom/phisher98/RiveStreamSource;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeRiveStream$sourceList$1", f = "StreamPlayExtractor.kt", i = {}, l = {3065}, m = "invokeSuspend", n = {}, nl = {6276}, s = {}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlayExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor$invokeRiveStream$sourceList$1\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n*L\n1#1,6275:1\n73#2,5:6276\n*S KotlinDebug\n*F\n+ 1 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor$invokeRiveStream$sourceList$1\n*L\n3065#1:6276,5\n*E\n"})
final class StreamPlayExtractor$invokeRiveStream$sourceList$1 extends SuspendLambda implements Function1<Continuation<? super RiveStreamSource>, Object> {
    final /* synthetic */ Map<String, String> $headers;
    final /* synthetic */ String $sourceApiUrl;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreamPlayExtractor$invokeRiveStream$sourceList$1(String str, Map<String, String> map, Continuation<? super StreamPlayExtractor$invokeRiveStream$sourceList$1> continuation) {
        super(1, continuation);
        this.$sourceApiUrl = str;
        this.$headers = map;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new StreamPlayExtractor$invokeRiveStream$sourceList$1(this.$sourceApiUrl, this.$headers, continuation);
    }

    public final Object invoke(Continuation<? super RiveStreamSource> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object objSafeGet$default;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                objSafeGet$default = StreamPlayUtilsKt.safeGet$default(this.$sourceApiUrl, this.$headers, null, null, null, false, 0, (Continuation) this, 124, null);
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
        NiceResponse this_$iv = (NiceResponse) objSafeGet$default;
        try {
            ResponseParser parser = this_$iv.getParser();
            Intrinsics.checkNotNull(parser);
            return parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(RiveStreamSource.class));
        } catch (Exception e$iv) {
            e$iv.printStackTrace();
            return null;
        }
    }
}
