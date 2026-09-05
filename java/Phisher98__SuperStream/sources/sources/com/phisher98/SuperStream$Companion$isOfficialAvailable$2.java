package com.phisher98;

import com.lagradost.api.Log;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.Interceptor;

/* JADX INFO: compiled from: SuperStream.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/SuperStream/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.SuperStream$Companion$isOfficialAvailable$2", f = "SuperStream.kt", i = {0}, l = {97}, m = "invokeSuspend", n = {"testUrl"}, nl = {105}, s = {"L$0"}, v = 2)
final class SuperStream$Companion$isOfficialAvailable$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    Object L$0;
    int label;

    SuperStream$Companion$isOfficialAvailable$2(Continuation<? super SuperStream$Companion$isOfficialAvailable$2> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SuperStream$Companion$isOfficialAvailable$2(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object obj;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean zContains = false;
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Requests app = MainActivityKt.getApp();
                    Pair[] pairArr = {TuplesKt.to("Cache-Control", "no-cache"), TuplesKt.to("Pragma", "no-cache")};
                    this.L$0 = SpillingKt.nullOutSpilledVariable("https://api.themoviedb.org/3/configuration?api_key=98ae14df2b8d8f8f8136499daf79f0e0");
                    this.label = 1;
                    obj = Requests.get$default(app, "https://api.themoviedb.org/3/configuration?api_key=98ae14df2b8d8f8f8136499daf79f0e0", MapsKt.mapOf(pairArr), (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 1000L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 3836, (Object) null);
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
            zContains = CollectionsKt.listOf(new Integer[]{Boxing.boxInt(200), Boxing.boxInt(304)}).contains(Boxing.boxInt(response.getOkhttpResponse().code()));
        } catch (Exception e) {
            Log.INSTANCE.d("Error", "Official TMDB unavailable: " + e.getMessage());
        }
        return Boxing.boxBoolean(zContains);
    }
}
