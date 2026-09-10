package com.phisher98;

import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.Interceptor;

/* JADX INFO: compiled from: Reanime.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Reanime/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.Reanime$getVideoInterceptor$1$keyBytes$1", f = "Reanime.kt", i = {0, 0}, l = {590}, m = "invokeSuspend", n = {"$this$runBlocking", "$this$invokeSuspend_u24lambda_u240"}, nl = {596}, s = {"L$0", "L$2"}, v = 2)
final class Reanime$getVideoInterceptor$1$keyBytes$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super byte[]>, Object> {
    final /* synthetic */ String $targetKeyUrl;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Reanime$getVideoInterceptor$1$keyBytes$1(String str, Continuation<? super Reanime$getVideoInterceptor$1$keyBytes$1> continuation) {
        super(2, continuation);
        this.$targetKeyUrl = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> reanime$getVideoInterceptor$1$keyBytes$1 = new Reanime$getVideoInterceptor$1$keyBytes$1(this.$targetKeyUrl, continuation);
        reanime$getVideoInterceptor$1$keyBytes$1.L$0 = obj;
        return reanime$getVideoInterceptor$1$keyBytes$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super byte[]> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object obj;
        Object obj2;
        String str;
        CoroutineScope $this$runBlocking = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String str2 = this.$targetKeyUrl;
                    Result.Companion companion = Result.Companion;
                    Requests app = MainActivityKt.getApp();
                    Map mapMapOf = MapsKt.mapOf(new Pair[]{TuplesKt.to("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/137.0.0.0 Safari/537.36"), TuplesKt.to("Referer", "https://flixcloud.cc/")});
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$runBlocking);
                    this.L$1 = str2;
                    this.L$2 = SpillingKt.nullOutSpilledVariable($this$runBlocking);
                    this.label = 1;
                    obj2 = Requests.get$default(app, str2, mapMapOf, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, this, 4092, (Object) null);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str = str2;
                    break;
                case 1:
                    str = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    obj2 = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            byte[] bytes = ((NiceResponse) obj2).getBody().bytes();
            if (!(bytes.length == 0)) {
                Reanime.flixKeyCache.put(str, bytes);
            }
            obj = Result.constructor-impl(bytes);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            return null;
        }
        return obj;
    }
}
