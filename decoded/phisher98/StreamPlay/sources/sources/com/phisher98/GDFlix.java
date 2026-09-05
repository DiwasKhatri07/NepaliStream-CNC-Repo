package com.phisher98;

import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.ParCollectionsKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.Qualities;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017J\u0016\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u001aJ\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/phisher98/GDFlix;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLatestBaseUrl", "baseUrl", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIndexQuality", "", "str", "getBaseUrl", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractors.kt\ncom/phisher98/GDFlix\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,4003:1\n73#2,5:4004\n1#3:4009\n*S KotlinDebug\n*F\n+ 1 Extractors.kt\ncom/phisher98/GDFlix\n*L\n1915#1:4004,5\n*E\n"})
public class GDFlix extends ExtractorApi {
    private final boolean requiresReferer;

    @NotNull
    private final String name = "GDFlix";

    @NotNull
    private final String mainUrl = "https://gdflix.*";

    /* JADX INFO: renamed from: com.phisher98.GDFlix$getLatestBaseUrl$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.GDFlix", f = "Extractors.kt", i = {0}, l = {1914}, m = "getLatestBaseUrl", n = {"baseUrl"}, nl = {1915}, s = {"L$0"}, v = 2)
    static final class C00221 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00221(Continuation<? super C00221> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GDFlix.this.getLatestBaseUrl(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.GDFlix$getUrl$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.GDFlix", f = "Extractors.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {1793, 1801, 1808}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "subtitleCallback", "callback", "baseUrl", "$this", "url", "referer", "subtitleCallback", "callback", "baseUrl", "latestBaseUrl", "newUrl", "$this", "url", "referer", "subtitleCallback", "callback", "baseUrl", "latestBaseUrl", "newUrl", "document", "fileName", "fileSize", "quality"}, nl = {1795, 1802, 1910}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "I$0"}, v = 2)
    static final class C00231 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C00231(Continuation<? super C00231> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GDFlix.getUrl$suspendImpl(GDFlix.this, null, null, null, null, (Continuation) this);
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

    /* JADX WARN: Code duplicated, block: B:21:0x0110  */
    /* JADX WARN: Code duplicated, block: B:22:0x0121  */
    /* JADX WARN: Code duplicated, block: B:25:0x0185 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:26:0x0186  */
    /* JADX WARN: Code duplicated, block: B:29:0x021a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:30:0x021b  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    static /* synthetic */ Object getUrl$suspendImpl(GDFlix $this, String url, String referer, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super Unit> continuation) {
        C00231 c00231;
        Object obj;
        String url2;
        String referer2;
        Ref.ObjectRef baseUrl;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        String latestBaseUrl;
        String newUrl;
        String url3;
        Function1<? super SubtitleFile, Unit> function5;
        Function1<? super ExtractorLink, Unit> function6;
        Ref.ObjectRef baseUrl2;
        String latestBaseUrl2;
        Object obj2;
        GDFlix $this2;
        int i;
        String newUrl2;
        C00231 c00232;
        String url4;
        Function1<? super ExtractorLink, Unit> function7;
        Ref.ObjectRef baseUrl3;
        GDFlix $this3;
        Function1<? super SubtitleFile, Unit> function8;
        List listSelect;
        C00242 c00242;
        GDFlix $this4 = $this;
        if (continuation instanceof C00231) {
            c00231 = (C00231) continuation;
            if ((c00231.label & Integer.MIN_VALUE) != 0) {
                c00231.label -= Integer.MIN_VALUE;
            } else {
                c00231 = $this4.new C00231(continuation);
            }
        } else {
            c00231 = $this4.new C00231(continuation);
        }
        Object $result = c00231.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00231.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Ref.ObjectRef baseUrl4 = new Ref.ObjectRef();
                baseUrl4.element = $this.getBaseUrl(url);
                String str = (String) baseUrl4.element;
                c00231.L$0 = $this4;
                c00231.L$1 = url;
                c00231.L$2 = SpillingKt.nullOutSpilledVariable(referer);
                c00231.L$3 = function1;
                c00231.L$4 = function2;
                c00231.L$5 = baseUrl4;
                c00231.label = 1;
                Object latestBaseUrl3 = $this4.getLatestBaseUrl(str, c00231);
                if (latestBaseUrl3 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = latestBaseUrl3;
                url2 = url;
                referer2 = referer;
                baseUrl = baseUrl4;
                function3 = function1;
                function4 = function2;
                latestBaseUrl = (String) obj;
                newUrl = url2;
                if (Intrinsics.areEqual(baseUrl.element, latestBaseUrl)) {
                    url3 = latestBaseUrl;
                } else {
                    newUrl = StringsKt.replace$default(url2, (String) baseUrl.element, latestBaseUrl, false, 4, (Object) null);
                    url3 = latestBaseUrl;
                    baseUrl.element = url3;
                }
                Requests app = MainActivityKt.getApp();
                c00231.L$0 = $this4;
                c00231.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                c00231.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                c00231.L$3 = function3;
                c00231.L$4 = function4;
                c00231.L$5 = baseUrl;
                c00231.L$6 = SpillingKt.nullOutSpilledVariable(url3);
                c00231.L$7 = SpillingKt.nullOutSpilledVariable(newUrl);
                c00231.label = 2;
                function5 = function3;
                function6 = function4;
                baseUrl2 = baseUrl;
                String newUrl3 = newUrl;
                latestBaseUrl2 = url3;
                C00231 c00233 = c00231;
                obj2 = coroutine_suspended;
                $this2 = $this4;
                i = 2;
                $result = Requests.get$default(app, newUrl3, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00233, 4094, (Object) null);
                newUrl2 = newUrl3;
                c00232 = c00233;
                if ($result == obj2) {
                    return obj2;
                }
                url4 = url2;
                function7 = function6;
                baseUrl3 = baseUrl2;
                $this3 = $this2;
                function8 = function5;
                Document document = ((NiceResponse) $result).getDocument();
                String fileName = StringsKt.substringAfter$default(document.select("ul > li.list-group-item:contains(Name)").text(), "Name : ", (String) null, i, (Object) null);
                String fileSize = StringsKt.substringAfter$default(document.select("ul > li.list-group-item:contains(Size)").text(), "Size : ", (String) null, i, (Object) null);
                int quality = $this3.getIndexQuality(fileName);
                listSelect = document.select("div.text-center a");
                c00242 = new C00242(function7, fileName, fileSize, baseUrl3, $this3, function8, quality, null);
                c00232.L$0 = SpillingKt.nullOutSpilledVariable($this3);
                c00232.L$1 = SpillingKt.nullOutSpilledVariable(url4);
                c00232.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                c00232.L$3 = SpillingKt.nullOutSpilledVariable(function8);
                c00232.L$4 = SpillingKt.nullOutSpilledVariable(function7);
                c00232.L$5 = SpillingKt.nullOutSpilledVariable(baseUrl3);
                c00232.L$6 = SpillingKt.nullOutSpilledVariable(latestBaseUrl2);
                c00232.L$7 = SpillingKt.nullOutSpilledVariable(newUrl2);
                c00232.L$8 = SpillingKt.nullOutSpilledVariable(document);
                c00232.L$9 = SpillingKt.nullOutSpilledVariable(fileName);
                c00232.L$10 = SpillingKt.nullOutSpilledVariable(fileSize);
                c00232.I$0 = quality;
                c00232.label = 3;
                if (ParCollectionsKt.amap(listSelect, c00242, c00232) == obj2) {
                    return obj2;
                }
                return Unit.INSTANCE;
            case 1:
                Ref.ObjectRef baseUrl5 = (Ref.ObjectRef) c00231.L$5;
                Function1<? super ExtractorLink, Unit> function9 = (Function1) c00231.L$4;
                Function1<? super SubtitleFile, Unit> function10 = (Function1) c00231.L$3;
                String referer3 = (String) c00231.L$2;
                String url5 = (String) c00231.L$1;
                $this4 = (GDFlix) c00231.L$0;
                ResultKt.throwOnFailure($result);
                baseUrl = baseUrl5;
                function4 = function9;
                function3 = function10;
                referer2 = referer3;
                url2 = url5;
                obj = $result;
                latestBaseUrl = (String) obj;
                newUrl = url2;
                if (Intrinsics.areEqual(baseUrl.element, latestBaseUrl)) {
                    newUrl = StringsKt.replace$default(url2, (String) baseUrl.element, latestBaseUrl, false, 4, (Object) null);
                    url3 = latestBaseUrl;
                    baseUrl.element = url3;
                } else {
                    url3 = latestBaseUrl;
                }
                Requests app2 = MainActivityKt.getApp();
                c00231.L$0 = $this4;
                c00231.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                c00231.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                c00231.L$3 = function3;
                c00231.L$4 = function4;
                c00231.L$5 = baseUrl;
                c00231.L$6 = SpillingKt.nullOutSpilledVariable(url3);
                c00231.L$7 = SpillingKt.nullOutSpilledVariable(newUrl);
                c00231.label = 2;
                function5 = function3;
                function6 = function4;
                baseUrl2 = baseUrl;
                String newUrl4 = newUrl;
                latestBaseUrl2 = url3;
                C00231 c00234 = c00231;
                obj2 = coroutine_suspended;
                $this2 = $this4;
                i = 2;
                $result = Requests.get$default(app2, newUrl4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00234, 4094, (Object) null);
                newUrl2 = newUrl4;
                c00232 = c00234;
                if ($result == obj2) {
                    return obj2;
                }
                url4 = url2;
                function7 = function6;
                baseUrl3 = baseUrl2;
                $this3 = $this2;
                function8 = function5;
                Document document2 = ((NiceResponse) $result).getDocument();
                String fileName2 = StringsKt.substringAfter$default(document2.select("ul > li.list-group-item:contains(Name)").text(), "Name : ", (String) null, i, (Object) null);
                String fileSize2 = StringsKt.substringAfter$default(document2.select("ul > li.list-group-item:contains(Size)").text(), "Size : ", (String) null, i, (Object) null);
                int quality2 = $this3.getIndexQuality(fileName2);
                listSelect = document2.select("div.text-center a");
                c00242 = new C00242(function7, fileName2, fileSize2, baseUrl3, $this3, function8, quality2, null);
                c00232.L$0 = SpillingKt.nullOutSpilledVariable($this3);
                c00232.L$1 = SpillingKt.nullOutSpilledVariable(url4);
                c00232.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                c00232.L$3 = SpillingKt.nullOutSpilledVariable(function8);
                c00232.L$4 = SpillingKt.nullOutSpilledVariable(function7);
                c00232.L$5 = SpillingKt.nullOutSpilledVariable(baseUrl3);
                c00232.L$6 = SpillingKt.nullOutSpilledVariable(latestBaseUrl2);
                c00232.L$7 = SpillingKt.nullOutSpilledVariable(newUrl2);
                c00232.L$8 = SpillingKt.nullOutSpilledVariable(document2);
                c00232.L$9 = SpillingKt.nullOutSpilledVariable(fileName2);
                c00232.L$10 = SpillingKt.nullOutSpilledVariable(fileSize2);
                c00232.I$0 = quality2;
                c00232.label = 3;
                if (ParCollectionsKt.amap(listSelect, c00242, c00232) == obj2) {
                    return obj2;
                }
                return Unit.INSTANCE;
            case 2:
                String newUrl5 = (String) c00231.L$7;
                String latestBaseUrl4 = (String) c00231.L$6;
                Ref.ObjectRef baseUrl6 = (Ref.ObjectRef) c00231.L$5;
                Function1<? super ExtractorLink, Unit> function11 = (Function1) c00231.L$4;
                Function1<? super SubtitleFile, Unit> function12 = (Function1) c00231.L$3;
                String referer4 = (String) c00231.L$2;
                String url6 = (String) c00231.L$1;
                GDFlix $this5 = (GDFlix) c00231.L$0;
                ResultKt.throwOnFailure($result);
                c00232 = c00231;
                obj2 = coroutine_suspended;
                newUrl2 = newUrl5;
                latestBaseUrl2 = latestBaseUrl4;
                function7 = function11;
                referer2 = referer4;
                url4 = url6;
                baseUrl3 = baseUrl6;
                function8 = function12;
                $this3 = $this5;
                i = 2;
                Document document3 = ((NiceResponse) $result).getDocument();
                String fileName3 = StringsKt.substringAfter$default(document3.select("ul > li.list-group-item:contains(Name)").text(), "Name : ", (String) null, i, (Object) null);
                String fileSize3 = StringsKt.substringAfter$default(document3.select("ul > li.list-group-item:contains(Size)").text(), "Size : ", (String) null, i, (Object) null);
                int quality3 = $this3.getIndexQuality(fileName3);
                listSelect = document3.select("div.text-center a");
                c00242 = new C00242(function7, fileName3, fileSize3, baseUrl3, $this3, function8, quality3, null);
                c00232.L$0 = SpillingKt.nullOutSpilledVariable($this3);
                c00232.L$1 = SpillingKt.nullOutSpilledVariable(url4);
                c00232.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                c00232.L$3 = SpillingKt.nullOutSpilledVariable(function8);
                c00232.L$4 = SpillingKt.nullOutSpilledVariable(function7);
                c00232.L$5 = SpillingKt.nullOutSpilledVariable(baseUrl3);
                c00232.L$6 = SpillingKt.nullOutSpilledVariable(latestBaseUrl2);
                c00232.L$7 = SpillingKt.nullOutSpilledVariable(newUrl2);
                c00232.L$8 = SpillingKt.nullOutSpilledVariable(document3);
                c00232.L$9 = SpillingKt.nullOutSpilledVariable(fileName3);
                c00232.L$10 = SpillingKt.nullOutSpilledVariable(fileSize3);
                c00232.I$0 = quality3;
                c00232.label = 3;
                if (ParCollectionsKt.amap(listSelect, c00242, c00232) == obj2) {
                    return obj2;
                }
                return Unit.INSTANCE;
            case 3:
                int i2 = c00231.I$0;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.phisher98.GDFlix$getUrl$2 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "anchor", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.GDFlix$getUrl$2", f = "Extractors.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9, 10, 10, 10}, l = {1815, 1823, 1831, 1841, 1845, 1858, 1862, 1877, 1885, 1889, 1901}, m = "invokeSuspend", n = {"anchor", "text", "link", "anchor", "text", "link", "anchor", "text", "link", "anchor", "text", "link", "cfLink", "$this$forEach$iv", "element$iv", "cfType", "anchor", "text", "link", "cfLink", "$this$forEach$iv", "element$iv", "sourceurl", "cfType", "anchor", "text", "link", "anchor", "text", "link", "dlink", "anchor", "text", "link", "baseUrlLink", "finalURL", "anchor", "text", "link", "anchor", "text", "link", "instantLink", "anchor", "text", "link"}, nl = {1814, 1822, 1830, 1842, 1844, 1859, 1861, 1876, 1886, 1888, 1902}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$9", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$9", "L$10", "I$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2"}, v = 2)
    @SourceDebugExtension({"SMAP\nExtractors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractors.kt\ncom/phisher98/GDFlix$getUrl$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,4003:1\n2068#2,2:4004\n*S KotlinDebug\n*F\n+ 1 Extractors.kt\ncom/phisher98/GDFlix$getUrl$2\n*L\n1839#1:4004,2\n*E\n"})
    static final class C00242 extends SuspendLambda implements Function2<Element, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<String> $baseUrl;
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ String $fileName;
        final /* synthetic */ String $fileSize;
        final /* synthetic */ int $quality;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        int I$0;
        int I$1;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        final /* synthetic */ GDFlix this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00242(Function1<? super ExtractorLink, Unit> function1, String str, String str2, Ref.ObjectRef<String> objectRef, GDFlix gDFlix, Function1<? super SubtitleFile, Unit> function2, int i, Continuation<? super C00242> continuation) {
            super(2, continuation);
            this.$callback = function1;
            this.$fileName = str;
            this.$fileSize = str2;
            this.$baseUrl = objectRef;
            this.this$0 = gDFlix;
            this.$subtitleCallback = function2;
            this.$quality = i;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00242 = new C00242(this.$callback, this.$fileName, this.$fileSize, this.$baseUrl, this.this$0, this.$subtitleCallback, this.$quality, continuation);
            c00242.L$0 = obj;
            return c00242;
        }

        public final Object invoke(Element element, Continuation<? super Unit> continuation) {
            return create(element, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:67:0x02fa  */
        /* JADX WARN: Code duplicated, block: B:74:0x037d A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:75:0x037e  */
        /* JADX WARN: Code duplicated, block: B:80:0x03a9  */
        /* JADX WARN: Code duplicated, block: B:81:0x03ab  */
        /* JADX WARN: Code duplicated, block: B:83:0x03af A[Catch: Exception -> 0x0471, TRY_LEAVE, TryCatch #9 {Exception -> 0x0471, blocks: (B:78:0x0394, B:83:0x03af), top: B:219:0x0394 }] */
        /* JADX WARN: Code duplicated, block: B:87:0x0423 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:88:0x0424  */
        /* JADX WARN: Code duplicated, block: B:95:0x045f  */
        /* JADX WARN: Not initialized variable reg: 19, insn: 0x0149: MOVE (r18 I:??[OBJECT, ARRAY]) = (r19 I:??[OBJECT, ARRAY] A[D('cfLink' java.lang.String)]), block:B:39:0x0148 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:106:0x04b8 -> B:107:0x04d0). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:88:0x0424 -> B:232:0x0434). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:95:0x045f -> B:107:0x04d0). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        public final java.lang.Object invokeSuspend(java.lang.Object r40) {
            /*
                Method dump skipped, instruction units count: 2244
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.phisher98.GDFlix.C00242.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: com.phisher98.GDFlix$getUrl$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: Extractors.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.phisher98.GDFlix$getUrl$2$1", f = "Extractors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
            final /* synthetic */ int $quality;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(int i, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$quality = i;
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
                        $this$newExtractorLink.setQuality(this.$quality);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }

        /* JADX INFO: renamed from: com.phisher98.GDFlix$getUrl$2$2, reason: invalid class name */
        /* JADX INFO: compiled from: Extractors.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.phisher98.GDFlix$getUrl$2$2", f = "Extractors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass2 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
            final /* synthetic */ int $quality;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(int i, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$quality = i;
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
                        $this$newExtractorLink.setQuality(this.$quality);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }

        /* JADX INFO: renamed from: com.phisher98.GDFlix$getUrl$2$3, reason: invalid class name */
        /* JADX INFO: compiled from: Extractors.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.phisher98.GDFlix$getUrl$2$3", f = "Extractors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass3 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
            final /* synthetic */ int $quality;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(int i, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.$quality = i;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass3 = new AnonymousClass3(this.$quality, continuation);
                anonymousClass3.L$0 = obj;
                return anonymousClass3;
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
                        $this$newExtractorLink.setQuality(this.$quality);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }

        /* JADX INFO: renamed from: com.phisher98.GDFlix$getUrl$2$5, reason: invalid class name */
        /* JADX INFO: compiled from: Extractors.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.phisher98.GDFlix$getUrl$2$5", f = "Extractors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass5 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
            final /* synthetic */ int $quality;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass5(int i, Continuation<? super AnonymousClass5> continuation) {
                super(2, continuation);
                this.$quality = i;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass5 = new AnonymousClass5(this.$quality, continuation);
                anonymousClass5.L$0 = obj;
                return anonymousClass5;
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
                        $this$newExtractorLink.setQuality(this.$quality);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }

        /* JADX INFO: renamed from: com.phisher98.GDFlix$getUrl$2$6, reason: invalid class name */
        /* JADX INFO: compiled from: Extractors.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.phisher98.GDFlix$getUrl$2$6", f = "Extractors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass6 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
            final /* synthetic */ int $quality;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass6(int i, Continuation<? super AnonymousClass6> continuation) {
                super(2, continuation);
                this.$quality = i;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass6 = new AnonymousClass6(this.$quality, continuation);
                anonymousClass6.L$0 = obj;
                return anonymousClass6;
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
                        $this$newExtractorLink.setQuality(this.$quality);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }

        /* JADX INFO: renamed from: com.phisher98.GDFlix$getUrl$2$7, reason: invalid class name */
        /* JADX INFO: compiled from: Extractors.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.phisher98.GDFlix$getUrl$2$7", f = "Extractors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass7 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
            final /* synthetic */ int $quality;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass7(int i, Continuation<? super AnonymousClass7> continuation) {
                super(2, continuation);
                this.$quality = i;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass7 = new AnonymousClass7(this.$quality, continuation);
                anonymousClass7.L$0 = obj;
                return anonymousClass7;
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
                        $this$newExtractorLink.setQuality(this.$quality);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:38:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:63:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object getLatestBaseUrl(String baseUrl, Continuation<? super String> continuation) {
        C00221 c00221;
        String baseUrl2;
        Object safe;
        Map dynamicUrls;
        String it;
        String str;
        if (continuation instanceof C00221) {
            c00221 = (C00221) continuation;
            if ((c00221.label & Integer.MIN_VALUE) != 0) {
                c00221.label -= Integer.MIN_VALUE;
            } else {
                c00221 = new C00221(continuation);
            }
        } else {
            c00221 = new C00221(continuation);
        }
        C00221 c00222 = c00221;
        Object $result = c00222.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00222.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                try {
                    Requests app = MainActivityKt.getApp();
                    try {
                        c00222.L$0 = baseUrl;
                        c00222.label = 1;
                        try {
                            $result = Requests.get$default(app, "https://raw.githubusercontent.com/SaurabhKaperwan/Utils/refs/heads/main/urls.json", (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00222, 4094, (Object) null);
                            if ($result == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            baseUrl2 = baseUrl;
                            try {
                                NiceResponse this_$iv = (NiceResponse) $result;
                                try {
                                    ResponseParser parser = this_$iv.getParser();
                                    Intrinsics.checkNotNull(parser);
                                    safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(Map.class));
                                    break;
                                } catch (Exception e$iv) {
                                    e$iv.printStackTrace();
                                    safe = null;
                                }
                                dynamicUrls = (Map) safe;
                                if (dynamicUrls != null && (it = (String) dynamicUrls.get("gdflix")) != null) {
                                    str = StringsKt.isBlank(it) ? null : it;
                                    if (str != null) {
                                        return str;
                                    }
                                }
                                return baseUrl2;
                            } catch (Exception e) {
                                return baseUrl2;
                            }
                        } catch (Exception e2) {
                            baseUrl2 = baseUrl;
                            return baseUrl2;
                        }
                    } catch (Exception e3) {
                        baseUrl2 = baseUrl;
                    }
                } catch (Exception e4) {
                    baseUrl2 = baseUrl;
                }
                break;
            case 1:
                baseUrl2 = (String) c00222.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    NiceResponse this_$iv2 = (NiceResponse) $result;
                    ResponseParser parser2 = this_$iv2.getParser();
                    Intrinsics.checkNotNull(parser2);
                    safe = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(Map.class));
                    dynamicUrls = (Map) safe;
                    if (dynamicUrls != null) {
                        if (StringsKt.isBlank(it)) {
                        }
                        if (str != null) {
                            return str;
                        }
                    }
                    return baseUrl2;
                } catch (Exception e5) {
                    return baseUrl2;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final int getIndexQuality(String str) {
        return ExtractorsKt.extractIndexQuality(str, Qualities.P2160.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getBaseUrl(String url) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            GDFlix gDFlix = this;
            URI it = new URI(url);
            obj = Result.constructor-impl(it.getScheme() + "://" + it.getHost());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = "";
        }
        return (String) obj;
    }
}
