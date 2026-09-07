package com.phisher98;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.APIHolder;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StremioX/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001\u001a\u001a\u0010\u0002\u001a\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u001a\u0016\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b\u001a/\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\r\u001a\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001\u001a\u0016\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0001\u001a&\u0010\u0014\u001a\u00020\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0086@¢\u0006\u0002\u0010\u0017\u001a<\u0010\u0018\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u0086@¢\u0006\u0002\u0010\u001f\u001a\u0010\u0010 \u001a\u00020\u00012\b\u0010!\u001a\u0004\u0018\u00010\u0001\u001a\u0010\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020\u0001¨\u0006%"}, d2 = {"fixSourceUrl", "", "fixSourceName", "name", "title", "getQuality", "", "qualities", "", "getEpisodeSlug", "Lkotlin/Pair;", "season", "episode", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lkotlin/Pair;", "isUpcoming", "", "dateString", "fixUrl", "url", "domain", "generateMagnetLink", "trackerUrls", "hash", "(Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchTmdbLogoUrl", "tmdbAPI", "apiKey", "type", "Lcom/lagradost/cloudstream3/TvType;", "tmdbId", "appLangCode", "(Ljava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/TvType;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "normalizeId", "id", "parseAnimeData", "Lcom/phisher98/MetaAnimeData;", "jsonString", "StremioX"}, k = 2, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utils.kt\ncom/phisher98/UtilsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 5 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,262:1\n1#2:263\n2068#3:264\n2069#3:267\n2068#3,2:268\n1505#4,2:265\n1088#5,2:270\n*S KotlinDebug\n*F\n+ 1 Utils.kt\ncom/phisher98/UtilsKt\n*L\n103#1:264\n103#1:267\n126#1:268,2\n110#1:265,2\n211#1:270,2\n*E\n"})
public final class UtilsKt {

