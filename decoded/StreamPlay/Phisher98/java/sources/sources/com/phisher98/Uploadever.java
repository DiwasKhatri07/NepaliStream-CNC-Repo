package com.phisher98;

import com.lagradost.cloudstream3.APIHolder;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import com.lagradost.cloudstream3.utils.Qualities;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/phisher98/Uploadever;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractors.kt\ncom/phisher98/Uploadever\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,4003:1\n1358#2,2:4004\n1435#2,4:4006\n1358#2,2:4017\n1435#2,4:4019\n635#3,7:4010\n*S KotlinDebug\n*F\n+ 1 Extractors.kt\ncom/phisher98/Uploadever\n*L\n533#1:4004,2\n533#1:4006,4\n543#1:4017,2\n543#1:4019,4\n534#1:4010,7\n*E\n"})
public class Uploadever extends ExtractorApi {

    @NotNull
    private final String name = "Uploadever";

    @NotNull
    private final String mainUrl = "https://uploadever.in";
    private final boolean requiresReferer = true;

    /* JADX INFO: renamed from: com.phisher98.Uploadever$getUrl$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Uploadever", f = "Extractors.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {531, 536, 542, 547, 555}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "subtitleCallback", "callback", "$this", "url", "referer", "subtitleCallback", "callback", "res", "formUrl", "formData", "$this", "url", "referer", "subtitleCallback", "callback", "res", "formUrl", "formData", "formReq", "captchaKey", "$this", "url", "referer", "subtitleCallback", "callback", "res", "formUrl", "formData", "formReq", "captchaKey", "token", "$this", "url", "referer", "subtitleCallback", "callback", "res", "formUrl", "formData", "formReq", "captchaKey", "token", "video"}, nl = {532, 538, 544, 551, 554}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11"}, v = 2)
    static final class C03021 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
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

        C03021(Continuation<? super C03021> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Uploadever.getUrl$suspendImpl(Uploadever.this, null, null, null, null, (Continuation) this);
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

    /* JADX WARN: Code duplicated, block: B:24:0x01fe A[LOOP:1: B:22:0x01f8->B:24:0x01fe, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:28:0x024e  */
    /* JADX WARN: Code duplicated, block: B:33:0x02e7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:34:0x02e8  */
    /* JADX WARN: Code duplicated, block: B:37:0x035b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:38:0x035c  */
    /* JADX WARN: Code duplicated, block: B:42:0x039b A[LOOP:0: B:40:0x0395->B:42:0x039b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:45:0x0488 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:46:0x0489  */
    /* JADX WARN: Code duplicated, block: B:49:0x0511 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:50:0x0512  */
    /* JADX WARN: Code duplicated, block: B:56:0x0263 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:58:0x0248 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    static /* synthetic */ Object getUrl$suspendImpl(Uploadever $this, String url, String referer, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super Unit> continuation) {
        C03021 c03021;
        Object obj;
        String str;
        int i;
        String url2;
        String referer2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        Object obj2;
        Uploadever $this2;
        Document res;
        String formUrl;
        Iterable $this$associate$iv;
        Map $this$filterKeys$iv;
        String formUrl2;
        LinkedHashMap result$iv;
        Map formData;
        Function1<? super ExtractorLink, Unit> function5;
        String url3;
        String formUrl3;
        Uploadever $this3;
        int i2;
        Object objPost$default;
        String formUrl4;
        Map formData2;
        String url4;
        String referer3;
        Function1<? super SubtitleFile, Unit> function6;
        Function1<? super ExtractorLink, Unit> function7;
        Object obj3;
        Uploadever $this4;
        String str2;
        NiceResponse formReq;
        Document res2;
        String captchaKey;
        Object captchaToken;
        String captchaKey2;
        Uploadever $this5;
        String formUrl5;
        Document res3;
        String referer4;
        NiceResponse formReq2;
        String url5;
        Function1<? super ExtractorLink, Unit> function8;
        Function1<? super SubtitleFile, Unit> function9;
        String token;
        Iterable $this$associate$iv2;
        Map destination$iv$iv;
        Map formData3;
        String url6;
        Function1<? super ExtractorLink, Unit> function10;
        Uploadever $this6;
        Continuation continuation2;
        Object objPost$default2;
        String url7;
        String url8;
        Function1<? super SubtitleFile, Unit> function11;
        Function1<? super ExtractorLink, Unit> function12;
        Object objNewExtractorLink;
        Function1<? super ExtractorLink, Unit> function13;
        if (continuation instanceof C03021) {
            c03021 = (C03021) continuation;
            if ((c03021.label & Integer.MIN_VALUE) != 0) {
                c03021.label -= Integer.MIN_VALUE;
            } else {
                c03021 = $this.new C03021(continuation);
            }
        } else {
            c03021 = $this.new C03021(continuation);
        }
        C03021 c03022 = c03021;
        Object $result = c03022.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c03022.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                Requests app = MainActivityKt.getApp();
                c03022.L$0 = $this;
                c03022.L$1 = url;
                c03022.L$2 = SpillingKt.nullOutSpilledVariable(referer);
                c03022.L$3 = SpillingKt.nullOutSpilledVariable(function1);
                c03022.L$4 = function2;
                c03022.label = 1;
                str = "value";
                i = 10;
                Object obj4 = Requests.get$default(app, url, (Map) null, referer, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c03022, 4090, (Object) null);
                c03022 = c03022;
                if (obj4 == obj) {
                    return obj;
                }
                url2 = url;
                referer2 = referer;
                function3 = function1;
                function4 = function2;
                obj2 = obj4;
                $this2 = $this;
                res = ((NiceResponse) obj2).getDocument();
                formUrl = res.select("form").attr("action");
                $this$associate$iv = res.select("form input");
                int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv, i)), 16);
                $this$filterKeys$iv = new LinkedHashMap(capacity$iv);
                for (Object element$iv$iv : $this$associate$iv) {
                    Element it = (Element) element$iv$iv;
                    String formUrl6 = formUrl;
                    String formUrl7 = str;
                    Pair pair = TuplesKt.to(it.attr("name"), it.attr(formUrl7));
                    $this$filterKeys$iv.put(pair.getFirst(), pair.getSecond());
                    res = res;
                    $this$associate$iv = $this$associate$iv;
                    formUrl = formUrl6;
                }
                Document res4 = res;
                formUrl2 = formUrl;
                String formUrl8 = str;
                result$iv = new LinkedHashMap();
                for (Map.Entry entry$iv : $this$filterKeys$iv.entrySet()) {
                    if (!Intrinsics.areEqual((String) entry$iv.getKey(), "go")) {
                        result$iv.put(entry$iv.getKey(), entry$iv.getValue());
                    }
                }
                formData = MapsKt.toMutableMap(result$iv);
                Requests app2 = MainActivityKt.getApp();
                c03022.L$0 = $this2;
                c03022.L$1 = url2;
                c03022.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                c03022.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                c03022.L$4 = function4;
                c03022.L$5 = SpillingKt.nullOutSpilledVariable(res4);
                c03022.L$6 = SpillingKt.nullOutSpilledVariable(formUrl2);
                c03022.L$7 = SpillingKt.nullOutSpilledVariable(formData);
                c03022.label = 2;
                function5 = function4;
                C03021 c03023 = c03022;
                url3 = url2;
                formUrl3 = formUrl8;
                $this3 = $this2;
                i2 = 2;
                objPost$default = Requests.post$default(app2, formUrl2, (Map) null, (String) null, (Map) null, (Map) null, formData, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c03023, 65502, (Object) null);
                c03022 = c03023;
                if (objPost$default == obj) {
                    return obj;
                }
                formUrl4 = formUrl2;
                formData2 = formData;
                url4 = url3;
                referer3 = referer2;
                function6 = function3;
                function7 = function5;
                obj3 = objPost$default;
                $this4 = $this3;
                formReq = (NiceResponse) obj3;
                res2 = formReq.getDocument();
                captchaKey = StringsKt.substringAfter$default(res2.select("script[src*=https://www.google.com/recaptcha/api.js?render=]").attr("src"), "render=", (String) null, i2, (Object) null);
                APIHolder aPIHolder = APIHolder.INSTANCE;
                String str3 = $this4.getMainUrl() + '/';
                c03022.L$0 = $this4;
                c03022.L$1 = url4;
                c03022.L$2 = SpillingKt.nullOutSpilledVariable(referer3);
                c03022.L$3 = SpillingKt.nullOutSpilledVariable(function6);
                c03022.L$4 = function7;
                c03022.L$5 = res2;
                c03022.L$6 = SpillingKt.nullOutSpilledVariable(formUrl4);
                c03022.L$7 = SpillingKt.nullOutSpilledVariable(formData2);
                c03022.L$8 = formReq;
                c03022.L$9 = SpillingKt.nullOutSpilledVariable(captchaKey);
                c03022.label = 3;
                captchaToken = aPIHolder.getCaptchaToken(url4, captchaKey, str3, c03022);
                if (captchaToken == obj) {
                    return obj;
                }
                captchaKey2 = captchaKey;
                $this5 = $this4;
                formUrl5 = formUrl4;
                res3 = res2;
                referer4 = referer3;
                formReq2 = formReq;
                url5 = url4;
                function8 = function7;
                function9 = function6;
                token = (String) captchaToken;
                $this$associate$iv2 = res3.select("form#down input");
                int capacity$iv2 = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv2, 10)), 16);
                destination$iv$iv = new LinkedHashMap(capacity$iv2);
                for (Object element$iv$iv2 : $this$associate$iv2) {
                    Document res5 = res3;
                    Element it2 = (Element) element$iv$iv2;
                    Iterable $this$associate$iv3 = $this$associate$iv2;
                    String strAttr = it2.attr(str2);
                    String str4 = str2;
                    String str5 = formUrl3;
                    Pair pair2 = TuplesKt.to(strAttr, it2.attr(str5));
                    destination$iv$iv.put(pair2.getFirst(), pair2.getSecond());
                    $this$associate$iv2 = $this$associate$iv3;
                    formData2 = formData2;
                    formUrl3 = str5;
                    res3 = res5;
                    str2 = str4;
                }
                Document res6 = res3;
                formData3 = MapsKt.toMutableMap(destination$iv$iv);
                formData3.put("adblock_detected", "0");
                formData3.put("referer", url5);
                Requests app3 = MainActivityKt.getApp();
                url6 = url5;
                String url9 = formReq2.getUrl();
                Map mapPlus = MapsKt.plus(formData3, MapsKt.mapOf(TuplesKt.to("g-recaptcha-response", String.valueOf(token))));
                Map cookies = formReq2.getCookies();
                c03022.L$0 = $this5;
                c03022.L$1 = SpillingKt.nullOutSpilledVariable(url6);
                c03022.L$2 = SpillingKt.nullOutSpilledVariable(referer4);
                c03022.L$3 = SpillingKt.nullOutSpilledVariable(function9);
                c03022.L$4 = function8;
                c03022.L$5 = SpillingKt.nullOutSpilledVariable(res6);
                c03022.L$6 = SpillingKt.nullOutSpilledVariable(formUrl5);
                c03022.L$7 = SpillingKt.nullOutSpilledVariable(formData3);
                c03022.L$8 = SpillingKt.nullOutSpilledVariable(formReq2);
                c03022.L$9 = SpillingKt.nullOutSpilledVariable(captchaKey2);
                c03022.L$10 = SpillingKt.nullOutSpilledVariable(token);
                c03022.label = 4;
                function10 = function8;
                C03021 c03024 = c03022;
                $this6 = $this5;
                continuation2 = null;
                objPost$default2 = Requests.post$default(app3, url9, (Map) null, (String) null, (Map) null, cookies, mapPlus, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c03024, 65486, (Object) null);
                c03022 = c03024;
                if (objPost$default2 == obj) {
                    return obj;
                }
                url7 = url6;
                url8 = referer4;
                function11 = function9;
                function12 = function10;
                Document res7 = ((NiceResponse) objPost$default2).getDocument();
                String video = res7.select("div.download-button a.btn.btn-dow.recaptchav2").attr("href");
                String name = $this6.getName();
                String name2 = $this6.getName();
                ExtractorLinkType infer_type = ExtractorApiKt.getINFER_TYPE();
                C03033 c03033 = new C03033(continuation2);
                c03022.L$0 = SpillingKt.nullOutSpilledVariable($this6);
                c03022.L$1 = SpillingKt.nullOutSpilledVariable(url7);
                c03022.L$2 = SpillingKt.nullOutSpilledVariable(url8);
                c03022.L$3 = SpillingKt.nullOutSpilledVariable(function11);
                c03022.L$4 = SpillingKt.nullOutSpilledVariable(function12);
                c03022.L$5 = SpillingKt.nullOutSpilledVariable(res7);
                c03022.L$6 = SpillingKt.nullOutSpilledVariable(formUrl5);
                c03022.L$7 = SpillingKt.nullOutSpilledVariable(formData3);
                c03022.L$8 = SpillingKt.nullOutSpilledVariable(formReq2);
                c03022.L$9 = SpillingKt.nullOutSpilledVariable(captchaKey2);
                c03022.L$10 = SpillingKt.nullOutSpilledVariable(token);
                c03022.L$11 = SpillingKt.nullOutSpilledVariable(video);
                c03022.L$12 = function12;
                c03022.label = 5;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(name, name2, video, infer_type, c03033, c03022);
                if (objNewExtractorLink == obj) {
                    return obj;
                }
                function13 = function12;
                function13.invoke(objNewExtractorLink);
                return Unit.INSTANCE;
            case 1:
                Function1<? super ExtractorLink, Unit> function14 = (Function1) c03022.L$4;
                Function1<? super SubtitleFile, Unit> function15 = (Function1) c03022.L$3;
                String referer5 = (String) c03022.L$2;
                String url10 = (String) c03022.L$1;
                Uploadever $this7 = (Uploadever) c03022.L$0;
                ResultKt.throwOnFailure($result);
                function3 = function15;
                str = "value";
                referer2 = referer5;
                url2 = url10;
                function4 = function14;
                obj = coroutine_suspended;
                $this2 = $this7;
                obj2 = $result;
                i = 10;
                res = ((NiceResponse) obj2).getDocument();
                formUrl = res.select("form").attr("action");
                $this$associate$iv = res.select("form input");
                int capacity$iv3 = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv, i)), 16);
                $this$filterKeys$iv = new LinkedHashMap(capacity$iv3);
                while (r15.hasNext()) {
                    Element it3 = (Element) element$iv$iv;
                    String formUrl9 = formUrl;
                    String formUrl10 = str;
                    Pair pair3 = TuplesKt.to(it3.attr("name"), it3.attr(formUrl10));
                    $this$filterKeys$iv.put(pair3.getFirst(), pair3.getSecond());
                    res = res;
                    $this$associate$iv = $this$associate$iv;
                    formUrl = formUrl9;
                }
                Document res8 = res;
                formUrl2 = formUrl;
                String formUrl11 = str;
                result$iv = new LinkedHashMap();
                while (r9.hasNext()) {
                    if (!Intrinsics.areEqual((String) entry$iv.getKey(), "go")) {
                        result$iv.put(entry$iv.getKey(), entry$iv.getValue());
                    }
                }
                formData = MapsKt.toMutableMap(result$iv);
                Requests app4 = MainActivityKt.getApp();
                c03022.L$0 = $this2;
                c03022.L$1 = url2;
                c03022.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                c03022.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                c03022.L$4 = function4;
                c03022.L$5 = SpillingKt.nullOutSpilledVariable(res8);
                c03022.L$6 = SpillingKt.nullOutSpilledVariable(formUrl2);
                c03022.L$7 = SpillingKt.nullOutSpilledVariable(formData);
                c03022.label = 2;
                function5 = function4;
                C03021 c03025 = c03022;
                url3 = url2;
                formUrl3 = formUrl11;
                $this3 = $this2;
                i2 = 2;
                objPost$default = Requests.post$default(app4, formUrl2, (Map) null, (String) null, (Map) null, (Map) null, formData, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c03025, 65502, (Object) null);
                c03022 = c03025;
                if (objPost$default == obj) {
                    return obj;
                }
                formUrl4 = formUrl2;
                formData2 = formData;
                url4 = url3;
                referer3 = referer2;
                function6 = function3;
                function7 = function5;
                obj3 = objPost$default;
                $this4 = $this3;
                formReq = (NiceResponse) obj3;
                res2 = formReq.getDocument();
                captchaKey = StringsKt.substringAfter$default(res2.select("script[src*=https://www.google.com/recaptcha/api.js?render=]").attr("src"), "render=", (String) null, i2, (Object) null);
                APIHolder aPIHolder2 = APIHolder.INSTANCE;
                String str6 = $this4.getMainUrl() + '/';
                c03022.L$0 = $this4;
                c03022.L$1 = url4;
                c03022.L$2 = SpillingKt.nullOutSpilledVariable(referer3);
                c03022.L$3 = SpillingKt.nullOutSpilledVariable(function6);
                c03022.L$4 = function7;
                c03022.L$5 = res2;
                c03022.L$6 = SpillingKt.nullOutSpilledVariable(formUrl4);
                c03022.L$7 = SpillingKt.nullOutSpilledVariable(formData2);
                c03022.L$8 = formReq;
                c03022.L$9 = SpillingKt.nullOutSpilledVariable(captchaKey);
                c03022.label = 3;
                captchaToken = aPIHolder2.getCaptchaToken(url4, captchaKey, str6, c03022);
                if (captchaToken == obj) {
                    return obj;
                }
                captchaKey2 = captchaKey;
                $this5 = $this4;
                formUrl5 = formUrl4;
                res3 = res2;
                referer4 = referer3;
                formReq2 = formReq;
                url5 = url4;
                function8 = function7;
                function9 = function6;
                token = (String) captchaToken;
                $this$associate$iv2 = res3.select("form#down input");
                int capacity$iv4 = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv2, 10)), 16);
                destination$iv$iv = new LinkedHashMap(capacity$iv4);
                while (r14.hasNext()) {
                    Document res9 = res3;
                    Element it4 = (Element) element$iv$iv2;
                    Iterable $this$associate$iv4 = $this$associate$iv2;
                    String strAttr2 = it4.attr(str2);
                    String str7 = str2;
                    String str8 = formUrl3;
                    Pair pair4 = TuplesKt.to(strAttr2, it4.attr(str8));
                    destination$iv$iv.put(pair4.getFirst(), pair4.getSecond());
                    $this$associate$iv2 = $this$associate$iv4;
                    formData2 = formData2;
                    formUrl3 = str8;
                    res3 = res9;
                    str2 = str7;
                }
                Document res10 = res3;
                formData3 = MapsKt.toMutableMap(destination$iv$iv);
                formData3.put("adblock_detected", "0");
                formData3.put("referer", url5);
                Requests app5 = MainActivityKt.getApp();
                url6 = url5;
                String url11 = formReq2.getUrl();
                Map mapPlus2 = MapsKt.plus(formData3, MapsKt.mapOf(TuplesKt.to("g-recaptcha-response", String.valueOf(token))));
                Map cookies2 = formReq2.getCookies();
                c03022.L$0 = $this5;
                c03022.L$1 = SpillingKt.nullOutSpilledVariable(url6);
                c03022.L$2 = SpillingKt.nullOutSpilledVariable(referer4);
                c03022.L$3 = SpillingKt.nullOutSpilledVariable(function9);
                c03022.L$4 = function8;
                c03022.L$5 = SpillingKt.nullOutSpilledVariable(res10);
                c03022.L$6 = SpillingKt.nullOutSpilledVariable(formUrl5);
                c03022.L$7 = SpillingKt.nullOutSpilledVariable(formData3);
                c03022.L$8 = SpillingKt.nullOutSpilledVariable(formReq2);
                c03022.L$9 = SpillingKt.nullOutSpilledVariable(captchaKey2);
                c03022.L$10 = SpillingKt.nullOutSpilledVariable(token);
                c03022.label = 4;
                function10 = function8;
                C03021 c03026 = c03022;
                $this6 = $this5;
                continuation2 = null;
                objPost$default2 = Requests.post$default(app5, url11, (Map) null, (String) null, (Map) null, cookies2, mapPlus2, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c03026, 65486, (Object) null);
                c03022 = c03026;
                if (objPost$default2 == obj) {
                    return obj;
                }
                url7 = url6;
                url8 = referer4;
                function11 = function9;
                function12 = function10;
                Document res11 = ((NiceResponse) objPost$default2).getDocument();
                String video2 = res11.select("div.download-button a.btn.btn-dow.recaptchav2").attr("href");
                String name3 = $this6.getName();
                String name4 = $this6.getName();
                ExtractorLinkType infer_type2 = ExtractorApiKt.getINFER_TYPE();
                C03033 c03034 = new C03033(continuation2);
                c03022.L$0 = SpillingKt.nullOutSpilledVariable($this6);
                c03022.L$1 = SpillingKt.nullOutSpilledVariable(url7);
                c03022.L$2 = SpillingKt.nullOutSpilledVariable(url8);
                c03022.L$3 = SpillingKt.nullOutSpilledVariable(function11);
                c03022.L$4 = SpillingKt.nullOutSpilledVariable(function12);
                c03022.L$5 = SpillingKt.nullOutSpilledVariable(res11);
                c03022.L$6 = SpillingKt.nullOutSpilledVariable(formUrl5);
                c03022.L$7 = SpillingKt.nullOutSpilledVariable(formData3);
                c03022.L$8 = SpillingKt.nullOutSpilledVariable(formReq2);
                c03022.L$9 = SpillingKt.nullOutSpilledVariable(captchaKey2);
                c03022.L$10 = SpillingKt.nullOutSpilledVariable(token);
                c03022.L$11 = SpillingKt.nullOutSpilledVariable(video2);
                c03022.L$12 = function12;
                c03022.label = 5;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(name3, name4, video2, infer_type2, c03034, c03022);
                if (objNewExtractorLink == obj) {
                    return obj;
                }
                function13 = function12;
                function13.invoke(objNewExtractorLink);
                return Unit.INSTANCE;
            case 2:
                Map formData4 = (Map) c03022.L$7;
                String formUrl12 = (String) c03022.L$6;
                Function1<? super ExtractorLink, Unit> function16 = (Function1) c03022.L$4;
                Function1<? super SubtitleFile, Unit> function17 = (Function1) c03022.L$3;
                referer3 = (String) c03022.L$2;
                String url12 = (String) c03022.L$1;
                Uploadever $this8 = (Uploadever) c03022.L$0;
                ResultKt.throwOnFailure($result);
                formData2 = formData4;
                obj = coroutine_suspended;
                formUrl3 = "value";
                function7 = function16;
                function6 = function17;
                url4 = url12;
                $this4 = $this8;
                formUrl4 = formUrl12;
                str2 = "name";
                i2 = 2;
                obj3 = $result;
                formReq = (NiceResponse) obj3;
                res2 = formReq.getDocument();
                captchaKey = StringsKt.substringAfter$default(res2.select("script[src*=https://www.google.com/recaptcha/api.js?render=]").attr("src"), "render=", (String) null, i2, (Object) null);
                APIHolder aPIHolder3 = APIHolder.INSTANCE;
                String str9 = $this4.getMainUrl() + '/';
                c03022.L$0 = $this4;
                c03022.L$1 = url4;
                c03022.L$2 = SpillingKt.nullOutSpilledVariable(referer3);
                c03022.L$3 = SpillingKt.nullOutSpilledVariable(function6);
                c03022.L$4 = function7;
                c03022.L$5 = res2;
                c03022.L$6 = SpillingKt.nullOutSpilledVariable(formUrl4);
                c03022.L$7 = SpillingKt.nullOutSpilledVariable(formData2);
                c03022.L$8 = formReq;
                c03022.L$9 = SpillingKt.nullOutSpilledVariable(captchaKey);
                c03022.label = 3;
                captchaToken = aPIHolder3.getCaptchaToken(url4, captchaKey, str9, c03022);
                if (captchaToken == obj) {
                    return obj;
                }
                captchaKey2 = captchaKey;
                $this5 = $this4;
                formUrl5 = formUrl4;
                res3 = res2;
                referer4 = referer3;
                formReq2 = formReq;
                url5 = url4;
                function8 = function7;
                function9 = function6;
                token = (String) captchaToken;
                $this$associate$iv2 = res3.select("form#down input");
                int capacity$iv5 = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv2, 10)), 16);
                destination$iv$iv = new LinkedHashMap(capacity$iv5);
                while (r14.hasNext()) {
                    Document res12 = res3;
                    Element it5 = (Element) element$iv$iv2;
                    Iterable $this$associate$iv5 = $this$associate$iv2;
                    String strAttr3 = it5.attr(str2);
                    String str10 = str2;
                    String str11 = formUrl3;
                    Pair pair5 = TuplesKt.to(strAttr3, it5.attr(str11));
                    destination$iv$iv.put(pair5.getFirst(), pair5.getSecond());
                    $this$associate$iv2 = $this$associate$iv5;
                    formData2 = formData2;
                    formUrl3 = str11;
                    res3 = res12;
                    str2 = str10;
                }
                Document res13 = res3;
                formData3 = MapsKt.toMutableMap(destination$iv$iv);
                formData3.put("adblock_detected", "0");
                formData3.put("referer", url5);
                Requests app6 = MainActivityKt.getApp();
                url6 = url5;
                String url13 = formReq2.getUrl();
                Map mapPlus3 = MapsKt.plus(formData3, MapsKt.mapOf(TuplesKt.to("g-recaptcha-response", String.valueOf(token))));
                Map cookies3 = formReq2.getCookies();
                c03022.L$0 = $this5;
                c03022.L$1 = SpillingKt.nullOutSpilledVariable(url6);
                c03022.L$2 = SpillingKt.nullOutSpilledVariable(referer4);
                c03022.L$3 = SpillingKt.nullOutSpilledVariable(function9);
                c03022.L$4 = function8;
                c03022.L$5 = SpillingKt.nullOutSpilledVariable(res13);
                c03022.L$6 = SpillingKt.nullOutSpilledVariable(formUrl5);
                c03022.L$7 = SpillingKt.nullOutSpilledVariable(formData3);
                c03022.L$8 = SpillingKt.nullOutSpilledVariable(formReq2);
                c03022.L$9 = SpillingKt.nullOutSpilledVariable(captchaKey2);
                c03022.L$10 = SpillingKt.nullOutSpilledVariable(token);
                c03022.label = 4;
                function10 = function8;
                C03021 c03027 = c03022;
                $this6 = $this5;
                continuation2 = null;
                objPost$default2 = Requests.post$default(app6, url13, (Map) null, (String) null, (Map) null, cookies3, mapPlus3, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c03027, 65486, (Object) null);
                c03022 = c03027;
                if (objPost$default2 == obj) {
                    return obj;
                }
                url7 = url6;
                url8 = referer4;
                function11 = function9;
                function12 = function10;
                Document res14 = ((NiceResponse) objPost$default2).getDocument();
                String video3 = res14.select("div.download-button a.btn.btn-dow.recaptchav2").attr("href");
                String name5 = $this6.getName();
                String name6 = $this6.getName();
                ExtractorLinkType infer_type3 = ExtractorApiKt.getINFER_TYPE();
                C03033 c03035 = new C03033(continuation2);
                c03022.L$0 = SpillingKt.nullOutSpilledVariable($this6);
                c03022.L$1 = SpillingKt.nullOutSpilledVariable(url7);
                c03022.L$2 = SpillingKt.nullOutSpilledVariable(url8);
                c03022.L$3 = SpillingKt.nullOutSpilledVariable(function11);
                c03022.L$4 = SpillingKt.nullOutSpilledVariable(function12);
                c03022.L$5 = SpillingKt.nullOutSpilledVariable(res14);
                c03022.L$6 = SpillingKt.nullOutSpilledVariable(formUrl5);
                c03022.L$7 = SpillingKt.nullOutSpilledVariable(formData3);
                c03022.L$8 = SpillingKt.nullOutSpilledVariable(formReq2);
                c03022.L$9 = SpillingKt.nullOutSpilledVariable(captchaKey2);
                c03022.L$10 = SpillingKt.nullOutSpilledVariable(token);
                c03022.L$11 = SpillingKt.nullOutSpilledVariable(video3);
                c03022.L$12 = function12;
                c03022.label = 5;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(name5, name6, video3, infer_type3, c03035, c03022);
                if (objNewExtractorLink == obj) {
                    return obj;
                }
                function13 = function12;
                function13.invoke(objNewExtractorLink);
                return Unit.INSTANCE;
            case 3:
                String captchaKey3 = (String) c03022.L$9;
                NiceResponse formReq3 = (NiceResponse) c03022.L$8;
                formData2 = (Map) c03022.L$7;
                String formUrl13 = (String) c03022.L$6;
                Document res15 = (Document) c03022.L$5;
                Function1<? super ExtractorLink, Unit> function18 = (Function1) c03022.L$4;
                Function1<? super SubtitleFile, Unit> function19 = (Function1) c03022.L$3;
                String referer6 = (String) c03022.L$2;
                String url14 = (String) c03022.L$1;
                $this5 = (Uploadever) c03022.L$0;
                ResultKt.throwOnFailure($result);
                captchaKey2 = captchaKey3;
                obj = coroutine_suspended;
                formUrl3 = "value";
                referer4 = referer6;
                formUrl5 = formUrl13;
                res3 = res15;
                captchaToken = $result;
                str2 = "name";
                formReq2 = formReq3;
                url5 = url14;
                function8 = function18;
                function9 = function19;
                token = (String) captchaToken;
                $this$associate$iv2 = res3.select("form#down input");
                int capacity$iv6 = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv2, 10)), 16);
                destination$iv$iv = new LinkedHashMap(capacity$iv6);
                while (r14.hasNext()) {
                    Document res16 = res3;
                    Element it6 = (Element) element$iv$iv2;
                    Iterable $this$associate$iv6 = $this$associate$iv2;
                    String strAttr4 = it6.attr(str2);
                    String str12 = str2;
                    String str13 = formUrl3;
                    Pair pair6 = TuplesKt.to(strAttr4, it6.attr(str13));
                    destination$iv$iv.put(pair6.getFirst(), pair6.getSecond());
                    $this$associate$iv2 = $this$associate$iv6;
                    formData2 = formData2;
                    formUrl3 = str13;
                    res3 = res16;
                    str2 = str12;
                }
                Document res17 = res3;
                formData3 = MapsKt.toMutableMap(destination$iv$iv);
                formData3.put("adblock_detected", "0");
                formData3.put("referer", url5);
                Requests app7 = MainActivityKt.getApp();
                url6 = url5;
                String url15 = formReq2.getUrl();
                Map mapPlus4 = MapsKt.plus(formData3, MapsKt.mapOf(TuplesKt.to("g-recaptcha-response", String.valueOf(token))));
                Map cookies4 = formReq2.getCookies();
                c03022.L$0 = $this5;
                c03022.L$1 = SpillingKt.nullOutSpilledVariable(url6);
                c03022.L$2 = SpillingKt.nullOutSpilledVariable(referer4);
                c03022.L$3 = SpillingKt.nullOutSpilledVariable(function9);
                c03022.L$4 = function8;
                c03022.L$5 = SpillingKt.nullOutSpilledVariable(res17);
                c03022.L$6 = SpillingKt.nullOutSpilledVariable(formUrl5);
                c03022.L$7 = SpillingKt.nullOutSpilledVariable(formData3);
                c03022.L$8 = SpillingKt.nullOutSpilledVariable(formReq2);
                c03022.L$9 = SpillingKt.nullOutSpilledVariable(captchaKey2);
                c03022.L$10 = SpillingKt.nullOutSpilledVariable(token);
                c03022.label = 4;
                function10 = function8;
                C03021 c03028 = c03022;
                $this6 = $this5;
                continuation2 = null;
                objPost$default2 = Requests.post$default(app7, url15, (Map) null, (String) null, (Map) null, cookies4, mapPlus4, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c03028, 65486, (Object) null);
                c03022 = c03028;
                if (objPost$default2 == obj) {
                    return obj;
                }
                url7 = url6;
                url8 = referer4;
                function11 = function9;
                function12 = function10;
                Document res18 = ((NiceResponse) objPost$default2).getDocument();
                String video4 = res18.select("div.download-button a.btn.btn-dow.recaptchav2").attr("href");
                String name7 = $this6.getName();
                String name8 = $this6.getName();
                ExtractorLinkType infer_type4 = ExtractorApiKt.getINFER_TYPE();
                C03033 c03036 = new C03033(continuation2);
                c03022.L$0 = SpillingKt.nullOutSpilledVariable($this6);
                c03022.L$1 = SpillingKt.nullOutSpilledVariable(url7);
                c03022.L$2 = SpillingKt.nullOutSpilledVariable(url8);
                c03022.L$3 = SpillingKt.nullOutSpilledVariable(function11);
                c03022.L$4 = SpillingKt.nullOutSpilledVariable(function12);
                c03022.L$5 = SpillingKt.nullOutSpilledVariable(res18);
                c03022.L$6 = SpillingKt.nullOutSpilledVariable(formUrl5);
                c03022.L$7 = SpillingKt.nullOutSpilledVariable(formData3);
                c03022.L$8 = SpillingKt.nullOutSpilledVariable(formReq2);
                c03022.L$9 = SpillingKt.nullOutSpilledVariable(captchaKey2);
                c03022.L$10 = SpillingKt.nullOutSpilledVariable(token);
                c03022.L$11 = SpillingKt.nullOutSpilledVariable(video4);
                c03022.L$12 = function12;
                c03022.label = 5;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(name7, name8, video4, infer_type4, c03036, c03022);
                if (objNewExtractorLink == obj) {
                    return obj;
                }
                function13 = function12;
                function13.invoke(objNewExtractorLink);
                return Unit.INSTANCE;
            case 4:
                String token2 = (String) c03022.L$10;
                String captchaKey4 = (String) c03022.L$9;
                NiceResponse formReq4 = (NiceResponse) c03022.L$8;
                Map formData5 = (Map) c03022.L$7;
                String formUrl14 = (String) c03022.L$6;
                function12 = (Function1) c03022.L$4;
                Function1<? super SubtitleFile, Unit> function20 = (Function1) c03022.L$3;
                String referer7 = (String) c03022.L$2;
                String url16 = (String) c03022.L$1;
                Uploadever $this9 = (Uploadever) c03022.L$0;
                ResultKt.throwOnFailure($result);
                $this6 = $this9;
                token = token2;
                obj = coroutine_suspended;
                captchaKey2 = captchaKey4;
                formReq2 = formReq4;
                formUrl5 = formUrl14;
                url7 = url16;
                continuation2 = null;
                objPost$default2 = $result;
                formData3 = formData5;
                url8 = referer7;
                function11 = function20;
                Document res19 = ((NiceResponse) objPost$default2).getDocument();
                String video5 = res19.select("div.download-button a.btn.btn-dow.recaptchav2").attr("href");
                String name9 = $this6.getName();
                String name10 = $this6.getName();
                ExtractorLinkType infer_type5 = ExtractorApiKt.getINFER_TYPE();
                C03033 c03037 = new C03033(continuation2);
                c03022.L$0 = SpillingKt.nullOutSpilledVariable($this6);
                c03022.L$1 = SpillingKt.nullOutSpilledVariable(url7);
                c03022.L$2 = SpillingKt.nullOutSpilledVariable(url8);
                c03022.L$3 = SpillingKt.nullOutSpilledVariable(function11);
                c03022.L$4 = SpillingKt.nullOutSpilledVariable(function12);
                c03022.L$5 = SpillingKt.nullOutSpilledVariable(res19);
                c03022.L$6 = SpillingKt.nullOutSpilledVariable(formUrl5);
                c03022.L$7 = SpillingKt.nullOutSpilledVariable(formData3);
                c03022.L$8 = SpillingKt.nullOutSpilledVariable(formReq2);
                c03022.L$9 = SpillingKt.nullOutSpilledVariable(captchaKey2);
                c03022.L$10 = SpillingKt.nullOutSpilledVariable(token);
                c03022.L$11 = SpillingKt.nullOutSpilledVariable(video5);
                c03022.L$12 = function12;
                c03022.label = 5;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(name9, name10, video5, infer_type5, c03037, c03022);
                if (objNewExtractorLink == obj) {
                    return obj;
                }
                function13 = function12;
                function13.invoke(objNewExtractorLink);
                return Unit.INSTANCE;
            case 5:
                function13 = (Function1) c03022.L$12;
                ResultKt.throwOnFailure($result);
                objNewExtractorLink = $result;
                function13.invoke(objNewExtractorLink);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.phisher98.Uploadever$getUrl$3 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Uploadever$getUrl$3", f = "Extractors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C03033 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C03033(Continuation<? super C03033> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c03033 = new C03033(continuation);
            c03033.L$0 = obj;
            return c03033;
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
                    $this$newExtractorLink.setQuality(Qualities.Unknown.getValue());
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
