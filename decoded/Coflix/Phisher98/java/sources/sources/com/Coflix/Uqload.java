package com.Coflix;

import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
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
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Coflix/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/Coflix/Uqload;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Coflix"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class Uqload extends ExtractorApi {
    private final boolean requiresReferer;

    @NotNull
    private final String name = "Uqload";

    @NotNull
    private final String mainUrl = "https://uqload.cx";

    /* JADX INFO: renamed from: com.Coflix.Uqload$getUrl$1 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Coflix.Uqload", f = "Extractor.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {299, 304}, m = "getUrl", n = {"url", "referer", "subtitleCallback", "callback", "url", "referer", "subtitleCallback", "callback", "html", "srcRegex", "videoUrl"}, nl = {300, 303}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"}, v = 2)
    static final class C00081 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        C00081(Continuation<? super C00081> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Uqload.this.getUrl(null, null, null, null, (Continuation) this);
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

    /* JADX WARN: Code duplicated, block: B:23:0x0102  */
    /* JADX WARN: Code duplicated, block: B:25:0x0107  */
    /* JADX WARN: Code duplicated, block: B:27:0x0154 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:28:0x0155  */
    /* JADX WARN: Code duplicated, block: B:30:0x0168  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object getUrl(@NotNull String url, @Nullable String referer, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        C00081 c00081;
        Object obj;
        int i;
        Object obj2;
        String url2;
        String referer2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        String html;
        Regex srcRegex;
        MatchResult matchResultFind$default;
        String videoUrl;
        String videoUrl2;
        String url3;
        Function1<? super SubtitleFile, Unit> function5;
        String videoUrl3;
        Function1<? super ExtractorLink, Unit> function6;
        Function1<? super ExtractorLink, Unit> function7;
        String html2;
        Regex srcRegex2;
        List groupValues;
        if (continuation instanceof C00081) {
            c00081 = (C00081) continuation;
            if ((c00081.label & Integer.MIN_VALUE) != 0) {
                c00081.label -= Integer.MIN_VALUE;
            } else {
                c00081 = new C00081(continuation);
            }
        } else {
            c00081 = new C00081(continuation);
        }
        C00081 c00082 = c00081;
        Object $result = c00082.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00082.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                Map mapMapOf = MapsKt.mapOf(TuplesKt.to("User-Agent", "Mozilla/5.0"));
                c00082.L$0 = SpillingKt.nullOutSpilledVariable(url);
                c00082.L$1 = referer;
                c00082.L$2 = SpillingKt.nullOutSpilledVariable(function1);
                c00082.L$3 = function2;
                c00082.label = 1;
                obj = coroutine_suspended;
                i = 1;
                obj2 = Requests.get$default(app, url, mapMapOf, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00082, 4092, (Object) null);
                c00082 = c00082;
                if (obj2 == obj) {
                    return obj;
                }
                url2 = url;
                referer2 = referer;
                function3 = function1;
                function4 = function2;
                html = ((NiceResponse) obj2).getText();
                srcRegex = new Regex("sources\\s*:\\s*\\[\\s*[\"']([^\"']+)[\"']");
                matchResultFind$default = Regex.find$default(srcRegex, html, 0, 2, (Object) null);
                if (matchResultFind$default != null || (groupValues = matchResultFind$default.getGroupValues()) == null) {
                    videoUrl = null;
                } else {
                    videoUrl = (String) groupValues.get(i);
                }
                if (videoUrl != null) {
                    String name = getName();
                    String name2 = getName();
                    ExtractorLinkType infer_type = ExtractorApiKt.getINFER_TYPE();
                    C00092 c00092 = new C00092(referer2, this, null);
                    c00082.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c00082.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                    c00082.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                    c00082.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                    c00082.L$4 = SpillingKt.nullOutSpilledVariable(html);
                    c00082.L$5 = SpillingKt.nullOutSpilledVariable(srcRegex);
                    c00082.L$6 = SpillingKt.nullOutSpilledVariable(videoUrl);
                    c00082.L$7 = function4;
                    c00082.label = 2;
                    videoUrl2 = videoUrl;
                    $result = ExtractorApiKt.newExtractorLink(name, name2, videoUrl2, infer_type, c00092, c00082);
                    if ($result == obj) {
                        return obj;
                    }
                    Function1<? super SubtitleFile, Unit> function8 = function3;
                    url3 = url2;
                    function5 = function8;
                    videoUrl3 = videoUrl2;
                    function6 = function4;
                    function7 = function6;
                    html2 = html;
                    srcRegex2 = srcRegex;
                    function6.invoke($result);
                }
                return Unit.INSTANCE;
            case 1:
                Function1<? super ExtractorLink, Unit> function9 = (Function1) c00082.L$3;
                Function1<? super SubtitleFile, Unit> function10 = (Function1) c00082.L$2;
                String referer3 = (String) c00082.L$1;
                url2 = (String) c00082.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                function4 = function9;
                function3 = function10;
                referer2 = referer3;
                obj2 = $result;
                i = 1;
                html = ((NiceResponse) obj2).getText();
                srcRegex = new Regex("sources\\s*:\\s*\\[\\s*[\"']([^\"']+)[\"']");
                matchResultFind$default = Regex.find$default(srcRegex, html, 0, 2, (Object) null);
                if (matchResultFind$default != null) {
                    videoUrl = null;
                } else {
                    videoUrl = null;
                }
                if (videoUrl != null) {
                    String name3 = getName();
                    String name4 = getName();
                    ExtractorLinkType infer_type2 = ExtractorApiKt.getINFER_TYPE();
                    C00092 c00093 = new C00092(referer2, this, null);
                    c00082.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c00082.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                    c00082.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                    c00082.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                    c00082.L$4 = SpillingKt.nullOutSpilledVariable(html);
                    c00082.L$5 = SpillingKt.nullOutSpilledVariable(srcRegex);
                    c00082.L$6 = SpillingKt.nullOutSpilledVariable(videoUrl);
                    c00082.L$7 = function4;
                    c00082.label = 2;
                    videoUrl2 = videoUrl;
                    $result = ExtractorApiKt.newExtractorLink(name3, name4, videoUrl2, infer_type2, c00093, c00082);
                    if ($result == obj) {
                        return obj;
                    }
                    Function1<? super SubtitleFile, Unit> function11 = function3;
                    url3 = url2;
                    function5 = function11;
                    videoUrl3 = videoUrl2;
                    function6 = function4;
                    function7 = function6;
                    html2 = html;
                    srcRegex2 = srcRegex;
                    function6.invoke($result);
                }
                return Unit.INSTANCE;
            case 2:
                function6 = (Function1) c00082.L$7;
                videoUrl3 = (String) c00082.L$6;
                srcRegex2 = (Regex) c00082.L$5;
                html2 = (String) c00082.L$4;
                function7 = (Function1) c00082.L$3;
                function5 = (Function1) c00082.L$2;
                url3 = (String) c00082.L$0;
                ResultKt.throwOnFailure($result);
                function6.invoke($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.Coflix.Uqload$getUrl$2 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Coflix.Uqload$getUrl$2", f = "Extractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00092 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $referer;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ Uqload this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00092(String str, Uqload uqload, Continuation<? super C00092> continuation) {
            super(2, continuation);
            this.$referer = str;
            this.this$0 = uqload;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00092 = new C00092(this.$referer, this.this$0, continuation);
            c00092.L$0 = obj;
            return c00092;
        }

        public final Object invoke(ExtractorLink extractorLink, Continuation<? super Unit> continuation) {
            return create(extractorLink, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            ExtractorLink $this$newExtractorLink = (ExtractorLink) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String mainUrl = this.$referer;
                    if (mainUrl == null) {
                        mainUrl = this.this$0.getMainUrl();
                    }
                    $this$newExtractorLink.setReferer(mainUrl);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
