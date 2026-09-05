package com.phisher98;

import com.lagradost.api.Log;
import com.lagradost.cloudstream3.Actor;
import com.lagradost.cloudstream3.ActorData;
import com.lagradost.cloudstream3.ActorRole;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.net.URI;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/XDMovies/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u001a\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u001a<\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0086@¢\u0006\u0002\u0010\r\u001a\u0006\u0010\u000e\u001a\u00020\u0004\u001a\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0002\u001a\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0086@¢\u0006\u0002\u0010\u0012\u001a\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0086@¢\u0006\u0002\u0010\u0012¨\u0006\u0015"}, d2 = {"parseTmdbActors", "", "Lcom/lagradost/cloudstream3/ActorData;", "jsonText", "", "fetchTmdbLogoUrl", "tmdbAPI", "apiKey", "type", "Lcom/lagradost/cloudstream3/TvType;", "tmdbId", "", "appLangCode", "(Ljava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/TvType;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateBrowserFingerprint", "getBaseUrl", "url", "bypassXD", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveFinalUrl", "startUrl", "XDMovies"}, k = 2, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractor.kt\ncom/phisher98/ExtractorKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,569:1\n1#2:570\n*E\n"})
public final class ExtractorKt {

    /* JADX INFO: renamed from: com.phisher98.ExtractorKt$bypassXD$1 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.ExtractorKt", f = "Extractor.kt", i = {0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, l = {419, 435, 436, 439, 440, 487, 490, 499, 514, 527, 532}, m = "bypassXD", n = {"url", "url", "initialResponse", "isCfBlocked", "url", "initialResponse", "isCfBlocked", "url", "initialResponse", "isCfBlocked", "url", "initialResponse", "isCfBlocked", "url", "initialResponse", "redirect", "baseUrl", "code", "fingerprint", "baseHeaders", "isolatedApp", "url", "initialResponse", "redirect", "baseUrl", "code", "fingerprint", "baseHeaders", "isolatedApp", "url", "initialResponse", "redirect", "baseUrl", "code", "fingerprint", "baseHeaders", "isolatedApp", "retryResp", "retryBaseUrl", "retryRedirect", "retryHeaders", "retryCode", "url", "initialResponse", "redirect", "baseUrl", "code", "fingerprint", "baseHeaders", "isolatedApp", "sessionJson", "sessionId", "url", "initialResponse", "redirect", "baseUrl", "code", "fingerprint", "baseHeaders", "isolatedApp", "sessionJson", "sessionId", "resultUrl", "finalResultUrl", "step2Url", "url", "initialResponse", "redirect", "baseUrl", "code", "fingerprint", "baseHeaders", "isolatedApp", "sessionJson", "sessionId", "resultUrl", "finalResultUrl"}, nl = {421, 436, 437, 440, 445, 489, 491, 503, 516, 528, 537}, s = {"L$0", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11"}, v = 2)
    static final class C00021 extends ContinuationImpl {
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

        C00021(Continuation<? super C00021> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ExtractorKt.bypassXD(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.ExtractorKt$fetchTmdbLogoUrl$1 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.ExtractorKt", f = "Extractor.kt", i = {0, 0, 0, 0, 0, 0}, l = {333}, m = "fetchTmdbLogoUrl", n = {"tmdbAPI", "apiKey", "type", "tmdbId", "appLangCode", "url"}, nl = {333}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
    static final class C00031 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C00031(Continuation<? super C00031> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ExtractorKt.fetchTmdbLogoUrl(null, null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.ExtractorKt$resolveFinalUrl$1 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.ExtractorKt", f = "Extractor.kt", i = {0, 0, 0, 0}, l = {553}, m = "resolveFinalUrl", n = {"startUrl", "currentUrl", "loopCount", "maxRedirects"}, nl = {554}, s = {"L$0", "L$1", "I$0", "I$1"}, v = 2)
    static final class C00041 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00041(Continuation<? super C00041> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ExtractorKt.resolveFinalUrl(null, (Continuation) this);
        }
    }

    @NotNull
    public static final List<ActorData> parseTmdbActors(@Nullable String jsonText) {
        String str = jsonText;
        if (str == null || StringsKt.isBlank(str)) {
            return CollectionsKt.emptyList();
        }
        List list = new ArrayList();
        JSONObject root = new JSONObject(jsonText);
        JSONArray castArr = root.optJSONArray("cast");
        if (castArr == null) {
            return CollectionsKt.emptyList();
        }
        int length = castArr.length();
        for (int i = 0; i < length; i++) {
            JSONObject c = castArr.optJSONObject(i);
            if (c != null) {
                String name = c.optString("name");
                if (StringsKt.isBlank(name)) {
                    name = null;
                }
                if (name == null && (name = c.optString("original_name")) == null) {
                    name = "";
                }
                String it = c.optString("profile_path");
                if (StringsKt.isBlank(it)) {
                    it = null;
                }
                String it2 = it != null ? XDMovies.TMDBIMAGEBASEURL + it : null;
                String it3 = c.optString("character");
                String role = StringsKt.isBlank(it3) ? null : it3;
                list.add(new ActorData(new Actor(name, it2), (ActorRole) null, role, (Actor) null, 10, (DefaultConstructorMarker) null));
            }
        }
        return list;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0232 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:110:0x01d0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:114:0x01de A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:115:0x01de A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:120:0x021d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:122:0x021d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:123:0x021d A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:0x0152  */
    /* JADX WARN: Code duplicated, block: B:45:0x0158 A[ADDED_TO_REGION, RETURN] */
    /* JADX WARN: Code duplicated, block: B:46:0x0159  */
    /* JADX WARN: Code duplicated, block: B:54:0x016d  */
    /* JADX WARN: Code duplicated, block: B:57:0x0184  */
    /* JADX WARN: Code duplicated, block: B:60:0x018e  */
    /* JADX WARN: Code duplicated, block: B:62:0x0194  */
    /* JADX WARN: Code duplicated, block: B:63:0x0199  */
    /* JADX WARN: Code duplicated, block: B:65:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:67:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:71:0x01d5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:72:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:73:0x01da  */
    /* JADX WARN: Code duplicated, block: B:77:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:79:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:81:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:84:0x0202  */
    /* JADX WARN: Code duplicated, block: B:88:0x020e  */
    /* JADX WARN: Code duplicated, block: B:90:0x0214  */
    /* JADX WARN: Code duplicated, block: B:91:0x0216  */
    /* JADX WARN: Code duplicated, block: B:93:0x021c  */
    /* JADX WARN: Code duplicated, block: B:96:0x0222  */
    /* JADX WARN: Code duplicated, block: B:98:0x0229 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:99:0x022b  */
    @Nullable
    public static final Object fetchTmdbLogoUrl(@NotNull String tmdbAPI, @NotNull String apiKey, @NotNull TvType type, @Nullable Integer tmdbId, @Nullable String appLangCode, @NotNull Continuation<? super String> continuation) {
        C00031 c00031;
        String appLangCode2;
        Object obj;
        JSONObject json;
        JSONArray logos;
        String lang;
        JSONObject svgFallback;
        int i;
        int length;
        JSONObject best;
        JSONObject bestSvg;
        int i2;
        int length2;
        JSONObject logo;
        JSONObject logo2;
        String p;
        JSONObject json2;
        String tmdbAPI2;
        String l;
        String string;
        String tmdbAPI3 = tmdbAPI;
        if (continuation instanceof C00031) {
            c00031 = (C00031) continuation;
            if ((c00031.label & Integer.MIN_VALUE) != 0) {
                c00031.label -= Integer.MIN_VALUE;
            } else {
                c00031 = new C00031(continuation);
            }
        } else {
            c00031 = new C00031(continuation);
        }
        C00031 c00032 = c00031;
        Object $result = c00032.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00032.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (tmdbId == null) {
                    return null;
                }
                String url = type == TvType.Movie ? tmdbAPI3 + "/movie/" + tmdbId.intValue() + "/images?api_key=" + apiKey : tmdbAPI3 + "/tv/" + tmdbId.intValue() + "/images?api_key=" + apiKey;
                try {
                    Result.Companion companion = Result.Companion;
                    Requests app = MainActivityKt.getApp();
                    c00032.L$0 = SpillingKt.nullOutSpilledVariable(tmdbAPI3);
                    c00032.L$1 = SpillingKt.nullOutSpilledVariable(apiKey);
                    c00032.L$2 = SpillingKt.nullOutSpilledVariable(type);
                    c00032.L$3 = SpillingKt.nullOutSpilledVariable(tmdbId);
                    c00032.L$4 = appLangCode;
                    c00032.L$5 = SpillingKt.nullOutSpilledVariable(url);
                    c00032.label = 1;
                    try {
                        Object obj2 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00032, 4094, (Object) null);
                        if (obj2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        appLangCode2 = appLangCode;
                        $result = obj2;
                        try {
                            obj = Result.constructor-impl(new JSONObject(((NiceResponse) $result).getText()));
                            break;
                        } catch (Throwable th) {
                            th = th;
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        if (Result.isFailure-impl(obj)) {
                            obj = null;
                        }
                        json = (JSONObject) obj;
                        if (json != null || (logos = json.optJSONArray("logos")) == null || logos.length() == 0) {
                            return null;
                        }
                        if (appLangCode2 != null || (string = StringsKt.trim(appLangCode2).toString()) == null) {
                            lang = null;
                        } else {
                            lang = string.toLowerCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(lang, "toLowerCase(...)");
                        }
                        svgFallback = null;
                        i = 0;
                        length = logos.length();
                        while (i < length) {
                            logo2 = logos.optJSONObject(i);
                            if (logo2 == null) {
                                json2 = json;
                                tmdbAPI2 = tmdbAPI3;
                            } else {
                                p = fetchTmdbLogoUrl$path(logo2);
                                if (StringsKt.isBlank(p)) {
                                    json2 = json;
                                    tmdbAPI2 = tmdbAPI3;
                                } else {
                                    json2 = json;
                                    tmdbAPI2 = tmdbAPI3;
                                    l = StringsKt.trim(logo2.optString("iso_639_1")).toString().toLowerCase(Locale.ROOT);
                                    Intrinsics.checkNotNullExpressionValue(l, "toLowerCase(...)");
                                    if (!Intrinsics.areEqual(l, lang)) {
                                        continue;
                                    } else {
                                        if (!fetchTmdbLogoUrl$isSvg(logo2)) {
                                            return fetchTmdbLogoUrl$urlOf(logo2);
                                        }
                                        if (svgFallback == null) {
                                            svgFallback = logo2;
                                        }
                                    }
                                }
                            }
                            i++;
                            json = json2;
                            tmdbAPI3 = tmdbAPI2;
                        }
                        if (svgFallback != null) {
                            JSONObject it = svgFallback;
                            return fetchTmdbLogoUrl$urlOf(it);
                        }
                        best = null;
                        bestSvg = null;
                        length2 = logos.length();
                        for (i2 = 0; i2 < length2; i2++) {
                            logo = logos.optJSONObject(i2);
                            if (logo != null && fetchTmdbLogoUrl$voted(logo)) {
                                if (fetchTmdbLogoUrl$isSvg(logo)) {
                                    if (fetchTmdbLogoUrl$better(bestSvg, logo)) {
                                        bestSvg = logo;
                                    }
                                } else if (fetchTmdbLogoUrl$better(best, logo)) {
                                    best = logo;
                                }
                            }
                        }
                        if (best != null) {
                            JSONObject it2 = best;
                            return fetchTmdbLogoUrl$urlOf(it2);
                        }
                        if (bestSvg != null) {
                            return null;
                        }
                        JSONObject it3 = bestSvg;
                        return fetchTmdbLogoUrl$urlOf(it3);
                    } catch (Throwable th2) {
                        th = th2;
                        appLangCode2 = appLangCode;
                        Result.Companion companion3 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                        if (Result.isFailure-impl(obj)) {
                            obj = null;
                        }
                        json = (JSONObject) obj;
                        if (json != null) {
                            return null;
                        }
                        if (appLangCode2 != null) {
                            lang = null;
                        } else {
                            lang = null;
                        }
                        svgFallback = null;
                        i = 0;
                        length = logos.length();
                        while (i < length) {
                            logo2 = logos.optJSONObject(i);
                            if (logo2 == null) {
                                json2 = json;
                                tmdbAPI2 = tmdbAPI3;
                            } else {
                                p = fetchTmdbLogoUrl$path(logo2);
                                if (StringsKt.isBlank(p)) {
                                    json2 = json;
                                    tmdbAPI2 = tmdbAPI3;
                                    l = StringsKt.trim(logo2.optString("iso_639_1")).toString().toLowerCase(Locale.ROOT);
                                    Intrinsics.checkNotNullExpressionValue(l, "toLowerCase(...)");
                                    if (!Intrinsics.areEqual(l, lang)) {
                                        continue;
                                    } else {
                                        if (!fetchTmdbLogoUrl$isSvg(logo2)) {
                                            return fetchTmdbLogoUrl$urlOf(logo2);
                                        }
                                        if (svgFallback == null) {
                                            svgFallback = logo2;
                                        }
                                    }
                                } else {
                                    json2 = json;
                                    tmdbAPI2 = tmdbAPI3;
                                }
                            }
                            i++;
                            json = json2;
                            tmdbAPI3 = tmdbAPI2;
                        }
                        if (svgFallback != null) {
                            JSONObject it4 = svgFallback;
                            return fetchTmdbLogoUrl$urlOf(it4);
                        }
                        best = null;
                        bestSvg = null;
                        length2 = logos.length();
                        while (i2 < length2) {
                            logo = logos.optJSONObject(i2);
                            if (logo != null) {
                                if (fetchTmdbLogoUrl$isSvg(logo)) {
                                    if (fetchTmdbLogoUrl$better(bestSvg, logo)) {
                                        bestSvg = logo;
                                    }
                                } else if (fetchTmdbLogoUrl$better(best, logo)) {
                                    best = logo;
                                }
                            }
                        }
                        if (best != null) {
                            JSONObject it5 = best;
                            return fetchTmdbLogoUrl$urlOf(it5);
                        }
                        if (bestSvg != null) {
                            return null;
                        }
                        JSONObject it6 = bestSvg;
                        return fetchTmdbLogoUrl$urlOf(it6);
                    }
                } catch (Throwable th3) {
                    th = th3;
                    appLangCode2 = appLangCode;
                }
                break;
            case 1:
                appLangCode2 = (String) c00032.L$4;
                tmdbAPI3 = (String) c00032.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    obj = Result.constructor-impl(new JSONObject(((NiceResponse) $result).getText()));
                    break;
                } catch (Throwable th4) {
                    th = th4;
                    Result.Companion companion4 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                    if (Result.isFailure-impl(obj)) {
                        obj = null;
                    }
                    json = (JSONObject) obj;
                    if (json != null) {
                        return null;
                    }
                    if (appLangCode2 != null) {
                        lang = null;
                    } else {
                        lang = null;
                    }
                    svgFallback = null;
                    i = 0;
                    length = logos.length();
                    while (i < length) {
                        logo2 = logos.optJSONObject(i);
                        if (logo2 == null) {
                            json2 = json;
                            tmdbAPI2 = tmdbAPI3;
                        } else {
                            p = fetchTmdbLogoUrl$path(logo2);
                            if (StringsKt.isBlank(p)) {
                                json2 = json;
                                tmdbAPI2 = tmdbAPI3;
                                l = StringsKt.trim(logo2.optString("iso_639_1")).toString().toLowerCase(Locale.ROOT);
                                Intrinsics.checkNotNullExpressionValue(l, "toLowerCase(...)");
                                if (!Intrinsics.areEqual(l, lang)) {
                                    continue;
                                } else {
                                    if (!fetchTmdbLogoUrl$isSvg(logo2)) {
                                        return fetchTmdbLogoUrl$urlOf(logo2);
                                    }
                                    if (svgFallback == null) {
                                        svgFallback = logo2;
                                    }
                                }
                            } else {
                                json2 = json;
                                tmdbAPI2 = tmdbAPI3;
                            }
                        }
                        i++;
                        json = json2;
                        tmdbAPI3 = tmdbAPI2;
                    }
                    if (svgFallback != null) {
                        JSONObject it7 = svgFallback;
                        return fetchTmdbLogoUrl$urlOf(it7);
                    }
                    best = null;
                    bestSvg = null;
                    length2 = logos.length();
                    while (i2 < length2) {
                        logo = logos.optJSONObject(i2);
                        if (logo != null) {
                            if (fetchTmdbLogoUrl$isSvg(logo)) {
                                if (fetchTmdbLogoUrl$better(bestSvg, logo)) {
                                    bestSvg = logo;
                                }
                            } else if (fetchTmdbLogoUrl$better(best, logo)) {
                                best = logo;
                            }
                        }
                    }
                    if (best != null) {
                        JSONObject it8 = best;
                        return fetchTmdbLogoUrl$urlOf(it8);
                    }
                    if (bestSvg != null) {
                        return null;
                    }
                    JSONObject it9 = bestSvg;
                    return fetchTmdbLogoUrl$urlOf(it9);
                }
                if (Result.isFailure-impl(obj)) {
                    obj = null;
                }
                json = (JSONObject) obj;
                if (json != null) {
                    return null;
                }
                if (appLangCode2 != null) {
                    lang = null;
                } else {
                    lang = null;
                }
                svgFallback = null;
                i = 0;
                length = logos.length();
                while (i < length) {
                    logo2 = logos.optJSONObject(i);
                    if (logo2 == null) {
                        json2 = json;
                        tmdbAPI2 = tmdbAPI3;
                    } else {
                        p = fetchTmdbLogoUrl$path(logo2);
                        if (StringsKt.isBlank(p)) {
                            json2 = json;
                            tmdbAPI2 = tmdbAPI3;
                            l = StringsKt.trim(logo2.optString("iso_639_1")).toString().toLowerCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(l, "toLowerCase(...)");
                            if (!Intrinsics.areEqual(l, lang)) {
                                continue;
                            } else {
                                if (!fetchTmdbLogoUrl$isSvg(logo2)) {
                                    return fetchTmdbLogoUrl$urlOf(logo2);
                                }
                                if (svgFallback == null) {
                                    svgFallback = logo2;
                                }
                            }
                        } else {
                            json2 = json;
                            tmdbAPI2 = tmdbAPI3;
                        }
                    }
                    i++;
                    json = json2;
                    tmdbAPI3 = tmdbAPI2;
                }
                if (svgFallback != null) {
                    JSONObject it10 = svgFallback;
                    return fetchTmdbLogoUrl$urlOf(it10);
                }
                best = null;
                bestSvg = null;
                length2 = logos.length();
                while (i2 < length2) {
                    logo = logos.optJSONObject(i2);
                    if (logo != null) {
                        if (fetchTmdbLogoUrl$isSvg(logo)) {
                            if (fetchTmdbLogoUrl$better(bestSvg, logo)) {
                                bestSvg = logo;
                            }
                        } else if (fetchTmdbLogoUrl$better(best, logo)) {
                            best = logo;
                        }
                    }
                }
                if (best != null) {
                    JSONObject it11 = best;
                    return fetchTmdbLogoUrl$urlOf(it11);
                }
                if (bestSvg != null) {
                    return null;
                }
                JSONObject it12 = bestSvg;
                return fetchTmdbLogoUrl$urlOf(it12);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private static final String fetchTmdbLogoUrl$path(JSONObject o) {
        return o.optString("file_path");
    }

    private static final boolean fetchTmdbLogoUrl$isSvg(JSONObject o) {
        return StringsKt.endsWith(fetchTmdbLogoUrl$path(o), ".svg", true);
    }

    private static final String fetchTmdbLogoUrl$urlOf(JSONObject o) {
        return "https://image.tmdb.org/t/p/w500" + fetchTmdbLogoUrl$path(o);
    }

    private static final boolean fetchTmdbLogoUrl$voted(JSONObject o) {
        return o.optDouble("vote_average", 0.0d) > 0.0d && o.optInt("vote_count", 0) > 0;
    }

    private static final boolean fetchTmdbLogoUrl$better(JSONObject a, JSONObject b) {
        if (a == null) {
            return true;
        }
        double aAvg = a.optDouble("vote_average", 0.0d);
        int aCnt = a.optInt("vote_count", 0);
        double bAvg = b.optDouble("vote_average", 0.0d);
        int bCnt = b.optInt("vote_count", 0);
        if (bAvg <= aAvg) {
            return ((bAvg > aAvg ? 1 : (bAvg == aAvg ? 0 : -1)) == 0) && bCnt > aCnt;
        }
        return true;
    }

    @NotNull
    public static final String generateBrowserFingerprint() throws NoSuchAlgorithmException {
        List components = CollectionsKt.listOf(new String[]{"1920x1080x24", "Asia/Kolkata", "en-US", "Win32", "8", "8", "canvas_stub_xdmovies", "ANGLE (NVIDIA)", "no_touch", "3", "true", "unset"});
        String raw = CollectionsKt.joinToString$default(components, "|||", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = raw.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] hash = digest.digest(bytes);
        return StringsKt.take(ArraysKt.joinToString$default(hash, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.phisher98.ExtractorKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return ExtractorKt.generateBrowserFingerprint$lambda$0(((Byte) obj).byteValue());
            }
        }, 30, (Object) null), 32);
    }

    static final CharSequence generateBrowserFingerprint$lambda$0(byte it) {
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(it)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    private static final String getBaseUrl(String url) {
        URI it = new URI(url);
        return it.getScheme() + "://" + it.getHost();
    }

    /* JADX WARN: Code duplicated, block: B:103:0x0717 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:104:0x0718  */
    /* JADX WARN: Code duplicated, block: B:118:0x07cb  */
    /* JADX WARN: Code duplicated, block: B:120:0x07d6  */
    /* JADX WARN: Code duplicated, block: B:122:0x07e2  */
    /* JADX WARN: Code duplicated, block: B:134:0x080e  */
    /* JADX WARN: Code duplicated, block: B:135:0x0816  */
    /* JADX WARN: Code duplicated, block: B:137:0x081a  */
    /* JADX WARN: Code duplicated, block: B:139:0x081e  */
    /* JADX WARN: Code duplicated, block: B:142:0x0842  */
    /* JADX WARN: Code duplicated, block: B:143:0x0844  */
    /* JADX WARN: Code duplicated, block: B:146:0x0848  */
    /* JADX WARN: Code duplicated, block: B:148:0x084b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:150:0x084d  */
    /* JADX WARN: Code duplicated, block: B:152:0x089c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:153:0x089d  */
    /* JADX WARN: Code duplicated, block: B:156:0x08ae A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:158:0x08b1  */
    /* JADX WARN: Code duplicated, block: B:160:0x08d5  */
    /* JADX WARN: Code duplicated, block: B:161:0x0908  */
    /* JADX WARN: Code duplicated, block: B:163:0x0912  */
    /* JADX WARN: Code duplicated, block: B:165:0x09b2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:166:0x09b3  */
    /* JADX WARN: Code duplicated, block: B:169:0x09dd  */
    /* JADX WARN: Code duplicated, block: B:171:0x09f6  */
    /* JADX WARN: Code duplicated, block: B:174:0x0a18  */
    /* JADX WARN: Code duplicated, block: B:176:0x0ab0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:177:0x0ab1  */
    /* JADX WARN: Code duplicated, block: B:180:0x0ad4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:33:0x0318  */
    /* JADX WARN: Code duplicated, block: B:35:0x0325  */
    /* JADX WARN: Code duplicated, block: B:37:0x0362 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:38:0x0363  */
    /* JADX WARN: Code duplicated, block: B:41:0x03aa A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:42:0x03ab  */
    /* JADX WARN: Code duplicated, block: B:44:0x03b8  */
    /* JADX WARN: Code duplicated, block: B:46:0x03c8  */
    /* JADX WARN: Code duplicated, block: B:48:0x03f9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:49:0x03fa  */
    /* JADX WARN: Code duplicated, block: B:52:0x043a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:53:0x043b  */
    /* JADX WARN: Code duplicated, block: B:55:0x0443  */
    /* JADX WARN: Code duplicated, block: B:56:0x0448  */
    /* JADX WARN: Code duplicated, block: B:60:0x045c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:61:0x045d  */
    /* JADX WARN: Code duplicated, block: B:63:0x0476  */
    /* JADX WARN: Code duplicated, block: B:64:0x0478  */
    /* JADX WARN: Code duplicated, block: B:66:0x047b  */
    /* JADX WARN: Code duplicated, block: B:67:0x047d  */
    /* JADX WARN: Code duplicated, block: B:69:0x0480 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:71:0x0483  */
    /* JADX WARN: Code duplicated, block: B:73:0x0549 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:74:0x054a  */
    /* JADX WARN: Code duplicated, block: B:77:0x055e  */
    /* JADX WARN: Code duplicated, block: B:79:0x05ce A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Code duplicated, block: B:80:0x05cf  */
    /* JADX WARN: Code duplicated, block: B:83:0x05ef A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:85:0x05f1  */
    /* JADX WARN: Code duplicated, block: B:87:0x0606  */
    /* JADX WARN: Code duplicated, block: B:88:0x0608  */
    /* JADX WARN: Code duplicated, block: B:91:0x060c  */
    /* JADX WARN: Code duplicated, block: B:93:0x060f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:95:0x0612  */
    @Nullable
    public static final Object bypassXD(@NotNull String url, @NotNull Continuation<? super String> continuation) throws NoSuchAlgorithmException {
        C00021 c00021;
        Object obj;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        int i;
        String str6;
        Object obj2;
        String url2;
        NiceResponse initialResponse;
        String url3;
        String str7;
        String str8;
        char c;
        String url4;
        NiceResponse initialResponse2;
        Function1 isCfBlocked;
        String str9;
        String str10;
        NiceResponse initialResponse3;
        Function1 isCfBlocked2;
        String url5;
        String str11;
        NiceResponse initialResponse4;
        Function1 isCfBlocked3;
        String url6;
        String str12;
        String url7;
        String url8;
        String str13;
        String redirect;
        String baseUrl;
        String it;
        boolean z;
        String code;
        String fingerprint;
        Object obj3;
        String str14;
        Object obj4;
        Map baseHeaders;
        Requests isolatedApp;
        Object objBypassXD$postSession;
        String retryCode;
        String retryBaseUrl;
        Map baseHeaders2;
        String retryCode2;
        Requests isolatedApp2;
        String redirect2;
        NiceResponse initialResponse5;
        JSONObject sessionJson;
        String str15;
        String str16;
        String str17;
        Map baseHeaders3;
        Requests isolatedApp3;
        String fingerprint2;
        String code2;
        String baseUrl2;
        Object obj5;
        Map baseHeaders4;
        String url9;
        Object obj6;
        String str18;
        String str19;
        String str20;
        String str21;
        String fingerprint3;
        Requests isolatedApp4;
        String code3;
        String code4;
        String redirect3;
        NiceResponse initialResponse6;
        String url10;
        String fingerprint4;
        NiceResponse retryResp;
        String str22;
        String retryRedirect;
        String retryBaseUrl2;
        String it2;
        boolean z2;
        String retryCode3;
        Map $this$bypassXD_u24lambda_u246_u241;
        String str23;
        Requests isolatedApp5;
        Map retryHeaders;
        String str24;
        Map baseHeaders5;
        String url11;
        String code5;
        String fingerprint5;
        String code6;
        NiceResponse initialResponse7;
        String baseUrl3;
        String code7;
        String baseUrl4;
        C00021 c00022;
        String fingerprint6;
        Requests isolatedApp6;
        Object objPost$default;
        Object obj7;
        String sessionId;
        boolean z3;
        Object objWithContext;
        JSONObject sessionJson2;
        Map baseHeaders6;
        Requests isolatedApp7;
        String fingerprint7;
        String code8;
        String baseUrl5;
        String sessionId2;
        Object sessionId3;
        NiceResponse retrySessionResp;
        Object obj8;
        String resultUrl;
        String str25;
        String resultUrl2;
        String baseUrl6;
        String code9;
        String baseUrl7;
        String finalResultUrl;
        Object finalResultUrl2;
        String step2Url;
        String step2Url2;
        String sessionId4;
        String code10;
        String baseUrl8;
        Object obj9;
        Object $result;
        String url12;
        Object obj10;
        JSONObject sessionJson3;
        String redirect4;
        NiceResponse initialResponse8;
        Requests isolatedApp8;
        Map baseHeaders7;
        String fingerprint8;
        String baseUrl9;
        String resultUrl3;
        String sessionId5;
        String code11;
        String str26;
        String str27;
        if (continuation instanceof C00021) {
            c00021 = (C00021) continuation;
            if ((c00021.label & Integer.MIN_VALUE) != 0) {
                c00021.label -= Integer.MIN_VALUE;
            } else {
                c00021 = new C00021(continuation);
            }
        } else {
            c00021 = new C00021(continuation);
        }
        C00021 c00023 = c00021;
        Object $result2 = c00023.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String str28 = "/";
        Object obj11 = "Referer";
        String str29 = "location";
        switch (c00023.label) {
            case 0:
                ResultKt.throwOnFailure($result2);
                Requests app = MainActivityKt.getApp();
                XDMoviesCFBypassInterceptor xDMoviesCFBypassInterceptor = XDMoviesCFBypassInterceptor.INSTANCE;
                c00023.L$0 = url;
                c00023.label = 1;
                obj = coroutine_suspended;
                str = "/go/";
                str2 = "/";
                str3 = "/r/";
                str4 = "XDMovies";
                str5 = str29;
                i = 3;
                str6 = null;
                Object obj12 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, xDMoviesCFBypassInterceptor, false, (ResponseParser) null, c00023, 3550, (Object) null);
                c00023 = c00023;
                if (obj12 == obj) {
                    return obj;
                }
                obj2 = obj12;
                url2 = url;
                initialResponse = (NiceResponse) obj2;
                url3 = str5;
                if (initialResponse.getHeaders().get(url3) == null) {
                    isCfBlocked = new Function1() { // from class: com.phisher98.ExtractorKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj13) {
                            return Boolean.valueOf(ExtractorKt.bypassXD$lambda$0((NiceResponse) obj13));
                        }
                    };
                    if (initialResponse.getCode() == 400) {
                        str11 = str4;
                        Log.INSTANCE.d(str11, "Got 400 on initial GET — clearing stale cookies and retrying CF bypass for " + url2);
                        XDMoviesProvider.INSTANCE.setCfCookies("");
                        XDMoviesProvider.INSTANCE.setCfUserAgent("");
                        c00023.L$0 = url2;
                        c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse);
                        c00023.L$2 = SpillingKt.nullOutSpilledVariable(isCfBlocked);
                        c00023.label = 2;
                        if (XDMoviesKt.showXDMoviesCFBypassDialogAndWait(url2, c00023) == obj) {
                            return obj;
                        }
                        initialResponse4 = initialResponse;
                        isCfBlocked3 = isCfBlocked;
                        url6 = url2;
                        Requests app2 = MainActivityKt.getApp();
                        XDMoviesCFBypassInterceptor xDMoviesCFBypassInterceptor2 = XDMoviesCFBypassInterceptor.INSTANCE;
                        c00023.L$0 = url6;
                        c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse4);
                        c00023.L$2 = SpillingKt.nullOutSpilledVariable(isCfBlocked3);
                        c00023.label = i;
                        C00021 c00024 = c00023;
                        str12 = str11;
                        str7 = url3;
                        $result2 = Requests.get$default(app2, url6, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, xDMoviesCFBypassInterceptor2, false, (ResponseParser) null, c00024, 3550, (Object) null);
                        c00023 = c00024;
                        if ($result2 == obj) {
                            return obj;
                        }
                        url7 = url6;
                        initialResponse2 = (NiceResponse) $result2;
                        url4 = url7;
                        str8 = str12;
                        c = 5;
                        str13 = str7;
                        redirect = initialResponse2.getHeaders().get(str13);
                        if (redirect == null) {
                            return str6;
                        }
                        baseUrl = getBaseUrl(redirect);
                        String str30 = str6;
                        str28 = str2;
                        it = StringsKt.substringAfterLast$default(redirect, str28, str30, 2, str30);
                        if (it.length() > 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            code = it;
                        } else {
                            code = null;
                        }
                        if (code == null) {
                            return null;
                        }
                        fingerprint = generateBrowserFingerprint();
                        Pair[] pairArr = new Pair[7];
                        pairArr[0] = TuplesKt.to("User-Agent", "Mozilla/5.0 (Linux; Android 10) AppleWebKit/537.36 Chrome/124 Mobile Safari/537.36");
                        pairArr[1] = TuplesKt.to("Accept", "*/*");
                        obj3 = "Origin";
                        pairArr[2] = TuplesKt.to(obj3, baseUrl);
                        str29 = str13;
                        str14 = str3;
                        obj4 = obj11;
                        pairArr[3] = TuplesKt.to(obj4, baseUrl + str14 + code);
                        pairArr[4] = TuplesKt.to("sec-fetch-site", "same-origin");
                        pairArr[c] = TuplesKt.to("sec-fetch-mode", "cors");
                        pairArr[6] = TuplesKt.to("sec-fetch-dest", "empty");
                        baseHeaders = MapsKt.mapOf(pairArr);
                        isolatedApp = new Requests(MainActivityKt.getApp().getBaseClient().newBuilder().cookieJar(CookieJar.NO_COOKIES).build(), (Map) null, (String) null, (Map) null, (Map) null, 0, (TimeUnit) null, 0L, (ResponseParser) null, 510, (DefaultConstructorMarker) null);
                        c00023.L$0 = url4;
                        c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse2);
                        c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect);
                        c00023.L$3 = baseUrl;
                        c00023.L$4 = code;
                        c00023.L$5 = fingerprint;
                        c00023.L$6 = baseHeaders;
                        c00023.L$7 = isolatedApp;
                        c00023.label = 6;
                        objBypassXD$postSession = bypassXD$postSession(code, baseUrl, fingerprint, isolatedApp, baseHeaders, c00023);
                        if (objBypassXD$postSession == obj) {
                            return obj;
                        }
                        retryCode = code;
                        $result2 = objBypassXD$postSession;
                        retryBaseUrl = baseUrl;
                        baseHeaders2 = baseHeaders;
                        retryCode2 = fingerprint;
                        isolatedApp2 = isolatedApp;
                        redirect2 = redirect;
                        initialResponse5 = initialResponse2;
                        sessionJson = (JSONObject) $result2;
                        if (sessionJson == null) {
                            String str31 = str8;
                            Log.INSTANCE.d(str31, "Retrying bypassXD from scratch after session POST failure");
                            Requests app3 = MainActivityKt.getApp();
                            XDMoviesCFBypassInterceptor xDMoviesCFBypassInterceptor3 = XDMoviesCFBypassInterceptor.INSTANCE;
                            c00023.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                            c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                            c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                            c00023.L$3 = retryBaseUrl;
                            c00023.L$4 = retryCode;
                            c00023.L$5 = retryCode2;
                            c00023.L$6 = baseHeaders2;
                            c00023.L$7 = isolatedApp2;
                            c00023.label = 7;
                            isolatedApp3 = isolatedApp2;
                            fingerprint2 = retryCode2;
                            code2 = retryCode;
                            C00021 c00025 = c00023;
                            baseUrl2 = retryBaseUrl;
                            obj5 = obj3;
                            baseHeaders4 = baseHeaders2;
                            url9 = url4;
                            obj6 = obj4;
                            str18 = str14;
                            str19 = str31;
                            str20 = str29;
                            str21 = str28;
                            $result2 = Requests.get$default(app3, url9, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, xDMoviesCFBypassInterceptor3, false, (ResponseParser) null, c00025, 3550, (Object) null);
                            c00023 = c00025;
                            if ($result2 == obj) {
                                return obj;
                            }
                            fingerprint3 = baseUrl2;
                            isolatedApp4 = isolatedApp3;
                            code3 = code2;
                            code4 = url9;
                            redirect3 = redirect2;
                            initialResponse6 = initialResponse5;
                            url10 = fingerprint2;
                            fingerprint4 = null;
                            retryResp = (NiceResponse) $result2;
                            str22 = str20;
                            retryRedirect = retryResp.getHeaders().get(str22);
                            if (retryRedirect == null) {
                                return null;
                            }
                            retryBaseUrl2 = getBaseUrl(retryRedirect);
                            it2 = StringsKt.substringAfterLast$default(retryRedirect, str21, (String) null, 2, (Object) null);
                            if (it2.length() > 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (!z2) {
                                it2 = null;
                            }
                            if (it2 == null) {
                                return null;
                            }
                            retryCode3 = it2;
                            $this$bypassXD_u24lambda_u246_u241 = MapsKt.toMutableMap(baseHeaders4);
                            $this$bypassXD_u24lambda_u246_u241.put(obj5, retryBaseUrl2);
                            str23 = str18;
                            $this$bypassXD_u24lambda_u246_u241.put(obj6, retryBaseUrl2 + str23 + retryCode3);
                            try {
                                Result.Companion companion = Result.Companion;
                                String str32 = retryBaseUrl2 + "/api/session";
                                try {
                                    RequestBody requestBodyCreate = RequestBody.Companion.create("{\"code\":\"" + retryCode3 + "\",\"fingerprint\":\"" + url10 + "\"}", MediaType.Companion.get("application/json"));
                                    c00023.L$0 = SpillingKt.nullOutSpilledVariable(code4);
                                    c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse6);
                                    c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect3);
                                    c00023.L$3 = fingerprint3;
                                    c00023.L$4 = code3;
                                    c00023.L$5 = url10;
                                    c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders4);
                                    c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp4);
                                    c00023.L$8 = SpillingKt.nullOutSpilledVariable(retryResp);
                                    c00023.L$9 = SpillingKt.nullOutSpilledVariable(retryBaseUrl2);
                                    c00023.L$10 = SpillingKt.nullOutSpilledVariable(retryRedirect);
                                    c00023.L$11 = SpillingKt.nullOutSpilledVariable($this$bypassXD_u24lambda_u246_u241);
                                    c00023.L$12 = SpillingKt.nullOutSpilledVariable(retryCode3);
                                    c00023.label = 8;
                                    code7 = code3;
                                    baseUrl4 = fingerprint3;
                                    c00022 = c00023;
                                    fingerprint6 = url10;
                                    str15 = str23;
                                    str16 = str22;
                                    isolatedApp6 = isolatedApp4;
                                    try {
                                        objPost$default = Requests.post$default(isolatedApp6, str32, $this$bypassXD_u24lambda_u246_u241, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                                        c00023 = c00022;
                                        if (objPost$default == obj) {
                                            return obj;
                                        }
                                        isolatedApp5 = isolatedApp6;
                                        retryHeaders = $this$bypassXD_u24lambda_u246_u241;
                                        str24 = fingerprint4;
                                        baseHeaders5 = baseHeaders4;
                                        url11 = code4;
                                        code5 = code7;
                                        retryBaseUrl2 = retryBaseUrl2;
                                        fingerprint5 = fingerprint6;
                                        code6 = retryCode3;
                                        $result2 = objPost$default;
                                        initialResponse7 = initialResponse6;
                                        baseUrl3 = baseUrl4;
                                        try {
                                            obj7 = Result.constructor-impl((NiceResponse) $result2);
                                        } catch (Throwable th) {
                                            th = th;
                                            Result.Companion companion2 = Result.Companion;
                                            obj7 = Result.constructor-impl(ResultKt.createFailure(th));
                                        }
                                        isolatedApp2 = isolatedApp5;
                                        baseHeaders3 = baseHeaders5;
                                        initialResponse5 = initialResponse7;
                                        url4 = url11;
                                        retryCode2 = fingerprint5;
                                        retryBaseUrl = baseUrl3;
                                        if (Result.exceptionOrNull-impl(obj7) != null) {
                                            return null;
                                        }
                                        retrySessionResp = (NiceResponse) obj7;
                                        if (retrySessionResp.getCode() == 400) {
                                            Log.INSTANCE.e(str19, "Retry session POST also got 400 — giving up");
                                            return null;
                                        }
                                        str17 = str19;
                                        try {
                                            Result.Companion companion3 = Result.Companion;
                                            try {
                                                obj8 = Result.constructor-impl(new JSONObject(retrySessionResp.getText()));
                                            } catch (Throwable th2) {
                                                th = th2;
                                                Result.Companion companion4 = Result.Companion;
                                                obj8 = Result.constructor-impl(ResultKt.createFailure(th));
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                        }
                                        if (Result.exceptionOrNull-impl(obj8) != null) {
                                            return null;
                                        }
                                        sessionJson = (JSONObject) obj8;
                                        retryCode = code5;
                                        redirect2 = redirect3;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        c00023 = c00022;
                                        isolatedApp5 = isolatedApp6;
                                        retryHeaders = $this$bypassXD_u24lambda_u246_u241;
                                        str24 = fingerprint4;
                                        baseHeaders5 = baseHeaders4;
                                        url11 = code4;
                                        code5 = code7;
                                        retryBaseUrl2 = retryBaseUrl2;
                                        fingerprint5 = fingerprint6;
                                        code6 = retryCode3;
                                        initialResponse7 = initialResponse6;
                                        baseUrl3 = baseUrl4;
                                        Result.Companion companion5 = Result.Companion;
                                        obj7 = Result.constructor-impl(ResultKt.createFailure(th));
                                        isolatedApp2 = isolatedApp5;
                                        baseHeaders3 = baseHeaders5;
                                        initialResponse5 = initialResponse7;
                                        url4 = url11;
                                        retryCode2 = fingerprint5;
                                        retryBaseUrl = baseUrl3;
                                        if (Result.exceptionOrNull-impl(obj7) != null) {
                                            return null;
                                        }
                                        retrySessionResp = (NiceResponse) obj7;
                                        if (retrySessionResp.getCode() == 400) {
                                            Log.INSTANCE.e(str19, "Retry session POST also got 400 — giving up");
                                            return null;
                                        }
                                        str17 = str19;
                                        Result.Companion companion6 = Result.Companion;
                                        obj8 = Result.constructor-impl(new JSONObject(retrySessionResp.getText()));
                                        if (Result.exceptionOrNull-impl(obj8) != null) {
                                            return null;
                                        }
                                        sessionJson = (JSONObject) obj8;
                                        retryCode = code5;
                                        redirect2 = redirect3;
                                        sessionId = sessionJson.optString("sessionId");
                                        if (sessionId.length() > 0) {
                                            z3 = true;
                                        } else {
                                            z3 = false;
                                        }
                                        if (!z3) {
                                            sessionId = null;
                                        }
                                        if (sessionId == null) {
                                            return null;
                                        }
                                        CoroutineContext main = Dispatchers.getMain();
                                        ExtractorKt$bypassXD$resultUrl$1 extractorKt$bypassXD$resultUrl$1 = new ExtractorKt$bypassXD$resultUrl$1(retryBaseUrl, sessionId, retryCode2, null);
                                        c00023.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                                        c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                                        c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                                        c00023.L$3 = retryBaseUrl;
                                        c00023.L$4 = retryCode;
                                        c00023.L$5 = SpillingKt.nullOutSpilledVariable(retryCode2);
                                        c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders3);
                                        c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp2);
                                        c00023.L$8 = SpillingKt.nullOutSpilledVariable(sessionJson);
                                        c00023.L$9 = sessionId;
                                        c00023.L$10 = null;
                                        c00023.L$11 = null;
                                        c00023.L$12 = null;
                                        c00023.label = 9;
                                        objWithContext = BuildersKt.withContext(main, extractorKt$bypassXD$resultUrl$1, c00023);
                                        if (objWithContext == obj) {
                                            return obj;
                                        }
                                        sessionJson2 = sessionJson;
                                        baseHeaders6 = baseHeaders3;
                                        isolatedApp7 = isolatedApp2;
                                        fingerprint7 = retryCode2;
                                        code8 = retryCode;
                                        $result2 = objWithContext;
                                        baseUrl5 = retryBaseUrl;
                                        sessionId2 = sessionId;
                                        sessionId3 = url4;
                                        resultUrl = (String) $result2;
                                        if (resultUrl == null) {
                                            return null;
                                        }
                                        Log.INSTANCE.d(str17, "Intercepted URL: " + resultUrl);
                                        if (StringsKt.startsWith$default(resultUrl, "COMPLETE:", false, 2, (Object) null)) {
                                            String completeToken = StringsKt.substringAfter$default(resultUrl, "COMPLETE:", (String) null, 2, (Object) null);
                                            String finalResultUrl3 = baseUrl5 + str + sessionId2 + "?t=" + completeToken;
                                            finalResultUrl2 = sessionId3;
                                            resultUrl2 = resultUrl;
                                            baseUrl6 = baseUrl5;
                                            step2Url = sessionId2;
                                            code9 = code8;
                                            finalResultUrl = finalResultUrl3;
                                            baseUrl7 = str16;
                                        } else {
                                            str25 = str;
                                            if (Intrinsics.areEqual(resultUrl, "COMPLETE")) {
                                                step2Url2 = baseUrl5 + str15 + code8 + "?step=2&sid=" + sessionId2;
                                                Requests app4 = MainActivityKt.getApp();
                                                c00023.L$0 = SpillingKt.nullOutSpilledVariable(sessionId3);
                                                c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                                                c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                                                c00023.L$3 = SpillingKt.nullOutSpilledVariable(baseUrl5);
                                                c00023.L$4 = SpillingKt.nullOutSpilledVariable(code8);
                                                c00023.L$5 = SpillingKt.nullOutSpilledVariable(fingerprint7);
                                                c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders6);
                                                c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp7);
                                                c00023.L$8 = SpillingKt.nullOutSpilledVariable(sessionJson2);
                                                c00023.L$9 = sessionId2;
                                                c00023.L$10 = SpillingKt.nullOutSpilledVariable(resultUrl);
                                                c00023.L$11 = SpillingKt.nullOutSpilledVariable(resultUrl);
                                                c00023.L$12 = step2Url2;
                                                c00023.label = 10;
                                                sessionId4 = sessionId2;
                                                code10 = code8;
                                                C00021 c00026 = c00023;
                                                baseUrl8 = baseUrl5;
                                                str = str25;
                                                obj9 = Requests.get$default(app4, step2Url2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00026, 4062, (Object) null);
                                                c00023 = c00026;
                                                if (obj9 == obj) {
                                                    return obj;
                                                }
                                                $result = sessionId3;
                                                url12 = step2Url2;
                                                obj10 = obj9;
                                                sessionJson3 = sessionJson2;
                                                redirect4 = redirect2;
                                                initialResponse8 = initialResponse5;
                                                isolatedApp8 = isolatedApp7;
                                                baseHeaders7 = baseHeaders6;
                                                fingerprint8 = fingerprint7;
                                                baseUrl9 = baseUrl8;
                                                resultUrl3 = resultUrl;
                                                sessionId5 = sessionId4;
                                                code11 = code10;
                                                NiceResponse step2Resp = (NiceResponse) obj10;
                                                String baseUrl10 = baseUrl9;
                                                baseUrl7 = str16;
                                                str27 = step2Resp.getHeaders().get(baseUrl7);
                                                if (str27 == null) {
                                                    str27 = url12;
                                                }
                                                String finalResultUrl4 = str27;
                                                baseUrl6 = baseUrl10;
                                                finalResultUrl2 = $result;
                                                redirect2 = redirect4;
                                                finalResultUrl = finalResultUrl4;
                                                resultUrl2 = resultUrl3;
                                                step2Url = sessionId5;
                                                sessionJson2 = sessionJson3;
                                                isolatedApp7 = isolatedApp8;
                                                baseHeaders6 = baseHeaders7;
                                                fingerprint7 = fingerprint8;
                                                code9 = code11;
                                                initialResponse5 = initialResponse8;
                                            } else {
                                                resultUrl2 = resultUrl;
                                                baseUrl6 = baseUrl5;
                                                code9 = code8;
                                                str = str25;
                                                baseUrl7 = str16;
                                                finalResultUrl = resultUrl;
                                                finalResultUrl2 = sessionId3;
                                                step2Url = sessionId2;
                                            }
                                        }
                                        if (!StringsKt.contains(finalResultUrl, str, true)) {
                                            return finalResultUrl;
                                        }
                                        Requests app5 = MainActivityKt.getApp();
                                        Map mapMapOf = MapsKt.mapOf(TuplesKt.to("Cookie", "sid=" + step2Url));
                                        XDMoviesCFBypassInterceptor xDMoviesCFBypassInterceptor4 = XDMoviesCFBypassInterceptor.INSTANCE;
                                        c00023.L$0 = SpillingKt.nullOutSpilledVariable(finalResultUrl2);
                                        c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                                        c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                                        c00023.L$3 = SpillingKt.nullOutSpilledVariable(baseUrl6);
                                        c00023.L$4 = SpillingKt.nullOutSpilledVariable(code9);
                                        c00023.L$5 = SpillingKt.nullOutSpilledVariable(fingerprint7);
                                        c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders6);
                                        c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp7);
                                        c00023.L$8 = SpillingKt.nullOutSpilledVariable(sessionJson2);
                                        c00023.L$9 = SpillingKt.nullOutSpilledVariable(step2Url);
                                        c00023.L$10 = SpillingKt.nullOutSpilledVariable(resultUrl2);
                                        c00023.L$11 = SpillingKt.nullOutSpilledVariable(finalResultUrl);
                                        c00023.L$12 = null;
                                        c00023.label = 11;
                                        str26 = baseUrl7;
                                        $result2 = Requests.get$default(app5, finalResultUrl, mapMapOf, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, xDMoviesCFBypassInterceptor4, false, (ResponseParser) null, c00023, 3548, (Object) null);
                                        if ($result2 == obj) {
                                            return obj;
                                        }
                                        return ((NiceResponse) $result2).getHeaders().get(str26);
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                    String str33 = fingerprint3;
                                    str16 = str22;
                                    str15 = str23;
                                    isolatedApp5 = isolatedApp4;
                                    retryHeaders = $this$bypassXD_u24lambda_u246_u241;
                                    str24 = fingerprint4;
                                    baseHeaders5 = baseHeaders4;
                                    url11 = code4;
                                    code5 = code3;
                                    fingerprint5 = url10;
                                    code6 = retryCode3;
                                    initialResponse7 = initialResponse6;
                                    baseUrl3 = str33;
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                String str34 = fingerprint3;
                                str16 = str22;
                                str15 = str23;
                                isolatedApp5 = isolatedApp4;
                                retryHeaders = $this$bypassXD_u24lambda_u246_u241;
                                str24 = fingerprint4;
                                baseHeaders5 = baseHeaders4;
                                url11 = code4;
                                code5 = code3;
                                fingerprint5 = url10;
                                code6 = retryCode3;
                                initialResponse7 = initialResponse6;
                                baseUrl3 = str34;
                            }
                            break;
                        } else {
                            str15 = str14;
                            str16 = str29;
                            str17 = str8;
                            baseHeaders3 = baseHeaders2;
                        }
                        sessionId = sessionJson.optString("sessionId");
                        if (sessionId.length() > 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (!z3) {
                            sessionId = null;
                        }
                        if (sessionId == null) {
                            return null;
                        }
                        CoroutineContext main2 = Dispatchers.getMain();
                        ExtractorKt$bypassXD$resultUrl$1 extractorKt$bypassXD$resultUrl$2 = new ExtractorKt$bypassXD$resultUrl$1(retryBaseUrl, sessionId, retryCode2, null);
                        c00023.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                        c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                        c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                        c00023.L$3 = retryBaseUrl;
                        c00023.L$4 = retryCode;
                        c00023.L$5 = SpillingKt.nullOutSpilledVariable(retryCode2);
                        c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders3);
                        c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp2);
                        c00023.L$8 = SpillingKt.nullOutSpilledVariable(sessionJson);
                        c00023.L$9 = sessionId;
                        c00023.L$10 = null;
                        c00023.L$11 = null;
                        c00023.L$12 = null;
                        c00023.label = 9;
                        objWithContext = BuildersKt.withContext(main2, extractorKt$bypassXD$resultUrl$2, c00023);
                        if (objWithContext == obj) {
                            return obj;
                        }
                        sessionJson2 = sessionJson;
                        baseHeaders6 = baseHeaders3;
                        isolatedApp7 = isolatedApp2;
                        fingerprint7 = retryCode2;
                        code8 = retryCode;
                        $result2 = objWithContext;
                        baseUrl5 = retryBaseUrl;
                        sessionId2 = sessionId;
                        sessionId3 = url4;
                        resultUrl = (String) $result2;
                        if (resultUrl == null) {
                            return null;
                        }
                        Log.INSTANCE.d(str17, "Intercepted URL: " + resultUrl);
                        if (StringsKt.startsWith$default(resultUrl, "COMPLETE:", false, 2, (Object) null)) {
                            String completeToken2 = StringsKt.substringAfter$default(resultUrl, "COMPLETE:", (String) null, 2, (Object) null);
                            String finalResultUrl5 = baseUrl5 + str + sessionId2 + "?t=" + completeToken2;
                            finalResultUrl2 = sessionId3;
                            resultUrl2 = resultUrl;
                            baseUrl6 = baseUrl5;
                            step2Url = sessionId2;
                            code9 = code8;
                            finalResultUrl = finalResultUrl5;
                            baseUrl7 = str16;
                        } else {
                            str25 = str;
                            if (Intrinsics.areEqual(resultUrl, "COMPLETE")) {
                                step2Url2 = baseUrl5 + str15 + code8 + "?step=2&sid=" + sessionId2;
                                Requests app6 = MainActivityKt.getApp();
                                c00023.L$0 = SpillingKt.nullOutSpilledVariable(sessionId3);
                                c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                                c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                                c00023.L$3 = SpillingKt.nullOutSpilledVariable(baseUrl5);
                                c00023.L$4 = SpillingKt.nullOutSpilledVariable(code8);
                                c00023.L$5 = SpillingKt.nullOutSpilledVariable(fingerprint7);
                                c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders6);
                                c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp7);
                                c00023.L$8 = SpillingKt.nullOutSpilledVariable(sessionJson2);
                                c00023.L$9 = sessionId2;
                                c00023.L$10 = SpillingKt.nullOutSpilledVariable(resultUrl);
                                c00023.L$11 = SpillingKt.nullOutSpilledVariable(resultUrl);
                                c00023.L$12 = step2Url2;
                                c00023.label = 10;
                                sessionId4 = sessionId2;
                                code10 = code8;
                                C00021 c00027 = c00023;
                                baseUrl8 = baseUrl5;
                                str = str25;
                                obj9 = Requests.get$default(app6, step2Url2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00027, 4062, (Object) null);
                                c00023 = c00027;
                                if (obj9 == obj) {
                                    return obj;
                                }
                                $result = sessionId3;
                                url12 = step2Url2;
                                obj10 = obj9;
                                sessionJson3 = sessionJson2;
                                redirect4 = redirect2;
                                initialResponse8 = initialResponse5;
                                isolatedApp8 = isolatedApp7;
                                baseHeaders7 = baseHeaders6;
                                fingerprint8 = fingerprint7;
                                baseUrl9 = baseUrl8;
                                resultUrl3 = resultUrl;
                                sessionId5 = sessionId4;
                                code11 = code10;
                                NiceResponse step2Resp2 = (NiceResponse) obj10;
                                String baseUrl11 = baseUrl9;
                                baseUrl7 = str16;
                                str27 = step2Resp2.getHeaders().get(baseUrl7);
                                if (str27 == null) {
                                    str27 = url12;
                                }
                                String finalResultUrl6 = str27;
                                baseUrl6 = baseUrl11;
                                finalResultUrl2 = $result;
                                redirect2 = redirect4;
                                finalResultUrl = finalResultUrl6;
                                resultUrl2 = resultUrl3;
                                step2Url = sessionId5;
                                sessionJson2 = sessionJson3;
                                isolatedApp7 = isolatedApp8;
                                baseHeaders6 = baseHeaders7;
                                fingerprint7 = fingerprint8;
                                code9 = code11;
                                initialResponse5 = initialResponse8;
                            } else {
                                resultUrl2 = resultUrl;
                                baseUrl6 = baseUrl5;
                                code9 = code8;
                                str = str25;
                                baseUrl7 = str16;
                                finalResultUrl = resultUrl;
                                finalResultUrl2 = sessionId3;
                                step2Url = sessionId2;
                            }
                        }
                        if (!StringsKt.contains(finalResultUrl, str, true)) {
                            return finalResultUrl;
                        }
                        Requests app7 = MainActivityKt.getApp();
                        Map mapMapOf2 = MapsKt.mapOf(TuplesKt.to("Cookie", "sid=" + step2Url));
                        XDMoviesCFBypassInterceptor xDMoviesCFBypassInterceptor5 = XDMoviesCFBypassInterceptor.INSTANCE;
                        c00023.L$0 = SpillingKt.nullOutSpilledVariable(finalResultUrl2);
                        c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                        c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                        c00023.L$3 = SpillingKt.nullOutSpilledVariable(baseUrl6);
                        c00023.L$4 = SpillingKt.nullOutSpilledVariable(code9);
                        c00023.L$5 = SpillingKt.nullOutSpilledVariable(fingerprint7);
                        c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders6);
                        c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp7);
                        c00023.L$8 = SpillingKt.nullOutSpilledVariable(sessionJson2);
                        c00023.L$9 = SpillingKt.nullOutSpilledVariable(step2Url);
                        c00023.L$10 = SpillingKt.nullOutSpilledVariable(resultUrl2);
                        c00023.L$11 = SpillingKt.nullOutSpilledVariable(finalResultUrl);
                        c00023.L$12 = null;
                        c00023.label = 11;
                        str26 = baseUrl7;
                        $result2 = Requests.get$default(app7, finalResultUrl, mapMapOf2, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, xDMoviesCFBypassInterceptor5, false, (ResponseParser) null, c00023, 3548, (Object) null);
                        if ($result2 == obj) {
                            return obj;
                        }
                        return ((NiceResponse) $result2).getHeaders().get(str26);
                    }
                    str7 = url3;
                    str9 = str4;
                    if (((Boolean) isCfBlocked.invoke(initialResponse)).booleanValue()) {
                        str10 = str9;
                        Log.INSTANCE.d(str10, "CF challenge on link domain – launching WebView bypass for " + url2);
                        c00023.L$0 = url2;
                        c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse);
                        c00023.L$2 = SpillingKt.nullOutSpilledVariable(isCfBlocked);
                        c00023.label = 4;
                        if (XDMoviesKt.showXDMoviesCFBypassDialogAndWait(url2, c00023) == obj) {
                            return obj;
                        }
                        initialResponse3 = initialResponse;
                        isCfBlocked2 = isCfBlocked;
                        url5 = url2;
                        Requests app8 = MainActivityKt.getApp();
                        XDMoviesCFBypassInterceptor xDMoviesCFBypassInterceptor6 = XDMoviesCFBypassInterceptor.INSTANCE;
                        c00023.L$0 = url5;
                        c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse3);
                        c00023.L$2 = SpillingKt.nullOutSpilledVariable(isCfBlocked2);
                        c00023.label = 5;
                        c = 5;
                        C00021 c00028 = c00023;
                        str8 = str10;
                        $result2 = Requests.get$default(app8, url5, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, xDMoviesCFBypassInterceptor6, false, (ResponseParser) null, c00028, 3550, (Object) null);
                        c00023 = c00028;
                        if ($result2 == obj) {
                            return obj;
                        }
                        url8 = url5;
                        initialResponse2 = (NiceResponse) $result2;
                        url4 = url8;
                        str13 = str7;
                        redirect = initialResponse2.getHeaders().get(str13);
                        if (redirect == null) {
                            return str6;
                        }
                        baseUrl = getBaseUrl(redirect);
                        String str35 = str6;
                        str28 = str2;
                        it = StringsKt.substringAfterLast$default(redirect, str28, str35, 2, str35);
                        if (it.length() > 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            code = it;
                        } else {
                            code = null;
                        }
                        if (code == null) {
                            return null;
                        }
                        fingerprint = generateBrowserFingerprint();
                        Pair[] pairArr2 = new Pair[7];
                        pairArr2[0] = TuplesKt.to("User-Agent", "Mozilla/5.0 (Linux; Android 10) AppleWebKit/537.36 Chrome/124 Mobile Safari/537.36");
                        pairArr2[1] = TuplesKt.to("Accept", "*/*");
                        obj3 = "Origin";
                        pairArr2[2] = TuplesKt.to(obj3, baseUrl);
                        str29 = str13;
                        str14 = str3;
                        obj4 = obj11;
                        pairArr2[3] = TuplesKt.to(obj4, baseUrl + str14 + code);
                        pairArr2[4] = TuplesKt.to("sec-fetch-site", "same-origin");
                        pairArr2[c] = TuplesKt.to("sec-fetch-mode", "cors");
                        pairArr2[6] = TuplesKt.to("sec-fetch-dest", "empty");
                        baseHeaders = MapsKt.mapOf(pairArr2);
                        isolatedApp = new Requests(MainActivityKt.getApp().getBaseClient().newBuilder().cookieJar(CookieJar.NO_COOKIES).build(), (Map) null, (String) null, (Map) null, (Map) null, 0, (TimeUnit) null, 0L, (ResponseParser) null, 510, (DefaultConstructorMarker) null);
                        c00023.L$0 = url4;
                        c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse2);
                        c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect);
                        c00023.L$3 = baseUrl;
                        c00023.L$4 = code;
                        c00023.L$5 = fingerprint;
                        c00023.L$6 = baseHeaders;
                        c00023.L$7 = isolatedApp;
                        c00023.label = 6;
                        objBypassXD$postSession = bypassXD$postSession(code, baseUrl, fingerprint, isolatedApp, baseHeaders, c00023);
                        if (objBypassXD$postSession == obj) {
                            return obj;
                        }
                        retryCode = code;
                        $result2 = objBypassXD$postSession;
                        retryBaseUrl = baseUrl;
                        baseHeaders2 = baseHeaders;
                        retryCode2 = fingerprint;
                        isolatedApp2 = isolatedApp;
                        redirect2 = redirect;
                        initialResponse5 = initialResponse2;
                        sessionJson = (JSONObject) $result2;
                        if (sessionJson == null) {
                            String str36 = str8;
                            Log.INSTANCE.d(str36, "Retrying bypassXD from scratch after session POST failure");
                            Requests app9 = MainActivityKt.getApp();
                            XDMoviesCFBypassInterceptor xDMoviesCFBypassInterceptor7 = XDMoviesCFBypassInterceptor.INSTANCE;
                            c00023.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                            c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                            c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                            c00023.L$3 = retryBaseUrl;
                            c00023.L$4 = retryCode;
                            c00023.L$5 = retryCode2;
                            c00023.L$6 = baseHeaders2;
                            c00023.L$7 = isolatedApp2;
                            c00023.label = 7;
                            isolatedApp3 = isolatedApp2;
                            fingerprint2 = retryCode2;
                            code2 = retryCode;
                            C00021 c00029 = c00023;
                            baseUrl2 = retryBaseUrl;
                            obj5 = obj3;
                            baseHeaders4 = baseHeaders2;
                            url9 = url4;
                            obj6 = obj4;
                            str18 = str14;
                            str19 = str36;
                            str20 = str29;
                            str21 = str28;
                            $result2 = Requests.get$default(app9, url9, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, xDMoviesCFBypassInterceptor7, false, (ResponseParser) null, c00029, 3550, (Object) null);
                            c00023 = c00029;
                            if ($result2 == obj) {
                                return obj;
                            }
                            fingerprint3 = baseUrl2;
                            isolatedApp4 = isolatedApp3;
                            code3 = code2;
                            code4 = url9;
                            redirect3 = redirect2;
                            initialResponse6 = initialResponse5;
                            url10 = fingerprint2;
                            fingerprint4 = null;
                            retryResp = (NiceResponse) $result2;
                            str22 = str20;
                            retryRedirect = retryResp.getHeaders().get(str22);
                            if (retryRedirect == null) {
                                return null;
                            }
                            retryBaseUrl2 = getBaseUrl(retryRedirect);
                            it2 = StringsKt.substringAfterLast$default(retryRedirect, str21, (String) null, 2, (Object) null);
                            if (it2.length() > 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (!z2) {
                                it2 = null;
                            }
                            if (it2 == null) {
                                return null;
                            }
                            retryCode3 = it2;
                            $this$bypassXD_u24lambda_u246_u241 = MapsKt.toMutableMap(baseHeaders4);
                            $this$bypassXD_u24lambda_u246_u241.put(obj5, retryBaseUrl2);
                            str23 = str18;
                            $this$bypassXD_u24lambda_u246_u241.put(obj6, retryBaseUrl2 + str23 + retryCode3);
                            Result.Companion companion7 = Result.Companion;
                            String str37 = retryBaseUrl2 + "/api/session";
                            RequestBody requestBodyCreate2 = RequestBody.Companion.create("{\"code\":\"" + retryCode3 + "\",\"fingerprint\":\"" + url10 + "\"}", MediaType.Companion.get("application/json"));
                            c00023.L$0 = SpillingKt.nullOutSpilledVariable(code4);
                            c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse6);
                            c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect3);
                            c00023.L$3 = fingerprint3;
                            c00023.L$4 = code3;
                            c00023.L$5 = url10;
                            c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders4);
                            c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp4);
                            c00023.L$8 = SpillingKt.nullOutSpilledVariable(retryResp);
                            c00023.L$9 = SpillingKt.nullOutSpilledVariable(retryBaseUrl2);
                            c00023.L$10 = SpillingKt.nullOutSpilledVariable(retryRedirect);
                            c00023.L$11 = SpillingKt.nullOutSpilledVariable($this$bypassXD_u24lambda_u246_u241);
                            c00023.L$12 = SpillingKt.nullOutSpilledVariable(retryCode3);
                            c00023.label = 8;
                            code7 = code3;
                            baseUrl4 = fingerprint3;
                            c00022 = c00023;
                            fingerprint6 = url10;
                            str15 = str23;
                            str16 = str22;
                            isolatedApp6 = isolatedApp4;
                            objPost$default = Requests.post$default(isolatedApp6, str37, $this$bypassXD_u24lambda_u246_u241, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate2, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                            c00023 = c00022;
                            if (objPost$default == obj) {
                                return obj;
                            }
                            isolatedApp5 = isolatedApp6;
                            retryHeaders = $this$bypassXD_u24lambda_u246_u241;
                            str24 = fingerprint4;
                            baseHeaders5 = baseHeaders4;
                            url11 = code4;
                            code5 = code7;
                            retryBaseUrl2 = retryBaseUrl2;
                            fingerprint5 = fingerprint6;
                            code6 = retryCode3;
                            $result2 = objPost$default;
                            initialResponse7 = initialResponse6;
                            baseUrl3 = baseUrl4;
                            obj7 = Result.constructor-impl((NiceResponse) $result2);
                            isolatedApp2 = isolatedApp5;
                            baseHeaders3 = baseHeaders5;
                            initialResponse5 = initialResponse7;
                            url4 = url11;
                            retryCode2 = fingerprint5;
                            retryBaseUrl = baseUrl3;
                            if (Result.exceptionOrNull-impl(obj7) != null) {
                                return null;
                            }
                            retrySessionResp = (NiceResponse) obj7;
                            if (retrySessionResp.getCode() == 400) {
                                Log.INSTANCE.e(str19, "Retry session POST also got 400 — giving up");
                                return null;
                            }
                            str17 = str19;
                            Result.Companion companion8 = Result.Companion;
                            obj8 = Result.constructor-impl(new JSONObject(retrySessionResp.getText()));
                            if (Result.exceptionOrNull-impl(obj8) != null) {
                                return null;
                            }
                            sessionJson = (JSONObject) obj8;
                            retryCode = code5;
                            redirect2 = redirect3;
                        } else {
                            str15 = str14;
                            str16 = str29;
                            str17 = str8;
                            baseHeaders3 = baseHeaders2;
                        }
                        sessionId = sessionJson.optString("sessionId");
                        if (sessionId.length() > 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (!z3) {
                            sessionId = null;
                        }
                        if (sessionId == null) {
                            return null;
                        }
                        CoroutineContext main3 = Dispatchers.getMain();
                        ExtractorKt$bypassXD$resultUrl$1 extractorKt$bypassXD$resultUrl$3 = new ExtractorKt$bypassXD$resultUrl$1(retryBaseUrl, sessionId, retryCode2, null);
                        c00023.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                        c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                        c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                        c00023.L$3 = retryBaseUrl;
                        c00023.L$4 = retryCode;
                        c00023.L$5 = SpillingKt.nullOutSpilledVariable(retryCode2);
                        c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders3);
                        c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp2);
                        c00023.L$8 = SpillingKt.nullOutSpilledVariable(sessionJson);
                        c00023.L$9 = sessionId;
                        c00023.L$10 = null;
                        c00023.L$11 = null;
                        c00023.L$12 = null;
                        c00023.label = 9;
                        objWithContext = BuildersKt.withContext(main3, extractorKt$bypassXD$resultUrl$3, c00023);
                        if (objWithContext == obj) {
                            return obj;
                        }
                        sessionJson2 = sessionJson;
                        baseHeaders6 = baseHeaders3;
                        isolatedApp7 = isolatedApp2;
                        fingerprint7 = retryCode2;
                        code8 = retryCode;
                        $result2 = objWithContext;
                        baseUrl5 = retryBaseUrl;
                        sessionId2 = sessionId;
                        sessionId3 = url4;
                        resultUrl = (String) $result2;
                        if (resultUrl == null) {
                            return null;
                        }
                        Log.INSTANCE.d(str17, "Intercepted URL: " + resultUrl);
                        if (StringsKt.startsWith$default(resultUrl, "COMPLETE:", false, 2, (Object) null)) {
                            String completeToken3 = StringsKt.substringAfter$default(resultUrl, "COMPLETE:", (String) null, 2, (Object) null);
                            String finalResultUrl7 = baseUrl5 + str + sessionId2 + "?t=" + completeToken3;
                            finalResultUrl2 = sessionId3;
                            resultUrl2 = resultUrl;
                            baseUrl6 = baseUrl5;
                            step2Url = sessionId2;
                            code9 = code8;
                            finalResultUrl = finalResultUrl7;
                            baseUrl7 = str16;
                        } else {
                            str25 = str;
                            if (Intrinsics.areEqual(resultUrl, "COMPLETE")) {
                                step2Url2 = baseUrl5 + str15 + code8 + "?step=2&sid=" + sessionId2;
                                Requests app10 = MainActivityKt.getApp();
                                c00023.L$0 = SpillingKt.nullOutSpilledVariable(sessionId3);
                                c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                                c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                                c00023.L$3 = SpillingKt.nullOutSpilledVariable(baseUrl5);
                                c00023.L$4 = SpillingKt.nullOutSpilledVariable(code8);
                                c00023.L$5 = SpillingKt.nullOutSpilledVariable(fingerprint7);
                                c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders6);
                                c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp7);
                                c00023.L$8 = SpillingKt.nullOutSpilledVariable(sessionJson2);
                                c00023.L$9 = sessionId2;
                                c00023.L$10 = SpillingKt.nullOutSpilledVariable(resultUrl);
                                c00023.L$11 = SpillingKt.nullOutSpilledVariable(resultUrl);
                                c00023.L$12 = step2Url2;
                                c00023.label = 10;
                                sessionId4 = sessionId2;
                                code10 = code8;
                                C00021 c000210 = c00023;
                                baseUrl8 = baseUrl5;
                                str = str25;
                                obj9 = Requests.get$default(app10, step2Url2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000210, 4062, (Object) null);
                                c00023 = c000210;
                                if (obj9 == obj) {
                                    return obj;
                                }
                                $result = sessionId3;
                                url12 = step2Url2;
                                obj10 = obj9;
                                sessionJson3 = sessionJson2;
                                redirect4 = redirect2;
                                initialResponse8 = initialResponse5;
                                isolatedApp8 = isolatedApp7;
                                baseHeaders7 = baseHeaders6;
                                fingerprint8 = fingerprint7;
                                baseUrl9 = baseUrl8;
                                resultUrl3 = resultUrl;
                                sessionId5 = sessionId4;
                                code11 = code10;
                                NiceResponse step2Resp3 = (NiceResponse) obj10;
                                String baseUrl12 = baseUrl9;
                                baseUrl7 = str16;
                                str27 = step2Resp3.getHeaders().get(baseUrl7);
                                if (str27 == null) {
                                    str27 = url12;
                                }
                                String finalResultUrl8 = str27;
                                baseUrl6 = baseUrl12;
                                finalResultUrl2 = $result;
                                redirect2 = redirect4;
                                finalResultUrl = finalResultUrl8;
                                resultUrl2 = resultUrl3;
                                step2Url = sessionId5;
                                sessionJson2 = sessionJson3;
                                isolatedApp7 = isolatedApp8;
                                baseHeaders6 = baseHeaders7;
                                fingerprint7 = fingerprint8;
                                code9 = code11;
                                initialResponse5 = initialResponse8;
                            } else {
                                resultUrl2 = resultUrl;
                                baseUrl6 = baseUrl5;
                                code9 = code8;
                                str = str25;
                                baseUrl7 = str16;
                                finalResultUrl = resultUrl;
                                finalResultUrl2 = sessionId3;
                                step2Url = sessionId2;
                            }
                        }
                        if (!StringsKt.contains(finalResultUrl, str, true)) {
                            return finalResultUrl;
                        }
                        Requests app11 = MainActivityKt.getApp();
                        Map mapMapOf3 = MapsKt.mapOf(TuplesKt.to("Cookie", "sid=" + step2Url));
                        XDMoviesCFBypassInterceptor xDMoviesCFBypassInterceptor8 = XDMoviesCFBypassInterceptor.INSTANCE;
                        c00023.L$0 = SpillingKt.nullOutSpilledVariable(finalResultUrl2);
                        c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                        c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                        c00023.L$3 = SpillingKt.nullOutSpilledVariable(baseUrl6);
                        c00023.L$4 = SpillingKt.nullOutSpilledVariable(code9);
                        c00023.L$5 = SpillingKt.nullOutSpilledVariable(fingerprint7);
                        c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders6);
                        c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp7);
                        c00023.L$8 = SpillingKt.nullOutSpilledVariable(sessionJson2);
                        c00023.L$9 = SpillingKt.nullOutSpilledVariable(step2Url);
                        c00023.L$10 = SpillingKt.nullOutSpilledVariable(resultUrl2);
                        c00023.L$11 = SpillingKt.nullOutSpilledVariable(finalResultUrl);
                        c00023.L$12 = null;
                        c00023.label = 11;
                        str26 = baseUrl7;
                        $result2 = Requests.get$default(app11, finalResultUrl, mapMapOf3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, xDMoviesCFBypassInterceptor8, false, (ResponseParser) null, c00023, 3548, (Object) null);
                        if ($result2 == obj) {
                            return obj;
                        }
                        return ((NiceResponse) $result2).getHeaders().get(str26);
                    }
                    str8 = str9;
                    c = 5;
                } else {
                    str7 = url3;
                    str8 = str4;
                    c = 5;
                }
                url4 = url2;
                initialResponse2 = initialResponse;
                str13 = str7;
                redirect = initialResponse2.getHeaders().get(str13);
                if (redirect == null) {
                    return str6;
                }
                baseUrl = getBaseUrl(redirect);
                String str38 = str6;
                str28 = str2;
                it = StringsKt.substringAfterLast$default(redirect, str28, str38, 2, str38);
                if (it.length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    code = it;
                } else {
                    code = null;
                }
                if (code == null) {
                    return null;
                }
                fingerprint = generateBrowserFingerprint();
                Pair[] pairArr3 = new Pair[7];
                pairArr3[0] = TuplesKt.to("User-Agent", "Mozilla/5.0 (Linux; Android 10) AppleWebKit/537.36 Chrome/124 Mobile Safari/537.36");
                pairArr3[1] = TuplesKt.to("Accept", "*/*");
                obj3 = "Origin";
                pairArr3[2] = TuplesKt.to(obj3, baseUrl);
                str29 = str13;
                str14 = str3;
                obj4 = obj11;
                pairArr3[3] = TuplesKt.to(obj4, baseUrl + str14 + code);
                pairArr3[4] = TuplesKt.to("sec-fetch-site", "same-origin");
                pairArr3[c] = TuplesKt.to("sec-fetch-mode", "cors");
                pairArr3[6] = TuplesKt.to("sec-fetch-dest", "empty");
                baseHeaders = MapsKt.mapOf(pairArr3);
                isolatedApp = new Requests(MainActivityKt.getApp().getBaseClient().newBuilder().cookieJar(CookieJar.NO_COOKIES).build(), (Map) null, (String) null, (Map) null, (Map) null, 0, (TimeUnit) null, 0L, (ResponseParser) null, 510, (DefaultConstructorMarker) null);
                c00023.L$0 = url4;
                c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse2);
                c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect);
                c00023.L$3 = baseUrl;
                c00023.L$4 = code;
                c00023.L$5 = fingerprint;
                c00023.L$6 = baseHeaders;
                c00023.L$7 = isolatedApp;
                c00023.label = 6;
                objBypassXD$postSession = bypassXD$postSession(code, baseUrl, fingerprint, isolatedApp, baseHeaders, c00023);
                if (objBypassXD$postSession == obj) {
                    return obj;
                }
                retryCode = code;
                $result2 = objBypassXD$postSession;
                retryBaseUrl = baseUrl;
                baseHeaders2 = baseHeaders;
                retryCode2 = fingerprint;
                isolatedApp2 = isolatedApp;
                redirect2 = redirect;
                initialResponse5 = initialResponse2;
                sessionJson = (JSONObject) $result2;
                if (sessionJson == null) {
                    String str39 = str8;
                    Log.INSTANCE.d(str39, "Retrying bypassXD from scratch after session POST failure");
                    Requests app12 = MainActivityKt.getApp();
                    XDMoviesCFBypassInterceptor xDMoviesCFBypassInterceptor9 = XDMoviesCFBypassInterceptor.INSTANCE;
                    c00023.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                    c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                    c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                    c00023.L$3 = retryBaseUrl;
                    c00023.L$4 = retryCode;
                    c00023.L$5 = retryCode2;
                    c00023.L$6 = baseHeaders2;
                    c00023.L$7 = isolatedApp2;
                    c00023.label = 7;
                    isolatedApp3 = isolatedApp2;
                    fingerprint2 = retryCode2;
                    code2 = retryCode;
                    C00021 c000211 = c00023;
                    baseUrl2 = retryBaseUrl;
                    obj5 = obj3;
                    baseHeaders4 = baseHeaders2;
                    url9 = url4;
                    obj6 = obj4;
                    str18 = str14;
                    str19 = str39;
                    str20 = str29;
                    str21 = str28;
                    $result2 = Requests.get$default(app12, url9, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, xDMoviesCFBypassInterceptor9, false, (ResponseParser) null, c000211, 3550, (Object) null);
                    c00023 = c000211;
                    if ($result2 == obj) {
                        return obj;
                    }
                    fingerprint3 = baseUrl2;
                    isolatedApp4 = isolatedApp3;
                    code3 = code2;
                    code4 = url9;
                    redirect3 = redirect2;
                    initialResponse6 = initialResponse5;
                    url10 = fingerprint2;
                    fingerprint4 = null;
                    retryResp = (NiceResponse) $result2;
                    str22 = str20;
                    retryRedirect = retryResp.getHeaders().get(str22);
                    if (retryRedirect == null) {
                        return null;
                    }
                    retryBaseUrl2 = getBaseUrl(retryRedirect);
                    it2 = StringsKt.substringAfterLast$default(retryRedirect, str21, (String) null, 2, (Object) null);
                    if (it2.length() > 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        it2 = null;
                    }
                    if (it2 == null) {
                        return null;
                    }
                    retryCode3 = it2;
                    $this$bypassXD_u24lambda_u246_u241 = MapsKt.toMutableMap(baseHeaders4);
                    $this$bypassXD_u24lambda_u246_u241.put(obj5, retryBaseUrl2);
                    str23 = str18;
                    $this$bypassXD_u24lambda_u246_u241.put(obj6, retryBaseUrl2 + str23 + retryCode3);
                    Result.Companion companion9 = Result.Companion;
                    String str310 = retryBaseUrl2 + "/api/session";
                    RequestBody requestBodyCreate3 = RequestBody.Companion.create("{\"code\":\"" + retryCode3 + "\",\"fingerprint\":\"" + url10 + "\"}", MediaType.Companion.get("application/json"));
                    c00023.L$0 = SpillingKt.nullOutSpilledVariable(code4);
                    c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse6);
                    c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect3);
                    c00023.L$3 = fingerprint3;
                    c00023.L$4 = code3;
                    c00023.L$5 = url10;
                    c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders4);
                    c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp4);
                    c00023.L$8 = SpillingKt.nullOutSpilledVariable(retryResp);
                    c00023.L$9 = SpillingKt.nullOutSpilledVariable(retryBaseUrl2);
                    c00023.L$10 = SpillingKt.nullOutSpilledVariable(retryRedirect);
                    c00023.L$11 = SpillingKt.nullOutSpilledVariable($this$bypassXD_u24lambda_u246_u241);
                    c00023.L$12 = SpillingKt.nullOutSpilledVariable(retryCode3);
                    c00023.label = 8;
                    code7 = code3;
                    baseUrl4 = fingerprint3;
                    c00022 = c00023;
                    fingerprint6 = url10;
                    str15 = str23;
                    str16 = str22;
                    isolatedApp6 = isolatedApp4;
                    objPost$default = Requests.post$default(isolatedApp6, str310, $this$bypassXD_u24lambda_u246_u241, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate3, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                    c00023 = c00022;
                    if (objPost$default == obj) {
                        return obj;
                    }
                    isolatedApp5 = isolatedApp6;
                    retryHeaders = $this$bypassXD_u24lambda_u246_u241;
                    str24 = fingerprint4;
                    baseHeaders5 = baseHeaders4;
                    url11 = code4;
                    code5 = code7;
                    retryBaseUrl2 = retryBaseUrl2;
                    fingerprint5 = fingerprint6;
                    code6 = retryCode3;
                    $result2 = objPost$default;
                    initialResponse7 = initialResponse6;
                    baseUrl3 = baseUrl4;
                    obj7 = Result.constructor-impl((NiceResponse) $result2);
                    isolatedApp2 = isolatedApp5;
                    baseHeaders3 = baseHeaders5;
                    initialResponse5 = initialResponse7;
                    url4 = url11;
                    retryCode2 = fingerprint5;
                    retryBaseUrl = baseUrl3;
                    if (Result.exceptionOrNull-impl(obj7) != null) {
                        return null;
                    }
                    retrySessionResp = (NiceResponse) obj7;
                    if (retrySessionResp.getCode() == 400) {
                        Log.INSTANCE.e(str19, "Retry session POST also got 400 — giving up");
                        return null;
                    }
                    str17 = str19;
                    Result.Companion companion10 = Result.Companion;
                    obj8 = Result.constructor-impl(new JSONObject(retrySessionResp.getText()));
                    if (Result.exceptionOrNull-impl(obj8) != null) {
                        return null;
                    }
                    sessionJson = (JSONObject) obj8;
                    retryCode = code5;
                    redirect2 = redirect3;
                } else {
                    str15 = str14;
                    str16 = str29;
                    str17 = str8;
                    baseHeaders3 = baseHeaders2;
                }
                sessionId = sessionJson.optString("sessionId");
                if (sessionId.length() > 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (!z3) {
                    sessionId = null;
                }
                if (sessionId == null) {
                    return null;
                }
                CoroutineContext main4 = Dispatchers.getMain();
                ExtractorKt$bypassXD$resultUrl$1 extractorKt$bypassXD$resultUrl$4 = new ExtractorKt$bypassXD$resultUrl$1(retryBaseUrl, sessionId, retryCode2, null);
                c00023.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                c00023.L$3 = retryBaseUrl;
                c00023.L$4 = retryCode;
                c00023.L$5 = SpillingKt.nullOutSpilledVariable(retryCode2);
                c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders3);
                c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp2);
                c00023.L$8 = SpillingKt.nullOutSpilledVariable(sessionJson);
                c00023.L$9 = sessionId;
                c00023.L$10 = null;
                c00023.L$11 = null;
                c00023.L$12 = null;
                c00023.label = 9;
                objWithContext = BuildersKt.withContext(main4, extractorKt$bypassXD$resultUrl$4, c00023);
                if (objWithContext == obj) {
                    return obj;
                }
                sessionJson2 = sessionJson;
                baseHeaders6 = baseHeaders3;
                isolatedApp7 = isolatedApp2;
                fingerprint7 = retryCode2;
                code8 = retryCode;
                $result2 = objWithContext;
                baseUrl5 = retryBaseUrl;
                sessionId2 = sessionId;
                sessionId3 = url4;
                resultUrl = (String) $result2;
                if (resultUrl == null) {
                    return null;
                }
                Log.INSTANCE.d(str17, "Intercepted URL: " + resultUrl);
                if (StringsKt.startsWith$default(resultUrl, "COMPLETE:", false, 2, (Object) null)) {
                    String completeToken4 = StringsKt.substringAfter$default(resultUrl, "COMPLETE:", (String) null, 2, (Object) null);
                    String finalResultUrl9 = baseUrl5 + str + sessionId2 + "?t=" + completeToken4;
                    finalResultUrl2 = sessionId3;
                    resultUrl2 = resultUrl;
                    baseUrl6 = baseUrl5;
                    step2Url = sessionId2;
                    code9 = code8;
                    finalResultUrl = finalResultUrl9;
                    baseUrl7 = str16;
                } else {
                    str25 = str;
                    if (Intrinsics.areEqual(resultUrl, "COMPLETE")) {
                        step2Url2 = baseUrl5 + str15 + code8 + "?step=2&sid=" + sessionId2;
                        Requests app13 = MainActivityKt.getApp();
                        c00023.L$0 = SpillingKt.nullOutSpilledVariable(sessionId3);
                        c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                        c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                        c00023.L$3 = SpillingKt.nullOutSpilledVariable(baseUrl5);
                        c00023.L$4 = SpillingKt.nullOutSpilledVariable(code8);
                        c00023.L$5 = SpillingKt.nullOutSpilledVariable(fingerprint7);
                        c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders6);
                        c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp7);
                        c00023.L$8 = SpillingKt.nullOutSpilledVariable(sessionJson2);
                        c00023.L$9 = sessionId2;
                        c00023.L$10 = SpillingKt.nullOutSpilledVariable(resultUrl);
                        c00023.L$11 = SpillingKt.nullOutSpilledVariable(resultUrl);
                        c00023.L$12 = step2Url2;
                        c00023.label = 10;
                        sessionId4 = sessionId2;
                        code10 = code8;
                        C00021 c000212 = c00023;
                        baseUrl8 = baseUrl5;
                        str = str25;
                        obj9 = Requests.get$default(app13, step2Url2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000212, 4062, (Object) null);
                        c00023 = c000212;
                        if (obj9 == obj) {
                            return obj;
                        }
                        $result = sessionId3;
                        url12 = step2Url2;
                        obj10 = obj9;
                        sessionJson3 = sessionJson2;
                        redirect4 = redirect2;
                        initialResponse8 = initialResponse5;
                        isolatedApp8 = isolatedApp7;
                        baseHeaders7 = baseHeaders6;
                        fingerprint8 = fingerprint7;
                        baseUrl9 = baseUrl8;
                        resultUrl3 = resultUrl;
                        sessionId5 = sessionId4;
                        code11 = code10;
                        NiceResponse step2Resp4 = (NiceResponse) obj10;
                        String baseUrl13 = baseUrl9;
                        baseUrl7 = str16;
                        str27 = step2Resp4.getHeaders().get(baseUrl7);
                        if (str27 == null) {
                            str27 = url12;
                        }
                        String finalResultUrl10 = str27;
                        baseUrl6 = baseUrl13;
                        finalResultUrl2 = $result;
                        redirect2 = redirect4;
                        finalResultUrl = finalResultUrl10;
                        resultUrl2 = resultUrl3;
                        step2Url = sessionId5;
                        sessionJson2 = sessionJson3;
                        isolatedApp7 = isolatedApp8;
                        baseHeaders6 = baseHeaders7;
                        fingerprint7 = fingerprint8;
                        code9 = code11;
                        initialResponse5 = initialResponse8;
                    } else {
                        resultUrl2 = resultUrl;
                        baseUrl6 = baseUrl5;
                        code9 = code8;
                        str = str25;
                        baseUrl7 = str16;
                        finalResultUrl = resultUrl;
                        finalResultUrl2 = sessionId3;
                        step2Url = sessionId2;
                    }
                }
                if (!StringsKt.contains(finalResultUrl, str, true)) {
                    return finalResultUrl;
                }
                Requests app14 = MainActivityKt.getApp();
                Map mapMapOf4 = MapsKt.mapOf(TuplesKt.to("Cookie", "sid=" + step2Url));
                XDMoviesCFBypassInterceptor xDMoviesCFBypassInterceptor10 = XDMoviesCFBypassInterceptor.INSTANCE;
                c00023.L$0 = SpillingKt.nullOutSpilledVariable(finalResultUrl2);
                c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                c00023.L$3 = SpillingKt.nullOutSpilledVariable(baseUrl6);
                c00023.L$4 = SpillingKt.nullOutSpilledVariable(code9);
                c00023.L$5 = SpillingKt.nullOutSpilledVariable(fingerprint7);
                c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders6);
                c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp7);
                c00023.L$8 = SpillingKt.nullOutSpilledVariable(sessionJson2);
                c00023.L$9 = SpillingKt.nullOutSpilledVariable(step2Url);
                c00023.L$10 = SpillingKt.nullOutSpilledVariable(resultUrl2);
                c00023.L$11 = SpillingKt.nullOutSpilledVariable(finalResultUrl);
                c00023.L$12 = null;
                c00023.label = 11;
                str26 = baseUrl7;
                $result2 = Requests.get$default(app14, finalResultUrl, mapMapOf4, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, xDMoviesCFBypassInterceptor10, false, (ResponseParser) null, c00023, 3548, (Object) null);
                if ($result2 == obj) {
                    return obj;
                }
                return ((NiceResponse) $result2).getHeaders().get(str26);
            case 1:
                String url13 = (String) c00023.L$0;
                ResultKt.throwOnFailure($result2);
                obj = coroutine_suspended;
                str = "/go/";
                str2 = "/";
                str3 = "/r/";
                str4 = "XDMovies";
                str5 = str29;
                str6 = null;
                url2 = url13;
                obj2 = $result2;
                i = 3;
                initialResponse = (NiceResponse) obj2;
                url3 = str5;
                if (initialResponse.getHeaders().get(url3) == null) {
                    isCfBlocked = new Function1() { // from class: com.phisher98.ExtractorKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj13) {
                            return Boolean.valueOf(ExtractorKt.bypassXD$lambda$0((NiceResponse) obj13));
                        }
                    };
                    if (initialResponse.getCode() == 400) {
                        str11 = str4;
                        Log.INSTANCE.d(str11, "Got 400 on initial GET — clearing stale cookies and retrying CF bypass for " + url2);
                        XDMoviesProvider.INSTANCE.setCfCookies("");
                        XDMoviesProvider.INSTANCE.setCfUserAgent("");
                        c00023.L$0 = url2;
                        c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse);
                        c00023.L$2 = SpillingKt.nullOutSpilledVariable(isCfBlocked);
                        c00023.label = 2;
                        if (XDMoviesKt.showXDMoviesCFBypassDialogAndWait(url2, c00023) == obj) {
                            return obj;
                        }
                        initialResponse4 = initialResponse;
                        isCfBlocked3 = isCfBlocked;
                        url6 = url2;
                        Requests app15 = MainActivityKt.getApp();
                        XDMoviesCFBypassInterceptor xDMoviesCFBypassInterceptor11 = XDMoviesCFBypassInterceptor.INSTANCE;
                        c00023.L$0 = url6;
                        c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse4);
                        c00023.L$2 = SpillingKt.nullOutSpilledVariable(isCfBlocked3);
                        c00023.label = i;
                        C00021 c000213 = c00023;
                        str12 = str11;
                        str7 = url3;
                        $result2 = Requests.get$default(app15, url6, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, xDMoviesCFBypassInterceptor11, false, (ResponseParser) null, c000213, 3550, (Object) null);
                        c00023 = c000213;
                        if ($result2 == obj) {
                            return obj;
                        }
                        url7 = url6;
                        initialResponse2 = (NiceResponse) $result2;
                        url4 = url7;
                        str8 = str12;
                        c = 5;
                        str13 = str7;
                        redirect = initialResponse2.getHeaders().get(str13);
                        if (redirect == null) {
                            return str6;
                        }
                        baseUrl = getBaseUrl(redirect);
                        String str311 = str6;
                        str28 = str2;
                        it = StringsKt.substringAfterLast$default(redirect, str28, str311, 2, str311);
                        if (it.length() > 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            code = it;
                        } else {
                            code = null;
                        }
                        if (code == null) {
                            return null;
                        }
                        fingerprint = generateBrowserFingerprint();
                        Pair[] pairArr4 = new Pair[7];
                        pairArr4[0] = TuplesKt.to("User-Agent", "Mozilla/5.0 (Linux; Android 10) AppleWebKit/537.36 Chrome/124 Mobile Safari/537.36");
                        pairArr4[1] = TuplesKt.to("Accept", "*/*");
                        obj3 = "Origin";
                        pairArr4[2] = TuplesKt.to(obj3, baseUrl);
                        str29 = str13;
                        str14 = str3;
                        obj4 = obj11;
                        pairArr4[3] = TuplesKt.to(obj4, baseUrl + str14 + code);
                        pairArr4[4] = TuplesKt.to("sec-fetch-site", "same-origin");
                        pairArr4[c] = TuplesKt.to("sec-fetch-mode", "cors");
                        pairArr4[6] = TuplesKt.to("sec-fetch-dest", "empty");
                        baseHeaders = MapsKt.mapOf(pairArr4);
                        isolatedApp = new Requests(MainActivityKt.getApp().getBaseClient().newBuilder().cookieJar(CookieJar.NO_COOKIES).build(), (Map) null, (String) null, (Map) null, (Map) null, 0, (TimeUnit) null, 0L, (ResponseParser) null, 510, (DefaultConstructorMarker) null);
                        c00023.L$0 = url4;
                        c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse2);
                        c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect);
                        c00023.L$3 = baseUrl;
                        c00023.L$4 = code;
                        c00023.L$5 = fingerprint;
                        c00023.L$6 = baseHeaders;
                        c00023.L$7 = isolatedApp;
                        c00023.label = 6;
                        objBypassXD$postSession = bypassXD$postSession(code, baseUrl, fingerprint, isolatedApp, baseHeaders, c00023);
                        if (objBypassXD$postSession == obj) {
                            return obj;
                        }
                        retryCode = code;
                        $result2 = objBypassXD$postSession;
                        retryBaseUrl = baseUrl;
                        baseHeaders2 = baseHeaders;
                        retryCode2 = fingerprint;
                        isolatedApp2 = isolatedApp;
                        redirect2 = redirect;
                        initialResponse5 = initialResponse2;
                        sessionJson = (JSONObject) $result2;
                        if (sessionJson == null) {
                            String str312 = str8;
                            Log.INSTANCE.d(str312, "Retrying bypassXD from scratch after session POST failure");
                            Requests app16 = MainActivityKt.getApp();
                            XDMoviesCFBypassInterceptor xDMoviesCFBypassInterceptor12 = XDMoviesCFBypassInterceptor.INSTANCE;
                            c00023.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                            c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                            c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                            c00023.L$3 = retryBaseUrl;
                            c00023.L$4 = retryCode;
                            c00023.L$5 = retryCode2;
                            c00023.L$6 = baseHeaders2;
                            c00023.L$7 = isolatedApp2;
                            c00023.label = 7;
                            isolatedApp3 = isolatedApp2;
                            fingerprint2 = retryCode2;
                            code2 = retryCode;
                            C00021 c000214 = c00023;
                            baseUrl2 = retryBaseUrl;
                            obj5 = obj3;
                            baseHeaders4 = baseHeaders2;
                            url9 = url4;
                            obj6 = obj4;
                            str18 = str14;
                            str19 = str312;
                            str20 = str29;
                            str21 = str28;
                            $result2 = Requests.get$default(app16, url9, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, xDMoviesCFBypassInterceptor12, false, (ResponseParser) null, c000214, 3550, (Object) null);
                            c00023 = c000214;
                            if ($result2 == obj) {
                                return obj;
                            }
                            fingerprint3 = baseUrl2;
                            isolatedApp4 = isolatedApp3;
                            code3 = code2;
                            code4 = url9;
                            redirect3 = redirect2;
                            initialResponse6 = initialResponse5;
                            url10 = fingerprint2;
                            fingerprint4 = null;
                            retryResp = (NiceResponse) $result2;
                            str22 = str20;
                            retryRedirect = retryResp.getHeaders().get(str22);
                            if (retryRedirect == null) {
                                return null;
                            }
                            retryBaseUrl2 = getBaseUrl(retryRedirect);
                            it2 = StringsKt.substringAfterLast$default(retryRedirect, str21, (String) null, 2, (Object) null);
                            if (it2.length() > 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (!z2) {
                                it2 = null;
                            }
                            if (it2 == null) {
                                return null;
                            }
                            retryCode3 = it2;
                            $this$bypassXD_u24lambda_u246_u241 = MapsKt.toMutableMap(baseHeaders4);
                            $this$bypassXD_u24lambda_u246_u241.put(obj5, retryBaseUrl2);
                            str23 = str18;
                            $this$bypassXD_u24lambda_u246_u241.put(obj6, retryBaseUrl2 + str23 + retryCode3);
                            Result.Companion companion11 = Result.Companion;
                            String str313 = retryBaseUrl2 + "/api/session";
                            RequestBody requestBodyCreate4 = RequestBody.Companion.create("{\"code\":\"" + retryCode3 + "\",\"fingerprint\":\"" + url10 + "\"}", MediaType.Companion.get("application/json"));
                            c00023.L$0 = SpillingKt.nullOutSpilledVariable(code4);
                            c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse6);
                            c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect3);
                            c00023.L$3 = fingerprint3;
                            c00023.L$4 = code3;
                            c00023.L$5 = url10;
                            c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders4);
                            c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp4);
                            c00023.L$8 = SpillingKt.nullOutSpilledVariable(retryResp);
                            c00023.L$9 = SpillingKt.nullOutSpilledVariable(retryBaseUrl2);
                            c00023.L$10 = SpillingKt.nullOutSpilledVariable(retryRedirect);
                            c00023.L$11 = SpillingKt.nullOutSpilledVariable($this$bypassXD_u24lambda_u246_u241);
                            c00023.L$12 = SpillingKt.nullOutSpilledVariable(retryCode3);
                            c00023.label = 8;
                            code7 = code3;
                            baseUrl4 = fingerprint3;
                            c00022 = c00023;
                            fingerprint6 = url10;
                            str15 = str23;
                            str16 = str22;
                            isolatedApp6 = isolatedApp4;
                            objPost$default = Requests.post$default(isolatedApp6, str313, $this$bypassXD_u24lambda_u246_u241, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate4, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                            c00023 = c00022;
                            if (objPost$default == obj) {
                                return obj;
                            }
                            isolatedApp5 = isolatedApp6;
                            retryHeaders = $this$bypassXD_u24lambda_u246_u241;
                            str24 = fingerprint4;
                            baseHeaders5 = baseHeaders4;
                            url11 = code4;
                            code5 = code7;
                            retryBaseUrl2 = retryBaseUrl2;
                            fingerprint5 = fingerprint6;
                            code6 = retryCode3;
                            $result2 = objPost$default;
                            initialResponse7 = initialResponse6;
                            baseUrl3 = baseUrl4;
                            obj7 = Result.constructor-impl((NiceResponse) $result2);
                            isolatedApp2 = isolatedApp5;
                            baseHeaders3 = baseHeaders5;
                            initialResponse5 = initialResponse7;
                            url4 = url11;
                            retryCode2 = fingerprint5;
                            retryBaseUrl = baseUrl3;
                            if (Result.exceptionOrNull-impl(obj7) != null) {
                                return null;
                            }
                            retrySessionResp = (NiceResponse) obj7;
                            if (retrySessionResp.getCode() == 400) {
                                Log.INSTANCE.e(str19, "Retry session POST also got 400 — giving up");
                                return null;
                            }
                            str17 = str19;
                            Result.Companion companion12 = Result.Companion;
                            obj8 = Result.constructor-impl(new JSONObject(retrySessionResp.getText()));
                            if (Result.exceptionOrNull-impl(obj8) != null) {
                                return null;
                            }
                            sessionJson = (JSONObject) obj8;
                            retryCode = code5;
                            redirect2 = redirect3;
                        } else {
                            str15 = str14;
                            str16 = str29;
                            str17 = str8;
                            baseHeaders3 = baseHeaders2;
                        }
                        sessionId = sessionJson.optString("sessionId");
                        if (sessionId.length() > 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (!z3) {
                            sessionId = null;
                        }
                        if (sessionId == null) {
                            return null;
                        }
                        CoroutineContext main5 = Dispatchers.getMain();
                        ExtractorKt$bypassXD$resultUrl$1 extractorKt$bypassXD$resultUrl$5 = new ExtractorKt$bypassXD$resultUrl$1(retryBaseUrl, sessionId, retryCode2, null);
                        c00023.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                        c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                        c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                        c00023.L$3 = retryBaseUrl;
                        c00023.L$4 = retryCode;
                        c00023.L$5 = SpillingKt.nullOutSpilledVariable(retryCode2);
                        c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders3);
                        c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp2);
                        c00023.L$8 = SpillingKt.nullOutSpilledVariable(sessionJson);
                        c00023.L$9 = sessionId;
                        c00023.L$10 = null;
                        c00023.L$11 = null;
                        c00023.L$12 = null;
                        c00023.label = 9;
                        objWithContext = BuildersKt.withContext(main5, extractorKt$bypassXD$resultUrl$5, c00023);
                        if (objWithContext == obj) {
                            return obj;
                        }
                        sessionJson2 = sessionJson;
                        baseHeaders6 = baseHeaders3;
                        isolatedApp7 = isolatedApp2;
                        fingerprint7 = retryCode2;
                        code8 = retryCode;
                        $result2 = objWithContext;
                        baseUrl5 = retryBaseUrl;
                        sessionId2 = sessionId;
                        sessionId3 = url4;
                        resultUrl = (String) $result2;
                        if (resultUrl == null) {
                            return null;
                        }
                        Log.INSTANCE.d(str17, "Intercepted URL: " + resultUrl);
                        if (StringsKt.startsWith$default(resultUrl, "COMPLETE:", false, 2, (Object) null)) {
                            String completeToken5 = StringsKt.substringAfter$default(resultUrl, "COMPLETE:", (String) null, 2, (Object) null);
                            String finalResultUrl11 = baseUrl5 + str + sessionId2 + "?t=" + completeToken5;
                            finalResultUrl2 = sessionId3;
                            resultUrl2 = resultUrl;
                            baseUrl6 = baseUrl5;
                            step2Url = sessionId2;
                            code9 = code8;
                            finalResultUrl = finalResultUrl11;
                            baseUrl7 = str16;
                        } else {
                            str25 = str;
                            if (Intrinsics.areEqual(resultUrl, "COMPLETE")) {
                                step2Url2 = baseUrl5 + str15 + code8 + "?step=2&sid=" + sessionId2;
                                Requests app17 = MainActivityKt.getApp();
                                c00023.L$0 = SpillingKt.nullOutSpilledVariable(sessionId3);
                                c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                                c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                                c00023.L$3 = SpillingKt.nullOutSpilledVariable(baseUrl5);
                                c00023.L$4 = SpillingKt.nullOutSpilledVariable(code8);
                                c00023.L$5 = SpillingKt.nullOutSpilledVariable(fingerprint7);
                                c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders6);
                                c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp7);
                                c00023.L$8 = SpillingKt.nullOutSpilledVariable(sessionJson2);
                                c00023.L$9 = sessionId2;
                                c00023.L$10 = SpillingKt.nullOutSpilledVariable(resultUrl);
                                c00023.L$11 = SpillingKt.nullOutSpilledVariable(resultUrl);
                                c00023.L$12 = step2Url2;
                                c00023.label = 10;
                                sessionId4 = sessionId2;
                                code10 = code8;
                                C00021 c000215 = c00023;
                                baseUrl8 = baseUrl5;
                                str = str25;
                                obj9 = Requests.get$default(app17, step2Url2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000215, 4062, (Object) null);
                                c00023 = c000215;
                                if (obj9 == obj) {
                                    return obj;
                                }
                                $result = sessionId3;
                                url12 = step2Url2;
                                obj10 = obj9;
                                sessionJson3 = sessionJson2;
                                redirect4 = redirect2;
                                initialResponse8 = initialResponse5;
                                isolatedApp8 = isolatedApp7;
                                baseHeaders7 = baseHeaders6;
                                fingerprint8 = fingerprint7;
                                baseUrl9 = baseUrl8;
                                resultUrl3 = resultUrl;
                                sessionId5 = sessionId4;
                                code11 = code10;
                                NiceResponse step2Resp5 = (NiceResponse) obj10;
                                String baseUrl14 = baseUrl9;
                                baseUrl7 = str16;
                                str27 = step2Resp5.getHeaders().get(baseUrl7);
                                if (str27 == null) {
                                    str27 = url12;
                                }
                                String finalResultUrl12 = str27;
                                baseUrl6 = baseUrl14;
                                finalResultUrl2 = $result;
                                redirect2 = redirect4;
                                finalResultUrl = finalResultUrl12;
                                resultUrl2 = resultUrl3;
                                step2Url = sessionId5;
                                sessionJson2 = sessionJson3;
                                isolatedApp7 = isolatedApp8;
                                baseHeaders6 = baseHeaders7;
                                fingerprint7 = fingerprint8;
                                code9 = code11;
                                initialResponse5 = initialResponse8;
                            } else {
                                resultUrl2 = resultUrl;
                                baseUrl6 = baseUrl5;
                                code9 = code8;
                                str = str25;
                                baseUrl7 = str16;
                                finalResultUrl = resultUrl;
                                finalResultUrl2 = sessionId3;
                                step2Url = sessionId2;
                            }
                        }
                        if (!StringsKt.contains(finalResultUrl, str, true)) {
                            return finalResultUrl;
                        }
                        Requests app18 = MainActivityKt.getApp();
                        Map mapMapOf5 = MapsKt.mapOf(TuplesKt.to("Cookie", "sid=" + step2Url));
                        XDMoviesCFBypassInterceptor xDMoviesCFBypassInterceptor13 = XDMoviesCFBypassInterceptor.INSTANCE;
                        c00023.L$0 = SpillingKt.nullOutSpilledVariable(finalResultUrl2);
                        c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                        c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                        c00023.L$3 = SpillingKt.nullOutSpilledVariable(baseUrl6);
                        c00023.L$4 = SpillingKt.nullOutSpilledVariable(code9);
                        c00023.L$5 = SpillingKt.nullOutSpilledVariable(fingerprint7);
                        c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders6);
                        c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp7);
                        c00023.L$8 = SpillingKt.nullOutSpilledVariable(sessionJson2);
                        c00023.L$9 = SpillingKt.nullOutSpilledVariable(step2Url);
                        c00023.L$10 = SpillingKt.nullOutSpilledVariable(resultUrl2);
                        c00023.L$11 = SpillingKt.nullOutSpilledVariable(finalResultUrl);
                        c00023.L$12 = null;
                        c00023.label = 11;
                        str26 = baseUrl7;
                        $result2 = Requests.get$default(app18, finalResultUrl, mapMapOf5, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, xDMoviesCFBypassInterceptor13, false, (ResponseParser) null, c00023, 3548, (Object) null);
                        if ($result2 == obj) {
                            return obj;
                        }
                        return ((NiceResponse) $result2).getHeaders().get(str26);
                    }
                    str7 = url3;
                    str9 = str4;
                    if (((Boolean) isCfBlocked.invoke(initialResponse)).booleanValue()) {
                        str10 = str9;
                        Log.INSTANCE.d(str10, "CF challenge on link domain – launching WebView bypass for " + url2);
                        c00023.L$0 = url2;
                        c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse);
                        c00023.L$2 = SpillingKt.nullOutSpilledVariable(isCfBlocked);
                        c00023.label = 4;
                        if (XDMoviesKt.showXDMoviesCFBypassDialogAndWait(url2, c00023) == obj) {
                            return obj;
                        }
                        initialResponse3 = initialResponse;
                        isCfBlocked2 = isCfBlocked;
                        url5 = url2;
                        Requests app19 = MainActivityKt.getApp();
                        XDMoviesCFBypassInterceptor xDMoviesCFBypassInterceptor14 = XDMoviesCFBypassInterceptor.INSTANCE;
                        c00023.L$0 = url5;
                        c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse3);
                        c00023.L$2 = SpillingKt.nullOutSpilledVariable(isCfBlocked2);
                        c00023.label = 5;
                        c = 5;
                        C00021 c000216 = c00023;
                        str8 = str10;
                        $result2 = Requests.get$default(app19, url5, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, xDMoviesCFBypassInterceptor14, false, (ResponseParser) null, c000216, 3550, (Object) null);
                        c00023 = c000216;
                        if ($result2 == obj) {
                            return obj;
                        }
                        url8 = url5;
                        initialResponse2 = (NiceResponse) $result2;
                        url4 = url8;
                        str13 = str7;
                        redirect = initialResponse2.getHeaders().get(str13);
                        if (redirect == null) {
                            return str6;
                        }
                        baseUrl = getBaseUrl(redirect);
                        String str314 = str6;
                        str28 = str2;
                        it = StringsKt.substringAfterLast$default(redirect, str28, str314, 2, str314);
                        if (it.length() > 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            code = it;
                        } else {
                            code = null;
                        }
                        if (code == null) {
                            return null;
                        }
                        fingerprint = generateBrowserFingerprint();
                        Pair[] pairArr5 = new Pair[7];
                        pairArr5[0] = TuplesKt.to("User-Agent", "Mozilla/5.0 (Linux; Android 10) AppleWebKit/537.36 Chrome/124 Mobile Safari/537.36");
                        pairArr5[1] = TuplesKt.to("Accept", "*/*");
                        obj3 = "Origin";
                        pairArr5[2] = TuplesKt.to(obj3, baseUrl);
                        str29 = str13;
                        str14 = str3;
                        obj4 = obj11;
                        pairArr5[3] = TuplesKt.to(obj4, baseUrl + str14 + code);
                        pairArr5[4] = TuplesKt.to("sec-fetch-site", "same-origin");
                        pairArr5[c] = TuplesKt.to("sec-fetch-mode", "cors");
                        pairArr5[6] = TuplesKt.to("sec-fetch-dest", "empty");
                        baseHeaders = MapsKt.mapOf(pairArr5);
                        isolatedApp = new Requests(MainActivityKt.getApp().getBaseClient().newBuilder().cookieJar(CookieJar.NO_COOKIES).build(), (Map) null, (String) null, (Map) null, (Map) null, 0, (TimeUnit) null, 0L, (ResponseParser) null, 510, (DefaultConstructorMarker) null);
                        c00023.L$0 = url4;
                        c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse2);
                        c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect);
                        c00023.L$3 = baseUrl;
                        c00023.L$4 = code;
                        c00023.L$5 = fingerprint;
                        c00023.L$6 = baseHeaders;
                        c00023.L$7 = isolatedApp;
                        c00023.label = 6;
                        objBypassXD$postSession = bypassXD$postSession(code, baseUrl, fingerprint, isolatedApp, baseHeaders, c00023);
                        if (objBypassXD$postSession == obj) {
                            return obj;
                        }
                        retryCode = code;
                        $result2 = objBypassXD$postSession;
                        retryBaseUrl = baseUrl;
                        baseHeaders2 = baseHeaders;
                        retryCode2 = fingerprint;
                        isolatedApp2 = isolatedApp;
                        redirect2 = redirect;
                        initialResponse5 = initialResponse2;
                        sessionJson = (JSONObject) $result2;
                        if (sessionJson == null) {
                            String str315 = str8;
                            Log.INSTANCE.d(str315, "Retrying bypassXD from scratch after session POST failure");
                            Requests app110 = MainActivityKt.getApp();
                            XDMoviesCFBypassInterceptor xDMoviesCFBypassInterceptor15 = XDMoviesCFBypassInterceptor.INSTANCE;
                            c00023.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                            c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                            c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                            c00023.L$3 = retryBaseUrl;
                            c00023.L$4 = retryCode;
                            c00023.L$5 = retryCode2;
                            c00023.L$6 = baseHeaders2;
                            c00023.L$7 = isolatedApp2;
                            c00023.label = 7;
                            isolatedApp3 = isolatedApp2;
                            fingerprint2 = retryCode2;
                            code2 = retryCode;
                            C00021 c000217 = c00023;
                            baseUrl2 = retryBaseUrl;
                            obj5 = obj3;
                            baseHeaders4 = baseHeaders2;
                            url9 = url4;
                            obj6 = obj4;
                            str18 = str14;
                            str19 = str315;
                            str20 = str29;
                            str21 = str28;
                            $result2 = Requests.get$default(app110, url9, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, xDMoviesCFBypassInterceptor15, false, (ResponseParser) null, c000217, 3550, (Object) null);
                            c00023 = c000217;
                            if ($result2 == obj) {
                                return obj;
                            }
                            fingerprint3 = baseUrl2;
                            isolatedApp4 = isolatedApp3;
                            code3 = code2;
                            code4 = url9;
                            redirect3 = redirect2;
                            initialResponse6 = initialResponse5;
                            url10 = fingerprint2;
                            fingerprint4 = null;
                            retryResp = (NiceResponse) $result2;
                            str22 = str20;
                            retryRedirect = retryResp.getHeaders().get(str22);
                            if (retryRedirect == null) {
                                return null;
                            }
                            retryBaseUrl2 = getBaseUrl(retryRedirect);
                            it2 = StringsKt.substringAfterLast$default(retryRedirect, str21, (String) null, 2, (Object) null);
                            if (it2.length() > 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (!z2) {
                                it2 = null;
                            }
                            if (it2 == null) {
                                return null;
                            }
                            retryCode3 = it2;
                            $this$bypassXD_u24lambda_u246_u241 = MapsKt.toMutableMap(baseHeaders4);
                            $this$bypassXD_u24lambda_u246_u241.put(obj5, retryBaseUrl2);
                            str23 = str18;
                            $this$bypassXD_u24lambda_u246_u241.put(obj6, retryBaseUrl2 + str23 + retryCode3);
                            Result.Companion companion13 = Result.Companion;
                            String str316 = retryBaseUrl2 + "/api/session";
                            RequestBody requestBodyCreate5 = RequestBody.Companion.create("{\"code\":\"" + retryCode3 + "\",\"fingerprint\":\"" + url10 + "\"}", MediaType.Companion.get("application/json"));
                            c00023.L$0 = SpillingKt.nullOutSpilledVariable(code4);
                            c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse6);
                            c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect3);
                            c00023.L$3 = fingerprint3;
                            c00023.L$4 = code3;
                            c00023.L$5 = url10;
                            c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders4);
                            c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp4);
                            c00023.L$8 = SpillingKt.nullOutSpilledVariable(retryResp);
                            c00023.L$9 = SpillingKt.nullOutSpilledVariable(retryBaseUrl2);
                            c00023.L$10 = SpillingKt.nullOutSpilledVariable(retryRedirect);
                            c00023.L$11 = SpillingKt.nullOutSpilledVariable($this$bypassXD_u24lambda_u246_u241);
                            c00023.L$12 = SpillingKt.nullOutSpilledVariable(retryCode3);
                            c00023.label = 8;
                            code7 = code3;
                            baseUrl4 = fingerprint3;
                            c00022 = c00023;
                            fingerprint6 = url10;
                            str15 = str23;
                            str16 = str22;
                            isolatedApp6 = isolatedApp4;
                            objPost$default = Requests.post$default(isolatedApp6, str316, $this$bypassXD_u24lambda_u246_u241, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate5, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                            c00023 = c00022;
                            if (objPost$default == obj) {
                                return obj;
                            }
                            isolatedApp5 = isolatedApp6;
                            retryHeaders = $this$bypassXD_u24lambda_u246_u241;
                            str24 = fingerprint4;
                            baseHeaders5 = baseHeaders4;
                            url11 = code4;
                            code5 = code7;
                            retryBaseUrl2 = retryBaseUrl2;
                            fingerprint5 = fingerprint6;
                            code6 = retryCode3;
                            $result2 = objPost$default;
                            initialResponse7 = initialResponse6;
                            baseUrl3 = baseUrl4;
                            obj7 = Result.constructor-impl((NiceResponse) $result2);
                            isolatedApp2 = isolatedApp5;
                            baseHeaders3 = baseHeaders5;
                            initialResponse5 = initialResponse7;
                            url4 = url11;
                            retryCode2 = fingerprint5;
                            retryBaseUrl = baseUrl3;
                            if (Result.exceptionOrNull-impl(obj7) != null) {
                                return null;
                            }
                            retrySessionResp = (NiceResponse) obj7;
                            if (retrySessionResp.getCode() == 400) {
                                Log.INSTANCE.e(str19, "Retry session POST also got 400 — giving up");
                                return null;
                            }
                            str17 = str19;
                            Result.Companion companion14 = Result.Companion;
                            obj8 = Result.constructor-impl(new JSONObject(retrySessionResp.getText()));
                            if (Result.exceptionOrNull-impl(obj8) != null) {
                                return null;
                            }
                            sessionJson = (JSONObject) obj8;
                            retryCode = code5;
                            redirect2 = redirect3;
                        } else {
                            str15 = str14;
                            str16 = str29;
                            str17 = str8;
                            baseHeaders3 = baseHeaders2;
                        }
                        sessionId = sessionJson.optString("sessionId");
                        if (sessionId.length() > 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (!z3) {
                            sessionId = null;
                        }
                        if (sessionId == null) {
                            return null;
                        }
                        CoroutineContext main6 = Dispatchers.getMain();
                        ExtractorKt$bypassXD$resultUrl$1 extractorKt$bypassXD$resultUrl$6 = new ExtractorKt$bypassXD$resultUrl$1(retryBaseUrl, sessionId, retryCode2, null);
                        c00023.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                        c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                        c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                        c00023.L$3 = retryBaseUrl;
                        c00023.L$4 = retryCode;
                        c00023.L$5 = SpillingKt.nullOutSpilledVariable(retryCode2);
                        c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders3);
                        c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp2);
                        c00023.L$8 = SpillingKt.nullOutSpilledVariable(sessionJson);
                        c00023.L$9 = sessionId;
                        c00023.L$10 = null;
                        c00023.L$11 = null;
                        c00023.L$12 = null;
                        c00023.label = 9;
                        objWithContext = BuildersKt.withContext(main6, extractorKt$bypassXD$resultUrl$6, c00023);
                        if (objWithContext == obj) {
                            return obj;
                        }
                        sessionJson2 = sessionJson;
                        baseHeaders6 = baseHeaders3;
                        isolatedApp7 = isolatedApp2;
                        fingerprint7 = retryCode2;
                        code8 = retryCode;
                        $result2 = objWithContext;
                        baseUrl5 = retryBaseUrl;
                        sessionId2 = sessionId;
                        sessionId3 = url4;
                        resultUrl = (String) $result2;
                        if (resultUrl == null) {
                            return null;
                        }
                        Log.INSTANCE.d(str17, "Intercepted URL: " + resultUrl);
                        if (StringsKt.startsWith$default(resultUrl, "COMPLETE:", false, 2, (Object) null)) {
                            String completeToken6 = StringsKt.substringAfter$default(resultUrl, "COMPLETE:", (String) null, 2, (Object) null);
                            String finalResultUrl13 = baseUrl5 + str + sessionId2 + "?t=" + completeToken6;
                            finalResultUrl2 = sessionId3;
                            resultUrl2 = resultUrl;
                            baseUrl6 = baseUrl5;
                            step2Url = sessionId2;
                            code9 = code8;
                            finalResultUrl = finalResultUrl13;
                            baseUrl7 = str16;
                        } else {
                            str25 = str;
                            if (Intrinsics.areEqual(resultUrl, "COMPLETE")) {
                                step2Url2 = baseUrl5 + str15 + code8 + "?step=2&sid=" + sessionId2;
                                Requests app111 = MainActivityKt.getApp();
                                c00023.L$0 = SpillingKt.nullOutSpilledVariable(sessionId3);
                                c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                                c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                                c00023.L$3 = SpillingKt.nullOutSpilledVariable(baseUrl5);
                                c00023.L$4 = SpillingKt.nullOutSpilledVariable(code8);
                                c00023.L$5 = SpillingKt.nullOutSpilledVariable(fingerprint7);
                                c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders6);
                                c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp7);
                                c00023.L$8 = SpillingKt.nullOutSpilledVariable(sessionJson2);
                                c00023.L$9 = sessionId2;
                                c00023.L$10 = SpillingKt.nullOutSpilledVariable(resultUrl);
                                c00023.L$11 = SpillingKt.nullOutSpilledVariable(resultUrl);
                                c00023.L$12 = step2Url2;
                                c00023.label = 10;
                                sessionId4 = sessionId2;
                                code10 = code8;
                                C00021 c000218 = c00023;
                                baseUrl8 = baseUrl5;
                                str = str25;
                                obj9 = Requests.get$default(app111, step2Url2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000218, 4062, (Object) null);
                                c00023 = c000218;
                                if (obj9 == obj) {
                                    return obj;
                                }
                                $result = sessionId3;
                                url12 = step2Url2;
                                obj10 = obj9;
                                sessionJson3 = sessionJson2;
                                redirect4 = redirect2;
                                initialResponse8 = initialResponse5;
                                isolatedApp8 = isolatedApp7;
                                baseHeaders7 = baseHeaders6;
                                fingerprint8 = fingerprint7;
                                baseUrl9 = baseUrl8;
                                resultUrl3 = resultUrl;
                                sessionId5 = sessionId4;
                                code11 = code10;
                                NiceResponse step2Resp6 = (NiceResponse) obj10;
                                String baseUrl15 = baseUrl9;
                                baseUrl7 = str16;
                                str27 = step2Resp6.getHeaders().get(baseUrl7);
                                if (str27 == null) {
                                    str27 = url12;
                                }
                                String finalResultUrl14 = str27;
                                baseUrl6 = baseUrl15;
                                finalResultUrl2 = $result;
                                redirect2 = redirect4;
                                finalResultUrl = finalResultUrl14;
                                resultUrl2 = resultUrl3;
                                step2Url = sessionId5;
                                sessionJson2 = sessionJson3;
                                isolatedApp7 = isolatedApp8;
                                baseHeaders6 = baseHeaders7;
                                fingerprint7 = fingerprint8;
                                code9 = code11;
                                initialResponse5 = initialResponse8;
                            } else {
                                resultUrl2 = resultUrl;
                                baseUrl6 = baseUrl5;
                                code9 = code8;
                                str = str25;
                                baseUrl7 = str16;
                                finalResultUrl = resultUrl;
                                finalResultUrl2 = sessionId3;
                                step2Url = sessionId2;
                            }
                        }
                        if (!StringsKt.contains(finalResultUrl, str, true)) {
                            return finalResultUrl;
                        }
                        Requests app112 = MainActivityKt.getApp();
                        Map mapMapOf6 = MapsKt.mapOf(TuplesKt.to("Cookie", "sid=" + step2Url));
                        XDMoviesCFBypassInterceptor xDMoviesCFBypassInterceptor16 = XDMoviesCFBypassInterceptor.INSTANCE;
                        c00023.L$0 = SpillingKt.nullOutSpilledVariable(finalResultUrl2);
                        c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                        c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                        c00023.L$3 = SpillingKt.nullOutSpilledVariable(baseUrl6);
                        c00023.L$4 = SpillingKt.nullOutSpilledVariable(code9);
                        c00023.L$5 = SpillingKt.nullOutSpilledVariable(fingerprint7);
                        c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders6);
                        c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp7);
                        c00023.L$8 = SpillingKt.nullOutSpilledVariable(sessionJson2);
                        c00023.L$9 = SpillingKt.nullOutSpilledVariable(step2Url);
                        c00023.L$10 = SpillingKt.nullOutSpilledVariable(resultUrl2);
                        c00023.L$11 = SpillingKt.nullOutSpilledVariable(finalResultUrl);
                        c00023.L$12 = null;
                        c00023.label = 11;
                        str26 = baseUrl7;
                        $result2 = Requests.get$default(app112, finalResultUrl, mapMapOf6, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, xDMoviesCFBypassInterceptor16, false, (ResponseParser) null, c00023, 3548, (Object) null);
                        if ($result2 == obj) {
                            return obj;
                        }
                        return ((NiceResponse) $result2).getHeaders().get(str26);
                    }
                    str8 = str9;
                    c = 5;
                } else {
                    str7 = url3;
                    str8 = str4;
                    c = 5;
                }
                url4 = url2;
                initialResponse2 = initialResponse;
                str13 = str7;
                redirect = initialResponse2.getHeaders().get(str13);
                if (redirect == null) {
                    return str6;
                }
                baseUrl = getBaseUrl(redirect);
                String str317 = str6;
                str28 = str2;
                it = StringsKt.substringAfterLast$default(redirect, str28, str317, 2, str317);
                if (it.length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    code = it;
                } else {
                    code = null;
                }
                if (code == null) {
                    return null;
                }
                fingerprint = generateBrowserFingerprint();
                Pair[] pairArr6 = new Pair[7];
                pairArr6[0] = TuplesKt.to("User-Agent", "Mozilla/5.0 (Linux; Android 10) AppleWebKit/537.36 Chrome/124 Mobile Safari/537.36");
                pairArr6[1] = TuplesKt.to("Accept", "*/*");
                obj3 = "Origin";
                pairArr6[2] = TuplesKt.to(obj3, baseUrl);
                str29 = str13;
                str14 = str3;
                obj4 = obj11;
                pairArr6[3] = TuplesKt.to(obj4, baseUrl + str14 + code);
                pairArr6[4] = TuplesKt.to("sec-fetch-site", "same-origin");
                pairArr6[c] = TuplesKt.to("sec-fetch-mode", "cors");
                pairArr6[6] = TuplesKt.to("sec-fetch-dest", "empty");
                baseHeaders = MapsKt.mapOf(pairArr6);
                isolatedApp = new Requests(MainActivityKt.getApp().getBaseClient().newBuilder().cookieJar(CookieJar.NO_COOKIES).build(), (Map) null, (String) null, (Map) null, (Map) null, 0, (TimeUnit) null, 0L, (ResponseParser) null, 510, (DefaultConstructorMarker) null);
                c00023.L$0 = url4;
                c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse2);
                c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect);
                c00023.L$3 = baseUrl;
                c00023.L$4 = code;
                c00023.L$5 = fingerprint;
                c00023.L$6 = baseHeaders;
                c00023.L$7 = isolatedApp;
                c00023.label = 6;
                objBypassXD$postSession = bypassXD$postSession(code, baseUrl, fingerprint, isolatedApp, baseHeaders, c00023);
                if (objBypassXD$postSession == obj) {
                    return obj;
                }
                retryCode = code;
                $result2 = objBypassXD$postSession;
                retryBaseUrl = baseUrl;
                baseHeaders2 = baseHeaders;
                retryCode2 = fingerprint;
                isolatedApp2 = isolatedApp;
                redirect2 = redirect;
                initialResponse5 = initialResponse2;
                sessionJson = (JSONObject) $result2;
                if (sessionJson == null) {
                    String str318 = str8;
                    Log.INSTANCE.d(str318, "Retrying bypassXD from scratch after session POST failure");
                    Requests app113 = MainActivityKt.getApp();
                    XDMoviesCFBypassInterceptor xDMoviesCFBypassInterceptor17 = XDMoviesCFBypassInterceptor.INSTANCE;
                    c00023.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                    c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                    c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                    c00023.L$3 = retryBaseUrl;
                    c00023.L$4 = retryCode;
                    c00023.L$5 = retryCode2;
                    c00023.L$6 = baseHeaders2;
                    c00023.L$7 = isolatedApp2;
                    c00023.label = 7;
                    isolatedApp3 = isolatedApp2;
                    fingerprint2 = retryCode2;
                    code2 = retryCode;
                    C00021 c000219 = c00023;
                    baseUrl2 = retryBaseUrl;
                    obj5 = obj3;
                    baseHeaders4 = baseHeaders2;
                    url9 = url4;
                    obj6 = obj4;
                    str18 = str14;
                    str19 = str318;
                    str20 = str29;
                    str21 = str28;
                    $result2 = Requests.get$default(app113, url9, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, xDMoviesCFBypassInterceptor17, false, (ResponseParser) null, c000219, 3550, (Object) null);
                    c00023 = c000219;
                    if ($result2 == obj) {
                        return obj;
                    }
                    fingerprint3 = baseUrl2;
                    isolatedApp4 = isolatedApp3;
                    code3 = code2;
                    code4 = url9;
                    redirect3 = redirect2;
                    initialResponse6 = initialResponse5;
                    url10 = fingerprint2;
                    fingerprint4 = null;
                    retryResp = (NiceResponse) $result2;
                    str22 = str20;
                    retryRedirect = retryResp.getHeaders().get(str22);
                    if (retryRedirect == null) {
                        return null;
                    }
                    retryBaseUrl2 = getBaseUrl(retryRedirect);
                    it2 = StringsKt.substringAfterLast$default(retryRedirect, str21, (String) null, 2, (Object) null);
                    if (it2.length() > 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        it2 = null;
                    }
                    if (it2 == null) {
                        return null;
                    }
                    retryCode3 = it2;
                    $this$bypassXD_u24lambda_u246_u241 = MapsKt.toMutableMap(baseHeaders4);
                    $this$bypassXD_u24lambda_u246_u241.put(obj5, retryBaseUrl2);
                    str23 = str18;
                    $this$bypassXD_u24lambda_u246_u241.put(obj6, retryBaseUrl2 + str23 + retryCode3);
                    Result.Companion companion15 = Result.Companion;
                    String str319 = retryBaseUrl2 + "/api/session";
                    RequestBody requestBodyCreate6 = RequestBody.Companion.create("{\"code\":\"" + retryCode3 + "\",\"fingerprint\":\"" + url10 + "\"}", MediaType.Companion.get("application/json"));
                    c00023.L$0 = SpillingKt.nullOutSpilledVariable(code4);
                    c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse6);
                    c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect3);
                    c00023.L$3 = fingerprint3;
                    c00023.L$4 = code3;
                    c00023.L$5 = url10;
                    c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders4);
                    c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp4);
                    c00023.L$8 = SpillingKt.nullOutSpilledVariable(retryResp);
                    c00023.L$9 = SpillingKt.nullOutSpilledVariable(retryBaseUrl2);
                    c00023.L$10 = SpillingKt.nullOutSpilledVariable(retryRedirect);
                    c00023.L$11 = SpillingKt.nullOutSpilledVariable($this$bypassXD_u24lambda_u246_u241);
                    c00023.L$12 = SpillingKt.nullOutSpilledVariable(retryCode3);
                    c00023.label = 8;
                    code7 = code3;
                    baseUrl4 = fingerprint3;
                    c00022 = c00023;
                    fingerprint6 = url10;
                    str15 = str23;
                    str16 = str22;
                    isolatedApp6 = isolatedApp4;
                    objPost$default = Requests.post$default(isolatedApp6, str319, $this$bypassXD_u24lambda_u246_u241, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate6, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                    c00023 = c00022;
                    if (objPost$default == obj) {
                        return obj;
                    }
                    isolatedApp5 = isolatedApp6;
                    retryHeaders = $this$bypassXD_u24lambda_u246_u241;
                    str24 = fingerprint4;
                    baseHeaders5 = baseHeaders4;
                    url11 = code4;
                    code5 = code7;
                    retryBaseUrl2 = retryBaseUrl2;
                    fingerprint5 = fingerprint6;
                    code6 = retryCode3;
                    $result2 = objPost$default;
                    initialResponse7 = initialResponse6;
                    baseUrl3 = baseUrl4;
                    obj7 = Result.constructor-impl((NiceResponse) $result2);
                    isolatedApp2 = isolatedApp5;
                    baseHeaders3 = baseHeaders5;
                    initialResponse5 = initialResponse7;
                    url4 = url11;
                    retryCode2 = fingerprint5;
                    retryBaseUrl = baseUrl3;
                    if (Result.exceptionOrNull-impl(obj7) != null) {
                        return null;
                    }
                    retrySessionResp = (NiceResponse) obj7;
                    if (retrySessionResp.getCode() == 400) {
                        Log.INSTANCE.e(str19, "Retry session POST also got 400 — giving up");
                        return null;
                    }
                    str17 = str19;
                    Result.Companion companion16 = Result.Companion;
                    obj8 = Result.constructor-impl(new JSONObject(retrySessionResp.getText()));
                    if (Result.exceptionOrNull-impl(obj8) != null) {
                        return null;
                    }
                    sessionJson = (JSONObject) obj8;
                    retryCode = code5;
                    redirect2 = redirect3;
                } else {
                    str15 = str14;
                    str16 = str29;
                    str17 = str8;
                    baseHeaders3 = baseHeaders2;
                }
                sessionId = sessionJson.optString("sessionId");
                if (sessionId.length() > 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (!z3) {
                    sessionId = null;
                }
                if (sessionId == null) {
                    return null;
                }
                CoroutineContext main7 = Dispatchers.getMain();
                ExtractorKt$bypassXD$resultUrl$1 extractorKt$bypassXD$resultUrl$7 = new ExtractorKt$bypassXD$resultUrl$1(retryBaseUrl, sessionId, retryCode2, null);
                c00023.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                c00023.L$3 = retryBaseUrl;
                c00023.L$4 = retryCode;
                c00023.L$5 = SpillingKt.nullOutSpilledVariable(retryCode2);
                c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders3);
                c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp2);
                c00023.L$8 = SpillingKt.nullOutSpilledVariable(sessionJson);
                c00023.L$9 = sessionId;
                c00023.L$10 = null;
                c00023.L$11 = null;
                c00023.L$12 = null;
                c00023.label = 9;
                objWithContext = BuildersKt.withContext(main7, extractorKt$bypassXD$resultUrl$7, c00023);
                if (objWithContext == obj) {
                    return obj;
                }
                sessionJson2 = sessionJson;
                baseHeaders6 = baseHeaders3;
                isolatedApp7 = isolatedApp2;
                fingerprint7 = retryCode2;
                code8 = retryCode;
                $result2 = objWithContext;
                baseUrl5 = retryBaseUrl;
                sessionId2 = sessionId;
                sessionId3 = url4;
                resultUrl = (String) $result2;
                if (resultUrl == null) {
                    return null;
                }
                Log.INSTANCE.d(str17, "Intercepted URL: " + resultUrl);
                if (StringsKt.startsWith$default(resultUrl, "COMPLETE:", false, 2, (Object) null)) {
                    String completeToken7 = StringsKt.substringAfter$default(resultUrl, "COMPLETE:", (String) null, 2, (Object) null);
                    String finalResultUrl15 = baseUrl5 + str + sessionId2 + "?t=" + completeToken7;
                    finalResultUrl2 = sessionId3;
                    resultUrl2 = resultUrl;
                    baseUrl6 = baseUrl5;
                    step2Url = sessionId2;
                    code9 = code8;
                    finalResultUrl = finalResultUrl15;
                    baseUrl7 = str16;
                } else {
                    str25 = str;
                    if (Intrinsics.areEqual(resultUrl, "COMPLETE")) {
                        step2Url2 = baseUrl5 + str15 + code8 + "?step=2&sid=" + sessionId2;
                        Requests app114 = MainActivityKt.getApp();
                        c00023.L$0 = SpillingKt.nullOutSpilledVariable(sessionId3);
                        c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                        c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                        c00023.L$3 = SpillingKt.nullOutSpilledVariable(baseUrl5);
                        c00023.L$4 = SpillingKt.nullOutSpilledVariable(code8);
                        c00023.L$5 = SpillingKt.nullOutSpilledVariable(fingerprint7);
                        c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders6);
                        c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp7);
                        c00023.L$8 = SpillingKt.nullOutSpilledVariable(sessionJson2);
                        c00023.L$9 = sessionId2;
                        c00023.L$10 = SpillingKt.nullOutSpilledVariable(resultUrl);
                        c00023.L$11 = SpillingKt.nullOutSpilledVariable(resultUrl);
                        c00023.L$12 = step2Url2;
                        c00023.label = 10;
                        sessionId4 = sessionId2;
                        code10 = code8;
                        C00021 c0002110 = c00023;
                        baseUrl8 = baseUrl5;
                        str = str25;
                        obj9 = Requests.get$default(app114, step2Url2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c0002110, 4062, (Object) null);
                        c00023 = c0002110;
                        if (obj9 == obj) {
                            return obj;
                        }
                        $result = sessionId3;
                        url12 = step2Url2;
                        obj10 = obj9;
                        sessionJson3 = sessionJson2;
                        redirect4 = redirect2;
                        initialResponse8 = initialResponse5;
                        isolatedApp8 = isolatedApp7;
                        baseHeaders7 = baseHeaders6;
                        fingerprint8 = fingerprint7;
                        baseUrl9 = baseUrl8;
                        resultUrl3 = resultUrl;
                        sessionId5 = sessionId4;
                        code11 = code10;
                        NiceResponse step2Resp7 = (NiceResponse) obj10;
                        String baseUrl16 = baseUrl9;
                        baseUrl7 = str16;
                        str27 = step2Resp7.getHeaders().get(baseUrl7);
                        if (str27 == null) {
                            str27 = url12;
                        }
                        String finalResultUrl16 = str27;
                        baseUrl6 = baseUrl16;
                        finalResultUrl2 = $result;
                        redirect2 = redirect4;
                        finalResultUrl = finalResultUrl16;
                        resultUrl2 = resultUrl3;
                        step2Url = sessionId5;
                        sessionJson2 = sessionJson3;
                        isolatedApp7 = isolatedApp8;
                        baseHeaders6 = baseHeaders7;
                        fingerprint7 = fingerprint8;
                        code9 = code11;
                        initialResponse5 = initialResponse8;
                    } else {
                        resultUrl2 = resultUrl;
                        baseUrl6 = baseUrl5;
                        code9 = code8;
                        str = str25;
                        baseUrl7 = str16;
                        finalResultUrl = resultUrl;
                        finalResultUrl2 = sessionId3;
                        step2Url = sessionId2;
                    }
                }
                if (!StringsKt.contains(finalResultUrl, str, true)) {
                    return finalResultUrl;
                }
                Requests app115 = MainActivityKt.getApp();
                Map mapMapOf7 = MapsKt.mapOf(TuplesKt.to("Cookie", "sid=" + step2Url));
                XDMoviesCFBypassInterceptor xDMoviesCFBypassInterceptor18 = XDMoviesCFBypassInterceptor.INSTANCE;
                c00023.L$0 = SpillingKt.nullOutSpilledVariable(finalResultUrl2);
                c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                c00023.L$3 = SpillingKt.nullOutSpilledVariable(baseUrl6);
                c00023.L$4 = SpillingKt.nullOutSpilledVariable(code9);
                c00023.L$5 = SpillingKt.nullOutSpilledVariable(fingerprint7);
                c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders6);
                c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp7);
                c00023.L$8 = SpillingKt.nullOutSpilledVariable(sessionJson2);
                c00023.L$9 = SpillingKt.nullOutSpilledVariable(step2Url);
                c00023.L$10 = SpillingKt.nullOutSpilledVariable(resultUrl2);
                c00023.L$11 = SpillingKt.nullOutSpilledVariable(finalResultUrl);
                c00023.L$12 = null;
                c00023.label = 11;
                str26 = baseUrl7;
                $result2 = Requests.get$default(app115, finalResultUrl, mapMapOf7, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, xDMoviesCFBypassInterceptor18, false, (ResponseParser) null, c00023, 3548, (Object) null);
                if ($result2 == obj) {
                    return obj;
                }
                return ((NiceResponse) $result2).getHeaders().get(str26);
            case 2:
                Function1 isCfBlocked4 = (Function1) c00023.L$2;
                NiceResponse initialResponse9 = (NiceResponse) c00023.L$1;
                String url14 = (String) c00023.L$0;
                ResultKt.throwOnFailure($result2);
                isCfBlocked3 = isCfBlocked4;
                obj = coroutine_suspended;
                initialResponse4 = initialResponse9;
                url6 = url14;
                str = "/go/";
                str2 = "/";
                str3 = "/r/";
                obj11 = obj11;
                str11 = "XDMovies";
                url3 = str29;
                i = 3;
                str6 = null;
                Requests app116 = MainActivityKt.getApp();
                XDMoviesCFBypassInterceptor xDMoviesCFBypassInterceptor19 = XDMoviesCFBypassInterceptor.INSTANCE;
                c00023.L$0 = url6;
                c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse4);
                c00023.L$2 = SpillingKt.nullOutSpilledVariable(isCfBlocked3);
                c00023.label = i;
                C00021 c0002111 = c00023;
                str12 = str11;
                str7 = url3;
                $result2 = Requests.get$default(app116, url6, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, xDMoviesCFBypassInterceptor19, false, (ResponseParser) null, c0002111, 3550, (Object) null);
                c00023 = c0002111;
                if ($result2 == obj) {
                    return obj;
                }
                url7 = url6;
                initialResponse2 = (NiceResponse) $result2;
                url4 = url7;
                str8 = str12;
                c = 5;
                str13 = str7;
                redirect = initialResponse2.getHeaders().get(str13);
                if (redirect == null) {
                    return str6;
                }
                baseUrl = getBaseUrl(redirect);
                String str3110 = str6;
                str28 = str2;
                it = StringsKt.substringAfterLast$default(redirect, str28, str3110, 2, str3110);
                if (it.length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    code = it;
                } else {
                    code = null;
                }
                if (code == null) {
                    return null;
                }
                fingerprint = generateBrowserFingerprint();
                Pair[] pairArr7 = new Pair[7];
                pairArr7[0] = TuplesKt.to("User-Agent", "Mozilla/5.0 (Linux; Android 10) AppleWebKit/537.36 Chrome/124 Mobile Safari/537.36");
                pairArr7[1] = TuplesKt.to("Accept", "*/*");
                obj3 = "Origin";
                pairArr7[2] = TuplesKt.to(obj3, baseUrl);
                str29 = str13;
                str14 = str3;
                obj4 = obj11;
                pairArr7[3] = TuplesKt.to(obj4, baseUrl + str14 + code);
                pairArr7[4] = TuplesKt.to("sec-fetch-site", "same-origin");
                pairArr7[c] = TuplesKt.to("sec-fetch-mode", "cors");
                pairArr7[6] = TuplesKt.to("sec-fetch-dest", "empty");
                baseHeaders = MapsKt.mapOf(pairArr7);
                isolatedApp = new Requests(MainActivityKt.getApp().getBaseClient().newBuilder().cookieJar(CookieJar.NO_COOKIES).build(), (Map) null, (String) null, (Map) null, (Map) null, 0, (TimeUnit) null, 0L, (ResponseParser) null, 510, (DefaultConstructorMarker) null);
                c00023.L$0 = url4;
                c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse2);
                c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect);
                c00023.L$3 = baseUrl;
                c00023.L$4 = code;
                c00023.L$5 = fingerprint;
                c00023.L$6 = baseHeaders;
                c00023.L$7 = isolatedApp;
                c00023.label = 6;
                objBypassXD$postSession = bypassXD$postSession(code, baseUrl, fingerprint, isolatedApp, baseHeaders, c00023);
                if (objBypassXD$postSession == obj) {
                    return obj;
                }
                retryCode = code;
                $result2 = objBypassXD$postSession;
                retryBaseUrl = baseUrl;
                baseHeaders2 = baseHeaders;
                retryCode2 = fingerprint;
                isolatedApp2 = isolatedApp;
                redirect2 = redirect;
                initialResponse5 = initialResponse2;
                sessionJson = (JSONObject) $result2;
                if (sessionJson == null) {
                    String str3111 = str8;
                    Log.INSTANCE.d(str3111, "Retrying bypassXD from scratch after session POST failure");
                    Requests app117 = MainActivityKt.getApp();
                    XDMoviesCFBypassInterceptor xDMoviesCFBypassInterceptor110 = XDMoviesCFBypassInterceptor.INSTANCE;
                    c00023.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                    c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                    c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                    c00023.L$3 = retryBaseUrl;
                    c00023.L$4 = retryCode;
                    c00023.L$5 = retryCode2;
                    c00023.L$6 = baseHeaders2;
                    c00023.L$7 = isolatedApp2;
                    c00023.label = 7;
                    isolatedApp3 = isolatedApp2;
                    fingerprint2 = retryCode2;
                    code2 = retryCode;
                    C00021 c0002112 = c00023;
                    baseUrl2 = retryBaseUrl;
                    obj5 = obj3;
                    baseHeaders4 = baseHeaders2;
                    url9 = url4;
                    obj6 = obj4;
                    str18 = str14;
                    str19 = str3111;
                    str20 = str29;
                    str21 = str28;
                    $result2 = Requests.get$default(app117, url9, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, xDMoviesCFBypassInterceptor110, false, (ResponseParser) null, c0002112, 3550, (Object) null);
                    c00023 = c0002112;
                    if ($result2 == obj) {
                        return obj;
                    }
                    fingerprint3 = baseUrl2;
                    isolatedApp4 = isolatedApp3;
                    code3 = code2;
                    code4 = url9;
                    redirect3 = redirect2;
                    initialResponse6 = initialResponse5;
                    url10 = fingerprint2;
                    fingerprint4 = null;
                    retryResp = (NiceResponse) $result2;
                    str22 = str20;
                    retryRedirect = retryResp.getHeaders().get(str22);
                    if (retryRedirect == null) {
                        return null;
                    }
                    retryBaseUrl2 = getBaseUrl(retryRedirect);
                    it2 = StringsKt.substringAfterLast$default(retryRedirect, str21, (String) null, 2, (Object) null);
                    if (it2.length() > 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        it2 = null;
                    }
                    if (it2 == null) {
                        return null;
                    }
                    retryCode3 = it2;
                    $this$bypassXD_u24lambda_u246_u241 = MapsKt.toMutableMap(baseHeaders4);
                    $this$bypassXD_u24lambda_u246_u241.put(obj5, retryBaseUrl2);
                    str23 = str18;
                    $this$bypassXD_u24lambda_u246_u241.put(obj6, retryBaseUrl2 + str23 + retryCode3);
                    Result.Companion companion17 = Result.Companion;
                    String str3112 = retryBaseUrl2 + "/api/session";
                    RequestBody requestBodyCreate7 = RequestBody.Companion.create("{\"code\":\"" + retryCode3 + "\",\"fingerprint\":\"" + url10 + "\"}", MediaType.Companion.get("application/json"));
                    c00023.L$0 = SpillingKt.nullOutSpilledVariable(code4);
                    c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse6);
                    c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect3);
                    c00023.L$3 = fingerprint3;
                    c00023.L$4 = code3;
                    c00023.L$5 = url10;
                    c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders4);
                    c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp4);
                    c00023.L$8 = SpillingKt.nullOutSpilledVariable(retryResp);
                    c00023.L$9 = SpillingKt.nullOutSpilledVariable(retryBaseUrl2);
                    c00023.L$10 = SpillingKt.nullOutSpilledVariable(retryRedirect);
                    c00023.L$11 = SpillingKt.nullOutSpilledVariable($this$bypassXD_u24lambda_u246_u241);
                    c00023.L$12 = SpillingKt.nullOutSpilledVariable(retryCode3);
                    c00023.label = 8;
                    code7 = code3;
                    baseUrl4 = fingerprint3;
                    c00022 = c00023;
                    fingerprint6 = url10;
                    str15 = str23;
                    str16 = str22;
                    isolatedApp6 = isolatedApp4;
                    objPost$default = Requests.post$default(isolatedApp6, str3112, $this$bypassXD_u24lambda_u246_u241, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate7, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                    c00023 = c00022;
                    if (objPost$default == obj) {
                        return obj;
                    }
                    isolatedApp5 = isolatedApp6;
                    retryHeaders = $this$bypassXD_u24lambda_u246_u241;
                    str24 = fingerprint4;
                    baseHeaders5 = baseHeaders4;
                    url11 = code4;
                    code5 = code7;
                    retryBaseUrl2 = retryBaseUrl2;
                    fingerprint5 = fingerprint6;
                    code6 = retryCode3;
                    $result2 = objPost$default;
                    initialResponse7 = initialResponse6;
                    baseUrl3 = baseUrl4;
                    obj7 = Result.constructor-impl((NiceResponse) $result2);
                    isolatedApp2 = isolatedApp5;
                    baseHeaders3 = baseHeaders5;
                    initialResponse5 = initialResponse7;
                    url4 = url11;
                    retryCode2 = fingerprint5;
                    retryBaseUrl = baseUrl3;
                    if (Result.exceptionOrNull-impl(obj7) != null) {
                        return null;
                    }
                    retrySessionResp = (NiceResponse) obj7;
                    if (retrySessionResp.getCode() == 400) {
                        Log.INSTANCE.e(str19, "Retry session POST also got 400 — giving up");
                        return null;
                    }
                    str17 = str19;
                    Result.Companion companion18 = Result.Companion;
                    obj8 = Result.constructor-impl(new JSONObject(retrySessionResp.getText()));
                    if (Result.exceptionOrNull-impl(obj8) != null) {
                        return null;
                    }
                    sessionJson = (JSONObject) obj8;
                    retryCode = code5;
                    redirect2 = redirect3;
                } else {
                    str15 = str14;
                    str16 = str29;
                    str17 = str8;
                    baseHeaders3 = baseHeaders2;
                }
                sessionId = sessionJson.optString("sessionId");
                if (sessionId.length() > 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (!z3) {
                    sessionId = null;
                }
                if (sessionId == null) {
                    return null;
                }
                CoroutineContext main8 = Dispatchers.getMain();
                ExtractorKt$bypassXD$resultUrl$1 extractorKt$bypassXD$resultUrl$8 = new ExtractorKt$bypassXD$resultUrl$1(retryBaseUrl, sessionId, retryCode2, null);
                c00023.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                c00023.L$3 = retryBaseUrl;
                c00023.L$4 = retryCode;
                c00023.L$5 = SpillingKt.nullOutSpilledVariable(retryCode2);
                c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders3);
                c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp2);
                c00023.L$8 = SpillingKt.nullOutSpilledVariable(sessionJson);
                c00023.L$9 = sessionId;
                c00023.L$10 = null;
                c00023.L$11 = null;
                c00023.L$12 = null;
                c00023.label = 9;
                objWithContext = BuildersKt.withContext(main8, extractorKt$bypassXD$resultUrl$8, c00023);
                if (objWithContext == obj) {
                    return obj;
                }
                sessionJson2 = sessionJson;
                baseHeaders6 = baseHeaders3;
                isolatedApp7 = isolatedApp2;
                fingerprint7 = retryCode2;
                code8 = retryCode;
                $result2 = objWithContext;
                baseUrl5 = retryBaseUrl;
                sessionId2 = sessionId;
                sessionId3 = url4;
                resultUrl = (String) $result2;
                if (resultUrl == null) {
                    return null;
                }
                Log.INSTANCE.d(str17, "Intercepted URL: " + resultUrl);
                if (StringsKt.startsWith$default(resultUrl, "COMPLETE:", false, 2, (Object) null)) {
                    String completeToken8 = StringsKt.substringAfter$default(resultUrl, "COMPLETE:", (String) null, 2, (Object) null);
                    String finalResultUrl17 = baseUrl5 + str + sessionId2 + "?t=" + completeToken8;
                    finalResultUrl2 = sessionId3;
                    resultUrl2 = resultUrl;
                    baseUrl6 = baseUrl5;
                    step2Url = sessionId2;
                    code9 = code8;
                    finalResultUrl = finalResultUrl17;
                    baseUrl7 = str16;
                } else {
                    str25 = str;
                    if (Intrinsics.areEqual(resultUrl, "COMPLETE")) {
                        step2Url2 = baseUrl5 + str15 + code8 + "?step=2&sid=" + sessionId2;
                        Requests app118 = MainActivityKt.getApp();
                        c00023.L$0 = SpillingKt.nullOutSpilledVariable(sessionId3);
                        c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                        c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                        c00023.L$3 = SpillingKt.nullOutSpilledVariable(baseUrl5);
                        c00023.L$4 = SpillingKt.nullOutSpilledVariable(code8);
                        c00023.L$5 = SpillingKt.nullOutSpilledVariable(fingerprint7);
                        c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders6);
                        c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp7);
                        c00023.L$8 = SpillingKt.nullOutSpilledVariable(sessionJson2);
                        c00023.L$9 = sessionId2;
                        c00023.L$10 = SpillingKt.nullOutSpilledVariable(resultUrl);
                        c00023.L$11 = SpillingKt.nullOutSpilledVariable(resultUrl);
                        c00023.L$12 = step2Url2;
                        c00023.label = 10;
                        sessionId4 = sessionId2;
                        code10 = code8;
                        C00021 c0002113 = c00023;
                        baseUrl8 = baseUrl5;
                        str = str25;
                        obj9 = Requests.get$default(app118, step2Url2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c0002113, 4062, (Object) null);
                        c00023 = c0002113;
                        if (obj9 == obj) {
                            return obj;
                        }
                        $result = sessionId3;
                        url12 = step2Url2;
                        obj10 = obj9;
                        sessionJson3 = sessionJson2;
                        redirect4 = redirect2;
                        initialResponse8 = initialResponse5;
                        isolatedApp8 = isolatedApp7;
                        baseHeaders7 = baseHeaders6;
                        fingerprint8 = fingerprint7;
                        baseUrl9 = baseUrl8;
                        resultUrl3 = resultUrl;
                        sessionId5 = sessionId4;
                        code11 = code10;
                        NiceResponse step2Resp8 = (NiceResponse) obj10;
                        String baseUrl17 = baseUrl9;
                        baseUrl7 = str16;
                        str27 = step2Resp8.getHeaders().get(baseUrl7);
                        if (str27 == null) {
                            str27 = url12;
                        }
                        String finalResultUrl18 = str27;
                        baseUrl6 = baseUrl17;
                        finalResultUrl2 = $result;
                        redirect2 = redirect4;
                        finalResultUrl = finalResultUrl18;
                        resultUrl2 = resultUrl3;
                        step2Url = sessionId5;
                        sessionJson2 = sessionJson3;
                        isolatedApp7 = isolatedApp8;
                        baseHeaders6 = baseHeaders7;
                        fingerprint7 = fingerprint8;
                        code9 = code11;
                        initialResponse5 = initialResponse8;
                    } else {
                        resultUrl2 = resultUrl;
                        baseUrl6 = baseUrl5;
                        code9 = code8;
                        str = str25;
                        baseUrl7 = str16;
                        finalResultUrl = resultUrl;
                        finalResultUrl2 = sessionId3;
                        step2Url = sessionId2;
                    }
                }
                if (!StringsKt.contains(finalResultUrl, str, true)) {
                    return finalResultUrl;
                }
                Requests app119 = MainActivityKt.getApp();
                Map mapMapOf8 = MapsKt.mapOf(TuplesKt.to("Cookie", "sid=" + step2Url));
                XDMoviesCFBypassInterceptor xDMoviesCFBypassInterceptor111 = XDMoviesCFBypassInterceptor.INSTANCE;
                c00023.L$0 = SpillingKt.nullOutSpilledVariable(finalResultUrl2);
                c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                c00023.L$3 = SpillingKt.nullOutSpilledVariable(baseUrl6);
                c00023.L$4 = SpillingKt.nullOutSpilledVariable(code9);
                c00023.L$5 = SpillingKt.nullOutSpilledVariable(fingerprint7);
                c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders6);
                c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp7);
                c00023.L$8 = SpillingKt.nullOutSpilledVariable(sessionJson2);
                c00023.L$9 = SpillingKt.nullOutSpilledVariable(step2Url);
                c00023.L$10 = SpillingKt.nullOutSpilledVariable(resultUrl2);
                c00023.L$11 = SpillingKt.nullOutSpilledVariable(finalResultUrl);
                c00023.L$12 = null;
                c00023.label = 11;
                str26 = baseUrl7;
                $result2 = Requests.get$default(app119, finalResultUrl, mapMapOf8, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, xDMoviesCFBypassInterceptor111, false, (ResponseParser) null, c00023, 3548, (Object) null);
                if ($result2 == obj) {
                    return obj;
                }
                return ((NiceResponse) $result2).getHeaders().get(str26);
            case 3:
                url7 = (String) c00023.L$0;
                ResultKt.throwOnFailure($result2);
                obj = coroutine_suspended;
                str = "/go/";
                str2 = "/";
                str3 = "/r/";
                obj11 = obj11;
                str12 = "XDMovies";
                str7 = str29;
                str6 = null;
                initialResponse2 = (NiceResponse) $result2;
                url4 = url7;
                str8 = str12;
                c = 5;
                str13 = str7;
                redirect = initialResponse2.getHeaders().get(str13);
                if (redirect == null) {
                    return str6;
                }
                baseUrl = getBaseUrl(redirect);
                String str3113 = str6;
                str28 = str2;
                it = StringsKt.substringAfterLast$default(redirect, str28, str3113, 2, str3113);
                if (it.length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    code = it;
                } else {
                    code = null;
                }
                if (code == null) {
                    return null;
                }
                fingerprint = generateBrowserFingerprint();
                Pair[] pairArr8 = new Pair[7];
                pairArr8[0] = TuplesKt.to("User-Agent", "Mozilla/5.0 (Linux; Android 10) AppleWebKit/537.36 Chrome/124 Mobile Safari/537.36");
                pairArr8[1] = TuplesKt.to("Accept", "*/*");
                obj3 = "Origin";
                pairArr8[2] = TuplesKt.to(obj3, baseUrl);
                str29 = str13;
                str14 = str3;
                obj4 = obj11;
                pairArr8[3] = TuplesKt.to(obj4, baseUrl + str14 + code);
                pairArr8[4] = TuplesKt.to("sec-fetch-site", "same-origin");
                pairArr8[c] = TuplesKt.to("sec-fetch-mode", "cors");
                pairArr8[6] = TuplesKt.to("sec-fetch-dest", "empty");
                baseHeaders = MapsKt.mapOf(pairArr8);
                isolatedApp = new Requests(MainActivityKt.getApp().getBaseClient().newBuilder().cookieJar(CookieJar.NO_COOKIES).build(), (Map) null, (String) null, (Map) null, (Map) null, 0, (TimeUnit) null, 0L, (ResponseParser) null, 510, (DefaultConstructorMarker) null);
                c00023.L$0 = url4;
                c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse2);
                c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect);
                c00023.L$3 = baseUrl;
                c00023.L$4 = code;
                c00023.L$5 = fingerprint;
                c00023.L$6 = baseHeaders;
                c00023.L$7 = isolatedApp;
                c00023.label = 6;
                objBypassXD$postSession = bypassXD$postSession(code, baseUrl, fingerprint, isolatedApp, baseHeaders, c00023);
                if (objBypassXD$postSession == obj) {
                    return obj;
                }
                retryCode = code;
                $result2 = objBypassXD$postSession;
                retryBaseUrl = baseUrl;
                baseHeaders2 = baseHeaders;
                retryCode2 = fingerprint;
                isolatedApp2 = isolatedApp;
                redirect2 = redirect;
                initialResponse5 = initialResponse2;
                sessionJson = (JSONObject) $result2;
                if (sessionJson == null) {
                    String str3114 = str8;
                    Log.INSTANCE.d(str3114, "Retrying bypassXD from scratch after session POST failure");
                    Requests app1110 = MainActivityKt.getApp();
                    XDMoviesCFBypassInterceptor xDMoviesCFBypassInterceptor112 = XDMoviesCFBypassInterceptor.INSTANCE;
                    c00023.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                    c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                    c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                    c00023.L$3 = retryBaseUrl;
                    c00023.L$4 = retryCode;
                    c00023.L$5 = retryCode2;
                    c00023.L$6 = baseHeaders2;
                    c00023.L$7 = isolatedApp2;
                    c00023.label = 7;
                    isolatedApp3 = isolatedApp2;
                    fingerprint2 = retryCode2;
                    code2 = retryCode;
                    C00021 c0002114 = c00023;
                    baseUrl2 = retryBaseUrl;
                    obj5 = obj3;
                    baseHeaders4 = baseHeaders2;
                    url9 = url4;
                    obj6 = obj4;
                    str18 = str14;
                    str19 = str3114;
                    str20 = str29;
                    str21 = str28;
                    $result2 = Requests.get$default(app1110, url9, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, xDMoviesCFBypassInterceptor112, false, (ResponseParser) null, c0002114, 3550, (Object) null);
                    c00023 = c0002114;
                    if ($result2 == obj) {
                        return obj;
                    }
                    fingerprint3 = baseUrl2;
                    isolatedApp4 = isolatedApp3;
                    code3 = code2;
                    code4 = url9;
                    redirect3 = redirect2;
                    initialResponse6 = initialResponse5;
                    url10 = fingerprint2;
                    fingerprint4 = null;
                    retryResp = (NiceResponse) $result2;
                    str22 = str20;
                    retryRedirect = retryResp.getHeaders().get(str22);
                    if (retryRedirect == null) {
                        return null;
                    }
                    retryBaseUrl2 = getBaseUrl(retryRedirect);
                    it2 = StringsKt.substringAfterLast$default(retryRedirect, str21, (String) null, 2, (Object) null);
                    if (it2.length() > 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        it2 = null;
                    }
                    if (it2 == null) {
                        return null;
                    }
                    retryCode3 = it2;
                    $this$bypassXD_u24lambda_u246_u241 = MapsKt.toMutableMap(baseHeaders4);
                    $this$bypassXD_u24lambda_u246_u241.put(obj5, retryBaseUrl2);
                    str23 = str18;
                    $this$bypassXD_u24lambda_u246_u241.put(obj6, retryBaseUrl2 + str23 + retryCode3);
                    Result.Companion companion19 = Result.Companion;
                    String str3115 = retryBaseUrl2 + "/api/session";
                    RequestBody requestBodyCreate8 = RequestBody.Companion.create("{\"code\":\"" + retryCode3 + "\",\"fingerprint\":\"" + url10 + "\"}", MediaType.Companion.get("application/json"));
                    c00023.L$0 = SpillingKt.nullOutSpilledVariable(code4);
                    c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse6);
                    c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect3);
                    c00023.L$3 = fingerprint3;
                    c00023.L$4 = code3;
                    c00023.L$5 = url10;
                    c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders4);
                    c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp4);
                    c00023.L$8 = SpillingKt.nullOutSpilledVariable(retryResp);
                    c00023.L$9 = SpillingKt.nullOutSpilledVariable(retryBaseUrl2);
                    c00023.L$10 = SpillingKt.nullOutSpilledVariable(retryRedirect);
                    c00023.L$11 = SpillingKt.nullOutSpilledVariable($this$bypassXD_u24lambda_u246_u241);
                    c00023.L$12 = SpillingKt.nullOutSpilledVariable(retryCode3);
                    c00023.label = 8;
                    code7 = code3;
                    baseUrl4 = fingerprint3;
                    c00022 = c00023;
                    fingerprint6 = url10;
                    str15 = str23;
                    str16 = str22;
                    isolatedApp6 = isolatedApp4;
                    objPost$default = Requests.post$default(isolatedApp6, str3115, $this$bypassXD_u24lambda_u246_u241, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate8, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                    c00023 = c00022;
                    if (objPost$default == obj) {
                        return obj;
                    }
                    isolatedApp5 = isolatedApp6;
                    retryHeaders = $this$bypassXD_u24lambda_u246_u241;
                    str24 = fingerprint4;
                    baseHeaders5 = baseHeaders4;
                    url11 = code4;
                    code5 = code7;
                    retryBaseUrl2 = retryBaseUrl2;
                    fingerprint5 = fingerprint6;
                    code6 = retryCode3;
                    $result2 = objPost$default;
                    initialResponse7 = initialResponse6;
                    baseUrl3 = baseUrl4;
                    obj7 = Result.constructor-impl((NiceResponse) $result2);
                    isolatedApp2 = isolatedApp5;
                    baseHeaders3 = baseHeaders5;
                    initialResponse5 = initialResponse7;
                    url4 = url11;
                    retryCode2 = fingerprint5;
                    retryBaseUrl = baseUrl3;
                    if (Result.exceptionOrNull-impl(obj7) != null) {
                        return null;
                    }
                    retrySessionResp = (NiceResponse) obj7;
                    if (retrySessionResp.getCode() == 400) {
                        Log.INSTANCE.e(str19, "Retry session POST also got 400 — giving up");
                        return null;
                    }
                    str17 = str19;
                    Result.Companion companion110 = Result.Companion;
                    obj8 = Result.constructor-impl(new JSONObject(retrySessionResp.getText()));
                    if (Result.exceptionOrNull-impl(obj8) != null) {
                        return null;
                    }
                    sessionJson = (JSONObject) obj8;
                    retryCode = code5;
                    redirect2 = redirect3;
                } else {
                    str15 = str14;
                    str16 = str29;
                    str17 = str8;
                    baseHeaders3 = baseHeaders2;
                }
                sessionId = sessionJson.optString("sessionId");
                if (sessionId.length() > 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (!z3) {
                    sessionId = null;
                }
                if (sessionId == null) {
                    return null;
                }
                CoroutineContext main9 = Dispatchers.getMain();
                ExtractorKt$bypassXD$resultUrl$1 extractorKt$bypassXD$resultUrl$9 = new ExtractorKt$bypassXD$resultUrl$1(retryBaseUrl, sessionId, retryCode2, null);
                c00023.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                c00023.L$3 = retryBaseUrl;
                c00023.L$4 = retryCode;
                c00023.L$5 = SpillingKt.nullOutSpilledVariable(retryCode2);
                c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders3);
                c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp2);
                c00023.L$8 = SpillingKt.nullOutSpilledVariable(sessionJson);
                c00023.L$9 = sessionId;
                c00023.L$10 = null;
                c00023.L$11 = null;
                c00023.L$12 = null;
                c00023.label = 9;
                objWithContext = BuildersKt.withContext(main9, extractorKt$bypassXD$resultUrl$9, c00023);
                if (objWithContext == obj) {
                    return obj;
                }
                sessionJson2 = sessionJson;
                baseHeaders6 = baseHeaders3;
                isolatedApp7 = isolatedApp2;
                fingerprint7 = retryCode2;
                code8 = retryCode;
                $result2 = objWithContext;
                baseUrl5 = retryBaseUrl;
                sessionId2 = sessionId;
                sessionId3 = url4;
                resultUrl = (String) $result2;
                if (resultUrl == null) {
                    return null;
                }
                Log.INSTANCE.d(str17, "Intercepted URL: " + resultUrl);
                if (StringsKt.startsWith$default(resultUrl, "COMPLETE:", false, 2, (Object) null)) {
                    String completeToken9 = StringsKt.substringAfter$default(resultUrl, "COMPLETE:", (String) null, 2, (Object) null);
                    String finalResultUrl19 = baseUrl5 + str + sessionId2 + "?t=" + completeToken9;
                    finalResultUrl2 = sessionId3;
                    resultUrl2 = resultUrl;
                    baseUrl6 = baseUrl5;
                    step2Url = sessionId2;
                    code9 = code8;
                    finalResultUrl = finalResultUrl19;
                    baseUrl7 = str16;
                } else {
                    str25 = str;
                    if (Intrinsics.areEqual(resultUrl, "COMPLETE")) {
                        step2Url2 = baseUrl5 + str15 + code8 + "?step=2&sid=" + sessionId2;
                        Requests app1111 = MainActivityKt.getApp();
                        c00023.L$0 = SpillingKt.nullOutSpilledVariable(sessionId3);
                        c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                        c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                        c00023.L$3 = SpillingKt.nullOutSpilledVariable(baseUrl5);
                        c00023.L$4 = SpillingKt.nullOutSpilledVariable(code8);
                        c00023.L$5 = SpillingKt.nullOutSpilledVariable(fingerprint7);
                        c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders6);
                        c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp7);
                        c00023.L$8 = SpillingKt.nullOutSpilledVariable(sessionJson2);
                        c00023.L$9 = sessionId2;
                        c00023.L$10 = SpillingKt.nullOutSpilledVariable(resultUrl);
                        c00023.L$11 = SpillingKt.nullOutSpilledVariable(resultUrl);
                        c00023.L$12 = step2Url2;
                        c00023.label = 10;
                        sessionId4 = sessionId2;
                        code10 = code8;
                        C00021 c0002115 = c00023;
                        baseUrl8 = baseUrl5;
                        str = str25;
                        obj9 = Requests.get$default(app1111, step2Url2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c0002115, 4062, (Object) null);
                        c00023 = c0002115;
                        if (obj9 == obj) {
                            return obj;
                        }
                        $result = sessionId3;
                        url12 = step2Url2;
                        obj10 = obj9;
                        sessionJson3 = sessionJson2;
                        redirect4 = redirect2;
                        initialResponse8 = initialResponse5;
                        isolatedApp8 = isolatedApp7;
                        baseHeaders7 = baseHeaders6;
                        fingerprint8 = fingerprint7;
                        baseUrl9 = baseUrl8;
                        resultUrl3 = resultUrl;
                        sessionId5 = sessionId4;
                        code11 = code10;
                        NiceResponse step2Resp9 = (NiceResponse) obj10;
                        String baseUrl18 = baseUrl9;
                        baseUrl7 = str16;
                        str27 = step2Resp9.getHeaders().get(baseUrl7);
                        if (str27 == null) {
                            str27 = url12;
                        }
                        String finalResultUrl110 = str27;
                        baseUrl6 = baseUrl18;
                        finalResultUrl2 = $result;
                        redirect2 = redirect4;
                        finalResultUrl = finalResultUrl110;
                        resultUrl2 = resultUrl3;
                        step2Url = sessionId5;
                        sessionJson2 = sessionJson3;
                        isolatedApp7 = isolatedApp8;
                        baseHeaders6 = baseHeaders7;
                        fingerprint7 = fingerprint8;
                        code9 = code11;
                        initialResponse5 = initialResponse8;
                    } else {
                        resultUrl2 = resultUrl;
                        baseUrl6 = baseUrl5;
                        code9 = code8;
                        str = str25;
                        baseUrl7 = str16;
                        finalResultUrl = resultUrl;
                        finalResultUrl2 = sessionId3;
                        step2Url = sessionId2;
                    }
                }
                if (!StringsKt.contains(finalResultUrl, str, true)) {
                    return finalResultUrl;
                }
                Requests app1112 = MainActivityKt.getApp();
                Map mapMapOf9 = MapsKt.mapOf(TuplesKt.to("Cookie", "sid=" + step2Url));
                XDMoviesCFBypassInterceptor xDMoviesCFBypassInterceptor113 = XDMoviesCFBypassInterceptor.INSTANCE;
                c00023.L$0 = SpillingKt.nullOutSpilledVariable(finalResultUrl2);
                c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                c00023.L$3 = SpillingKt.nullOutSpilledVariable(baseUrl6);
                c00023.L$4 = SpillingKt.nullOutSpilledVariable(code9);
                c00023.L$5 = SpillingKt.nullOutSpilledVariable(fingerprint7);
                c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders6);
                c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp7);
                c00023.L$8 = SpillingKt.nullOutSpilledVariable(sessionJson2);
                c00023.L$9 = SpillingKt.nullOutSpilledVariable(step2Url);
                c00023.L$10 = SpillingKt.nullOutSpilledVariable(resultUrl2);
                c00023.L$11 = SpillingKt.nullOutSpilledVariable(finalResultUrl);
                c00023.L$12 = null;
                c00023.label = 11;
                str26 = baseUrl7;
                $result2 = Requests.get$default(app1112, finalResultUrl, mapMapOf9, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, xDMoviesCFBypassInterceptor113, false, (ResponseParser) null, c00023, 3548, (Object) null);
                if ($result2 == obj) {
                    return obj;
                }
                return ((NiceResponse) $result2).getHeaders().get(str26);
            case 4:
                Function1 isCfBlocked5 = (Function1) c00023.L$2;
                NiceResponse initialResponse10 = (NiceResponse) c00023.L$1;
                String url15 = (String) c00023.L$0;
                ResultKt.throwOnFailure($result2);
                isCfBlocked2 = isCfBlocked5;
                obj = coroutine_suspended;
                initialResponse3 = initialResponse10;
                url5 = url15;
                str = "/go/";
                str2 = "/";
                str3 = "/r/";
                obj11 = obj11;
                str10 = "XDMovies";
                str7 = str29;
                str6 = null;
                Requests app120 = MainActivityKt.getApp();
                XDMoviesCFBypassInterceptor xDMoviesCFBypassInterceptor114 = XDMoviesCFBypassInterceptor.INSTANCE;
                c00023.L$0 = url5;
                c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse3);
                c00023.L$2 = SpillingKt.nullOutSpilledVariable(isCfBlocked2);
                c00023.label = 5;
                c = 5;
                C00021 c0002116 = c00023;
                str8 = str10;
                $result2 = Requests.get$default(app120, url5, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, xDMoviesCFBypassInterceptor114, false, (ResponseParser) null, c0002116, 3550, (Object) null);
                c00023 = c0002116;
                if ($result2 == obj) {
                    return obj;
                }
                url8 = url5;
                initialResponse2 = (NiceResponse) $result2;
                url4 = url8;
                str13 = str7;
                redirect = initialResponse2.getHeaders().get(str13);
                if (redirect == null) {
                    return str6;
                }
                baseUrl = getBaseUrl(redirect);
                String str3116 = str6;
                str28 = str2;
                it = StringsKt.substringAfterLast$default(redirect, str28, str3116, 2, str3116);
                if (it.length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    code = it;
                } else {
                    code = null;
                }
                if (code == null) {
                    return null;
                }
                fingerprint = generateBrowserFingerprint();
                Pair[] pairArr9 = new Pair[7];
                pairArr9[0] = TuplesKt.to("User-Agent", "Mozilla/5.0 (Linux; Android 10) AppleWebKit/537.36 Chrome/124 Mobile Safari/537.36");
                pairArr9[1] = TuplesKt.to("Accept", "*/*");
                obj3 = "Origin";
                pairArr9[2] = TuplesKt.to(obj3, baseUrl);
                str29 = str13;
                str14 = str3;
                obj4 = obj11;
                pairArr9[3] = TuplesKt.to(obj4, baseUrl + str14 + code);
                pairArr9[4] = TuplesKt.to("sec-fetch-site", "same-origin");
                pairArr9[c] = TuplesKt.to("sec-fetch-mode", "cors");
                pairArr9[6] = TuplesKt.to("sec-fetch-dest", "empty");
                baseHeaders = MapsKt.mapOf(pairArr9);
                isolatedApp = new Requests(MainActivityKt.getApp().getBaseClient().newBuilder().cookieJar(CookieJar.NO_COOKIES).build(), (Map) null, (String) null, (Map) null, (Map) null, 0, (TimeUnit) null, 0L, (ResponseParser) null, 510, (DefaultConstructorMarker) null);
                c00023.L$0 = url4;
                c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse2);
                c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect);
                c00023.L$3 = baseUrl;
                c00023.L$4 = code;
                c00023.L$5 = fingerprint;
                c00023.L$6 = baseHeaders;
                c00023.L$7 = isolatedApp;
                c00023.label = 6;
                objBypassXD$postSession = bypassXD$postSession(code, baseUrl, fingerprint, isolatedApp, baseHeaders, c00023);
                if (objBypassXD$postSession == obj) {
                    return obj;
                }
                retryCode = code;
                $result2 = objBypassXD$postSession;
                retryBaseUrl = baseUrl;
                baseHeaders2 = baseHeaders;
                retryCode2 = fingerprint;
                isolatedApp2 = isolatedApp;
                redirect2 = redirect;
                initialResponse5 = initialResponse2;
                sessionJson = (JSONObject) $result2;
                if (sessionJson == null) {
                    String str3117 = str8;
                    Log.INSTANCE.d(str3117, "Retrying bypassXD from scratch after session POST failure");
                    Requests app1113 = MainActivityKt.getApp();
                    XDMoviesCFBypassInterceptor xDMoviesCFBypassInterceptor115 = XDMoviesCFBypassInterceptor.INSTANCE;
                    c00023.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                    c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                    c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                    c00023.L$3 = retryBaseUrl;
                    c00023.L$4 = retryCode;
                    c00023.L$5 = retryCode2;
                    c00023.L$6 = baseHeaders2;
                    c00023.L$7 = isolatedApp2;
                    c00023.label = 7;
                    isolatedApp3 = isolatedApp2;
                    fingerprint2 = retryCode2;
                    code2 = retryCode;
                    C00021 c0002117 = c00023;
                    baseUrl2 = retryBaseUrl;
                    obj5 = obj3;
                    baseHeaders4 = baseHeaders2;
                    url9 = url4;
                    obj6 = obj4;
                    str18 = str14;
                    str19 = str3117;
                    str20 = str29;
                    str21 = str28;
                    $result2 = Requests.get$default(app1113, url9, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, xDMoviesCFBypassInterceptor115, false, (ResponseParser) null, c0002117, 3550, (Object) null);
                    c00023 = c0002117;
                    if ($result2 == obj) {
                        return obj;
                    }
                    fingerprint3 = baseUrl2;
                    isolatedApp4 = isolatedApp3;
                    code3 = code2;
                    code4 = url9;
                    redirect3 = redirect2;
                    initialResponse6 = initialResponse5;
                    url10 = fingerprint2;
                    fingerprint4 = null;
                    retryResp = (NiceResponse) $result2;
                    str22 = str20;
                    retryRedirect = retryResp.getHeaders().get(str22);
                    if (retryRedirect == null) {
                        return null;
                    }
                    retryBaseUrl2 = getBaseUrl(retryRedirect);
                    it2 = StringsKt.substringAfterLast$default(retryRedirect, str21, (String) null, 2, (Object) null);
                    if (it2.length() > 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        it2 = null;
                    }
                    if (it2 == null) {
                        return null;
                    }
                    retryCode3 = it2;
                    $this$bypassXD_u24lambda_u246_u241 = MapsKt.toMutableMap(baseHeaders4);
                    $this$bypassXD_u24lambda_u246_u241.put(obj5, retryBaseUrl2);
                    str23 = str18;
                    $this$bypassXD_u24lambda_u246_u241.put(obj6, retryBaseUrl2 + str23 + retryCode3);
                    Result.Companion companion111 = Result.Companion;
                    String str3118 = retryBaseUrl2 + "/api/session";
                    RequestBody requestBodyCreate9 = RequestBody.Companion.create("{\"code\":\"" + retryCode3 + "\",\"fingerprint\":\"" + url10 + "\"}", MediaType.Companion.get("application/json"));
                    c00023.L$0 = SpillingKt.nullOutSpilledVariable(code4);
                    c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse6);
                    c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect3);
                    c00023.L$3 = fingerprint3;
                    c00023.L$4 = code3;
                    c00023.L$5 = url10;
                    c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders4);
                    c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp4);
                    c00023.L$8 = SpillingKt.nullOutSpilledVariable(retryResp);
                    c00023.L$9 = SpillingKt.nullOutSpilledVariable(retryBaseUrl2);
                    c00023.L$10 = SpillingKt.nullOutSpilledVariable(retryRedirect);
                    c00023.L$11 = SpillingKt.nullOutSpilledVariable($this$bypassXD_u24lambda_u246_u241);
                    c00023.L$12 = SpillingKt.nullOutSpilledVariable(retryCode3);
                    c00023.label = 8;
                    code7 = code3;
                    baseUrl4 = fingerprint3;
                    c00022 = c00023;
                    fingerprint6 = url10;
                    str15 = str23;
                    str16 = str22;
                    isolatedApp6 = isolatedApp4;
                    objPost$default = Requests.post$default(isolatedApp6, str3118, $this$bypassXD_u24lambda_u246_u241, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate9, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                    c00023 = c00022;
                    if (objPost$default == obj) {
                        return obj;
                    }
                    isolatedApp5 = isolatedApp6;
                    retryHeaders = $this$bypassXD_u24lambda_u246_u241;
                    str24 = fingerprint4;
                    baseHeaders5 = baseHeaders4;
                    url11 = code4;
                    code5 = code7;
                    retryBaseUrl2 = retryBaseUrl2;
                    fingerprint5 = fingerprint6;
                    code6 = retryCode3;
                    $result2 = objPost$default;
                    initialResponse7 = initialResponse6;
                    baseUrl3 = baseUrl4;
                    obj7 = Result.constructor-impl((NiceResponse) $result2);
                    isolatedApp2 = isolatedApp5;
                    baseHeaders3 = baseHeaders5;
                    initialResponse5 = initialResponse7;
                    url4 = url11;
                    retryCode2 = fingerprint5;
                    retryBaseUrl = baseUrl3;
                    if (Result.exceptionOrNull-impl(obj7) != null) {
                        return null;
                    }
                    retrySessionResp = (NiceResponse) obj7;
                    if (retrySessionResp.getCode() == 400) {
                        Log.INSTANCE.e(str19, "Retry session POST also got 400 — giving up");
                        return null;
                    }
                    str17 = str19;
                    Result.Companion companion112 = Result.Companion;
                    obj8 = Result.constructor-impl(new JSONObject(retrySessionResp.getText()));
                    if (Result.exceptionOrNull-impl(obj8) != null) {
                        return null;
                    }
                    sessionJson = (JSONObject) obj8;
                    retryCode = code5;
                    redirect2 = redirect3;
                } else {
                    str15 = str14;
                    str16 = str29;
                    str17 = str8;
                    baseHeaders3 = baseHeaders2;
                }
                sessionId = sessionJson.optString("sessionId");
                if (sessionId.length() > 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (!z3) {
                    sessionId = null;
                }
                if (sessionId == null) {
                    return null;
                }
                CoroutineContext main10 = Dispatchers.getMain();
                ExtractorKt$bypassXD$resultUrl$1 extractorKt$bypassXD$resultUrl$10 = new ExtractorKt$bypassXD$resultUrl$1(retryBaseUrl, sessionId, retryCode2, null);
                c00023.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                c00023.L$3 = retryBaseUrl;
                c00023.L$4 = retryCode;
                c00023.L$5 = SpillingKt.nullOutSpilledVariable(retryCode2);
                c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders3);
                c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp2);
                c00023.L$8 = SpillingKt.nullOutSpilledVariable(sessionJson);
                c00023.L$9 = sessionId;
                c00023.L$10 = null;
                c00023.L$11 = null;
                c00023.L$12 = null;
                c00023.label = 9;
                objWithContext = BuildersKt.withContext(main10, extractorKt$bypassXD$resultUrl$10, c00023);
                if (objWithContext == obj) {
                    return obj;
                }
                sessionJson2 = sessionJson;
                baseHeaders6 = baseHeaders3;
                isolatedApp7 = isolatedApp2;
                fingerprint7 = retryCode2;
                code8 = retryCode;
                $result2 = objWithContext;
                baseUrl5 = retryBaseUrl;
                sessionId2 = sessionId;
                sessionId3 = url4;
                resultUrl = (String) $result2;
                if (resultUrl == null) {
                    return null;
                }
                Log.INSTANCE.d(str17, "Intercepted URL: " + resultUrl);
                if (StringsKt.startsWith$default(resultUrl, "COMPLETE:", false, 2, (Object) null)) {
                    String completeToken10 = StringsKt.substringAfter$default(resultUrl, "COMPLETE:", (String) null, 2, (Object) null);
                    String finalResultUrl111 = baseUrl5 + str + sessionId2 + "?t=" + completeToken10;
                    finalResultUrl2 = sessionId3;
                    resultUrl2 = resultUrl;
                    baseUrl6 = baseUrl5;
                    step2Url = sessionId2;
                    code9 = code8;
                    finalResultUrl = finalResultUrl111;
                    baseUrl7 = str16;
                } else {
                    str25 = str;
                    if (Intrinsics.areEqual(resultUrl, "COMPLETE")) {
                        step2Url2 = baseUrl5 + str15 + code8 + "?step=2&sid=" + sessionId2;
                        Requests app1114 = MainActivityKt.getApp();
                        c00023.L$0 = SpillingKt.nullOutSpilledVariable(sessionId3);
                        c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                        c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                        c00023.L$3 = SpillingKt.nullOutSpilledVariable(baseUrl5);
                        c00023.L$4 = SpillingKt.nullOutSpilledVariable(code8);
                        c00023.L$5 = SpillingKt.nullOutSpilledVariable(fingerprint7);
                        c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders6);
                        c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp7);
                        c00023.L$8 = SpillingKt.nullOutSpilledVariable(sessionJson2);
                        c00023.L$9 = sessionId2;
                        c00023.L$10 = SpillingKt.nullOutSpilledVariable(resultUrl);
                        c00023.L$11 = SpillingKt.nullOutSpilledVariable(resultUrl);
                        c00023.L$12 = step2Url2;
                        c00023.label = 10;
                        sessionId4 = sessionId2;
                        code10 = code8;
                        C00021 c0002118 = c00023;
                        baseUrl8 = baseUrl5;
                        str = str25;
                        obj9 = Requests.get$default(app1114, step2Url2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c0002118, 4062, (Object) null);
                        c00023 = c0002118;
                        if (obj9 == obj) {
                            return obj;
                        }
                        $result = sessionId3;
                        url12 = step2Url2;
                        obj10 = obj9;
                        sessionJson3 = sessionJson2;
                        redirect4 = redirect2;
                        initialResponse8 = initialResponse5;
                        isolatedApp8 = isolatedApp7;
                        baseHeaders7 = baseHeaders6;
                        fingerprint8 = fingerprint7;
                        baseUrl9 = baseUrl8;
                        resultUrl3 = resultUrl;
                        sessionId5 = sessionId4;
                        code11 = code10;
                        NiceResponse step2Resp10 = (NiceResponse) obj10;
                        String baseUrl19 = baseUrl9;
                        baseUrl7 = str16;
                        str27 = step2Resp10.getHeaders().get(baseUrl7);
                        if (str27 == null) {
                            str27 = url12;
                        }
                        String finalResultUrl112 = str27;
                        baseUrl6 = baseUrl19;
                        finalResultUrl2 = $result;
                        redirect2 = redirect4;
                        finalResultUrl = finalResultUrl112;
                        resultUrl2 = resultUrl3;
                        step2Url = sessionId5;
                        sessionJson2 = sessionJson3;
                        isolatedApp7 = isolatedApp8;
                        baseHeaders6 = baseHeaders7;
                        fingerprint7 = fingerprint8;
                        code9 = code11;
                        initialResponse5 = initialResponse8;
                    } else {
                        resultUrl2 = resultUrl;
                        baseUrl6 = baseUrl5;
                        code9 = code8;
                        str = str25;
                        baseUrl7 = str16;
                        finalResultUrl = resultUrl;
                        finalResultUrl2 = sessionId3;
                        step2Url = sessionId2;
                    }
                }
                if (!StringsKt.contains(finalResultUrl, str, true)) {
                    return finalResultUrl;
                }
                Requests app1115 = MainActivityKt.getApp();
                Map mapMapOf10 = MapsKt.mapOf(TuplesKt.to("Cookie", "sid=" + step2Url));
                XDMoviesCFBypassInterceptor xDMoviesCFBypassInterceptor116 = XDMoviesCFBypassInterceptor.INSTANCE;
                c00023.L$0 = SpillingKt.nullOutSpilledVariable(finalResultUrl2);
                c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                c00023.L$3 = SpillingKt.nullOutSpilledVariable(baseUrl6);
                c00023.L$4 = SpillingKt.nullOutSpilledVariable(code9);
                c00023.L$5 = SpillingKt.nullOutSpilledVariable(fingerprint7);
                c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders6);
                c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp7);
                c00023.L$8 = SpillingKt.nullOutSpilledVariable(sessionJson2);
                c00023.L$9 = SpillingKt.nullOutSpilledVariable(step2Url);
                c00023.L$10 = SpillingKt.nullOutSpilledVariable(resultUrl2);
                c00023.L$11 = SpillingKt.nullOutSpilledVariable(finalResultUrl);
                c00023.L$12 = null;
                c00023.label = 11;
                str26 = baseUrl7;
                $result2 = Requests.get$default(app1115, finalResultUrl, mapMapOf10, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, xDMoviesCFBypassInterceptor116, false, (ResponseParser) null, c00023, 3548, (Object) null);
                if ($result2 == obj) {
                    return obj;
                }
                return ((NiceResponse) $result2).getHeaders().get(str26);
            case 5:
                url8 = (String) c00023.L$0;
                ResultKt.throwOnFailure($result2);
                obj = coroutine_suspended;
                str = "/go/";
                str2 = "/";
                str3 = "/r/";
                obj11 = obj11;
                str8 = "XDMovies";
                str7 = str29;
                str6 = null;
                c = 5;
                initialResponse2 = (NiceResponse) $result2;
                url4 = url8;
                str13 = str7;
                redirect = initialResponse2.getHeaders().get(str13);
                if (redirect == null) {
                    return str6;
                }
                baseUrl = getBaseUrl(redirect);
                String str3119 = str6;
                str28 = str2;
                it = StringsKt.substringAfterLast$default(redirect, str28, str3119, 2, str3119);
                if (it.length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    code = it;
                } else {
                    code = null;
                }
                if (code == null) {
                    return null;
                }
                fingerprint = generateBrowserFingerprint();
                Pair[] pairArr10 = new Pair[7];
                pairArr10[0] = TuplesKt.to("User-Agent", "Mozilla/5.0 (Linux; Android 10) AppleWebKit/537.36 Chrome/124 Mobile Safari/537.36");
                pairArr10[1] = TuplesKt.to("Accept", "*/*");
                obj3 = "Origin";
                pairArr10[2] = TuplesKt.to(obj3, baseUrl);
                str29 = str13;
                str14 = str3;
                obj4 = obj11;
                pairArr10[3] = TuplesKt.to(obj4, baseUrl + str14 + code);
                pairArr10[4] = TuplesKt.to("sec-fetch-site", "same-origin");
                pairArr10[c] = TuplesKt.to("sec-fetch-mode", "cors");
                pairArr10[6] = TuplesKt.to("sec-fetch-dest", "empty");
                baseHeaders = MapsKt.mapOf(pairArr10);
                isolatedApp = new Requests(MainActivityKt.getApp().getBaseClient().newBuilder().cookieJar(CookieJar.NO_COOKIES).build(), (Map) null, (String) null, (Map) null, (Map) null, 0, (TimeUnit) null, 0L, (ResponseParser) null, 510, (DefaultConstructorMarker) null);
                c00023.L$0 = url4;
                c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse2);
                c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect);
                c00023.L$3 = baseUrl;
                c00023.L$4 = code;
                c00023.L$5 = fingerprint;
                c00023.L$6 = baseHeaders;
                c00023.L$7 = isolatedApp;
                c00023.label = 6;
                objBypassXD$postSession = bypassXD$postSession(code, baseUrl, fingerprint, isolatedApp, baseHeaders, c00023);
                if (objBypassXD$postSession == obj) {
                    return obj;
                }
                retryCode = code;
                $result2 = objBypassXD$postSession;
                retryBaseUrl = baseUrl;
                baseHeaders2 = baseHeaders;
                retryCode2 = fingerprint;
                isolatedApp2 = isolatedApp;
                redirect2 = redirect;
                initialResponse5 = initialResponse2;
                sessionJson = (JSONObject) $result2;
                if (sessionJson == null) {
                    String str31110 = str8;
                    Log.INSTANCE.d(str31110, "Retrying bypassXD from scratch after session POST failure");
                    Requests app1116 = MainActivityKt.getApp();
                    XDMoviesCFBypassInterceptor xDMoviesCFBypassInterceptor117 = XDMoviesCFBypassInterceptor.INSTANCE;
                    c00023.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                    c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                    c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                    c00023.L$3 = retryBaseUrl;
                    c00023.L$4 = retryCode;
                    c00023.L$5 = retryCode2;
                    c00023.L$6 = baseHeaders2;
                    c00023.L$7 = isolatedApp2;
                    c00023.label = 7;
                    isolatedApp3 = isolatedApp2;
                    fingerprint2 = retryCode2;
                    code2 = retryCode;
                    C00021 c0002119 = c00023;
                    baseUrl2 = retryBaseUrl;
                    obj5 = obj3;
                    baseHeaders4 = baseHeaders2;
                    url9 = url4;
                    obj6 = obj4;
                    str18 = str14;
                    str19 = str31110;
                    str20 = str29;
                    str21 = str28;
                    $result2 = Requests.get$default(app1116, url9, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, xDMoviesCFBypassInterceptor117, false, (ResponseParser) null, c0002119, 3550, (Object) null);
                    c00023 = c0002119;
                    if ($result2 == obj) {
                        return obj;
                    }
                    fingerprint3 = baseUrl2;
                    isolatedApp4 = isolatedApp3;
                    code3 = code2;
                    code4 = url9;
                    redirect3 = redirect2;
                    initialResponse6 = initialResponse5;
                    url10 = fingerprint2;
                    fingerprint4 = null;
                    retryResp = (NiceResponse) $result2;
                    str22 = str20;
                    retryRedirect = retryResp.getHeaders().get(str22);
                    if (retryRedirect == null) {
                        return null;
                    }
                    retryBaseUrl2 = getBaseUrl(retryRedirect);
                    it2 = StringsKt.substringAfterLast$default(retryRedirect, str21, (String) null, 2, (Object) null);
                    if (it2.length() > 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        it2 = null;
                    }
                    if (it2 == null) {
                        return null;
                    }
                    retryCode3 = it2;
                    $this$bypassXD_u24lambda_u246_u241 = MapsKt.toMutableMap(baseHeaders4);
                    $this$bypassXD_u24lambda_u246_u241.put(obj5, retryBaseUrl2);
                    str23 = str18;
                    $this$bypassXD_u24lambda_u246_u241.put(obj6, retryBaseUrl2 + str23 + retryCode3);
                    Result.Companion companion113 = Result.Companion;
                    String str31111 = retryBaseUrl2 + "/api/session";
                    RequestBody requestBodyCreate10 = RequestBody.Companion.create("{\"code\":\"" + retryCode3 + "\",\"fingerprint\":\"" + url10 + "\"}", MediaType.Companion.get("application/json"));
                    c00023.L$0 = SpillingKt.nullOutSpilledVariable(code4);
                    c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse6);
                    c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect3);
                    c00023.L$3 = fingerprint3;
                    c00023.L$4 = code3;
                    c00023.L$5 = url10;
                    c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders4);
                    c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp4);
                    c00023.L$8 = SpillingKt.nullOutSpilledVariable(retryResp);
                    c00023.L$9 = SpillingKt.nullOutSpilledVariable(retryBaseUrl2);
                    c00023.L$10 = SpillingKt.nullOutSpilledVariable(retryRedirect);
                    c00023.L$11 = SpillingKt.nullOutSpilledVariable($this$bypassXD_u24lambda_u246_u241);
                    c00023.L$12 = SpillingKt.nullOutSpilledVariable(retryCode3);
                    c00023.label = 8;
                    code7 = code3;
                    baseUrl4 = fingerprint3;
                    c00022 = c00023;
                    fingerprint6 = url10;
                    str15 = str23;
                    str16 = str22;
                    isolatedApp6 = isolatedApp4;
                    objPost$default = Requests.post$default(isolatedApp6, str31111, $this$bypassXD_u24lambda_u246_u241, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate10, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                    c00023 = c00022;
                    if (objPost$default == obj) {
                        return obj;
                    }
                    isolatedApp5 = isolatedApp6;
                    retryHeaders = $this$bypassXD_u24lambda_u246_u241;
                    str24 = fingerprint4;
                    baseHeaders5 = baseHeaders4;
                    url11 = code4;
                    code5 = code7;
                    retryBaseUrl2 = retryBaseUrl2;
                    fingerprint5 = fingerprint6;
                    code6 = retryCode3;
                    $result2 = objPost$default;
                    initialResponse7 = initialResponse6;
                    baseUrl3 = baseUrl4;
                    obj7 = Result.constructor-impl((NiceResponse) $result2);
                    isolatedApp2 = isolatedApp5;
                    baseHeaders3 = baseHeaders5;
                    initialResponse5 = initialResponse7;
                    url4 = url11;
                    retryCode2 = fingerprint5;
                    retryBaseUrl = baseUrl3;
                    if (Result.exceptionOrNull-impl(obj7) != null) {
                        return null;
                    }
                    retrySessionResp = (NiceResponse) obj7;
                    if (retrySessionResp.getCode() == 400) {
                        Log.INSTANCE.e(str19, "Retry session POST also got 400 — giving up");
                        return null;
                    }
                    str17 = str19;
                    Result.Companion companion114 = Result.Companion;
                    obj8 = Result.constructor-impl(new JSONObject(retrySessionResp.getText()));
                    if (Result.exceptionOrNull-impl(obj8) != null) {
                        return null;
                    }
                    sessionJson = (JSONObject) obj8;
                    retryCode = code5;
                    redirect2 = redirect3;
                } else {
                    str15 = str14;
                    str16 = str29;
                    str17 = str8;
                    baseHeaders3 = baseHeaders2;
                }
                sessionId = sessionJson.optString("sessionId");
                if (sessionId.length() > 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (!z3) {
                    sessionId = null;
                }
                if (sessionId == null) {
                    return null;
                }
                CoroutineContext main11 = Dispatchers.getMain();
                ExtractorKt$bypassXD$resultUrl$1 extractorKt$bypassXD$resultUrl$11 = new ExtractorKt$bypassXD$resultUrl$1(retryBaseUrl, sessionId, retryCode2, null);
                c00023.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                c00023.L$3 = retryBaseUrl;
                c00023.L$4 = retryCode;
                c00023.L$5 = SpillingKt.nullOutSpilledVariable(retryCode2);
                c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders3);
                c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp2);
                c00023.L$8 = SpillingKt.nullOutSpilledVariable(sessionJson);
                c00023.L$9 = sessionId;
                c00023.L$10 = null;
                c00023.L$11 = null;
                c00023.L$12 = null;
                c00023.label = 9;
                objWithContext = BuildersKt.withContext(main11, extractorKt$bypassXD$resultUrl$11, c00023);
                if (objWithContext == obj) {
                    return obj;
                }
                sessionJson2 = sessionJson;
                baseHeaders6 = baseHeaders3;
                isolatedApp7 = isolatedApp2;
                fingerprint7 = retryCode2;
                code8 = retryCode;
                $result2 = objWithContext;
                baseUrl5 = retryBaseUrl;
                sessionId2 = sessionId;
                sessionId3 = url4;
                resultUrl = (String) $result2;
                if (resultUrl == null) {
                    return null;
                }
                Log.INSTANCE.d(str17, "Intercepted URL: " + resultUrl);
                if (StringsKt.startsWith$default(resultUrl, "COMPLETE:", false, 2, (Object) null)) {
                    String completeToken11 = StringsKt.substringAfter$default(resultUrl, "COMPLETE:", (String) null, 2, (Object) null);
                    String finalResultUrl113 = baseUrl5 + str + sessionId2 + "?t=" + completeToken11;
                    finalResultUrl2 = sessionId3;
                    resultUrl2 = resultUrl;
                    baseUrl6 = baseUrl5;
                    step2Url = sessionId2;
                    code9 = code8;
                    finalResultUrl = finalResultUrl113;
                    baseUrl7 = str16;
                } else {
                    str25 = str;
                    if (Intrinsics.areEqual(resultUrl, "COMPLETE")) {
                        step2Url2 = baseUrl5 + str15 + code8 + "?step=2&sid=" + sessionId2;
                        Requests app1117 = MainActivityKt.getApp();
                        c00023.L$0 = SpillingKt.nullOutSpilledVariable(sessionId3);
                        c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                        c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                        c00023.L$3 = SpillingKt.nullOutSpilledVariable(baseUrl5);
                        c00023.L$4 = SpillingKt.nullOutSpilledVariable(code8);
                        c00023.L$5 = SpillingKt.nullOutSpilledVariable(fingerprint7);
                        c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders6);
                        c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp7);
                        c00023.L$8 = SpillingKt.nullOutSpilledVariable(sessionJson2);
                        c00023.L$9 = sessionId2;
                        c00023.L$10 = SpillingKt.nullOutSpilledVariable(resultUrl);
                        c00023.L$11 = SpillingKt.nullOutSpilledVariable(resultUrl);
                        c00023.L$12 = step2Url2;
                        c00023.label = 10;
                        sessionId4 = sessionId2;
                        code10 = code8;
                        C00021 c00021110 = c00023;
                        baseUrl8 = baseUrl5;
                        str = str25;
                        obj9 = Requests.get$default(app1117, step2Url2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00021110, 4062, (Object) null);
                        c00023 = c00021110;
                        if (obj9 == obj) {
                            return obj;
                        }
                        $result = sessionId3;
                        url12 = step2Url2;
                        obj10 = obj9;
                        sessionJson3 = sessionJson2;
                        redirect4 = redirect2;
                        initialResponse8 = initialResponse5;
                        isolatedApp8 = isolatedApp7;
                        baseHeaders7 = baseHeaders6;
                        fingerprint8 = fingerprint7;
                        baseUrl9 = baseUrl8;
                        resultUrl3 = resultUrl;
                        sessionId5 = sessionId4;
                        code11 = code10;
                        NiceResponse step2Resp11 = (NiceResponse) obj10;
                        String baseUrl110 = baseUrl9;
                        baseUrl7 = str16;
                        str27 = step2Resp11.getHeaders().get(baseUrl7);
                        if (str27 == null) {
                            str27 = url12;
                        }
                        String finalResultUrl114 = str27;
                        baseUrl6 = baseUrl110;
                        finalResultUrl2 = $result;
                        redirect2 = redirect4;
                        finalResultUrl = finalResultUrl114;
                        resultUrl2 = resultUrl3;
                        step2Url = sessionId5;
                        sessionJson2 = sessionJson3;
                        isolatedApp7 = isolatedApp8;
                        baseHeaders6 = baseHeaders7;
                        fingerprint7 = fingerprint8;
                        code9 = code11;
                        initialResponse5 = initialResponse8;
                    } else {
                        resultUrl2 = resultUrl;
                        baseUrl6 = baseUrl5;
                        code9 = code8;
                        str = str25;
                        baseUrl7 = str16;
                        finalResultUrl = resultUrl;
                        finalResultUrl2 = sessionId3;
                        step2Url = sessionId2;
                    }
                }
                if (!StringsKt.contains(finalResultUrl, str, true)) {
                    return finalResultUrl;
                }
                Requests app1118 = MainActivityKt.getApp();
                Map mapMapOf11 = MapsKt.mapOf(TuplesKt.to("Cookie", "sid=" + step2Url));
                XDMoviesCFBypassInterceptor xDMoviesCFBypassInterceptor118 = XDMoviesCFBypassInterceptor.INSTANCE;
                c00023.L$0 = SpillingKt.nullOutSpilledVariable(finalResultUrl2);
                c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                c00023.L$3 = SpillingKt.nullOutSpilledVariable(baseUrl6);
                c00023.L$4 = SpillingKt.nullOutSpilledVariable(code9);
                c00023.L$5 = SpillingKt.nullOutSpilledVariable(fingerprint7);
                c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders6);
                c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp7);
                c00023.L$8 = SpillingKt.nullOutSpilledVariable(sessionJson2);
                c00023.L$9 = SpillingKt.nullOutSpilledVariable(step2Url);
                c00023.L$10 = SpillingKt.nullOutSpilledVariable(resultUrl2);
                c00023.L$11 = SpillingKt.nullOutSpilledVariable(finalResultUrl);
                c00023.L$12 = null;
                c00023.label = 11;
                str26 = baseUrl7;
                $result2 = Requests.get$default(app1118, finalResultUrl, mapMapOf11, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, xDMoviesCFBypassInterceptor118, false, (ResponseParser) null, c00023, 3548, (Object) null);
                if ($result2 == obj) {
                    return obj;
                }
                return ((NiceResponse) $result2).getHeaders().get(str26);
            case 6:
                Requests isolatedApp9 = (Requests) c00023.L$7;
                Map baseHeaders8 = (Map) c00023.L$6;
                retryCode2 = (String) c00023.L$5;
                retryCode = (String) c00023.L$4;
                String baseUrl20 = (String) c00023.L$3;
                String redirect5 = (String) c00023.L$2;
                NiceResponse initialResponse11 = (NiceResponse) c00023.L$1;
                url4 = (String) c00023.L$0;
                ResultKt.throwOnFailure($result2);
                obj = coroutine_suspended;
                baseHeaders2 = baseHeaders8;
                str = "/go/";
                retryBaseUrl = baseUrl20;
                str14 = "/r/";
                str8 = "XDMovies";
                obj3 = "Origin";
                isolatedApp2 = isolatedApp9;
                obj4 = obj11;
                initialResponse5 = initialResponse11;
                redirect2 = redirect5;
                sessionJson = (JSONObject) $result2;
                if (sessionJson == null) {
                    String str31112 = str8;
                    Log.INSTANCE.d(str31112, "Retrying bypassXD from scratch after session POST failure");
                    Requests app1119 = MainActivityKt.getApp();
                    XDMoviesCFBypassInterceptor xDMoviesCFBypassInterceptor119 = XDMoviesCFBypassInterceptor.INSTANCE;
                    c00023.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                    c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                    c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                    c00023.L$3 = retryBaseUrl;
                    c00023.L$4 = retryCode;
                    c00023.L$5 = retryCode2;
                    c00023.L$6 = baseHeaders2;
                    c00023.L$7 = isolatedApp2;
                    c00023.label = 7;
                    isolatedApp3 = isolatedApp2;
                    fingerprint2 = retryCode2;
                    code2 = retryCode;
                    C00021 c00021111 = c00023;
                    baseUrl2 = retryBaseUrl;
                    obj5 = obj3;
                    baseHeaders4 = baseHeaders2;
                    url9 = url4;
                    obj6 = obj4;
                    str18 = str14;
                    str19 = str31112;
                    str20 = str29;
                    str21 = str28;
                    $result2 = Requests.get$default(app1119, url9, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, xDMoviesCFBypassInterceptor119, false, (ResponseParser) null, c00021111, 3550, (Object) null);
                    c00023 = c00021111;
                    if ($result2 == obj) {
                        return obj;
                    }
                    fingerprint3 = baseUrl2;
                    isolatedApp4 = isolatedApp3;
                    code3 = code2;
                    code4 = url9;
                    redirect3 = redirect2;
                    initialResponse6 = initialResponse5;
                    url10 = fingerprint2;
                    fingerprint4 = null;
                    retryResp = (NiceResponse) $result2;
                    str22 = str20;
                    retryRedirect = retryResp.getHeaders().get(str22);
                    if (retryRedirect == null) {
                        return null;
                    }
                    retryBaseUrl2 = getBaseUrl(retryRedirect);
                    it2 = StringsKt.substringAfterLast$default(retryRedirect, str21, (String) null, 2, (Object) null);
                    if (it2.length() > 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        it2 = null;
                    }
                    if (it2 == null) {
                        return null;
                    }
                    retryCode3 = it2;
                    $this$bypassXD_u24lambda_u246_u241 = MapsKt.toMutableMap(baseHeaders4);
                    $this$bypassXD_u24lambda_u246_u241.put(obj5, retryBaseUrl2);
                    str23 = str18;
                    $this$bypassXD_u24lambda_u246_u241.put(obj6, retryBaseUrl2 + str23 + retryCode3);
                    Result.Companion companion115 = Result.Companion;
                    String str31113 = retryBaseUrl2 + "/api/session";
                    RequestBody requestBodyCreate11 = RequestBody.Companion.create("{\"code\":\"" + retryCode3 + "\",\"fingerprint\":\"" + url10 + "\"}", MediaType.Companion.get("application/json"));
                    c00023.L$0 = SpillingKt.nullOutSpilledVariable(code4);
                    c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse6);
                    c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect3);
                    c00023.L$3 = fingerprint3;
                    c00023.L$4 = code3;
                    c00023.L$5 = url10;
                    c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders4);
                    c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp4);
                    c00023.L$8 = SpillingKt.nullOutSpilledVariable(retryResp);
                    c00023.L$9 = SpillingKt.nullOutSpilledVariable(retryBaseUrl2);
                    c00023.L$10 = SpillingKt.nullOutSpilledVariable(retryRedirect);
                    c00023.L$11 = SpillingKt.nullOutSpilledVariable($this$bypassXD_u24lambda_u246_u241);
                    c00023.L$12 = SpillingKt.nullOutSpilledVariable(retryCode3);
                    c00023.label = 8;
                    code7 = code3;
                    baseUrl4 = fingerprint3;
                    c00022 = c00023;
                    fingerprint6 = url10;
                    str15 = str23;
                    str16 = str22;
                    isolatedApp6 = isolatedApp4;
                    objPost$default = Requests.post$default(isolatedApp6, str31113, $this$bypassXD_u24lambda_u246_u241, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate11, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                    c00023 = c00022;
                    if (objPost$default == obj) {
                        return obj;
                    }
                    isolatedApp5 = isolatedApp6;
                    retryHeaders = $this$bypassXD_u24lambda_u246_u241;
                    str24 = fingerprint4;
                    baseHeaders5 = baseHeaders4;
                    url11 = code4;
                    code5 = code7;
                    retryBaseUrl2 = retryBaseUrl2;
                    fingerprint5 = fingerprint6;
                    code6 = retryCode3;
                    $result2 = objPost$default;
                    initialResponse7 = initialResponse6;
                    baseUrl3 = baseUrl4;
                    obj7 = Result.constructor-impl((NiceResponse) $result2);
                    isolatedApp2 = isolatedApp5;
                    baseHeaders3 = baseHeaders5;
                    initialResponse5 = initialResponse7;
                    url4 = url11;
                    retryCode2 = fingerprint5;
                    retryBaseUrl = baseUrl3;
                    if (Result.exceptionOrNull-impl(obj7) != null) {
                        return null;
                    }
                    retrySessionResp = (NiceResponse) obj7;
                    if (retrySessionResp.getCode() == 400) {
                        Log.INSTANCE.e(str19, "Retry session POST also got 400 — giving up");
                        return null;
                    }
                    str17 = str19;
                    Result.Companion companion116 = Result.Companion;
                    obj8 = Result.constructor-impl(new JSONObject(retrySessionResp.getText()));
                    if (Result.exceptionOrNull-impl(obj8) != null) {
                        return null;
                    }
                    sessionJson = (JSONObject) obj8;
                    retryCode = code5;
                    redirect2 = redirect3;
                } else {
                    str15 = str14;
                    str16 = str29;
                    str17 = str8;
                    baseHeaders3 = baseHeaders2;
                }
                sessionId = sessionJson.optString("sessionId");
                if (sessionId.length() > 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (!z3) {
                    sessionId = null;
                }
                if (sessionId == null) {
                    return null;
                }
                CoroutineContext main12 = Dispatchers.getMain();
                ExtractorKt$bypassXD$resultUrl$1 extractorKt$bypassXD$resultUrl$12 = new ExtractorKt$bypassXD$resultUrl$1(retryBaseUrl, sessionId, retryCode2, null);
                c00023.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                c00023.L$3 = retryBaseUrl;
                c00023.L$4 = retryCode;
                c00023.L$5 = SpillingKt.nullOutSpilledVariable(retryCode2);
                c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders3);
                c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp2);
                c00023.L$8 = SpillingKt.nullOutSpilledVariable(sessionJson);
                c00023.L$9 = sessionId;
                c00023.L$10 = null;
                c00023.L$11 = null;
                c00023.L$12 = null;
                c00023.label = 9;
                objWithContext = BuildersKt.withContext(main12, extractorKt$bypassXD$resultUrl$12, c00023);
                if (objWithContext == obj) {
                    return obj;
                }
                sessionJson2 = sessionJson;
                baseHeaders6 = baseHeaders3;
                isolatedApp7 = isolatedApp2;
                fingerprint7 = retryCode2;
                code8 = retryCode;
                $result2 = objWithContext;
                baseUrl5 = retryBaseUrl;
                sessionId2 = sessionId;
                sessionId3 = url4;
                resultUrl = (String) $result2;
                if (resultUrl == null) {
                    return null;
                }
                Log.INSTANCE.d(str17, "Intercepted URL: " + resultUrl);
                if (StringsKt.startsWith$default(resultUrl, "COMPLETE:", false, 2, (Object) null)) {
                    String completeToken12 = StringsKt.substringAfter$default(resultUrl, "COMPLETE:", (String) null, 2, (Object) null);
                    String finalResultUrl115 = baseUrl5 + str + sessionId2 + "?t=" + completeToken12;
                    finalResultUrl2 = sessionId3;
                    resultUrl2 = resultUrl;
                    baseUrl6 = baseUrl5;
                    step2Url = sessionId2;
                    code9 = code8;
                    finalResultUrl = finalResultUrl115;
                    baseUrl7 = str16;
                } else {
                    str25 = str;
                    if (Intrinsics.areEqual(resultUrl, "COMPLETE")) {
                        step2Url2 = baseUrl5 + str15 + code8 + "?step=2&sid=" + sessionId2;
                        Requests app11110 = MainActivityKt.getApp();
                        c00023.L$0 = SpillingKt.nullOutSpilledVariable(sessionId3);
                        c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                        c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                        c00023.L$3 = SpillingKt.nullOutSpilledVariable(baseUrl5);
                        c00023.L$4 = SpillingKt.nullOutSpilledVariable(code8);
                        c00023.L$5 = SpillingKt.nullOutSpilledVariable(fingerprint7);
                        c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders6);
                        c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp7);
                        c00023.L$8 = SpillingKt.nullOutSpilledVariable(sessionJson2);
                        c00023.L$9 = sessionId2;
                        c00023.L$10 = SpillingKt.nullOutSpilledVariable(resultUrl);
                        c00023.L$11 = SpillingKt.nullOutSpilledVariable(resultUrl);
                        c00023.L$12 = step2Url2;
                        c00023.label = 10;
                        sessionId4 = sessionId2;
                        code10 = code8;
                        C00021 c00021112 = c00023;
                        baseUrl8 = baseUrl5;
                        str = str25;
                        obj9 = Requests.get$default(app11110, step2Url2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00021112, 4062, (Object) null);
                        c00023 = c00021112;
                        if (obj9 == obj) {
                            return obj;
                        }
                        $result = sessionId3;
                        url12 = step2Url2;
                        obj10 = obj9;
                        sessionJson3 = sessionJson2;
                        redirect4 = redirect2;
                        initialResponse8 = initialResponse5;
                        isolatedApp8 = isolatedApp7;
                        baseHeaders7 = baseHeaders6;
                        fingerprint8 = fingerprint7;
                        baseUrl9 = baseUrl8;
                        resultUrl3 = resultUrl;
                        sessionId5 = sessionId4;
                        code11 = code10;
                        NiceResponse step2Resp12 = (NiceResponse) obj10;
                        String baseUrl111 = baseUrl9;
                        baseUrl7 = str16;
                        str27 = step2Resp12.getHeaders().get(baseUrl7);
                        if (str27 == null) {
                            str27 = url12;
                        }
                        String finalResultUrl116 = str27;
                        baseUrl6 = baseUrl111;
                        finalResultUrl2 = $result;
                        redirect2 = redirect4;
                        finalResultUrl = finalResultUrl116;
                        resultUrl2 = resultUrl3;
                        step2Url = sessionId5;
                        sessionJson2 = sessionJson3;
                        isolatedApp7 = isolatedApp8;
                        baseHeaders6 = baseHeaders7;
                        fingerprint7 = fingerprint8;
                        code9 = code11;
                        initialResponse5 = initialResponse8;
                    } else {
                        resultUrl2 = resultUrl;
                        baseUrl6 = baseUrl5;
                        code9 = code8;
                        str = str25;
                        baseUrl7 = str16;
                        finalResultUrl = resultUrl;
                        finalResultUrl2 = sessionId3;
                        step2Url = sessionId2;
                    }
                }
                if (!StringsKt.contains(finalResultUrl, str, true)) {
                    return finalResultUrl;
                }
                Requests app11111 = MainActivityKt.getApp();
                Map mapMapOf12 = MapsKt.mapOf(TuplesKt.to("Cookie", "sid=" + step2Url));
                XDMoviesCFBypassInterceptor xDMoviesCFBypassInterceptor1110 = XDMoviesCFBypassInterceptor.INSTANCE;
                c00023.L$0 = SpillingKt.nullOutSpilledVariable(finalResultUrl2);
                c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                c00023.L$3 = SpillingKt.nullOutSpilledVariable(baseUrl6);
                c00023.L$4 = SpillingKt.nullOutSpilledVariable(code9);
                c00023.L$5 = SpillingKt.nullOutSpilledVariable(fingerprint7);
                c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders6);
                c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp7);
                c00023.L$8 = SpillingKt.nullOutSpilledVariable(sessionJson2);
                c00023.L$9 = SpillingKt.nullOutSpilledVariable(step2Url);
                c00023.L$10 = SpillingKt.nullOutSpilledVariable(resultUrl2);
                c00023.L$11 = SpillingKt.nullOutSpilledVariable(finalResultUrl);
                c00023.L$12 = null;
                c00023.label = 11;
                str26 = baseUrl7;
                $result2 = Requests.get$default(app11111, finalResultUrl, mapMapOf12, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, xDMoviesCFBypassInterceptor1110, false, (ResponseParser) null, c00023, 3548, (Object) null);
                if ($result2 == obj) {
                    return obj;
                }
                return ((NiceResponse) $result2).getHeaders().get(str26);
            case 7:
                isolatedApp4 = (Requests) c00023.L$7;
                Map baseHeaders9 = (Map) c00023.L$6;
                String fingerprint9 = (String) c00023.L$5;
                String code12 = (String) c00023.L$4;
                String baseUrl21 = (String) c00023.L$3;
                String redirect6 = (String) c00023.L$2;
                NiceResponse initialResponse12 = (NiceResponse) c00023.L$1;
                String url16 = (String) c00023.L$0;
                ResultKt.throwOnFailure($result2);
                fingerprint4 = null;
                obj = coroutine_suspended;
                baseHeaders4 = baseHeaders9;
                url10 = fingerprint9;
                str = "/go/";
                str21 = "/";
                code3 = code12;
                fingerprint3 = baseUrl21;
                redirect3 = redirect6;
                initialResponse6 = initialResponse12;
                str18 = "/r/";
                code4 = url16;
                obj6 = obj11;
                str19 = "XDMovies";
                str20 = str29;
                obj5 = "Origin";
                retryResp = (NiceResponse) $result2;
                str22 = str20;
                retryRedirect = retryResp.getHeaders().get(str22);
                if (retryRedirect == null) {
                    return null;
                }
                retryBaseUrl2 = getBaseUrl(retryRedirect);
                it2 = StringsKt.substringAfterLast$default(retryRedirect, str21, (String) null, 2, (Object) null);
                if (it2.length() > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    it2 = null;
                }
                if (it2 == null) {
                    return null;
                }
                retryCode3 = it2;
                $this$bypassXD_u24lambda_u246_u241 = MapsKt.toMutableMap(baseHeaders4);
                $this$bypassXD_u24lambda_u246_u241.put(obj5, retryBaseUrl2);
                str23 = str18;
                $this$bypassXD_u24lambda_u246_u241.put(obj6, retryBaseUrl2 + str23 + retryCode3);
                Result.Companion companion117 = Result.Companion;
                String str31114 = retryBaseUrl2 + "/api/session";
                RequestBody requestBodyCreate12 = RequestBody.Companion.create("{\"code\":\"" + retryCode3 + "\",\"fingerprint\":\"" + url10 + "\"}", MediaType.Companion.get("application/json"));
                c00023.L$0 = SpillingKt.nullOutSpilledVariable(code4);
                c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse6);
                c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect3);
                c00023.L$3 = fingerprint3;
                c00023.L$4 = code3;
                c00023.L$5 = url10;
                c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders4);
                c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp4);
                c00023.L$8 = SpillingKt.nullOutSpilledVariable(retryResp);
                c00023.L$9 = SpillingKt.nullOutSpilledVariable(retryBaseUrl2);
                c00023.L$10 = SpillingKt.nullOutSpilledVariable(retryRedirect);
                c00023.L$11 = SpillingKt.nullOutSpilledVariable($this$bypassXD_u24lambda_u246_u241);
                c00023.L$12 = SpillingKt.nullOutSpilledVariable(retryCode3);
                c00023.label = 8;
                code7 = code3;
                baseUrl4 = fingerprint3;
                c00022 = c00023;
                fingerprint6 = url10;
                str15 = str23;
                str16 = str22;
                isolatedApp6 = isolatedApp4;
                objPost$default = Requests.post$default(isolatedApp6, str31114, $this$bypassXD_u24lambda_u246_u241, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate12, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                c00023 = c00022;
                if (objPost$default == obj) {
                    return obj;
                }
                isolatedApp5 = isolatedApp6;
                retryHeaders = $this$bypassXD_u24lambda_u246_u241;
                str24 = fingerprint4;
                baseHeaders5 = baseHeaders4;
                url11 = code4;
                code5 = code7;
                retryBaseUrl2 = retryBaseUrl2;
                fingerprint5 = fingerprint6;
                code6 = retryCode3;
                $result2 = objPost$default;
                initialResponse7 = initialResponse6;
                baseUrl3 = baseUrl4;
                obj7 = Result.constructor-impl((NiceResponse) $result2);
                isolatedApp2 = isolatedApp5;
                baseHeaders3 = baseHeaders5;
                initialResponse5 = initialResponse7;
                url4 = url11;
                retryCode2 = fingerprint5;
                retryBaseUrl = baseUrl3;
                if (Result.exceptionOrNull-impl(obj7) != null) {
                    return null;
                }
                retrySessionResp = (NiceResponse) obj7;
                if (retrySessionResp.getCode() == 400) {
                    Log.INSTANCE.e(str19, "Retry session POST also got 400 — giving up");
                    return null;
                }
                str17 = str19;
                Result.Companion companion118 = Result.Companion;
                obj8 = Result.constructor-impl(new JSONObject(retrySessionResp.getText()));
                if (Result.exceptionOrNull-impl(obj8) != null) {
                    return null;
                }
                sessionJson = (JSONObject) obj8;
                retryCode = code5;
                redirect2 = redirect3;
                sessionId = sessionJson.optString("sessionId");
                if (sessionId.length() > 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (!z3) {
                    sessionId = null;
                }
                if (sessionId == null) {
                    return null;
                }
                CoroutineContext main13 = Dispatchers.getMain();
                ExtractorKt$bypassXD$resultUrl$1 extractorKt$bypassXD$resultUrl$13 = new ExtractorKt$bypassXD$resultUrl$1(retryBaseUrl, sessionId, retryCode2, null);
                c00023.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                c00023.L$3 = retryBaseUrl;
                c00023.L$4 = retryCode;
                c00023.L$5 = SpillingKt.nullOutSpilledVariable(retryCode2);
                c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders3);
                c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp2);
                c00023.L$8 = SpillingKt.nullOutSpilledVariable(sessionJson);
                c00023.L$9 = sessionId;
                c00023.L$10 = null;
                c00023.L$11 = null;
                c00023.L$12 = null;
                c00023.label = 9;
                objWithContext = BuildersKt.withContext(main13, extractorKt$bypassXD$resultUrl$13, c00023);
                if (objWithContext == obj) {
                    return obj;
                }
                sessionJson2 = sessionJson;
                baseHeaders6 = baseHeaders3;
                isolatedApp7 = isolatedApp2;
                fingerprint7 = retryCode2;
                code8 = retryCode;
                $result2 = objWithContext;
                baseUrl5 = retryBaseUrl;
                sessionId2 = sessionId;
                sessionId3 = url4;
                resultUrl = (String) $result2;
                if (resultUrl == null) {
                    return null;
                }
                Log.INSTANCE.d(str17, "Intercepted URL: " + resultUrl);
                if (StringsKt.startsWith$default(resultUrl, "COMPLETE:", false, 2, (Object) null)) {
                    String completeToken13 = StringsKt.substringAfter$default(resultUrl, "COMPLETE:", (String) null, 2, (Object) null);
                    String finalResultUrl117 = baseUrl5 + str + sessionId2 + "?t=" + completeToken13;
                    finalResultUrl2 = sessionId3;
                    resultUrl2 = resultUrl;
                    baseUrl6 = baseUrl5;
                    step2Url = sessionId2;
                    code9 = code8;
                    finalResultUrl = finalResultUrl117;
                    baseUrl7 = str16;
                } else {
                    str25 = str;
                    if (Intrinsics.areEqual(resultUrl, "COMPLETE")) {
                        step2Url2 = baseUrl5 + str15 + code8 + "?step=2&sid=" + sessionId2;
                        Requests app11112 = MainActivityKt.getApp();
                        c00023.L$0 = SpillingKt.nullOutSpilledVariable(sessionId3);
                        c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                        c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                        c00023.L$3 = SpillingKt.nullOutSpilledVariable(baseUrl5);
                        c00023.L$4 = SpillingKt.nullOutSpilledVariable(code8);
                        c00023.L$5 = SpillingKt.nullOutSpilledVariable(fingerprint7);
                        c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders6);
                        c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp7);
                        c00023.L$8 = SpillingKt.nullOutSpilledVariable(sessionJson2);
                        c00023.L$9 = sessionId2;
                        c00023.L$10 = SpillingKt.nullOutSpilledVariable(resultUrl);
                        c00023.L$11 = SpillingKt.nullOutSpilledVariable(resultUrl);
                        c00023.L$12 = step2Url2;
                        c00023.label = 10;
                        sessionId4 = sessionId2;
                        code10 = code8;
                        C00021 c00021113 = c00023;
                        baseUrl8 = baseUrl5;
                        str = str25;
                        obj9 = Requests.get$default(app11112, step2Url2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00021113, 4062, (Object) null);
                        c00023 = c00021113;
                        if (obj9 == obj) {
                            return obj;
                        }
                        $result = sessionId3;
                        url12 = step2Url2;
                        obj10 = obj9;
                        sessionJson3 = sessionJson2;
                        redirect4 = redirect2;
                        initialResponse8 = initialResponse5;
                        isolatedApp8 = isolatedApp7;
                        baseHeaders7 = baseHeaders6;
                        fingerprint8 = fingerprint7;
                        baseUrl9 = baseUrl8;
                        resultUrl3 = resultUrl;
                        sessionId5 = sessionId4;
                        code11 = code10;
                        NiceResponse step2Resp13 = (NiceResponse) obj10;
                        String baseUrl112 = baseUrl9;
                        baseUrl7 = str16;
                        str27 = step2Resp13.getHeaders().get(baseUrl7);
                        if (str27 == null) {
                            str27 = url12;
                        }
                        String finalResultUrl118 = str27;
                        baseUrl6 = baseUrl112;
                        finalResultUrl2 = $result;
                        redirect2 = redirect4;
                        finalResultUrl = finalResultUrl118;
                        resultUrl2 = resultUrl3;
                        step2Url = sessionId5;
                        sessionJson2 = sessionJson3;
                        isolatedApp7 = isolatedApp8;
                        baseHeaders6 = baseHeaders7;
                        fingerprint7 = fingerprint8;
                        code9 = code11;
                        initialResponse5 = initialResponse8;
                    } else {
                        resultUrl2 = resultUrl;
                        baseUrl6 = baseUrl5;
                        code9 = code8;
                        str = str25;
                        baseUrl7 = str16;
                        finalResultUrl = resultUrl;
                        finalResultUrl2 = sessionId3;
                        step2Url = sessionId2;
                    }
                }
                if (!StringsKt.contains(finalResultUrl, str, true)) {
                    return finalResultUrl;
                }
                Requests app11113 = MainActivityKt.getApp();
                Map mapMapOf13 = MapsKt.mapOf(TuplesKt.to("Cookie", "sid=" + step2Url));
                XDMoviesCFBypassInterceptor xDMoviesCFBypassInterceptor1111 = XDMoviesCFBypassInterceptor.INSTANCE;
                c00023.L$0 = SpillingKt.nullOutSpilledVariable(finalResultUrl2);
                c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                c00023.L$3 = SpillingKt.nullOutSpilledVariable(baseUrl6);
                c00023.L$4 = SpillingKt.nullOutSpilledVariable(code9);
                c00023.L$5 = SpillingKt.nullOutSpilledVariable(fingerprint7);
                c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders6);
                c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp7);
                c00023.L$8 = SpillingKt.nullOutSpilledVariable(sessionJson2);
                c00023.L$9 = SpillingKt.nullOutSpilledVariable(step2Url);
                c00023.L$10 = SpillingKt.nullOutSpilledVariable(resultUrl2);
                c00023.L$11 = SpillingKt.nullOutSpilledVariable(finalResultUrl);
                c00023.L$12 = null;
                c00023.label = 11;
                str26 = baseUrl7;
                $result2 = Requests.get$default(app11113, finalResultUrl, mapMapOf13, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, xDMoviesCFBypassInterceptor1111, false, (ResponseParser) null, c00023, 3548, (Object) null);
                if ($result2 == obj) {
                    return obj;
                }
                return ((NiceResponse) $result2).getHeaders().get(str26);
            case 8:
                str24 = null;
                code6 = (String) c00023.L$12;
                retryHeaders = (Map) c00023.L$11;
                retryBaseUrl2 = (String) c00023.L$9;
                isolatedApp5 = (Requests) c00023.L$7;
                baseHeaders5 = (Map) c00023.L$6;
                fingerprint5 = (String) c00023.L$5;
                code5 = (String) c00023.L$4;
                baseUrl3 = (String) c00023.L$3;
                redirect3 = (String) c00023.L$2;
                initialResponse7 = (NiceResponse) c00023.L$1;
                url11 = (String) c00023.L$0;
                try {
                    ResultKt.throwOnFailure($result2);
                    obj = coroutine_suspended;
                    str = "/go/";
                    str15 = "/r/";
                    str19 = "XDMovies";
                    str16 = str29;
                    obj7 = Result.constructor-impl((NiceResponse) $result2);
                    break;
                } catch (Throwable th7) {
                    th = th7;
                    obj = coroutine_suspended;
                    str = "/go/";
                    str15 = "/r/";
                    str19 = "XDMovies";
                    str16 = str29;
                    Result.Companion companion20 = Result.Companion;
                    obj7 = Result.constructor-impl(ResultKt.createFailure(th));
                    isolatedApp2 = isolatedApp5;
                    baseHeaders3 = baseHeaders5;
                    initialResponse5 = initialResponse7;
                    url4 = url11;
                    retryCode2 = fingerprint5;
                    retryBaseUrl = baseUrl3;
                    if (Result.exceptionOrNull-impl(obj7) != null) {
                        return null;
                    }
                    retrySessionResp = (NiceResponse) obj7;
                    if (retrySessionResp.getCode() == 400) {
                        Log.INSTANCE.e(str19, "Retry session POST also got 400 — giving up");
                        return null;
                    }
                    str17 = str19;
                    Result.Companion companion119 = Result.Companion;
                    obj8 = Result.constructor-impl(new JSONObject(retrySessionResp.getText()));
                    if (Result.exceptionOrNull-impl(obj8) != null) {
                        return null;
                    }
                    sessionJson = (JSONObject) obj8;
                    retryCode = code5;
                    redirect2 = redirect3;
                    sessionId = sessionJson.optString("sessionId");
                    if (sessionId.length() > 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (!z3) {
                        sessionId = null;
                    }
                    if (sessionId == null) {
                        return null;
                    }
                    CoroutineContext main14 = Dispatchers.getMain();
                    ExtractorKt$bypassXD$resultUrl$1 extractorKt$bypassXD$resultUrl$14 = new ExtractorKt$bypassXD$resultUrl$1(retryBaseUrl, sessionId, retryCode2, null);
                    c00023.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                    c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                    c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                    c00023.L$3 = retryBaseUrl;
                    c00023.L$4 = retryCode;
                    c00023.L$5 = SpillingKt.nullOutSpilledVariable(retryCode2);
                    c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders3);
                    c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp2);
                    c00023.L$8 = SpillingKt.nullOutSpilledVariable(sessionJson);
                    c00023.L$9 = sessionId;
                    c00023.L$10 = null;
                    c00023.L$11 = null;
                    c00023.L$12 = null;
                    c00023.label = 9;
                    objWithContext = BuildersKt.withContext(main14, extractorKt$bypassXD$resultUrl$14, c00023);
                    if (objWithContext == obj) {
                        return obj;
                    }
                    sessionJson2 = sessionJson;
                    baseHeaders6 = baseHeaders3;
                    isolatedApp7 = isolatedApp2;
                    fingerprint7 = retryCode2;
                    code8 = retryCode;
                    $result2 = objWithContext;
                    baseUrl5 = retryBaseUrl;
                    sessionId2 = sessionId;
                    sessionId3 = url4;
                    resultUrl = (String) $result2;
                    if (resultUrl == null) {
                        return null;
                    }
                    Log.INSTANCE.d(str17, "Intercepted URL: " + resultUrl);
                    if (StringsKt.startsWith$default(resultUrl, "COMPLETE:", false, 2, (Object) null)) {
                        String completeToken14 = StringsKt.substringAfter$default(resultUrl, "COMPLETE:", (String) null, 2, (Object) null);
                        String finalResultUrl119 = baseUrl5 + str + sessionId2 + "?t=" + completeToken14;
                        finalResultUrl2 = sessionId3;
                        resultUrl2 = resultUrl;
                        baseUrl6 = baseUrl5;
                        step2Url = sessionId2;
                        code9 = code8;
                        finalResultUrl = finalResultUrl119;
                        baseUrl7 = str16;
                    } else {
                        str25 = str;
                        if (Intrinsics.areEqual(resultUrl, "COMPLETE")) {
                            step2Url2 = baseUrl5 + str15 + code8 + "?step=2&sid=" + sessionId2;
                            Requests app11114 = MainActivityKt.getApp();
                            c00023.L$0 = SpillingKt.nullOutSpilledVariable(sessionId3);
                            c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                            c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                            c00023.L$3 = SpillingKt.nullOutSpilledVariable(baseUrl5);
                            c00023.L$4 = SpillingKt.nullOutSpilledVariable(code8);
                            c00023.L$5 = SpillingKt.nullOutSpilledVariable(fingerprint7);
                            c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders6);
                            c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp7);
                            c00023.L$8 = SpillingKt.nullOutSpilledVariable(sessionJson2);
                            c00023.L$9 = sessionId2;
                            c00023.L$10 = SpillingKt.nullOutSpilledVariable(resultUrl);
                            c00023.L$11 = SpillingKt.nullOutSpilledVariable(resultUrl);
                            c00023.L$12 = step2Url2;
                            c00023.label = 10;
                            sessionId4 = sessionId2;
                            code10 = code8;
                            C00021 c00021114 = c00023;
                            baseUrl8 = baseUrl5;
                            str = str25;
                            obj9 = Requests.get$default(app11114, step2Url2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00021114, 4062, (Object) null);
                            c00023 = c00021114;
                            if (obj9 == obj) {
                                return obj;
                            }
                            $result = sessionId3;
                            url12 = step2Url2;
                            obj10 = obj9;
                            sessionJson3 = sessionJson2;
                            redirect4 = redirect2;
                            initialResponse8 = initialResponse5;
                            isolatedApp8 = isolatedApp7;
                            baseHeaders7 = baseHeaders6;
                            fingerprint8 = fingerprint7;
                            baseUrl9 = baseUrl8;
                            resultUrl3 = resultUrl;
                            sessionId5 = sessionId4;
                            code11 = code10;
                            NiceResponse step2Resp14 = (NiceResponse) obj10;
                            String baseUrl113 = baseUrl9;
                            baseUrl7 = str16;
                            str27 = step2Resp14.getHeaders().get(baseUrl7);
                            if (str27 == null) {
                                str27 = url12;
                            }
                            String finalResultUrl1110 = str27;
                            baseUrl6 = baseUrl113;
                            finalResultUrl2 = $result;
                            redirect2 = redirect4;
                            finalResultUrl = finalResultUrl1110;
                            resultUrl2 = resultUrl3;
                            step2Url = sessionId5;
                            sessionJson2 = sessionJson3;
                            isolatedApp7 = isolatedApp8;
                            baseHeaders6 = baseHeaders7;
                            fingerprint7 = fingerprint8;
                            code9 = code11;
                            initialResponse5 = initialResponse8;
                        } else {
                            resultUrl2 = resultUrl;
                            baseUrl6 = baseUrl5;
                            code9 = code8;
                            str = str25;
                            baseUrl7 = str16;
                            finalResultUrl = resultUrl;
                            finalResultUrl2 = sessionId3;
                            step2Url = sessionId2;
                        }
                    }
                    if (!StringsKt.contains(finalResultUrl, str, true)) {
                        return finalResultUrl;
                    }
                    Requests app11115 = MainActivityKt.getApp();
                    Map mapMapOf14 = MapsKt.mapOf(TuplesKt.to("Cookie", "sid=" + step2Url));
                    XDMoviesCFBypassInterceptor xDMoviesCFBypassInterceptor1112 = XDMoviesCFBypassInterceptor.INSTANCE;
                    c00023.L$0 = SpillingKt.nullOutSpilledVariable(finalResultUrl2);
                    c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                    c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                    c00023.L$3 = SpillingKt.nullOutSpilledVariable(baseUrl6);
                    c00023.L$4 = SpillingKt.nullOutSpilledVariable(code9);
                    c00023.L$5 = SpillingKt.nullOutSpilledVariable(fingerprint7);
                    c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders6);
                    c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp7);
                    c00023.L$8 = SpillingKt.nullOutSpilledVariable(sessionJson2);
                    c00023.L$9 = SpillingKt.nullOutSpilledVariable(step2Url);
                    c00023.L$10 = SpillingKt.nullOutSpilledVariable(resultUrl2);
                    c00023.L$11 = SpillingKt.nullOutSpilledVariable(finalResultUrl);
                    c00023.L$12 = null;
                    c00023.label = 11;
                    str26 = baseUrl7;
                    $result2 = Requests.get$default(app11115, finalResultUrl, mapMapOf14, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, xDMoviesCFBypassInterceptor1112, false, (ResponseParser) null, c00023, 3548, (Object) null);
                    if ($result2 == obj) {
                        return obj;
                    }
                    return ((NiceResponse) $result2).getHeaders().get(str26);
                }
                isolatedApp2 = isolatedApp5;
                baseHeaders3 = baseHeaders5;
                initialResponse5 = initialResponse7;
                url4 = url11;
                retryCode2 = fingerprint5;
                retryBaseUrl = baseUrl3;
                if (Result.exceptionOrNull-impl(obj7) != null) {
                    return null;
                }
                retrySessionResp = (NiceResponse) obj7;
                if (retrySessionResp.getCode() == 400) {
                    Log.INSTANCE.e(str19, "Retry session POST also got 400 — giving up");
                    return null;
                }
                str17 = str19;
                Result.Companion companion1110 = Result.Companion;
                obj8 = Result.constructor-impl(new JSONObject(retrySessionResp.getText()));
                if (Result.exceptionOrNull-impl(obj8) != null) {
                    return null;
                }
                sessionJson = (JSONObject) obj8;
                retryCode = code5;
                redirect2 = redirect3;
                sessionId = sessionJson.optString("sessionId");
                if (sessionId.length() > 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (!z3) {
                    sessionId = null;
                }
                if (sessionId == null) {
                    return null;
                }
                CoroutineContext main15 = Dispatchers.getMain();
                ExtractorKt$bypassXD$resultUrl$1 extractorKt$bypassXD$resultUrl$15 = new ExtractorKt$bypassXD$resultUrl$1(retryBaseUrl, sessionId, retryCode2, null);
                c00023.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                c00023.L$3 = retryBaseUrl;
                c00023.L$4 = retryCode;
                c00023.L$5 = SpillingKt.nullOutSpilledVariable(retryCode2);
                c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders3);
                c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp2);
                c00023.L$8 = SpillingKt.nullOutSpilledVariable(sessionJson);
                c00023.L$9 = sessionId;
                c00023.L$10 = null;
                c00023.L$11 = null;
                c00023.L$12 = null;
                c00023.label = 9;
                objWithContext = BuildersKt.withContext(main15, extractorKt$bypassXD$resultUrl$15, c00023);
                if (objWithContext == obj) {
                    return obj;
                }
                sessionJson2 = sessionJson;
                baseHeaders6 = baseHeaders3;
                isolatedApp7 = isolatedApp2;
                fingerprint7 = retryCode2;
                code8 = retryCode;
                $result2 = objWithContext;
                baseUrl5 = retryBaseUrl;
                sessionId2 = sessionId;
                sessionId3 = url4;
                resultUrl = (String) $result2;
                if (resultUrl == null) {
                    return null;
                }
                Log.INSTANCE.d(str17, "Intercepted URL: " + resultUrl);
                if (StringsKt.startsWith$default(resultUrl, "COMPLETE:", false, 2, (Object) null)) {
                    String completeToken15 = StringsKt.substringAfter$default(resultUrl, "COMPLETE:", (String) null, 2, (Object) null);
                    String finalResultUrl1111 = baseUrl5 + str + sessionId2 + "?t=" + completeToken15;
                    finalResultUrl2 = sessionId3;
                    resultUrl2 = resultUrl;
                    baseUrl6 = baseUrl5;
                    step2Url = sessionId2;
                    code9 = code8;
                    finalResultUrl = finalResultUrl1111;
                    baseUrl7 = str16;
                } else {
                    str25 = str;
                    if (Intrinsics.areEqual(resultUrl, "COMPLETE")) {
                        step2Url2 = baseUrl5 + str15 + code8 + "?step=2&sid=" + sessionId2;
                        Requests app11116 = MainActivityKt.getApp();
                        c00023.L$0 = SpillingKt.nullOutSpilledVariable(sessionId3);
                        c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                        c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                        c00023.L$3 = SpillingKt.nullOutSpilledVariable(baseUrl5);
                        c00023.L$4 = SpillingKt.nullOutSpilledVariable(code8);
                        c00023.L$5 = SpillingKt.nullOutSpilledVariable(fingerprint7);
                        c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders6);
                        c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp7);
                        c00023.L$8 = SpillingKt.nullOutSpilledVariable(sessionJson2);
                        c00023.L$9 = sessionId2;
                        c00023.L$10 = SpillingKt.nullOutSpilledVariable(resultUrl);
                        c00023.L$11 = SpillingKt.nullOutSpilledVariable(resultUrl);
                        c00023.L$12 = step2Url2;
                        c00023.label = 10;
                        sessionId4 = sessionId2;
                        code10 = code8;
                        C00021 c00021115 = c00023;
                        baseUrl8 = baseUrl5;
                        str = str25;
                        obj9 = Requests.get$default(app11116, step2Url2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00021115, 4062, (Object) null);
                        c00023 = c00021115;
                        if (obj9 == obj) {
                            return obj;
                        }
                        $result = sessionId3;
                        url12 = step2Url2;
                        obj10 = obj9;
                        sessionJson3 = sessionJson2;
                        redirect4 = redirect2;
                        initialResponse8 = initialResponse5;
                        isolatedApp8 = isolatedApp7;
                        baseHeaders7 = baseHeaders6;
                        fingerprint8 = fingerprint7;
                        baseUrl9 = baseUrl8;
                        resultUrl3 = resultUrl;
                        sessionId5 = sessionId4;
                        code11 = code10;
                        NiceResponse step2Resp15 = (NiceResponse) obj10;
                        String baseUrl114 = baseUrl9;
                        baseUrl7 = str16;
                        str27 = step2Resp15.getHeaders().get(baseUrl7);
                        if (str27 == null) {
                            str27 = url12;
                        }
                        String finalResultUrl1112 = str27;
                        baseUrl6 = baseUrl114;
                        finalResultUrl2 = $result;
                        redirect2 = redirect4;
                        finalResultUrl = finalResultUrl1112;
                        resultUrl2 = resultUrl3;
                        step2Url = sessionId5;
                        sessionJson2 = sessionJson3;
                        isolatedApp7 = isolatedApp8;
                        baseHeaders6 = baseHeaders7;
                        fingerprint7 = fingerprint8;
                        code9 = code11;
                        initialResponse5 = initialResponse8;
                    } else {
                        resultUrl2 = resultUrl;
                        baseUrl6 = baseUrl5;
                        code9 = code8;
                        str = str25;
                        baseUrl7 = str16;
                        finalResultUrl = resultUrl;
                        finalResultUrl2 = sessionId3;
                        step2Url = sessionId2;
                    }
                }
                if (!StringsKt.contains(finalResultUrl, str, true)) {
                    return finalResultUrl;
                }
                Requests app11117 = MainActivityKt.getApp();
                Map mapMapOf15 = MapsKt.mapOf(TuplesKt.to("Cookie", "sid=" + step2Url));
                XDMoviesCFBypassInterceptor xDMoviesCFBypassInterceptor1113 = XDMoviesCFBypassInterceptor.INSTANCE;
                c00023.L$0 = SpillingKt.nullOutSpilledVariable(finalResultUrl2);
                c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                c00023.L$3 = SpillingKt.nullOutSpilledVariable(baseUrl6);
                c00023.L$4 = SpillingKt.nullOutSpilledVariable(code9);
                c00023.L$5 = SpillingKt.nullOutSpilledVariable(fingerprint7);
                c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders6);
                c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp7);
                c00023.L$8 = SpillingKt.nullOutSpilledVariable(sessionJson2);
                c00023.L$9 = SpillingKt.nullOutSpilledVariable(step2Url);
                c00023.L$10 = SpillingKt.nullOutSpilledVariable(resultUrl2);
                c00023.L$11 = SpillingKt.nullOutSpilledVariable(finalResultUrl);
                c00023.L$12 = null;
                c00023.label = 11;
                str26 = baseUrl7;
                $result2 = Requests.get$default(app11117, finalResultUrl, mapMapOf15, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, xDMoviesCFBypassInterceptor1113, false, (ResponseParser) null, c00023, 3548, (Object) null);
                if ($result2 == obj) {
                    return obj;
                }
                return ((NiceResponse) $result2).getHeaders().get(str26);
            case 9:
                String sessionId6 = (String) c00023.L$9;
                JSONObject sessionJson4 = (JSONObject) c00023.L$8;
                Requests isolatedApp10 = (Requests) c00023.L$7;
                Map baseHeaders10 = (Map) c00023.L$6;
                String fingerprint10 = (String) c00023.L$5;
                String code13 = (String) c00023.L$4;
                String baseUrl22 = (String) c00023.L$3;
                String redirect7 = (String) c00023.L$2;
                NiceResponse initialResponse13 = (NiceResponse) c00023.L$1;
                Object url17 = (String) c00023.L$0;
                ResultKt.throwOnFailure($result2);
                obj = coroutine_suspended;
                sessionJson2 = sessionJson4;
                isolatedApp7 = isolatedApp10;
                baseHeaders6 = baseHeaders10;
                str = "/go/";
                fingerprint7 = fingerprint10;
                code8 = code13;
                baseUrl5 = baseUrl22;
                redirect2 = redirect7;
                initialResponse5 = initialResponse13;
                str15 = "/r/";
                str17 = "XDMovies";
                str16 = str29;
                sessionId2 = sessionId6;
                sessionId3 = url17;
                resultUrl = (String) $result2;
                if (resultUrl == null) {
                    return null;
                }
                Log.INSTANCE.d(str17, "Intercepted URL: " + resultUrl);
                if (StringsKt.startsWith$default(resultUrl, "COMPLETE:", false, 2, (Object) null)) {
                    String completeToken16 = StringsKt.substringAfter$default(resultUrl, "COMPLETE:", (String) null, 2, (Object) null);
                    String finalResultUrl1113 = baseUrl5 + str + sessionId2 + "?t=" + completeToken16;
                    finalResultUrl2 = sessionId3;
                    resultUrl2 = resultUrl;
                    baseUrl6 = baseUrl5;
                    step2Url = sessionId2;
                    code9 = code8;
                    finalResultUrl = finalResultUrl1113;
                    baseUrl7 = str16;
                } else {
                    str25 = str;
                    if (Intrinsics.areEqual(resultUrl, "COMPLETE")) {
                        step2Url2 = baseUrl5 + str15 + code8 + "?step=2&sid=" + sessionId2;
                        Requests app11118 = MainActivityKt.getApp();
                        c00023.L$0 = SpillingKt.nullOutSpilledVariable(sessionId3);
                        c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                        c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                        c00023.L$3 = SpillingKt.nullOutSpilledVariable(baseUrl5);
                        c00023.L$4 = SpillingKt.nullOutSpilledVariable(code8);
                        c00023.L$5 = SpillingKt.nullOutSpilledVariable(fingerprint7);
                        c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders6);
                        c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp7);
                        c00023.L$8 = SpillingKt.nullOutSpilledVariable(sessionJson2);
                        c00023.L$9 = sessionId2;
                        c00023.L$10 = SpillingKt.nullOutSpilledVariable(resultUrl);
                        c00023.L$11 = SpillingKt.nullOutSpilledVariable(resultUrl);
                        c00023.L$12 = step2Url2;
                        c00023.label = 10;
                        sessionId4 = sessionId2;
                        code10 = code8;
                        C00021 c00021116 = c00023;
                        baseUrl8 = baseUrl5;
                        str = str25;
                        obj9 = Requests.get$default(app11118, step2Url2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00021116, 4062, (Object) null);
                        c00023 = c00021116;
                        if (obj9 == obj) {
                            return obj;
                        }
                        $result = sessionId3;
                        url12 = step2Url2;
                        obj10 = obj9;
                        sessionJson3 = sessionJson2;
                        redirect4 = redirect2;
                        initialResponse8 = initialResponse5;
                        isolatedApp8 = isolatedApp7;
                        baseHeaders7 = baseHeaders6;
                        fingerprint8 = fingerprint7;
                        baseUrl9 = baseUrl8;
                        resultUrl3 = resultUrl;
                        sessionId5 = sessionId4;
                        code11 = code10;
                        NiceResponse step2Resp16 = (NiceResponse) obj10;
                        String baseUrl115 = baseUrl9;
                        baseUrl7 = str16;
                        str27 = step2Resp16.getHeaders().get(baseUrl7);
                        if (str27 == null) {
                            str27 = url12;
                        }
                        String finalResultUrl1114 = str27;
                        baseUrl6 = baseUrl115;
                        finalResultUrl2 = $result;
                        redirect2 = redirect4;
                        finalResultUrl = finalResultUrl1114;
                        resultUrl2 = resultUrl3;
                        step2Url = sessionId5;
                        sessionJson2 = sessionJson3;
                        isolatedApp7 = isolatedApp8;
                        baseHeaders6 = baseHeaders7;
                        fingerprint7 = fingerprint8;
                        code9 = code11;
                        initialResponse5 = initialResponse8;
                    } else {
                        resultUrl2 = resultUrl;
                        baseUrl6 = baseUrl5;
                        code9 = code8;
                        str = str25;
                        baseUrl7 = str16;
                        finalResultUrl = resultUrl;
                        finalResultUrl2 = sessionId3;
                        step2Url = sessionId2;
                    }
                }
                if (!StringsKt.contains(finalResultUrl, str, true)) {
                    return finalResultUrl;
                }
                Requests app11119 = MainActivityKt.getApp();
                Map mapMapOf16 = MapsKt.mapOf(TuplesKt.to("Cookie", "sid=" + step2Url));
                XDMoviesCFBypassInterceptor xDMoviesCFBypassInterceptor1114 = XDMoviesCFBypassInterceptor.INSTANCE;
                c00023.L$0 = SpillingKt.nullOutSpilledVariable(finalResultUrl2);
                c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                c00023.L$3 = SpillingKt.nullOutSpilledVariable(baseUrl6);
                c00023.L$4 = SpillingKt.nullOutSpilledVariable(code9);
                c00023.L$5 = SpillingKt.nullOutSpilledVariable(fingerprint7);
                c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders6);
                c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp7);
                c00023.L$8 = SpillingKt.nullOutSpilledVariable(sessionJson2);
                c00023.L$9 = SpillingKt.nullOutSpilledVariable(step2Url);
                c00023.L$10 = SpillingKt.nullOutSpilledVariable(resultUrl2);
                c00023.L$11 = SpillingKt.nullOutSpilledVariable(finalResultUrl);
                c00023.L$12 = null;
                c00023.label = 11;
                str26 = baseUrl7;
                $result2 = Requests.get$default(app11119, finalResultUrl, mapMapOf16, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, xDMoviesCFBypassInterceptor1114, false, (ResponseParser) null, c00023, 3548, (Object) null);
                if ($result2 == obj) {
                    return obj;
                }
                return ((NiceResponse) $result2).getHeaders().get(str26);
            case 10:
                String step2Url3 = (String) c00023.L$12;
                resultUrl3 = (String) c00023.L$10;
                sessionId5 = (String) c00023.L$9;
                sessionJson3 = (JSONObject) c00023.L$8;
                isolatedApp8 = (Requests) c00023.L$7;
                baseHeaders7 = (Map) c00023.L$6;
                fingerprint8 = (String) c00023.L$5;
                code11 = (String) c00023.L$4;
                baseUrl9 = (String) c00023.L$3;
                redirect4 = (String) c00023.L$2;
                initialResponse8 = (NiceResponse) c00023.L$1;
                Object url18 = (String) c00023.L$0;
                ResultKt.throwOnFailure($result2);
                obj = coroutine_suspended;
                str = "/go/";
                str16 = str29;
                $result = url18;
                obj10 = $result2;
                url12 = step2Url3;
                NiceResponse step2Resp17 = (NiceResponse) obj10;
                String baseUrl116 = baseUrl9;
                baseUrl7 = str16;
                str27 = step2Resp17.getHeaders().get(baseUrl7);
                if (str27 == null) {
                    str27 = url12;
                }
                String finalResultUrl1115 = str27;
                baseUrl6 = baseUrl116;
                finalResultUrl2 = $result;
                redirect2 = redirect4;
                finalResultUrl = finalResultUrl1115;
                resultUrl2 = resultUrl3;
                step2Url = sessionId5;
                sessionJson2 = sessionJson3;
                isolatedApp7 = isolatedApp8;
                baseHeaders6 = baseHeaders7;
                fingerprint7 = fingerprint8;
                code9 = code11;
                initialResponse5 = initialResponse8;
                if (!StringsKt.contains(finalResultUrl, str, true)) {
                    return finalResultUrl;
                }
                Requests app111110 = MainActivityKt.getApp();
                Map mapMapOf17 = MapsKt.mapOf(TuplesKt.to("Cookie", "sid=" + step2Url));
                XDMoviesCFBypassInterceptor xDMoviesCFBypassInterceptor1115 = XDMoviesCFBypassInterceptor.INSTANCE;
                c00023.L$0 = SpillingKt.nullOutSpilledVariable(finalResultUrl2);
                c00023.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse5);
                c00023.L$2 = SpillingKt.nullOutSpilledVariable(redirect2);
                c00023.L$3 = SpillingKt.nullOutSpilledVariable(baseUrl6);
                c00023.L$4 = SpillingKt.nullOutSpilledVariable(code9);
                c00023.L$5 = SpillingKt.nullOutSpilledVariable(fingerprint7);
                c00023.L$6 = SpillingKt.nullOutSpilledVariable(baseHeaders6);
                c00023.L$7 = SpillingKt.nullOutSpilledVariable(isolatedApp7);
                c00023.L$8 = SpillingKt.nullOutSpilledVariable(sessionJson2);
                c00023.L$9 = SpillingKt.nullOutSpilledVariable(step2Url);
                c00023.L$10 = SpillingKt.nullOutSpilledVariable(resultUrl2);
                c00023.L$11 = SpillingKt.nullOutSpilledVariable(finalResultUrl);
                c00023.L$12 = null;
                c00023.label = 11;
                str26 = baseUrl7;
                $result2 = Requests.get$default(app111110, finalResultUrl, mapMapOf17, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, xDMoviesCFBypassInterceptor1115, false, (ResponseParser) null, c00023, 3548, (Object) null);
                if ($result2 == obj) {
                    return obj;
                }
                return ((NiceResponse) $result2).getHeaders().get(str26);
            case 11:
                ResultKt.throwOnFailure($result2);
                str26 = str29;
                return ((NiceResponse) $result2).getHeaders().get(str26);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static final boolean bypassXD$lambda$0(NiceResponse resp) {
        Object obj;
        if (resp.getCode() == 403 || resp.getCode() == 503 || resp.getHeaders().get("cf-mitigated") != null) {
            return true;
        }
        try {
            Result.Companion companion = Result.Companion;
            String lowerCase = resp.getText().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            obj = Result.constructor-impl(lowerCase);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            obj = "";
        }
        String it = (String) obj;
        return StringsKt.contains$default(it, "just a moment", false, 2, (Object) null) || StringsKt.contains$default(it, "cloudflare", false, 2, (Object) null) || StringsKt.contains$default(it, "checking your browser", false, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:35:0x012d  */
    /* JADX WARN: Code duplicated, block: B:37:0x0138  */
    /* JADX WARN: Code duplicated, block: B:45:0x0179  */
    /* JADX WARN: Code duplicated, block: B:46:0x017b  */
    /* JADX WARN: Code duplicated, block: B:48:0x019b  */
    /* JADX WARN: Code duplicated, block: B:56:0x0157 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public static final Object bypassXD$postSession(String code, String baseUrl, String fingerprint, Requests isolatedApp, Map<String, String> map, Continuation<? super JSONObject> continuation) {
        ExtractorKt$bypassXD$postSession$1 extractorKt$bypassXD$postSession$1;
        Object obj;
        Throwable it;
        NiceResponse resp;
        Object obj2;
        Throwable it2;
        String code2 = code;
        if (continuation instanceof ExtractorKt$bypassXD$postSession$1) {
            extractorKt$bypassXD$postSession$1 = (ExtractorKt$bypassXD$postSession$1) continuation;
            if ((extractorKt$bypassXD$postSession$1.label & Integer.MIN_VALUE) != 0) {
                extractorKt$bypassXD$postSession$1.label -= Integer.MIN_VALUE;
            } else {
                extractorKt$bypassXD$postSession$1 = new ExtractorKt$bypassXD$postSession$1(continuation);
            }
        } else {
            extractorKt$bypassXD$postSession$1 = new ExtractorKt$bypassXD$postSession$1(continuation);
        }
        ExtractorKt$bypassXD$postSession$1 extractorKt$bypassXD$postSession$2 = extractorKt$bypassXD$postSession$1;
        Object $result = extractorKt$bypassXD$postSession$2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (extractorKt$bypassXD$postSession$2.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                try {
                    Result.Companion companion = Result.Companion;
                    String str = baseUrl + "/api/session";
                    RequestBody requestBodyCreate = RequestBody.Companion.create("{\"code\":\"" + code2 + "\",\"fingerprint\":\"" + fingerprint + "\"}", MediaType.Companion.get("application/json"));
                    extractorKt$bypassXD$postSession$2.L$0 = code2;
                    extractorKt$bypassXD$postSession$2.L$1 = SpillingKt.nullOutSpilledVariable(baseUrl);
                    extractorKt$bypassXD$postSession$2.L$2 = SpillingKt.nullOutSpilledVariable(fingerprint);
                    extractorKt$bypassXD$postSession$2.L$3 = SpillingKt.nullOutSpilledVariable(isolatedApp);
                    extractorKt$bypassXD$postSession$2.L$4 = SpillingKt.nullOutSpilledVariable(map);
                    extractorKt$bypassXD$postSession$2.label = 1;
                    try {
                        $result = Requests.post$default(isolatedApp, str, map, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, extractorKt$bypassXD$postSession$2, 65276, (Object) null);
                        if ($result == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        try {
                            obj = Result.constructor-impl((NiceResponse) $result);
                            break;
                        } catch (Throwable th) {
                            th = th;
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        it = Result.exceptionOrNull-impl(obj);
                        if (it == null) {
                            Log.INSTANCE.e("XDMovies", "Session POST exception: " + it.getMessage());
                            return null;
                        }
                        resp = (NiceResponse) obj;
                        if (resp.getCode() == 400) {
                            Log.INSTANCE.d("XDMovies", "Got 400 from /api/session — session likely expired (code=" + code2 + ')');
                            return null;
                        }
                        try {
                            Result.Companion companion3 = Result.Companion;
                            obj2 = Result.constructor-impl(new JSONObject(resp.getText()));
                            break;
                        } catch (Throwable th2) {
                            Result.Companion companion4 = Result.Companion;
                            obj2 = Result.constructor-impl(ResultKt.createFailure(th2));
                        }
                        it2 = Result.exceptionOrNull-impl(obj2);
                        if (it2 == null) {
                            return obj2;
                        }
                        Log.INSTANCE.e("XDMovies", "Failed to parse session JSON: " + it2.getMessage());
                        return null;
                    } catch (Throwable th3) {
                        th = th3;
                        Result.Companion companion5 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                        it = Result.exceptionOrNull-impl(obj);
                        if (it == null) {
                            Log.INSTANCE.e("XDMovies", "Session POST exception: " + it.getMessage());
                            return null;
                        }
                        resp = (NiceResponse) obj;
                        if (resp.getCode() == 400) {
                            Log.INSTANCE.d("XDMovies", "Got 400 from /api/session — session likely expired (code=" + code2 + ')');
                            return null;
                        }
                        Result.Companion companion6 = Result.Companion;
                        obj2 = Result.constructor-impl(new JSONObject(resp.getText()));
                        it2 = Result.exceptionOrNull-impl(obj2);
                        if (it2 == null) {
                            return obj2;
                        }
                        Log.INSTANCE.e("XDMovies", "Failed to parse session JSON: " + it2.getMessage());
                        return null;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
                break;
            case 1:
                code2 = (String) extractorKt$bypassXD$postSession$2.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    obj = Result.constructor-impl((NiceResponse) $result);
                    break;
                } catch (Throwable th5) {
                    th = th5;
                    Result.Companion companion7 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                    it = Result.exceptionOrNull-impl(obj);
                    if (it == null) {
                        Log.INSTANCE.e("XDMovies", "Session POST exception: " + it.getMessage());
                        return null;
                    }
                    resp = (NiceResponse) obj;
                    if (resp.getCode() == 400) {
                        Log.INSTANCE.d("XDMovies", "Got 400 from /api/session — session likely expired (code=" + code2 + ')');
                        return null;
                    }
                    Result.Companion companion8 = Result.Companion;
                    obj2 = Result.constructor-impl(new JSONObject(resp.getText()));
                    it2 = Result.exceptionOrNull-impl(obj2);
                    if (it2 == null) {
                        return obj2;
                    }
                    Log.INSTANCE.e("XDMovies", "Failed to parse session JSON: " + it2.getMessage());
                    return null;
                }
                it = Result.exceptionOrNull-impl(obj);
                if (it == null) {
                    Log.INSTANCE.e("XDMovies", "Session POST exception: " + it.getMessage());
                    return null;
                }
                resp = (NiceResponse) obj;
                if (resp.getCode() == 400) {
                    Log.INSTANCE.d("XDMovies", "Got 400 from /api/session — session likely expired (code=" + code2 + ')');
                    return null;
                }
                Result.Companion companion9 = Result.Companion;
                obj2 = Result.constructor-impl(new JSONObject(resp.getText()));
                it2 = Result.exceptionOrNull-impl(obj2);
                if (it2 == null) {
                    return obj2;
                }
                Log.INSTANCE.e("XDMovies", "Failed to parse session JSON: " + it2.getMessage());
                return null;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x00ab A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:27:0x00bc A[Catch: Exception -> 0x00f4, TryCatch #2 {Exception -> 0x00f4, blocks: (B:25:0x00b1, B:27:0x00bc, B:36:0x00cf, B:38:0x00de), top: B:57:0x00b1 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:32:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:34:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:35:0x00ce A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:38:0x00de A[Catch: Exception -> 0x00f4, TRY_LEAVE, TryCatch #2 {Exception -> 0x00f4, blocks: (B:25:0x00b1, B:27:0x00bc, B:36:0x00cf, B:38:0x00de), top: B:57:0x00b1 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:42:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:59:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00ac -> B:57:0x00b1). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Object resolveFinalUrl(@org.jetbrains.annotations.NotNull java.lang.String r26, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.String> r27) {
        /*
            Method dump skipped, instruction units count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.ExtractorKt.resolveFinalUrl(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
