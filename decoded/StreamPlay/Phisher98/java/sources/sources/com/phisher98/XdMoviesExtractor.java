package com.phisher98;

import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/phisher98/XdMoviesExtractor;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class XdMoviesExtractor extends ExtractorApi {
    private final boolean requiresReferer;

    @NotNull
    private final String name = "XdMoviesExtractor";

    @NotNull
    private final String mainUrl = "https://link.xdmovies.wtf";

    /* JADX INFO: renamed from: com.phisher98.XdMoviesExtractor$getUrl$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.XdMoviesExtractor", f = "Extractors.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {2499, 2500}, m = "getUrl", n = {"url", "referer", "subtitleCallback", "callback", "url", "referer", "subtitleCallback", "callback", "redirect"}, nl = {2500, 2501}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4"}, v = 2)
    static final class C03131 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C03131(Continuation<? super C03131> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return XdMoviesExtractor.this.getUrl(null, null, null, null, (Continuation) this);
        }
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    public boolean getRequiresReferer() {
        return this.requiresReferer;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0082  */
    /* JADX WARN: Code duplicated, block: B:21:0x0085  */
    /* JADX WARN: Code duplicated, block: B:23:0x00ae A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x00af  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Nullable
    public Object getUrl(@NotNull String url, @Nullable String referer, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) throws Throwable {
        C03131 c03131;
        Object objBypassXD;
        String redirect;
        if (continuation instanceof C03131) {
            c03131 = (C03131) continuation;
            if ((c03131.label & Integer.MIN_VALUE) != 0) {
                c03131.label -= Integer.MIN_VALUE;
            } else {
                c03131 = new C03131(continuation);
            }
        } else {
            c03131 = new C03131(continuation);
        }
        Object $result = c03131.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c03131.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                c03131.L$0 = SpillingKt.nullOutSpilledVariable(url);
                c03131.L$1 = SpillingKt.nullOutSpilledVariable(referer);
                c03131.L$2 = function1;
                c03131.L$3 = function2;
                c03131.label = 1;
                objBypassXD = StreamPlayUtilsKt.bypassXD(url, c03131);
                if (objBypassXD == coroutine_suspended) {
                    return coroutine_suspended;
                }
                redirect = (String) objBypassXD;
                if (redirect == null) {
                    return Unit.INSTANCE;
                }
                c03131.L$0 = SpillingKt.nullOutSpilledVariable(url);
                c03131.L$1 = SpillingKt.nullOutSpilledVariable(referer);
                c03131.L$2 = SpillingKt.nullOutSpilledVariable(function1);
                c03131.L$3 = SpillingKt.nullOutSpilledVariable(function2);
                c03131.L$4 = SpillingKt.nullOutSpilledVariable(redirect);
                c03131.label = 2;
                if (ExtractorApiKt.loadExtractor(redirect, "HubCloud", function1, function2, c03131) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                function2 = (Function1) c03131.L$3;
                function1 = (Function1) c03131.L$2;
                referer = (String) c03131.L$1;
                url = (String) c03131.L$0;
                ResultKt.throwOnFailure($result);
                objBypassXD = $result;
                redirect = (String) objBypassXD;
                if (redirect == null) {
                    return Unit.INSTANCE;
                }
                c03131.L$0 = SpillingKt.nullOutSpilledVariable(url);
                c03131.L$1 = SpillingKt.nullOutSpilledVariable(referer);
                c03131.L$2 = SpillingKt.nullOutSpilledVariable(function1);
                c03131.L$3 = SpillingKt.nullOutSpilledVariable(function2);
                c03131.L$4 = SpillingKt.nullOutSpilledVariable(redirect);
                c03131.label = 2;
                if (ExtractorApiKt.loadExtractor(redirect, "HubCloud", function1, function2, c03131) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
