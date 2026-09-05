package com.MovieBox;

import com.fasterxml.jackson.databind.JsonNode;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.utils.Qualities;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: MovieBoxProvider.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/MovieBoxProvider/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010\u0004\u001a\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0002\u001a:\u0010\u0007\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b2\u0006\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00012\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0082@¢\u0006\u0002\u0010\r\u001a:\u0010\u000e\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b2\u0006\u0010\u000f\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00012\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0082@¢\u0006\u0002\u0010\r\u001a\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0002\u001a\"\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0018\u001a\u00020\u0019H\u0082@¢\u0006\u0002\u0010\u001a\u001a<\u0010\u001b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u00012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003H\u0082@¢\u0006\u0002\u0010 ¨\u0006!"}, d2 = {"getHighestQuality", "", "input", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "cleanTitle", "s", "identifyID", "Lkotlin/Pair;", "title", "year", "imdbRatingValue", "", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchAndPick", "normTitle", "tokenEquals", "", "a", "b", "normalize", "fetchMetaData", "Lcom/fasterxml/jackson/databind/JsonNode;", "imdbId", "type", "Lcom/lagradost/cloudstream3/TvType;", "(Ljava/lang/String;Lcom/lagradost/cloudstream3/TvType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchTmdbLogoUrl", "tmdbAPI", "apiKey", "tmdbId", "appLangCode", "(Ljava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/TvType;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "MovieBoxProvider"}, k = 2, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMovieBoxProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MovieBoxProvider.kt\ncom/MovieBox/MovieBoxProviderKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1185:1\n777#2:1186\n873#2,2:1187\n777#2:1189\n873#2,2:1190\n777#2:1192\n873#2,2:1193\n1#3:1195\n*S KotlinDebug\n*F\n+ 1 MovieBoxProvider.kt\ncom/MovieBox/MovieBoxProviderKt\n*L\n1020#1:1186\n1020#1:1187,2\n1079#1:1189\n1079#1:1190,2\n1080#1:1192\n1080#1:1193,2\n*E\n"})
public final class MovieBoxProviderKt {

    /* JADX INFO: renamed from: com.MovieBox.MovieBoxProviderKt$fetchMetaData$1 */
    /* JADX INFO: compiled from: MovieBoxProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.MovieBox.MovieBoxProviderKt", f = "MovieBoxProvider.kt", i = {0, 0, 0, 0}, l = {1105}, m = "fetchMetaData", n = {"imdbId", "type", "metaType", "url"}, nl = {1106}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 2)
    static final class C00091 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C00091(Continuation<? super C00091> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MovieBoxProviderKt.fetchMetaData(null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.MovieBox.MovieBoxProviderKt$fetchTmdbLogoUrl$1 */
    /* JADX INFO: compiled from: MovieBoxProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.MovieBox.MovieBoxProviderKt", f = "MovieBoxProvider.kt", i = {0, 0, 0, 0, 0, 0}, l = {1127}, m = "fetchTmdbLogoUrl", n = {"tmdbAPI", "apiKey", "type", "tmdbId", "appLangCode", "url"}, nl = {1127}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
    static final class C00101 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C00101(Continuation<? super C00101> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MovieBoxProviderKt.fetchTmdbLogoUrl(null, null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.MovieBox.MovieBoxProviderKt$identifyID$1 */
    /* JADX INFO: compiled from: MovieBoxProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.MovieBox.MovieBoxProviderKt", f = "MovieBoxProvider.kt", i = {0, 0, 0, 0}, l = {967}, m = "identifyID", n = {"title", "year", "imdbRatingValue", "normTitle"}, nl = {968}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 2)
    static final class C00111 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C00111(Continuation<? super C00111> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MovieBoxProviderKt.identifyID(null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.MovieBox.MovieBoxProviderKt$searchAndPick$1 */
    /* JADX INFO: compiled from: MovieBoxProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.MovieBox.MovieBoxProviderKt", f = "MovieBoxProvider.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {990, 993, 994, 1071}, m = "searchAndPick", n = {"normTitle", "year", "imdbRatingValue", "normTitle", "year", "imdbRatingValue", "multiResults", "normTitle", "year", "imdbRatingValue", "multiResults", "normTitle", "year", "imdbRatingValue", "multiResults", "searchQueues", "bestId", "detailKind", "detailUrl", "bestScore", "bestIsTv"}, nl = {992, 992, 992, 1072}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "D$0", "I$0"}, v = 2)
    static final class C00121 extends ContinuationImpl {
        double D$0;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        C00121(Continuation<? super C00121> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MovieBoxProviderKt.searchAndPick(null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer getHighestQuality(String input) {
        List<Pair> qualities = CollectionsKt.listOf(new Pair[]{TuplesKt.to("2160", Integer.valueOf(Qualities.P2160.getValue())), TuplesKt.to("1440", Integer.valueOf(Qualities.P1440.getValue())), TuplesKt.to("1080", Integer.valueOf(Qualities.P1080.getValue())), TuplesKt.to("720", Integer.valueOf(Qualities.P720.getValue())), TuplesKt.to("480", Integer.valueOf(Qualities.P480.getValue())), TuplesKt.to("360", Integer.valueOf(Qualities.P360.getValue())), TuplesKt.to("240", Integer.valueOf(Qualities.P240.getValue()))});
        for (Pair pair : qualities) {
            String label = (String) pair.component1();
            int mappedValue = ((Number) pair.component2()).intValue();
            if (StringsKt.contains(input, label, true)) {
                return Integer.valueOf(mappedValue);
            }
        }
        return null;
    }

    private static final String cleanTitle(String s) {
        String lowerCase = s.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return StringsKt.trim(new Regex("\\s+").replace(new Regex("[^a-z0-9 ]").replace(lowerCase, " "), " ")).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object identifyID(String title, Integer year, Double imdbRatingValue, Continuation<? super Pair<Integer, String>> continuation) throws JSONException {
        C00111 c00111;
        Object objSearchAndPick;
        if (continuation instanceof C00111) {
            c00111 = (C00111) continuation;
            if ((c00111.label & Integer.MIN_VALUE) != 0) {
                c00111.label -= Integer.MIN_VALUE;
            } else {
                c00111 = new C00111(continuation);
            }
        } else {
            c00111 = new C00111(continuation);
        }
        Object $result = c00111.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00111.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String normTitle = normalize(title);
                c00111.L$0 = SpillingKt.nullOutSpilledVariable(title);
                c00111.L$1 = SpillingKt.nullOutSpilledVariable(year);
                c00111.L$2 = SpillingKt.nullOutSpilledVariable(imdbRatingValue);
                c00111.L$3 = SpillingKt.nullOutSpilledVariable(normTitle);
                c00111.label = 1;
                objSearchAndPick = searchAndPick(normTitle, year, imdbRatingValue, c00111);
                if (objSearchAndPick == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                objSearchAndPick = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Pair res = (Pair) objSearchAndPick;
        return res.getFirst() != null ? res : new Pair((Object) null, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:100:0x03cd  */
    /* JADX WARN: Code duplicated, block: B:103:0x03d2  */
    /* JADX WARN: Code duplicated, block: B:104:0x03df  */
    /* JADX WARN: Code duplicated, block: B:111:0x0443  */
    /* JADX WARN: Code duplicated, block: B:123:0x0501  */
    /* JADX WARN: Code duplicated, block: B:124:0x0508  */
    /* JADX WARN: Code duplicated, block: B:127:0x050f A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:131:0x0424 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:132:0x0228 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:141:0x02bf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:142:0x036e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:143:0x031c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:144:0x035b A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x014b  */
    /* JADX WARN: Code duplicated, block: B:27:0x0165  */
    /* JADX WARN: Code duplicated, block: B:30:0x0190 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:31:0x0191  */
    /* JADX WARN: Code duplicated, block: B:34:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:35:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:38:0x01ec A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:39:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:43:0x0212  */
    /* JADX WARN: Code duplicated, block: B:47:0x0236  */
    /* JADX WARN: Code duplicated, block: B:49:0x0243  */
    /* JADX WARN: Code duplicated, block: B:50:0x024c  */
    /* JADX WARN: Code duplicated, block: B:52:0x0254  */
    /* JADX WARN: Code duplicated, block: B:53:0x0256  */
    /* JADX WARN: Code duplicated, block: B:56:0x0265  */
    /* JADX WARN: Code duplicated, block: B:59:0x02a6  */
    /* JADX WARN: Code duplicated, block: B:61:0x02bc  */
    /* JADX WARN: Code duplicated, block: B:65:0x02d1  */
    /* JADX WARN: Code duplicated, block: B:66:0x02d8  */
    /* JADX WARN: Code duplicated, block: B:70:0x030a  */
    /* JADX WARN: Code duplicated, block: B:73:0x0328  */
    /* JADX WARN: Code duplicated, block: B:75:0x0340  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:83:0x037d A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:89:0x0390  */
    /* JADX WARN: Code duplicated, block: B:93:0x03a6  */
    /* JADX WARN: Code duplicated, block: B:94:0x03ab  */
    /* JADX WARN: Code duplicated, block: B:96:0x03b1  */
    /* JADX WARN: Code duplicated, block: B:99:0x03bb  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r24v0 */
    /* JADX WARN: Type inference failed for: r24v1 */
    /* JADX WARN: Type inference failed for: r24v2 */
    /* JADX WARN: Type inference failed for: r24v3 */
    /* JADX WARN: Type inference failed for: r24v4 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15, types: [int] */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v42 */
    /* JADX WARN: Type inference failed for: r4v50 */
    /* JADX WARN: Type inference failed for: r4v51 */
    public static final Object searchAndPick(String str, Integer num, Double d, Continuation<? super Pair<Integer, String>> continuation) throws JSONException {
        C00121 c00121;
        Object obj;
        Double d2;
        JSONArray jSONArray;
        Pair[] pairArr;
        String str2;
        Object objSearchAndPick$doSearch;
        Object obj2;
        Pair[] pairArr2;
        int i;
        Double d3;
        String str3;
        String str4;
        Object objSearchAndPick$doSearch2;
        Double d4;
        JSONArray jSONArray2;
        String str5;
        Pair[] pairArr3;
        int i2;
        List listListOf;
        double d5;
        Iterator it;
        Integer numBoxInt;
        ?? r4;
        Object obj3;
        String str6;
        Integer num2;
        String str7;
        JSONArray jSONArray3;
        String str8;
        int length;
        int i3;
        JSONObject jSONObject;
        int i4;
        String strOptString;
        int iOptInt;
        String str9;
        boolean zAreEqual;
        List listListOf2;
        ArrayList arrayList;
        String strOptString2;
        Integer intOrNull;
        double dOptDouble;
        String strCleanTitle;
        Iterator it2;
        double dMax;
        double dCoerceAtMost;
        double dAbs;
        String strCleanTitle2;
        JSONObject jSONObjectOptJSONObject;
        String strOptString3;
        String str10 = str;
        Integer num3 = num;
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
        Object obj4 = c00121.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String str11 = "multi";
        String str12 = "movie";
        switch (c00121.label) {
            case 0:
                ResultKt.throwOnFailure(obj4);
                String str13 = "&query=" + str10 + (num3 != null ? "&year=" + num3.intValue() : "");
                c00121.L$0 = str10;
                c00121.L$1 = num3;
                c00121.L$2 = d;
                c00121.label = 1;
                Object objSearchAndPick$doSearch3 = searchAndPick$doSearch("search/multi", str13, c00121);
                if (objSearchAndPick$doSearch3 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = objSearchAndPick$doSearch3;
                d2 = d;
                jSONArray = (JSONArray) obj;
                pairArr = new Pair[3];
                pairArr[0] = TuplesKt.to("multi", jSONArray);
                StringBuilder sbAppend = new StringBuilder().append("&query=").append(str10);
                if (num3 != null) {
                    str2 = "&first_air_date_year=" + num3.intValue();
                } else {
                    str2 = "";
                }
                String string = sbAppend.append(str2).toString();
                c00121.L$0 = str10;
                c00121.L$1 = num3;
                c00121.L$2 = d2;
                c00121.L$3 = SpillingKt.nullOutSpilledVariable(jSONArray);
                c00121.L$4 = pairArr;
                c00121.L$5 = pairArr;
                c00121.L$6 = "tv";
                c00121.I$0 = 1;
                c00121.label = 2;
                objSearchAndPick$doSearch = searchAndPick$doSearch("search/tv", string, c00121);
                if (objSearchAndPick$doSearch == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj2 = objSearchAndPick$doSearch;
                pairArr2 = pairArr;
                i = 1;
                d3 = d2;
                str3 = "tv";
                pairArr[i] = TuplesKt.to(str3, obj2);
                StringBuilder sbAppend2 = new StringBuilder().append("&query=").append(str10);
                if (num3 != null) {
                    str4 = "&year=" + num3.intValue();
                } else {
                    str4 = "";
                }
                String string2 = sbAppend2.append(str4).toString();
                c00121.L$0 = str10;
                c00121.L$1 = num3;
                c00121.L$2 = d3;
                c00121.L$3 = SpillingKt.nullOutSpilledVariable(jSONArray);
                c00121.L$4 = pairArr2;
                c00121.L$5 = pairArr2;
                c00121.L$6 = "movie";
                c00121.I$0 = 2;
                c00121.label = 3;
                objSearchAndPick$doSearch2 = searchAndPick$doSearch("search/movie", string2, c00121);
                if (objSearchAndPick$doSearch2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                d4 = d3;
                jSONArray2 = jSONArray;
                str5 = "movie";
                pairArr3 = pairArr2;
                i2 = 2;
                pairArr3[i2] = TuplesKt.to(str5, objSearchAndPick$doSearch2);
                listListOf = CollectionsKt.listOf(pairArr2);
                d5 = -1.0d;
                it = listListOf.iterator();
                numBoxInt = null;
                r4 = 0;
                while (it.hasNext()) {
                    Pair pair = (Pair) it.next();
                    str7 = (String) pair.component1();
                    jSONArray3 = (JSONArray) pair.component2();
                    if (jSONArray3 != null) {
                        str8 = str10;
                        length = jSONArray3.length();
                        List list = listListOf;
                        i3 = 0;
                        r4 = r4;
                        while (i3 < length) {
                            int i5 = length;
                            jSONObject = jSONArray3.getJSONObject(i3);
                            if (Intrinsics.areEqual(str7, str11)) {
                                i4 = i3;
                                strOptString = jSONObject.optString("media_type", "");
                            } else {
                                i4 = i3;
                                if (Intrinsics.areEqual(str7, "tv")) {
                                    strOptString = "tv";
                                } else {
                                    strOptString = str12;
                                }
                            }
                            ?? r24 = r4;
                            Object obj5 = coroutine_suspended;
                            iOptInt = jSONObject.optInt("id", -1);
                            if (iOptInt != -1) {
                                str9 = str11;
                                listListOf2 = CollectionsKt.listOf(new String[]{jSONObject.optString("title"), jSONObject.optString("name"), jSONObject.optString("original_title"), jSONObject.optString("original_name")});
                                arrayList = new ArrayList();
                                for (Object obj6 : listListOf2) {
                                    List list2 = listListOf2;
                                    if (!StringsKt.isBlank((String) obj6)) {
                                        arrayList.add(obj6);
                                    }
                                    listListOf2 = list2;
                                }
                                ArrayList arrayList2 = arrayList;
                                if (Intrinsics.areEqual(strOptString, "tv")) {
                                    strOptString2 = jSONObject.optString("first_air_date", "");
                                } else {
                                    strOptString2 = jSONObject.optString("release_date", "");
                                }
                                intOrNull = StringsKt.toIntOrNull(StringsKt.take(strOptString2, 4));
                                dOptDouble = jSONObject.optDouble("vote_average", Double.NaN);
                                strCleanTitle = cleanTitle(str8);
                                it2 = arrayList2.iterator();
                                dMax = 0.0d;
                                while (true) {
                                    if (it2.hasNext()) {
                                        d5 = d5;
                                        strCleanTitle2 = cleanTitle((String) it2.next());
                                        if (tokenEquals(strCleanTitle2, strCleanTitle)) {
                                            dMax = 50.0d;
                                        } else {
                                            strCleanTitle = strCleanTitle;
                                            str12 = str12;
                                            it = it;
                                            jSONArray3 = jSONArray3;
                                            if (!StringsKt.contains$default(strCleanTitle2, strCleanTitle, false, 2, (Object) null) || StringsKt.contains$default(strCleanTitle, strCleanTitle2, false, 2, (Object) null)) {
                                                dMax = Math.max(dMax, 20.0d);
                                            }
                                        }
                                    } else {
                                        d5 = d5;
                                    }
                                }
                                dCoerceAtMost = 0.0d + dMax;
                                if (intOrNull != null && num3 != null && Intrinsics.areEqual(intOrNull, num3)) {
                                    dCoerceAtMost += 35.0d;
                                }
                                if (d4 != null && !Double.isNaN(dOptDouble)) {
                                    dAbs = Math.abs(dOptDouble - d4.doubleValue());
                                    if (dAbs <= 0.5d) {
                                        dCoerceAtMost += 10.0d;
                                    } else if (dAbs <= 1.0d) {
                                        dCoerceAtMost += 5.0d;
                                    }
                                }
                                if (jSONObject.has("popularity")) {
                                    dCoerceAtMost += RangesKt.coerceAtMost(jSONObject.optDouble("popularity", 0.0d) / 100.0d, 5.0d);
                                }
                                if (dCoerceAtMost > d5) {
                                    d5 = dCoerceAtMost;
                                    numBoxInt = Boxing.boxInt(iOptInt);
                                    zAreEqual = Intrinsics.areEqual(strOptString, "tv");
                                }
                                i3 = i4 + 1;
                                str7 = str7;
                                it = it;
                                jSONArray3 = jSONArray3;
                                length = i5;
                                coroutine_suspended = obj5;
                                str11 = str9;
                                str12 = str12;
                                r4 = zAreEqual;
                            } else {
                                str9 = str11;
                                d5 = d5;
                                str12 = str12;
                                it = it;
                                jSONArray3 = jSONArray3;
                                str7 = str7;
                            }
                            zAreEqual = r24 == true ? 1 : 0;
                            numBoxInt = numBoxInt;
                            d5 = d5;
                            i3 = i4 + 1;
                            str7 = str7;
                            it = it;
                            jSONArray3 = jSONArray3;
                            length = i5;
                            coroutine_suspended = obj5;
                            str11 = str9;
                            str12 = str12;
                            r4 = zAreEqual;
                        }
                        str10 = str8;
                        listListOf = list;
                        it = it;
                    } else {
                        it = it;
                    }
                }
                String str14 = str10;
                List list3 = listListOf;
                Object obj7 = coroutine_suspended;
                String str15 = str12;
                if (numBoxInt != null || d5 < 40.0d) {
                    obj3 = null;
                    return new Pair(obj3, obj3);
                }
                String str16 = r4 != 0 ? "tv" : str15;
                String str17 = "https://api.themoviedb.org/3/" + str16 + '/' + numBoxInt.intValue() + "?api_key=1865f43a0549ca50d341dd9ab8b29f49&append_to_response=external_ids";
                Requests app = MainActivityKt.getApp();
                c00121.L$0 = SpillingKt.nullOutSpilledVariable(str14);
                c00121.L$1 = SpillingKt.nullOutSpilledVariable(num3);
                c00121.L$2 = SpillingKt.nullOutSpilledVariable(d4);
                c00121.L$3 = SpillingKt.nullOutSpilledVariable(jSONArray2);
                c00121.L$4 = SpillingKt.nullOutSpilledVariable(list3);
                c00121.L$5 = numBoxInt;
                c00121.L$6 = SpillingKt.nullOutSpilledVariable(str16);
                c00121.L$7 = SpillingKt.nullOutSpilledVariable(str17);
                c00121.D$0 = d5;
                c00121.I$0 = r4;
                c00121.label = 4;
                Integer num4 = numBoxInt;
                str6 = null;
                obj4 = Requests.get$default(app, str17, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00121, 4094, (Object) null);
                if (obj4 == obj7) {
                    return obj7;
                }
                num2 = num4;
                jSONObjectOptJSONObject = new JSONObject(((NiceResponse) obj4).getText()).optJSONObject("external_ids");
                if (jSONObjectOptJSONObject != null) {
                    strOptString3 = jSONObjectOptJSONObject.optString("imdb_id");
                } else {
                    strOptString3 = str6;
                }
                return new Pair(num2, strOptString3);
            case 1:
                d2 = (Double) c00121.L$2;
                num3 = (Integer) c00121.L$1;
                str10 = (String) c00121.L$0;
                ResultKt.throwOnFailure(obj4);
                obj = obj4;
                jSONArray = (JSONArray) obj;
                pairArr = new Pair[3];
                pairArr[0] = TuplesKt.to("multi", jSONArray);
                StringBuilder sbAppend3 = new StringBuilder().append("&query=").append(str10);
                if (num3 != null) {
                    str2 = "&first_air_date_year=" + num3.intValue();
                } else {
                    str2 = "";
                }
                String string3 = sbAppend3.append(str2).toString();
                c00121.L$0 = str10;
                c00121.L$1 = num3;
                c00121.L$2 = d2;
                c00121.L$3 = SpillingKt.nullOutSpilledVariable(jSONArray);
                c00121.L$4 = pairArr;
                c00121.L$5 = pairArr;
                c00121.L$6 = "tv";
                c00121.I$0 = 1;
                c00121.label = 2;
                objSearchAndPick$doSearch = searchAndPick$doSearch("search/tv", string3, c00121);
                if (objSearchAndPick$doSearch == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj2 = objSearchAndPick$doSearch;
                pairArr2 = pairArr;
                i = 1;
                d3 = d2;
                str3 = "tv";
                pairArr[i] = TuplesKt.to(str3, obj2);
                StringBuilder sbAppend4 = new StringBuilder().append("&query=").append(str10);
                if (num3 != null) {
                    str4 = "&year=" + num3.intValue();
                } else {
                    str4 = "";
                }
                String string4 = sbAppend4.append(str4).toString();
                c00121.L$0 = str10;
                c00121.L$1 = num3;
                c00121.L$2 = d3;
                c00121.L$3 = SpillingKt.nullOutSpilledVariable(jSONArray);
                c00121.L$4 = pairArr2;
                c00121.L$5 = pairArr2;
                c00121.L$6 = "movie";
                c00121.I$0 = 2;
                c00121.label = 3;
                objSearchAndPick$doSearch2 = searchAndPick$doSearch("search/movie", string4, c00121);
                if (objSearchAndPick$doSearch2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                d4 = d3;
                jSONArray2 = jSONArray;
                str5 = "movie";
                pairArr3 = pairArr2;
                i2 = 2;
                pairArr3[i2] = TuplesKt.to(str5, objSearchAndPick$doSearch2);
                listListOf = CollectionsKt.listOf(pairArr2);
                d5 = -1.0d;
                it = listListOf.iterator();
                numBoxInt = null;
                r4 = 0;
                while (it.hasNext()) {
                    Pair pair2 = (Pair) it.next();
                    str7 = (String) pair2.component1();
                    jSONArray3 = (JSONArray) pair2.component2();
                    if (jSONArray3 != null) {
                        str8 = str10;
                        length = jSONArray3.length();
                        List list4 = listListOf;
                        i3 = 0;
                        r4 = r4;
                        while (i3 < length) {
                            int i6 = length;
                            jSONObject = jSONArray3.getJSONObject(i3);
                            if (Intrinsics.areEqual(str7, str11)) {
                                i4 = i3;
                                strOptString = jSONObject.optString("media_type", "");
                            } else {
                                i4 = i3;
                                if (Intrinsics.areEqual(str7, "tv")) {
                                    strOptString = "tv";
                                } else {
                                    strOptString = str12;
                                }
                            }
                            ?? r25 = r4;
                            Object obj8 = coroutine_suspended;
                            iOptInt = jSONObject.optInt("id", -1);
                            if (iOptInt != -1) {
                                str9 = str11;
                                listListOf2 = CollectionsKt.listOf(new String[]{jSONObject.optString("title"), jSONObject.optString("name"), jSONObject.optString("original_title"), jSONObject.optString("original_name")});
                                arrayList = new ArrayList();
                                while (r30.hasNext()) {
                                    List list5 = listListOf2;
                                    if (!StringsKt.isBlank((String) obj6)) {
                                        arrayList.add(obj6);
                                    }
                                    listListOf2 = list5;
                                }
                                ArrayList arrayList3 = arrayList;
                                if (Intrinsics.areEqual(strOptString, "tv")) {
                                    strOptString2 = jSONObject.optString("first_air_date", "");
                                } else {
                                    strOptString2 = jSONObject.optString("release_date", "");
                                }
                                intOrNull = StringsKt.toIntOrNull(StringsKt.take(strOptString2, 4));
                                dOptDouble = jSONObject.optDouble("vote_average", Double.NaN);
                                strCleanTitle = cleanTitle(str8);
                                it2 = arrayList3.iterator();
                                dMax = 0.0d;
                                while (true) {
                                    if (it2.hasNext()) {
                                        d5 = d5;
                                        strCleanTitle2 = cleanTitle((String) it2.next());
                                        if (tokenEquals(strCleanTitle2, strCleanTitle)) {
                                            dMax = 50.0d;
                                        } else {
                                            strCleanTitle = strCleanTitle;
                                            str12 = str12;
                                            it = it;
                                            jSONArray3 = jSONArray3;
                                            if (!StringsKt.contains$default(strCleanTitle2, strCleanTitle, false, 2, (Object) null)) {
                                            }
                                            dMax = Math.max(dMax, 20.0d);
                                        }
                                    } else {
                                        d5 = d5;
                                    }
                                }
                                dCoerceAtMost = 0.0d + dMax;
                                if (intOrNull != null) {
                                    dCoerceAtMost += 35.0d;
                                }
                                if (d4 != null) {
                                    dAbs = Math.abs(dOptDouble - d4.doubleValue());
                                    if (dAbs <= 0.5d) {
                                        dCoerceAtMost += 10.0d;
                                    } else if (dAbs <= 1.0d) {
                                        dCoerceAtMost += 5.0d;
                                    }
                                }
                                if (jSONObject.has("popularity")) {
                                    dCoerceAtMost += RangesKt.coerceAtMost(jSONObject.optDouble("popularity", 0.0d) / 100.0d, 5.0d);
                                }
                                if (dCoerceAtMost > d5) {
                                    d5 = dCoerceAtMost;
                                    numBoxInt = Boxing.boxInt(iOptInt);
                                    zAreEqual = Intrinsics.areEqual(strOptString, "tv");
                                }
                                i3 = i4 + 1;
                                str7 = str7;
                                it = it;
                                jSONArray3 = jSONArray3;
                                length = i6;
                                coroutine_suspended = obj8;
                                str11 = str9;
                                str12 = str12;
                                r4 = zAreEqual;
                            } else {
                                str9 = str11;
                                d5 = d5;
                                str12 = str12;
                                it = it;
                                jSONArray3 = jSONArray3;
                                str7 = str7;
                            }
                            zAreEqual = r25 == true ? 1 : 0;
                            numBoxInt = numBoxInt;
                            d5 = d5;
                            i3 = i4 + 1;
                            str7 = str7;
                            it = it;
                            jSONArray3 = jSONArray3;
                            length = i6;
                            coroutine_suspended = obj8;
                            str11 = str9;
                            str12 = str12;
                            r4 = zAreEqual;
                        }
                        str10 = str8;
                        listListOf = list4;
                        it = it;
                    } else {
                        it = it;
                    }
                }
                String str18 = str10;
                List list6 = listListOf;
                Object obj9 = coroutine_suspended;
                String str19 = str12;
                if (numBoxInt != null) {
                    obj3 = null;
                } else {
                    obj3 = null;
                }
                return new Pair(obj3, obj3);
            case 2:
                int i7 = c00121.I$0;
                String str20 = (String) c00121.L$6;
                Pair[] pairArr4 = (Pair[]) c00121.L$5;
                Pair[] pairArr5 = (Pair[]) c00121.L$4;
                jSONArray = (JSONArray) c00121.L$3;
                Double d6 = (Double) c00121.L$2;
                num3 = (Integer) c00121.L$1;
                str10 = (String) c00121.L$0;
                ResultKt.throwOnFailure(obj4);
                str3 = str20;
                d3 = d6;
                i = i7;
                pairArr2 = pairArr5;
                pairArr = pairArr4;
                obj2 = obj4;
                pairArr[i] = TuplesKt.to(str3, obj2);
                StringBuilder sbAppend5 = new StringBuilder().append("&query=").append(str10);
                if (num3 != null) {
                    str4 = "&year=" + num3.intValue();
                } else {
                    str4 = "";
                }
                String string5 = sbAppend5.append(str4).toString();
                c00121.L$0 = str10;
                c00121.L$1 = num3;
                c00121.L$2 = d3;
                c00121.L$3 = SpillingKt.nullOutSpilledVariable(jSONArray);
                c00121.L$4 = pairArr2;
                c00121.L$5 = pairArr2;
                c00121.L$6 = "movie";
                c00121.I$0 = 2;
                c00121.label = 3;
                objSearchAndPick$doSearch2 = searchAndPick$doSearch("search/movie", string5, c00121);
                if (objSearchAndPick$doSearch2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                d4 = d3;
                jSONArray2 = jSONArray;
                str5 = "movie";
                pairArr3 = pairArr2;
                i2 = 2;
                pairArr3[i2] = TuplesKt.to(str5, objSearchAndPick$doSearch2);
                listListOf = CollectionsKt.listOf(pairArr2);
                d5 = -1.0d;
                it = listListOf.iterator();
                numBoxInt = null;
                r4 = 0;
                while (it.hasNext()) {
                    Pair pair3 = (Pair) it.next();
                    str7 = (String) pair3.component1();
                    jSONArray3 = (JSONArray) pair3.component2();
                    if (jSONArray3 != null) {
                        str8 = str10;
                        length = jSONArray3.length();
                        List list7 = listListOf;
                        i3 = 0;
                        r4 = r4;
                        while (i3 < length) {
                            int i8 = length;
                            jSONObject = jSONArray3.getJSONObject(i3);
                            if (Intrinsics.areEqual(str7, str11)) {
                                i4 = i3;
                                strOptString = jSONObject.optString("media_type", "");
                            } else {
                                i4 = i3;
                                if (Intrinsics.areEqual(str7, "tv")) {
                                    strOptString = "tv";
                                } else {
                                    strOptString = str12;
                                }
                            }
                            ?? r26 = r4;
                            Object obj10 = coroutine_suspended;
                            iOptInt = jSONObject.optInt("id", -1);
                            if (iOptInt != -1) {
                                str9 = str11;
                                listListOf2 = CollectionsKt.listOf(new String[]{jSONObject.optString("title"), jSONObject.optString("name"), jSONObject.optString("original_title"), jSONObject.optString("original_name")});
                                arrayList = new ArrayList();
                                while (r30.hasNext()) {
                                    List list8 = listListOf2;
                                    if (!StringsKt.isBlank((String) obj6)) {
                                        arrayList.add(obj6);
                                    }
                                    listListOf2 = list8;
                                }
                                ArrayList arrayList4 = arrayList;
                                if (Intrinsics.areEqual(strOptString, "tv")) {
                                    strOptString2 = jSONObject.optString("first_air_date", "");
                                } else {
                                    strOptString2 = jSONObject.optString("release_date", "");
                                }
                                intOrNull = StringsKt.toIntOrNull(StringsKt.take(strOptString2, 4));
                                dOptDouble = jSONObject.optDouble("vote_average", Double.NaN);
                                strCleanTitle = cleanTitle(str8);
                                it2 = arrayList4.iterator();
                                dMax = 0.0d;
                                while (true) {
                                    if (it2.hasNext()) {
                                        d5 = d5;
                                        strCleanTitle2 = cleanTitle((String) it2.next());
                                        if (tokenEquals(strCleanTitle2, strCleanTitle)) {
                                            dMax = 50.0d;
                                        } else {
                                            strCleanTitle = strCleanTitle;
                                            str12 = str12;
                                            it = it;
                                            jSONArray3 = jSONArray3;
                                            if (!StringsKt.contains$default(strCleanTitle2, strCleanTitle, false, 2, (Object) null)) {
                                            }
                                            dMax = Math.max(dMax, 20.0d);
                                        }
                                    } else {
                                        d5 = d5;
                                    }
                                }
                                dCoerceAtMost = 0.0d + dMax;
                                if (intOrNull != null) {
                                    dCoerceAtMost += 35.0d;
                                }
                                if (d4 != null) {
                                    dAbs = Math.abs(dOptDouble - d4.doubleValue());
                                    if (dAbs <= 0.5d) {
                                        dCoerceAtMost += 10.0d;
                                    } else if (dAbs <= 1.0d) {
                                        dCoerceAtMost += 5.0d;
                                    }
                                }
                                if (jSONObject.has("popularity")) {
                                    dCoerceAtMost += RangesKt.coerceAtMost(jSONObject.optDouble("popularity", 0.0d) / 100.0d, 5.0d);
                                }
                                if (dCoerceAtMost > d5) {
                                    d5 = dCoerceAtMost;
                                    numBoxInt = Boxing.boxInt(iOptInt);
                                    zAreEqual = Intrinsics.areEqual(strOptString, "tv");
                                }
                                i3 = i4 + 1;
                                str7 = str7;
                                it = it;
                                jSONArray3 = jSONArray3;
                                length = i8;
                                coroutine_suspended = obj10;
                                str11 = str9;
                                str12 = str12;
                                r4 = zAreEqual;
                            } else {
                                str9 = str11;
                                d5 = d5;
                                str12 = str12;
                                it = it;
                                jSONArray3 = jSONArray3;
                                str7 = str7;
                            }
                            zAreEqual = r26 == true ? 1 : 0;
                            numBoxInt = numBoxInt;
                            d5 = d5;
                            i3 = i4 + 1;
                            str7 = str7;
                            it = it;
                            jSONArray3 = jSONArray3;
                            length = i8;
                            coroutine_suspended = obj10;
                            str11 = str9;
                            str12 = str12;
                            r4 = zAreEqual;
                        }
                        str10 = str8;
                        listListOf = list7;
                        it = it;
                    } else {
                        it = it;
                    }
                }
                String str110 = str10;
                List list9 = listListOf;
                Object obj11 = coroutine_suspended;
                String str111 = str12;
                if (numBoxInt != null) {
                    obj3 = null;
                } else {
                    obj3 = null;
                }
                return new Pair(obj3, obj3);
            case 3:
                i2 = c00121.I$0;
                str5 = (String) c00121.L$6;
                pairArr3 = (Pair[]) c00121.L$5;
                pairArr2 = (Pair[]) c00121.L$4;
                JSONArray jSONArray4 = (JSONArray) c00121.L$3;
                Double d7 = (Double) c00121.L$2;
                num3 = (Integer) c00121.L$1;
                str10 = (String) c00121.L$0;
                ResultKt.throwOnFailure(obj4);
                objSearchAndPick$doSearch2 = obj4;
                jSONArray2 = jSONArray4;
                d4 = d7;
                pairArr3[i2] = TuplesKt.to(str5, objSearchAndPick$doSearch2);
                listListOf = CollectionsKt.listOf(pairArr2);
                d5 = -1.0d;
                it = listListOf.iterator();
                numBoxInt = null;
                r4 = 0;
                while (it.hasNext()) {
                    Pair pair4 = (Pair) it.next();
                    str7 = (String) pair4.component1();
                    jSONArray3 = (JSONArray) pair4.component2();
                    if (jSONArray3 != null) {
                        str8 = str10;
                        length = jSONArray3.length();
                        List list10 = listListOf;
                        i3 = 0;
                        r4 = r4;
                        while (i3 < length) {
                            int i9 = length;
                            jSONObject = jSONArray3.getJSONObject(i3);
                            if (Intrinsics.areEqual(str7, str11)) {
                                i4 = i3;
                                strOptString = jSONObject.optString("media_type", "");
                            } else {
                                i4 = i3;
                                if (Intrinsics.areEqual(str7, "tv")) {
                                    strOptString = "tv";
                                } else {
                                    strOptString = str12;
                                }
                            }
                            ?? r27 = r4;
                            Object obj12 = coroutine_suspended;
                            iOptInt = jSONObject.optInt("id", -1);
                            if (iOptInt != -1) {
                                str9 = str11;
                                listListOf2 = CollectionsKt.listOf(new String[]{jSONObject.optString("title"), jSONObject.optString("name"), jSONObject.optString("original_title"), jSONObject.optString("original_name")});
                                arrayList = new ArrayList();
                                while (r30.hasNext()) {
                                    List list11 = listListOf2;
                                    if (!StringsKt.isBlank((String) obj6)) {
                                        arrayList.add(obj6);
                                    }
                                    listListOf2 = list11;
                                }
                                ArrayList arrayList5 = arrayList;
                                if (Intrinsics.areEqual(strOptString, "tv")) {
                                    strOptString2 = jSONObject.optString("first_air_date", "");
                                } else {
                                    strOptString2 = jSONObject.optString("release_date", "");
                                }
                                intOrNull = StringsKt.toIntOrNull(StringsKt.take(strOptString2, 4));
                                dOptDouble = jSONObject.optDouble("vote_average", Double.NaN);
                                strCleanTitle = cleanTitle(str8);
                                it2 = arrayList5.iterator();
                                dMax = 0.0d;
                                while (true) {
                                    if (it2.hasNext()) {
                                        d5 = d5;
                                        strCleanTitle2 = cleanTitle((String) it2.next());
                                        if (tokenEquals(strCleanTitle2, strCleanTitle)) {
                                            dMax = 50.0d;
                                        } else {
                                            strCleanTitle = strCleanTitle;
                                            str12 = str12;
                                            it = it;
                                            jSONArray3 = jSONArray3;
                                            if (!StringsKt.contains$default(strCleanTitle2, strCleanTitle, false, 2, (Object) null)) {
                                            }
                                            dMax = Math.max(dMax, 20.0d);
                                        }
                                    } else {
                                        d5 = d5;
                                    }
                                }
                                dCoerceAtMost = 0.0d + dMax;
                                if (intOrNull != null) {
                                    dCoerceAtMost += 35.0d;
                                }
                                if (d4 != null) {
                                    dAbs = Math.abs(dOptDouble - d4.doubleValue());
                                    if (dAbs <= 0.5d) {
                                        dCoerceAtMost += 10.0d;
                                    } else if (dAbs <= 1.0d) {
                                        dCoerceAtMost += 5.0d;
                                    }
                                }
                                if (jSONObject.has("popularity")) {
                                    dCoerceAtMost += RangesKt.coerceAtMost(jSONObject.optDouble("popularity", 0.0d) / 100.0d, 5.0d);
                                }
                                if (dCoerceAtMost > d5) {
                                    d5 = dCoerceAtMost;
                                    numBoxInt = Boxing.boxInt(iOptInt);
                                    zAreEqual = Intrinsics.areEqual(strOptString, "tv");
                                }
                                i3 = i4 + 1;
                                str7 = str7;
                                it = it;
                                jSONArray3 = jSONArray3;
                                length = i9;
                                coroutine_suspended = obj12;
                                str11 = str9;
                                str12 = str12;
                                r4 = zAreEqual;
                            } else {
                                str9 = str11;
                                d5 = d5;
                                str12 = str12;
                                it = it;
                                jSONArray3 = jSONArray3;
                                str7 = str7;
                            }
                            zAreEqual = r27 == true ? 1 : 0;
                            numBoxInt = numBoxInt;
                            d5 = d5;
                            i3 = i4 + 1;
                            str7 = str7;
                            it = it;
                            jSONArray3 = jSONArray3;
                            length = i9;
                            coroutine_suspended = obj12;
                            str11 = str9;
                            str12 = str12;
                            r4 = zAreEqual;
                        }
                        str10 = str8;
                        listListOf = list10;
                        it = it;
                    } else {
                        it = it;
                    }
                }
                String str112 = str10;
                List list12 = listListOf;
                Object obj13 = coroutine_suspended;
                String str113 = str12;
                if (numBoxInt != null) {
                    obj3 = null;
                } else {
                    obj3 = null;
                }
                return new Pair(obj3, obj3);
            case 4:
                int i10 = c00121.I$0;
                double d8 = c00121.D$0;
                num2 = (Integer) c00121.L$5;
                ResultKt.throwOnFailure(obj4);
                str6 = null;
                jSONObjectOptJSONObject = new JSONObject(((NiceResponse) obj4).getText()).optJSONObject("external_ids");
                if (jSONObjectOptJSONObject != null) {
                    strOptString3 = jSONObjectOptJSONObject.optString("imdb_id");
                } else {
                    strOptString3 = str6;
                }
                return new Pair(num2, strOptString3);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public static final Object searchAndPick$doSearch(String endpoint, String extraParams, Continuation<? super JSONArray> continuation) {
        MovieBoxProviderKt$searchAndPick$doSearch$1 movieBoxProviderKt$searchAndPick$doSearch$1;
        if (continuation instanceof MovieBoxProviderKt$searchAndPick$doSearch$1) {
            movieBoxProviderKt$searchAndPick$doSearch$1 = (MovieBoxProviderKt$searchAndPick$doSearch$1) continuation;
            if ((movieBoxProviderKt$searchAndPick$doSearch$1.label & Integer.MIN_VALUE) != 0) {
                movieBoxProviderKt$searchAndPick$doSearch$1.label -= Integer.MIN_VALUE;
            } else {
                movieBoxProviderKt$searchAndPick$doSearch$1 = new MovieBoxProviderKt$searchAndPick$doSearch$1(continuation);
            }
        } else {
            movieBoxProviderKt$searchAndPick$doSearch$1 = new MovieBoxProviderKt$searchAndPick$doSearch$1(continuation);
        }
        Object $result = movieBoxProviderKt$searchAndPick$doSearch$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (movieBoxProviderKt$searchAndPick$doSearch$1.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                StringBuilder $this$searchAndPick_u24doSearch_u24lambda_u240 = new StringBuilder();
                $this$searchAndPick_u24doSearch_u24lambda_u240.append("https://api.themoviedb.org/3/").append(endpoint);
                $this$searchAndPick_u24doSearch_u24lambda_u240.append("?api_key=").append("1865f43a0549ca50d341dd9ab8b29f49");
                $this$searchAndPick_u24doSearch_u24lambda_u240.append(extraParams);
                $this$searchAndPick_u24doSearch_u24lambda_u240.append("&include_adult=false&page=1");
                String url = $this$searchAndPick_u24doSearch_u24lambda_u240.toString();
                Requests app = MainActivityKt.getApp();
                movieBoxProviderKt$searchAndPick$doSearch$1.L$0 = SpillingKt.nullOutSpilledVariable(endpoint);
                movieBoxProviderKt$searchAndPick$doSearch$1.L$1 = SpillingKt.nullOutSpilledVariable(extraParams);
                movieBoxProviderKt$searchAndPick$doSearch$1.L$2 = SpillingKt.nullOutSpilledVariable(url);
                movieBoxProviderKt$searchAndPick$doSearch$1.label = 1;
                $result = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, movieBoxProviderKt$searchAndPick$doSearch$1, 4094, (Object) null);
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
        String text = ((NiceResponse) $result).getText();
        return new JSONObject(text).optJSONArray("results");
    }

    static /* synthetic */ Object searchAndPick$doSearch$default(String str, String str2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        return searchAndPick$doSearch(str, str2, continuation);
    }

    private static final boolean tokenEquals(String a, String b) {
        Iterable $this$filter$iv = new Regex("\\s+").split(a, 0);
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            String it = (String) element$iv$iv;
            if (!StringsKt.isBlank(it)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Set sa = CollectionsKt.toSet((List) destination$iv$iv);
        Iterable $this$filter$iv2 = new Regex("\\s+").split(b, 0);
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv2 : $this$filter$iv2) {
            String it2 = (String) element$iv$iv2;
            if (!StringsKt.isBlank(it2)) {
                destination$iv$iv2.add(element$iv$iv2);
            }
        }
        Set sb = CollectionsKt.toSet((List) destination$iv$iv2);
        if (sa.isEmpty() || sb.isEmpty()) {
            return false;
        }
        int inter = CollectionsKt.intersect(sa, sb).size();
        return inter >= Math.max(1, (Math.min(sa.size(), sb.size()) * 3) / 4);
    }

    private static final String normalize(String s) {
        String lowerCase = StringsKt.trim(new Regex("(?i)\\b(dub|dubbed|hd|4k|hindi|tamil|telugu|dual audio)\\b").replace(new Regex("\\(.*?\\)").replace(new Regex("\\[.*?]").replace(s, " "), " "), " ")).toString().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String t = new Regex("\\s+").replace(new Regex("\\p{Punct}").replace(StringsKt.replace$default(lowerCase, ":", " ", false, 4, (Object) null), " "), " ");
        return t;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public static final Object fetchMetaData(String imdbId, TvType type, Continuation<? super JsonNode> continuation) {
        C00091 c00091;
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
        C00091 c00092 = c00091;
        Object $result = c00092.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00092.label) {
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
                    c00092.L$0 = SpillingKt.nullOutSpilledVariable(imdbId);
                    c00092.L$1 = SpillingKt.nullOutSpilledVariable(type);
                    c00092.L$2 = SpillingKt.nullOutSpilledVariable(metaType);
                    c00092.L$3 = SpillingKt.nullOutSpilledVariable(url);
                    c00092.label = 1;
                    try {
                        Object obj = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00092, 4094, (Object) null);
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
    public static final Object fetchTmdbLogoUrl(String tmdbAPI, String apiKey, TvType type, Integer tmdbId, String appLangCode, Continuation<? super String> continuation) {
        C00101 c00101;
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
        if (continuation instanceof C00101) {
            c00101 = (C00101) continuation;
            if ((c00101.label & Integer.MIN_VALUE) != 0) {
                c00101.label -= Integer.MIN_VALUE;
            } else {
                c00101 = new C00101(continuation);
            }
        } else {
            c00101 = new C00101(continuation);
        }
        C00101 c00102 = c00101;
        Object $result = c00102.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00102.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (tmdbId == null) {
                    return null;
                }
                String url = type == TvType.Movie ? tmdbAPI3 + "/movie/" + tmdbId.intValue() + "/images?api_key=" + apiKey : tmdbAPI3 + "/tv/" + tmdbId.intValue() + "/images?api_key=" + apiKey;
                try {
                    Result.Companion companion = Result.Companion;
                    Requests app = MainActivityKt.getApp();
                    c00102.L$0 = SpillingKt.nullOutSpilledVariable(tmdbAPI3);
                    c00102.L$1 = SpillingKt.nullOutSpilledVariable(apiKey);
                    c00102.L$2 = SpillingKt.nullOutSpilledVariable(type);
                    c00102.L$3 = SpillingKt.nullOutSpilledVariable(tmdbId);
                    c00102.L$4 = appLangCode;
                    c00102.L$5 = SpillingKt.nullOutSpilledVariable(url);
                    c00102.label = 1;
                    try {
                        Object obj2 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00102, 4094, (Object) null);
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
                appLangCode2 = (String) c00102.L$4;
                tmdbAPI3 = (String) c00102.L$0;
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
}
