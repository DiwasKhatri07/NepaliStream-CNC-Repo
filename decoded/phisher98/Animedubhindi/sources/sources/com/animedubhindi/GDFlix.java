package com.animedubhindi;

import com.lagradost.api.Log;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.ParCollectionsKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Animedubhindi/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u000fJH\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00110\u00152\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00110\u0015H\u0096@¢\u0006\u0002\u0010\u0019J\u000e\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/animedubhindi/GDFlix;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getLatestUrl", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBaseUrl", "Animedubhindi"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractor.kt\ncom/animedubhindi/GDFlix\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,516:1\n1#2:517\n*E\n"})
public final class GDFlix extends ExtractorApi {
    private final boolean requiresReferer;

    @NotNull
    private final String name = "GDFlix";

    @NotNull
    private final String mainUrl = "https://*.gdflix.*";

    /* JADX INFO: renamed from: com.animedubhindi.GDFlix$getLatestUrl$1 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.animedubhindi.GDFlix", f = "Extractor.kt", i = {}, l = {249}, m = "getLatestUrl", n = {}, nl = {248}, s = {}, v = 2)
    static final class C00081 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C00081(Continuation<? super C00081> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GDFlix.this.getLatestUrl((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.animedubhindi.GDFlix$getUrl$1 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.animedubhindi.GDFlix", f = "Extractor.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {263, 265, 272}, m = "getUrl", n = {"url", "referer", "subtitleCallback", "callback", "url", "referer", "subtitleCallback", "callback", "latestUrl", "newUrl", "url", "referer", "subtitleCallback", "callback", "latestUrl", "newUrl", "document", "fileName", "fileSize", "quality"}, nl = {264, 266, 413}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0"}, v = 2)
    static final class C00091 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;
        /* synthetic */ Object result;

