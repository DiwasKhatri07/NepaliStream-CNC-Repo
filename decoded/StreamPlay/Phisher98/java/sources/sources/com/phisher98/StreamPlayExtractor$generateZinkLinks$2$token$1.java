package com.phisher98;

import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.Interceptor;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: StreamPlayExtractor.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayExtractor$generateZinkLinks$2$token$1", f = "StreamPlayExtractor.kt", i = {}, l = {5538}, m = "invokeSuspend", n = {}, nl = {5546}, s = {}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlayExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor$generateZinkLinks$2$token$1\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n*L\n1#1,6275:1\n73#2,5:6276\n*S KotlinDebug\n*F\n+ 1 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor$generateZinkLinks$2$token$1\n*L\n5546#1:6276,5\n*E\n"})
final class StreamPlayExtractor$generateZinkLinks$2$token$1 extends SuspendLambda implements Function1<Continuation<? super String>, Object> {
    final /* synthetic */ String $ajaxEndpoint;
    final /* synthetic */ String $randomId;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreamPlayExtractor$generateZinkLinks$2$token$1(String str, String str2, Continuation<? super StreamPlayExtractor$generateZinkLinks$2$token$1> continuation) {
        super(1, continuation);
        this.$ajaxEndpoint = str;
        this.$randomId = str2;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new StreamPlayExtractor$generateZinkLinks$2$token$1(this.$ajaxEndpoint, this.$randomId, continuation);
    }

    public final Object invoke(Continuation<? super String> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object objPost$default;
        Object safe;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                String str = this.$ajaxEndpoint + "?random_id=" + this.$randomId;
                Map mapMapOf = MapsKt.mapOf(TuplesKt.to("random_id", this.$randomId));
                this.label = 1;
                objPost$default = Requests.post$default(app, str, MapsKt.mapOf(TuplesKt.to("X-Requested-With", "XMLHttpRequest")), (String) null, (Map) null, (Map) null, mapMapOf, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 65500, (Object) null);
                if (objPost$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                objPost$default = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse this_$iv = (NiceResponse) objPost$default;
        try {
            ResponseParser parser = this_$iv.getParser();
            Intrinsics.checkNotNull(parser);
            safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(ZinkTokenResponse.class));
        } catch (Exception e$iv) {
            e$iv.printStackTrace();
            safe = null;
        }
        ZinkTokenResponse zinkTokenResponse = (ZinkTokenResponse) safe;
        if (zinkTokenResponse != null) {
            return zinkTokenResponse.getToken();
        }
        return null;
    }
}
