package com.hdhub4u;

import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
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
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/HDhub4u/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/hdhub4u/Hubdrive;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "HDhub4u"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class Hubdrive extends ExtractorApi {
    private final boolean requiresReferer;

    @NotNull
    private final String name = "Hubdrive";

    @NotNull
    private final String mainUrl = "https://hubdrive.space";

    /* JADX INFO: renamed from: com.hdhub4u.Hubdrive$getUrl$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.hdhub4u.Hubdrive", f = "Extractors.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {204, 205, 206}, m = "getUrl", n = {"url", "referer", "subtitleCallback", "callback", "url", "referer", "subtitleCallback", "callback", "href", "url", "referer", "subtitleCallback", "callback", "href"}, nl = {205, 207, 207}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"}, v = 2)
    static final class C00151 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C00151(Continuation<? super C00151> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Hubdrive.this.getUrl(null, null, null, null, (Continuation) this);
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

    /* JADX WARN: Code duplicated, block: B:21:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:23:0x012b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x012c  */
    /* JADX WARN: Code duplicated, block: B:26:0x0132  */
    /* JADX WARN: Code duplicated, block: B:28:0x015b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:29:0x015c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object getUrl(@NotNull String url, @Nullable String referer, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        C00151 c00151;
        Object obj;
        boolean z;
        Object obj2;
        String url2;
        String referer2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        String href;
        if (continuation instanceof C00151) {
            c00151 = (C00151) continuation;
            if ((c00151.label & Integer.MIN_VALUE) != 0) {
                c00151.label -= Integer.MIN_VALUE;
            } else {
                c00151 = new C00151(continuation);
            }
        } else {
            c00151 = new C00151(continuation);
        }
        C00151 c00152 = c00151;
        Object $result = c00152.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00152.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                c00152.L$0 = SpillingKt.nullOutSpilledVariable(url);
                c00152.L$1 = SpillingKt.nullOutSpilledVariable(referer);
                c00152.L$2 = function1;
                c00152.L$3 = function2;
                c00152.label = 1;
                obj = coroutine_suspended;
                z = true;
                obj2 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 5000L, (Interceptor) null, false, (ResponseParser) null, c00152, 3838, (Object) null);
                c00152 = c00152;
                if (obj2 == obj) {
                    return obj;
                }
                url2 = url;
                referer2 = referer;
                function3 = function1;
                function4 = function2;
                href = ((NiceResponse) obj2).getDocument().select(".btn.btn-primary.btn-user.btn-success1.m-1").attr("href");
                if (StringsKt.contains(href, "hubcloud", z)) {
                    c00152.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c00152.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                    c00152.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                    c00152.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                    c00152.L$4 = SpillingKt.nullOutSpilledVariable(href);
                    c00152.label = 3;
                    if (ExtractorApiKt.loadExtractor(href, "HubDrive", function3, function4, c00152) == obj) {
                        return obj;
                    }
                    return Unit.INSTANCE;
                }
                HubCloud hubCloud = new HubCloud();
                c00152.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00152.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                c00152.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                c00152.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                c00152.L$4 = SpillingKt.nullOutSpilledVariable(href);
                c00152.label = 2;
                $result = hubCloud.getUrl(href, "HubDrive", function3, function4, c00152);
                if ($result == obj) {
                    return obj;
                }
                return $result;
            case 1:
                Function1<? super ExtractorLink, Unit> function5 = (Function1) c00152.L$3;
                function3 = (Function1) c00152.L$2;
                String referer3 = (String) c00152.L$1;
                url2 = (String) c00152.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                referer2 = referer3;
                obj2 = $result;
                function4 = function5;
                z = true;
                href = ((NiceResponse) obj2).getDocument().select(".btn.btn-primary.btn-user.btn-success1.m-1").attr("href");
                if (StringsKt.contains(href, "hubcloud", z)) {
                    c00152.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c00152.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                    c00152.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                    c00152.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                    c00152.L$4 = SpillingKt.nullOutSpilledVariable(href);
                    c00152.label = 3;
                    if (ExtractorApiKt.loadExtractor(href, "HubDrive", function3, function4, c00152) == obj) {
                        return obj;
                    }
                    return Unit.INSTANCE;
                }
                HubCloud hubCloud2 = new HubCloud();
                c00152.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00152.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                c00152.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                c00152.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                c00152.L$4 = SpillingKt.nullOutSpilledVariable(href);
                c00152.label = 2;
                $result = hubCloud2.getUrl(href, "HubDrive", function3, function4, c00152);
                if ($result == obj) {
                    return obj;
                }
                return $result;
            case 2:
                ResultKt.throwOnFailure($result);
                return $result;
            case 3:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
