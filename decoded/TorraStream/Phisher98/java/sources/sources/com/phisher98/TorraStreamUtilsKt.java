package com.phisher98;

import android.content.SharedPreferences;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.ParCollectionsKt;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.Qualities;
import com.lagradost.cloudstream3.utils.SubtitleHelper;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: TorraStreamUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/TorraStream/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u001a\u001f\u0010\u0006\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\t\u001a\u0010\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\u0003\u001a\u0012\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u001a\u0006\u0010\u000e\u001a\u00020\u000f\u001a<\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u0086@¢\u0006\u0002\u0010\u0017\u001a.\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u0019\u001a&\u0010\u001f\u001a\u00020\u00032\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030!2\b\u0010\"\u001a\u0004\u0018\u00010\u0003H\u0086@¢\u0006\u0002\u0010#¨\u0006$"}, d2 = {"getIndexQuality", "", "str", "", "getLanguage", "language", "getAnidbEid", "jsonString", "episodeNumber", "(Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/Integer;", "parseAnimeData", "Lcom/phisher98/MetaAnimeData;", "extractResolutionFromDescription", "description", "getDate", "Lcom/phisher98/TmdbDate;", "fetchTmdbLogoUrl", "tmdbAPI", "apiKey", "type", "Lcom/lagradost/cloudstream3/TvType;", "tmdbId", "appLangCode", "(Ljava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/TvType;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "filteredCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "", "sharedPref", "Landroid/content/SharedPreferences;", "callback", "generateMagnetLink", "trackerUrls", "", "hash", "(Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "TorraStream"}, k = 2, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTorraStreamUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TorraStreamUtils.kt\ncom/phisher98/TorraStreamUtilsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,351:1\n1#2:352\n777#3:353\n873#3,2:354\n2068#3,2:356\n*S KotlinDebug\n*F\n+ 1 TorraStreamUtils.kt\ncom/phisher98/TorraStreamUtilsKt\n*L\n280#1:353\n280#1:354,2\n346#1:356,2\n*E\n"})
public final class TorraStreamUtilsKt {