        C00091(Continuation<? super C00091> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GDFlix.this.getUrl(null, null, null, null, (Continuation) this);
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object getLatestUrl(Continuation<? super String> continuation) {
        C00081 c00081;
        GDFlix gDFlix;
        if (continuation instanceof C00081) {
            c00081 = (C00081) continuation;
            if ((c00081.label & Integer.MIN_VALUE) != 0) {
                c00081.label -= Integer.MIN_VALUE;
                gDFlix = this;
            } else {
                gDFlix = this;
                c00081 = gDFlix.new C00081(continuation);
            }
        } else {
            gDFlix = this;
            c00081 = gDFlix.new C00081(continuation);
        }
        Object $result = c00081.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00081.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                c00081.label = 1;
                $result = Requests.get$default(app, "https://raw.githubusercontent.com/SaurabhKaperwan/Utils/refs/heads/main/urls.json", (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00081, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String url = new JSONObject(((NiceResponse) $result).getText()).optString("gdflix");
        String str = url;
        if (str == null || str.length() == 0) {
            return gDFlix.getMainUrl();
        }
        return url;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x010c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:22:0x010d  */
    /* JADX WARN: Code duplicated, block: B:25:0x019d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:26:0x019e  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object getUrl(@NotNull String url, @Nullable String referer, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        C00091 c00091;
        Function1<? super SubtitleFile, Unit> function3;
        Object latestUrl;
        String url2;
        Function1<? super ExtractorLink, Unit> function4;
        String referer2;
        String latestUrl2;
        String url3;
        String url4;
        Object obj;
        C00091 c00092;
        Function1<? super SubtitleFile, Unit> function5;
        String latestUrl3;
        String referer3;
        String url5;
        Function1<? super ExtractorLink, Unit> function6;
        List listSelect;
        C00102 c00102;
        if (continuation instanceof C00091) {
            c00091 = (C00091) continuation;
            if ((c00091.label & Integer.MIN_VALUE) != 0) {
                c00091.label -= Integer.MIN_VALUE;
            } else {
                c00091 = new C00091(continuation);
            }
        } else {
            c00091 = new C00091(continuation);
        }
        Object $result = c00091.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00091.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                c00091.L$0 = url;
                c00091.L$1 = SpillingKt.nullOutSpilledVariable(referer);
                function3 = function1;
                c00091.L$2 = function3;
                c00091.L$3 = function2;
                c00091.label = 1;
                latestUrl = getLatestUrl(c00091);
                if (latestUrl == coroutine_suspended) {
                    return coroutine_suspended;
                }
                url2 = url;
                function4 = function2;
                referer2 = referer;
                latestUrl2 = (String) latestUrl;
                url3 = StringsKt.replace$default(url2, getMainUrl(), latestUrl2, false, 4, (Object) null);
                url4 = url2;
                Requests app = MainActivityKt.getApp();
                c00091.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                c00091.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                c00091.L$2 = function3;
                c00091.L$3 = function4;
                c00091.L$4 = latestUrl2;
                c00091.L$5 = SpillingKt.nullOutSpilledVariable(url3);
                c00091.label = 2;
                C00091 c00093 = c00091;
                obj = Requests.get$default(app, url3, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00093, 4094, (Object) null);
                c00092 = c00093;
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                function5 = function3;
                latestUrl3 = latestUrl2;
                referer3 = referer2;
                url5 = url4;
                function6 = function4;
                Document document = ((NiceResponse) obj).getDocument();
                String fileName = StringsKt.substringAfter$default(document.select("ul > li.list-group-item:contains(Name)").text(), "Name : ", (String) null, 2, (Object) null);
                String fileSize = StringsKt.substringAfter$default(document.select("ul > li.list-group-item:contains(Size)").text(), "Size : ", (String) null, 2, (Object) null);
                String latestUrl4 = latestUrl3;
                int quality = ExtractorKt.getIndexQuality(fileName);
                listSelect = document.select("div.text-center a");
                Function1<? super ExtractorLink, Unit> function7 = function6;
                Function1<? super SubtitleFile, Unit> function8 = function5;
                c00102 = new C00102(function7, fileName, fileSize, this, latestUrl4, quality, function8, null);
                c00092.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                c00092.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                c00092.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                c00092.L$3 = SpillingKt.nullOutSpilledVariable(function7);
                c00092.L$4 = SpillingKt.nullOutSpilledVariable(latestUrl4);
                c00092.L$5 = SpillingKt.nullOutSpilledVariable(url3);
                c00092.L$6 = SpillingKt.nullOutSpilledVariable(document);
                c00092.L$7 = SpillingKt.nullOutSpilledVariable(fileName);
                c00092.L$8 = SpillingKt.nullOutSpilledVariable(fileSize);
                c00092.I$0 = quality;
                c00092.label = 3;
                if (ParCollectionsKt.amap(listSelect, c00102, c00092) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                function4 = (Function1) c00091.L$3;
                function3 = (Function1) c00091.L$2;
                referer2 = (String) c00091.L$1;
                String url6 = (String) c00091.L$0;
                ResultKt.throwOnFailure($result);
                url2 = url6;
                latestUrl = $result;
                latestUrl2 = (String) latestUrl;
                url3 = StringsKt.replace$default(url2, getMainUrl(), latestUrl2, false, 4, (Object) null);
                url4 = url2;
                Requests app2 = MainActivityKt.getApp();
                c00091.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                c00091.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                c00091.L$2 = function3;
                c00091.L$3 = function4;
                c00091.L$4 = latestUrl2;
                c00091.L$5 = SpillingKt.nullOutSpilledVariable(url3);
                c00091.label = 2;
                C00091 c00094 = c00091;
                obj = Requests.get$default(app2, url3, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00094, 4094, (Object) null);
                c00092 = c00094;
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                function5 = function3;
                latestUrl3 = latestUrl2;
                referer3 = referer2;
                url5 = url4;
                function6 = function4;
                Document document2 = ((NiceResponse) obj).getDocument();
                String fileName2 = StringsKt.substringAfter$default(document2.select("ul > li.list-group-item:contains(Name)").text(), "Name : ", (String) null, 2, (Object) null);
                String fileSize2 = StringsKt.substringAfter$default(document2.select("ul > li.list-group-item:contains(Size)").text(), "Size : ", (String) null, 2, (Object) null);
                String latestUrl5 = latestUrl3;
                int quality2 = ExtractorKt.getIndexQuality(fileName2);
                listSelect = document2.select("div.text-center a");
                Function1<? super ExtractorLink, Unit> function9 = function6;
                Function1<? super SubtitleFile, Unit> function10 = function5;
                c00102 = new C00102(function9, fileName2, fileSize2, this, latestUrl5, quality2, function10, null);
                c00092.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                c00092.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                c00092.L$2 = SpillingKt.nullOutSpilledVariable(function10);
                c00092.L$3 = SpillingKt.nullOutSpilledVariable(function9);
                c00092.L$4 = SpillingKt.nullOutSpilledVariable(latestUrl5);
                c00092.L$5 = SpillingKt.nullOutSpilledVariable(url3);
                c00092.L$6 = SpillingKt.nullOutSpilledVariable(document2);
                c00092.L$7 = SpillingKt.nullOutSpilledVariable(fileName2);
                c00092.L$8 = SpillingKt.nullOutSpilledVariable(fileSize2);
                c00092.I$0 = quality2;
                c00092.label = 3;
                if (ParCollectionsKt.amap(listSelect, c00102, c00092) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 2:
                String newUrl = (String) c00091.L$5;
                latestUrl3 = (String) c00091.L$4;
                function6 = (Function1) c00091.L$3;
                function5 = (Function1) c00091.L$2;
                String referer4 = (String) c00091.L$1;
                String url7 = (String) c00091.L$0;
                ResultKt.throwOnFailure($result);
                referer3 = referer4;
                url5 = url7;
                c00092 = c00091;
                obj = $result;
                url3 = newUrl;
                Document document3 = ((NiceResponse) obj).getDocument();
                String fileName3 = StringsKt.substringAfter$default(document3.select("ul > li.list-group-item:contains(Name)").text(), "Name : ", (String) null, 2, (Object) null);
                String fileSize3 = StringsKt.substringAfter$default(document3.select("ul > li.list-group-item:contains(Size)").text(), "Size : ", (String) null, 2, (Object) null);
                String latestUrl6 = latestUrl3;
                int quality3 = ExtractorKt.getIndexQuality(fileName3);
                listSelect = document3.select("div.text-center a");
                Function1<? super ExtractorLink, Unit> function11 = function6;
                Function1<? super SubtitleFile, Unit> function12 = function5;
                c00102 = new C00102(function11, fileName3, fileSize3, this, latestUrl6, quality3, function12, null);
                c00092.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                c00092.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                c00092.L$2 = SpillingKt.nullOutSpilledVariable(function12);
                c00092.L$3 = SpillingKt.nullOutSpilledVariable(function11);
                c00092.L$4 = SpillingKt.nullOutSpilledVariable(latestUrl6);
                c00092.L$5 = SpillingKt.nullOutSpilledVariable(url3);
                c00092.L$6 = SpillingKt.nullOutSpilledVariable(document3);
                c00092.L$7 = SpillingKt.nullOutSpilledVariable(fileName3);
                c00092.L$8 = SpillingKt.nullOutSpilledVariable(fileSize3);
                c00092.I$0 = quality3;
                c00092.label = 3;
                if (ParCollectionsKt.amap(listSelect, c00102, c00092) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 3:
                int i = c00091.I$0;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.animedubhindi.GDFlix$getUrl$2 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "anchor", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.animedubhindi.GDFlix$getUrl$2", f = "Extractor.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9}, l = {279, 288, 300, 310, 311, 335, 382, 386, 396, 397}, m = "invokeSuspend", n = {"anchor", "text", "link", "anchor", "text", "link", "link", "anchor", "text", "link", "baseUrlLink", "finalURL", "anchor", "text", "link", "anchor", "text", "link", "anchor", "text", "link", "driveLink", "id", "doId", "baseUrls", "anchor", "text", "link", "instantLink", "anchor", "text", "link", "instantLink", "link", "anchor", "text", "link", "anchor", "text", "link"}, nl = {278, 287, 299, 311, 323, 374, 383, 385, 397, 403}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"}, v = 2)
    static final class C00102 extends SuspendLambda implements Function2<Element, Continuation<? super Object>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ String $fileName;
        final /* synthetic */ String $fileSize;
        final /* synthetic */ String $latestUrl;
        final /* synthetic */ int $quality;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        final /* synthetic */ GDFlix this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00102(Function1<? super ExtractorLink, Unit> function1, String str, String str2, GDFlix gDFlix, String str3, int i, Function1<? super SubtitleFile, Unit> function2, Continuation<? super C00102> continuation) {
            super(2, continuation);
            this.$callback = function1;
            this.$fileName = str;
            this.$fileSize = str2;
            this.this$0 = gDFlix;
            this.$latestUrl = str3;
            this.$quality = i;
            this.$subtitleCallback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00102 = new C00102(this.$callback, this.$fileName, this.$fileSize, this.this$0, this.$latestUrl, this.$quality, this.$subtitleCallback, continuation);
            c00102.L$0 = obj;
            return c00102;
        }

        public final Object invoke(Element element, Continuation<Object> continuation) {
            return create(element, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:101:0x046b A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:102:0x046c  */
        /* JADX WARN: Code duplicated, block: B:122:0x0517 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:67:0x02dd A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:95:0x03f9 A[Catch: Exception -> 0x047a, TryCatch #3 {Exception -> 0x047a, blocks: (B:93:0x03ea, B:95:0x03f9, B:99:0x0403, B:90:0x03a6), top: B:149:0x03a6 }] */
        /* JADX WARN: Code duplicated, block: B:96:0x03fe  */
        /* JADX WARN: Code duplicated, block: B:98:0x0401  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r14v0 */
        /* JADX WARN: Type inference failed for: r14v1 */
        /* JADX WARN: Type inference failed for: r14v18 */
        /* JADX WARN: Type inference failed for: r14v9 */
        /* JADX WARN: Type inference failed for: r3v0, types: [int] */
        /* JADX WARN: Type inference failed for: r3v1 */
        /* JADX WARN: Type inference failed for: r3v10 */
        /* JADX WARN: Type inference failed for: r3v11 */
        /* JADX WARN: Type inference failed for: r3v12 */
        /* JADX WARN: Type inference failed for: r3v13 */
        /* JADX WARN: Type inference failed for: r3v26, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r3v29 */
        /* JADX WARN: Type inference failed for: r3v3 */
        /* JADX WARN: Type inference failed for: r3v50, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r3v53 */
        /* JADX WARN: Type inference failed for: r3v57 */
        /* JADX WARN: Type inference failed for: r3v58 */
        /* JADX WARN: Type inference failed for: r3v59 */
        /* JADX WARN: Type inference failed for: r3v60 */
        /* JADX WARN: Type inference failed for: r3v61 */
        /* JADX WARN: Type inference failed for: r3v62 */
        /* JADX WARN: Type inference failed for: r3v9 */
        public final Object invokeSuspend(Object obj) throws UnsupportedEncodingException {
            String strText;
            String strAttr;
            Object objNewExtractorLink$default;
            String str;
            Function1<ExtractorLink, Unit> function1;
            String str2;
            Object obj2;
            String str3;
            Object obj3;
            String str4;
            String str5;
            Object obj4;
            String str6;
            String str7;
            Object objAmap;
            Object objNewExtractorLink$default2;
            String str8;
            Function1<ExtractorLink, Unit> function2;
            String str9;
            Object objNewExtractorLink$default3;
            Function1<ExtractorLink, Unit> function3;
            String str10;
            String str11;
            Object objAmap2;
            ?? r3;
            String str12;
            String str13;
            String str14;
            String strSubstringAfter$default;
            Function1<ExtractorLink, Unit> function4;
            Object objNewExtractorLink$default4;
            Function1<ExtractorLink, Unit> function5;
            Object objAmap3;
            ?? r4;
            Element element = (Element) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ?? r5 = this.label;
            String str15 = "Instant DL";
            try {
                try {
                    switch (r5) {
                        case 0:
                            ResultKt.throwOnFailure(obj);
                            strText = element.select("a").text();
                            strAttr = element.attr("href");
                            if (StringsKt.contains$default(strText, "DIRECT DL", false, 2, (Object) null)) {
                                Function1<ExtractorLink, Unit> function6 = this.$callback;
                                this.L$0 = SpillingKt.nullOutSpilledVariable(element);
                                this.L$1 = SpillingKt.nullOutSpilledVariable(strText);
                                this.L$2 = SpillingKt.nullOutSpilledVariable(strAttr);
                                this.L$3 = function6;
                                this.label = 1;
                                objNewExtractorLink$default3 = ExtractorApiKt.newExtractorLink$default("GDFlix[Direct]", "GDFlix[Direct] " + this.$fileName + '[' + this.$fileSize + ']', strAttr, (ExtractorLinkType) null, new AnonymousClass1(this.$quality, null), (Continuation) this, 8, (Object) null);
                                if (objNewExtractorLink$default3 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                function3 = function6;
                                str10 = strText;
                                str11 = strAttr;
                                function3.invoke(objNewExtractorLink$default3);
                                return Unit.INSTANCE;
                            }
                            if (StringsKt.contains$default(strText, "CLOUD DOWNLOAD [R2]", false, 2, (Object) null)) {
                                String strDecode = URLDecoder.decode(StringsKt.substringAfter$default(strAttr, "url=", (String) null, 2, (Object) null), StandardCharsets.UTF_8.toString());
                                Function1<ExtractorLink, Unit> function7 = this.$callback;
                                this.L$0 = SpillingKt.nullOutSpilledVariable(element);
                                this.L$1 = SpillingKt.nullOutSpilledVariable(strText);
                                this.L$2 = SpillingKt.nullOutSpilledVariable(strAttr);
                                this.L$3 = SpillingKt.nullOutSpilledVariable(strDecode);
                                this.L$4 = function7;
                                this.label = 2;
                                objNewExtractorLink$default2 = ExtractorApiKt.newExtractorLink$default("GDFlix[Cloud]", "GDFlix[Cloud] " + this.$fileName + '[' + this.$fileSize + ']', strDecode, (ExtractorLinkType) null, new AnonymousClass2(this.$quality, null), (Continuation) this, 8, (Object) null);
                                if (objNewExtractorLink$default2 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                str8 = strText;
                                function2 = function7;
                                str9 = strAttr;
                                function2.invoke(objNewExtractorLink$default2);
                                return Unit.INSTANCE;
                            }
                            if (StringsKt.contains(strText, "pixeldra", true) || StringsKt.contains(strText, "pixel", true)) {
                                String baseUrl = this.this$0.getBaseUrl(strAttr);
                                String str16 = StringsKt.contains(strAttr, "download", true) ? strAttr : baseUrl + "/api/file/" + StringsKt.substringAfterLast$default(strAttr, "/", (String) null, 2, (Object) null) + "?download";
                                Function1<ExtractorLink, Unit> function8 = this.$callback;
                                this.L$0 = SpillingKt.nullOutSpilledVariable(element);
                                this.L$1 = SpillingKt.nullOutSpilledVariable(strText);
                                this.L$2 = SpillingKt.nullOutSpilledVariable(strAttr);
                                this.L$3 = SpillingKt.nullOutSpilledVariable(baseUrl);
                                this.L$4 = SpillingKt.nullOutSpilledVariable(str16);
                                this.L$5 = function8;
                                this.label = 3;
                                objNewExtractorLink$default = ExtractorApiKt.newExtractorLink$default("GDFlix Pixeldrain", "GDFlix Pixeldrain " + this.$fileName + '[' + this.$fileSize + ']', str16, (ExtractorLinkType) null, new AnonymousClass3(this.$quality, null), (Continuation) this, 8, (Object) null);
                                if (objNewExtractorLink$default == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                str = strText;
                                function1 = function8;
                                str2 = strAttr;
                                function1.invoke(objNewExtractorLink$default);
                                return Unit.INSTANCE;
                            }
                            if (StringsKt.contains$default(strText, "Index Links", false, 2, (Object) null)) {
                                try {
                                    this.L$0 = SpillingKt.nullOutSpilledVariable(element);
                                    this.L$1 = SpillingKt.nullOutSpilledVariable(strText);
                                    this.L$2 = SpillingKt.nullOutSpilledVariable(strAttr);
                                    this.label = 4;
                                    obj2 = Requests.get$default(MainActivityKt.getApp(), this.$latestUrl + strAttr, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4094, (Object) null);
                                    if (obj2 == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    str3 = strText;
                                    r5 = strAttr;
                                    try {
                                        this.L$0 = SpillingKt.nullOutSpilledVariable(element);
                                        this.L$1 = SpillingKt.nullOutSpilledVariable(str3);
                                        this.L$2 = SpillingKt.nullOutSpilledVariable((Object) r5);
                                        this.label = 5;
                                        objAmap2 = ParCollectionsKt.amap(((NiceResponse) obj2).getDocument().select("a.btn.btn-outline-info"), new AnonymousClass4(this.$latestUrl, this.$callback, this.$fileName, this.$fileSize, this.$quality, null), (Continuation) this);
                                        r3 = r5;
                                        if (objAmap2 == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        return objAmap2;
                                    } catch (Exception e) {
                                        e = e;
                                        str15 = str3;
                                        Log.INSTANCE.d("Index Links", e.toString());
                                        return Unit.INSTANCE;
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                    str15 = strText;
                                    r5 = strAttr;
                                    Log.INSTANCE.d("Index Links", e.toString());
                                    return Unit.INSTANCE;
                                }
                            }
                            if (StringsKt.contains$default(strText, "DRIVEBOT", false, 2, (Object) null)) {
                                try {
                                    String strSubstringBefore$default = StringsKt.substringBefore$default(StringsKt.substringAfter$default(strAttr, "id=", (String) null, 2, (Object) null), "&", (String) null, 2, (Object) null);
                                    String strSubstringBefore$default2 = StringsKt.substringBefore$default(StringsKt.substringAfter$default(strAttr, "do=", (String) null, 2, (Object) null), "==", (String) null, 2, (Object) null);
                                    List listListOf = CollectionsKt.listOf(new String[]{"https://drivebot.sbs", "https://indexbot.site"});
                                    this.L$0 = SpillingKt.nullOutSpilledVariable(element);
                                    this.L$1 = SpillingKt.nullOutSpilledVariable(strText);
                                    this.L$2 = SpillingKt.nullOutSpilledVariable(strAttr);
                                    this.L$3 = SpillingKt.nullOutSpilledVariable(strAttr);
                                    this.L$4 = SpillingKt.nullOutSpilledVariable(strSubstringBefore$default);
                                    this.L$5 = SpillingKt.nullOutSpilledVariable(strSubstringBefore$default2);
                                    this.L$6 = SpillingKt.nullOutSpilledVariable(listListOf);
                                    this.label = 6;
                                    objAmap = ParCollectionsKt.amap(listListOf, new AnonymousClass5(strSubstringBefore$default, strSubstringBefore$default2, this.$callback, this.$fileName, this.$fileSize, this.$quality, null), (Continuation) this);
                                    if (objAmap == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    str6 = strText;
                                    return objAmap;
                                } catch (Exception e3) {
                                    e = e3;
                                    str6 = strText;
                                    str7 = strAttr;
                                    Log.INSTANCE.d("DriveBot", e.toString());
                                    return Unit.INSTANCE;
                                }
                            }
                            if (StringsKt.contains$default(strText, "Instant DL", false, 2, (Object) null)) {
                                str5 = strAttr;
                                try {
                                    this.L$0 = SpillingKt.nullOutSpilledVariable(element);
                                    this.L$1 = SpillingKt.nullOutSpilledVariable(strText);
                                    this.L$2 = SpillingKt.nullOutSpilledVariable(strAttr);
                                    this.L$3 = SpillingKt.nullOutSpilledVariable(str5);
                                    this.label = 7;
                                    obj4 = Requests.get$default(MainActivityKt.getApp(), str5, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4062, (Object) null);
                                    if (obj4 == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    str14 = ((NiceResponse) obj4).getHeaders().get("location");
                                    if (str14 != null) {
                                        strSubstringAfter$default = StringsKt.substringAfter$default(str14, "url=", (String) null, 2, (Object) null);
                                    } else {
                                        strSubstringAfter$default = null;
                                    }
                                    if (strSubstringAfter$default == null) {
                                        strSubstringAfter$default = "";
                                    }
                                    String str17 = strSubstringAfter$default;
                                    function4 = this.$callback;
                                    this.L$0 = SpillingKt.nullOutSpilledVariable(element);
                                    this.L$1 = SpillingKt.nullOutSpilledVariable(strText);
                                    this.L$2 = SpillingKt.nullOutSpilledVariable(strAttr);
                                    this.L$3 = SpillingKt.nullOutSpilledVariable(str5);
                                    this.L$4 = SpillingKt.nullOutSpilledVariable(str17);
                                    this.L$5 = function4;
                                    this.label = 8;
                                    objNewExtractorLink$default4 = ExtractorApiKt.newExtractorLink$default("GDFlix[Instant Download]", "GDFlix[Instant Download] " + this.$fileName + '[' + this.$fileSize + ']', str17, (ExtractorLinkType) null, new AnonymousClass6(this.$quality, null), (Continuation) this, 8, (Object) null);
                                    if (objNewExtractorLink$default4 == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    str12 = strText;
                                    function5 = function4;
                                    try {
                                        function5.invoke(objNewExtractorLink$default4);
                                    } catch (Exception e4) {
                                        e = e4;
                                        str13 = strAttr;
                                        Log.INSTANCE.d("Instant DL", e.toString());
                                    }
                                    return Unit.INSTANCE;
                                } catch (Exception e5) {
                                    e = e5;
                                    str12 = strText;
                                    str13 = strAttr;
                                    Log.INSTANCE.d("Instant DL", e.toString());
                                    return Unit.INSTANCE;
                                }
                            }
                            if (!StringsKt.contains$default(strText, "GoFile", false, 2, (Object) null)) {
                                Log.INSTANCE.d("Error", "No Server matched");
                                return Unit.INSTANCE;
                            }
                            try {
                                Requests app = MainActivityKt.getApp();
                                Continuation continuation = (Continuation) this;
                                this.L$0 = SpillingKt.nullOutSpilledVariable(element);
                                this.L$1 = SpillingKt.nullOutSpilledVariable(strText);
                                this.L$2 = SpillingKt.nullOutSpilledVariable(strAttr);
                                this.label = 9;
                                try {
                                    obj3 = Requests.get$default(app, strAttr, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, continuation, 4094, (Object) null);
                                    if (obj3 == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    str4 = strText;
                                    r5 = strAttr;
                                    try {
                                        this.L$0 = SpillingKt.nullOutSpilledVariable(element);
                                        this.L$1 = SpillingKt.nullOutSpilledVariable(str4);
                                        this.L$2 = SpillingKt.nullOutSpilledVariable((Object) r5);
                                        this.label = 10;
                                        objAmap3 = ParCollectionsKt.amap(((NiceResponse) obj3).getDocument().select(".row .row a"), new AnonymousClass7(this.$subtitleCallback, this.$callback, null), (Continuation) this);
                                        r4 = r5;
                                        if (objAmap3 == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        return objAmap3;
                                    } catch (Exception e6) {
                                        e = e6;
                                        str15 = str4;
                                        Log.INSTANCE.d("Gofile", e.toString());
                                        return Unit.INSTANCE;
                                    }
                                } catch (Exception e7) {
                                    e = e7;
                                    str15 = strText;
                                    r5 = strAttr;
                                    Log.INSTANCE.d("Gofile", e.toString());
                                    return Unit.INSTANCE;
                                }
                            } catch (Exception e8) {
                                e = e8;
                                str15 = strText;
                                r5 = strAttr;
                            }
                            break;
                        case 1:
                            function3 = (Function1) this.L$3;
                            str11 = (String) this.L$2;
                            str10 = (String) this.L$1;
                            ResultKt.throwOnFailure(obj);
                            objNewExtractorLink$default3 = obj;
                            function3.invoke(objNewExtractorLink$default3);
                            return Unit.INSTANCE;
                        case 2:
                            function2 = (Function1) this.L$4;
                            str9 = (String) this.L$2;
                            String str18 = (String) this.L$1;
                            ResultKt.throwOnFailure(obj);
                            str8 = str18;
                            objNewExtractorLink$default2 = obj;
                            function2.invoke(objNewExtractorLink$default2);
                            return Unit.INSTANCE;
                        case 3:
                            function1 = (Function1) this.L$5;
                            str2 = (String) this.L$2;
                            String str19 = (String) this.L$1;
                            ResultKt.throwOnFailure(obj);
                            str = str19;
                            objNewExtractorLink$default = obj;
                            function1.invoke(objNewExtractorLink$default);
                            return Unit.INSTANCE;
                        case 4:
                            String str20 = (String) this.L$2;
                            String str21 = (String) this.L$1;
                            ResultKt.throwOnFailure(obj);
                            str3 = str21;
                            obj2 = obj;
                            r5 = str20;
                            this.L$0 = SpillingKt.nullOutSpilledVariable(element);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(str3);
                            this.L$2 = SpillingKt.nullOutSpilledVariable((Object) r5);
                            this.label = 5;
                            objAmap2 = ParCollectionsKt.amap(((NiceResponse) obj2).getDocument().select("a.btn.btn-outline-info"), new AnonymousClass4(this.$latestUrl, this.$callback, this.$fileName, this.$fileSize, this.$quality, null), (Continuation) this);
                            r3 = r5;
                            if (objAmap2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return objAmap2;
                        case 5:
                            String str22 = (String) this.L$2;
                            String str23 = (String) this.L$1;
                            ResultKt.throwOnFailure(obj);
                            str3 = str23;
                            objAmap2 = obj;
                            r3 = str22;
                            return objAmap2;
                        case 6:
                            str7 = (String) this.L$2;
                            str6 = (String) this.L$1;
                            try {
                                ResultKt.throwOnFailure(obj);
                                objAmap = obj;
                                return objAmap;
                            } catch (Exception e9) {
                                e = e9;
                                Log.INSTANCE.d("DriveBot", e.toString());
                                return Unit.INSTANCE;
                            }
                        case 7:
                            String str24 = (String) this.L$3;
                            String str25 = (String) this.L$2;
                            String str26 = (String) this.L$1;
                            try {
                                ResultKt.throwOnFailure(obj);
                                str5 = str24;
                                strAttr = str25;
                                strText = str26;
                                obj4 = obj;
                                str14 = ((NiceResponse) obj4).getHeaders().get("location");
                                if (str14 != null) {
                                    strSubstringAfter$default = StringsKt.substringAfter$default(str14, "url=", (String) null, 2, (Object) null);
                                } else {
                                    strSubstringAfter$default = null;
                                }
                                if (strSubstringAfter$default == null) {
                                    strSubstringAfter$default = "";
                                }
                                String str110 = strSubstringAfter$default;
                                function4 = this.$callback;
                                this.L$0 = SpillingKt.nullOutSpilledVariable(element);
                                this.L$1 = SpillingKt.nullOutSpilledVariable(strText);
                                this.L$2 = SpillingKt.nullOutSpilledVariable(strAttr);
                                this.L$3 = SpillingKt.nullOutSpilledVariable(str5);
                                this.L$4 = SpillingKt.nullOutSpilledVariable(str110);
                                this.L$5 = function4;
                                this.label = 8;
                                objNewExtractorLink$default4 = ExtractorApiKt.newExtractorLink$default("GDFlix[Instant Download]", "GDFlix[Instant Download] " + this.$fileName + '[' + this.$fileSize + ']', str110, (ExtractorLinkType) null, new AnonymousClass6(this.$quality, null), (Continuation) this, 8, (Object) null);
                                if (objNewExtractorLink$default4 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                str12 = strText;
                                function5 = function4;
                                function5.invoke(objNewExtractorLink$default4);
                                return Unit.INSTANCE;
                            } catch (Exception e10) {
                                e = e10;
                                str13 = str25;
                                str12 = str26;
                                Log.INSTANCE.d("Instant DL", e.toString());
                                return Unit.INSTANCE;
                            }
                        case 8:
                            function5 = (Function1) this.L$5;
                            str13 = (String) this.L$2;
                            str12 = (String) this.L$1;
                            try {
                                ResultKt.throwOnFailure(obj);
                                strAttr = str13;
                                objNewExtractorLink$default4 = obj;
                                function5.invoke(objNewExtractorLink$default4);
                            } catch (Exception e11) {
                                e = e11;
                                Log.INSTANCE.d("Instant DL", e.toString());
                                return Unit.INSTANCE;
                            }
                            return Unit.INSTANCE;
                        case 9:
                            String str27 = (String) this.L$2;
                            String str28 = (String) this.L$1;
                            ResultKt.throwOnFailure(obj);
                            str4 = str28;
                            obj3 = obj;
                            r5 = str27;
                            this.L$0 = SpillingKt.nullOutSpilledVariable(element);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(str4);
                            this.L$2 = SpillingKt.nullOutSpilledVariable((Object) r5);
                            this.label = 10;
                            objAmap3 = ParCollectionsKt.amap(((NiceResponse) obj3).getDocument().select(".row .row a"), new AnonymousClass7(this.$subtitleCallback, this.$callback, null), (Continuation) this);
                            r4 = r5;
                            if (objAmap3 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return objAmap3;
                        case 10:
                            String str29 = (String) this.L$2;
                            String str30 = (String) this.L$1;
                            ResultKt.throwOnFailure(obj);
                            str4 = str30;
                            objAmap3 = obj;
                            r4 = str29;
                            return objAmap3;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } catch (Exception e12) {
                    e = e12;
                }
            } catch (Exception e13) {
                e = e13;
            }
        }

        /* JADX INFO: renamed from: com.animedubhindi.GDFlix$getUrl$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: Extractor.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.animedubhindi.GDFlix$getUrl$2$1", f = "Extractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
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

        /* JADX INFO: renamed from: com.animedubhindi.GDFlix$getUrl$2$2, reason: invalid class name */
        /* JADX INFO: compiled from: Extractor.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.animedubhindi.GDFlix$getUrl$2$2", f = "Extractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
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

        /* JADX INFO: renamed from: com.animedubhindi.GDFlix$getUrl$2$3, reason: invalid class name */
        /* JADX INFO: compiled from: Extractor.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.animedubhindi.GDFlix$getUrl$2$3", f = "Extractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
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

        /* JADX INFO: renamed from: com.animedubhindi.GDFlix$getUrl$2$4, reason: invalid class name */
        /* JADX INFO: compiled from: Extractor.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u000b\u0010\u0003\u001a\u00070\u0004¢\u0006\u0002\b\u0005H\n"}, d2 = {"<anonymous>", "", "", "btn", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.animedubhindi.GDFlix$getUrl$2$4", f = "Extractor.kt", i = {0, 0, 1, 1}, l = {313, 314}, m = "invokeSuspend", n = {"btn", "serverUrl", "btn", "serverUrl"}, nl = {314, 321}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 2)
        static final class AnonymousClass4 extends SuspendLambda implements Function2<Element, Continuation<? super List<? extends Unit>>, Object> {
            final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
            final /* synthetic */ String $fileName;
            final /* synthetic */ String $fileSize;
            final /* synthetic */ String $latestUrl;
            final /* synthetic */ int $quality;
            /* synthetic */ Object L$0;
            Object L$1;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass4(String str, Function1<? super ExtractorLink, Unit> function1, String str2, String str3, int i, Continuation<? super AnonymousClass4> continuation) {
                super(2, continuation);
                this.$latestUrl = str;
                this.$callback = function1;
                this.$fileName = str2;
                this.$fileSize = str3;
                this.$quality = i;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass4 = new AnonymousClass4(this.$latestUrl, this.$callback, this.$fileName, this.$fileSize, this.$quality, continuation);
                anonymousClass4.L$0 = obj;
                return anonymousClass4;
            }

            public final Object invoke(Element element, Continuation<? super List<Unit>> continuation) {
                return create(element, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object $result) {
                Object obj;
                String serverUrl;
                Element btn = (Element) this.L$0;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        String serverUrl2 = this.$latestUrl + btn.attr("href");
                        this.L$0 = SpillingKt.nullOutSpilledVariable(btn);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(serverUrl2);
                        this.label = 1;
                        Object obj2 = Requests.get$default(MainActivityKt.getApp(), serverUrl2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4094, (Object) null);
                        if (obj2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = obj2;
                        serverUrl = serverUrl2;
                        break;
                        break;
                    case 1:
                        serverUrl = (String) this.L$1;
                        ResultKt.throwOnFailure($result);
                        obj = $result;
                        break;
                    case 2:
                        ResultKt.throwOnFailure($result);
                        return $result;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(btn);
                this.L$1 = SpillingKt.nullOutSpilledVariable(serverUrl);
                this.label = 2;
                Object objAmap = ParCollectionsKt.amap(((NiceResponse) obj).getDocument().select("div.mb-4 > a"), new AnonymousClass1(this.$callback, this.$fileName, this.$fileSize, this.$quality, null), (Continuation) this);
                if (objAmap == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return objAmap;
            }

            /* JADX INFO: renamed from: com.animedubhindi.GDFlix$getUrl$2$4$1, reason: invalid class name */
            /* JADX INFO: compiled from: Extractor.kt */
            @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "sourceAnchor", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
            @DebugMetadata(c = "com.animedubhindi.GDFlix$getUrl$2$4$1", f = "Extractor.kt", i = {0, 0}, l = {317}, m = "invokeSuspend", n = {"sourceAnchor", "source"}, nl = {316}, s = {"L$0", "L$1"}, v = 2)
            static final class AnonymousClass1 extends SuspendLambda implements Function2<Element, Continuation<? super Unit>, Object> {
                final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
                final /* synthetic */ String $fileName;
                final /* synthetic */ String $fileSize;
                final /* synthetic */ int $quality;
                /* synthetic */ Object L$0;
                Object L$1;
                Object L$2;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(Function1<? super ExtractorLink, Unit> function1, String str, String str2, int i, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$callback = function1;
                    this.$fileName = str;
                    this.$fileSize = str2;
                    this.$quality = i;
                }

                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$callback, this.$fileName, this.$fileSize, this.$quality, continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                public final Object invoke(Element element, Continuation<? super Unit> continuation) {
                    return create(element, continuation).invokeSuspend(Unit.INSTANCE);
                }

                public final Object invokeSuspend(Object $result) {
                    Object objNewExtractorLink$default;
                    Function1<ExtractorLink, Unit> function1;
                    Element sourceAnchor = (Element) this.L$0;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            String source = sourceAnchor.attr("href");
                            Function1<ExtractorLink, Unit> function2 = this.$callback;
                            this.L$0 = SpillingKt.nullOutSpilledVariable(sourceAnchor);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(source);
                            this.L$2 = function2;
                            this.label = 1;
                            objNewExtractorLink$default = ExtractorApiKt.newExtractorLink$default("GDFlix[Index]", "GDFlix[Index] " + this.$fileName + '[' + this.$fileSize + ']', source, (ExtractorLinkType) null, new C00141(this.$quality, null), (Continuation) this, 8, (Object) null);
                            if (objNewExtractorLink$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            function1 = function2;
                            break;
                            break;
                        case 1:
                            function1 = (Function1) this.L$2;
                            ResultKt.throwOnFailure($result);
                            objNewExtractorLink$default = $result;
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    function1.invoke(objNewExtractorLink$default);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: com.animedubhindi.GDFlix$getUrl$2$4$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: Extractor.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
                @DebugMetadata(c = "com.animedubhindi.GDFlix$getUrl$2$4$1$1", f = "Extractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
                static final class C00141 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
                    final /* synthetic */ int $quality;
                    private /* synthetic */ Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C00141(int i, Continuation<? super C00141> continuation) {
                        super(2, continuation);
                        this.$quality = i;
                    }

                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        Continuation<Unit> c00141 = new C00141(this.$quality, continuation);
                        c00141.L$0 = obj;
                        return c00141;
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
        }

        /* JADX INFO: renamed from: com.animedubhindi.GDFlix$getUrl$2$5, reason: invalid class name */
        /* JADX INFO: compiled from: Extractor.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "baseUrl", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.animedubhindi.GDFlix$getUrl$2$5", f = "Extractor.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {337, 356, 367}, m = "invokeSuspend", n = {"baseUrl", "indexbotLink", "baseUrl", "indexbotLink", "indexbotResponse", "cookiesSSID", "indexbotDoc", "token", "postId", "requestBody", "headers", "cookies", "baseUrl", "indexbotLink", "indexbotResponse", "cookiesSSID", "indexbotDoc", "token", "postId", "requestBody", "headers", "cookies", "downloadLink"}, nl = {339, 362, 366}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10"}, v = 2)
        static final class AnonymousClass5 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
            final /* synthetic */ String $doId;
            final /* synthetic */ String $fileName;
            final /* synthetic */ String $fileSize;
            final /* synthetic */ String $id;
            final /* synthetic */ int $quality;
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

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass5(String str, String str2, Function1<? super ExtractorLink, Unit> function1, String str3, String str4, int i, Continuation<? super AnonymousClass5> continuation) {
                super(2, continuation);
                this.$id = str;
                this.$doId = str2;
                this.$callback = function1;
                this.$fileName = str3;
                this.$fileSize = str4;
                this.$quality = i;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass5 = new AnonymousClass5(this.$id, this.$doId, this.$callback, this.$fileName, this.$fileSize, this.$quality, continuation);
                anonymousClass5.L$0 = obj;
                return anonymousClass5;
            }

            public final Object invoke(String str, Continuation<? super Unit> continuation) {
                return create(str, continuation).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code duplicated, block: B:15:0x00f2  */
            /* JADX WARN: Code duplicated, block: B:20:0x0126  */
            /* JADX WARN: Code duplicated, block: B:22:0x0129  */
            /* JADX WARN: Code duplicated, block: B:28:0x0150  */
            /* JADX WARN: Code duplicated, block: B:30:0x0153  */
            /* JADX WARN: Code duplicated, block: B:33:0x0202 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:34:0x0203  */
            /* JADX WARN: Code duplicated, block: B:37:0x022c  */
            /* JADX WARN: Code duplicated, block: B:42:0x024c  */
            /* JADX WARN: Code duplicated, block: B:44:0x024f  */
            /* JADX WARN: Code duplicated, block: B:47:0x02e2 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:48:0x02e3  */
            public final Object invokeSuspend(Object $result) {
                Object obj;
                String indexbotLink;
                NiceResponse indexbotResponse;
                String cookiesSSID;
                Document indexbotDoc;
                MatchResult matchResultFind$default;
                String token;
                MatchResult matchResultFind$default2;
                String postId;
                FormBody requestBody;
                Map headers;
                Map cookies;
                Object objPost$default;
                String cookiesSSID2;
                FormBody requestBody2;
                Document indexbotDoc2;
                String token2;
                NiceResponse indexbotResponse2;
                Map cookies2;
                List groupValues;
                List groupValues2;
                MatchResult matchResultFind$default3;
                String strReplace$default;
                Function1<ExtractorLink, Unit> function1;
                Object objNewExtractorLink$default;
                Function1<ExtractorLink, Unit> function2;
                String token3;
                List groupValues3;
                String str;
                String baseUrl = (String) this.L$0;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        String indexbotLink2 = baseUrl + "/download?id=" + this.$id + "&do=" + this.$doId;
                        this.L$0 = baseUrl;
                        this.L$1 = indexbotLink2;
                        this.label = 1;
                        obj = Requests.get$default(MainActivityKt.getApp(), indexbotLink2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 100L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 3838, (Object) null);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        indexbotLink = indexbotLink2;
                        indexbotResponse = (NiceResponse) obj;
                        if (indexbotResponse.isSuccessful()) {
                            cookiesSSID = (String) indexbotResponse.getCookies().get("PHPSESSID");
                            indexbotDoc = indexbotResponse.getDocument();
                            matchResultFind$default = Regex.find$default(new Regex("formData\\.append\\('token', '([a-f0-9]+)'\\)"), indexbotDoc.toString(), 0, 2, (Object) null);
                            if (matchResultFind$default != null || (groupValues2 = matchResultFind$default.getGroupValues()) == null) {
                                token = null;
                            } else {
                                token = (String) groupValues2.get(1);
                            }
                            if (token == null) {
                                token = "";
                            }
                            matchResultFind$default2 = Regex.find$default(new Regex("fetch\\('/download\\?id=([a-zA-Z0-9/+]+)'"), indexbotDoc.toString(), 0, 2, (Object) null);
                            if (matchResultFind$default2 != null || (groupValues = matchResultFind$default2.getGroupValues()) == null) {
                                postId = null;
                            } else {
                                postId = (String) groupValues.get(1);
                            }
                            if (postId == null) {
                                postId = "";
                            }
                            requestBody = new FormBody.Builder((Charset) null, 1, (DefaultConstructorMarker) null).add("token", token).build();
                            headers = MapsKt.mapOf(TuplesKt.to("Referer", indexbotLink));
                            cookies = MapsKt.mapOf(TuplesKt.to("PHPSESSID", String.valueOf(cookiesSSID)));
                            this.L$0 = baseUrl;
                            this.L$1 = SpillingKt.nullOutSpilledVariable(indexbotLink);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(indexbotResponse);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(cookiesSSID);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(indexbotDoc);
                            this.L$5 = SpillingKt.nullOutSpilledVariable(token);
                            this.L$6 = SpillingKt.nullOutSpilledVariable(postId);
                            this.L$7 = SpillingKt.nullOutSpilledVariable(requestBody);
                            this.L$8 = SpillingKt.nullOutSpilledVariable(headers);
                            this.L$9 = SpillingKt.nullOutSpilledVariable(cookies);
                            this.label = 2;
                            objPost$default = Requests.post$default(MainActivityKt.getApp(), baseUrl + "/download?id=" + postId, headers, (String) null, (Map) null, cookies, (Map) null, (List) null, (Object) null, (RequestBody) requestBody, false, 0, (TimeUnit) null, 100L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 61164, (Object) null);
                            if (objPost$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            cookiesSSID2 = indexbotLink;
                            requestBody2 = requestBody;
                            String str2 = token;
                            indexbotDoc2 = indexbotDoc;
                            token2 = str2;
                            indexbotResponse2 = indexbotResponse;
                            cookies2 = cookies;
                            String it = ((NiceResponse) objPost$default).getText();
                            Map cookies3 = cookies2;
                            matchResultFind$default3 = Regex.find$default(new Regex("url\":\"(.*?)\""), it, 0, 2, (Object) null);
                            if (matchResultFind$default3 != null || (groupValues3 = matchResultFind$default3.getGroupValues()) == null || (str = (String) groupValues3.get(1)) == null) {
                                strReplace$default = null;
                            } else {
                                strReplace$default = StringsKt.replace$default(str, "\\", "", false, 4, (Object) null);
                            }
                            if (strReplace$default == null) {
                                strReplace$default = "";
                            }
                            String downloadLink = strReplace$default;
                            function1 = this.$callback;
                            this.L$0 = SpillingKt.nullOutSpilledVariable(baseUrl);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(cookiesSSID2);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(indexbotResponse2);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(cookiesSSID);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(indexbotDoc2);
                            this.L$5 = SpillingKt.nullOutSpilledVariable(token2);
                            this.L$6 = SpillingKt.nullOutSpilledVariable(postId);
                            this.L$7 = SpillingKt.nullOutSpilledVariable(requestBody2);
                            this.L$8 = SpillingKt.nullOutSpilledVariable(headers);
                            this.L$9 = SpillingKt.nullOutSpilledVariable(cookies3);
                            this.L$10 = SpillingKt.nullOutSpilledVariable(downloadLink);
                            this.L$11 = function1;
                            this.label = 3;
                            objNewExtractorLink$default = ExtractorApiKt.newExtractorLink$default("GDFlix[DriveBot]", "GDFlix[DriveBot] " + this.$fileName + '[' + this.$fileSize + ']', downloadLink, (ExtractorLinkType) null, new AnonymousClass1(baseUrl, this.$quality, null), (Continuation) this, 8, (Object) null);
                            if (objNewExtractorLink$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            function2 = function1;
                            token3 = cookiesSSID2;
                            function2.invoke(objNewExtractorLink$default);
                        }
                        return Unit.INSTANCE;
                    case 1:
                        String indexbotLink3 = (String) this.L$1;
                        ResultKt.throwOnFailure($result);
                        indexbotLink = indexbotLink3;
                        obj = $result;
                        indexbotResponse = (NiceResponse) obj;
                        if (indexbotResponse.isSuccessful()) {
                            cookiesSSID = (String) indexbotResponse.getCookies().get("PHPSESSID");
                            indexbotDoc = indexbotResponse.getDocument();
                            matchResultFind$default = Regex.find$default(new Regex("formData\\.append\\('token', '([a-f0-9]+)'\\)"), indexbotDoc.toString(), 0, 2, (Object) null);
                            if (matchResultFind$default != null) {
                                token = null;
                            } else {
                                token = null;
                            }
                            if (token == null) {
                                token = "";
                            }
                            matchResultFind$default2 = Regex.find$default(new Regex("fetch\\('/download\\?id=([a-zA-Z0-9/+]+)'"), indexbotDoc.toString(), 0, 2, (Object) null);
                            if (matchResultFind$default2 != null) {
                                postId = null;
                            } else {
                                postId = null;
                            }
                            if (postId == null) {
                                postId = "";
                            }
                            requestBody = new FormBody.Builder((Charset) null, 1, (DefaultConstructorMarker) null).add("token", token).build();
                            headers = MapsKt.mapOf(TuplesKt.to("Referer", indexbotLink));
                            cookies = MapsKt.mapOf(TuplesKt.to("PHPSESSID", String.valueOf(cookiesSSID)));
                            this.L$0 = baseUrl;
                            this.L$1 = SpillingKt.nullOutSpilledVariable(indexbotLink);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(indexbotResponse);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(cookiesSSID);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(indexbotDoc);
                            this.L$5 = SpillingKt.nullOutSpilledVariable(token);
                            this.L$6 = SpillingKt.nullOutSpilledVariable(postId);
                            this.L$7 = SpillingKt.nullOutSpilledVariable(requestBody);
                            this.L$8 = SpillingKt.nullOutSpilledVariable(headers);
                            this.L$9 = SpillingKt.nullOutSpilledVariable(cookies);
                            this.label = 2;
                            objPost$default = Requests.post$default(MainActivityKt.getApp(), baseUrl + "/download?id=" + postId, headers, (String) null, (Map) null, cookies, (Map) null, (List) null, (Object) null, (RequestBody) requestBody, false, 0, (TimeUnit) null, 100L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 61164, (Object) null);
                            if (objPost$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            cookiesSSID2 = indexbotLink;
                            requestBody2 = requestBody;
                            String str3 = token;
                            indexbotDoc2 = indexbotDoc;
                            token2 = str3;
                            indexbotResponse2 = indexbotResponse;
                            cookies2 = cookies;
                            String it2 = ((NiceResponse) objPost$default).getText();
                            Map cookies4 = cookies2;
                            matchResultFind$default3 = Regex.find$default(new Regex("url\":\"(.*?)\""), it2, 0, 2, (Object) null);
                            if (matchResultFind$default3 != null) {
                                strReplace$default = null;
                            } else {
                                strReplace$default = null;
                            }
                            if (strReplace$default == null) {
                                strReplace$default = "";
                            }
                            String downloadLink2 = strReplace$default;
                            function1 = this.$callback;
                            this.L$0 = SpillingKt.nullOutSpilledVariable(baseUrl);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(cookiesSSID2);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(indexbotResponse2);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(cookiesSSID);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(indexbotDoc2);
                            this.L$5 = SpillingKt.nullOutSpilledVariable(token2);
                            this.L$6 = SpillingKt.nullOutSpilledVariable(postId);
                            this.L$7 = SpillingKt.nullOutSpilledVariable(requestBody2);
                            this.L$8 = SpillingKt.nullOutSpilledVariable(headers);
                            this.L$9 = SpillingKt.nullOutSpilledVariable(cookies4);
                            this.L$10 = SpillingKt.nullOutSpilledVariable(downloadLink2);
                            this.L$11 = function1;
                            this.label = 3;
                            objNewExtractorLink$default = ExtractorApiKt.newExtractorLink$default("GDFlix[DriveBot]", "GDFlix[DriveBot] " + this.$fileName + '[' + this.$fileSize + ']', downloadLink2, (ExtractorLinkType) null, new AnonymousClass1(baseUrl, this.$quality, null), (Continuation) this, 8, (Object) null);
                            if (objNewExtractorLink$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            function2 = function1;
                            token3 = cookiesSSID2;
                            function2.invoke(objNewExtractorLink$default);
                        }
                        return Unit.INSTANCE;
                    case 2:
                        cookies2 = (Map) this.L$9;
                        Map headers2 = (Map) this.L$8;
                        FormBody requestBody3 = (FormBody) this.L$7;
                        String postId2 = (String) this.L$6;
                        token2 = (String) this.L$5;
                        indexbotDoc2 = (Document) this.L$4;
                        String cookiesSSID3 = (String) this.L$3;
                        NiceResponse indexbotResponse3 = (NiceResponse) this.L$2;
                        String indexbotLink4 = (String) this.L$1;
                        ResultKt.throwOnFailure($result);
                        cookiesSSID2 = indexbotLink4;
                        requestBody2 = requestBody3;
                        cookiesSSID = cookiesSSID3;
                        headers = headers2;
                        postId = postId2;
                        indexbotResponse2 = indexbotResponse3;
                        objPost$default = $result;
                        String it3 = ((NiceResponse) objPost$default).getText();
                        Map cookies5 = cookies2;
                        matchResultFind$default3 = Regex.find$default(new Regex("url\":\"(.*?)\""), it3, 0, 2, (Object) null);
                        if (matchResultFind$default3 != null) {
                            strReplace$default = null;
                        } else {
                            strReplace$default = null;
                        }
                        if (strReplace$default == null) {
                            strReplace$default = "";
                        }
                        String downloadLink3 = strReplace$default;
                        function1 = this.$callback;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(baseUrl);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(cookiesSSID2);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(indexbotResponse2);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(cookiesSSID);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(indexbotDoc2);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(token2);
                        this.L$6 = SpillingKt.nullOutSpilledVariable(postId);
                        this.L$7 = SpillingKt.nullOutSpilledVariable(requestBody2);
                        this.L$8 = SpillingKt.nullOutSpilledVariable(headers);
                        this.L$9 = SpillingKt.nullOutSpilledVariable(cookies5);
                        this.L$10 = SpillingKt.nullOutSpilledVariable(downloadLink3);
                        this.L$11 = function1;
                        this.label = 3;
                        objNewExtractorLink$default = ExtractorApiKt.newExtractorLink$default("GDFlix[DriveBot]", "GDFlix[DriveBot] " + this.$fileName + '[' + this.$fileSize + ']', downloadLink3, (ExtractorLinkType) null, new AnonymousClass1(baseUrl, this.$quality, null), (Continuation) this, 8, (Object) null);
                        if (objNewExtractorLink$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function2 = function1;
                        token3 = cookiesSSID2;
                        function2.invoke(objNewExtractorLink$default);
                        return Unit.INSTANCE;
                    case 3:
                        function2 = (Function1) this.L$11;
                        indexbotResponse2 = (NiceResponse) this.L$2;
                        token3 = (String) this.L$1;
                        ResultKt.throwOnFailure($result);
                        objNewExtractorLink$default = $result;
                        function2.invoke(objNewExtractorLink$default);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX INFO: renamed from: com.animedubhindi.GDFlix$getUrl$2$5$1, reason: invalid class name */
            /* JADX INFO: compiled from: Extractor.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
            @DebugMetadata(c = "com.animedubhindi.GDFlix$getUrl$2$5$1", f = "Extractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
            static final class AnonymousClass1 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
                final /* synthetic */ String $baseUrl;
                final /* synthetic */ int $quality;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(String str, int i, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$baseUrl = str;
                    this.$quality = i;
                }

                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$baseUrl, this.$quality, continuation);
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
                            $this$newExtractorLink.setReferer(this.$baseUrl);
                            $this$newExtractorLink.setQuality(this.$quality);
                            return Unit.INSTANCE;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
        }

        /* JADX INFO: renamed from: com.animedubhindi.GDFlix$getUrl$2$6, reason: invalid class name */
        /* JADX INFO: compiled from: Extractor.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.animedubhindi.GDFlix$getUrl$2$6", f = "Extractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
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

        /* JADX INFO: renamed from: com.animedubhindi.GDFlix$getUrl$2$7, reason: invalid class name */
        /* JADX INFO: compiled from: Extractor.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "gofileAnchor", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.animedubhindi.GDFlix$getUrl$2$7", f = "Extractor.kt", i = {0, 0}, l = {400}, m = "invokeSuspend", n = {"gofileAnchor", "link"}, nl = {402}, s = {"L$0", "L$1"}, v = 2)
        static final class AnonymousClass7 extends SuspendLambda implements Function2<Element, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
            final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
            /* synthetic */ Object L$0;
            Object L$1;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass7(Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super AnonymousClass7> continuation) {
                super(2, continuation);
                this.$subtitleCallback = function1;
                this.$callback = function2;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass7 = new AnonymousClass7(this.$subtitleCallback, this.$callback, continuation);
                anonymousClass7.L$0 = obj;
                return anonymousClass7;
            }

            public final Object invoke(Element element, Continuation<? super Unit> continuation) {
                return create(element, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object $result) {
                String link;
                Element gofileAnchor = (Element) this.L$0;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        String link2 = gofileAnchor.attr("href");
                        if (StringsKt.contains$default(link2, "gofile", false, 2, (Object) null)) {
                            this.L$0 = SpillingKt.nullOutSpilledVariable(gofileAnchor);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(link2);
                            this.label = 1;
                            if (new Gofile().getUrl(link2, "", this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            link = link2;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        link = (String) this.L$1;
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
    }

    @NotNull
    public final String getBaseUrl(@NotNull String url) {
        try {
            URI it = new URI(url);
            return it.getScheme() + "://" + it.getHost();
        } catch (Exception e) {
            return "";
        }
    }
}
