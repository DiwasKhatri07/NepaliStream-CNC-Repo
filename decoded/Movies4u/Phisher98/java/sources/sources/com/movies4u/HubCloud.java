package com.movies4u;

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
import java.net.URI;
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
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Movies4u/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0005H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/movies4u/HubCloud;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIndexQuality", "", "str", "getBaseUrl", "cleanTitle", "title", "Movies4u"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractor.kt\ncom/movies4u/HubCloud\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,788:1\n1#2:789\n1#2:804\n1795#3,10:790\n2068#3:800\n1960#3,3:801\n2069#3:805\n1805#3:806\n*S KotlinDebug\n*F\n+ 1 Extractor.kt\ncom/movies4u/HubCloud\n*L\n471#1:804\n471#1:790,10\n471#1:800\n477#1:801,3\n471#1:805\n471#1:806\n*E\n"})
public class HubCloud extends ExtractorApi {
    private final boolean requiresReferer;

    @NotNull
    private final String name = "Hub-Cloud";

    @NotNull
    private final String mainUrl = "https://hubcloud.foo";

    /* JADX INFO: renamed from: com.movies4u.HubCloud$getUrl$1 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.movies4u.HubCloud", f = "Extractor.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {307, 322, 334}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "subtitleCallback", "callback", "tag", "ref", "uri", "realUrl", "baseUrl", "$this$getUrl_u24lambda_u242", "$this", "url", "referer", "subtitleCallback", "callback", "tag", "ref", "uri", "realUrl", "baseUrl", "href", "$this", "url", "referer", "subtitleCallback", "callback", "tag", "ref", "uri", "realUrl", "baseUrl", "href", "document", "size", "header", "headerDetails", "labelExtras", "quality"}, nl = {308, 323, 428}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "I$0"}, v = 2)
    static final class C00081 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
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

        C00081(Continuation<? super C00081> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HubCloud.getUrl$suspendImpl(HubCloud.this, null, null, null, null, (Continuation) this);
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

    /* JADX WARN: Code duplicated, block: B:102:0x036a  */
    /* JADX WARN: Code duplicated, block: B:104:0x036d  */
    /* JADX WARN: Code duplicated, block: B:106:0x03d7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:107:0x03d8  */
    /* JADX WARN: Code duplicated, block: B:110:0x03f4  */
    /* JADX WARN: Code duplicated, block: B:111:0x03f9  */
    /* JADX WARN: Code duplicated, block: B:113:0x03fd  */
    /* JADX WARN: Code duplicated, block: B:116:0x0408  */
    /* JADX WARN: Code duplicated, block: B:119:0x0411  */
    /* JADX WARN: Code duplicated, block: B:122:0x0430  */
    /* JADX WARN: Code duplicated, block: B:123:0x0433  */
    /* JADX WARN: Code duplicated, block: B:126:0x0439  */
    /* JADX WARN: Code duplicated, block: B:127:0x0458  */
    /* JADX WARN: Code duplicated, block: B:130:0x0465  */
    /* JADX WARN: Code duplicated, block: B:132:0x0469  */
    /* JADX WARN: Code duplicated, block: B:133:0x0488  */
    /* JADX WARN: Code duplicated, block: B:136:0x0511 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:137:0x0512  */
    /* JADX WARN: Code duplicated, block: B:158:0x0252 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:0x025d  */
    /* JADX WARN: Code duplicated, block: B:59:0x0261  */
    /* JADX WARN: Code duplicated, block: B:65:0x026f  */
    /* JADX WARN: Code duplicated, block: B:66:0x0276 A[Catch: all -> 0x02b5, TRY_LEAVE, TryCatch #6 {all -> 0x02b5, blocks: (B:63:0x0269, B:66:0x0276), top: B:154:0x0269 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:99:0x033e  */
    static /* synthetic */ Object getUrl$suspendImpl(HubCloud $this, String url, String referer, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super Unit> continuation) {
        C00081 c00081;
        String str;
        Object obj;
        String raw;
        String strText;
        char c;
        HubCloud $this2;
        String tag;
        String referer2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        String baseUrl;
        URI uri;
        String baseUrl2;
        String tag2;
        String ref;
        HubCloud $this$getUrl_u24lambda_u242;
        HubCloud $this$getUrl_u24lambda_u243;
        Object obj2;
        String url2;
        String baseUrl3;
        String realUrl;
        URI uri2;
        String ref2;
        String url3;
        Function1<? super ExtractorLink, Unit> function5;
        Function1<? super SubtitleFile, Unit> function6;
        String referer3;
        Throwable it;
        String href;
        HubCloud $this3;
        Object obj3;
        C00081 c00082;
        String href2;
        String ref3;
        String href3;
        HubCloud $this4;
        String realUrl2;
        Function1<? super ExtractorLink, Unit> function7;
        Function1<? super SubtitleFile, Unit> function8;
        Element elementSelectFirst;
        String strAttr;
        HubCloud $this5;
        Element elementSelectFirst2;
        String strText2;
        String size;
        Element elementSelectFirst3;
        String headerDetails;
        StringBuilder $this$getUrl_u24lambda_u244;
        boolean z;
        StringBuilder $this$getUrl_u24lambda_u245;
        List listSelect;
        C00092 c00092;
        if (continuation instanceof C00081) {
            c00081 = (C00081) continuation;
            if ((c00081.label & Integer.MIN_VALUE) != 0) {
                c00081.label -= Integer.MIN_VALUE;
            } else {
                c00081 = $this.new C00081(continuation);
            }
        } else {
            c00081 = $this.new C00081(continuation);
        }
        C00081 c00083 = c00081;
        Object $result = c00083.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00083.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String tag3 = "HubCloud";
                String ref4 = referer == null ? "" : referer;
                try {
                    Result.Companion companion = Result.Companion;
                    str = url;
                    try {
                        obj = Result.constructor-impl(new URI(str));
                    } catch (Throwable th) {
                        th = th;
                        Result.Companion companion2 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    break;
                } catch (Throwable th2) {
                    th = th2;
                    str = url;
                }
                Throwable it2 = Result.exceptionOrNull-impl(obj);
                if (it2 != null) {
                    Log.INSTANCE.e("HubCloud", "Invalid URL: " + it2.getMessage());
                    return Unit.INSTANCE;
                }
                URI uri3 = (URI) obj;
                raw = uri3.toString();
                String baseUrl4 = uri3.getScheme() + "://" + uri3.getHost();
                try {
                    Result.Companion companion3 = Result.Companion;
                    try {
                        if (StringsKt.contains$default(raw, "hubcloud.php", false, 2, (Object) null)) {
                            $this2 = $this;
                            coroutine_suspended = coroutine_suspended;
                            c00083 = c00083;
                            referer2 = referer;
                            function4 = function2;
                            tag2 = "HubCloud";
                            ref = ref4;
                            baseUrl2 = baseUrl4;
                            tag = str;
                            strText = null;
                            uri = uri3;
                            c = 0;
                            function3 = function1;
                            baseUrl = raw;
                            try {
                                obj2 = Result.constructor-impl(raw);
                                break;
                            } catch (Throwable th3) {
                                th = th3;
                                Result.Companion companion4 = Result.Companion;
                                obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                            }
                            url2 = tag;
                            baseUrl3 = baseUrl2;
                            realUrl = baseUrl;
                            uri2 = uri;
                            ref2 = ref;
                            url3 = tag2;
                            function5 = function4;
                            function6 = function3;
                            referer3 = referer2;
                            it = Result.exceptionOrNull-impl(obj2);
                            if (it != null) {
                                Log.INSTANCE.e(url3, "Failed to extract href: " + it.getMessage());
                                obj2 = "";
                            }
                            href = (String) obj2;
                            if (StringsKt.isBlank(href)) {
                                return Unit.INSTANCE;
                            }
                            Requests app = MainActivityKt.getApp();
                            c00083.L$0 = $this2;
                            c00083.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                            c00083.L$2 = SpillingKt.nullOutSpilledVariable(referer3);
                            c00083.L$3 = function6;
                            c00083.L$4 = function5;
                            c00083.L$5 = url3;
                            c00083.L$6 = ref2;
                            c00083.L$7 = SpillingKt.nullOutSpilledVariable(uri2);
                            c00083.L$8 = SpillingKt.nullOutSpilledVariable(realUrl);
                            c00083.L$9 = SpillingKt.nullOutSpilledVariable(baseUrl3);
                            c00083.L$10 = SpillingKt.nullOutSpilledVariable(href);
                            c00083.label = 2;
                            C00081 c00084 = c00083;
                            $this3 = $this2;
                            obj3 = Requests.get$default(app, href, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00084, 4094, (Object) null);
                            c00082 = c00084;
                            if (obj3 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $result = obj3;
                            href2 = href;
                            ref3 = ref2;
                            href3 = url2;
                            $this4 = $this3;
                            realUrl2 = url3;
                            function7 = function5;
                            function8 = function6;
                            Document document = ((NiceResponse) $result).getDocument();
                            elementSelectFirst2 = document.selectFirst("i#size");
                            if (elementSelectFirst2 != null) {
                                strText2 = elementSelectFirst2.text();
                            } else {
                                strText2 = strText;
                            }
                            if (strText2 == null) {
                                strText2 = "";
                            }
                            size = strText2;
                            elementSelectFirst3 = document.selectFirst("div.card-header");
                            if (elementSelectFirst3 != null) {
                                strText = elementSelectFirst3.text();
                            }
                            String header = strText != null ? strText : "";
                            headerDetails = $this4.cleanTitle(header);
                            int quality = $this4.getIndexQuality(header);
                            $this$getUrl_u24lambda_u244 = new StringBuilder();
                            if (headerDetails.length() > 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                $this$getUrl_u24lambda_u245 = $this$getUrl_u24lambda_u244;
                                $this$getUrl_u24lambda_u245.append('[' + headerDetails + ']');
                            } else {
                                $this$getUrl_u24lambda_u245 = $this$getUrl_u24lambda_u244;
                            }
                            if (size.length() > 0) {
                                c = 1;
                            }
                            if (c != 0) {
                                $this$getUrl_u24lambda_u245.append('[' + size + ']');
                            }
                            String labelExtras = $this$getUrl_u24lambda_u244.toString();
                            listSelect = document.select("a.btn");
                            c00092 = new C00092(function7, ref3, labelExtras, realUrl2, $this4, function8, quality, null);
                            c00082.L$0 = SpillingKt.nullOutSpilledVariable($this4);
                            c00082.L$1 = SpillingKt.nullOutSpilledVariable(href3);
                            c00082.L$2 = SpillingKt.nullOutSpilledVariable(referer3);
                            c00082.L$3 = SpillingKt.nullOutSpilledVariable(function8);
                            c00082.L$4 = SpillingKt.nullOutSpilledVariable(function7);
                            c00082.L$5 = SpillingKt.nullOutSpilledVariable(realUrl2);
                            c00082.L$6 = SpillingKt.nullOutSpilledVariable(ref3);
                            c00082.L$7 = SpillingKt.nullOutSpilledVariable(uri2);
                            c00082.L$8 = SpillingKt.nullOutSpilledVariable(realUrl);
                            c00082.L$9 = SpillingKt.nullOutSpilledVariable(baseUrl3);
                            c00082.L$10 = SpillingKt.nullOutSpilledVariable(href2);
                            c00082.L$11 = SpillingKt.nullOutSpilledVariable(document);
                            c00082.L$12 = SpillingKt.nullOutSpilledVariable(size);
                            c00082.L$13 = SpillingKt.nullOutSpilledVariable(header);
                            c00082.L$14 = SpillingKt.nullOutSpilledVariable(headerDetails);
                            c00082.L$15 = SpillingKt.nullOutSpilledVariable(labelExtras);
                            c00082.I$0 = quality;
                            c00082.label = 3;
                            if (ParCollectionsKt.amap(listSelect, c00092, c00082) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        }
                        Requests app2 = MainActivityKt.getApp();
                        c00083.L$0 = $this;
                        c00083.L$1 = SpillingKt.nullOutSpilledVariable(str);
                        c00083.L$2 = SpillingKt.nullOutSpilledVariable(referer);
                        c00083.L$3 = function1;
                        try {
                            c00083.L$4 = function2;
                            c00083.L$5 = "HubCloud";
                            c00083.L$6 = ref4;
                            c00083.L$7 = SpillingKt.nullOutSpilledVariable(uri3);
                            c00083.L$8 = SpillingKt.nullOutSpilledVariable(raw);
                            c00083.L$9 = baseUrl4;
                            c00083.L$10 = SpillingKt.nullOutSpilledVariable($this);
                            c00083.label = 1;
                            strText = null;
                            c = 0;
                            coroutine_suspended = coroutine_suspended;
                            try {
                                Object obj4 = Requests.get$default(app2, raw, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00083, 4094, (Object) null);
                                c00083 = c00083;
                                if (obj4 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                tag = url;
                                referer2 = referer;
                                function3 = function1;
                                function4 = function2;
                                $this$getUrl_u24lambda_u242 = $this;
                                baseUrl = raw;
                                uri = uri3;
                                $this$getUrl_u24lambda_u243 = null;
                                baseUrl2 = baseUrl4;
                                tag2 = "HubCloud";
                                ref = ref4;
                                $result = obj4;
                                $this2 = $this;
                                try {
                                    try {
                                        elementSelectFirst = ((NiceResponse) $result).getDocument().selectFirst("a[href*='hubcloud.php']");
                                        if (elementSelectFirst != null) {
                                            try {
                                                strAttr = elementSelectFirst.attr("href");
                                            } catch (Throwable th4) {
                                                th = th4;
                                            }
                                        } else {
                                            strAttr = strText;
                                        }
                                        if (strAttr == null) {
                                            strAttr = "";
                                        }
                                        raw = strAttr;
                                        $this5 = $this2;
                                        try {
                                            if (StringsKt.startsWith(raw, "http", true)) {
                                                $this2 = $this5;
                                            } else {
                                                StringBuilder sb = new StringBuilder();
                                                char[] cArr = new char[1];
                                                cArr[c] = '/';
                                                StringBuilder sbAppend = sb.append(StringsKt.trimEnd(baseUrl2, cArr)).append('/');
                                                try {
                                                    char[] cArr2 = new char[1];
                                                    cArr2[c] = '/';
                                                    String string = sbAppend.append(StringsKt.trimStart(raw, cArr2)).toString();
                                                    $this2 = $this5;
                                                    raw = string;
                                                } catch (Throwable th5) {
                                                    th = th5;
                                                    $this2 = $this5;
                                                }
                                            }
                                            obj2 = Result.constructor-impl(raw);
                                        } catch (Throwable th6) {
                                            th = th6;
                                        }
                                    } catch (Throwable th7) {
                                        th = th7;
                                    }
                                    break;
                                } catch (Throwable th8) {
                                    th = th8;
                                }
                                url2 = tag;
                                baseUrl3 = baseUrl2;
                                realUrl = baseUrl;
                                uri2 = uri;
                                ref2 = ref;
                                url3 = tag2;
                                function5 = function4;
                                function6 = function3;
                                referer3 = referer2;
                                it = Result.exceptionOrNull-impl(obj2);
                                if (it != null) {
                                    Log.INSTANCE.e(url3, "Failed to extract href: " + it.getMessage());
                                    obj2 = "";
                                }
                                href = (String) obj2;
                                if (StringsKt.isBlank(href)) {
                                    return Unit.INSTANCE;
                                }
                                Requests app3 = MainActivityKt.getApp();
                                c00083.L$0 = $this2;
                                c00083.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                                c00083.L$2 = SpillingKt.nullOutSpilledVariable(referer3);
                                c00083.L$3 = function6;
                                c00083.L$4 = function5;
                                c00083.L$5 = url3;
                                c00083.L$6 = ref2;
                                c00083.L$7 = SpillingKt.nullOutSpilledVariable(uri2);
                                c00083.L$8 = SpillingKt.nullOutSpilledVariable(realUrl);
                                c00083.L$9 = SpillingKt.nullOutSpilledVariable(baseUrl3);
                                c00083.L$10 = SpillingKt.nullOutSpilledVariable(href);
                                c00083.label = 2;
                                C00081 c00085 = c00083;
                                $this3 = $this2;
                                obj3 = Requests.get$default(app3, href, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00085, 4094, (Object) null);
                                c00082 = c00085;
                                if (obj3 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                $result = obj3;
                                href2 = href;
                                ref3 = ref2;
                                href3 = url2;
                                $this4 = $this3;
                                realUrl2 = url3;
                                function7 = function5;
                                function8 = function6;
                                Document document2 = ((NiceResponse) $result).getDocument();
                                elementSelectFirst2 = document2.selectFirst("i#size");
                                if (elementSelectFirst2 != null) {
                                    strText2 = elementSelectFirst2.text();
                                } else {
                                    strText2 = strText;
                                }
                                if (strText2 == null) {
                                    strText2 = "";
                                }
                                size = strText2;
                                elementSelectFirst3 = document2.selectFirst("div.card-header");
                                if (elementSelectFirst3 != null) {
                                    strText = elementSelectFirst3.text();
                                }
                                String header2 = strText != null ? strText : "";
                                headerDetails = $this4.cleanTitle(header2);
                                int quality2 = $this4.getIndexQuality(header2);
                                $this$getUrl_u24lambda_u244 = new StringBuilder();
                                if (headerDetails.length() > 0) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (z) {
                                    $this$getUrl_u24lambda_u245 = $this$getUrl_u24lambda_u244;
                                    $this$getUrl_u24lambda_u245.append('[' + headerDetails + ']');
                                } else {
                                    $this$getUrl_u24lambda_u245 = $this$getUrl_u24lambda_u244;
                                }
                                if (size.length() > 0) {
                                    c = 1;
                                }
                                if (c != 0) {
                                    $this$getUrl_u24lambda_u245.append('[' + size + ']');
                                }
                                String labelExtras2 = $this$getUrl_u24lambda_u244.toString();
                                listSelect = document2.select("a.btn");
                                c00092 = new C00092(function7, ref3, labelExtras2, realUrl2, $this4, function8, quality2, null);
                                c00082.L$0 = SpillingKt.nullOutSpilledVariable($this4);
                                c00082.L$1 = SpillingKt.nullOutSpilledVariable(href3);
                                c00082.L$2 = SpillingKt.nullOutSpilledVariable(referer3);
                                c00082.L$3 = SpillingKt.nullOutSpilledVariable(function8);
                                c00082.L$4 = SpillingKt.nullOutSpilledVariable(function7);
                                c00082.L$5 = SpillingKt.nullOutSpilledVariable(realUrl2);
                                c00082.L$6 = SpillingKt.nullOutSpilledVariable(ref3);
                                c00082.L$7 = SpillingKt.nullOutSpilledVariable(uri2);
                                c00082.L$8 = SpillingKt.nullOutSpilledVariable(realUrl);
                                c00082.L$9 = SpillingKt.nullOutSpilledVariable(baseUrl3);
                                c00082.L$10 = SpillingKt.nullOutSpilledVariable(href2);
                                c00082.L$11 = SpillingKt.nullOutSpilledVariable(document2);
                                c00082.L$12 = SpillingKt.nullOutSpilledVariable(size);
                                c00082.L$13 = SpillingKt.nullOutSpilledVariable(header2);
                                c00082.L$14 = SpillingKt.nullOutSpilledVariable(headerDetails);
                                c00082.L$15 = SpillingKt.nullOutSpilledVariable(labelExtras2);
                                c00082.I$0 = quality2;
                                c00082.label = 3;
                                if (ParCollectionsKt.amap(listSelect, c00092, c00082) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                return Unit.INSTANCE;
                            } catch (Throwable th9) {
                                th = th9;
                                c00083 = c00083;
                                $this2 = $this;
                                tag = url;
                                referer2 = referer;
                                function3 = function1;
                                function4 = function2;
                                baseUrl = raw;
                                uri = uri3;
                                baseUrl2 = baseUrl4;
                                tag2 = "HubCloud";
                                ref = ref4;
                            }
                        } catch (Throwable th10) {
                            th = th10;
                            tag3 = "HubCloud";
                            ref4 = ref4;
                            baseUrl4 = baseUrl4;
                            strText = null;
                            coroutine_suspended = coroutine_suspended;
                            c = 0;
                            $this2 = $this;
                            tag = url;
                            referer2 = referer;
                            function3 = function1;
                            function4 = function2;
                            baseUrl = raw;
                            uri = uri3;
                            baseUrl2 = baseUrl4;
                            tag2 = tag3;
                            ref = ref4;
                        }
                    } catch (Throwable th11) {
                        th = th11;
                        strText = null;
                        c = 0;
                    }
                } catch (Throwable th12) {
                    th = th12;
                    strText = null;
                }
                $this2 = $this;
                tag = url;
                referer2 = referer;
                function3 = function1;
                function4 = function2;
                baseUrl = raw;
                uri = uri3;
                baseUrl2 = baseUrl4;
                tag2 = tag3;
                ref = ref4;
                Result.Companion companion5 = Result.Companion;
                obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                url2 = tag;
                baseUrl3 = baseUrl2;
                realUrl = baseUrl;
                uri2 = uri;
                ref2 = ref;
                url3 = tag2;
                function5 = function4;
                function6 = function3;
                referer3 = referer2;
                it = Result.exceptionOrNull-impl(obj2);
                if (it != null) {
                    Log.INSTANCE.e(url3, "Failed to extract href: " + it.getMessage());
                    obj2 = "";
                }
                href = (String) obj2;
                if (StringsKt.isBlank(href)) {
                    return Unit.INSTANCE;
                }
                Requests app4 = MainActivityKt.getApp();
                c00083.L$0 = $this2;
                c00083.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                c00083.L$2 = SpillingKt.nullOutSpilledVariable(referer3);
                c00083.L$3 = function6;
                c00083.L$4 = function5;
                c00083.L$5 = url3;
                c00083.L$6 = ref2;
                c00083.L$7 = SpillingKt.nullOutSpilledVariable(uri2);
                c00083.L$8 = SpillingKt.nullOutSpilledVariable(realUrl);
                c00083.L$9 = SpillingKt.nullOutSpilledVariable(baseUrl3);
                c00083.L$10 = SpillingKt.nullOutSpilledVariable(href);
                c00083.label = 2;
                C00081 c00086 = c00083;
                $this3 = $this2;
                obj3 = Requests.get$default(app4, href, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00086, 4094, (Object) null);
                c00082 = c00086;
                if (obj3 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $result = obj3;
                href2 = href;
                ref3 = ref2;
                href3 = url2;
                $this4 = $this3;
                realUrl2 = url3;
                function7 = function5;
                function8 = function6;
                Document document3 = ((NiceResponse) $result).getDocument();
                elementSelectFirst2 = document3.selectFirst("i#size");
                if (elementSelectFirst2 != null) {
                    strText2 = elementSelectFirst2.text();
                } else {
                    strText2 = strText;
                }
                if (strText2 == null) {
                    strText2 = "";
                }
                size = strText2;
                elementSelectFirst3 = document3.selectFirst("div.card-header");
                if (elementSelectFirst3 != null) {
                    strText = elementSelectFirst3.text();
                }
                String header3 = strText != null ? strText : "";
                headerDetails = $this4.cleanTitle(header3);
                int quality3 = $this4.getIndexQuality(header3);
                $this$getUrl_u24lambda_u244 = new StringBuilder();
                if (headerDetails.length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    $this$getUrl_u24lambda_u245 = $this$getUrl_u24lambda_u244;
                    $this$getUrl_u24lambda_u245.append('[' + headerDetails + ']');
                } else {
                    $this$getUrl_u24lambda_u245 = $this$getUrl_u24lambda_u244;
                }
                if (size.length() > 0) {
                    c = 1;
                }
                if (c != 0) {
                    $this$getUrl_u24lambda_u245.append('[' + size + ']');
                }
                String labelExtras3 = $this$getUrl_u24lambda_u244.toString();
                listSelect = document3.select("a.btn");
                c00092 = new C00092(function7, ref3, labelExtras3, realUrl2, $this4, function8, quality3, null);
                c00082.L$0 = SpillingKt.nullOutSpilledVariable($this4);
                c00082.L$1 = SpillingKt.nullOutSpilledVariable(href3);
                c00082.L$2 = SpillingKt.nullOutSpilledVariable(referer3);
                c00082.L$3 = SpillingKt.nullOutSpilledVariable(function8);
                c00082.L$4 = SpillingKt.nullOutSpilledVariable(function7);
                c00082.L$5 = SpillingKt.nullOutSpilledVariable(realUrl2);
                c00082.L$6 = SpillingKt.nullOutSpilledVariable(ref3);
                c00082.L$7 = SpillingKt.nullOutSpilledVariable(uri2);
                c00082.L$8 = SpillingKt.nullOutSpilledVariable(realUrl);
                c00082.L$9 = SpillingKt.nullOutSpilledVariable(baseUrl3);
                c00082.L$10 = SpillingKt.nullOutSpilledVariable(href2);
                c00082.L$11 = SpillingKt.nullOutSpilledVariable(document3);
                c00082.L$12 = SpillingKt.nullOutSpilledVariable(size);
                c00082.L$13 = SpillingKt.nullOutSpilledVariable(header3);
                c00082.L$14 = SpillingKt.nullOutSpilledVariable(headerDetails);
                c00082.L$15 = SpillingKt.nullOutSpilledVariable(labelExtras3);
                c00082.I$0 = quality3;
                c00082.label = 3;
                if (ParCollectionsKt.amap(listSelect, c00092, c00082) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                $this$getUrl_u24lambda_u242 = (HubCloud) c00083.L$10;
                baseUrl2 = (String) c00083.L$9;
                baseUrl = (String) c00083.L$8;
                uri = (URI) c00083.L$7;
                ref = (String) c00083.L$6;
                tag2 = (String) c00083.L$5;
                function4 = (Function1) c00083.L$4;
                function3 = (Function1) c00083.L$3;
                referer2 = (String) c00083.L$2;
                tag = (String) c00083.L$1;
                HubCloud $this6 = (HubCloud) c00083.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    $this2 = $this6;
                    coroutine_suspended = coroutine_suspended;
                    c00083 = c00083;
                    $this$getUrl_u24lambda_u243 = null;
                    strText = null;
                    c = 0;
                    elementSelectFirst = ((NiceResponse) $result).getDocument().selectFirst("a[href*='hubcloud.php']");
                    if (elementSelectFirst != null) {
                        strAttr = elementSelectFirst.attr("href");
                    } else {
                        strAttr = strText;
                    }
                    if (strAttr == null) {
                        strAttr = "";
                    }
                    raw = strAttr;
                    $this5 = $this2;
                    if (StringsKt.startsWith(raw, "http", true)) {
                        $this2 = $this5;
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        char[] cArr3 = new char[1];
                        cArr3[c] = '/';
                        StringBuilder sbAppend2 = sb2.append(StringsKt.trimEnd(baseUrl2, cArr3)).append('/');
                        char[] cArr4 = new char[1];
                        cArr4[c] = '/';
                        String string2 = sbAppend2.append(StringsKt.trimStart(raw, cArr4)).toString();
                        $this2 = $this5;
                        raw = string2;
                    }
                    obj2 = Result.constructor-impl(raw);
                    break;
                } catch (Throwable th13) {
                    th = th13;
                    $this2 = $this6;
                    coroutine_suspended = coroutine_suspended;
                    c00083 = c00083;
                    strText = null;
                    c = 0;
                    break;
                }
                url2 = tag;
                baseUrl3 = baseUrl2;
                realUrl = baseUrl;
                uri2 = uri;
                ref2 = ref;
                url3 = tag2;
                function5 = function4;
                function6 = function3;
                referer3 = referer2;
                it = Result.exceptionOrNull-impl(obj2);
                if (it != null) {
                    Log.INSTANCE.e(url3, "Failed to extract href: " + it.getMessage());
                    obj2 = "";
                }
                href = (String) obj2;
                if (StringsKt.isBlank(href)) {
                    return Unit.INSTANCE;
                }
                Requests app5 = MainActivityKt.getApp();
                c00083.L$0 = $this2;
                c00083.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                c00083.L$2 = SpillingKt.nullOutSpilledVariable(referer3);
                c00083.L$3 = function6;
                c00083.L$4 = function5;
                c00083.L$5 = url3;
                c00083.L$6 = ref2;
                c00083.L$7 = SpillingKt.nullOutSpilledVariable(uri2);
                c00083.L$8 = SpillingKt.nullOutSpilledVariable(realUrl);
                c00083.L$9 = SpillingKt.nullOutSpilledVariable(baseUrl3);
                c00083.L$10 = SpillingKt.nullOutSpilledVariable(href);
                c00083.label = 2;
                C00081 c00087 = c00083;
                $this3 = $this2;
                obj3 = Requests.get$default(app5, href, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00087, 4094, (Object) null);
                c00082 = c00087;
                if (obj3 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $result = obj3;
                href2 = href;
                ref3 = ref2;
                href3 = url2;
                $this4 = $this3;
                realUrl2 = url3;
                function7 = function5;
                function8 = function6;
                Document document4 = ((NiceResponse) $result).getDocument();
                elementSelectFirst2 = document4.selectFirst("i#size");
                if (elementSelectFirst2 != null) {
                    strText2 = elementSelectFirst2.text();
                } else {
                    strText2 = strText;
                }
                if (strText2 == null) {
                    strText2 = "";
                }
                size = strText2;
                elementSelectFirst3 = document4.selectFirst("div.card-header");
                if (elementSelectFirst3 != null) {
                    strText = elementSelectFirst3.text();
                }
                String header4 = strText != null ? strText : "";
                headerDetails = $this4.cleanTitle(header4);
                int quality4 = $this4.getIndexQuality(header4);
                $this$getUrl_u24lambda_u244 = new StringBuilder();
                if (headerDetails.length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    $this$getUrl_u24lambda_u245 = $this$getUrl_u24lambda_u244;
                    $this$getUrl_u24lambda_u245.append('[' + headerDetails + ']');
                } else {
                    $this$getUrl_u24lambda_u245 = $this$getUrl_u24lambda_u244;
                }
                if (size.length() > 0) {
                    c = 1;
                }
                if (c != 0) {
                    $this$getUrl_u24lambda_u245.append('[' + size + ']');
                }
                String labelExtras4 = $this$getUrl_u24lambda_u244.toString();
                listSelect = document4.select("a.btn");
                c00092 = new C00092(function7, ref3, labelExtras4, realUrl2, $this4, function8, quality4, null);
                c00082.L$0 = SpillingKt.nullOutSpilledVariable($this4);
                c00082.L$1 = SpillingKt.nullOutSpilledVariable(href3);
                c00082.L$2 = SpillingKt.nullOutSpilledVariable(referer3);
                c00082.L$3 = SpillingKt.nullOutSpilledVariable(function8);
                c00082.L$4 = SpillingKt.nullOutSpilledVariable(function7);
                c00082.L$5 = SpillingKt.nullOutSpilledVariable(realUrl2);
                c00082.L$6 = SpillingKt.nullOutSpilledVariable(ref3);
                c00082.L$7 = SpillingKt.nullOutSpilledVariable(uri2);
                c00082.L$8 = SpillingKt.nullOutSpilledVariable(realUrl);
                c00082.L$9 = SpillingKt.nullOutSpilledVariable(baseUrl3);
                c00082.L$10 = SpillingKt.nullOutSpilledVariable(href2);
                c00082.L$11 = SpillingKt.nullOutSpilledVariable(document4);
                c00082.L$12 = SpillingKt.nullOutSpilledVariable(size);
                c00082.L$13 = SpillingKt.nullOutSpilledVariable(header4);
                c00082.L$14 = SpillingKt.nullOutSpilledVariable(headerDetails);
                c00082.L$15 = SpillingKt.nullOutSpilledVariable(labelExtras4);
                c00082.I$0 = quality4;
                c00082.label = 3;
                if (ParCollectionsKt.amap(listSelect, c00092, c00082) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 2:
                String href4 = (String) c00083.L$10;
                String baseUrl5 = (String) c00083.L$9;
                String realUrl3 = (String) c00083.L$8;
                URI uri4 = (URI) c00083.L$7;
                String ref5 = (String) c00083.L$6;
                String tag4 = (String) c00083.L$5;
                Function1<? super ExtractorLink, Unit> function9 = (Function1) c00083.L$4;
                Function1<? super SubtitleFile, Unit> function10 = (Function1) c00083.L$3;
                String referer4 = (String) c00083.L$2;
                String url4 = (String) c00083.L$1;
                HubCloud $this7 = (HubCloud) c00083.L$0;
                ResultKt.throwOnFailure($result);
                baseUrl3 = baseUrl5;
                referer3 = referer4;
                realUrl = realUrl3;
                uri2 = uri4;
                ref3 = ref5;
                realUrl2 = tag4;
                function8 = function10;
                strText = null;
                c = 0;
                $this4 = $this7;
                coroutine_suspended = coroutine_suspended;
                c00082 = c00083;
                href2 = href4;
                href3 = url4;
                function7 = function9;
                Document document5 = ((NiceResponse) $result).getDocument();
                elementSelectFirst2 = document5.selectFirst("i#size");
                if (elementSelectFirst2 != null) {
                    strText2 = elementSelectFirst2.text();
                } else {
                    strText2 = strText;
                }
                if (strText2 == null) {
                    strText2 = "";
                }
                size = strText2;
                elementSelectFirst3 = document5.selectFirst("div.card-header");
                if (elementSelectFirst3 != null) {
                    strText = elementSelectFirst3.text();
                }
                String header5 = strText != null ? strText : "";
                headerDetails = $this4.cleanTitle(header5);
                int quality5 = $this4.getIndexQuality(header5);
                $this$getUrl_u24lambda_u244 = new StringBuilder();
                if (headerDetails.length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    $this$getUrl_u24lambda_u245 = $this$getUrl_u24lambda_u244;
                    $this$getUrl_u24lambda_u245.append('[' + headerDetails + ']');
                } else {
                    $this$getUrl_u24lambda_u245 = $this$getUrl_u24lambda_u244;
                }
                if (size.length() > 0) {
                    c = 1;
                }
                if (c != 0) {
                    $this$getUrl_u24lambda_u245.append('[' + size + ']');
                }
                String labelExtras5 = $this$getUrl_u24lambda_u244.toString();
                listSelect = document5.select("a.btn");
                c00092 = new C00092(function7, ref3, labelExtras5, realUrl2, $this4, function8, quality5, null);
                c00082.L$0 = SpillingKt.nullOutSpilledVariable($this4);
                c00082.L$1 = SpillingKt.nullOutSpilledVariable(href3);
                c00082.L$2 = SpillingKt.nullOutSpilledVariable(referer3);
                c00082.L$3 = SpillingKt.nullOutSpilledVariable(function8);
                c00082.L$4 = SpillingKt.nullOutSpilledVariable(function7);
                c00082.L$5 = SpillingKt.nullOutSpilledVariable(realUrl2);
                c00082.L$6 = SpillingKt.nullOutSpilledVariable(ref3);
                c00082.L$7 = SpillingKt.nullOutSpilledVariable(uri2);
                c00082.L$8 = SpillingKt.nullOutSpilledVariable(realUrl);
                c00082.L$9 = SpillingKt.nullOutSpilledVariable(baseUrl3);
                c00082.L$10 = SpillingKt.nullOutSpilledVariable(href2);
                c00082.L$11 = SpillingKt.nullOutSpilledVariable(document5);
                c00082.L$12 = SpillingKt.nullOutSpilledVariable(size);
                c00082.L$13 = SpillingKt.nullOutSpilledVariable(header5);
                c00082.L$14 = SpillingKt.nullOutSpilledVariable(headerDetails);
                c00082.L$15 = SpillingKt.nullOutSpilledVariable(labelExtras5);
                c00082.I$0 = quality5;
                c00082.label = 3;
                if (ParCollectionsKt.amap(listSelect, c00092, c00082) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 3:
                int i = c00083.I$0;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.movies4u.HubCloud$getUrl$2 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "element", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.movies4u.HubCloud$getUrl$2", f = "Extractor.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8}, l = {342, 352, 361, 367, 385, 395, 405, 415, 424}, m = "invokeSuspend", n = {"element", "link", "text", "label", "element", "link", "text", "label", "element", "link", "text", "label", "element", "link", "text", "label", "resp", "dlink", "element", "link", "text", "label", "base", "finalUrl", "element", "link", "text", "label", "element", "link", "text", "label", "element", "link", "text", "label", "element", "link", "text", "label"}, nl = {341, 351, 362, 366, 384, 394, 404, 414, 426}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"}, v = 2)
    static final class C00092 extends SuspendLambda implements Function2<Element, Continuation<? super Object>, Object> {
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
        C00092(Function1<? super ExtractorLink, Unit> function1, String str, String str2, String str3, HubCloud hubCloud, Function1<? super SubtitleFile, Unit> function2, int i, Continuation<? super C00092> continuation) {
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
            Continuation<Unit> c00092 = new C00092(this.$callback, this.$ref, this.$labelExtras, this.$tag, this.this$0, this.$subtitleCallback, this.$quality, continuation);
            c00092.L$0 = obj;
            return c00092;
        }

        public final Object invoke(Element element, Continuation<Object> continuation) {
            return create(element, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:37:0x028c  */
        /* JADX WARN: Code duplicated, block: B:40:0x0299  */
        /* JADX WARN: Code duplicated, block: B:41:0x029b  */
        /* JADX WARN: Code duplicated, block: B:44:0x02a6  */
        /* JADX WARN: Code duplicated, block: B:46:0x031b A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:47:0x031c  */
        /* JADX WARN: Code duplicated, block: B:49:0x0327  */
        public final Object invokeSuspend(Object $result) {
            String label;
            Function1<ExtractorLink, Unit> function1;
            String link;
            String text;
            Object obj;
            String label2;
            Function1<ExtractorLink, Unit> function2;
            Object obj2;
            String text2;
            String text3;
            Function1<ExtractorLink, Unit> function3;
            Object obj3;
            String text4;
            String text5;
            Function1<ExtractorLink, Unit> function4;
            Object obj4;
            String text6;
            String text7;
            Object obj5;
            String link2;
            String link3;
            String text8;
            Object objNewExtractorLink$default;
            Function1<ExtractorLink, Unit> function5;
            String text9;
            Object objNewExtractorLink$default2;
            Function1<ExtractorLink, Unit> function6;
            String text10;
            NiceResponse resp;
            String str;
            String dlink;
            String link4;
            Function1<ExtractorLink, Unit> function7;
            Object objNewExtractorLink$default3;
            Function1<ExtractorLink, Unit> function8;
            String text11;
            String str2;
            Element element = (Element) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            String str3 = "";
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String link5 = element.attr("href");
                    String text12 = element.ownText();
                    String lowerCase = text12.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    label = lowerCase;
                    Log.INSTANCE.d("Phisher", label);
                    if (StringsKt.contains$default(label, "fsl server", false, 2, (Object) null)) {
                        Function1<ExtractorLink, Unit> function9 = this.$callback;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(element);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(link5);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(text12);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(label);
                        this.L$4 = function9;
                        this.label = 1;
                        objNewExtractorLink$default2 = ExtractorApiKt.newExtractorLink$default(this.$ref + " [FSL Server]", this.$ref + " [FSL Server] " + this.$labelExtras, link5, (ExtractorLinkType) null, new AnonymousClass1(this.$quality, null), (Continuation) this, 8, (Object) null);
                        if (objNewExtractorLink$default2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function6 = function9;
                        text10 = link5;
                        function6.invoke(objNewExtractorLink$default2);
                        return Unit.INSTANCE;
                    }
                    if (StringsKt.contains$default(label, "download file", false, 2, (Object) null)) {
                        Function1<ExtractorLink, Unit> function10 = this.$callback;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(element);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(link5);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(text12);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(label);
                        this.L$4 = function10;
                        this.label = 2;
                        objNewExtractorLink$default = ExtractorApiKt.newExtractorLink$default(this.$ref, this.$ref + ' ' + this.$labelExtras, link5, (ExtractorLinkType) null, new AnonymousClass2(this.$quality, null), (Continuation) this, 8, (Object) null);
                        if (objNewExtractorLink$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function5 = function10;
                        text9 = link5;
                        function5.invoke(objNewExtractorLink$default);
                        return Unit.INSTANCE;
                    }
                    if (StringsKt.contains$default(label, "buzzserver", false, 2, (Object) null)) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(element);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(link5);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(text12);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(label);
                        this.label = 3;
                        obj5 = Requests.get$default(MainActivityKt.getApp(), link5 + "/download", (Map) null, link5, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4058, (Object) null);
                        if (obj5 == coroutine_suspended) {
                            link2 = link5;
                            return coroutine_suspended;
                        }
                        link2 = link5;
                        link3 = text12;
                        text8 = label;
                        resp = (NiceResponse) obj5;
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
                            link4 = link2;
                        } else {
                            function7 = this.$callback;
                            this.L$0 = SpillingKt.nullOutSpilledVariable(element);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(link2);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(link3);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(text8);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(resp);
                            this.L$5 = SpillingKt.nullOutSpilledVariable(dlink);
                            this.L$6 = function7;
                            this.label = 4;
                            objNewExtractorLink$default3 = ExtractorApiKt.newExtractorLink$default(this.$ref + " [BuzzServer]", this.$ref + " [BuzzServer] " + this.$labelExtras, dlink, (ExtractorLinkType) null, new AnonymousClass3(this.$quality, null), (Continuation) this, 8, (Object) null);
                            if (objNewExtractorLink$default3 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            function8 = function7;
                            text11 = text8;
                            function8.invoke(objNewExtractorLink$default3);
                            link4 = link2;
                        }
                        return Unit.INSTANCE;
                    }
                    if (StringsKt.contains$default(label, "pixeldra", false, 2, (Object) null) || StringsKt.contains$default(label, "pixelserver", false, 2, (Object) null) || StringsKt.contains$default(label, "pixel server", false, 2, (Object) null) || StringsKt.contains$default(label, "pixeldrain", false, 2, (Object) null)) {
                        String base = this.this$0.getBaseUrl(link5);
                        String finalUrl = StringsKt.contains$default(link5, "download", false, 2, (Object) null) ? link5 : base + "/api/file/" + StringsKt.substringAfterLast$default(link5, "/", (String) null, 2, (Object) null) + "?download";
                        Function1<ExtractorLink, Unit> function11 = this.$callback;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(element);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(link5);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(text12);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(label);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(base);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(finalUrl);
                        this.L$6 = function11;
                        this.label = 5;
                        Object objNewExtractorLink$default4 = ExtractorApiKt.newExtractorLink$default(this.$ref + " Pixeldrain", this.$ref + " Pixeldrain " + this.$labelExtras, finalUrl, (ExtractorLinkType) null, new AnonymousClass4(this.$quality, null), (Continuation) this, 8, (Object) null);
                        if (objNewExtractorLink$default4 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function1 = function11;
                        link = link5;
                        text = text12;
                        obj = objNewExtractorLink$default4;
                        label2 = label;
                        function1.invoke(obj);
                        return Unit.INSTANCE;
                    }
                    if (StringsKt.contains$default(label, "s3 server", false, 2, (Object) null)) {
                        Function1<ExtractorLink, Unit> function12 = this.$callback;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(element);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(link5);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(text12);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(label);
                        this.L$4 = function12;
                        this.label = 6;
                        Object objNewExtractorLink$default5 = ExtractorApiKt.newExtractorLink$default(this.$ref + " [S3 Server]", this.$ref + " [S3 Server] " + this.$labelExtras, link5, (ExtractorLinkType) null, new AnonymousClass5(this.$quality, null), (Continuation) this, 8, (Object) null);
                        if (objNewExtractorLink$default5 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function4 = function12;
                        obj4 = objNewExtractorLink$default5;
                        text6 = text12;
                        text7 = label;
                        function4.invoke(obj4);
                        return Unit.INSTANCE;
                    }
                    if (StringsKt.contains$default(label, "fslv2", false, 2, (Object) null)) {
                        Function1<ExtractorLink, Unit> function13 = this.$callback;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(element);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(link5);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(text12);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(label);
                        this.L$4 = function13;
                        this.label = 7;
                        Object objNewExtractorLink$default6 = ExtractorApiKt.newExtractorLink$default(this.$ref + " [FSLv2]", this.$ref + " [FSLv2] " + this.$labelExtras, link5, (ExtractorLinkType) null, new AnonymousClass6(this.$quality, null), (Continuation) this, 8, (Object) null);
                        if (objNewExtractorLink$default6 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function3 = function13;
                        obj3 = objNewExtractorLink$default6;
                        text4 = text12;
                        text5 = label;
                        function3.invoke(obj3);
                        return Unit.INSTANCE;
                    }
                    if (!StringsKt.contains$default(label, "mega server", false, 2, (Object) null)) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(element);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(link5);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(text12);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(label);
                        this.label = 9;
                        Object objLoadExtractor = ExtractorApiKt.loadExtractor(link5, "", this.$subtitleCallback, this.$callback, (Continuation) this);
                        return objLoadExtractor == coroutine_suspended ? coroutine_suspended : objLoadExtractor;
                    }
                    Function1<ExtractorLink, Unit> function14 = this.$callback;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(element);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(link5);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(text12);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(label);
                    this.L$4 = function14;
                    this.label = 8;
                    Object objNewExtractorLink$default7 = ExtractorApiKt.newExtractorLink$default(this.$ref + " [Mega Server]", this.$ref + " [Mega Server] " + this.$labelExtras, link5, (ExtractorLinkType) null, new AnonymousClass7(this.$quality, null), (Continuation) this, 8, (Object) null);
                    if (objNewExtractorLink$default7 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function2 = function14;
                    obj2 = objNewExtractorLink$default7;
                    text2 = text12;
                    text3 = label;
                    function2.invoke(obj2);
                    return Unit.INSTANCE;
                case 1:
                    function6 = (Function1) this.L$4;
                    String label3 = (String) this.L$3;
                    String link6 = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    label = label3;
                    text10 = link6;
                    objNewExtractorLink$default2 = $result;
                    function6.invoke(objNewExtractorLink$default2);
                    return Unit.INSTANCE;
                case 2:
                    function5 = (Function1) this.L$4;
                    String label4 = (String) this.L$3;
                    String link7 = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    label = label4;
                    text9 = link7;
                    objNewExtractorLink$default = $result;
                    function5.invoke(objNewExtractorLink$default);
                    return Unit.INSTANCE;
                case 3:
                    text8 = (String) this.L$3;
                    String text13 = (String) this.L$2;
                    String link8 = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    link2 = link8;
                    link3 = text13;
                    obj5 = $result;
                    resp = (NiceResponse) obj5;
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
                        function7 = this.$callback;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(element);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(link2);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(link3);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(text8);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(resp);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(dlink);
                        this.L$6 = function7;
                        this.label = 4;
                        objNewExtractorLink$default3 = ExtractorApiKt.newExtractorLink$default(this.$ref + " [BuzzServer]", this.$ref + " [BuzzServer] " + this.$labelExtras, dlink, (ExtractorLinkType) null, new AnonymousClass3(this.$quality, null), (Continuation) this, 8, (Object) null);
                        if (objNewExtractorLink$default3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function8 = function7;
                        text11 = text8;
                        function8.invoke(objNewExtractorLink$default3);
                        link4 = link2;
                    } else {
                        Log.INSTANCE.w(this.$tag, "BuzzServer: No redirect");
                        link4 = link2;
                    }
                    return Unit.INSTANCE;
                case 4:
                    function8 = (Function1) this.L$6;
                    String label5 = (String) this.L$3;
                    String text14 = (String) this.L$2;
                    String link9 = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    link2 = link9;
                    link3 = text14;
                    text11 = label5;
                    objNewExtractorLink$default3 = $result;
                    function8.invoke(objNewExtractorLink$default3);
                    link4 = link2;
                    return Unit.INSTANCE;
                case 5:
                    function1 = (Function1) this.L$6;
                    label2 = (String) this.L$3;
                    text = (String) this.L$2;
                    link = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    obj = $result;
                    function1.invoke(obj);
                    return Unit.INSTANCE;
                case 6:
                    function4 = (Function1) this.L$4;
                    text7 = (String) this.L$3;
                    text6 = (String) this.L$2;
                    ResultKt.throwOnFailure($result);
                    obj4 = $result;
                    function4.invoke(obj4);
                    return Unit.INSTANCE;
                case 7:
                    function3 = (Function1) this.L$4;
                    text5 = (String) this.L$3;
                    text4 = (String) this.L$2;
                    ResultKt.throwOnFailure($result);
                    obj3 = $result;
                    function3.invoke(obj3);
                    return Unit.INSTANCE;
                case 8:
                    function2 = (Function1) this.L$4;
                    text3 = (String) this.L$3;
                    text2 = (String) this.L$2;
                    ResultKt.throwOnFailure($result);
                    obj2 = $result;
                    function2.invoke(obj2);
                    return Unit.INSTANCE;
                case 9:
                    ResultKt.throwOnFailure($result);
                    return $result;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.movies4u.HubCloud$getUrl$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: Extractor.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.movies4u.HubCloud$getUrl$2$1", f = "Extractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
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

        /* JADX INFO: renamed from: com.movies4u.HubCloud$getUrl$2$2, reason: invalid class name */
        /* JADX INFO: compiled from: Extractor.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.movies4u.HubCloud$getUrl$2$2", f = "Extractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
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

        /* JADX INFO: renamed from: com.movies4u.HubCloud$getUrl$2$3, reason: invalid class name */
        /* JADX INFO: compiled from: Extractor.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.movies4u.HubCloud$getUrl$2$3", f = "Extractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
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

        /* JADX INFO: renamed from: com.movies4u.HubCloud$getUrl$2$4, reason: invalid class name */
        /* JADX INFO: compiled from: Extractor.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.movies4u.HubCloud$getUrl$2$4", f = "Extractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
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

        /* JADX INFO: renamed from: com.movies4u.HubCloud$getUrl$2$5, reason: invalid class name */
        /* JADX INFO: compiled from: Extractor.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.movies4u.HubCloud$getUrl$2$5", f = "Extractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
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

        /* JADX INFO: renamed from: com.movies4u.HubCloud$getUrl$2$6, reason: invalid class name */
        /* JADX INFO: compiled from: Extractor.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.movies4u.HubCloud$getUrl$2$6", f = "Extractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
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

        /* JADX INFO: renamed from: com.movies4u.HubCloud$getUrl$2$7, reason: invalid class name */
        /* JADX INFO: compiled from: Extractor.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.movies4u.HubCloud$getUrl$2$7", f = "Extractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
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
