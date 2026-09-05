package com.movies4u;

import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.ParCollectionsKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.List;
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
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Movies4u/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/movies4u/Filesdl;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Movies4u"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class Filesdl extends ExtractorApi {

    @NotNull
    private final String name = "Filesdl";

    @NotNull
    private final String mainUrl = "https://new6.filesdl.site";
    private final boolean requiresReferer = true;

    /* JADX INFO: renamed from: com.movies4u.Filesdl$getUrl$1 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.movies4u.Filesdl", f = "Extractor.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {37, 41}, m = "getUrl", n = {"url", "referer", "subtitleCallback", "callback", "url", "referer", "subtitleCallback", "callback", "res", "titleText", "qualityRegex", "quality"}, nl = {38, 81}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"}, v = 2)
    static final class C00011 extends ContinuationImpl {
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

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Filesdl.this.getUrl(null, null, null, null, (Continuation) this);
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

    /* JADX WARN: Code duplicated, block: B:22:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:25:0x013b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:26:0x013c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object getUrl(@NotNull String url, @Nullable String referer, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        C00011 c00011;
        Object obj;
        C00011 c00012;
        String url2;
        String referer2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        MatchResult matchResultFind$default;
        String quality;
        List listSelect;
        C00022 c00022;
        if (continuation instanceof C00011) {
            c00011 = (C00011) continuation;
            if ((c00011.label & Integer.MIN_VALUE) != 0) {
                c00011.label -= Integer.MIN_VALUE;
            } else {
                c00011 = new C00011(continuation);
            }
        } else {
            c00011 = new C00011(continuation);
        }
        Object $result = c00011.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00011.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                c00011.L$0 = SpillingKt.nullOutSpilledVariable(url);
                c00011.L$1 = SpillingKt.nullOutSpilledVariable(referer);
                c00011.L$2 = function1;
                c00011.L$3 = function2;
                c00011.label = 1;
                C00011 c00013 = c00011;
                obj = coroutine_suspended;
                $result = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00013, 4094, (Object) null);
                c00012 = c00013;
                if ($result == obj) {
                    return obj;
                }
                url2 = url;
                referer2 = referer;
                function3 = function1;
                function4 = function2;
                Document res = ((NiceResponse) $result).getDocument();
                String titleText = res.select("div.title").text();
                Regex qualityRegex = new Regex("(\\d{3,4}p)", RegexOption.IGNORE_CASE);
                matchResultFind$default = Regex.find$default(qualityRegex, titleText, 0, 2, (Object) null);
                if (matchResultFind$default != null || (quality = matchResultFind$default.getValue()) == null) {
                    quality = "Unknown";
                }
                listSelect = res.select("div.container a");
                c00022 = new C00022(function3, function4, quality, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(res);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(titleText);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(qualityRegex);
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(quality);
                c00012.label = 2;
                if (ParCollectionsKt.amap(listSelect, c00022, c00012) == obj) {
                    return obj;
                }
                return Unit.INSTANCE;
            case 1:
                function4 = (Function1) c00011.L$3;
                function3 = (Function1) c00011.L$2;
                referer2 = (String) c00011.L$1;
                url2 = (String) c00011.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                c00012 = c00011;
                Document res2 = ((NiceResponse) $result).getDocument();
                String titleText2 = res2.select("div.title").text();
                Regex qualityRegex2 = new Regex("(\\d{3,4}p)", RegexOption.IGNORE_CASE);
                matchResultFind$default = Regex.find$default(qualityRegex2, titleText2, 0, 2, (Object) null);
                if (matchResultFind$default != null) {
                    quality = "Unknown";
                } else {
                    quality = "Unknown";
                }
                listSelect = res2.select("div.container a");
                c00022 = new C00022(function3, function4, quality, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(res2);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(titleText2);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(qualityRegex2);
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(quality);
                c00012.label = 2;
                if (ParCollectionsKt.amap(listSelect, c00022, c00012) == obj) {
                    return obj;
                }
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.movies4u.Filesdl$getUrl$2 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "it", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.movies4u.Filesdl$getUrl$2", f = "Extractor.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5}, l = {46, 48, 50, 53, 56, 69}, m = "invokeSuspend", n = {"it", "source", "href", "it", "source", "href", "it", "source", "href", "it", "source", "href", "it", "source", "href", "response", "redirectUrl", "it", "source", "href"}, nl = {48, 50, 52, 54, 55, 68}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2"}, v = 2)
    static final class C00022 extends SuspendLambda implements Function2<Element, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ String $quality;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00022(Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, String str, Continuation<? super C00022> continuation) {
            super(2, continuation);
            this.$subtitleCallback = function1;
            this.$callback = function2;
            this.$quality = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00022 = new C00022(this.$subtitleCallback, this.$callback, this.$quality, continuation);
            c00022.L$0 = obj;
            return c00022;
        }

        public final Object invoke(Element element, Continuation<? super Unit> continuation) {
            return create(element, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:53:0x01fc  */
        /* JADX WARN: Code duplicated, block: B:56:0x0242 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:57:0x0243  */
        public final Object invokeSuspend(Object $result) {
            Object obj;
            String source;
            String source2;
            Object objNewExtractorLink;
            Function1<ExtractorLink, Unit> function1;
            String source3;
            String source4;
            String href;
            String href2;
            String href3;
            String str;
            Function1<ExtractorLink, Unit> function2;
            Object objNewExtractorLink2;
            Function1<ExtractorLink, Unit> function3;
            String source5;
            String source6;
            Element it = (Element) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String source7 = it.text();
                    String href4 = it.attr("href");
                    if (StringsKt.contains(source7, "Hubcloud", true)) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(source7);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(href4);
                        this.label = 1;
                        if (new HubCloud().getUrl(href4, "Filmyfiy", this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        href3 = href4;
                    } else if (StringsKt.contains(source7, "GDFLIX", true)) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(source7);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(href4);
                        this.label = 2;
                        if (new GDFlix().getUrl(href4, "Filmyfiy", this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        href2 = href4;
                    } else if (StringsKt.contains(source7, "Gofile", true)) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(source7);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(href4);
                        this.label = 3;
                        if (new Gofile().getUrl(href4, "Filmyfiy", this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        href = href4;
                    } else if (StringsKt.contains(source7, "Direct Download", true) || StringsKt.contains(source7, "Ultra FastDL", true) || StringsKt.contains(source7, "Fast Cloud-02", true)) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(source7);
                        this.L$2 = href4;
                        this.label = 4;
                        obj = Requests.get$default(MainActivityKt.getApp(), href4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4062, (Object) null);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        source = source7;
                        source2 = href4;
                        NiceResponse response = (NiceResponse) obj;
                        str = response.getHeaders().get("location");
                        if (str == null) {
                            str = source2;
                        }
                        String redirectUrl = str;
                        function2 = this.$callback;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(source);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(source2);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(response);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(redirectUrl);
                        this.L$5 = function2;
                        this.label = 5;
                        objNewExtractorLink2 = ExtractorApiKt.newExtractorLink("Direct Download", "Filmyfiy [Direct Download]", redirectUrl, ExtractorApiKt.getINFER_TYPE(), new AnonymousClass1(this.$quality, null), (Continuation) this);
                        if (objNewExtractorLink2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function3 = function2;
                        source5 = source;
                        source6 = source2;
                        function3.invoke(objNewExtractorLink2);
                    } else if (StringsKt.contains(source7, "Fast Cloud", true)) {
                        Function1<ExtractorLink, Unit> function4 = this.$callback;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(source7);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(href4);
                        this.L$3 = function4;
                        this.label = 6;
                        objNewExtractorLink = ExtractorApiKt.newExtractorLink("Fast Cloud", "Filmyfiy [Fast Cloud]", href4, ExtractorApiKt.getINFER_TYPE(), new AnonymousClass2(this.$quality, null), (Continuation) this);
                        if (objNewExtractorLink == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function1 = function4;
                        source3 = source7;
                        source4 = href4;
                        function1.invoke(objNewExtractorLink);
                    }
                    return Unit.INSTANCE;
                case 1:
                    href3 = (String) this.L$2;
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                case 2:
                    href2 = (String) this.L$2;
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                case 3:
                    href = (String) this.L$2;
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                case 4:
                    source2 = (String) this.L$2;
                    String source8 = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    source = source8;
                    obj = $result;
                    NiceResponse response2 = (NiceResponse) obj;
                    str = response2.getHeaders().get("location");
                    if (str == null) {
                        str = source2;
                    }
                    String redirectUrl2 = str;
                    function2 = this.$callback;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(source);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(source2);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(response2);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(redirectUrl2);
                    this.L$5 = function2;
                    this.label = 5;
                    objNewExtractorLink2 = ExtractorApiKt.newExtractorLink("Direct Download", "Filmyfiy [Direct Download]", redirectUrl2, ExtractorApiKt.getINFER_TYPE(), new AnonymousClass1(this.$quality, null), (Continuation) this);
                    if (objNewExtractorLink2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function3 = function2;
                    source5 = source;
                    source6 = source2;
                    function3.invoke(objNewExtractorLink2);
                    return Unit.INSTANCE;
                case 5:
                    function3 = (Function1) this.L$5;
                    String href5 = (String) this.L$2;
                    String source9 = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    source5 = source9;
                    source6 = href5;
                    objNewExtractorLink2 = $result;
                    function3.invoke(objNewExtractorLink2);
                    return Unit.INSTANCE;
                case 6:
                    function1 = (Function1) this.L$3;
                    source4 = (String) this.L$2;
                    String source10 = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    source3 = source10;
                    objNewExtractorLink = $result;
                    function1.invoke(objNewExtractorLink);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.movies4u.Filesdl$getUrl$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: Extractor.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.movies4u.Filesdl$getUrl$2$1", f = "Extractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $quality;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$quality = str;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$quality, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
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
                        $this$newExtractorLink.setQuality(ExtractorApiKt.getQualityFromName(this.$quality));
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }

        /* JADX INFO: renamed from: com.movies4u.Filesdl$getUrl$2$2, reason: invalid class name */
        /* JADX INFO: compiled from: Extractor.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.movies4u.Filesdl$getUrl$2$2", f = "Extractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass2 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $quality;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(String str, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$quality = str;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass2 = new AnonymousClass2(this.$quality, continuation);
                anonymousClass2.L$0 = obj;
                return anonymousClass2;
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
                        $this$newExtractorLink.setQuality(ExtractorApiKt.getQualityFromName(this.$quality));
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
    }
}
