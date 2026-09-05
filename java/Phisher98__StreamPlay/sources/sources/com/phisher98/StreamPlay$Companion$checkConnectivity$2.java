package com.phisher98;

import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.Interceptor;

/* JADX INFO: compiled from: StreamPlay.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlay$Companion$checkConnectivity$2", f = "StreamPlay.kt", i = {}, l = {147}, m = "invokeSuspend", n = {}, nl = {152}, s = {}, v = 2)
final class StreamPlay$Companion$checkConnectivity$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $testUrl;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreamPlay$Companion$checkConnectivity$2(String str, Continuation<? super StreamPlay$Companion$checkConnectivity$2> continuation) {
        super(2, continuation);
        this.$testUrl = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StreamPlay$Companion$checkConnectivity$2(this.$testUrl, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object obj;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z = true;
        boolean z2 = false;
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Requests app = MainActivityKt.getApp();
                    Map mapMapOf = MapsKt.mapOf(TuplesKt.to("Cache-Control", "no-cache"));
                    this.label = 1;
                    obj = Requests.get$default(app, this.$testUrl, mapMapOf, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 1500L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 3836, (Object) null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    obj = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            NiceResponse response = (NiceResponse) obj;
            if (response.getCode() != 200 && response.getCode() != 304) {
                z = false;
            }
            z2 = z;
        } catch (Exception e) {
        }
        return Boxing.boxBoolean(z2);
    }
}
