package com.fourKHDHub;

import com.lagradost.api.Log;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.ParCollectionsKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import com.lagradost.cloudstream3.utils.Qualities;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/FourKHDHub/classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00110\u00152\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00110\u0015H\u0096@¢\u0006\u0002\u0010\u0019J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0005H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0007\"\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006 "}, d2 = {"Lcom/fourKHDHub/HubCloud;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "setMainUrl", "(Ljava/lang/String;)V", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIndexQuality", "", "str", "getBaseUrl", "cleanTitle", "title", "FourKHDHub"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractor.kt\ncom/fourKHDHub/HubCloud\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,457:1\n1#2:458\n1#2:473\n1795#3,10:459\n2068#3:469\n1960#3,3:470\n2069#3:474\n1805#3:475\n*S KotlinDebug\n*F\n+ 1 Extractor.kt\ncom/fourKHDHub/HubCloud\n*L\n372#1:473\n372#1:459,10\n372#1:469\n378#1:470,3\n372#1:474\n372#1:475\n*E\n"})
public final class HubCloud extends ExtractorApi {
    private final boolean requiresReferer;

    @NotNull
    private final String name = "Hub-Cloud";

    @NotNull
    private String mainUrl = (String) BuildersKt.runBlockingK(EmptyCoroutineContext.INSTANCE, new HubCloud$mainUrl$1(null));

    /* JADX INFO: renamed from: com.fourKHDHub.HubCloud$getUrl$1 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.fourKHDHub.HubCloud", f = "Extractor.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {186, 201, 213}, m = "getUrl", n = {"url", "referer", "subtitleCallback", "callback", "tag", "ref", "uri", "realUrl", "baseUrl", "$this$getUrl_u24lambda_u242", "url", "referer", "subtitleCallback", "callback", "tag", "ref", "uri", "realUrl", "baseUrl", "href", "url", "referer", "subtitleCallback", "callback", "tag", "ref", "uri", "realUrl", "baseUrl", "href", "document", "size", "header", "headerDetails", "labelExtras", "quality"}, nl = {187, 202, 329}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "I$0"}, v = 2)
    static final class C00121 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
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

        C00121(Continuation<? super C00121> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HubCloud.this.getUrl(null, null, null, null, (Continuation) this);
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

    public void setMainUrl(@NotNull String str) {
        this.mainUrl = str;
    }

    public boolean getRequiresReferer() {
        return this.requiresReferer;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x036f  */
    /* JADX WARN: Code duplicated, block: B:104:0x0372  */
    /* JADX WARN: Code duplicated, block: B:106:0x03e5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:107:0x03e6  */
    /* JADX WARN: Code duplicated, block: B:110:0x03fc  */
    /* JADX WARN: Code duplicated, block: B:111:0x0401  */
    /* JADX WARN: Code duplicated, block: B:113:0x0405  */
    /* JADX WARN: Code duplicated, block: B:116:0x040e  */
    /* JADX WARN: Code duplicated, block: B:119:0x0417  */
    /* JADX WARN: Code duplicated, block: B:122:0x0438  */
    /* JADX WARN: Code duplicated, block: B:123:0x043b  */
    /* JADX WARN: Code duplicated, block: B:126:0x0443  */
    /* JADX WARN: Code duplicated, block: B:127:0x0462  */
    /* JADX WARN: Code duplicated, block: B:130:0x046f  */
    /* JADX WARN: Code duplicated, block: B:132:0x0473  */
    /* JADX WARN: Code duplicated, block: B:133:0x0492  */
    /* JADX WARN: Code duplicated, block: B:136:0x0522 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:137:0x0523  */
    /* JADX WARN: Code duplicated, block: B:142:0x0239 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:148:0x0268 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:0x024c  */
    /* JADX WARN: Code duplicated, block: B:51:0x0250  */
    /* JADX WARN: Code duplicated, block: B:57:0x025d  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:98:0x033d  */
    /* JADX WARN: Code duplicated, block: B:99:0x0340  */
    @Nullable
    public Object getUrl(@NotNull String url, @Nullable String referer, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        C00121 c00121;
        String ref;
        Object obj;
        String realUrl;
        C00121 c00122;
        boolean z;
        String strText;
        String url2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        String tag;
        String realUrl2;
        String tag2;
        Url uri;
        String baseUrl;
        Object obj2;
        Url $result;
        String tag3;
        String tag4;
        HubCloud $this$getUrl_u24lambda_u242;
        HubCloud $this$getUrl_u24lambda_u243;
        Url uri2;
        Object obj3;
        String realUrl3;
        String ref2;
        String tag5;
        Function1<? super ExtractorLink, Unit> function5;
        Function1<? super SubtitleFile, Unit> function6;
        String url3;
        Throwable it;
        String href;
        Function1<? super ExtractorLink, Unit> function7;
        String tag6;
        String realUrl4;
        String ref3;
        Object obj4;
        C00121 c00123;
        Url uri3;
        String tag7;
        String ref4;
        Function1<? super SubtitleFile, Unit> function8;
        String referer2;
        String baseUrl2;
        Element elementSelectFirst;
        String raw;
        Url uri4;
        Element elementSelectFirst2;
        String size;
        Element elementSelectFirst3;
        String headerDetails;
        StringBuilder $this$getUrl_u24lambda_u244;
        boolean z2;
        StringBuilder $this$getUrl_u24lambda_u245;
        List listSelect;
        C00132 c00132;
        if (continuation instanceof C00121) {
            c00121 = (C00121) continuation;
            if ((c00121.label & Integer.MIN_VALUE) != 0) {
                c00121.label -= Integer.MIN_VALUE;
            } else {
                c00121 = new C00121(continuation);
            }
        } else {
            c00121 = new C00121(continuation);
        }
        C00121 c00124 = c00121;
        Object $result2 = c00124.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00124.label) {
            case 0:
                ResultKt.throwOnFailure($result2);
                ref = referer == null ? "" : referer;
                try {
                    Result.Companion companion = Result.Companion;
                    HubCloud hubCloud = this;
                    obj = Result.constructor-impl(URLUtilsKt.Url(url));
                    break;
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                Throwable it2 = Result.exceptionOrNull-impl(obj);
                if (it2 != null) {
                    Log.INSTANCE.e("HubCloud", "Invalid URL: " + it2.getMessage());
                    return Unit.INSTANCE;
                }
                Url uri5 = (Url) obj;
                realUrl = uri5.toString();
                String baseUrl3 = uri5.getProtocol().getName() + "://" + uri5.getHost();
                try {
                    Result.Companion companion3 = Result.Companion;
                    HubCloud $this$getUrl_u24lambda_u246 = this;
                    try {
                        if (StringsKt.contains$default(realUrl, "hubcloud.php", false, 2, (Object) null)) {
                            url2 = url;
                            function4 = function2;
                            c00122 = c00124;
                            tag3 = "HubCloud";
                            tag4 = ref;
                            uri2 = uri5;
                            baseUrl = baseUrl3;
                            realUrl2 = realUrl;
                            strText = null;
                            z = false;
                            tag2 = referer;
                            function3 = function1;
                            try {
                                obj3 = Result.constructor-impl(realUrl);
                                ref2 = realUrl2;
                                realUrl3 = tag4;
                                tag5 = tag3;
                                function5 = function4;
                                function6 = function3;
                                url3 = url2;
                            } catch (Throwable th2) {
                                th = th2;
                                uri = uri2;
                                ref = tag4;
                                tag = tag3;
                                Result.Companion companion4 = Result.Companion;
                                obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                                String str = realUrl2;
                                realUrl3 = ref;
                                ref2 = str;
                                uri2 = uri;
                                tag5 = tag;
                                function5 = function4;
                                function6 = function3;
                                url3 = url2;
                            }
                            it = Result.exceptionOrNull-impl(obj3);
                            if (it != null) {
                                Log.INSTANCE.e(tag5, "Failed to extract href: " + it.getMessage());
                                obj3 = "";
                            }
                            href = (String) obj3;
                            if (StringsKt.isBlank(href)) {
                                return Unit.INSTANCE;
                            }
                            Requests app = MainActivityKt.getApp();
                            c00122.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                            c00122.L$1 = SpillingKt.nullOutSpilledVariable(tag2);
                            c00122.L$2 = function6;
                            c00122.L$3 = function5;
                            c00122.L$4 = tag5;
                            c00122.L$5 = realUrl3;
                            c00122.L$6 = SpillingKt.nullOutSpilledVariable(uri2);
                            c00122.L$7 = SpillingKt.nullOutSpilledVariable(ref2);
                            c00122.L$8 = SpillingKt.nullOutSpilledVariable(baseUrl);
                            c00122.L$9 = SpillingKt.nullOutSpilledVariable(href);
                            c00122.label = 2;
                            C00121 c00125 = c00122;
                            function7 = function5;
                            tag6 = tag5;
                            realUrl4 = href;
                            ref3 = realUrl3;
                            obj4 = Requests.get$default(app, realUrl4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00125, 4094, (Object) null);
                            c00123 = c00125;
                            if (obj4 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            uri3 = uri2;
                            tag7 = ref2;
                            ref4 = baseUrl;
                            function8 = function6;
                            $result2 = obj4;
                            referer2 = tag2;
                            baseUrl2 = tag6;
                            Document document = ((NiceResponse) $result2).getDocument();
                            elementSelectFirst2 = document.selectFirst("i#size");
                            if (elementSelectFirst2 != null) {
                                size = elementSelectFirst2.text();
                            } else {
                                size = strText;
                            }
                            if (size == null) {
                                size = "";
                            }
                            elementSelectFirst3 = document.selectFirst("div.card-header");
                            if (elementSelectFirst3 != null) {
                                strText = elementSelectFirst3.text();
                            }
                            String header = strText != null ? strText : "";
                            headerDetails = cleanTitle(header);
                            String ref5 = ref3;
                            int quality = getIndexQuality(header);
                            $this$getUrl_u24lambda_u244 = new StringBuilder();
                            if (headerDetails.length() > 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (z2) {
                                $this$getUrl_u24lambda_u245 = $this$getUrl_u24lambda_u244;
                                $this$getUrl_u24lambda_u245.append('[' + headerDetails + ']');
                            } else {
                                $this$getUrl_u24lambda_u245 = $this$getUrl_u24lambda_u244;
                            }
                            if (size.length() > 0) {
                                z = true;
                            }
                            if (z) {
                                $this$getUrl_u24lambda_u245.append('[' + size + ']');
                            }
                            String labelExtras = $this$getUrl_u24lambda_u244.toString();
                            listSelect = document.select("a.btn");
                            Function1<? super ExtractorLink, Unit> function9 = function7;
                            String tag8 = baseUrl2;
                            c00132 = new C00132(function9, ref5, labelExtras, tag8, this, function8, quality, null);
                            c00123.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                            c00123.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                            c00123.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                            c00123.L$3 = SpillingKt.nullOutSpilledVariable(function9);
                            c00123.L$4 = SpillingKt.nullOutSpilledVariable(tag8);
                            c00123.L$5 = SpillingKt.nullOutSpilledVariable(ref5);
                            c00123.L$6 = SpillingKt.nullOutSpilledVariable(uri3);
                            c00123.L$7 = SpillingKt.nullOutSpilledVariable(tag7);
                            c00123.L$8 = SpillingKt.nullOutSpilledVariable(ref4);
                            c00123.L$9 = SpillingKt.nullOutSpilledVariable(realUrl4);
                            c00123.L$10 = SpillingKt.nullOutSpilledVariable(document);
                            c00123.L$11 = SpillingKt.nullOutSpilledVariable(size);
                            c00123.L$12 = SpillingKt.nullOutSpilledVariable(header);
                            c00123.L$13 = SpillingKt.nullOutSpilledVariable(headerDetails);
                            c00123.L$14 = SpillingKt.nullOutSpilledVariable(labelExtras);
                            c00123.I$0 = quality;
                            c00123.label = 3;
                            if (ParCollectionsKt.amap(listSelect, c00132, c00123) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        }
                        Requests app2 = MainActivityKt.getApp();
                        c00124.L$0 = SpillingKt.nullOutSpilledVariable(url);
                        c00124.L$1 = SpillingKt.nullOutSpilledVariable(referer);
                        c00124.L$2 = function1;
                        c00124.L$3 = function2;
                        c00124.L$4 = "HubCloud";
                        c00124.L$5 = ref;
                        c00124.L$6 = SpillingKt.nullOutSpilledVariable(uri5);
                        c00124.L$7 = SpillingKt.nullOutSpilledVariable(realUrl);
                        c00124.L$8 = baseUrl3;
                        c00124.L$9 = SpillingKt.nullOutSpilledVariable($this$getUrl_u24lambda_u246);
                        c00124.label = 1;
                        strText = null;
                        try {
                            obj2 = Requests.get$default(app2, realUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00124, 4094, (Object) null);
                            c00122 = c00124;
                            if (obj2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            baseUrl = baseUrl3;
                            $result = uri5;
                            url2 = url;
                            function3 = function1;
                            function4 = function2;
                            tag3 = "HubCloud";
                            tag4 = ref;
                            tag2 = referer;
                            $this$getUrl_u24lambda_u242 = $this$getUrl_u24lambda_u246;
                            $this$getUrl_u24lambda_u243 = null;
                            try {
                                elementSelectFirst = ((NiceResponse) obj2).getDocument().selectFirst("a[href*='hubcloud.php']");
                                if (elementSelectFirst != null) {
                                    try {
                                        raw = elementSelectFirst.attr("href");
                                    } catch (Throwable th3) {
                                        th = th3;
                                        realUrl2 = realUrl;
                                        ref = tag4;
                                        tag = tag3;
                                        z = false;
                                        uri = $result;
                                    }
                                } else {
                                    raw = strText;
                                }
                                if (raw == null) {
                                    raw = "";
                                }
                                uri4 = $result;
                                try {
                                    if (StringsKt.startsWith(raw, "http", true)) {
                                        realUrl2 = realUrl;
                                        z = false;
                                        realUrl = raw;
                                        uri2 = uri4;
                                    } else {
                                        try {
                                            StringBuilder sb = new StringBuilder();
                                            try {
                                                char[] cArr = new char[1];
                                                z = false;
                                                try {
                                                    cArr[0] = '/';
                                                    StringBuilder sbAppend = sb.append(StringsKt.trimEnd(baseUrl, cArr)).append('/');
                                                    try {
                                                        char[] cArr2 = new char[1];
                                                        z = false;
                                                        try {
                                                            cArr2[0] = '/';
                                                            String string = sbAppend.append(StringsKt.trimStart(raw, cArr2)).toString();
                                                            uri2 = uri4;
                                                            realUrl2 = realUrl;
                                                            realUrl = string;
                                                        } catch (Throwable th4) {
                                                            th = th4;
                                                            realUrl2 = realUrl;
                                                            ref = tag4;
                                                            tag = tag3;
                                                            uri = uri4;
                                                        }
                                                    } catch (Throwable th5) {
                                                        th = th5;
                                                        z = false;
                                                        realUrl2 = realUrl;
                                                        ref = tag4;
                                                        tag = tag3;
                                                        uri = uri4;
                                                        Result.Companion companion5 = Result.Companion;
                                                        obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                                                        String str2 = realUrl2;
                                                        realUrl3 = ref;
                                                        ref2 = str2;
                                                        uri2 = uri;
                                                        tag5 = tag;
                                                        function5 = function4;
                                                        function6 = function3;
                                                        url3 = url2;
                                                        it = Result.exceptionOrNull-impl(obj3);
                                                        if (it != null) {
                                                            Log.INSTANCE.e(tag5, "Failed to extract href: " + it.getMessage());
                                                            obj3 = "";
                                                        }
                                                        href = (String) obj3;
                                                        if (StringsKt.isBlank(href)) {
                                                            return Unit.INSTANCE;
                                                        }
                                                        Requests app3 = MainActivityKt.getApp();
                                                        c00122.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                                                        c00122.L$1 = SpillingKt.nullOutSpilledVariable(tag2);
                                                        c00122.L$2 = function6;
                                                        c00122.L$3 = function5;
                                                        c00122.L$4 = tag5;
                                                        c00122.L$5 = realUrl3;
                                                        c00122.L$6 = SpillingKt.nullOutSpilledVariable(uri2);
                                                        c00122.L$7 = SpillingKt.nullOutSpilledVariable(ref2);
                                                        c00122.L$8 = SpillingKt.nullOutSpilledVariable(baseUrl);
                                                        c00122.L$9 = SpillingKt.nullOutSpilledVariable(href);
                                                        c00122.label = 2;
                                                        C00121 c00126 = c00122;
                                                        function7 = function5;
                                                        tag6 = tag5;
                                                        realUrl4 = href;
                                                        ref3 = realUrl3;
                                                        obj4 = Requests.get$default(app3, realUrl4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00126, 4094, (Object) null);
                                                        c00123 = c00126;
                                                        if (obj4 == coroutine_suspended) {
                                                            return coroutine_suspended;
                                                        }
                                                        uri3 = uri2;
                                                        tag7 = ref2;
                                                        ref4 = baseUrl;
                                                        function8 = function6;
                                                        $result2 = obj4;
                                                        referer2 = tag2;
                                                        baseUrl2 = tag6;
                                                        Document document2 = ((NiceResponse) $result2).getDocument();
                                                        elementSelectFirst2 = document2.selectFirst("i#size");
                                                        if (elementSelectFirst2 != null) {
                                                            size = elementSelectFirst2.text();
                                                        } else {
                                                            size = strText;
                                                        }
                                                        if (size == null) {
                                                            size = "";
                                                        }
                                                        elementSelectFirst3 = document2.selectFirst("div.card-header");
                                                        if (elementSelectFirst3 != null) {
                                                            strText = elementSelectFirst3.text();
                                                        }
                                                        String header2 = strText != null ? strText : "";
                                                        headerDetails = cleanTitle(header2);
                                                        String ref6 = ref3;
                                                        int quality2 = getIndexQuality(header2);
                                                        $this$getUrl_u24lambda_u244 = new StringBuilder();
                                                        if (headerDetails.length() > 0) {
                                                            z2 = true;
                                                        } else {
                                                            z2 = false;
                                                        }
                                                        if (z2) {
                                                            $this$getUrl_u24lambda_u245 = $this$getUrl_u24lambda_u244;
                                                            $this$getUrl_u24lambda_u245.append('[' + headerDetails + ']');
                                                        } else {
                                                            $this$getUrl_u24lambda_u245 = $this$getUrl_u24lambda_u244;
                                                        }
                                                        if (size.length() > 0) {
                                                            z = true;
                                                        }
                                                        if (z) {
                                                            $this$getUrl_u24lambda_u245.append('[' + size + ']');
                                                        }
                                                        String labelExtras2 = $this$getUrl_u24lambda_u244.toString();
                                                        listSelect = document2.select("a.btn");
                                                        Function1<? super ExtractorLink, Unit> function10 = function7;
                                                        String tag9 = baseUrl2;
                                                        c00132 = new C00132(function10, ref6, labelExtras2, tag9, this, function8, quality2, null);
                                                        c00123.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                                                        c00123.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                                                        c00123.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                                        c00123.L$3 = SpillingKt.nullOutSpilledVariable(function10);
                                                        c00123.L$4 = SpillingKt.nullOutSpilledVariable(tag9);
                                                        c00123.L$5 = SpillingKt.nullOutSpilledVariable(ref6);
                                                        c00123.L$6 = SpillingKt.nullOutSpilledVariable(uri3);
                                                        c00123.L$7 = SpillingKt.nullOutSpilledVariable(tag7);
                                                        c00123.L$8 = SpillingKt.nullOutSpilledVariable(ref4);
                                                        c00123.L$9 = SpillingKt.nullOutSpilledVariable(realUrl4);
                                                        c00123.L$10 = SpillingKt.nullOutSpilledVariable(document2);
                                                        c00123.L$11 = SpillingKt.nullOutSpilledVariable(size);
                                                        c00123.L$12 = SpillingKt.nullOutSpilledVariable(header2);
                                                        c00123.L$13 = SpillingKt.nullOutSpilledVariable(headerDetails);
                                                        c00123.L$14 = SpillingKt.nullOutSpilledVariable(labelExtras2);
                                                        c00123.I$0 = quality2;
                                                        c00123.label = 3;
                                                        if (ParCollectionsKt.amap(listSelect, c00132, c00123) == coroutine_suspended) {
                                                            return coroutine_suspended;
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                } catch (Throwable th6) {
                                                    th = th6;
                                                }
                                            } catch (Throwable th7) {
                                                th = th7;
                                            }
                                        } catch (Throwable th8) {
                                            th = th8;
                                        }
                                    }
                                    obj3 = Result.constructor-impl(realUrl);
                                    ref2 = realUrl2;
                                    realUrl3 = tag4;
                                    tag5 = tag3;
                                    function5 = function4;
                                    function6 = function3;
                                    url3 = url2;
                                } catch (Throwable th9) {
                                    th = th9;
                                }
                                break;
                            } catch (Throwable th10) {
                                th = th10;
                                z = false;
                                realUrl2 = realUrl;
                                ref = tag4;
                                tag = tag3;
                                uri = $result;
                            }
                            it = Result.exceptionOrNull-impl(obj3);
                            if (it != null) {
                                Log.INSTANCE.e(tag5, "Failed to extract href: " + it.getMessage());
                                obj3 = "";
                            }
                            href = (String) obj3;
                            if (StringsKt.isBlank(href)) {
                                return Unit.INSTANCE;
                            }
                            Requests app4 = MainActivityKt.getApp();
                            c00122.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                            c00122.L$1 = SpillingKt.nullOutSpilledVariable(tag2);
                            c00122.L$2 = function6;
                            c00122.L$3 = function5;
                            c00122.L$4 = tag5;
                            c00122.L$5 = realUrl3;
                            c00122.L$6 = SpillingKt.nullOutSpilledVariable(uri2);
                            c00122.L$7 = SpillingKt.nullOutSpilledVariable(ref2);
                            c00122.L$8 = SpillingKt.nullOutSpilledVariable(baseUrl);
                            c00122.L$9 = SpillingKt.nullOutSpilledVariable(href);
                            c00122.label = 2;
                            C00121 c00127 = c00122;
                            function7 = function5;
                            tag6 = tag5;
                            realUrl4 = href;
                            ref3 = realUrl3;
                            obj4 = Requests.get$default(app4, realUrl4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00127, 4094, (Object) null);
                            c00123 = c00127;
                            if (obj4 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            uri3 = uri2;
                            tag7 = ref2;
                            ref4 = baseUrl;
                            function8 = function6;
                            $result2 = obj4;
                            referer2 = tag2;
                            baseUrl2 = tag6;
                            Document document3 = ((NiceResponse) $result2).getDocument();
                            elementSelectFirst2 = document3.selectFirst("i#size");
                            if (elementSelectFirst2 != null) {
                                size = elementSelectFirst2.text();
                            } else {
                                size = strText;
                            }
                            if (size == null) {
                                size = "";
                            }
                            elementSelectFirst3 = document3.selectFirst("div.card-header");
                            if (elementSelectFirst3 != null) {
                                strText = elementSelectFirst3.text();
                            }
                            String header3 = strText != null ? strText : "";
                            headerDetails = cleanTitle(header3);
                            String ref7 = ref3;
                            int quality3 = getIndexQuality(header3);
                            $this$getUrl_u24lambda_u244 = new StringBuilder();
                            if (headerDetails.length() > 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (z2) {
                                $this$getUrl_u24lambda_u245 = $this$getUrl_u24lambda_u244;
                                $this$getUrl_u24lambda_u245.append('[' + headerDetails + ']');
                            } else {
                                $this$getUrl_u24lambda_u245 = $this$getUrl_u24lambda_u244;
                            }
                            if (size.length() > 0) {
                                z = true;
                            }
                            if (z) {
                                $this$getUrl_u24lambda_u245.append('[' + size + ']');
                            }
                            String labelExtras3 = $this$getUrl_u24lambda_u244.toString();
                            listSelect = document3.select("a.btn");
                            Function1<? super ExtractorLink, Unit> function11 = function7;
                            String tag10 = baseUrl2;
                            c00132 = new C00132(function11, ref7, labelExtras3, tag10, this, function8, quality3, null);
                            c00123.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                            c00123.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                            c00123.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                            c00123.L$3 = SpillingKt.nullOutSpilledVariable(function11);
                            c00123.L$4 = SpillingKt.nullOutSpilledVariable(tag10);
                            c00123.L$5 = SpillingKt.nullOutSpilledVariable(ref7);
                            c00123.L$6 = SpillingKt.nullOutSpilledVariable(uri3);
                            c00123.L$7 = SpillingKt.nullOutSpilledVariable(tag7);
                            c00123.L$8 = SpillingKt.nullOutSpilledVariable(ref4);
                            c00123.L$9 = SpillingKt.nullOutSpilledVariable(realUrl4);
                            c00123.L$10 = SpillingKt.nullOutSpilledVariable(document3);
                            c00123.L$11 = SpillingKt.nullOutSpilledVariable(size);
                            c00123.L$12 = SpillingKt.nullOutSpilledVariable(header3);
                            c00123.L$13 = SpillingKt.nullOutSpilledVariable(headerDetails);
                            c00123.L$14 = SpillingKt.nullOutSpilledVariable(labelExtras3);
                            c00123.I$0 = quality3;
                            c00123.label = 3;
                            if (ParCollectionsKt.amap(listSelect, c00132, c00123) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        } catch (Throwable th11) {
                            th = th11;
                            c00122 = c00124;
                            z = false;
                            url2 = url;
                            function3 = function1;
                            function4 = function2;
                            tag = "HubCloud";
                            realUrl2 = realUrl;
                            tag2 = referer;
                            uri = uri5;
                            baseUrl = baseUrl3;
                        }
                    } catch (Throwable th12) {
                        th = th12;
                        c00122 = c00124;
                        strText = null;
                        z = false;
                        url2 = url;
                        function3 = function1;
                        function4 = function2;
                        tag = "HubCloud";
                        realUrl2 = realUrl;
                        tag2 = referer;
                        uri = uri5;
                        baseUrl = baseUrl3;
                    }
                } catch (Throwable th13) {
                    th = th13;
                    c00122 = c00124;
                    z = false;
                    strText = null;
                    url2 = url;
                    function3 = function1;
                    function4 = function2;
                    tag = "HubCloud";
                    realUrl2 = realUrl;
                    tag2 = referer;
                    uri = uri5;
                    baseUrl = baseUrl3;
                }
                Result.Companion companion6 = Result.Companion;
                obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                String str3 = realUrl2;
                realUrl3 = ref;
                ref2 = str3;
                uri2 = uri;
                tag5 = tag;
                function5 = function4;
                function6 = function3;
                url3 = url2;
                it = Result.exceptionOrNull-impl(obj3);
                if (it != null) {
                    Log.INSTANCE.e(tag5, "Failed to extract href: " + it.getMessage());
                    obj3 = "";
                }
                href = (String) obj3;
                if (StringsKt.isBlank(href)) {
                    return Unit.INSTANCE;
                }
                Requests app5 = MainActivityKt.getApp();
                c00122.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                c00122.L$1 = SpillingKt.nullOutSpilledVariable(tag2);
                c00122.L$2 = function6;
                c00122.L$3 = function5;
                c00122.L$4 = tag5;
                c00122.L$5 = realUrl3;
                c00122.L$6 = SpillingKt.nullOutSpilledVariable(uri2);
                c00122.L$7 = SpillingKt.nullOutSpilledVariable(ref2);
                c00122.L$8 = SpillingKt.nullOutSpilledVariable(baseUrl);
                c00122.L$9 = SpillingKt.nullOutSpilledVariable(href);
                c00122.label = 2;
                C00121 c00128 = c00122;
                function7 = function5;
                tag6 = tag5;
                realUrl4 = href;
                ref3 = realUrl3;
                obj4 = Requests.get$default(app5, realUrl4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00128, 4094, (Object) null);
                c00123 = c00128;
                if (obj4 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                uri3 = uri2;
                tag7 = ref2;
                ref4 = baseUrl;
                function8 = function6;
                $result2 = obj4;
                referer2 = tag2;
                baseUrl2 = tag6;
                Document document4 = ((NiceResponse) $result2).getDocument();
                elementSelectFirst2 = document4.selectFirst("i#size");
                if (elementSelectFirst2 != null) {
                    size = elementSelectFirst2.text();
                } else {
                    size = strText;
                }
                if (size == null) {
                    size = "";
                }
                elementSelectFirst3 = document4.selectFirst("div.card-header");
                if (elementSelectFirst3 != null) {
                    strText = elementSelectFirst3.text();
                }
                String header4 = strText != null ? strText : "";
                headerDetails = cleanTitle(header4);
                String ref8 = ref3;
                int quality4 = getIndexQuality(header4);
                $this$getUrl_u24lambda_u244 = new StringBuilder();
                if (headerDetails.length() > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    $this$getUrl_u24lambda_u245 = $this$getUrl_u24lambda_u244;
                    $this$getUrl_u24lambda_u245.append('[' + headerDetails + ']');
                } else {
                    $this$getUrl_u24lambda_u245 = $this$getUrl_u24lambda_u244;
                }
                if (size.length() > 0) {
                    z = true;
                }
                if (z) {
                    $this$getUrl_u24lambda_u245.append('[' + size + ']');
                }
                String labelExtras4 = $this$getUrl_u24lambda_u244.toString();
                listSelect = document4.select("a.btn");
                Function1<? super ExtractorLink, Unit> function12 = function7;
                String tag11 = baseUrl2;
                c00132 = new C00132(function12, ref8, labelExtras4, tag11, this, function8, quality4, null);
                c00123.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                c00123.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                c00123.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                c00123.L$3 = SpillingKt.nullOutSpilledVariable(function12);
                c00123.L$4 = SpillingKt.nullOutSpilledVariable(tag11);
                c00123.L$5 = SpillingKt.nullOutSpilledVariable(ref8);
                c00123.L$6 = SpillingKt.nullOutSpilledVariable(uri3);
                c00123.L$7 = SpillingKt.nullOutSpilledVariable(tag7);
                c00123.L$8 = SpillingKt.nullOutSpilledVariable(ref4);
                c00123.L$9 = SpillingKt.nullOutSpilledVariable(realUrl4);
                c00123.L$10 = SpillingKt.nullOutSpilledVariable(document4);
                c00123.L$11 = SpillingKt.nullOutSpilledVariable(size);
                c00123.L$12 = SpillingKt.nullOutSpilledVariable(header4);
                c00123.L$13 = SpillingKt.nullOutSpilledVariable(headerDetails);
                c00123.L$14 = SpillingKt.nullOutSpilledVariable(labelExtras4);
                c00123.I$0 = quality4;
                c00123.label = 3;
                if (ParCollectionsKt.amap(listSelect, c00132, c00123) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                $this$getUrl_u24lambda_u242 = (HubCloud) c00124.L$9;
                baseUrl = (String) c00124.L$8;
                realUrl2 = (String) c00124.L$7;
                uri = (Url) c00124.L$6;
                String ref9 = (String) c00124.L$5;
                tag = (String) c00124.L$4;
                function4 = (Function1) c00124.L$3;
                function3 = (Function1) c00124.L$2;
                tag2 = (String) c00124.L$1;
                url2 = (String) c00124.L$0;
                try {
                    ResultKt.throwOnFailure($result2);
                    tag3 = tag;
                    $this$getUrl_u24lambda_u243 = null;
                    strText = null;
                    $result = uri;
                    tag4 = ref9;
                    c00122 = c00124;
                    realUrl = realUrl2;
                    obj2 = $result2;
                    elementSelectFirst = ((NiceResponse) obj2).getDocument().selectFirst("a[href*='hubcloud.php']");
                    if (elementSelectFirst != null) {
                        raw = elementSelectFirst.attr("href");
                    } else {
                        raw = strText;
                    }
                    if (raw == null) {
                        raw = "";
                    }
                    uri4 = $result;
                    if (StringsKt.startsWith(raw, "http", true)) {
                        realUrl2 = realUrl;
                        z = false;
                        realUrl = raw;
                        uri2 = uri4;
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        char[] cArr3 = new char[1];
                        z = false;
                        cArr3[0] = '/';
                        StringBuilder sbAppend2 = sb2.append(StringsKt.trimEnd(baseUrl, cArr3)).append('/');
                        char[] cArr4 = new char[1];
                        z = false;
                        cArr4[0] = '/';
                        String string2 = sbAppend2.append(StringsKt.trimStart(raw, cArr4)).toString();
                        uri2 = uri4;
                        realUrl2 = realUrl;
                        realUrl = string2;
                    }
                    obj3 = Result.constructor-impl(realUrl);
                    ref2 = realUrl2;
                    realUrl3 = tag4;
                    tag5 = tag3;
                    function5 = function4;
                    function6 = function3;
                    url3 = url2;
                    break;
                } catch (Throwable th14) {
                    th = th14;
                    ref = ref9;
                    z = false;
                    strText = null;
                    c00122 = c00124;
                    break;
                }
                it = Result.exceptionOrNull-impl(obj3);
                if (it != null) {
                    Log.INSTANCE.e(tag5, "Failed to extract href: " + it.getMessage());
                    obj3 = "";
                }
                href = (String) obj3;
                if (StringsKt.isBlank(href)) {
                    return Unit.INSTANCE;
                }
                Requests app6 = MainActivityKt.getApp();
                c00122.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                c00122.L$1 = SpillingKt.nullOutSpilledVariable(tag2);
                c00122.L$2 = function6;
                c00122.L$3 = function5;
                c00122.L$4 = tag5;
                c00122.L$5 = realUrl3;
                c00122.L$6 = SpillingKt.nullOutSpilledVariable(uri2);
                c00122.L$7 = SpillingKt.nullOutSpilledVariable(ref2);
                c00122.L$8 = SpillingKt.nullOutSpilledVariable(baseUrl);
                c00122.L$9 = SpillingKt.nullOutSpilledVariable(href);
                c00122.label = 2;
                C00121 c00129 = c00122;
                function7 = function5;
                tag6 = tag5;
                realUrl4 = href;
                ref3 = realUrl3;
                obj4 = Requests.get$default(app6, realUrl4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00129, 4094, (Object) null);
                c00123 = c00129;
                if (obj4 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                uri3 = uri2;
                tag7 = ref2;
                ref4 = baseUrl;
                function8 = function6;
                $result2 = obj4;
                referer2 = tag2;
                baseUrl2 = tag6;
                Document document5 = ((NiceResponse) $result2).getDocument();
                elementSelectFirst2 = document5.selectFirst("i#size");
                if (elementSelectFirst2 != null) {
                    size = elementSelectFirst2.text();
                } else {
                    size = strText;
                }
                if (size == null) {
                    size = "";
                }
                elementSelectFirst3 = document5.selectFirst("div.card-header");
                if (elementSelectFirst3 != null) {
                    strText = elementSelectFirst3.text();
                }
                String header5 = strText != null ? strText : "";
                headerDetails = cleanTitle(header5);
                String ref10 = ref3;
                int quality5 = getIndexQuality(header5);
                $this$getUrl_u24lambda_u244 = new StringBuilder();
                if (headerDetails.length() > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    $this$getUrl_u24lambda_u245 = $this$getUrl_u24lambda_u244;
                    $this$getUrl_u24lambda_u245.append('[' + headerDetails + ']');
                } else {
                    $this$getUrl_u24lambda_u245 = $this$getUrl_u24lambda_u244;
                }
                if (size.length() > 0) {
                    z = true;
                }
                if (z) {
                    $this$getUrl_u24lambda_u245.append('[' + size + ']');
                }
                String labelExtras5 = $this$getUrl_u24lambda_u244.toString();
                listSelect = document5.select("a.btn");
                Function1<? super ExtractorLink, Unit> function13 = function7;
                String tag12 = baseUrl2;
                c00132 = new C00132(function13, ref10, labelExtras5, tag12, this, function8, quality5, null);
                c00123.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                c00123.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                c00123.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                c00123.L$3 = SpillingKt.nullOutSpilledVariable(function13);
                c00123.L$4 = SpillingKt.nullOutSpilledVariable(tag12);
                c00123.L$5 = SpillingKt.nullOutSpilledVariable(ref10);
                c00123.L$6 = SpillingKt.nullOutSpilledVariable(uri3);
                c00123.L$7 = SpillingKt.nullOutSpilledVariable(tag7);
                c00123.L$8 = SpillingKt.nullOutSpilledVariable(ref4);
                c00123.L$9 = SpillingKt.nullOutSpilledVariable(realUrl4);
                c00123.L$10 = SpillingKt.nullOutSpilledVariable(document5);
                c00123.L$11 = SpillingKt.nullOutSpilledVariable(size);
                c00123.L$12 = SpillingKt.nullOutSpilledVariable(header5);
                c00123.L$13 = SpillingKt.nullOutSpilledVariable(headerDetails);
                c00123.L$14 = SpillingKt.nullOutSpilledVariable(labelExtras5);
                c00123.I$0 = quality5;
                c00123.label = 3;
                if (ParCollectionsKt.amap(listSelect, c00132, c00123) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 2:
                String href2 = (String) c00124.L$9;
                String baseUrl4 = (String) c00124.L$8;
                String realUrl5 = (String) c00124.L$7;
                Url uri6 = (Url) c00124.L$6;
                String ref11 = (String) c00124.L$5;
                String tag13 = (String) c00124.L$4;
                Function1<? super ExtractorLink, Unit> function14 = (Function1) c00124.L$3;
                Function1<? super SubtitleFile, Unit> function15 = (Function1) c00124.L$2;
                String referer3 = (String) c00124.L$1;
                String url4 = (String) c00124.L$0;
                ResultKt.throwOnFailure($result2);
                referer2 = referer3;
                function8 = function15;
                url3 = url4;
                function7 = function14;
                z = false;
                strText = null;
                uri3 = uri6;
                c00123 = c00124;
                ref3 = ref11;
                ref4 = baseUrl4;
                baseUrl2 = tag13;
                tag7 = realUrl5;
                realUrl4 = href2;
                Document document6 = ((NiceResponse) $result2).getDocument();
                elementSelectFirst2 = document6.selectFirst("i#size");
                if (elementSelectFirst2 != null) {
                    size = elementSelectFirst2.text();
                } else {
                    size = strText;
                }
                if (size == null) {
                    size = "";
                }
                elementSelectFirst3 = document6.selectFirst("div.card-header");
                if (elementSelectFirst3 != null) {
                    strText = elementSelectFirst3.text();
                }
                String header6 = strText != null ? strText : "";
                headerDetails = cleanTitle(header6);
                String ref12 = ref3;
                int quality6 = getIndexQuality(header6);
                $this$getUrl_u24lambda_u244 = new StringBuilder();
                if (headerDetails.length() > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    $this$getUrl_u24lambda_u245 = $this$getUrl_u24lambda_u244;
                    $this$getUrl_u24lambda_u245.append('[' + headerDetails + ']');
                } else {
                    $this$getUrl_u24lambda_u245 = $this$getUrl_u24lambda_u244;
                }
                if (size.length() > 0) {
                    z = true;
                }
                if (z) {
                    $this$getUrl_u24lambda_u245.append('[' + size + ']');
                }
                String labelExtras6 = $this$getUrl_u24lambda_u244.toString();
                listSelect = document6.select("a.btn");
                Function1<? super ExtractorLink, Unit> function16 = function7;
                String tag14 = baseUrl2;
                c00132 = new C00132(function16, ref12, labelExtras6, tag14, this, function8, quality6, null);
                c00123.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                c00123.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                c00123.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                c00123.L$3 = SpillingKt.nullOutSpilledVariable(function16);
                c00123.L$4 = SpillingKt.nullOutSpilledVariable(tag14);
                c00123.L$5 = SpillingKt.nullOutSpilledVariable(ref12);
                c00123.L$6 = SpillingKt.nullOutSpilledVariable(uri3);
                c00123.L$7 = SpillingKt.nullOutSpilledVariable(tag7);
                c00123.L$8 = SpillingKt.nullOutSpilledVariable(ref4);
                c00123.L$9 = SpillingKt.nullOutSpilledVariable(realUrl4);
                c00123.L$10 = SpillingKt.nullOutSpilledVariable(document6);
                c00123.L$11 = SpillingKt.nullOutSpilledVariable(size);
                c00123.L$12 = SpillingKt.nullOutSpilledVariable(header6);
                c00123.L$13 = SpillingKt.nullOutSpilledVariable(headerDetails);
                c00123.L$14 = SpillingKt.nullOutSpilledVariable(labelExtras6);
                c00123.I$0 = quality6;
                c00123.label = 3;
                if (ParCollectionsKt.amap(listSelect, c00132, c00123) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 3:
                int i = c00124.I$0;
                ResultKt.throwOnFailure($result2);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.fourKHDHub.HubCloud$getUrl$2 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "element", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.fourKHDHub.HubCloud$getUrl$2", f = "Extractor.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9, 10, 10, 10, 10, 10, 11, 11, 11, 11}, l = {221, 231, 240, 246, 264, 274, 284, 294, 304, 313, 316, 325}, m = "invokeSuspend", n = {"element", "link", "text", "label", "element", "link", "text", "label", "element", "link", "text", "label", "element", "link", "text", "label", "resp", "dlink", "element", "link", "text", "label", "base", "finalUrl", "element", "link", "text", "label", "element", "link", "text", "label", "element", "link", "text", "label", "element", "link", "text", "label", "element", "link", "text", "label", "element", "link", "text", "label", "redirectUrl", "element", "link", "text", "label"}, nl = {220, 230, 241, 245, 263, 273, 283, 293, 303, 314, 315, 328}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3"}, v = 2)
    static final class C00132 extends SuspendLambda implements Function2<Element, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ String $labelExtras;
        final /* synthetic */ int $quality;
        final /* synthetic */ String $ref;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        final /* synthetic */ String $tag;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        final /* synthetic */ HubCloud this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00132(Function1<? super ExtractorLink, Unit> function1, String str, String str2, String str3, HubCloud hubCloud, Function1<? super SubtitleFile, Unit> function2, int i, Continuation<? super C00132> continuation) {
            super(2, continuation);
            this.$callback = function1;
            this.$ref = str;
            this.$labelExtras = str2;
            this.$tag = str3;
            this.this$0 = hubCloud;
            this.$subtitleCallback = function2;
            this.$quality = i;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00132 = new C00132(this.$callback, this.$ref, this.$labelExtras, this.$tag, this.this$0, this.$subtitleCallback, this.$quality, continuation);
            c00132.L$0 = obj;
            return c00132;
        }

        public final Object invoke(Element element, Continuation<? super Unit> continuation) {
            return create(element, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:101:0x0606  */
        /* JADX WARN: Code duplicated, block: B:103:0x0614  */
        /* JADX WARN: Code duplicated, block: B:106:0x068a A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:107:0x068b  */
        /* JADX WARN: Code duplicated, block: B:40:0x02c4  */
        /* JADX WARN: Code duplicated, block: B:43:0x02d1  */
        /* JADX WARN: Code duplicated, block: B:44:0x02d3  */
        /* JADX WARN: Code duplicated, block: B:47:0x02de  */
        /* JADX WARN: Code duplicated, block: B:49:0x0354 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:50:0x0355  */
        /* JADX WARN: Code duplicated, block: B:52:0x0360  */
        /* JADX WARN: Code duplicated, block: B:99:0x0603  */
        public final Object invokeSuspend(Object $result) {
            String link;
            Function1<ExtractorLink, Unit> function1;
            Object obj;
            String link2;
            String label;
            String text;
            Object objResolveFinalUrl;
            String link3;
            String redirectUrl;
            Function1<ExtractorLink, Unit> function2;
            Object obj2;
            String link4;
            String text2;
            String text3;
            Function1<ExtractorLink, Unit> function3;
            Object obj3;
            String link5;
            String text4;
            String text5;
            Function1<ExtractorLink, Unit> function4;
            Object obj4;
            String link6;
            String text6;
            String text7;
            Function1<ExtractorLink, Unit> function5;
            Object obj5;
            String link7;
            String text8;
            String text9;
            Object obj6;
            String link8;
            String text10;
            String text11;
            Function1<ExtractorLink, Unit> function6;
            Object obj7;
            String link9;
            String text12;
            String text13;
            Function1<ExtractorLink, Unit> function7;
            Object obj8;
            String link10;
            String text14;
            String text15;
            NiceResponse resp;
            String str;
            String dlink;
            Function1<ExtractorLink, Unit> function8;
            Object objNewExtractorLink$default;
            Function1<ExtractorLink, Unit> function9;
            String label2;
            String str2;
            String redirectUrl2;
            Function1<ExtractorLink, Unit> function10;
            Object objNewExtractorLink$default2;
            Function1<ExtractorLink, Unit> function11;
            Object obj9;
            String text16;
            Element element = (Element) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            String str3 = "";
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    link = element.attr("href");
                    String text17 = element.ownText();
                    String label3 = text17.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(label3, "toLowerCase(...)");
                    if (StringsKt.contains$default(label3, "fsl server", false, 2, (Object) null)) {
                        Function1<ExtractorLink, Unit> function12 = this.$callback;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(element);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(link);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(text17);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(label3);
                        this.L$4 = function12;
                        this.label = 1;
                        Object objNewExtractorLink$default3 = ExtractorApiKt.newExtractorLink$default(this.$ref + " [FSL Server]", this.$ref + " [FSL Server] " + this.$labelExtras, link, (ExtractorLinkType) null, new AnonymousClass1(this.$quality, null), (Continuation) this, 8, (Object) null);
                        if (objNewExtractorLink$default3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function7 = function12;
                        obj8 = objNewExtractorLink$default3;
                        link10 = link;
                        text14 = text17;
                        text15 = label3;
                        function7.invoke(obj8);
                        Unit unit = Unit.INSTANCE;
                    } else if (StringsKt.contains$default(label3, "download file", false, 2, (Object) null)) {
                        Function1<ExtractorLink, Unit> function13 = this.$callback;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(element);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(link);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(text17);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(label3);
                        this.L$4 = function13;
                        this.label = 2;
                        Object objNewExtractorLink$default4 = ExtractorApiKt.newExtractorLink$default(this.$ref, this.$ref + ' ' + this.$labelExtras, link, (ExtractorLinkType) null, new AnonymousClass2(this.$quality, null), (Continuation) this, 8, (Object) null);
                        if (objNewExtractorLink$default4 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function6 = function13;
                        obj7 = objNewExtractorLink$default4;
                        link9 = link;
                        text12 = text17;
                        text13 = label3;
                        function6.invoke(obj7);
                        Unit unit2 = Unit.INSTANCE;
                    } else if (StringsKt.contains$default(label3, "buzzserver", false, 2, (Object) null)) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(element);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(link);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(text17);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(label3);
                        this.label = 3;
                        obj6 = Requests.get$default(MainActivityKt.getApp(), link + "/download", (Map) null, link, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4058, (Object) null);
                        if (obj6 == coroutine_suspended) {
                            link8 = link;
                            return coroutine_suspended;
                        }
                        link8 = link;
                        text10 = text17;
                        text11 = label3;
                        resp = (NiceResponse) obj6;
                        str = resp.getHeaders().get("hx-redirect");
                        if (str == null) {
                            str2 = resp.getHeaders().get("HX-Redirect");
                            if (str2 != null) {
                                str3 = str2;
                            }
                        } else {
                            str3 = str;
                        }
                        dlink = str3;
                        if (StringsKt.isBlank(dlink)) {
                            Log.INSTANCE.w(this.$tag, "BuzzServer: No redirect");
                        } else {
                            function8 = this.$callback;
                            this.L$0 = SpillingKt.nullOutSpilledVariable(element);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(link8);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(text10);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(text11);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(resp);
                            this.L$5 = SpillingKt.nullOutSpilledVariable(dlink);
                            this.L$6 = function8;
                            this.label = 4;
                            objNewExtractorLink$default = ExtractorApiKt.newExtractorLink$default(this.$ref + " [BuzzServer]", this.$ref + " [BuzzServer] " + this.$labelExtras, dlink, (ExtractorLinkType) null, new AnonymousClass3(this.$quality, null), (Continuation) this, 8, (Object) null);
                            if (objNewExtractorLink$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            function9 = function8;
                            label2 = text11;
                            function9.invoke(objNewExtractorLink$default);
                        }
                        Unit unit3 = Unit.INSTANCE;
                    } else if (StringsKt.contains$default(label3, "pixeldra", false, 2, (Object) null) || StringsKt.contains$default(label3, "pixelserver", false, 2, (Object) null) || StringsKt.contains$default(label3, "pixel server", false, 2, (Object) null) || StringsKt.contains$default(label3, "pixeldrain", false, 2, (Object) null)) {
                        String base = this.this$0.getBaseUrl(link);
                        String finalUrl = StringsKt.contains$default(link, "download", false, 2, (Object) null) ? link : base + "/api/file/" + StringsKt.substringAfterLast$default(link, "/", (String) null, 2, (Object) null) + "?download";
                        Function1<ExtractorLink, Unit> function14 = this.$callback;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(element);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(link);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(text17);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(label3);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(base);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(finalUrl);
                        this.L$6 = function14;
                        this.label = 5;
                        Object objNewExtractorLink$default5 = ExtractorApiKt.newExtractorLink$default(this.$ref + " Pixeldrain", this.$ref + " Pixeldrain " + this.$labelExtras, finalUrl, (ExtractorLinkType) null, new AnonymousClass4(this.$quality, null), (Continuation) this, 8, (Object) null);
                        if (objNewExtractorLink$default5 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function1 = function14;
                        obj = objNewExtractorLink$default5;
                        link2 = link;
                        label = label3;
                        text = text17;
                        function1.invoke(obj);
                        Unit unit4 = Unit.INSTANCE;
                    } else if (StringsKt.contains$default(label3, "s3 server", false, 2, (Object) null)) {
                        Function1<ExtractorLink, Unit> function15 = this.$callback;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(element);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(link);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(text17);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(label3);
                        this.L$4 = function15;
                        this.label = 6;
                        Object objNewExtractorLink$default6 = ExtractorApiKt.newExtractorLink$default(this.$ref + " [S3 Server]", this.$ref + " [S3 Server] " + this.$labelExtras, link, (ExtractorLinkType) null, new AnonymousClass5(this.$quality, null), (Continuation) this, 8, (Object) null);
                        if (objNewExtractorLink$default6 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function5 = function15;
                        obj5 = objNewExtractorLink$default6;
                        link7 = link;
                        text8 = text17;
                        text9 = label3;
                        function5.invoke(obj5);
                        Unit unit5 = Unit.INSTANCE;
                    } else if (StringsKt.contains$default(label3, "fslv2", false, 2, (Object) null)) {
                        Function1<ExtractorLink, Unit> function16 = this.$callback;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(element);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(link);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(text17);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(label3);
                        this.L$4 = function16;
                        this.label = 7;
                        Object objNewExtractorLink$default7 = ExtractorApiKt.newExtractorLink$default(this.$ref + " [FSLv2]", this.$ref + " [FSLv2] " + this.$labelExtras, link, (ExtractorLinkType) null, new AnonymousClass6(this.$quality, null), (Continuation) this, 8, (Object) null);
                        if (objNewExtractorLink$default7 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function4 = function16;
                        obj4 = objNewExtractorLink$default7;
                        link6 = link;
                        text6 = text17;
                        text7 = label3;
                        function4.invoke(obj4);
                        Unit unit6 = Unit.INSTANCE;
                    } else if (StringsKt.contains$default(label3, "mega server", false, 2, (Object) null)) {
                        Function1<ExtractorLink, Unit> function17 = this.$callback;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(element);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(link);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(text17);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(label3);
                        this.L$4 = function17;
                        this.label = 8;
                        Object objNewExtractorLink$default8 = ExtractorApiKt.newExtractorLink$default(this.$ref + " [Mega Server]", this.$ref + " [Mega Server] " + this.$labelExtras, link, (ExtractorLinkType) null, new AnonymousClass7(this.$quality, null), (Continuation) this, 8, (Object) null);
                        if (objNewExtractorLink$default8 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function3 = function17;
                        obj3 = objNewExtractorLink$default8;
                        link5 = link;
                        text4 = text17;
                        text5 = label3;
                        function3.invoke(obj3);
                        Unit unit7 = Unit.INSTANCE;
                    } else if (StringsKt.contains$default(label3, "pdl Server", false, 2, (Object) null)) {
                        Function1<ExtractorLink, Unit> function18 = this.$callback;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(element);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(link);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(text17);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(label3);
                        this.L$4 = function18;
                        this.label = 9;
                        Object objNewExtractorLink$default9 = ExtractorApiKt.newExtractorLink$default(this.$ref + " [PDL Server]", this.$ref + " [PDL Server] " + this.$labelExtras, link, (ExtractorLinkType) null, new AnonymousClass8(this.$quality, null), (Continuation) this, 8, (Object) null);
                        if (objNewExtractorLink$default9 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function2 = function18;
                        obj2 = objNewExtractorLink$default9;
                        link4 = link;
                        text2 = text17;
                        text3 = label3;
                        function2.invoke(obj2);
                        Unit unit8 = Unit.INSTANCE;
                    } else if (StringsKt.contains$default(label3, "10gbps", false, 2, (Object) null)) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(element);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(link);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(text17);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(label3);
                        this.label = 10;
                        objResolveFinalUrl = ExtractorKt.resolveFinalUrl(link, (Continuation) this);
                        if (objResolveFinalUrl == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        link3 = text17;
                        redirectUrl = label3;
                        redirectUrl2 = (String) objResolveFinalUrl;
                        if (redirectUrl2 == null) {
                            return Unit.INSTANCE;
                        }
                        if (StringsKt.contains$default(redirectUrl2, "link=", false, 2, (Object) null)) {
                            redirectUrl2 = StringsKt.substringAfter$default(redirectUrl2, "link=", (String) null, 2, (Object) null);
                        }
                        String redirectUrl3 = redirectUrl2;
                        function10 = this.$callback;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(element);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(link);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(link3);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(redirectUrl);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(redirectUrl3);
                        this.L$5 = function10;
                        this.label = 11;
                        objNewExtractorLink$default2 = ExtractorApiKt.newExtractorLink$default(this.$ref + " 10Gbps [Download]", this.$ref + " 10Gbps [Download] " + this.$labelExtras, redirectUrl3, (ExtractorLinkType) null, new AnonymousClass9(this.$quality, null), (Continuation) this, 8, (Object) null);
                        if (objNewExtractorLink$default2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function11 = function10;
                        obj9 = objNewExtractorLink$default2;
                        text16 = link3;
                        function11.invoke(obj9);
                        Unit unit9 = Unit.INSTANCE;
                    } else {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(element);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(link);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(text17);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(label3);
                        this.label = 12;
                        if (ExtractorApiKt.loadExtractor(link, "", this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Unit.INSTANCE;
                case 1:
                    function7 = (Function1) this.L$4;
                    text15 = (String) this.L$3;
                    text14 = (String) this.L$2;
                    link10 = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    obj8 = $result;
                    function7.invoke(obj8);
                    Unit unit10 = Unit.INSTANCE;
                    return Unit.INSTANCE;
                case 2:
                    function6 = (Function1) this.L$4;
                    text13 = (String) this.L$3;
                    text12 = (String) this.L$2;
                    link9 = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    obj7 = $result;
                    function6.invoke(obj7);
                    Unit unit11 = Unit.INSTANCE;
                    return Unit.INSTANCE;
                case 3:
                    text11 = (String) this.L$3;
                    String text18 = (String) this.L$2;
                    String link11 = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    link8 = link11;
                    text10 = text18;
                    obj6 = $result;
                    resp = (NiceResponse) obj6;
                    str = resp.getHeaders().get("hx-redirect");
                    if (str == null) {
                        str2 = resp.getHeaders().get("HX-Redirect");
                        if (str2 != null) {
                            str3 = str2;
                        }
                    } else {
                        str3 = str;
                    }
                    dlink = str3;
                    if (StringsKt.isBlank(dlink)) {
                        function8 = this.$callback;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(element);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(link8);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(text10);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(text11);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(resp);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(dlink);
                        this.L$6 = function8;
                        this.label = 4;
                        objNewExtractorLink$default = ExtractorApiKt.newExtractorLink$default(this.$ref + " [BuzzServer]", this.$ref + " [BuzzServer] " + this.$labelExtras, dlink, (ExtractorLinkType) null, new AnonymousClass3(this.$quality, null), (Continuation) this, 8, (Object) null);
                        if (objNewExtractorLink$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function9 = function8;
                        label2 = text11;
                        function9.invoke(objNewExtractorLink$default);
                    } else {
                        Log.INSTANCE.w(this.$tag, "BuzzServer: No redirect");
                    }
                    Unit unit12 = Unit.INSTANCE;
                    return Unit.INSTANCE;
                case 4:
                    function9 = (Function1) this.L$6;
                    label2 = (String) this.L$3;
                    text10 = (String) this.L$2;
                    String link12 = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    link8 = link12;
                    objNewExtractorLink$default = $result;
                    function9.invoke(objNewExtractorLink$default);
                    Unit unit13 = Unit.INSTANCE;
                    return Unit.INSTANCE;
                case 5:
                    function1 = (Function1) this.L$6;
                    label = (String) this.L$3;
                    text = (String) this.L$2;
                    link2 = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    obj = $result;
                    function1.invoke(obj);
                    Unit unit14 = Unit.INSTANCE;
                    return Unit.INSTANCE;
                case 6:
                    function5 = (Function1) this.L$4;
                    text9 = (String) this.L$3;
                    text8 = (String) this.L$2;
                    link7 = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    obj5 = $result;
                    function5.invoke(obj5);
                    Unit unit15 = Unit.INSTANCE;
                    return Unit.INSTANCE;
                case 7:
                    function4 = (Function1) this.L$4;
                    text7 = (String) this.L$3;
                    text6 = (String) this.L$2;
                    link6 = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    obj4 = $result;
                    function4.invoke(obj4);
                    Unit unit16 = Unit.INSTANCE;
                    return Unit.INSTANCE;
                case 8:
                    function3 = (Function1) this.L$4;
                    text5 = (String) this.L$3;
                    text4 = (String) this.L$2;
                    link5 = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    obj3 = $result;
                    function3.invoke(obj3);
                    Unit unit17 = Unit.INSTANCE;
                    return Unit.INSTANCE;
                case 9:
                    function2 = (Function1) this.L$4;
                    text3 = (String) this.L$3;
                    text2 = (String) this.L$2;
                    link4 = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    obj2 = $result;
                    function2.invoke(obj2);
                    Unit unit18 = Unit.INSTANCE;
                    return Unit.INSTANCE;
                case 10:
                    redirectUrl = (String) this.L$3;
                    String text19 = (String) this.L$2;
                    String link13 = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    link = link13;
                    link3 = text19;
                    objResolveFinalUrl = $result;
                    redirectUrl2 = (String) objResolveFinalUrl;
                    if (redirectUrl2 == null) {
                        return Unit.INSTANCE;
                    }
                    if (StringsKt.contains$default(redirectUrl2, "link=", false, 2, (Object) null)) {
                        redirectUrl2 = StringsKt.substringAfter$default(redirectUrl2, "link=", (String) null, 2, (Object) null);
                    }
                    String redirectUrl4 = redirectUrl2;
                    function10 = this.$callback;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(element);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(link);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(link3);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(redirectUrl);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(redirectUrl4);
                    this.L$5 = function10;
                    this.label = 11;
                    objNewExtractorLink$default2 = ExtractorApiKt.newExtractorLink$default(this.$ref + " 10Gbps [Download]", this.$ref + " 10Gbps [Download] " + this.$labelExtras, redirectUrl4, (ExtractorLinkType) null, new AnonymousClass9(this.$quality, null), (Continuation) this, 8, (Object) null);
                    if (objNewExtractorLink$default2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function11 = function10;
                    obj9 = objNewExtractorLink$default2;
                    text16 = link3;
                    function11.invoke(obj9);
                    Unit unit19 = Unit.INSTANCE;
                    return Unit.INSTANCE;
                case 11:
                    function11 = (Function1) this.L$5;
                    String label4 = (String) this.L$3;
                    text16 = (String) this.L$2;
                    ResultKt.throwOnFailure($result);
                    redirectUrl = label4;
                    obj9 = $result;
                    function11.invoke(obj9);
                    Unit unit110 = Unit.INSTANCE;
                    return Unit.INSTANCE;
                case 12:
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.fourKHDHub.HubCloud$getUrl$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: Extractor.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.fourKHDHub.HubCloud$getUrl$2$1", f = "Extractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
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

        /* JADX INFO: renamed from: com.fourKHDHub.HubCloud$getUrl$2$2, reason: invalid class name */
        /* JADX INFO: compiled from: Extractor.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.fourKHDHub.HubCloud$getUrl$2$2", f = "Extractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
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

        /* JADX INFO: renamed from: com.fourKHDHub.HubCloud$getUrl$2$3, reason: invalid class name */
        /* JADX INFO: compiled from: Extractor.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.fourKHDHub.HubCloud$getUrl$2$3", f = "Extractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
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

        /* JADX INFO: renamed from: com.fourKHDHub.HubCloud$getUrl$2$4, reason: invalid class name */
        /* JADX INFO: compiled from: Extractor.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.fourKHDHub.HubCloud$getUrl$2$4", f = "Extractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass4 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
            final /* synthetic */ int $quality;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass4(int i, Continuation<? super AnonymousClass4> continuation) {
                super(2, continuation);
                this.$quality = i;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass4 = new AnonymousClass4(this.$quality, continuation);
                anonymousClass4.L$0 = obj;
                return anonymousClass4;
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

        /* JADX INFO: renamed from: com.fourKHDHub.HubCloud$getUrl$2$5, reason: invalid class name */
        /* JADX INFO: compiled from: Extractor.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.fourKHDHub.HubCloud$getUrl$2$5", f = "Extractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
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

        /* JADX INFO: renamed from: com.fourKHDHub.HubCloud$getUrl$2$6, reason: invalid class name */
        /* JADX INFO: compiled from: Extractor.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.fourKHDHub.HubCloud$getUrl$2$6", f = "Extractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
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

        /* JADX INFO: renamed from: com.fourKHDHub.HubCloud$getUrl$2$7, reason: invalid class name */
        /* JADX INFO: compiled from: Extractor.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.fourKHDHub.HubCloud$getUrl$2$7", f = "Extractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
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

        /* JADX INFO: renamed from: com.fourKHDHub.HubCloud$getUrl$2$8, reason: invalid class name */
        /* JADX INFO: compiled from: Extractor.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.fourKHDHub.HubCloud$getUrl$2$8", f = "Extractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass8 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
            final /* synthetic */ int $quality;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass8(int i, Continuation<? super AnonymousClass8> continuation) {
                super(2, continuation);
                this.$quality = i;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass8 = new AnonymousClass8(this.$quality, continuation);
                anonymousClass8.L$0 = obj;
                return anonymousClass8;
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

        /* JADX INFO: renamed from: com.fourKHDHub.HubCloud$getUrl$2$9, reason: invalid class name */
        /* JADX INFO: compiled from: Extractor.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.fourKHDHub.HubCloud$getUrl$2$9", f = "Extractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass9 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
            final /* synthetic */ int $quality;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass9(int i, Continuation<? super AnonymousClass9> continuation) {
                super(2, continuation);
                this.$quality = i;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass9 = new AnonymousClass9(this.$quality, continuation);
                anonymousClass9.L$0 = obj;
                return anonymousClass9;
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

    private final int getIndexQuality(String str) {
        List groupValues;
        String str2;
        Integer intOrNull;
        MatchResult matchResultFind$default = Regex.find$default(new Regex("(\\d{3,4})[pP]"), str == null ? "" : str, 0, 2, (Object) null);
        return (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null || (str2 = (String) CollectionsKt.getOrNull(groupValues, 1)) == null || (intOrNull = StringsKt.toIntOrNull(str2)) == null) ? Qualities.P2160.getValue() : intOrNull.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getBaseUrl(String url) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            HubCloud hubCloud = this;
            Url it = URLUtilsKt.Url(url);
            obj = Result.constructor-impl(it.getProtocol().getName() + "://" + it.getHost());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = "";
        }
        return (String) obj;
    }

    /* JADX WARN: Code duplicated, block: B:47:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:53:0x01d1 A[SYNTHETIC] */
    private final String cleanTitle(String title) {
        List parts;
        Set sourceTags;
        Set codecTags;
        String str;
        boolean z;
        String str2;
        Object it$iv$iv = new Regex("\\.[a-zA-Z0-9]{2,4}$").replace(title, "");
        String normalized = new Regex("DDP[ .]?([0-9]\\.[0-9])", RegexOption.IGNORE_CASE).replace(new Regex("H[ .]?264", RegexOption.IGNORE_CASE).replace(new Regex("H[ .]?265", RegexOption.IGNORE_CASE).replace(new Regex("WEB[-_. ]?RIP", RegexOption.IGNORE_CASE).replace(new Regex("WEB[-_. ]?DL", RegexOption.IGNORE_CASE).replace((CharSequence) it$iv$iv, "WEB-DL"), "WEBRIP"), "H265"), "H264"), "DDP$1");
        List parts2 = StringsKt.split$default(normalized, new String[]{" ", "_", "."}, false, 0, 6, (Object) null);
        Set sourceTags2 = SetsKt.setOf(new String[]{"WEB-DL", "WEBRIP", "BLURAY", "HDRIP", "DVDRIP", "HDTV", "CAM", "TS", "BRRIP", "BDRIP"});
        Set codecTags2 = SetsKt.setOf(new String[]{"H264", "H265", "X264", "X265", "HEVC", "AVC"});
        Iterable audioTags = SetsKt.setOf(new String[]{"AAC", "AC3", "DTS", "MP3", "FLAC", "DD", "DDP", "EAC3"});
        Set audioExtras = SetsKt.setOf("ATMOS");
        Set hdrTags = SetsKt.setOf(new String[]{"SDR", "HDR", "HDR10", "HDR10+", "DV", "DOLBYVISION"});
        List $this$mapNotNull$iv = parts2;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Object name = it$iv$iv;
            String part = (String) element$iv$iv$iv;
            String normalized2 = normalized;
            String p = part.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(p, "toUpperCase(...)");
            if (sourceTags2.contains(p) || codecTags2.contains(p)) {
                parts = parts2;
                sourceTags = sourceTags2;
                codecTags = codecTags2;
            } else {
                Iterable $this$any$iv = audioTags;
                parts = parts2;
                if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
                    sourceTags = sourceTags2;
                    codecTags = codecTags2;
                    z = false;
                    str = null;
                } else {
                    Iterator it = $this$any$iv.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            sourceTags = sourceTags2;
                            codecTags = codecTags2;
                            str = null;
                            z = false;
                            break;
                        }
                        Object element$iv = it.next();
                        String it2 = (String) element$iv;
                        Iterator it3 = it;
                        sourceTags = sourceTags2;
                        codecTags = codecTags2;
                        str = null;
                        if (StringsKt.startsWith$default(p, it2, false, 2, (Object) null)) {
                            z = true;
                            break;
                        }
                        codecTags2 = codecTags;
                        it = it3;
                        sourceTags2 = sourceTags;
                    }
                }
                if (!z && !audioExtras.contains(p)) {
                    if (hdrTags.contains(p)) {
                        if (Intrinsics.areEqual(p, "DV") || Intrinsics.areEqual(p, "DOLBYVISION")) {
                            str2 = "DOLBYVISION";
                        }
                    } else if (!Intrinsics.areEqual(p, "NF") && !Intrinsics.areEqual(p, "CR")) {
                        str2 = str;
                    }
                }
                if (str2 != null) {
                    destination$iv$iv.add(str2);
                }
                it$iv$iv = name;
                normalized = normalized2;
                parts2 = parts;
                codecTags2 = codecTags;
                sourceTags2 = sourceTags;
            }
            str2 = p;
            if (str2 != null) {
                destination$iv$iv.add(str2);
            }
            it$iv$iv = name;
            normalized = normalized2;
            parts2 = parts;
            codecTags2 = codecTags;
            sourceTags2 = sourceTags;
        }
        List filtered = (List) destination$iv$iv;
        return CollectionsKt.joinToString$default(CollectionsKt.distinct(filtered), " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }
}
