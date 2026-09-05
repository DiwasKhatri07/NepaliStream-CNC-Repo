package com.phisher98;

import com.fasterxml.jackson.databind.JsonNode;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: UHDmoviesProvider.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/UHDmoviesProvider/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\b\u001a\"\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\rH\u0082@¢\u0006\u0002\u0010\u000e\u001a \u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0082@¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"fetchIds", "Lcom/phisher98/IdResult;", "title", "", "year", "", "isSeries", "", "(Ljava/lang/String;Ljava/lang/Integer;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchMetaData", "Lcom/fasterxml/jackson/databind/JsonNode;", "imdbId", "type", "Lcom/lagradost/cloudstream3/TvType;", "(Ljava/lang/String;Lcom/lagradost/cloudstream3/TvType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchSimklId", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "UHDmoviesProvider"}, k = 2, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nUHDmoviesProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UHDmoviesProvider.kt\ncom/phisher98/UHDmoviesProviderKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,382:1\n1#2:383\n*E\n"})
public final class UHDmoviesProviderKt {

    /* JADX INFO: renamed from: com.phisher98.UHDmoviesProviderKt$fetchIds$1 */
    /* JADX INFO: compiled from: UHDmoviesProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.UHDmoviesProviderKt", f = "UHDmoviesProvider.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {334, 340}, m = "fetchIds", n = {"title", "year", "TMDB_API", "TMDB_API_KEY", "type", "searchUrl", "isSeries", "title", "year", "TMDB_API", "TMDB_API_KEY", "type", "searchUrl", "searchJson", "results", "tmdbId", "extUrl", "isSeries", "id"}, nl = {335, 341}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "Z$0", "I$0"}, v = 2)
    static final class C00141 extends ContinuationImpl {
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
        Object L$9;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00141(Continuation<? super C00141> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UHDmoviesProviderKt.fetchIds(null, null, false, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.UHDmoviesProviderKt$fetchMetaData$1 */
    /* JADX INFO: compiled from: UHDmoviesProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.UHDmoviesProviderKt", f = "UHDmoviesProvider.kt", i = {0, 0, 0, 0}, l = {363}, m = "fetchMetaData", n = {"imdbId", "type", "metaType", "url"}, nl = {364}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 2)
    static final class C00151 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C00151(Continuation<? super C00151> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UHDmoviesProviderKt.fetchMetaData(null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.UHDmoviesProviderKt$fetchSimklId$1 */
    /* JADX INFO: compiled from: UHDmoviesProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.UHDmoviesProviderKt", f = "UHDmoviesProvider.kt", i = {0, 0, 0, 0}, l = {377}, m = "fetchSimklId", n = {"imdbId", "type", "url", "isSeries"}, nl = {378}, s = {"L$0", "L$1", "L$2", "Z$0"}, v = 2)
    static final class C00161 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00161(Continuation<? super C00161> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UHDmoviesProviderKt.fetchSimklId(null, false, (Continuation) this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:36:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:38:0x025f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:39:0x0260  */
    /* JADX WARN: Code duplicated, block: B:42:0x0297  */
    /* JADX WARN: Code duplicated, block: B:44:0x02a6  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public static final Object fetchIds(@NotNull String title, @Nullable Integer year, boolean isSeries, @NotNull Continuation<? super IdResult> continuation) {
        C00141 c00141;
        Object obj;
        C00141 c00142;
        String TMDB_API;
        String TMDB_API_KEY;
        String type;
        Integer year2;
        String TMDB_API_KEY2;
        Object obj2;
        boolean isSeries2;
        String title2;
        StringBuilder sb;
        String str;
        JSONObject searchJson;
        JSONArray results;
        Integer tmdbId;
        String type2;
        String TMDB_API_KEY3;
        String TMDB_API2;
        Integer tmdbId2;
        boolean isSeries3;
        String title3;
        Integer year3;
        String searchUrl;
        String TMDB_API3;
        boolean isSeries4;
        JSONObject searchJson2;
        String type3;
        String TMDB_API_KEY4;
        JSONArray results2;
        Integer tmdbId3;
        JSONObject jSONObjectOptJSONObject;
        if (continuation instanceof C00141) {
            c00141 = (C00141) continuation;
            if ((c00141.label & Integer.MIN_VALUE) != 0) {
                c00141.label -= Integer.MIN_VALUE;
            } else {
                c00141 = new C00141(continuation);
            }
        } else {
            c00141 = new C00141(continuation);
        }
        Object $result = c00141.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String str2 = null;
        switch (c00141.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String type4 = isSeries ? "tv" : "movie";
                StringBuilder $this$fetchIds_u24lambda_u240 = new StringBuilder();
                $this$fetchIds_u24lambda_u240.append("https://api.themoviedb.org/3/search/" + type4);
                $this$fetchIds_u24lambda_u240.append("?api_key=1865f43a0549ca50d341dd9ab8b29f49");
                $this$fetchIds_u24lambda_u240.append("&query=" + title);
                if (year != null) {
                    if (isSeries) {
                        sb = new StringBuilder();
                        str = "&first_air_date_year=";
                    } else {
                        sb = new StringBuilder();
                        str = "&year=";
                    }
                    $this$fetchIds_u24lambda_u240.append(sb.append(str).append(year.intValue()).toString());
                }
                String searchUrl2 = $this$fetchIds_u24lambda_u240.toString();
                Requests app = MainActivityKt.getApp();
                c00141.L$0 = SpillingKt.nullOutSpilledVariable(title);
                c00141.L$1 = SpillingKt.nullOutSpilledVariable(year);
                c00141.L$2 = "https://api.themoviedb.org/3";
                c00141.L$3 = "1865f43a0549ca50d341dd9ab8b29f49";
                c00141.L$4 = type4;
                c00141.L$5 = SpillingKt.nullOutSpilledVariable(searchUrl2);
                c00141.Z$0 = isSeries;
                c00141.label = 1;
                String type5 = type4;
                C00141 c00143 = c00141;
                obj = coroutine_suspended;
                Object obj3 = Requests.get$default(app, searchUrl2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00143, 4094, (Object) null);
                c00142 = c00143;
                if (obj3 == obj) {
                    return obj;
                }
                TMDB_API = "https://api.themoviedb.org/3";
                TMDB_API_KEY = "1865f43a0549ca50d341dd9ab8b29f49";
                type = type5;
                year2 = year;
                TMDB_API_KEY2 = searchUrl2;
                obj2 = obj3;
                isSeries2 = isSeries;
                title2 = title;
                searchJson = new JSONObject(((NiceResponse) obj2).getText());
                results = searchJson.optJSONArray("results");
                if (results != null || (jSONObjectOptJSONObject = results.optJSONObject(0)) == null) {
                    tmdbId = null;
                } else {
                    tmdbId = Boxing.boxInt(jSONObjectOptJSONObject.optInt("id"));
                }
                if (tmdbId != null) {
                    int id = tmdbId.intValue();
                    String extUrl = TMDB_API + '/' + type + '/' + id + "/external_ids?api_key=" + TMDB_API_KEY;
                    Requests app2 = MainActivityKt.getApp();
                    c00142.L$0 = SpillingKt.nullOutSpilledVariable(title2);
                    c00142.L$1 = SpillingKt.nullOutSpilledVariable(year2);
                    c00142.L$2 = SpillingKt.nullOutSpilledVariable(TMDB_API);
                    c00142.L$3 = SpillingKt.nullOutSpilledVariable(TMDB_API_KEY);
                    c00142.L$4 = SpillingKt.nullOutSpilledVariable(type);
                    c00142.L$5 = SpillingKt.nullOutSpilledVariable(TMDB_API_KEY2);
                    c00142.L$6 = SpillingKt.nullOutSpilledVariable(searchJson);
                    c00142.L$7 = SpillingKt.nullOutSpilledVariable(results);
                    c00142.L$8 = tmdbId;
                    c00142.L$9 = SpillingKt.nullOutSpilledVariable(extUrl);
                    c00142.Z$0 = isSeries2;
                    c00142.I$0 = id;
                    c00142.label = 2;
                    type2 = type;
                    TMDB_API_KEY3 = TMDB_API_KEY;
                    TMDB_API2 = TMDB_API;
                    tmdbId2 = tmdbId;
                    isSeries3 = isSeries2;
                    $result = Requests.get$default(app2, extUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00142, 4094, (Object) null);
                    if ($result == obj) {
                        return obj;
                    }
                    title3 = title2;
                    year3 = year2;
                    searchUrl = TMDB_API_KEY2;
                    TMDB_API3 = TMDB_API2;
                    isSeries4 = isSeries3;
                    searchJson2 = searchJson;
                    type3 = type2;
                    TMDB_API_KEY4 = TMDB_API_KEY3;
                    results2 = results;
                    tmdbId3 = tmdbId2;
                    JSONObject extJson = new JSONObject(((NiceResponse) $result).getText());
                    String it = extJson.optString("imdb_id");
                    str2 = StringsKt.isBlank(it) ? null : it;
                    tmdbId = tmdbId3;
                }
                String imdbId = str2;
                return new IdResult(tmdbId, imdbId);
            case 1:
                boolean isSeries5 = c00141.Z$0;
                String searchUrl3 = (String) c00141.L$5;
                type = (String) c00141.L$4;
                TMDB_API_KEY = (String) c00141.L$3;
                TMDB_API = (String) c00141.L$2;
                Integer year4 = (Integer) c00141.L$1;
                String title4 = (String) c00141.L$0;
                ResultKt.throwOnFailure($result);
                c00142 = c00141;
                obj = coroutine_suspended;
                TMDB_API_KEY2 = searchUrl3;
                year2 = year4;
                isSeries2 = isSeries5;
                obj2 = $result;
                title2 = title4;
                searchJson = new JSONObject(((NiceResponse) obj2).getText());
                results = searchJson.optJSONArray("results");
                if (results != null) {
                    tmdbId = null;
                } else {
                    tmdbId = null;
                }
                if (tmdbId != null) {
                    int id2 = tmdbId.intValue();
                    String extUrl2 = TMDB_API + '/' + type + '/' + id2 + "/external_ids?api_key=" + TMDB_API_KEY;
                    Requests app3 = MainActivityKt.getApp();
                    c00142.L$0 = SpillingKt.nullOutSpilledVariable(title2);
                    c00142.L$1 = SpillingKt.nullOutSpilledVariable(year2);
                    c00142.L$2 = SpillingKt.nullOutSpilledVariable(TMDB_API);
                    c00142.L$3 = SpillingKt.nullOutSpilledVariable(TMDB_API_KEY);
                    c00142.L$4 = SpillingKt.nullOutSpilledVariable(type);
                    c00142.L$5 = SpillingKt.nullOutSpilledVariable(TMDB_API_KEY2);
                    c00142.L$6 = SpillingKt.nullOutSpilledVariable(searchJson);
                    c00142.L$7 = SpillingKt.nullOutSpilledVariable(results);
                    c00142.L$8 = tmdbId;
                    c00142.L$9 = SpillingKt.nullOutSpilledVariable(extUrl2);
                    c00142.Z$0 = isSeries2;
                    c00142.I$0 = id2;
                    c00142.label = 2;
                    type2 = type;
                    TMDB_API_KEY3 = TMDB_API_KEY;
                    TMDB_API2 = TMDB_API;
                    tmdbId2 = tmdbId;
                    isSeries3 = isSeries2;
                    $result = Requests.get$default(app3, extUrl2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00142, 4094, (Object) null);
                    if ($result == obj) {
                        return obj;
                    }
                    title3 = title2;
                    year3 = year2;
                    searchUrl = TMDB_API_KEY2;
                    TMDB_API3 = TMDB_API2;
                    isSeries4 = isSeries3;
                    searchJson2 = searchJson;
                    type3 = type2;
                    TMDB_API_KEY4 = TMDB_API_KEY3;
                    results2 = results;
                    tmdbId3 = tmdbId2;
                    JSONObject extJson2 = new JSONObject(((NiceResponse) $result).getText());
                    String it2 = extJson2.optString("imdb_id");
                    if (StringsKt.isBlank(it2)) {
                    }
                    tmdbId = tmdbId3;
                }
                String imdbId2 = str2;
                return new IdResult(tmdbId, imdbId2);
            case 2:
                int i = c00141.I$0;
                isSeries4 = c00141.Z$0;
                tmdbId3 = (Integer) c00141.L$8;
                results2 = (JSONArray) c00141.L$7;
                searchJson2 = (JSONObject) c00141.L$6;
                searchUrl = (String) c00141.L$5;
                type3 = (String) c00141.L$4;
                TMDB_API_KEY4 = (String) c00141.L$3;
                TMDB_API3 = (String) c00141.L$2;
                year3 = (Integer) c00141.L$1;
                title3 = (String) c00141.L$0;
                ResultKt.throwOnFailure($result);
                JSONObject extJson3 = new JSONObject(((NiceResponse) $result).getText());
                String it3 = extJson3.optString("imdb_id");
                if (StringsKt.isBlank(it3)) {
                }
                tmdbId = tmdbId3;
                String imdbId3 = str2;
                return new IdResult(tmdbId, imdbId3);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public static final Object fetchMetaData(String imdbId, TvType type, Continuation<? super JsonNode> continuation) {
        C00151 c00151;
        if (continuation instanceof C00151) {
            c00151 = (C00151) continuation;
            if ((c00151.label & Integer.MIN_VALUE) != 0) {
                c00151.label -= Integer.MIN_VALUE;
            } else {
                c00151 = new C00151(continuation);
            }
        } else {
            c00151 = new C00151(continuation);
        }
        C00151 c00152 = c00151;
        Object $result = c00152.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00152.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String str = imdbId;
                if (str == null || StringsKt.isBlank(str)) {
                    return null;
                }
                String metaType = type == TvType.TvSeries ? "series" : "movie";
                String url = "https://v3-cinemeta.strem.io/meta/" + metaType + '/' + imdbId + ".json";
                try {
                    Requests app = MainActivityKt.getApp();
                    c00152.L$0 = SpillingKt.nullOutSpilledVariable(imdbId);
                    c00152.L$1 = SpillingKt.nullOutSpilledVariable(type);
                    c00152.L$2 = SpillingKt.nullOutSpilledVariable(metaType);
                    c00152.L$3 = SpillingKt.nullOutSpilledVariable(url);
                    c00152.label = 1;
                    try {
                        Object obj = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00152, 4094, (Object) null);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result = obj;
                    } catch (Exception e) {
                        return null;
                    }
                } catch (Exception e2) {
                    return null;
                }
                break;
                break;
            case 1:
                try {
                    ResultKt.throwOnFailure($result);
                } catch (Exception e3) {
                    return null;
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        try {
            String resp = ((NiceResponse) $result).getText();
            return MainAPIKt.getMapper().readTree(resp).get("meta");
        } catch (Exception e4) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:34:0x00f9 A[Catch: all -> 0x0120, TryCatch #0 {all -> 0x0120, blocks: (B:32:0x00e5, B:34:0x00f9, B:42:0x011a), top: B:56:0x00e5 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x010e  */
    /* JADX WARN: Code duplicated, block: B:37:0x0110  */
    /* JADX WARN: Code duplicated, block: B:39:0x0114  */
    /* JADX WARN: Code duplicated, block: B:40:0x0115  */
    /* JADX WARN: Code duplicated, block: B:41:0x0118  */
    /* JADX WARN: Code duplicated, block: B:54:0x013e  */
    /* JADX WARN: Code duplicated, block: B:64:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    public static final Object fetchSimklId(String imdbId, boolean isSeries, Continuation<? super Integer> continuation) {
        C00161 c00161;
        Object obj;
        JSONObject jSONObjectOptJSONObject;
        Integer numBoxInt;
        int it;
        int i;
        if (continuation instanceof C00161) {
            c00161 = (C00161) continuation;
            if ((c00161.label & Integer.MIN_VALUE) != 0) {
                c00161.label -= Integer.MIN_VALUE;
            } else {
                c00161 = new C00161(continuation);
            }
        } else {
            c00161 = new C00161(continuation);
        }
        C00161 c00162 = c00161;
        Object $result = c00162.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00162.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                try {
                    Result.Companion companion = Result.Companion;
                    String type = isSeries ? "tv" : "movies";
                    String url = "https://api.simkl.com/" + type + '/' + imdbId + "?client_id=39f470a9f2ec1aa2383269ca831bc7be0e47da48d6d708ccad9bed4e1a60993e";
                    Requests app = MainActivityKt.getApp();
                    c00162.L$0 = SpillingKt.nullOutSpilledVariable(imdbId);
                    c00162.L$1 = SpillingKt.nullOutSpilledVariable(type);
                    c00162.L$2 = SpillingKt.nullOutSpilledVariable(url);
                    c00162.Z$0 = isSeries;
                    c00162.label = 1;
                    try {
                        Object obj2 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00162, 4094, (Object) null);
                        if (obj2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result = obj2;
                        try {
                            jSONObjectOptJSONObject = new JSONObject(((NiceResponse) $result).getText()).optJSONObject("ids");
                            if (jSONObjectOptJSONObject != null) {
                                numBoxInt = Boxing.boxInt(jSONObjectOptJSONObject.optInt("simkl"));
                                it = numBoxInt.intValue();
                                if (it != 0) {
                                    i = 1;
                                } else {
                                    i = 0;
                                }
                                if (i != 0) {
                                    numBoxInt = null;
                                }
                            } else {
                                numBoxInt = null;
                            }
                            obj = Result.constructor-impl(numBoxInt);
                            break;
                        } catch (Throwable th) {
                            th = th;
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        if (Result.isFailure-impl(obj)) {
                            return null;
                        }
                        return obj;
                    } catch (Throwable th2) {
                        th = th2;
                        Result.Companion companion3 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                        if (Result.isFailure-impl(obj)) {
                            return null;
                        }
                        return obj;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
                break;
            case 1:
                boolean z = c00162.Z$0;
                try {
                    ResultKt.throwOnFailure($result);
                    jSONObjectOptJSONObject = new JSONObject(((NiceResponse) $result).getText()).optJSONObject("ids");
                    if (jSONObjectOptJSONObject != null) {
                        numBoxInt = Boxing.boxInt(jSONObjectOptJSONObject.optInt("simkl"));
                        it = numBoxInt.intValue();
                        if (it != 0) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                        if (i != 0) {
                            numBoxInt = null;
                        }
                    } else {
                        numBoxInt = null;
                    }
                    obj = Result.constructor-impl(numBoxInt);
                    break;
                } catch (Throwable th4) {
                    th = th4;
                    Result.Companion companion4 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                    if (Result.isFailure-impl(obj)) {
                        return null;
                    }
                    return obj;
                }
                if (Result.isFailure-impl(obj)) {
                    return null;
                }
                return obj;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
