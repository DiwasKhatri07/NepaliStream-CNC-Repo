package com.phisher98;

import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: XDMoviesSettingsFragment.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/XDMovies/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.XDMoviesSettingsFragment$onCreateView$2$1$isValid$1", f = "XDMoviesSettingsFragment.kt", i = {}, l = {85}, m = "invokeSuspend", n = {}, nl = {89}, s = {}, v = 2)
final class XDMoviesSettingsFragment$onCreateView$2$1$isValid$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    int label;

    XDMoviesSettingsFragment$onCreateView$2$1$isValid$1(Continuation<? super XDMoviesSettingsFragment$onCreateView$2$1$isValid$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new XDMoviesSettingsFragment$onCreateView$2$1$isValid$1(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object obj;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z = false;
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    obj = Requests.get$default(MainActivityKt.getApp(), "https://top.xdmovies.wtf/series/agent-kim-reactivated-1080p-720p-english-korean-download-296206", (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, XDMoviesCFBypassInterceptor.INSTANCE, false, (ResponseParser) null, (Continuation) this, 3582, (Object) null);
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
            NiceResponse resp = (NiceResponse) obj;
            int code = resp.getCode();
            z = 200 <= code && code < 300;
        } catch (Exception e) {
        }
        return Boxing.boxBoolean(z);
    }
}
