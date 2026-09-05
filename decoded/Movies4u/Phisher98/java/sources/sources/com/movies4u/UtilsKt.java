package com.movies4u;

import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.utils.Qualities;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Movies4u/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\f\u001a<\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0086@¢\u0006\u0002\u0010\t\u001a\u001a\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u0007\u001a\u000e\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0001\"\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\rX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"fetchTmdbLogoUrl", "", "tmdbAPI", "apiKey", "type", "Lcom/lagradost/cloudstream3/TvType;", "tmdbId", "", "appLangCode", "(Ljava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/TvType;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "extractorTitleExtensionRegex", "Lkotlin/text/Regex;", "extractorTitlePatterns", "", "extractorNormalizeWebDlRegex", "extractorNormalizeWebRipRegex", "extractorNormalizeH265Regex", "extractorNormalizeH264Regex", "extractorNormalizeDolbyVisionRegex", "extractorQualityRegex", "extractIndexQuality", "str", "defaultQuality", "extractCleanTitle", "title", "Movies4u"}, k = 2, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utils.kt\ncom/movies4u/UtilsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,133:1\n1#2:134\n1505#3,2:135\n*S KotlinDebug\n*F\n+ 1 Utils.kt\ncom/movies4u/UtilsKt\n*L\n119#1:135,2\n*E\n"})
public final class UtilsKt {

    @NotNull
    private static final Regex extractorTitleExtensionRegex = new Regex("\\.[a-zA-Z0-9]{2,4}$");

    @NotNull
    private static final List<Regex> extractorTitlePatterns = CollectionsKt.listOf(new Regex[]{new Regex("(WEB[- ]?DL|WEB[- ]?RIP|WEBDL|WEBRIP|BLURAY|BDRIP|BRRIP|REMUX|HDRIP|DVDRIP|HDTV|UHD|CAM|TS|TC)", RegexOption.IGNORE_CASE), new Regex("(H[ .]?264|H[ .]?265|X264|X265|HEVC|AVC|AV1|VP9|XVID)", RegexOption.IGNORE_CASE), new Regex("(DDP?[ .]?[0-9]\\.[0-9]|DD[ .]?[0-9]\\.[0-9]|AAC[ .]?[0-9]\\.[0-9]|AC3|DTS[- ]?HD|DTS|EAC3|TRUEHD|ATMOS|FLAC|MP3|OPUS)", RegexOption.IGNORE_CASE), new Regex("(HDR10\\+?|HDR|DV|DOLBY[ .]?VISION)", RegexOption.IGNORE_CASE), new Regex("\\b(NF|AMZN|DSNP|HULU|CRAV|ATVP|HMAX|PCOK|STAN)\\b", RegexOption.IGNORE_CASE), new Regex("\\b(REPACK|PROPER|REAL|EXTENDED|UNCUT|REMASTERED|LIMITED|MULTI|DUAL)\\b", RegexOption.IGNORE_CASE)});

    @NotNull
    private static final Regex extractorNormalizeWebDlRegex = new Regex("WEB[-_. ]?DL");

    @NotNull
    private static final Regex extractorNormalizeWebRipRegex = new Regex("WEB[-_. ]?RIP");

    @NotNull
    private static final Regex extractorNormalizeH265Regex = new Regex("H[ .]?265");

    @NotNull
    private static final Regex extractorNormalizeH264Regex = new Regex("H[ .]?264");

    @NotNull
    private static final Regex extractorNormalizeDolbyVisionRegex = new Regex("DOLBY[ .]?VISION");

    @NotNull
    private static final Regex extractorQualityRegex = new Regex("(\\d{3,4})[pP]");

