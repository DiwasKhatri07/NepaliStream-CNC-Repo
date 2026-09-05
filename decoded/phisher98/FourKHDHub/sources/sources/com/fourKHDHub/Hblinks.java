package com.fourKHDHub;

import com.lagradost.api.Log;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.ParCollectionsKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.Qualities;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/FourKHDHub/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/fourKHDHub/Hblinks;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "FourKHDHub"}, k = 1, mv = {2, 4, 0}, xi = 48)
public class Hblinks extends ExtractorApi {

    @NotNull
    private final String name = "Hblinks";

    @NotNull
    private final String mainUrl = "https://hblinks.*";
    private final boolean requiresReferer = true;

    /* JADX INFO: renamed from: com.fourKHDHub.Hblinks$getUrl$1 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.fourKHDHub.Hblinks", f = "Extractor.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {48, 55}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "subtitleCallback", "callback", "$this$getUrl_u24lambda_u240", "$this", "url", "referer", "subtitleCallback", "callback", "elements"}, nl = {49, 79}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
    static final class C00101 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C00101(Continuation<? super C00101> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Hblinks.getUrl$suspendImpl(Hblinks.this, null, null, null, null, (Continuation) this);
        }
    }

    @Nullable
    public Object getUrl(@NotNull String str, @Nullable String str2, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        return getUrl$suspendImpl(this, str, str2, function1, function2, continuation);
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

    /* JADX WARN: Code duplicated, block: B:37:0x012f  */
    /* JADX WARN: Code duplicated, block: B:39:0x016a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:40:0x016b  */
    /* JADX WARN: Code duplicated, block: B:43:0x016f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    static /* synthetic */ Object getUrl$suspendImpl(Hblinks $this, String url, String referer, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super Unit> continuation) {
        C00101 c00101;
        Object obj;
        C00101 c00102;
        Hblinks $this2;
        String url2;
        String referer2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        Object obj2;
        Object obj3;
        Function1<? super ExtractorLink, Unit> function5;
        Function1<? super SubtitleFile, Unit> function6;
        String referer3;
        String url3;
        Throwable it;
        List list;
        C00112 c00112;
        if (continuation instanceof C00101) {
            c00101 = (C00101) continuation;
            if ((c00101.label & Integer.MIN_VALUE) != 0) {
                c00101.label -= Integer.MIN_VALUE;
            } else {
                c00101 = $this.new C00101(continuation);
            }
        } else {
            c00101 = $this.new C00101(continuation);
        }
        C00101 c00103 = c00101;
        Object $result = c00103.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00103.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                try {
                    Result.Companion companion = Result.Companion;
                    Requests app = MainActivityKt.getApp();
                    c00103.L$0 = $this;
                    c00103.L$1 = SpillingKt.nullOutSpilledVariable(url);
                    c00103.L$2 = SpillingKt.nullOutSpilledVariable(referer);
                    c00103.L$3 = function1;
                    c00103.L$4 = function2;
                    c00103.L$5 = SpillingKt.nullOutSpilledVariable($this);
                    c00103.label = 1;
                    obj = coroutine_suspended;
                    try {
                        Object obj4 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00103, 4094, (Object) null);
                        c00102 = c00103;
                        if (obj4 == obj) {
                            return obj;
                        }
                        url2 = url;
                        referer2 = referer;
                        function3 = function1;
                        function4 = function2;
                        obj2 = obj4;
                        $this2 = $this;
                        try {
                            obj3 = Result.constructor-impl(((NiceResponse) obj2).getDocument().select("h3 a, h5 a, div.entry-content p a"));
                            break;
                        } catch (Throwable th) {
                            th = th;
                            Result.Companion companion2 = Result.Companion;
                            obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        function5 = function4;
                        function6 = function3;
                        referer3 = referer2;
                        url3 = url2;
                        it = Result.exceptionOrNull-impl(obj3);
                        if (it == null) {
                            Log.INSTANCE.e($this2.getName(), "Failed to load page: " + it.getMessage());
                            return Unit.INSTANCE;
                        }
                        list = (Elements) obj3;
                        c00112 = $this2.new C00112(function6, function5, null);
                        c00102.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                        c00102.L$1 = SpillingKt.nullOutSpilledVariable(url3);
                        c00102.L$2 = SpillingKt.nullOutSpilledVariable(referer3);
                        c00102.L$3 = SpillingKt.nullOutSpilledVariable(function6);
                        c00102.L$4 = SpillingKt.nullOutSpilledVariable(function5);
                        c00102.L$5 = SpillingKt.nullOutSpilledVariable(list);
                        c00102.label = 2;
                        if (ParCollectionsKt.amap(list, c00112, c00102) == obj) {
                            return obj;
                        }
                        return Unit.INSTANCE;
                    } catch (Throwable th2) {
                        th = th2;
                        c00102 = c00103;
                        $this2 = $this;
                        url2 = url;
                        referer2 = referer;
                        function3 = function1;
                        function4 = function2;
                        Result.Companion companion3 = Result.Companion;
                        obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                        function5 = function4;
                        function6 = function3;
                        referer3 = referer2;
                        url3 = url2;
                        it = Result.exceptionOrNull-impl(obj3);
                        if (it == null) {
                            Log.INSTANCE.e($this2.getName(), "Failed to load page: " + it.getMessage());
                            return Unit.INSTANCE;
                        }
                        list = (Elements) obj3;
                        c00112 = $this2.new C00112(function6, function5, null);
                        c00102.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                        c00102.L$1 = SpillingKt.nullOutSpilledVariable(url3);
                        c00102.L$2 = SpillingKt.nullOutSpilledVariable(referer3);
                        c00102.L$3 = SpillingKt.nullOutSpilledVariable(function6);
                        c00102.L$4 = SpillingKt.nullOutSpilledVariable(function5);
                        c00102.L$5 = SpillingKt.nullOutSpilledVariable(list);
                        c00102.label = 2;
                        if (ParCollectionsKt.amap(list, c00112, c00102) == obj) {
                            return obj;
                        }
                        return Unit.INSTANCE;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    obj = coroutine_suspended;
                    c00102 = c00103;
                    $this2 = $this;
                    url2 = url;
                    referer2 = referer;
                    function3 = function1;
                    function4 = function2;
                }
                break;
            case 1:
                function4 = (Function1) c00103.L$4;
                function3 = (Function1) c00103.L$3;
                referer2 = (String) c00103.L$2;
                url2 = (String) c00103.L$1;
                Hblinks $this3 = (Hblinks) c00103.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    c00102 = c00103;
                    $this2 = $this3;
                    obj = coroutine_suspended;
                    obj2 = $result;
                    obj3 = Result.constructor-impl(((NiceResponse) obj2).getDocument().select("h3 a, h5 a, div.entry-content p a"));
                    break;
                } catch (Throwable th4) {
                    th = th4;
                    c00102 = c00103;
                    $this2 = $this3;
                    obj = coroutine_suspended;
                    Result.Companion companion4 = Result.Companion;
                    obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                    function5 = function4;
                    function6 = function3;
                    referer3 = referer2;
                    url3 = url2;
                    it = Result.exceptionOrNull-impl(obj3);
                    if (it == null) {
                        Log.INSTANCE.e($this2.getName(), "Failed to load page: " + it.getMessage());
                        return Unit.INSTANCE;
                    }
                    list = (Elements) obj3;
                    c00112 = $this2.new C00112(function6, function5, null);
                    c00102.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                    c00102.L$1 = SpillingKt.nullOutSpilledVariable(url3);
                    c00102.L$2 = SpillingKt.nullOutSpilledVariable(referer3);
                    c00102.L$3 = SpillingKt.nullOutSpilledVariable(function6);
                    c00102.L$4 = SpillingKt.nullOutSpilledVariable(function5);
                    c00102.L$5 = SpillingKt.nullOutSpilledVariable(list);
                    c00102.label = 2;
                    if (ParCollectionsKt.amap(list, c00112, c00102) == obj) {
                        return obj;
                    }
                    return Unit.INSTANCE;
                }
                function5 = function4;
                function6 = function3;
                referer3 = referer2;
                url3 = url2;
                it = Result.exceptionOrNull-impl(obj3);
                if (it == null) {
                    Log.INSTANCE.e($this2.getName(), "Failed to load page: " + it.getMessage());
                    return Unit.INSTANCE;
                }
                list = (Elements) obj3;
                c00112 = $this2.new C00112(function6, function5, null);
                c00102.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                c00102.L$1 = SpillingKt.nullOutSpilledVariable(url3);
                c00102.L$2 = SpillingKt.nullOutSpilledVariable(referer3);
                c00102.L$3 = SpillingKt.nullOutSpilledVariable(function6);
                c00102.L$4 = SpillingKt.nullOutSpilledVariable(function5);
                c00102.L$5 = SpillingKt.nullOutSpilledVariable(list);
                c00102.label = 2;
                if (ParCollectionsKt.amap(list, c00112, c00102) == obj) {
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

    /* JADX INFO: renamed from: com.fourKHDHub.Hblinks$getUrl$2 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "el", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.fourKHDHub.Hblinks$getUrl$2", f = "Extractor.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3}, l = {65, 66, 67, 69}, m = "invokeSuspend", n = {"el", "href", "lower", "el", "href", "lower", "el", "href", "lower", "el", "href", "lower"}, nl = {66, 67, 69, 78}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"}, v = 2)
    @SourceDebugExtension({"SMAP\nExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractor.kt\ncom/fourKHDHub/Hblinks$getUrl$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,457:1\n1#2:458\n*E\n"})
    static final class C00112 extends SuspendLambda implements Function2<Element, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00112(Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00112> continuation) {
            super(2, continuation);
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00112 = Hblinks.this.new C00112(this.$subtitleCallback, this.$callback, continuation);
            c00112.L$0 = obj;
            return c00112;
        }

        public final Object invoke(Element element, Continuation<? super Unit> continuation) {
            return create(element, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Element el = (Element) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String strAbsUrl = el.absUrl("href");
                    if (StringsKt.isBlank(strAbsUrl)) {
                        strAbsUrl = el.attr("href");
                    }
                    String href = StringsKt.trim(strAbsUrl).toString();
                    if (href.length() == 0) {
                        return Unit.INSTANCE;
                    }
                    String lower = href.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lower, "toLowerCase(...)");
                    if (StringsKt.contains$default(lower, "hubdrive", false, 2, (Object) null)) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(el);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(href);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(lower);
                        this.label = 1;
                        if (new Hubdrive().getUrl(href, Hblinks.this.getName(), this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (StringsKt.contains$default(lower, "hubcloud", false, 2, (Object) null)) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(el);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(href);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(lower);
                        this.label = 2;
                        if (new HubCloud().getUrl(href, Hblinks.this.getName(), this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (!StringsKt.contains$default(lower, "hubcdn", false, 2, (Object) null)) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(el);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(href);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(lower);
                        this.label = 4;
                        if (UtilsKt.loadSourceNameExtractor(Hblinks.this.getName(), href, "", Boxing.boxInt(Qualities.Unknown.getValue()), this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(el);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(href);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(lower);
                        this.label = 3;
                        if (new HUBCDN().getUrl(href, Hblinks.this.getName(), this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                case 2:
                    ResultKt.throwOnFailure($result);
                    break;
                case 3:
                    ResultKt.throwOnFailure($result);
                    break;
                case 4:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }
}