    /* JADX INFO: renamed from: com.phisher98.UtilsKt$fetchTmdbLogoUrl$1 */
    /* JADX INFO: compiled from: Utils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.UtilsKt", f = "Utils.kt", i = {0, 0, 0, 0, 0, 0}, l = {148}, m = "fetchTmdbLogoUrl", n = {"tmdbAPI", "apiKey", "type", "tmdbId", "appLangCode", "url"}, nl = {148}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
    static final class C00331 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C00331(Continuation<? super C00331> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UtilsKt.fetchTmdbLogoUrl(null, null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.UtilsKt$generateMagnetLink$1 */
    /* JADX INFO: compiled from: Utils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.UtilsKt", f = "Utils.kt", i = {0, 0, 0, 0, 0, 0}, l = {105}, m = "generateMagnetLink", n = {"trackerUrls", "hash", "trackers", "$this$forEach$iv", "element$iv", "url"}, nl = {106}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "L$6"}, v = 2)
    static final class C00341 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C00341(Continuation<? super C00341> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UtilsKt.generateMagnetLink(null, null, (Continuation) this);
        }
    }

    @NotNull
    public static final String fixSourceUrl(@NotNull String $this$fixSourceUrl) {
        return StringsKt.replace$default(StringsKt.replace$default($this$fixSourceUrl, "/manifest.json", "", false, 4, (Object) null), "stremio://", "https://", false, 4, (Object) null);
    }

    @NotNull
    public static final String fixSourceName(@Nullable String name, @Nullable String title) {
        if (name != null && StringsKt.contains(name, "[RD+]", true)) {
            return "[RD+] " + title;
        }
        if (name != null && StringsKt.contains(name, "[RD download]", true)) {
            return "[RD download] " + title;
        }
        String str = name;
        if (!(str == null || str.length() == 0)) {
            String str2 = title;
            if (!(str2 == null || str2.length() == 0)) {
                return name + ' ' + title;
            }
        }
        if (title == null) {
            return name == null ? "" : name;
        }
        return title;
    }

    private static final String getQuality$getQuality(String $this$getQuality_u24getQuality) {
        List groupValues;
        MatchResult matchResultFind$default = Regex.find$default(new Regex("(\\d{3,4}[pP])"), $this$getQuality_u24getQuality, 0, 2, (Object) null);
        if (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null) {
            return null;
        }
        return (String) CollectionsKt.getOrNull(groupValues, 1);
    }

    public static final int getQuality(@NotNull List<String> list) {
        String quality;
        Iterator<T> it = list.iterator();
        do {
            quality = null;
            if (!it.hasNext()) {
                break;
            }
            String it2 = (String) it.next();
            if (it2 != null) {
                quality = getQuality$getQuality(it2);
            }
        } while (quality == null);
        return ExtractorApiKt.getQualityFromName(quality);
    }

    public static /* synthetic */ Pair getEpisodeSlug$default(Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            num2 = null;
        }
        return getEpisodeSlug(num, num2);
    }

    @NotNull
    public static final Pair<String, String> getEpisodeSlug(@Nullable Integer season, @Nullable Integer episode) {
        if (season == null && episode == null) {
            return TuplesKt.to("", "");
        }
        Intrinsics.checkNotNull(season);
        String string = season.intValue() < 10 ? new StringBuilder().append('0').append(season.intValue()).toString() : String.valueOf(season.intValue());
        Intrinsics.checkNotNull(episode);
        return TuplesKt.to(string, episode.intValue() < 10 ? new StringBuilder().append('0').append(episode.intValue()).toString() : String.valueOf(episode.intValue()));
    }

    public static final boolean isUpcoming(@Nullable String dateString) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            if (dateString != null) {
                Date date = format.parse(dateString);
                Long lValueOf = date != null ? Long.valueOf(date.getTime()) : null;
                if (lValueOf != null) {
                    long dateTime = lValueOf.longValue();
                    return APIHolder.INSTANCE.getUnixTimeMS() < dateTime;
                }
            }
            return false;
        } catch (Throwable t) {
            ArchComponentExtKt.logError(t);
            return false;
        }
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

    /* JADX WARN: Code duplicated, block: B:26:0x0095  */
    /* JADX WARN: Code duplicated, block: B:31:0x00fd A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:32:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:36:0x013b A[Catch: Exception -> 0x015e, TRY_LEAVE, TryCatch #0 {Exception -> 0x015e, blocks: (B:33:0x0111, B:34:0x0135, B:36:0x013b), top: B:58:0x0111 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00fe -> B:58:0x0111). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x0163 -> B:45:0x0194). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0179 -> B:45:0x0194). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Object generateMagnetLink(@org.jetbrains.annotations.NotNull java.util.List<java.lang.String> r30, @org.jetbrains.annotations.Nullable java.lang.String r31, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.String> r32) {
        /*
            Method dump skipped, instruction units count: 546
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.UtilsKt.generateMagnetLink(java.util.List, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String generateMagnetLink$lambda$0$0(String it) {
        return StringsKt.trim(it).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean generateMagnetLink$lambda$0$1(String it) {
        return (it.length() > 0) && !StringsKt.startsWith$default(it, "#", false, 2, (Object) null);
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
        C00331 c00331;
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
        if (continuation instanceof C00331) {
            c00331 = (C00331) continuation;
            if ((c00331.label & Integer.MIN_VALUE) != 0) {
                c00331.label -= Integer.MIN_VALUE;
            } else {
                c00331 = new C00331(continuation);
            }
        } else {
            c00331 = new C00331(continuation);
        }
        C00331 c00332 = c00331;
        Object $result = c00332.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00332.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (tmdbId == null) {
                    return null;
                }
                String url = type == TvType.Movie ? tmdbAPI + "/movie/" + tmdbId.intValue() + "/images?api_key=" + apiKey : tmdbAPI + "/tv/" + tmdbId.intValue() + "/images?api_key=" + apiKey;
                try {
                    Result.Companion companion = Result.Companion;
                    Requests app = MainActivityKt.getApp();
                    c00332.L$0 = SpillingKt.nullOutSpilledVariable(tmdbAPI);
                    c00332.L$1 = SpillingKt.nullOutSpilledVariable(apiKey);
                    c00332.L$2 = SpillingKt.nullOutSpilledVariable(type);
                    c00332.L$3 = SpillingKt.nullOutSpilledVariable(tmdbId);
                    c00332.L$4 = appLangCode;
                    c00332.L$5 = SpillingKt.nullOutSpilledVariable(url);
                    c00332.label = 1;
                    tmdbAPI2 = null;
                    try {
                        Object obj3 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00332, 4094, (Object) null);
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
                appLangCode2 = (String) c00332.L$4;
                String tmdbAPI4 = (String) c00332.L$0;
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

    @NotNull
    public static final String normalizeId(@Nullable String id) {
        String clean;
        if (id == null || (clean = StringsKt.trim(id).toString()) == null) {
            clean = "";
        }
        if (!new Regex("^tt\\d+$").matches(clean)) {
            CharSequence $this$all$iv = clean;
            boolean z = false;
            int i = 0;
            while (true) {
                if (i < $this$all$iv.length()) {
                    char element$iv = $this$all$iv.charAt(i);
                    if (!Character.isDigit(element$iv)) {
                        break;
                    }
                    i++;
                } else {
                    z = true;
                    break;
                }
            }
            if (z) {
                return "tmdb:" + clean;
            }
        }
        return clean;
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
}