    /* JADX INFO: renamed from: com.movies4u.UtilsKt$fetchTmdbLogoUrl$1 */
    /* JADX INFO: compiled from: Utils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.movies4u.UtilsKt", f = "Utils.kt", i = {0, 0, 0, 0, 0, 0}, l = {34}, m = "fetchTmdbLogoUrl", n = {"tmdbAPI", "apiKey", "type", "tmdbId", "appLangCode", "url"}, nl = {34}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
    static final class C00191 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C00191(Continuation<? super C00191> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UtilsKt.fetchTmdbLogoUrl(null, null, null, null, null, (Continuation) this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0242 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:101:0x0244  */
    /* JADX WARN: Code duplicated, block: B:103:0x024b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:112:0x01e9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:116:0x01f7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:117:0x01f7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:122:0x0236 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:124:0x0236 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:125:0x0236 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:0x0164  */
    /* JADX WARN: Code duplicated, block: B:45:0x0169 A[ADDED_TO_REGION, RETURN] */
    /* JADX WARN: Code duplicated, block: B:46:0x016a  */
    /* JADX WARN: Code duplicated, block: B:54:0x017e  */
    /* JADX WARN: Code duplicated, block: B:59:0x019e  */
    /* JADX WARN: Code duplicated, block: B:62:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:64:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:65:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:67:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:69:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:73:0x01ee A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:74:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:75:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:79:0x0204  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:81:0x020b  */
    /* JADX WARN: Code duplicated, block: B:83:0x0214  */
    /* JADX WARN: Code duplicated, block: B:86:0x021b  */
    /* JADX WARN: Code duplicated, block: B:90:0x0227  */
    /* JADX WARN: Code duplicated, block: B:92:0x022d  */
    /* JADX WARN: Code duplicated, block: B:93:0x022f  */
    /* JADX WARN: Code duplicated, block: B:95:0x0235  */
    /* JADX WARN: Code duplicated, block: B:98:0x023b  */
    @Nullable
    public static final Object fetchTmdbLogoUrl(@NotNull String tmdbAPI, @NotNull String apiKey, @NotNull TvType type, @Nullable Integer tmdbId, @Nullable String appLangCode, @NotNull Continuation<? super String> continuation) {
        C00191 c00191;
        String tmdbAPI2;
        String appLangCode2;
        String apiKey2;
        Object obj;
        Object obj2;
        JSONObject json;
        JSONArray logos;
        String lang;
        JSONObject svgFallback;
        int i;
        int length;
        String str;
        JSONObject best;
        JSONObject bestSvg;
        int i2;
        int length2;
        JSONObject logo;
        JSONObject logo2;
        String p;
        String str2;
        String tmdbAPI3;
        String l;
        String string;
        if (continuation instanceof C00191) {
            c00191 = (C00191) continuation;
            if ((c00191.label & Integer.MIN_VALUE) != 0) {
                c00191.label -= Integer.MIN_VALUE;
            } else {
                c00191 = new C00191(continuation);
            }
        } else {
            c00191 = new C00191(continuation);
        }
        C00191 c00192 = c00191;
        Object $result = c00192.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00192.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (tmdbId == null) {
                    return null;
                }
                String url = type == TvType.Movie ? tmdbAPI + "/movie/" + tmdbId.intValue() + "/images?api_key=" + apiKey : tmdbAPI + "/tv/" + tmdbId.intValue() + "/images?api_key=" + apiKey;
                try {
                    Result.Companion companion = Result.Companion;
                    Requests app = MainActivityKt.getApp();
                    c00192.L$0 = SpillingKt.nullOutSpilledVariable(tmdbAPI);
                    c00192.L$1 = SpillingKt.nullOutSpilledVariable(apiKey);
                    c00192.L$2 = SpillingKt.nullOutSpilledVariable(type);
                    c00192.L$3 = SpillingKt.nullOutSpilledVariable(tmdbId);
                    c00192.L$4 = appLangCode;
                    c00192.L$5 = SpillingKt.nullOutSpilledVariable(url);
                    c00192.label = 1;
                    tmdbAPI2 = null;
                    try {
                        Object obj3 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00192, 4094, (Object) null);
                        if (obj3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        appLangCode2 = appLangCode;
                        $result = obj3;
                        apiKey2 = tmdbAPI;
                        try {
                            obj = Result.constructor-impl(new JSONObject(((NiceResponse) $result).getText()));
                            break;
                        } catch (Throwable th) {
                            th = th;
                            Object $result2 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        obj2 = obj;
                        if (Result.isFailure-impl(obj2)) {
                            obj2 = tmdbAPI2;
                        }
                        json = (JSONObject) obj2;
                        if (json != null || (logos = json.optJSONArray("logos")) == null || logos.length() == 0) {
                            return tmdbAPI2;
                        }
                        if (appLangCode2 != null || (string = StringsKt.trim(appLangCode2).toString()) == null) {
                            lang = tmdbAPI2;
                        } else {
                            String lowerCase = string.toLowerCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                            if (lowerCase != null) {
                                lang = StringsKt.substringBefore$default(lowerCase, "-", tmdbAPI2, 2, tmdbAPI2);
                            } else {
                                lang = tmdbAPI2;
                            }
                        }
                        svgFallback = null;
                        i = 0;
                        length = logos.length();
                        while (i < length) {
                            logo2 = logos.optJSONObject(i);
                            if (logo2 == null) {
                                str2 = tmdbAPI2;
                                tmdbAPI3 = apiKey2;
                            } else {
                                p = fetchTmdbLogoUrl$path(logo2);
                                if (StringsKt.isBlank(p)) {
                                    str2 = tmdbAPI2;
                                    tmdbAPI3 = apiKey2;
                                } else {
                                    str2 = tmdbAPI2;
                                    tmdbAPI3 = apiKey2;
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
                            apiKey2 = tmdbAPI3;
                            tmdbAPI2 = str2;
                        }
                        str = tmdbAPI2;
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
                            return str;
                        }
                        JSONObject it3 = bestSvg;
                        return fetchTmdbLogoUrl$urlOf(it3);
                    } catch (Throwable th2) {
                        th = th2;
                        appLangCode2 = appLangCode;
                        apiKey2 = tmdbAPI;
                        Object $result3 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                        obj2 = obj;
                        if (Result.isFailure-impl(obj2)) {
                            obj2 = tmdbAPI2;
                        }
                        json = (JSONObject) obj2;
                        if (json != null) {
                            return tmdbAPI2;
                        }
                        if (appLangCode2 != null) {
                            lang = tmdbAPI2;
                        } else {
                            lang = tmdbAPI2;
                        }
                        svgFallback = null;
                        i = 0;
                        length = logos.length();
                        while (i < length) {
                            logo2 = logos.optJSONObject(i);
                            if (logo2 == null) {
                                str2 = tmdbAPI2;
                                tmdbAPI3 = apiKey2;
                            } else {
                                p = fetchTmdbLogoUrl$path(logo2);
                                if (StringsKt.isBlank(p)) {
                                    str2 = tmdbAPI2;
                                    tmdbAPI3 = apiKey2;
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
                                    str2 = tmdbAPI2;
                                    tmdbAPI3 = apiKey2;
                                }
                            }
                            i++;
                            apiKey2 = tmdbAPI3;
                            tmdbAPI2 = str2;
                        }
                        str = tmdbAPI2;
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
                            return str;
                        }
                        JSONObject it6 = bestSvg;
                        return fetchTmdbLogoUrl$urlOf(it6);
                    }
                } catch (Throwable th3) {
                    th = th3;
                    tmdbAPI2 = null;
                    appLangCode2 = appLangCode;
                    apiKey2 = tmdbAPI;
                }
                break;
            case 1:
                appLangCode2 = (String) c00192.L$4;
                String tmdbAPI4 = (String) c00192.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    apiKey2 = tmdbAPI4;
                    tmdbAPI2 = null;
                    obj = Result.constructor-impl(new JSONObject(((NiceResponse) $result).getText()));
                    break;
                } catch (Throwable th4) {
                    th = th4;
                    apiKey2 = tmdbAPI4;
                    tmdbAPI2 = null;
                    Object $result4 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                    obj2 = obj;
                    if (Result.isFailure-impl(obj2)) {
                        obj2 = tmdbAPI2;
                    }
                    json = (JSONObject) obj2;
                    if (json != null) {
                        return tmdbAPI2;
                    }
                    if (appLangCode2 != null) {
                        lang = tmdbAPI2;
                    } else {
                        lang = tmdbAPI2;
                    }
                    svgFallback = null;
                    i = 0;
                    length = logos.length();
                    while (i < length) {
                        logo2 = logos.optJSONObject(i);
                        if (logo2 == null) {
                            str2 = tmdbAPI2;
                            tmdbAPI3 = apiKey2;
                        } else {
                            p = fetchTmdbLogoUrl$path(logo2);
                            if (StringsKt.isBlank(p)) {
                                str2 = tmdbAPI2;
                                tmdbAPI3 = apiKey2;
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
                                str2 = tmdbAPI2;
                                tmdbAPI3 = apiKey2;
                            }
                        }
                        i++;
                        apiKey2 = tmdbAPI3;
                        tmdbAPI2 = str2;
                    }
                    str = tmdbAPI2;
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
                        return str;
                    }
                    JSONObject it9 = bestSvg;
                    return fetchTmdbLogoUrl$urlOf(it9);
                }
                obj2 = obj;
                if (Result.isFailure-impl(obj2)) {
                    obj2 = tmdbAPI2;
                }
                json = (JSONObject) obj2;
                if (json != null) {
                    return tmdbAPI2;
                }
                if (appLangCode2 != null) {
                    lang = tmdbAPI2;
                } else {
                    lang = tmdbAPI2;
                }
                svgFallback = null;
                i = 0;
                length = logos.length();
                while (i < length) {
                    logo2 = logos.optJSONObject(i);
                    if (logo2 == null) {
                        str2 = tmdbAPI2;
                        tmdbAPI3 = apiKey2;
                    } else {
                        p = fetchTmdbLogoUrl$path(logo2);
                        if (StringsKt.isBlank(p)) {
                            str2 = tmdbAPI2;
                            tmdbAPI3 = apiKey2;
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
                            str2 = tmdbAPI2;
                            tmdbAPI3 = apiKey2;
                        }
                    }
                    i++;
                    apiKey2 = tmdbAPI3;
                    tmdbAPI2 = str2;
                }
                str = tmdbAPI2;
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
                    return str;
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

