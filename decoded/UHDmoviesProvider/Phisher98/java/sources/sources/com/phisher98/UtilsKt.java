package com.phisher98;

import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SearchQuality;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
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

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/UHDmoviesProvider/classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0016\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001\u001a\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086@¢\u0006\u0002\u0010\u0006\u001a\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001¨\u0006\n"}, d2 = {"getBaseUrl", "", "url", "fixUrl", "domain", "bypassHrefli", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSearchQuality", "Lcom/lagradost/cloudstream3/SearchQuality;", "check", "UHDmoviesProvider"}, k = 2, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utils.kt\ncom/phisher98/UtilsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,128:1\n1358#2,2:129\n1435#2,4:131\n*S KotlinDebug\n*F\n+ 1 Utils.kt\ncom/phisher98/UtilsKt\n*L\n40#1:129,2\n40#1:131,4\n*E\n"})
public final class UtilsKt {

    /* JADX INFO: renamed from: com.phisher98.UtilsKt$bypassHrefli$1 */
    /* JADX INFO: compiled from: Utils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.UtilsKt", f = "Utils.kt", i = {0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4}, l = {44, 48, 52, 55, 60}, m = "bypassHrefli", n = {"url", "host", "url", "host", "res", "formUrl", "formData", "url", "host", "res", "formUrl", "formData", "url", "host", "res", "formUrl", "formData", "skToken", "url", "host", "res", "formUrl", "formData", "skToken", "driveUrl"}, nl = {45, 49, 53, 59, 61}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"}, v = 2)
    static final class C00171 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C00171(Continuation<? super C00171> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UtilsKt.bypassHrefli(null, (Continuation) this);
        }
    }

    @NotNull
    public static final String getBaseUrl(@NotNull String url) {
        URI it = new URI(url);
        return it.getScheme() + "://" + it.getHost();
    }

    @NotNull
    public static final String fixUrl(@NotNull String url, @NotNull String domain) {
        if (StringsKt.startsWith$default(url, "http", false, 2, (Object) null)) {
            return url;
        }
        if (url.length() == 0) {
            return "";
        }
        boolean startsWithNoHttp = StringsKt.startsWith$default(url, "//", false, 2, (Object) null);
        if (startsWithNoHttp) {
            return "https:" + url;
        }
        if (StringsKt.startsWith$default(url, '/', false, 2, (Object) null)) {
            return domain + url;
        }
        return domain + '/' + url;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0190 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x0191  */
    /* JADX WARN: Code duplicated, block: B:27:0x01e7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:28:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:31:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:35:0x020f  */
    /* JADX WARN: Code duplicated, block: B:37:0x0218  */
    /* JADX WARN: Code duplicated, block: B:39:0x0299 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:42:0x02a9  */
    /* JADX WARN: Code duplicated, block: B:45:0x02bb  */
    /* JADX WARN: Code duplicated, block: B:48:0x02c3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:50:0x02c6  */
    /* JADX WARN: Code duplicated, block: B:52:0x0307 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:53:0x0308  */
    /* JADX WARN: Code duplicated, block: B:56:0x0330 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:57:0x0331  */
    /* JADX WARN: Code duplicated, block: B:59:0x033a  */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    @Nullable
    public static final Object bypassHrefli(@NotNull String url, @NotNull Continuation<? super String> continuation) {
        C00171 c00171;
        int i;
        Object obj;
        C00171 c00172;
        String url2;
        String host;
        String host2;
        C00171 c00173;
        String formUrl;
        String formUrl2;
        Map<String, String> mapBypassHrefli$getFormData;
        String host3;
        C00171 c00174;
        String formUrl3;
        Map<String, String> map;
        String host4;
        Document res;
        Element elementSelectFirst;
        String strData;
        String strSubstringAfter$default;
        String skToken;
        String host5;
        Map<String, String> map2;
        String skToken2;
        Document res2;
        C00171 c00175;
        Element elementSelectFirst2;
        String driveUrl;
        Requests app;
        String strAttr;
        String path;
        if (continuation instanceof C00171) {
            c00171 = (C00171) continuation;
            if ((c00171.label & Integer.MIN_VALUE) != 0) {
                c00171.label -= Integer.MIN_VALUE;
            } else {
                c00171 = new C00171(continuation);
            }
        } else {
            c00171 = new C00171(continuation);
        }
        Object $result = c00171.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00171.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String host6 = getBaseUrl(url);
                Requests app2 = MainActivityKt.getApp();
                c00171.L$0 = SpillingKt.nullOutSpilledVariable(url);
                c00171.L$1 = host6;
                c00171.label = 1;
                i = 2;
                C00171 c00176 = c00171;
                obj = coroutine_suspended;
                $result = Requests.get$default(app2, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00176, 4094, (Object) null);
                c00172 = c00176;
                if ($result == obj) {
                    return obj;
                }
                url2 = url;
                host = host6;
                Document res3 = ((NiceResponse) $result).getDocument();
                String formUrl4 = bypassHrefli$getFormUrl(res3);
                Map<String, String> mapBypassHrefli$getFormData2 = bypassHrefli$getFormData(res3);
                Requests app3 = MainActivityKt.getApp();
                c00172.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00172.L$1 = host;
                c00172.L$2 = SpillingKt.nullOutSpilledVariable(res3);
                c00172.L$3 = SpillingKt.nullOutSpilledVariable(formUrl4);
                c00172.L$4 = SpillingKt.nullOutSpilledVariable(mapBypassHrefli$getFormData2);
                c00172.label = i;
                host2 = host;
                C00171 c00177 = c00172;
                $result = Requests.post$default(app3, formUrl4, (Map) null, (String) null, (Map) null, (Map) null, mapBypassHrefli$getFormData2, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00177, 65502, (Object) null);
                c00173 = c00177;
                if ($result == obj) {
                    return obj;
                }
                formUrl = host2;
                Document res4 = ((NiceResponse) $result).getDocument();
                formUrl2 = bypassHrefli$getFormUrl(res4);
                mapBypassHrefli$getFormData = bypassHrefli$getFormData(res4);
                Requests app4 = MainActivityKt.getApp();
                c00173.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00173.L$1 = formUrl;
                c00173.L$2 = SpillingKt.nullOutSpilledVariable(res4);
                c00173.L$3 = SpillingKt.nullOutSpilledVariable(formUrl2);
                c00173.L$4 = mapBypassHrefli$getFormData;
                c00173.label = 3;
                C00171 c00178 = c00173;
                host3 = formUrl;
                $result = Requests.post$default(app4, formUrl2, (Map) null, (String) null, (Map) null, (Map) null, mapBypassHrefli$getFormData, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00178, 65502, (Object) null);
                c00174 = c00178;
                if ($result == obj) {
                    return obj;
                }
                formUrl3 = formUrl2;
                map = mapBypassHrefli$getFormData;
                host4 = host3;
                res = ((NiceResponse) $result).getDocument();
                elementSelectFirst = res.selectFirst("script:containsData(?go=)");
                if (elementSelectFirst != null && (strData = elementSelectFirst.data()) != null) {
                    strSubstringAfter$default = StringsKt.substringAfter$default(strData, "?go=", (String) null, i, (Object) null);
                    if (strSubstringAfter$default != null) {
                        return null;
                    }
                    skToken = StringsKt.substringBefore$default(strSubstringAfter$default, "\"", (String) null, i, (Object) null);
                    if (skToken != null) {
                        Map mapMapOf = MapsKt.mapOf(TuplesKt.to(skToken, String.valueOf(map.get("_wp_http2"))));
                        c00174.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                        c00174.L$1 = SpillingKt.nullOutSpilledVariable(host4);
                        c00174.L$2 = SpillingKt.nullOutSpilledVariable(res);
                        c00174.L$3 = SpillingKt.nullOutSpilledVariable(formUrl3);
                        c00174.L$4 = SpillingKt.nullOutSpilledVariable(map);
                        c00174.L$5 = SpillingKt.nullOutSpilledVariable(skToken);
                        c00174.label = 4;
                        C00171 c00179 = c00174;
                        host5 = host4;
                        map2 = map;
                        skToken2 = skToken;
                        res2 = res;
                        $result = Requests.get$default(MainActivityKt.getApp(), host4 + "?go=" + skToken, (Map) null, (String) null, (Map) null, mapMapOf, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00179, 4078, (Object) null);
                        c00175 = c00179;
                        if ($result == obj) {
                            return obj;
                        }
                        elementSelectFirst2 = ((NiceResponse) $result).getDocument().selectFirst("meta[http-equiv=refresh]");
                        if (elementSelectFirst2 != null || (strAttr = elementSelectFirst2.attr("content")) == null) {
                            driveUrl = null;
                        } else {
                            driveUrl = StringsKt.substringAfter$default(strAttr, "url=", (String) null, i, (Object) null);
                        }
                        app = MainActivityKt.getApp();
                        if (driveUrl == null) {
                            return null;
                        }
                        c00175.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                        c00175.L$1 = SpillingKt.nullOutSpilledVariable(host5);
                        c00175.L$2 = SpillingKt.nullOutSpilledVariable(res2);
                        c00175.L$3 = SpillingKt.nullOutSpilledVariable(formUrl3);
                        c00175.L$4 = SpillingKt.nullOutSpilledVariable(map2);
                        c00175.L$5 = SpillingKt.nullOutSpilledVariable(skToken2);
                        c00175.L$6 = driveUrl;
                        c00175.label = 5;
                        $result = Requests.get$default(app, driveUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00175, 4094, (Object) null);
                        if ($result == obj) {
                            return obj;
                        }
                        path = StringsKt.substringBefore$default(StringsKt.substringAfter$default(((NiceResponse) $result).getText(), "replace(\"", (String) null, i, (Object) null), "\")", (String) null, i, (Object) null);
                        if (Intrinsics.areEqual(path, "/404")) {
                            return null;
                        }
                        return fixUrl(path, getBaseUrl(driveUrl));
                    }
                }
                return null;
            case 1:
                host = (String) c00171.L$1;
                String url3 = (String) c00171.L$0;
                ResultKt.throwOnFailure($result);
                c00172 = c00171;
                obj = coroutine_suspended;
                url2 = url3;
                i = 2;
                Document res5 = ((NiceResponse) $result).getDocument();
                String formUrl5 = bypassHrefli$getFormUrl(res5);
                Map<String, String> mapBypassHrefli$getFormData3 = bypassHrefli$getFormData(res5);
                Requests app5 = MainActivityKt.getApp();
                c00172.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00172.L$1 = host;
                c00172.L$2 = SpillingKt.nullOutSpilledVariable(res5);
                c00172.L$3 = SpillingKt.nullOutSpilledVariable(formUrl5);
                c00172.L$4 = SpillingKt.nullOutSpilledVariable(mapBypassHrefli$getFormData3);
                c00172.label = i;
                host2 = host;
                C00171 c001710 = c00172;
                $result = Requests.post$default(app5, formUrl5, (Map) null, (String) null, (Map) null, (Map) null, mapBypassHrefli$getFormData3, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c001710, 65502, (Object) null);
                c00173 = c001710;
                if ($result == obj) {
                    return obj;
                }
                formUrl = host2;
                Document res6 = ((NiceResponse) $result).getDocument();
                formUrl2 = bypassHrefli$getFormUrl(res6);
                mapBypassHrefli$getFormData = bypassHrefli$getFormData(res6);
                Requests app6 = MainActivityKt.getApp();
                c00173.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00173.L$1 = formUrl;
                c00173.L$2 = SpillingKt.nullOutSpilledVariable(res6);
                c00173.L$3 = SpillingKt.nullOutSpilledVariable(formUrl2);
                c00173.L$4 = mapBypassHrefli$getFormData;
                c00173.label = 3;
                C00171 c001711 = c00173;
                host3 = formUrl;
                $result = Requests.post$default(app6, formUrl2, (Map) null, (String) null, (Map) null, (Map) null, mapBypassHrefli$getFormData, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c001711, 65502, (Object) null);
                c00174 = c001711;
                if ($result == obj) {
                    return obj;
                }
                formUrl3 = formUrl2;
                map = mapBypassHrefli$getFormData;
                host4 = host3;
                res = ((NiceResponse) $result).getDocument();
                elementSelectFirst = res.selectFirst("script:containsData(?go=)");
                if (elementSelectFirst != null) {
                    strSubstringAfter$default = StringsKt.substringAfter$default(strData, "?go=", (String) null, i, (Object) null);
                    if (strSubstringAfter$default != null) {
                        return null;
                    }
                    skToken = StringsKt.substringBefore$default(strSubstringAfter$default, "\"", (String) null, i, (Object) null);
                    if (skToken != null) {
                        Map mapMapOf2 = MapsKt.mapOf(TuplesKt.to(skToken, String.valueOf(map.get("_wp_http2"))));
                        c00174.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                        c00174.L$1 = SpillingKt.nullOutSpilledVariable(host4);
                        c00174.L$2 = SpillingKt.nullOutSpilledVariable(res);
                        c00174.L$3 = SpillingKt.nullOutSpilledVariable(formUrl3);
                        c00174.L$4 = SpillingKt.nullOutSpilledVariable(map);
                        c00174.L$5 = SpillingKt.nullOutSpilledVariable(skToken);
                        c00174.label = 4;
                        C00171 c001712 = c00174;
                        host5 = host4;
                        map2 = map;
                        skToken2 = skToken;
                        res2 = res;
                        $result = Requests.get$default(MainActivityKt.getApp(), host4 + "?go=" + skToken, (Map) null, (String) null, (Map) null, mapMapOf2, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c001712, 4078, (Object) null);
                        c00175 = c001712;
                        if ($result == obj) {
                            return obj;
                        }
                        elementSelectFirst2 = ((NiceResponse) $result).getDocument().selectFirst("meta[http-equiv=refresh]");
                        if (elementSelectFirst2 != null) {
                            driveUrl = null;
                        } else {
                            driveUrl = null;
                        }
                        app = MainActivityKt.getApp();
                        if (driveUrl == null) {
                            return null;
                        }
                        c00175.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                        c00175.L$1 = SpillingKt.nullOutSpilledVariable(host5);
                        c00175.L$2 = SpillingKt.nullOutSpilledVariable(res2);
                        c00175.L$3 = SpillingKt.nullOutSpilledVariable(formUrl3);
                        c00175.L$4 = SpillingKt.nullOutSpilledVariable(map2);
                        c00175.L$5 = SpillingKt.nullOutSpilledVariable(skToken2);
                        c00175.L$6 = driveUrl;
                        c00175.label = 5;
                        $result = Requests.get$default(app, driveUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00175, 4094, (Object) null);
                        if ($result == obj) {
                            return obj;
                        }
                        path = StringsKt.substringBefore$default(StringsKt.substringAfter$default(((NiceResponse) $result).getText(), "replace(\"", (String) null, i, (Object) null), "\")", (String) null, i, (Object) null);
                        if (Intrinsics.areEqual(path, "/404")) {
                            return null;
                        }
                        return fixUrl(path, getBaseUrl(driveUrl));
                    }
                }
                return null;
            case 2:
                String host7 = (String) c00171.L$1;
                String url4 = (String) c00171.L$0;
                ResultKt.throwOnFailure($result);
                url2 = url4;
                i = 2;
                c00173 = c00171;
                obj = coroutine_suspended;
                formUrl = host7;
                Document res7 = ((NiceResponse) $result).getDocument();
                formUrl2 = bypassHrefli$getFormUrl(res7);
                mapBypassHrefli$getFormData = bypassHrefli$getFormData(res7);
                Requests app7 = MainActivityKt.getApp();
                c00173.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00173.L$1 = formUrl;
                c00173.L$2 = SpillingKt.nullOutSpilledVariable(res7);
                c00173.L$3 = SpillingKt.nullOutSpilledVariable(formUrl2);
                c00173.L$4 = mapBypassHrefli$getFormData;
                c00173.label = 3;
                C00171 c001713 = c00173;
                host3 = formUrl;
                $result = Requests.post$default(app7, formUrl2, (Map) null, (String) null, (Map) null, (Map) null, mapBypassHrefli$getFormData, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c001713, 65502, (Object) null);
                c00174 = c001713;
                if ($result == obj) {
                    return obj;
                }
                formUrl3 = formUrl2;
                map = mapBypassHrefli$getFormData;
                host4 = host3;
                res = ((NiceResponse) $result).getDocument();
                elementSelectFirst = res.selectFirst("script:containsData(?go=)");
                if (elementSelectFirst != null) {
                    strSubstringAfter$default = StringsKt.substringAfter$default(strData, "?go=", (String) null, i, (Object) null);
                    if (strSubstringAfter$default != null) {
                        return null;
                    }
                    skToken = StringsKt.substringBefore$default(strSubstringAfter$default, "\"", (String) null, i, (Object) null);
                    if (skToken != null) {
                        Map mapMapOf3 = MapsKt.mapOf(TuplesKt.to(skToken, String.valueOf(map.get("_wp_http2"))));
                        c00174.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                        c00174.L$1 = SpillingKt.nullOutSpilledVariable(host4);
                        c00174.L$2 = SpillingKt.nullOutSpilledVariable(res);
                        c00174.L$3 = SpillingKt.nullOutSpilledVariable(formUrl3);
                        c00174.L$4 = SpillingKt.nullOutSpilledVariable(map);
                        c00174.L$5 = SpillingKt.nullOutSpilledVariable(skToken);
                        c00174.label = 4;
                        C00171 c001714 = c00174;
                        host5 = host4;
                        map2 = map;
                        skToken2 = skToken;
                        res2 = res;
                        $result = Requests.get$default(MainActivityKt.getApp(), host4 + "?go=" + skToken, (Map) null, (String) null, (Map) null, mapMapOf3, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c001714, 4078, (Object) null);
                        c00175 = c001714;
                        if ($result == obj) {
                            return obj;
                        }
                        elementSelectFirst2 = ((NiceResponse) $result).getDocument().selectFirst("meta[http-equiv=refresh]");
                        if (elementSelectFirst2 != null) {
                            driveUrl = null;
                        } else {
                            driveUrl = null;
                        }
                        app = MainActivityKt.getApp();
                        if (driveUrl == null) {
                            return null;
                        }
                        c00175.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                        c00175.L$1 = SpillingKt.nullOutSpilledVariable(host5);
                        c00175.L$2 = SpillingKt.nullOutSpilledVariable(res2);
                        c00175.L$3 = SpillingKt.nullOutSpilledVariable(formUrl3);
                        c00175.L$4 = SpillingKt.nullOutSpilledVariable(map2);
                        c00175.L$5 = SpillingKt.nullOutSpilledVariable(skToken2);
                        c00175.L$6 = driveUrl;
                        c00175.label = 5;
                        $result = Requests.get$default(app, driveUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00175, 4094, (Object) null);
                        if ($result == obj) {
                            return obj;
                        }
                        path = StringsKt.substringBefore$default(StringsKt.substringAfter$default(((NiceResponse) $result).getText(), "replace(\"", (String) null, i, (Object) null), "\")", (String) null, i, (Object) null);
                        if (Intrinsics.areEqual(path, "/404")) {
                            return null;
                        }
                        return fixUrl(path, getBaseUrl(driveUrl));
                    }
                }
                return null;
            case 3:
                Map<String, String> map3 = (Map) c00171.L$4;
                String formUrl6 = (String) c00171.L$3;
                String host8 = (String) c00171.L$1;
                String url5 = (String) c00171.L$0;
                ResultKt.throwOnFailure($result);
                c00174 = c00171;
                obj = coroutine_suspended;
                map = map3;
                formUrl3 = formUrl6;
                host4 = host8;
                url2 = url5;
                i = 2;
                res = ((NiceResponse) $result).getDocument();
                elementSelectFirst = res.selectFirst("script:containsData(?go=)");
                if (elementSelectFirst != null) {
                    strSubstringAfter$default = StringsKt.substringAfter$default(strData, "?go=", (String) null, i, (Object) null);
                    if (strSubstringAfter$default != null) {
                        return null;
                    }
                    skToken = StringsKt.substringBefore$default(strSubstringAfter$default, "\"", (String) null, i, (Object) null);
                    if (skToken != null) {
                        Map mapMapOf4 = MapsKt.mapOf(TuplesKt.to(skToken, String.valueOf(map.get("_wp_http2"))));
                        c00174.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                        c00174.L$1 = SpillingKt.nullOutSpilledVariable(host4);
                        c00174.L$2 = SpillingKt.nullOutSpilledVariable(res);
                        c00174.L$3 = SpillingKt.nullOutSpilledVariable(formUrl3);
                        c00174.L$4 = SpillingKt.nullOutSpilledVariable(map);
                        c00174.L$5 = SpillingKt.nullOutSpilledVariable(skToken);
                        c00174.label = 4;
                        C00171 c001715 = c00174;
                        host5 = host4;
                        map2 = map;
                        skToken2 = skToken;
                        res2 = res;
                        $result = Requests.get$default(MainActivityKt.getApp(), host4 + "?go=" + skToken, (Map) null, (String) null, (Map) null, mapMapOf4, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c001715, 4078, (Object) null);
                        c00175 = c001715;
                        if ($result == obj) {
                            return obj;
                        }
                        elementSelectFirst2 = ((NiceResponse) $result).getDocument().selectFirst("meta[http-equiv=refresh]");
                        if (elementSelectFirst2 != null) {
                            driveUrl = null;
                        } else {
                            driveUrl = null;
                        }
                        app = MainActivityKt.getApp();
                        if (driveUrl == null) {
                            return null;
                        }
                        c00175.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                        c00175.L$1 = SpillingKt.nullOutSpilledVariable(host5);
                        c00175.L$2 = SpillingKt.nullOutSpilledVariable(res2);
                        c00175.L$3 = SpillingKt.nullOutSpilledVariable(formUrl3);
                        c00175.L$4 = SpillingKt.nullOutSpilledVariable(map2);
                        c00175.L$5 = SpillingKt.nullOutSpilledVariable(skToken2);
                        c00175.L$6 = driveUrl;
                        c00175.label = 5;
                        $result = Requests.get$default(app, driveUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00175, 4094, (Object) null);
                        if ($result == obj) {
                            return obj;
                        }
                        path = StringsKt.substringBefore$default(StringsKt.substringAfter$default(((NiceResponse) $result).getText(), "replace(\"", (String) null, i, (Object) null), "\")", (String) null, i, (Object) null);
                        if (Intrinsics.areEqual(path, "/404")) {
                            return null;
                        }
                        return fixUrl(path, getBaseUrl(driveUrl));
                    }
                }
                return null;
            case 4:
                String skToken3 = (String) c00171.L$5;
                Map<String, String> map4 = (Map) c00171.L$4;
                String formUrl7 = (String) c00171.L$3;
                Document res8 = (Document) c00171.L$2;
                String host9 = (String) c00171.L$1;
                String url6 = (String) c00171.L$0;
                ResultKt.throwOnFailure($result);
                skToken2 = skToken3;
                map2 = map4;
                formUrl3 = formUrl7;
                res2 = res8;
                host5 = host9;
                url2 = url6;
                i = 2;
                c00175 = c00171;
                obj = coroutine_suspended;
                elementSelectFirst2 = ((NiceResponse) $result).getDocument().selectFirst("meta[http-equiv=refresh]");
                if (elementSelectFirst2 != null) {
                    driveUrl = null;
                } else {
                    driveUrl = null;
                }
                app = MainActivityKt.getApp();
                if (driveUrl == null) {
                    return null;
                }
                c00175.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00175.L$1 = SpillingKt.nullOutSpilledVariable(host5);
                c00175.L$2 = SpillingKt.nullOutSpilledVariable(res2);
                c00175.L$3 = SpillingKt.nullOutSpilledVariable(formUrl3);
                c00175.L$4 = SpillingKt.nullOutSpilledVariable(map2);
                c00175.L$5 = SpillingKt.nullOutSpilledVariable(skToken2);
                c00175.L$6 = driveUrl;
                c00175.label = 5;
                $result = Requests.get$default(app, driveUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00175, 4094, (Object) null);
                if ($result == obj) {
                    return obj;
                }
                path = StringsKt.substringBefore$default(StringsKt.substringAfter$default(((NiceResponse) $result).getText(), "replace(\"", (String) null, i, (Object) null), "\")", (String) null, i, (Object) null);
                if (Intrinsics.areEqual(path, "/404")) {
                    return null;
                }
                return fixUrl(path, getBaseUrl(driveUrl));
            case 5:
                driveUrl = (String) c00171.L$6;
                ResultKt.throwOnFailure($result);
                i = 2;
                path = StringsKt.substringBefore$default(StringsKt.substringAfter$default(((NiceResponse) $result).getText(), "replace(\"", (String) null, i, (Object) null), "\")", (String) null, i, (Object) null);
                if (Intrinsics.areEqual(path, "/404")) {
                    return null;
                }
                return fixUrl(path, getBaseUrl(driveUrl));
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private static final String bypassHrefli$getFormUrl(Document $this$bypassHrefli_u24getFormUrl) {
        return $this$bypassHrefli_u24getFormUrl.select("form#landing").attr("action");
    }

    private static final Map<String, String> bypassHrefli$getFormData(Document $this$bypassHrefli_u24getFormData) {
        Iterable $this$associate$iv = $this$bypassHrefli_u24getFormData.select("form#landing input");
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv, 10)), 16);
        Map destination$iv$iv = new LinkedHashMap(capacity$iv);
        for (Object element$iv$iv : $this$associate$iv) {
            Element it = (Element) element$iv$iv;
            Pair pair = TuplesKt.to(it.attr("name"), it.attr("value"));
            destination$iv$iv.put(pair.getFirst(), pair.getSecond());
        }
        return destination$iv$iv;
    }

    @Nullable
    public static final SearchQuality getSearchQuality(@Nullable String check) {
        String lowercaseCheck;
        if (check != null) {
            lowercaseCheck = check.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowercaseCheck, "toLowerCase(...)");
        } else {
            lowercaseCheck = null;
        }
        if (lowercaseCheck != null) {
            if (!StringsKt.contains$default(lowercaseCheck, "4k", false, 2, (Object) null) && !StringsKt.contains$default(lowercaseCheck, "uhd", false, 2, (Object) null) && !StringsKt.contains$default(lowercaseCheck, "2160p", false, 2, (Object) null)) {
                if (!StringsKt.contains$default(lowercaseCheck, "1440p", false, 2, (Object) null) && !StringsKt.contains$default(lowercaseCheck, "qhd", false, 2, (Object) null)) {
                    if (!StringsKt.contains$default(lowercaseCheck, "1080p", false, 2, (Object) null) && !StringsKt.contains$default(lowercaseCheck, "fullhd", false, 2, (Object) null)) {
                        if (StringsKt.contains$default(lowercaseCheck, "720p", false, 2, (Object) null)) {
                            return SearchQuality.SD;
                        }
                        if (!StringsKt.contains$default(lowercaseCheck, "webrip", false, 2, (Object) null) && !StringsKt.contains$default(lowercaseCheck, "web-dl", false, 2, (Object) null)) {
                            if (StringsKt.contains$default(lowercaseCheck, "bluray", false, 2, (Object) null)) {
                                return SearchQuality.BlueRay;
                            }
                            if (!StringsKt.contains$default(lowercaseCheck, "hdts", false, 2, (Object) null) && !StringsKt.contains$default(lowercaseCheck, "hdcam", false, 2, (Object) null) && !StringsKt.contains$default(lowercaseCheck, "hdtc", false, 2, (Object) null)) {
                                if (StringsKt.contains$default(lowercaseCheck, "dvd", false, 2, (Object) null)) {
                                    return SearchQuality.DVD;
                                }
                                if (!StringsKt.contains$default(lowercaseCheck, "camrip", false, 2, (Object) null) && !StringsKt.contains$default(lowercaseCheck, "rip", false, 2, (Object) null)) {
                                    if (StringsKt.contains$default(lowercaseCheck, "cam", false, 2, (Object) null)) {
                                        return SearchQuality.Cam;
                                    }
                                    if (!StringsKt.contains$default(lowercaseCheck, "hdrip", false, 2, (Object) null) && !StringsKt.contains$default(lowercaseCheck, "hdtv", false, 2, (Object) null)) {
                                        if (StringsKt.contains$default(lowercaseCheck, "hq", false, 2, (Object) null)) {
                                            return SearchQuality.HQ;
                                        }
                                        return null;
                                    }
                                    return SearchQuality.HD;
                                }
                                return SearchQuality.CamRip;
                            }
                            return SearchQuality.HdCam;
                        }
                        return SearchQuality.WebRip;
                    }
                    return SearchQuality.HD;
                }
                return SearchQuality.BlueRay;
            }
            return SearchQuality.FourK;
        }
        return null;
    }
}