    /* JADX INFO: renamed from: com.phisher98.TorraStreamUtilsKt$fetchTmdbLogoUrl$1 */
    /* JADX INFO: compiled from: TorraStreamUtils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamUtilsKt", f = "TorraStreamUtils.kt", i = {0, 0, 0, 0, 0, 0}, l = {195}, m = "fetchTmdbLogoUrl", n = {"tmdbAPI", "apiKey", "type", "tmdbId", "appLangCode", "url"}, nl = {195}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
    static final class C00711 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C00711(Continuation<? super C00711> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TorraStreamUtilsKt.fetchTmdbLogoUrl(null, null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStreamUtilsKt$generateMagnetLink$1 */
    /* JADX INFO: compiled from: TorraStreamUtils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamUtilsKt", f = "TorraStreamUtils.kt", i = {0, 0, 0}, l = {326}, m = "generateMagnetLink", n = {"trackerUrls", "hash", "trackers"}, nl = {334}, s = {"L$0", "L$1", "L$2"}, v = 2)
    static final class C00721 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00721(Continuation<? super C00721> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TorraStreamUtilsKt.generateMagnetLink(null, null, (Continuation) this);
        }
    }

    public static final int getIndexQuality(@Nullable String str) {
        List groupValues;
        String str2;
        Integer intOrNull;
        MatchResult matchResultFind$default = Regex.find$default(new Regex("(\\d{3,4})[pP]"), str == null ? "" : str, 0, 2, (Object) null);
        return (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null || (str2 = (String) CollectionsKt.getOrNull(groupValues, 1)) == null || (intOrNull = StringsKt.toIntOrNull(str2)) == null) ? Qualities.Unknown.getValue() : intOrNull.intValue();
    }

    @Nullable
    public static final String getLanguage(@Nullable String language) {
        SubtitleHelper subtitleHelper = SubtitleHelper.INSTANCE;
        if (language == null) {
            return null;
        }
        String strFromTagToEnglishLanguageName = subtitleHelper.fromTagToEnglishLanguageName(language);
        if (strFromTagToEnglishLanguageName != null) {
            return strFromTagToEnglishLanguageName;
        }
        return SubtitleHelper.INSTANCE.fromTagToEnglishLanguageName(StringsKt.substringBefore$default(language, "-", (String) null, 2, (Object) null));
    }

    @Nullable
    public static final Integer getAnidbEid(@NotNull String jsonString, @Nullable Integer episodeNumber) {
        JSONObject jSONObjectOptJSONObject;
        if (episodeNumber == null) {
            return null;
        }
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONObject episodes = jsonObject.optJSONObject("episodes");
            if (episodes == null || (jSONObjectOptJSONObject = episodes.optJSONObject(String.valueOf(episodeNumber.intValue()))) == null) {
                return null;
            }
            Integer numValueOf = Integer.valueOf(jSONObjectOptJSONObject.optInt("anidbEid", -1));
            int it = numValueOf.intValue();
            if (it != -1) {
                return numValueOf;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Nullable
    public static final MetaAnimeData parseAnimeData(@NotNull String jsonString) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return (MetaAnimeData) objectMapper.readValue(jsonString, MetaAnimeData.class);
        } catch (Exception e) {
            return null;
        }
    }

    @Nullable
    public static final String extractResolutionFromDescription(@Nullable String description) {
        String str = description;
        if (str == null || StringsKt.isBlank(str)) {
            return null;
        }
        Regex regex = new Regex("\\b(2160p|1440p|1080p|720p|480p|360p)\\b", RegexOption.IGNORE_CASE);
        MatchResult matchResultFind$default = Regex.find$default(regex, description, 0, 2, (Object) null);
        if (matchResultFind$default != null) {
            return matchResultFind$default.getValue();
        }
        return null;
    }

    @NotNull
    public static final TmdbDate getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Calendar calendar = Calendar.getInstance();
        String today = formatter.format(calendar.getTime());
        calendar.add(3, 1);
        String nextWeek = formatter.format(calendar.getTime());
        calendar.setTime(new Date());
        calendar.set(7, 2);
        calendar.add(3, -1);
        String lastWeekStart = formatter.format(calendar.getTime());
        calendar.setTime(new Date());
        calendar.set(5, 1);
        String monthStart = formatter.format(calendar.getTime());
        return new TmdbDate(today, nextWeek, lastWeekStart, monthStart);
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
        C00711 c00711;
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
        if (continuation instanceof C00711) {
            c00711 = (C00711) continuation;
            if ((c00711.label & Integer.MIN_VALUE) != 0) {
                c00711.label -= Integer.MIN_VALUE;
            } else {
                c00711 = new C00711(continuation);
            }
        } else {
            c00711 = new C00711(continuation);
        }
        C00711 c00712 = c00711;
        Object $result = c00712.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00712.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (tmdbId == null) {
                    return null;
                }
                String url = type == TvType.Movie ? tmdbAPI3 + "/movie/" + tmdbId.intValue() + "/images?api_key=" + apiKey : tmdbAPI3 + "/tv/" + tmdbId.intValue() + "/images?api_key=" + apiKey;
                try {
                    Result.Companion companion = Result.Companion;
                    Requests app = MainActivityKt.getApp();
                    c00712.L$0 = SpillingKt.nullOutSpilledVariable(tmdbAPI3);
                    c00712.L$1 = SpillingKt.nullOutSpilledVariable(apiKey);
                    c00712.L$2 = SpillingKt.nullOutSpilledVariable(type);
                    c00712.L$3 = SpillingKt.nullOutSpilledVariable(tmdbId);
                    c00712.L$4 = appLangCode;
                    c00712.L$5 = SpillingKt.nullOutSpilledVariable(url);
                    c00712.label = 1;
                    try {
                        Object obj2 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00712, 4094, (Object) null);
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
                appLangCode2 = (String) c00712.L$4;
                tmdbAPI3 = (String) c00712.L$0;
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

    /* JADX WARN: Code duplicated, block: B:15:0x0060  */
    @NotNull
    public static final Function1<ExtractorLink, Unit> filteredCallback(@NotNull SharedPreferences sharedPref, @NotNull final Function1<? super ExtractorLink, Unit> function1) {
        List listEmptyList;
        Integer intOrNull;
        Iterable iterableSplit$default;
        String string = sharedPref.getString("qualityfilter", "");
        if (string != null) {
            String lowerCase = string.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (lowerCase == null || (iterableSplit$default = StringsKt.split$default(lowerCase, new String[]{","}, false, 0, 6, (Object) null)) == null) {
                listEmptyList = CollectionsKt.emptyList();
            } else {
                Iterable $this$filter$iv = iterableSplit$default;
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv : $this$filter$iv) {
                    String it = (String) element$iv$iv;
                    if (!StringsKt.isBlank(it)) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                }
                listEmptyList = (List) destination$iv$iv;
            }
        } else {
            listEmptyList = CollectionsKt.emptyList();
        }
        final List excludedQualities = listEmptyList;
        String string2 = sharedPref.getString("sizefilter", "");
        final Double maxSize = string2 != null ? StringsKt.toDoubleOrNull(string2) : null;
        String string3 = sharedPref.getString("limit", "");
        final int limit = (string3 == null || (intOrNull = StringsKt.toIntOrNull(string3)) == null) ? 0 : intOrNull.intValue();
        final Ref.IntRef resultCount = new Ref.IntRef();
        return new Function1() { // from class: com.phisher98.TorraStreamUtilsKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return TorraStreamUtilsKt.filteredCallback$lambda$1(limit, resultCount, excludedQualities, maxSize, function1, (ExtractorLink) obj);
            }
        };
    }

    static final Unit filteredCallback$lambda$1(int limit, Ref.IntRef resultCount, List<String> list, Double maxSize, Function1<? super ExtractorLink, Unit> function1, ExtractorLink link) {
        String detectedQuality;
        String upperCase;
        List groupValues;
        List groupValues2;
        String str;
        String strReplace$default;
        if (1 <= limit && limit <= resultCount.element) {
            return Unit.INSTANCE;
        }
        int quality = link.getQuality();
        if (2000 <= quality && quality < 3001) {
            detectedQuality = "4k";
        } else {
            if (1080 <= quality && quality < 2000) {
                detectedQuality = "1080p";
            } else {
                if (720 <= quality && quality < 1080) {
                    detectedQuality = "720p";
                } else {
                    detectedQuality = 480 <= quality && quality < 720 ? "480p" : "other";
                }
            }
        }
        if (list.contains(detectedQuality)) {
            return Unit.INSTANCE;
        }
        Double sizeGB = null;
        MatchResult sizeMatch = Regex.find$default(new Regex("(\\d+(?:[.,]\\d+)?)\\s*(GB|MB)", RegexOption.IGNORE_CASE), link.getName(), 0, 2, (Object) null);
        Double sizeValue = (sizeMatch == null || (groupValues2 = sizeMatch.getGroupValues()) == null || (str = (String) groupValues2.get(1)) == null || (strReplace$default = StringsKt.replace$default(str, ',', '.', false, 4, (Object) null)) == null) ? null : StringsKt.toDoubleOrNull(strReplace$default);
        String sizeUnit = (sizeMatch == null || (groupValues = sizeMatch.getGroupValues()) == null) ? null : (String) groupValues.get(2);
        if (sizeUnit != null) {
            upperCase = sizeUnit.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        } else {
            upperCase = null;
        }
        if (Intrinsics.areEqual(upperCase, "GB")) {
            sizeGB = sizeValue;
        } else if (Intrinsics.areEqual(upperCase, "MB") && sizeValue != null) {
            sizeGB = Double.valueOf(sizeValue.doubleValue() / 1024.0d);
        }
        if (maxSize != null && sizeGB != null && sizeGB.doubleValue() > maxSize.doubleValue()) {
            return Unit.INSTANCE;
        }
        function1.invoke(link);
        resultCount.element++;
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Nullable
    public static final Object generateMagnetLink(@NotNull List<String> list, @Nullable String hash, @NotNull Continuation<? super String> continuation) {
        C00721 c00721;
        Object objAmap;
        Set trackers;
        if (continuation instanceof C00721) {
            c00721 = (C00721) continuation;
            if ((c00721.label & Integer.MIN_VALUE) != 0) {
                c00721.label -= Integer.MIN_VALUE;
            } else {
                c00721 = new C00721(continuation);
            }
        } else {
            c00721 = new C00721(continuation);
        }
        Object $result = c00721.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00721.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                boolean z = false;
                if (hash != null && (!StringsKt.isBlank(hash))) {
                    z = true;
                }
                if (!z) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                Set trackers2 = new LinkedHashSet();
                C00732 c00732 = new C00732(null);
                c00721.L$0 = SpillingKt.nullOutSpilledVariable(list);
                c00721.L$1 = hash;
                c00721.L$2 = trackers2;
                c00721.label = 1;
                objAmap = ParCollectionsKt.amap(list, c00732, c00721);
                if (objAmap == coroutine_suspended) {
                    return coroutine_suspended;
                }
                trackers = trackers2;
                break;
                break;
            case 1:
                trackers = (Set) c00721.L$2;
                hash = (String) c00721.L$1;
                ResultKt.throwOnFailure($result);
                objAmap = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        CollectionsKt.toMutableSet(CollectionsKt.flatten((Iterable) objAmap));
        StringBuilder $this$generateMagnetLink_u24lambda_u240 = new StringBuilder();
        $this$generateMagnetLink_u24lambda_u240.append("magnet:?xt=urn:btih:").append(hash);
        if (!StringsKt.isBlank(hash)) {
            $this$generateMagnetLink_u24lambda_u240.append("&dn=");
            $this$generateMagnetLink_u24lambda_u240.append(URLEncoder.encode(hash, StandardCharsets.UTF_8.name()));
        }
        Iterable $this$forEach$iv = CollectionsKt.take(trackers, 10);
        for (Object element$iv : $this$forEach$iv) {
            String tracker = (String) element$iv;
            $this$generateMagnetLink_u24lambda_u240.append("&tr=");
            $this$generateMagnetLink_u24lambda_u240.append(URLEncoder.encode(tracker, StandardCharsets.UTF_8.name()));
        }
        return $this$generateMagnetLink_u24lambda_u240.toString();
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStreamUtilsKt$generateMagnetLink$2 */
    /* JADX INFO: compiled from: TorraStreamUtils.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "", "url"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamUtilsKt$generateMagnetLink$2", f = "TorraStreamUtils.kt", i = {0}, l = {328}, m = "invokeSuspend", n = {"url"}, nl = {329}, s = {"L$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nTorraStreamUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TorraStreamUtils.kt\ncom/phisher98/TorraStreamUtilsKt$generateMagnetLink$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,351:1\n1#2:352\n*E\n"})
    static final class C00732 extends SuspendLambda implements Function2<String, Continuation<? super List<? extends String>>, Object> {
        /* synthetic */ Object L$0;
        int label;

        C00732(Continuation<? super C00732> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00732 = new C00732(continuation);
            c00732.L$0 = obj;
            return c00732;
        }

        public final Object invoke(String str, Continuation<? super List<String>> continuation) {
            return create(str, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object obj;
            Object obj2;
            String url = (String) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Result.Companion companion = Result.Companion;
                        Requests app = MainActivityKt.getApp();
                        this.L$0 = SpillingKt.nullOutSpilledVariable(url);
                        this.label = 1;
                        obj2 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, this, 4094, (Object) null);
                        if (obj2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        obj2 = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj = Result.constructor-impl(SequencesKt.toList(SequencesKt.filter(SequencesKt.map(StringsKt.lineSequence(((NiceResponse) obj2).getText()), new Function1() { // from class: com.phisher98.TorraStreamUtilsKt$generateMagnetLink$2$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj3) {
                        return TorraStreamUtilsKt.C00732.invokeSuspend$lambda$0$0((String) obj3);
                    }
                }), new Function1() { // from class: com.phisher98.TorraStreamUtilsKt$generateMagnetLink$2$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj3) {
                        return Boolean.valueOf(TorraStreamUtilsKt.C00732.invokeSuspend$lambda$0$1((String) obj3));
                    }
                })));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            return Result.exceptionOrNull-impl(obj) == null ? obj : CollectionsKt.emptyList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$0$0(String it) {
            return StringsKt.trim(it).toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invokeSuspend$lambda$0$1(String it) {
            return (it.length() > 0) && !StringsKt.startsWith$default(it, "#", false, 2, (Object) null);
        }
    }
}