    public static /* synthetic */ int extractIndexQuality$default(String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = Qualities.Unknown.getValue();
        }
        return extractIndexQuality(str, i);
    }

    public static final int extractIndexQuality(@Nullable String str, int defaultQuality) {
        List groupValues;
        String str2;
        Integer intOrNull;
        MatchResult matchResultFind$default = Regex.find$default(extractorQualityRegex, str == null ? "" : str, 0, 2, (Object) null);
        return (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null || (str2 = (String) CollectionsKt.getOrNull(groupValues, 1)) == null || (intOrNull = StringsKt.toIntOrNull(str2)) == null) ? defaultQuality : intOrNull.intValue();
    }

    @NotNull
    public static final String extractCleanTitle(@NotNull String title) {
        String name = extractorTitleExtensionRegex.replace(title, "");
        LinkedHashSet results = new LinkedHashSet();
        for (Regex pattern : extractorTitlePatterns) {
            Sequence $this$forEach$iv = Regex.findAll$default(pattern, name, 0, 2, (Object) null);
            for (Object element$iv : $this$forEach$iv) {
                MatchResult match = (MatchResult) element$iv;
                String upperCase = match.getValue().toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                String value = StringsKt.replace$default(extractorNormalizeDolbyVisionRegex.replace(extractorNormalizeH264Regex.replace(extractorNormalizeH265Regex.replace(extractorNormalizeWebRipRegex.replace(extractorNormalizeWebDlRegex.replace(upperCase, "WEB-DL"), "WEBRIP"), "H265"), "H264"), "DOLBYVISION"), "2160P", "4K", false, 4, (Object) null);
                results.add(value);
            }
        }
        return CollectionsKt.joinToString$default(results, " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }
}
