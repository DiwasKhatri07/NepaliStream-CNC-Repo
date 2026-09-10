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
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010\u0004\u001a\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0002\u001aN\u0010\u0007\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b2\u0006\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00012\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0082@¢\u0006\u0002\u0010\u0011\u001aN\u0010\u0012\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b2\u0006\u0010\u0013\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00012\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0082@¢\u0006\u0002\u0010\u0011\u001a\u0018\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0002\u001a\"\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001b\u001a\u00020\u0010H\u0082@¢\u0006\u0002\u0010\u001c\u001a<\u0010\u001d\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00102\b\u0010 \u001a\u0004\u0018\u00010\u00012\b\u0010!\u001a\u0004\u0018\u00010\u0003H\u0082@¢\u0006\u0002\u0010\"¨\u0006#"}, d2 = {"getHighestQuality", "", "input", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "cleanTitle", "s", "identifyID", "Lkotlin/Pair;", "title", "year", "imdbRatingValue", "", "isIndian", "", "expectedType", "Lcom/lagradost/cloudstream3/TvType;", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;ZLcom/lagradost/cloudstream3/TvType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchAndPick", "normTitle", "tokenEquals", "a", "b", "normalize", "fetchMetaData", "Lcom/fasterxml/jackson/databind/JsonNode;", "imdbId", "type", "(Ljava/lang/String;Lcom/lagradost/cloudstream3/TvType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchTmdbLogoUrl", "tmdbAPI", "apiKey", "tmdbId", "appLangCode", "(Ljava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/TvType;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "MovieBoxProvider"}, k = 2, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMovieBoxProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MovieBoxProvider.kt\ncom/MovieBox/MovieBoxProviderKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1366:1\n777#2:1367\n873#2,2:1368\n777#2:1370\n873#2,2:1371\n777#2:1373\n873#2,2:1374\n1#3:1376\n*S KotlinDebug\n*F\n+ 1 MovieBoxProvider.kt\ncom/MovieBox/MovieBoxProviderKt\n*L\n1181#1:1367\n1181#1:1368,2\n1259#1:1370\n1259#1:1371,2\n1260#1:1373\n1260#1:1374,2\n*E\n"})
public final class MovieBoxProviderKt {

    /* JADX INFO: renamed from: com.MovieBox.MovieBoxProviderKt$fetchMetaData$1 */
    /* JADX INFO: compiled from: MovieBoxProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.MovieBox.MovieBoxProviderKt", f = "MovieBoxProvider.kt", i = {0, 0, 0, 0}, l = {1285}, m = "fetchMetaData", n = {"imdbId", "type", "metaType", "url"}, nl = {1286}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 2)
    static final class C00101 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C00101(Continuation<? super C00101> continuation) {
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
    @DebugMetadata(c = "com.MovieBox.MovieBoxProviderKt", f = "MovieBoxProvider.kt", i = {0, 0, 0, 0, 0, 0}, l = {1307}, m = "fetchTmdbLogoUrl", n = {"tmdbAPI", "apiKey", "type", "tmdbId", "appLangCode", "url"}, nl = {1307}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
    static final class C00111 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C00111(Continuation<? super C00111> continuation) {
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
    @DebugMetadata(c = "com.MovieBox.MovieBoxProviderKt", f = "MovieBoxProvider.kt", i = {0, 0, 0, 0, 0, 0}, l = {1116}, m = "identifyID", n = {"title", "year", "imdbRatingValue", "expectedType", "normTitle", "isIndian"}, nl = {1117}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0"}, v = 2)
    static final class C00121 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00121(Continuation<? super C00121> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MovieBoxProviderKt.identifyID(null, null, null, false, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.MovieBox.MovieBoxProviderKt$searchAndPick$1 */
    /* JADX INFO: compiled from: MovieBoxProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.MovieBox.MovieBoxProviderKt", f = "MovieBoxProvider.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6}, l = {1146, 1147, 1148, 1152, 1153, 1154, 1251}, m = "searchAndPick", n = {"normTitle", "year", "imdbRatingValue", "expectedType", "extraYearParam", "extraTvYearParam", "isIndian", "normTitle", "year", "imdbRatingValue", "expectedType", "extraYearParam", "extraTvYearParam", "isIndian", "normTitle", "year", "imdbRatingValue", "expectedType", "extraYearParam", "extraTvYearParam", "isIndian", "normTitle", "year", "imdbRatingValue", "expectedType", "extraYearParam", "extraTvYearParam", "isIndian", "normTitle", "year", "imdbRatingValue", "expectedType", "extraYearParam", "extraTvYearParam", "isIndian", "normTitle", "year", "imdbRatingValue", "expectedType", "extraYearParam", "extraTvYearParam", "isIndian", "normTitle", "year", "imdbRatingValue", "expectedType", "extraYearParam", "extraTvYearParam", "searchQueues", "bestId", "detailKind", "detailUrl", "isIndian", "bestScore", "bestIsTv"}, nl = {1147, 1146, 1146, 1153, 1152, 1152, 1252}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "Z$0", "D$0", "I$0"}, v = 2)
    static final class C00131 extends ContinuationImpl {
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
        Object L$8;
        Object L$9;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00131(Continuation<? super C00131> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MovieBoxProviderKt.searchAndPick(null, null, null, false, null, (Continuation) this);
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
    public static final Object identifyID(String title, Integer year, Double imdbRatingValue, boolean isIndian, TvType expectedType, Continuation<? super Pair<Integer, String>> continuation) throws JSONException {
        C00121 c00121;
        Object objSearchAndPick;
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
        C00121 c00122 = c00121;
        Object $result = c00122.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00122.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String normTitle = normalize(title);
                c00122.L$0 = SpillingKt.nullOutSpilledVariable(title);
                c00122.L$1 = SpillingKt.nullOutSpilledVariable(year);
                c00122.L$2 = SpillingKt.nullOutSpilledVariable(imdbRatingValue);
                c00122.L$3 = SpillingKt.nullOutSpilledVariable(expectedType);
                c00122.L$4 = SpillingKt.nullOutSpilledVariable(normTitle);
                c00122.Z$0 = isIndian;
                c00122.label = 1;
                objSearchAndPick = searchAndPick(normTitle, year, imdbRatingValue, isIndian, expectedType, c00122);
                if (objSearchAndPick == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                boolean isIndian2 = c00122.Z$0;
                ResultKt.throwOnFailure($result);
                objSearchAndPick = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Pair res = (Pair) objSearchAndPick;
        return res.getFirst() != null ? res : new Pair((Object) null, (Object) null);
    }

    static /* synthetic */ Object identifyID$default(String str, Integer num, Double d, boolean z, TvType tvType, Continuation continuation, int i, Object obj) {
        TvType tvType2;
        boolean z2 = (i & 8) != 0 ? false : z;
        if ((i & 16) == 0) {
            tvType2 = tvType;
        } else {
            tvType2 = TvType.Movie;
        }
        return identifyID(str, num, d, z2, tvType2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:100:0x0646  */
    /* JADX WARN: Code duplicated, block: B:102:0x064e  */
    /* JADX WARN: Code duplicated, block: B:105:0x0656 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:118:0x0683  */
    /* JADX WARN: Code duplicated, block: B:121:0x0688  */
    /* JADX WARN: Code duplicated, block: B:126:0x0694  */
    /* JADX WARN: Code duplicated, block: B:128:0x069c  */
    /* JADX WARN: Code duplicated, block: B:129:0x069f  */
    /* JADX WARN: Code duplicated, block: B:132:0x06a5  */
    /* JADX WARN: Code duplicated, block: B:136:0x06bb  */
    /* JADX WARN: Code duplicated, block: B:137:0x06c0  */
    /* JADX WARN: Code duplicated, block: B:139:0x06c6  */
    /* JADX WARN: Code duplicated, block: B:142:0x06d0  */
    /* JADX WARN: Code duplicated, block: B:143:0x06e3  */
    /* JADX WARN: Code duplicated, block: B:146:0x06e9  */
    /* JADX WARN: Code duplicated, block: B:147:0x06f7  */
    /* JADX WARN: Code duplicated, block: B:154:0x076b  */
    /* JADX WARN: Code duplicated, block: B:165:0x083d  */
    /* JADX WARN: Code duplicated, block: B:166:0x0846  */
    /* JADX WARN: Code duplicated, block: B:169:0x084f A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:173:0x0743 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:174:0x04c2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:183:0x0561 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:184:0x0615 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:185:0x05c7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:186:0x0604 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:34:0x0333 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:35:0x0334  */
    /* JADX WARN: Code duplicated, block: B:38:0x0381 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:39:0x0382  */
    /* JADX WARN: Code duplicated, block: B:47:0x042a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:48:0x042b  */
    /* JADX WARN: Code duplicated, block: B:51:0x0479 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:52:0x047a  */
    /* JADX WARN: Code duplicated, block: B:57:0x04aa  */
    /* JADX WARN: Code duplicated, block: B:61:0x04d0  */
    /* JADX WARN: Code duplicated, block: B:63:0x04dd  */
    /* JADX WARN: Code duplicated, block: B:64:0x04ea  */
    /* JADX WARN: Code duplicated, block: B:66:0x04f6  */
    /* JADX WARN: Code duplicated, block: B:67:0x04f8  */
    /* JADX WARN: Code duplicated, block: B:70:0x0508  */
    /* JADX WARN: Code duplicated, block: B:73:0x0548  */
    /* JADX WARN: Code duplicated, block: B:75:0x055e  */
    /* JADX WARN: Code duplicated, block: B:79:0x0573  */
    /* JADX WARN: Code duplicated, block: B:7:0x0020  */
    /* JADX WARN: Code duplicated, block: B:80:0x057a  */
    /* JADX WARN: Code duplicated, block: B:84:0x05b7  */
    /* JADX WARN: Code duplicated, block: B:87:0x05d2  */
    /* JADX WARN: Code duplicated, block: B:89:0x05ea  */
    /* JADX WARN: Code duplicated, block: B:97:0x0621  */
    /* JADX WARN: Code duplicated, block: B:99:0x0641  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r31v0 */
    /* JADX WARN: Type inference failed for: r31v1 */
    /* JADX WARN: Type inference failed for: r31v2 */
    /* JADX WARN: Type inference failed for: r31v3 */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v23, types: [int] */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v26 */
    /* JADX WARN: Type inference failed for: r9v27 */
    /* JADX WARN: Type inference failed for: r9v34 */
    /* JADX WARN: Type inference failed for: r9v35 */
    /* JADX WARN: Type inference failed for: r9v38 */
    /* JADX WARN: Type inference failed for: r9v39 */
    public static final Object searchAndPick(String str, Integer num, Double d, boolean z, TvType tvType, Continuation<? super Pair<Integer, String>> continuation) throws JSONException {
        C00131 c00131;
        String str2;
        String str3;
        String str4;
        String str5;
        Pair[] pairArr;
        String str6;
        int i;
        String str7;
        Pair[] pairArr2;
        Pair[] pairArr3;
        String str8;
        String str9;
        Object obj;
        int i2;
        String str10;
        Pair[] pairArr4;
        String str11;
        Object objSearchAndPick$doSearch;
        Object obj2;
        String str12;
        int i3;
        boolean z2;
        Pair[] pairArr5;
        Object objSearchAndPick$doSearch2;
        Pair[] pairArr6;
        Pair[] pairArr7;
        int i4;
        String str13;
        List listListOf;
        TvType tvType2;
        boolean z3;
        String str14;
        Object objSearchAndPick$doSearch3;
        Object obj3;
        Pair[] pairArr8;
        int i5;
        boolean z4;
        Pair[] pairArr9;
        String str15;
        Object objSearchAndPick$doSearch4;
        Pair[] pairArr10;
        Pair[] pairArr11;
        boolean z5;
        int i6;
        String str16;
        double d2;
        Iterator it;
        Integer num2;
        ?? r9;
        Integer num3;
        String str17;
        String str18;
        JSONArray jSONArray;
        Integer num4;
        int length;
        Double d3;
        int i7;
        JSONObject jSONObject;
        int i8;
        List list;
        String str19;
        String strOptString;
        int iOptInt;
        double d4;
        String str20;
        ?? AreEqual;
        List listListOf2;
        ArrayList arrayList;
        String strOptString2;
        String str21;
        double dOptDouble;
        String strOptString3;
        String strCleanTitle;
        Iterator it2;
        double dMax;
        double dCoerceAtMost;
        double dAbs;
        String strCleanTitle2;
        JSONObject jSONObjectOptJSONObject;
        String strOptString4;
        String str22 = str;
        Integer num5 = num;
        Double d5 = d;
        boolean z6 = z;
        TvType tvType3 = tvType;
        if (continuation instanceof C00131) {
            c00131 = (C00131) continuation;
            if ((c00131.label & Integer.MIN_VALUE) != 0) {
                c00131.label -= Integer.MIN_VALUE;
            } else {
                c00131 = new C00131(continuation);
            }
        } else {
            c00131 = new C00131(continuation);
        }
        Object obj4 = c00131.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String str23 = "search/tv";
        String str24 = "movie";
        switch (c00131.label) {
            case 0:
                ResultKt.throwOnFailure(obj4);
                if (num5 != null) {
                    str2 = "";
                    str3 = "&year=" + num5.intValue();
                } else {
                    str2 = "";
                    str3 = str2;
                }
                String str25 = num5 != null ? "&first_air_date_year=" + num5.intValue() : str2;
                if (tvType3 != TvType.TvSeries) {
                    String str26 = str25;
                    Pair[] pairArr12 = new Pair[3];
                    c00131.L$0 = str22;
                    c00131.L$1 = num5;
                    c00131.L$2 = d5;
                    c00131.L$3 = tvType3;
                    c00131.L$4 = str3;
                    c00131.L$5 = str26;
                    c00131.L$6 = pairArr12;
                    c00131.L$7 = pairArr12;
                    c00131.L$8 = "movie";
                    c00131.Z$0 = z6;
                    c00131.I$0 = 0;
                    c00131.label = 4;
                    Object objSearchAndPick$doSearch5 = searchAndPick$doSearch("search/movie", "&query=" + str22 + str3, c00131);
                    if (objSearchAndPick$doSearch5 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str4 = "movie";
                    str5 = str4;
                    pairArr = pairArr12;
                    str6 = str26;
                    i = 0;
                    str7 = str3;
                    obj4 = objSearchAndPick$doSearch5;
                    str22 = str;
                    pairArr2 = pairArr;
                    pairArr2[i] = TuplesKt.to(str4, obj4);
                    c00131.L$0 = str22;
                    c00131.L$1 = num5;
                    c00131.L$2 = d5;
                    c00131.L$3 = tvType3;
                    c00131.L$4 = SpillingKt.nullOutSpilledVariable(str7);
                    c00131.L$5 = str6;
                    c00131.L$6 = pairArr;
                    c00131.L$7 = pairArr;
                    c00131.L$8 = "multi";
                    c00131.Z$0 = z6;
                    c00131.I$0 = 1;
                    c00131.label = 5;
                    objSearchAndPick$doSearch3 = searchAndPick$doSearch("search/multi", "&query=" + str22 + str7, c00131);
                    if (objSearchAndPick$doSearch3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj3 = objSearchAndPick$doSearch3;
                    pairArr8 = pairArr;
                    i5 = 1;
                    z4 = z6;
                    pairArr9 = pairArr8;
                    str15 = "multi";
                    pairArr8[i5] = TuplesKt.to(str15, obj3);
                    c00131.L$0 = str22;
                    c00131.L$1 = num5;
                    c00131.L$2 = d5;
                    c00131.L$3 = tvType3;
                    c00131.L$4 = SpillingKt.nullOutSpilledVariable(str7);
                    c00131.L$5 = SpillingKt.nullOutSpilledVariable(str6);
                    c00131.L$6 = pairArr9;
                    c00131.L$7 = pairArr9;
                    c00131.L$8 = "tv";
                    c00131.Z$0 = z4;
                    c00131.I$0 = 2;
                    c00131.label = 6;
                    objSearchAndPick$doSearch4 = searchAndPick$doSearch(str23, "&query=" + str22 + str6, c00131);
                    if (objSearchAndPick$doSearch4 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    pairArr10 = pairArr9;
                    pairArr11 = pairArr10;
                    z5 = z4;
                    i6 = 2;
                    str16 = "tv";
                    pairArr10[i6] = TuplesKt.to(str16, objSearchAndPick$doSearch4);
                    TvType tvType4 = tvType3;
                    z3 = z5;
                    listListOf = CollectionsKt.listOf(pairArr11);
                    tvType2 = tvType4;
                    str8 = str6;
                    str14 = str7;
                    d2 = -1.0d;
                    it = listListOf.iterator();
                    num2 = null;
                    r9 = 0;
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        str22 = str22;
                        str18 = (String) pair.component1();
                        jSONArray = (JSONArray) pair.component2();
                        if (jSONArray != null) {
                            num4 = num5;
                            length = jSONArray.length();
                            d3 = d5;
                            i7 = 0;
                            r9 = r9;
                            while (i7 < length) {
                                int i9 = length;
                                jSONObject = jSONArray.getJSONObject(i7);
                                if (Intrinsics.areEqual(str18, "multi")) {
                                    i8 = i7;
                                    list = listListOf;
                                    str19 = str2;
                                    strOptString = jSONObject.optString("media_type", str19);
                                } else {
                                    i8 = i7;
                                    list = listListOf;
                                    str19 = str2;
                                    if (Intrinsics.areEqual(str18, "tv")) {
                                        strOptString = "tv";
                                    } else {
                                        strOptString = str5;
                                    }
                                }
                                String str27 = str18;
                                Object obj5 = coroutine_suspended;
                                iOptInt = jSONObject.optInt("id", -1);
                                if (iOptInt != -1) {
                                    d4 = d2;
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
                                        strOptString2 = jSONObject.optString("first_air_date", str19);
                                    } else {
                                        strOptString2 = jSONObject.optString("release_date", str19);
                                    }
                                    Integer intOrNull = StringsKt.toIntOrNull(StringsKt.take(strOptString2, 4));
                                    str21 = strOptString2;
                                    dOptDouble = jSONObject.optDouble("vote_average", Double.NaN);
                                    strOptString3 = jSONObject.optString("original_language", str19);
                                    strCleanTitle = cleanTitle(str22);
                                    it2 = arrayList2.iterator();
                                    dMax = 0.0d;
                                    while (true) {
                                        str21 = str21;
                                        num2 = num2;
                                        if (it2.hasNext()) {
                                            strCleanTitle2 = cleanTitle((String) it2.next());
                                            if (tokenEquals(strCleanTitle2, strCleanTitle)) {
                                                dMax = 50.0d;
                                            } else {
                                                strCleanTitle = strCleanTitle;
                                                str19 = str19;
                                                it = it;
                                                if (!StringsKt.contains$default(strCleanTitle2, strCleanTitle, false, 2, (Object) null)) {
                                                }
                                                dMax = Math.max(dMax, 20.0d);
                                            }
                                        }
                                    }
                                    dCoerceAtMost = 0.0d + dMax;
                                    if (z3) {
                                        if (CollectionsKt.listOf(new String[]{"hi", "ta", "te", "ml", "kn", "pa", "bn", "mr", "gu"}).contains(strOptString3)) {
                                            dCoerceAtMost += 30.0d;
                                        } else if (Intrinsics.areEqual(strOptString3, "en")) {
                                            dCoerceAtMost -= 20.0d;
                                        }
                                    }
                                    if (num4 == null) {
                                    }
                                    if (tvType2 == TvType.TvSeries) {
                                        dCoerceAtMost += 15.0d;
                                    }
                                    if (tvType2 == TvType.Movie) {
                                        str20 = str5;
                                        if (Intrinsics.areEqual(strOptString, str20)) {
                                            dCoerceAtMost += 15.0d;
                                        }
                                    } else {
                                        str20 = str5;
                                    }
                                    if (d3 != null) {
                                        dAbs = Math.abs(dOptDouble - d3.doubleValue());
                                        if (dAbs <= 0.5d) {
                                            dCoerceAtMost += 10.0d;
                                        } else if (dAbs <= 1.0d) {
                                            dCoerceAtMost += 5.0d;
                                        }
                                    }
                                    if (jSONObject.has("popularity")) {
                                        dCoerceAtMost += RangesKt.coerceAtMost(jSONObject.optDouble("popularity", 0.0d) / 100.0d, 5.0d);
                                    }
                                    if (dCoerceAtMost > d4) {
                                        Integer numBoxInt = Boxing.boxInt(iOptInt);
                                        d2 = dCoerceAtMost;
                                        AreEqual = Intrinsics.areEqual(strOptString, "tv");
                                        num2 = numBoxInt;
                                    }
                                    i7 = i8 + 1;
                                    length = i9;
                                    listListOf = list;
                                    it = it;
                                    jSONArray = jSONArray;
                                    coroutine_suspended = obj5;
                                    str5 = str20;
                                    str18 = str27;
                                    str2 = str19;
                                    r9 = AreEqual;
                                } else {
                                    str19 = str19;
                                    d4 = d2;
                                    num2 = num2;
                                    it = it;
                                    str20 = str5;
                                    jSONArray = jSONArray;
                                }
                                AreEqual = r9;
                                d2 = d4;
                                num2 = num2;
                                i7 = i8 + 1;
                                length = i9;
                                listListOf = list;
                                it = it;
                                jSONArray = jSONArray;
                                coroutine_suspended = obj5;
                                str5 = str20;
                                str18 = str27;
                                str2 = str19;
                                r9 = AreEqual;
                            }
                            num5 = num4;
                            d5 = d3;
                            str5 = str5;
                            str2 = str2;
                        } else {
                            str5 = str5;
                            str2 = str2;
                        }
                    }
                    String str28 = str22;
                    Integer num6 = num5;
                    Double d6 = d5;
                    List list3 = listListOf;
                    Object obj7 = coroutine_suspended;
                    String str29 = str5;
                    if (num2 != null) {
                    }
                    return new Pair((Object) null, (Object) null);
                }
                pairArr3 = new Pair[3];
                c00131.L$0 = str22;
                c00131.L$1 = num5;
                c00131.L$2 = d5;
                c00131.L$3 = tvType3;
                c00131.L$4 = str3;
                str8 = str25;
                c00131.L$5 = SpillingKt.nullOutSpilledVariable(str8);
                c00131.L$6 = pairArr3;
                c00131.L$7 = pairArr3;
                c00131.L$8 = "tv";
                c00131.Z$0 = z6;
                c00131.I$0 = 0;
                c00131.label = 1;
                Object objSearchAndPick$doSearch6 = searchAndPick$doSearch("search/tv", "&query=" + str22 + str25, c00131);
                if (objSearchAndPick$doSearch6 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str9 = str3;
                obj = objSearchAndPick$doSearch6;
                i2 = 0;
                str10 = "tv";
                pairArr4 = pairArr3;
                pairArr3[i2] = TuplesKt.to(str10, obj);
                c00131.L$0 = str22;
                c00131.L$1 = num5;
                c00131.L$2 = d5;
                c00131.L$3 = tvType3;
                c00131.L$4 = str9;
                c00131.L$5 = SpillingKt.nullOutSpilledVariable(str8);
                c00131.L$6 = pairArr4;
                c00131.L$7 = pairArr4;
                c00131.L$8 = "multi";
                c00131.Z$0 = z6;
                c00131.I$0 = 1;
                c00131.label = 2;
                objSearchAndPick$doSearch = searchAndPick$doSearch("search/multi", "&query=" + str22 + str9, c00131);
                if (objSearchAndPick$doSearch == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj2 = objSearchAndPick$doSearch;
                str12 = "multi";
                i3 = 1;
                z2 = z6;
                pairArr5 = pairArr4;
                pairArr5[i3] = TuplesKt.to(str12, obj2);
                c00131.L$0 = str22;
                c00131.L$1 = num5;
                c00131.L$2 = d5;
                c00131.L$3 = tvType3;
                c00131.L$4 = SpillingKt.nullOutSpilledVariable(str9);
                c00131.L$5 = SpillingKt.nullOutSpilledVariable(str8);
                c00131.L$6 = pairArr4;
                c00131.L$7 = pairArr4;
                str24 = str24;
                c00131.L$8 = str24;
                c00131.Z$0 = z2;
                c00131.I$0 = 2;
                c00131.label = 3;
                objSearchAndPick$doSearch2 = searchAndPick$doSearch(str11, "&query=" + str22 + str9, c00131);
                if (objSearchAndPick$doSearch2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                pairArr6 = pairArr4;
                pairArr7 = pairArr6;
                i4 = 2;
                str13 = str24;
                pairArr6[i4] = TuplesKt.to(str13, objSearchAndPick$doSearch2);
                listListOf = CollectionsKt.listOf(pairArr7);
                boolean z7 = z2;
                tvType2 = tvType3;
                z3 = z7;
                str5 = str24;
                str14 = str9;
                d2 = -1.0d;
                it = listListOf.iterator();
                num2 = null;
                r9 = 0;
                while (it.hasNext()) {
                    Pair pair2 = (Pair) it.next();
                    str22 = str22;
                    str18 = (String) pair2.component1();
                    jSONArray = (JSONArray) pair2.component2();
                    if (jSONArray != null) {
                        num4 = num5;
                        length = jSONArray.length();
                        d3 = d5;
                        i7 = 0;
                        r9 = r9;
                        while (i7 < length) {
                            int i10 = length;
                            jSONObject = jSONArray.getJSONObject(i7);
                            if (Intrinsics.areEqual(str18, "multi")) {
                                i8 = i7;
                                list = listListOf;
                                str19 = str2;
                                strOptString = jSONObject.optString("media_type", str19);
                            } else {
                                i8 = i7;
                                list = listListOf;
                                str19 = str2;
                                if (Intrinsics.areEqual(str18, "tv")) {
                                    strOptString = "tv";
                                } else {
                                    strOptString = str5;
                                }
                            }
                            String str210 = str18;
                            Object obj8 = coroutine_suspended;
                            iOptInt = jSONObject.optInt("id", -1);
                            if (iOptInt != -1) {
                                d4 = d2;
                                listListOf2 = CollectionsKt.listOf(new String[]{jSONObject.optString("title"), jSONObject.optString("name"), jSONObject.optString("original_title"), jSONObject.optString("original_name")});
                                arrayList = new ArrayList();
                                while (r34.hasNext()) {
                                    List list4 = listListOf2;
                                    if (!StringsKt.isBlank((String) obj6)) {
                                        arrayList.add(obj6);
                                    }
                                    listListOf2 = list4;
                                }
                                ArrayList arrayList3 = arrayList;
                                if (Intrinsics.areEqual(strOptString, "tv")) {
                                    strOptString2 = jSONObject.optString("first_air_date", str19);
                                } else {
                                    strOptString2 = jSONObject.optString("release_date", str19);
                                }
                                Integer intOrNull2 = StringsKt.toIntOrNull(StringsKt.take(strOptString2, 4));
                                str21 = strOptString2;
                                dOptDouble = jSONObject.optDouble("vote_average", Double.NaN);
                                strOptString3 = jSONObject.optString("original_language", str19);
                                strCleanTitle = cleanTitle(str22);
                                it2 = arrayList3.iterator();
                                dMax = 0.0d;
                                while (true) {
                                    str21 = str21;
                                    num2 = num2;
                                    if (it2.hasNext()) {
                                        strCleanTitle2 = cleanTitle((String) it2.next());
                                        if (tokenEquals(strCleanTitle2, strCleanTitle)) {
                                            dMax = 50.0d;
                                        } else {
                                            strCleanTitle = strCleanTitle;
                                            str19 = str19;
                                            it = it;
                                            if (!StringsKt.contains$default(strCleanTitle2, strCleanTitle, false, 2, (Object) null) || StringsKt.contains$default(strCleanTitle, strCleanTitle2, false, 2, (Object) null)) {
                                                dMax = Math.max(dMax, 20.0d);
                                            }
                                        }
                                    }
                                }
                                dCoerceAtMost = 0.0d + dMax;
                                if (z3) {
                                    if (CollectionsKt.listOf(new String[]{"hi", "ta", "te", "ml", "kn", "pa", "bn", "mr", "gu"}).contains(strOptString3)) {
                                        dCoerceAtMost += 30.0d;
                                    } else if (Intrinsics.areEqual(strOptString3, "en")) {
                                        dCoerceAtMost -= 20.0d;
                                    }
                                }
                                if (num4 == null && intOrNull2 != null) {
                                    int iAbs = Math.abs(intOrNull2.intValue() - num4.intValue());
                                    if (iAbs == 0) {
                                        dCoerceAtMost += 40.0d;
                                    } else if (iAbs == 1) {
                                        dCoerceAtMost += 20.0d;
                                    } else if (iAbs >= 4) {
                                        dCoerceAtMost -= 40.0d;
                                    } else if (iAbs >= 2) {
                                        dCoerceAtMost -= 15.0d;
                                    }
                                }
                                if (tvType2 == TvType.TvSeries && Intrinsics.areEqual(strOptString, "tv")) {
                                    dCoerceAtMost += 15.0d;
                                }
                                if (tvType2 == TvType.Movie) {
                                    str20 = str5;
                                    if (Intrinsics.areEqual(strOptString, str20)) {
                                        dCoerceAtMost += 15.0d;
                                    }
                                } else {
                                    str20 = str5;
                                }
                                if (d3 != null && !Double.isNaN(dOptDouble)) {
                                    dAbs = Math.abs(dOptDouble - d3.doubleValue());
                                    if (dAbs <= 0.5d) {
                                        dCoerceAtMost += 10.0d;
                                    } else if (dAbs <= 1.0d) {
                                        dCoerceAtMost += 5.0d;
                                    }
                                }
                                if (jSONObject.has("popularity")) {
                                    dCoerceAtMost += RangesKt.coerceAtMost(jSONObject.optDouble("popularity", 0.0d) / 100.0d, 5.0d);
                                }
                                if (dCoerceAtMost > d4) {
                                    Integer numBoxInt2 = Boxing.boxInt(iOptInt);
                                    d2 = dCoerceAtMost;
                                    AreEqual = Intrinsics.areEqual(strOptString, "tv");
                                    num2 = numBoxInt2;
                                }
                                i7 = i8 + 1;
                                length = i10;
                                listListOf = list;
                                it = it;
                                jSONArray = jSONArray;
                                coroutine_suspended = obj8;
                                str5 = str20;
                                str18 = str210;
                                str2 = str19;
                                r9 = AreEqual;
                            } else {
                                str19 = str19;
                                d4 = d2;
                                num2 = num2;
                                it = it;
                                str20 = str5;
                                jSONArray = jSONArray;
                            }
                            AreEqual = r9;
                            d2 = d4;
                            num2 = num2;
                            i7 = i8 + 1;
                            length = i10;
                            listListOf = list;
                            it = it;
                            jSONArray = jSONArray;
                            coroutine_suspended = obj8;
                            str5 = str20;
                            str18 = str210;
                            str2 = str19;
                            r9 = AreEqual;
                        }
                        num5 = num4;
                        d5 = d3;
                        str5 = str5;
                        str2 = str2;
                    } else {
                        str5 = str5;
                        str2 = str2;
                    }
                }
                String str211 = str22;
                Integer num7 = num5;
                Double d7 = d5;
                List list5 = listListOf;
                Object obj9 = coroutine_suspended;
                String str212 = str5;
                if (num2 != null || d2 < 40.0d) {
                    return new Pair((Object) null, (Object) null);
                }
                if (r9 != 0) {
                    str212 = "tv";
                }
                String str30 = "https://api.themoviedb.org/3/" + str212 + '/' + num2.intValue() + "?api_key=1865f43a0549ca50d341dd9ab8b29f49&append_to_response=external_ids";
                TvType tvType5 = tvType2;
                Requests app = MainActivityKt.getApp();
                c00131.L$0 = SpillingKt.nullOutSpilledVariable(str211);
                c00131.L$1 = SpillingKt.nullOutSpilledVariable(num7);
                c00131.L$2 = SpillingKt.nullOutSpilledVariable(d7);
                c00131.L$3 = SpillingKt.nullOutSpilledVariable(tvType5);
                c00131.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                c00131.L$5 = SpillingKt.nullOutSpilledVariable(str8);
                c00131.L$6 = SpillingKt.nullOutSpilledVariable(list5);
                c00131.L$7 = num2;
                c00131.L$8 = SpillingKt.nullOutSpilledVariable(str212);
                c00131.L$9 = SpillingKt.nullOutSpilledVariable(str30);
                c00131.Z$0 = z3;
                c00131.D$0 = d2;
                c00131.I$0 = r9;
                c00131.label = 7;
                Integer num8 = num2;
                obj4 = Requests.get$default(app, str30, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00131, 4094, (Object) null);
                if (obj4 == obj9) {
                    return obj9;
                }
                num3 = num8;
                str17 = str211;
                jSONObjectOptJSONObject = new JSONObject(((NiceResponse) obj4).getText()).optJSONObject("external_ids");
                if (jSONObjectOptJSONObject != null) {
                    strOptString4 = jSONObjectOptJSONObject.optString("imdb_id");
                } else {
                    strOptString4 = null;
                }
                return new Pair(num3, strOptString4);
            case 1:
                int i11 = c00131.I$0;
                boolean z8 = c00131.Z$0;
                String str31 = (String) c00131.L$8;
                Pair[] pairArr13 = (Pair[]) c00131.L$7;
                Pair[] pairArr14 = (Pair[]) c00131.L$6;
                String str32 = (String) c00131.L$5;
                String str33 = (String) c00131.L$4;
                TvType tvType6 = (TvType) c00131.L$3;
                d5 = (Double) c00131.L$2;
                num5 = (Integer) c00131.L$1;
                str22 = (String) c00131.L$0;
                ResultKt.throwOnFailure(obj4);
                tvType3 = tvType6;
                i2 = i11;
                z6 = z8;
                pairArr4 = pairArr14;
                obj4 = obj4;
                str11 = "search/movie";
                str9 = str33;
                str10 = str31;
                str8 = str32;
                pairArr3 = pairArr13;
                str2 = "";
                obj = obj4;
                pairArr3[i2] = TuplesKt.to(str10, obj);
                c00131.L$0 = str22;
                c00131.L$1 = num5;
                c00131.L$2 = d5;
                c00131.L$3 = tvType3;
                c00131.L$4 = str9;
                c00131.L$5 = SpillingKt.nullOutSpilledVariable(str8);
                c00131.L$6 = pairArr4;
                c00131.L$7 = pairArr4;
                c00131.L$8 = "multi";
                c00131.Z$0 = z6;
                c00131.I$0 = 1;
                c00131.label = 2;
                objSearchAndPick$doSearch = searchAndPick$doSearch("search/multi", "&query=" + str22 + str9, c00131);
                if (objSearchAndPick$doSearch == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj2 = objSearchAndPick$doSearch;
                str12 = "multi";
                i3 = 1;
                z2 = z6;
                pairArr5 = pairArr4;
                pairArr5[i3] = TuplesKt.to(str12, obj2);
                c00131.L$0 = str22;
                c00131.L$1 = num5;
                c00131.L$2 = d5;
                c00131.L$3 = tvType3;
                c00131.L$4 = SpillingKt.nullOutSpilledVariable(str9);
                c00131.L$5 = SpillingKt.nullOutSpilledVariable(str8);
                c00131.L$6 = pairArr4;
                c00131.L$7 = pairArr4;
                str24 = str24;
                c00131.L$8 = str24;
                c00131.Z$0 = z2;
                c00131.I$0 = 2;
                c00131.label = 3;
                objSearchAndPick$doSearch2 = searchAndPick$doSearch(str11, "&query=" + str22 + str9, c00131);
                if (objSearchAndPick$doSearch2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                pairArr6 = pairArr4;
                pairArr7 = pairArr6;
                i4 = 2;
                str13 = str24;
                pairArr6[i4] = TuplesKt.to(str13, objSearchAndPick$doSearch2);
                listListOf = CollectionsKt.listOf(pairArr7);
                boolean z9 = z2;
                tvType2 = tvType3;
                z3 = z9;
                str5 = str24;
                str14 = str9;
                d2 = -1.0d;
                it = listListOf.iterator();
                num2 = null;
                r9 = 0;
                while (it.hasNext()) {
                    Pair pair3 = (Pair) it.next();
                    str22 = str22;
                    str18 = (String) pair3.component1();
                    jSONArray = (JSONArray) pair3.component2();
                    if (jSONArray != null) {
                        num4 = num5;
                        length = jSONArray.length();
                        d3 = d5;
                        i7 = 0;
                        r9 = r9;
                        while (i7 < length) {
                            int i12 = length;
                            jSONObject = jSONArray.getJSONObject(i7);
                            if (Intrinsics.areEqual(str18, "multi")) {
                                i8 = i7;
                                list = listListOf;
                                str19 = str2;
                                strOptString = jSONObject.optString("media_type", str19);
                            } else {
                                i8 = i7;
                                list = listListOf;
                                str19 = str2;
                                if (Intrinsics.areEqual(str18, "tv")) {
                                    strOptString = "tv";
                                } else {
                                    strOptString = str5;
                                }
                            }
                            String str213 = str18;
                            Object obj10 = coroutine_suspended;
                            iOptInt = jSONObject.optInt("id", -1);
                            if (iOptInt != -1) {
                                d4 = d2;
                                listListOf2 = CollectionsKt.listOf(new String[]{jSONObject.optString("title"), jSONObject.optString("name"), jSONObject.optString("original_title"), jSONObject.optString("original_name")});
                                arrayList = new ArrayList();
                                while (r34.hasNext()) {
                                    List list6 = listListOf2;
                                    if (!StringsKt.isBlank((String) obj6)) {
                                        arrayList.add(obj6);
                                    }
                                    listListOf2 = list6;
                                }
                                ArrayList arrayList4 = arrayList;
                                if (Intrinsics.areEqual(strOptString, "tv")) {
                                    strOptString2 = jSONObject.optString("first_air_date", str19);
                                } else {
                                    strOptString2 = jSONObject.optString("release_date", str19);
                                }
                                Integer intOrNull3 = StringsKt.toIntOrNull(StringsKt.take(strOptString2, 4));
                                str21 = strOptString2;
                                dOptDouble = jSONObject.optDouble("vote_average", Double.NaN);
                                strOptString3 = jSONObject.optString("original_language", str19);
                                strCleanTitle = cleanTitle(str22);
                                it2 = arrayList4.iterator();
                                dMax = 0.0d;
                                while (true) {
                                    str21 = str21;
                                    num2 = num2;
                                    if (it2.hasNext()) {
                                        strCleanTitle2 = cleanTitle((String) it2.next());
                                        if (tokenEquals(strCleanTitle2, strCleanTitle)) {
                                            dMax = 50.0d;
                                        } else {
                                            strCleanTitle = strCleanTitle;
                                            str19 = str19;
                                            it = it;
                                            if (!StringsKt.contains$default(strCleanTitle2, strCleanTitle, false, 2, (Object) null)) {
                                            }
                                            dMax = Math.max(dMax, 20.0d);
                                        }
                                    }
                                }
                                dCoerceAtMost = 0.0d + dMax;
                                if (z3) {
                                    if (CollectionsKt.listOf(new String[]{"hi", "ta", "te", "ml", "kn", "pa", "bn", "mr", "gu"}).contains(strOptString3)) {
                                        dCoerceAtMost += 30.0d;
                                    } else if (Intrinsics.areEqual(strOptString3, "en")) {
                                        dCoerceAtMost -= 20.0d;
                                    }
                                }
                                if (num4 == null) {
                                }
                                if (tvType2 == TvType.TvSeries) {
                                    dCoerceAtMost += 15.0d;
                                }
                                if (tvType2 == TvType.Movie) {
                                    str20 = str5;
                                    if (Intrinsics.areEqual(strOptString, str20)) {
                                        dCoerceAtMost += 15.0d;
                                    }
                                } else {
                                    str20 = str5;
                                }
                                if (d3 != null) {
                                    dAbs = Math.abs(dOptDouble - d3.doubleValue());
                                    if (dAbs <= 0.5d) {
                                        dCoerceAtMost += 10.0d;
                                    } else if (dAbs <= 1.0d) {
                                        dCoerceAtMost += 5.0d;
                                    }
                                }
                                if (jSONObject.has("popularity")) {
                                    dCoerceAtMost += RangesKt.coerceAtMost(jSONObject.optDouble("popularity", 0.0d) / 100.0d, 5.0d);
                                }
                                if (dCoerceAtMost > d4) {
                                    Integer numBoxInt3 = Boxing.boxInt(iOptInt);
                                    d2 = dCoerceAtMost;
                                    AreEqual = Intrinsics.areEqual(strOptString, "tv");
                                    num2 = numBoxInt3;
                                }
                                i7 = i8 + 1;
                                length = i12;
                                listListOf = list;
                                it = it;
                                jSONArray = jSONArray;
                                coroutine_suspended = obj10;
                                str5 = str20;
                                str18 = str213;
                                str2 = str19;
                                r9 = AreEqual;
                            } else {
                                str19 = str19;
                                d4 = d2;
                                num2 = num2;
                                it = it;
                                str20 = str5;
                                jSONArray = jSONArray;
                            }
                            AreEqual = r9;
                            d2 = d4;
                            num2 = num2;
                            i7 = i8 + 1;
                            length = i12;
                            listListOf = list;
                            it = it;
                            jSONArray = jSONArray;
                            coroutine_suspended = obj10;
                            str5 = str20;
                            str18 = str213;
                            str2 = str19;
                            r9 = AreEqual;
                        }
                        num5 = num4;
                        d5 = d3;
                        str5 = str5;
                        str2 = str2;
                    } else {
                        str5 = str5;
                        str2 = str2;
                    }
                }
                String str214 = str22;
                Integer num9 = num5;
                Double d8 = d5;
                List list7 = listListOf;
                Object obj11 = coroutine_suspended;
                String str215 = str5;
                if (num2 != null) {
                }
                return new Pair((Object) null, (Object) null);
            case 2:
                int i13 = c00131.I$0;
                boolean z10 = c00131.Z$0;
                str12 = (String) c00131.L$8;
                Pair[] pairArr15 = (Pair[]) c00131.L$7;
                Pair[] pairArr16 = (Pair[]) c00131.L$6;
                String str34 = (String) c00131.L$5;
                String str35 = (String) c00131.L$4;
                TvType tvType7 = (TvType) c00131.L$3;
                d5 = (Double) c00131.L$2;
                num5 = (Integer) c00131.L$1;
                str22 = (String) c00131.L$0;
                ResultKt.throwOnFailure(obj4);
                i3 = i13;
                pairArr4 = pairArr16;
                str2 = "";
                tvType3 = tvType7;
                str8 = str34;
                pairArr5 = pairArr15;
                str11 = "search/movie";
                str9 = str35;
                str24 = "movie";
                obj2 = obj4;
                z2 = z10;
                obj4 = obj2;
                pairArr5[i3] = TuplesKt.to(str12, obj2);
                c00131.L$0 = str22;
                c00131.L$1 = num5;
                c00131.L$2 = d5;
                c00131.L$3 = tvType3;
                c00131.L$4 = SpillingKt.nullOutSpilledVariable(str9);
                c00131.L$5 = SpillingKt.nullOutSpilledVariable(str8);
                c00131.L$6 = pairArr4;
                c00131.L$7 = pairArr4;
                str24 = str24;
                c00131.L$8 = str24;
                c00131.Z$0 = z2;
                c00131.I$0 = 2;
                c00131.label = 3;
                objSearchAndPick$doSearch2 = searchAndPick$doSearch(str11, "&query=" + str22 + str9, c00131);
                if (objSearchAndPick$doSearch2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                pairArr6 = pairArr4;
                pairArr7 = pairArr6;
                i4 = 2;
                str13 = str24;
                pairArr6[i4] = TuplesKt.to(str13, objSearchAndPick$doSearch2);
                listListOf = CollectionsKt.listOf(pairArr7);
                boolean z11 = z2;
                tvType2 = tvType3;
                z3 = z11;
                str5 = str24;
                str14 = str9;
                d2 = -1.0d;
                it = listListOf.iterator();
                num2 = null;
                r9 = 0;
                while (it.hasNext()) {
                    Pair pair4 = (Pair) it.next();
                    str22 = str22;
                    str18 = (String) pair4.component1();
                    jSONArray = (JSONArray) pair4.component2();
                    if (jSONArray != null) {
                        num4 = num5;
                        length = jSONArray.length();
                        d3 = d5;
                        i7 = 0;
                        r9 = r9;
                        while (i7 < length) {
                            int i14 = length;
                            jSONObject = jSONArray.getJSONObject(i7);
                            if (Intrinsics.areEqual(str18, "multi")) {
                                i8 = i7;
                                list = listListOf;
                                str19 = str2;
                                strOptString = jSONObject.optString("media_type", str19);
                            } else {
                                i8 = i7;
                                list = listListOf;
                                str19 = str2;
                                if (Intrinsics.areEqual(str18, "tv")) {
                                    strOptString = "tv";
                                } else {
                                    strOptString = str5;
                                }
                            }
                            String str216 = str18;
                            Object obj12 = coroutine_suspended;
                            iOptInt = jSONObject.optInt("id", -1);
                            if (iOptInt != -1) {
                                d4 = d2;
                                listListOf2 = CollectionsKt.listOf(new String[]{jSONObject.optString("title"), jSONObject.optString("name"), jSONObject.optString("original_title"), jSONObject.optString("original_name")});
                                arrayList = new ArrayList();
                                while (r34.hasNext()) {
                                    List list8 = listListOf2;
                                    if (!StringsKt.isBlank((String) obj6)) {
                                        arrayList.add(obj6);
                                    }
                                    listListOf2 = list8;
                                }
                                ArrayList arrayList5 = arrayList;
                                if (Intrinsics.areEqual(strOptString, "tv")) {
                                    strOptString2 = jSONObject.optString("first_air_date", str19);
                                } else {
                                    strOptString2 = jSONObject.optString("release_date", str19);
                                }
                                Integer intOrNull4 = StringsKt.toIntOrNull(StringsKt.take(strOptString2, 4));
                                str21 = strOptString2;
                                dOptDouble = jSONObject.optDouble("vote_average", Double.NaN);
                                strOptString3 = jSONObject.optString("original_language", str19);
                                strCleanTitle = cleanTitle(str22);
                                it2 = arrayList5.iterator();
                                dMax = 0.0d;
                                while (true) {
                                    str21 = str21;
                                    num2 = num2;
                                    if (it2.hasNext()) {
                                        strCleanTitle2 = cleanTitle((String) it2.next());
                                        if (tokenEquals(strCleanTitle2, strCleanTitle)) {
                                            dMax = 50.0d;
                                        } else {
                                            strCleanTitle = strCleanTitle;
                                            str19 = str19;
                                            it = it;
                                            if (!StringsKt.contains$default(strCleanTitle2, strCleanTitle, false, 2, (Object) null)) {
                                            }
                                            dMax = Math.max(dMax, 20.0d);
                                        }
                                    }
                                }
                                dCoerceAtMost = 0.0d + dMax;
                                if (z3) {
                                    if (CollectionsKt.listOf(new String[]{"hi", "ta", "te", "ml", "kn", "pa", "bn", "mr", "gu"}).contains(strOptString3)) {
                                        dCoerceAtMost += 30.0d;
                                    } else if (Intrinsics.areEqual(strOptString3, "en")) {
                                        dCoerceAtMost -= 20.0d;
                                    }
                                }
                                if (num4 == null) {
                                }
                                if (tvType2 == TvType.TvSeries) {
                                    dCoerceAtMost += 15.0d;
                                }
                                if (tvType2 == TvType.Movie) {
                                    str20 = str5;
                                    if (Intrinsics.areEqual(strOptString, str20)) {
                                        dCoerceAtMost += 15.0d;
                                    }
                                } else {
                                    str20 = str5;
                                }
                                if (d3 != null) {
                                    dAbs = Math.abs(dOptDouble - d3.doubleValue());
                                    if (dAbs <= 0.5d) {
                                        dCoerceAtMost += 10.0d;
                                    } else if (dAbs <= 1.0d) {
                                        dCoerceAtMost += 5.0d;
                                    }
                                }
                                if (jSONObject.has("popularity")) {
                                    dCoerceAtMost += RangesKt.coerceAtMost(jSONObject.optDouble("popularity", 0.0d) / 100.0d, 5.0d);
                                }
                                if (dCoerceAtMost > d4) {
                                    Integer numBoxInt4 = Boxing.boxInt(iOptInt);
                                    d2 = dCoerceAtMost;
                                    AreEqual = Intrinsics.areEqual(strOptString, "tv");
                                    num2 = numBoxInt4;
                                }
                                i7 = i8 + 1;
                                length = i14;
                                listListOf = list;
                                it = it;
                                jSONArray = jSONArray;
                                coroutine_suspended = obj12;
                                str5 = str20;
                                str18 = str216;
                                str2 = str19;
                                r9 = AreEqual;
                            } else {
                                str19 = str19;
                                d4 = d2;
                                num2 = num2;
                                it = it;
                                str20 = str5;
                                jSONArray = jSONArray;
                            }
                            AreEqual = r9;
                            d2 = d4;
                            num2 = num2;
                            i7 = i8 + 1;
                            length = i14;
                            listListOf = list;
                            it = it;
                            jSONArray = jSONArray;
                            coroutine_suspended = obj12;
                            str5 = str20;
                            str18 = str216;
                            str2 = str19;
                            r9 = AreEqual;
                        }
                        num5 = num4;
                        d5 = d3;
                        str5 = str5;
                        str2 = str2;
                    } else {
                        str5 = str5;
                        str2 = str2;
                    }
                }
                String str217 = str22;
                Integer num10 = num5;
                Double d9 = d5;
                List list9 = listListOf;
                Object obj13 = coroutine_suspended;
                String str218 = str5;
                if (num2 != null) {
                }
                return new Pair((Object) null, (Object) null);
            case 3:
                int i15 = c00131.I$0;
                boolean z12 = c00131.Z$0;
                String str36 = (String) c00131.L$8;
                pairArr6 = (Pair[]) c00131.L$7;
                pairArr7 = (Pair[]) c00131.L$6;
                String str37 = (String) c00131.L$5;
                String str38 = (String) c00131.L$4;
                TvType tvType8 = (TvType) c00131.L$3;
                d5 = (Double) c00131.L$2;
                num5 = (Integer) c00131.L$1;
                str22 = (String) c00131.L$0;
                ResultKt.throwOnFailure(obj4);
                str8 = str37;
                tvType3 = tvType8;
                objSearchAndPick$doSearch2 = obj4;
                str2 = "";
                i4 = i15;
                str13 = str36;
                z2 = z12;
                str9 = str38;
                obj4 = objSearchAndPick$doSearch2;
                pairArr6[i4] = TuplesKt.to(str13, objSearchAndPick$doSearch2);
                listListOf = CollectionsKt.listOf(pairArr7);
                boolean z13 = z2;
                tvType2 = tvType3;
                z3 = z13;
                str5 = str24;
                str14 = str9;
                d2 = -1.0d;
                it = listListOf.iterator();
                num2 = null;
                r9 = 0;
                while (it.hasNext()) {
                    Pair pair5 = (Pair) it.next();
                    str22 = str22;
                    str18 = (String) pair5.component1();
                    jSONArray = (JSONArray) pair5.component2();
                    if (jSONArray != null) {
                        num4 = num5;
                        length = jSONArray.length();
                        d3 = d5;
                        i7 = 0;
                        r9 = r9;
                        while (i7 < length) {
                            int i16 = length;
                            jSONObject = jSONArray.getJSONObject(i7);
                            if (Intrinsics.areEqual(str18, "multi")) {
                                i8 = i7;
                                list = listListOf;
                                str19 = str2;
                                strOptString = jSONObject.optString("media_type", str19);
                            } else {
                                i8 = i7;
                                list = listListOf;
                                str19 = str2;
                                if (Intrinsics.areEqual(str18, "tv")) {
                                    strOptString = "tv";
                                } else {
                                    strOptString = str5;
                                }
                            }
                            String str219 = str18;
                            Object obj14 = coroutine_suspended;
                            iOptInt = jSONObject.optInt("id", -1);
                            if (iOptInt != -1) {
                                d4 = d2;
                                listListOf2 = CollectionsKt.listOf(new String[]{jSONObject.optString("title"), jSONObject.optString("name"), jSONObject.optString("original_title"), jSONObject.optString("original_name")});
                                arrayList = new ArrayList();
                                while (r34.hasNext()) {
                                    List list10 = listListOf2;
                                    if (!StringsKt.isBlank((String) obj6)) {
                                        arrayList.add(obj6);
                                    }
                                    listListOf2 = list10;
                                }
                                ArrayList arrayList6 = arrayList;
                                if (Intrinsics.areEqual(strOptString, "tv")) {
                                    strOptString2 = jSONObject.optString("first_air_date", str19);
                                } else {
                                    strOptString2 = jSONObject.optString("release_date", str19);
                                }
                                Integer intOrNull5 = StringsKt.toIntOrNull(StringsKt.take(strOptString2, 4));
                                str21 = strOptString2;
                                dOptDouble = jSONObject.optDouble("vote_average", Double.NaN);
                                strOptString3 = jSONObject.optString("original_language", str19);
                                strCleanTitle = cleanTitle(str22);
                                it2 = arrayList6.iterator();
                                dMax = 0.0d;
                                while (true) {
                                    str21 = str21;
                                    num2 = num2;
                                    if (it2.hasNext()) {
                                        strCleanTitle2 = cleanTitle((String) it2.next());
                                        if (tokenEquals(strCleanTitle2, strCleanTitle)) {
                                            dMax = 50.0d;
                                        } else {
                                            strCleanTitle = strCleanTitle;
                                            str19 = str19;
                                            it = it;
                                            if (!StringsKt.contains$default(strCleanTitle2, strCleanTitle, false, 2, (Object) null)) {
                                            }
                                            dMax = Math.max(dMax, 20.0d);
                                        }
                                    }
                                }
                                dCoerceAtMost = 0.0d + dMax;
                                if (z3) {
                                    if (CollectionsKt.listOf(new String[]{"hi", "ta", "te", "ml", "kn", "pa", "bn", "mr", "gu"}).contains(strOptString3)) {
                                        dCoerceAtMost += 30.0d;
                                    } else if (Intrinsics.areEqual(strOptString3, "en")) {
                                        dCoerceAtMost -= 20.0d;
                                    }
                                }
                                if (num4 == null) {
                                }
                                if (tvType2 == TvType.TvSeries) {
                                    dCoerceAtMost += 15.0d;
                                }
                                if (tvType2 == TvType.Movie) {
                                    str20 = str5;
                                    if (Intrinsics.areEqual(strOptString, str20)) {
                                        dCoerceAtMost += 15.0d;
                                    }
                                } else {
                                    str20 = str5;
                                }
                                if (d3 != null) {
                                    dAbs = Math.abs(dOptDouble - d3.doubleValue());
                                    if (dAbs <= 0.5d) {
                                        dCoerceAtMost += 10.0d;
                                    } else if (dAbs <= 1.0d) {
                                        dCoerceAtMost += 5.0d;
                                    }
                                }
                                if (jSONObject.has("popularity")) {
                                    dCoerceAtMost += RangesKt.coerceAtMost(jSONObject.optDouble("popularity", 0.0d) / 100.0d, 5.0d);
                                }
                                if (dCoerceAtMost > d4) {
                                    Integer numBoxInt5 = Boxing.boxInt(iOptInt);
                                    d2 = dCoerceAtMost;
                                    AreEqual = Intrinsics.areEqual(strOptString, "tv");
                                    num2 = numBoxInt5;
                                }
                                i7 = i8 + 1;
                                length = i16;
                                listListOf = list;
                                it = it;
                                jSONArray = jSONArray;
                                coroutine_suspended = obj14;
                                str5 = str20;
                                str18 = str219;
                                str2 = str19;
                                r9 = AreEqual;
                            } else {
                                str19 = str19;
                                d4 = d2;
                                num2 = num2;
                                it = it;
                                str20 = str5;
                                jSONArray = jSONArray;
                            }
                            AreEqual = r9;
                            d2 = d4;
                            num2 = num2;
                            i7 = i8 + 1;
                            length = i16;
                            listListOf = list;
                            it = it;
                            jSONArray = jSONArray;
                            coroutine_suspended = obj14;
                            str5 = str20;
                            str18 = str219;
                            str2 = str19;
                            r9 = AreEqual;
                        }
                        num5 = num4;
                        d5 = d3;
                        str5 = str5;
                        str2 = str2;
                    } else {
                        str5 = str5;
                        str2 = str2;
                    }
                }
                String str2110 = str22;
                Integer num11 = num5;
                Double d10 = d5;
                List list11 = listListOf;
                Object obj15 = coroutine_suspended;
                String str2111 = str5;
                if (num2 != null) {
                }
                return new Pair((Object) null, (Object) null);
            case 4:
                int i17 = c00131.I$0;
                boolean z14 = c00131.Z$0;
                String str39 = (String) c00131.L$8;
                Pair[] pairArr17 = (Pair[]) c00131.L$7;
                Pair[] pairArr18 = (Pair[]) c00131.L$6;
                String str40 = (String) c00131.L$5;
                String str41 = (String) c00131.L$4;
                TvType tvType9 = (TvType) c00131.L$3;
                d5 = (Double) c00131.L$2;
                num5 = (Integer) c00131.L$1;
                str22 = (String) c00131.L$0;
                ResultKt.throwOnFailure(obj4);
                str5 = "movie";
                str6 = str40;
                i = i17;
                str7 = str41;
                str2 = "";
                pairArr = pairArr18;
                tvType3 = tvType9;
                z6 = z14;
                pairArr2 = pairArr17;
                obj4 = obj4;
                str4 = str39;
                pairArr2[i] = TuplesKt.to(str4, obj4);
                c00131.L$0 = str22;
                c00131.L$1 = num5;
                c00131.L$2 = d5;
                c00131.L$3 = tvType3;
                c00131.L$4 = SpillingKt.nullOutSpilledVariable(str7);
                c00131.L$5 = str6;
                c00131.L$6 = pairArr;
                c00131.L$7 = pairArr;
                c00131.L$8 = "multi";
                c00131.Z$0 = z6;
                c00131.I$0 = 1;
                c00131.label = 5;
                objSearchAndPick$doSearch3 = searchAndPick$doSearch("search/multi", "&query=" + str22 + str7, c00131);
                if (objSearchAndPick$doSearch3 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj3 = objSearchAndPick$doSearch3;
                pairArr8 = pairArr;
                i5 = 1;
                z4 = z6;
                pairArr9 = pairArr8;
                str15 = "multi";
                pairArr8[i5] = TuplesKt.to(str15, obj3);
                c00131.L$0 = str22;
                c00131.L$1 = num5;
                c00131.L$2 = d5;
                c00131.L$3 = tvType3;
                c00131.L$4 = SpillingKt.nullOutSpilledVariable(str7);
                c00131.L$5 = SpillingKt.nullOutSpilledVariable(str6);
                c00131.L$6 = pairArr9;
                c00131.L$7 = pairArr9;
                c00131.L$8 = "tv";
                c00131.Z$0 = z4;
                c00131.I$0 = 2;
                c00131.label = 6;
                objSearchAndPick$doSearch4 = searchAndPick$doSearch(str23, "&query=" + str22 + str6, c00131);
                if (objSearchAndPick$doSearch4 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                pairArr10 = pairArr9;
                pairArr11 = pairArr10;
                z5 = z4;
                i6 = 2;
                str16 = "tv";
                pairArr10[i6] = TuplesKt.to(str16, objSearchAndPick$doSearch4);
                TvType tvType10 = tvType3;
                z3 = z5;
                listListOf = CollectionsKt.listOf(pairArr11);
                tvType2 = tvType10;
                str8 = str6;
                str14 = str7;
                d2 = -1.0d;
                it = listListOf.iterator();
                num2 = null;
                r9 = 0;
                while (it.hasNext()) {
                    Pair pair6 = (Pair) it.next();
                    str22 = str22;
                    str18 = (String) pair6.component1();
                    jSONArray = (JSONArray) pair6.component2();
                    if (jSONArray != null) {
                        num4 = num5;
                        length = jSONArray.length();
                        d3 = d5;
                        i7 = 0;
                        r9 = r9;
                        while (i7 < length) {
                            int i18 = length;
                            jSONObject = jSONArray.getJSONObject(i7);
                            if (Intrinsics.areEqual(str18, "multi")) {
                                i8 = i7;
                                list = listListOf;
                                str19 = str2;
                                strOptString = jSONObject.optString("media_type", str19);
                            } else {
                                i8 = i7;
                                list = listListOf;
                                str19 = str2;
                                if (Intrinsics.areEqual(str18, "tv")) {
                                    strOptString = "tv";
                                } else {
                                    strOptString = str5;
                                }
                            }
                            String str2112 = str18;
                            Object obj16 = coroutine_suspended;
                            iOptInt = jSONObject.optInt("id", -1);
                            if (iOptInt != -1) {
                                d4 = d2;
                                listListOf2 = CollectionsKt.listOf(new String[]{jSONObject.optString("title"), jSONObject.optString("name"), jSONObject.optString("original_title"), jSONObject.optString("original_name")});
                                arrayList = new ArrayList();
                                while (r34.hasNext()) {
                                    List list12 = listListOf2;
                                    if (!StringsKt.isBlank((String) obj6)) {
                                        arrayList.add(obj6);
                                    }
                                    listListOf2 = list12;
                                }
                                ArrayList arrayList7 = arrayList;
                                if (Intrinsics.areEqual(strOptString, "tv")) {
                                    strOptString2 = jSONObject.optString("first_air_date", str19);
                                } else {
                                    strOptString2 = jSONObject.optString("release_date", str19);
                                }
                                Integer intOrNull6 = StringsKt.toIntOrNull(StringsKt.take(strOptString2, 4));
                                str21 = strOptString2;
                                dOptDouble = jSONObject.optDouble("vote_average", Double.NaN);
                                strOptString3 = jSONObject.optString("original_language", str19);
                                strCleanTitle = cleanTitle(str22);
                                it2 = arrayList7.iterator();
                                dMax = 0.0d;
                                while (true) {
                                    str21 = str21;
                                    num2 = num2;
                                    if (it2.hasNext()) {
                                        strCleanTitle2 = cleanTitle((String) it2.next());
                                        if (tokenEquals(strCleanTitle2, strCleanTitle)) {
                                            dMax = 50.0d;
                                        } else {
                                            strCleanTitle = strCleanTitle;
                                            str19 = str19;
                                            it = it;
                                            if (!StringsKt.contains$default(strCleanTitle2, strCleanTitle, false, 2, (Object) null)) {
                                            }
                                            dMax = Math.max(dMax, 20.0d);
                                        }
                                    }
                                }
                                dCoerceAtMost = 0.0d + dMax;
                                if (z3) {
                                    if (CollectionsKt.listOf(new String[]{"hi", "ta", "te", "ml", "kn", "pa", "bn", "mr", "gu"}).contains(strOptString3)) {
                                        dCoerceAtMost += 30.0d;
                                    } else if (Intrinsics.areEqual(strOptString3, "en")) {
                                        dCoerceAtMost -= 20.0d;
                                    }
                                }
                                if (num4 == null) {
                                }
                                if (tvType2 == TvType.TvSeries) {
                                    dCoerceAtMost += 15.0d;
                                }
                                if (tvType2 == TvType.Movie) {
                                    str20 = str5;
                                    if (Intrinsics.areEqual(strOptString, str20)) {
                                        dCoerceAtMost += 15.0d;
                                    }
                                } else {
                                    str20 = str5;
                                }
                                if (d3 != null) {
                                    dAbs = Math.abs(dOptDouble - d3.doubleValue());
                                    if (dAbs <= 0.5d) {
                                        dCoerceAtMost += 10.0d;
                                    } else if (dAbs <= 1.0d) {
                                        dCoerceAtMost += 5.0d;
                                    }
                                }
                                if (jSONObject.has("popularity")) {
                                    dCoerceAtMost += RangesKt.coerceAtMost(jSONObject.optDouble("popularity", 0.0d) / 100.0d, 5.0d);
                                }
                                if (dCoerceAtMost > d4) {
                                    Integer numBoxInt6 = Boxing.boxInt(iOptInt);
                                    d2 = dCoerceAtMost;
                                    AreEqual = Intrinsics.areEqual(strOptString, "tv");
                                    num2 = numBoxInt6;
                                }
                                i7 = i8 + 1;
                                length = i18;
                                listListOf = list;
                                it = it;
                                jSONArray = jSONArray;
                                coroutine_suspended = obj16;
                                str5 = str20;
                                str18 = str2112;
                                str2 = str19;
                                r9 = AreEqual;
                            } else {
                                str19 = str19;
                                d4 = d2;
                                num2 = num2;
                                it = it;
                                str20 = str5;
                                jSONArray = jSONArray;
                            }
                            AreEqual = r9;
                            d2 = d4;
                            num2 = num2;
                            i7 = i8 + 1;
                            length = i18;
                            listListOf = list;
                            it = it;
                            jSONArray = jSONArray;
                            coroutine_suspended = obj16;
                            str5 = str20;
                            str18 = str2112;
                            str2 = str19;
                            r9 = AreEqual;
                        }
                        num5 = num4;
                        d5 = d3;
                        str5 = str5;
                        str2 = str2;
                    } else {
                        str5 = str5;
                        str2 = str2;
                    }
                }
                String str2113 = str22;
                Integer num12 = num5;
                Double d11 = d5;
                List list13 = listListOf;
                Object obj17 = coroutine_suspended;
                String str2114 = str5;
                if (num2 != null) {
                }
                return new Pair((Object) null, (Object) null);
            case 5:
                int i19 = c00131.I$0;
                boolean z15 = c00131.Z$0;
                String str42 = (String) c00131.L$8;
                Pair[] pairArr19 = (Pair[]) c00131.L$7;
                Pair[] pairArr20 = (Pair[]) c00131.L$6;
                String str43 = (String) c00131.L$5;
                String str44 = (String) c00131.L$4;
                TvType tvType11 = (TvType) c00131.L$3;
                d5 = (Double) c00131.L$2;
                num5 = (Integer) c00131.L$1;
                str22 = (String) c00131.L$0;
                ResultKt.throwOnFailure(obj4);
                pairArr8 = pairArr19;
                tvType3 = tvType11;
                str5 = "movie";
                pairArr9 = pairArr20;
                str6 = str43;
                str23 = "search/tv";
                str2 = "";
                obj3 = obj4;
                str15 = str42;
                i5 = i19;
                z4 = z15;
                str7 = str44;
                obj4 = obj3;
                pairArr8[i5] = TuplesKt.to(str15, obj3);
                c00131.L$0 = str22;
                c00131.L$1 = num5;
                c00131.L$2 = d5;
                c00131.L$3 = tvType3;
                c00131.L$4 = SpillingKt.nullOutSpilledVariable(str7);
                c00131.L$5 = SpillingKt.nullOutSpilledVariable(str6);
                c00131.L$6 = pairArr9;
                c00131.L$7 = pairArr9;
                c00131.L$8 = "tv";
                c00131.Z$0 = z4;
                c00131.I$0 = 2;
                c00131.label = 6;
                objSearchAndPick$doSearch4 = searchAndPick$doSearch(str23, "&query=" + str22 + str6, c00131);
                if (objSearchAndPick$doSearch4 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                pairArr10 = pairArr9;
                pairArr11 = pairArr10;
                z5 = z4;
                i6 = 2;
                str16 = "tv";
                pairArr10[i6] = TuplesKt.to(str16, objSearchAndPick$doSearch4);
                TvType tvType12 = tvType3;
                z3 = z5;
                listListOf = CollectionsKt.listOf(pairArr11);
                tvType2 = tvType12;
                str8 = str6;
                str14 = str7;
                d2 = -1.0d;
                it = listListOf.iterator();
                num2 = null;
                r9 = 0;
                while (it.hasNext()) {
                    Pair pair7 = (Pair) it.next();
                    str22 = str22;
                    str18 = (String) pair7.component1();
                    jSONArray = (JSONArray) pair7.component2();
                    if (jSONArray != null) {
                        num4 = num5;
                        length = jSONArray.length();
                        d3 = d5;
                        i7 = 0;
                        r9 = r9;
                        while (i7 < length) {
                            int i110 = length;
                            jSONObject = jSONArray.getJSONObject(i7);
                            if (Intrinsics.areEqual(str18, "multi")) {
                                i8 = i7;
                                list = listListOf;
                                str19 = str2;
                                strOptString = jSONObject.optString("media_type", str19);
                            } else {
                                i8 = i7;
                                list = listListOf;
                                str19 = str2;
                                if (Intrinsics.areEqual(str18, "tv")) {
                                    strOptString = "tv";
                                } else {
                                    strOptString = str5;
                                }
                            }
                            String str2115 = str18;
                            Object obj18 = coroutine_suspended;
                            iOptInt = jSONObject.optInt("id", -1);
                            if (iOptInt != -1) {
                                d4 = d2;
                                listListOf2 = CollectionsKt.listOf(new String[]{jSONObject.optString("title"), jSONObject.optString("name"), jSONObject.optString("original_title"), jSONObject.optString("original_name")});
                                arrayList = new ArrayList();
                                while (r34.hasNext()) {
                                    List list14 = listListOf2;
                                    if (!StringsKt.isBlank((String) obj6)) {
                                        arrayList.add(obj6);
                                    }
                                    listListOf2 = list14;
                                }
                                ArrayList arrayList8 = arrayList;
                                if (Intrinsics.areEqual(strOptString, "tv")) {
                                    strOptString2 = jSONObject.optString("first_air_date", str19);
                                } else {
                                    strOptString2 = jSONObject.optString("release_date", str19);
                                }
                                Integer intOrNull7 = StringsKt.toIntOrNull(StringsKt.take(strOptString2, 4));
                                str21 = strOptString2;
                                dOptDouble = jSONObject.optDouble("vote_average", Double.NaN);
                                strOptString3 = jSONObject.optString("original_language", str19);
                                strCleanTitle = cleanTitle(str22);
                                it2 = arrayList8.iterator();
                                dMax = 0.0d;
                                while (true) {
                                    str21 = str21;
                                    num2 = num2;
                                    if (it2.hasNext()) {
                                        strCleanTitle2 = cleanTitle((String) it2.next());
                                        if (tokenEquals(strCleanTitle2, strCleanTitle)) {
                                            dMax = 50.0d;
                                        } else {
                                            strCleanTitle = strCleanTitle;
                                            str19 = str19;
                                            it = it;
                                            if (!StringsKt.contains$default(strCleanTitle2, strCleanTitle, false, 2, (Object) null)) {
                                            }
                                            dMax = Math.max(dMax, 20.0d);
                                        }
                                    }
                                }
                                dCoerceAtMost = 0.0d + dMax;
                                if (z3) {
                                    if (CollectionsKt.listOf(new String[]{"hi", "ta", "te", "ml", "kn", "pa", "bn", "mr", "gu"}).contains(strOptString3)) {
                                        dCoerceAtMost += 30.0d;
                                    } else if (Intrinsics.areEqual(strOptString3, "en")) {
                                        dCoerceAtMost -= 20.0d;
                                    }
                                }
                                if (num4 == null) {
                                }
                                if (tvType2 == TvType.TvSeries) {
                                    dCoerceAtMost += 15.0d;
                                }
                                if (tvType2 == TvType.Movie) {
                                    str20 = str5;
                                    if (Intrinsics.areEqual(strOptString, str20)) {
                                        dCoerceAtMost += 15.0d;
                                    }
                                } else {
                                    str20 = str5;
                                }
                                if (d3 != null) {
                                    dAbs = Math.abs(dOptDouble - d3.doubleValue());
                                    if (dAbs <= 0.5d) {
                                        dCoerceAtMost += 10.0d;
                                    } else if (dAbs <= 1.0d) {
                                        dCoerceAtMost += 5.0d;
                                    }
                                }
                                if (jSONObject.has("popularity")) {
                                    dCoerceAtMost += RangesKt.coerceAtMost(jSONObject.optDouble("popularity", 0.0d) / 100.0d, 5.0d);
                                }
                                if (dCoerceAtMost > d4) {
                                    Integer numBoxInt7 = Boxing.boxInt(iOptInt);
                                    d2 = dCoerceAtMost;
                                    AreEqual = Intrinsics.areEqual(strOptString, "tv");
                                    num2 = numBoxInt7;
                                }
                                i7 = i8 + 1;
                                length = i110;
                                listListOf = list;
                                it = it;
                                jSONArray = jSONArray;
                                coroutine_suspended = obj18;
                                str5 = str20;
                                str18 = str2115;
                                str2 = str19;
                                r9 = AreEqual;
                            } else {
                                str19 = str19;
                                d4 = d2;
                                num2 = num2;
                                it = it;
                                str20 = str5;
                                jSONArray = jSONArray;
                            }
                            AreEqual = r9;
                            d2 = d4;
                            num2 = num2;
                            i7 = i8 + 1;
                            length = i110;
                            listListOf = list;
                            it = it;
                            jSONArray = jSONArray;
                            coroutine_suspended = obj18;
                            str5 = str20;
                            str18 = str2115;
                            str2 = str19;
                            r9 = AreEqual;
                        }
                        num5 = num4;
                        d5 = d3;
                        str5 = str5;
                        str2 = str2;
                    } else {
                        str5 = str5;
                        str2 = str2;
                    }
                }
                String str2116 = str22;
                Integer num13 = num5;
                Double d12 = d5;
                List list15 = listListOf;
                Object obj19 = coroutine_suspended;
                String str2117 = str5;
                if (num2 != null) {
                }
                return new Pair((Object) null, (Object) null);
            case 6:
                int i20 = c00131.I$0;
                boolean z16 = c00131.Z$0;
                String str45 = (String) c00131.L$8;
                pairArr10 = (Pair[]) c00131.L$7;
                pairArr11 = (Pair[]) c00131.L$6;
                String str46 = (String) c00131.L$5;
                String str47 = (String) c00131.L$4;
                TvType tvType13 = (TvType) c00131.L$3;
                d5 = (Double) c00131.L$2;
                num5 = (Integer) c00131.L$1;
                str22 = (String) c00131.L$0;
                ResultKt.throwOnFailure(obj4);
                tvType3 = tvType13;
                str5 = "movie";
                str2 = "";
                z5 = z16;
                str6 = str46;
                obj4 = obj4;
                i6 = i20;
                objSearchAndPick$doSearch4 = obj4;
                str16 = str45;
                str7 = str47;
                pairArr10[i6] = TuplesKt.to(str16, objSearchAndPick$doSearch4);
                TvType tvType14 = tvType3;
                z3 = z5;
                listListOf = CollectionsKt.listOf(pairArr11);
                tvType2 = tvType14;
                str8 = str6;
                str14 = str7;
                d2 = -1.0d;
                it = listListOf.iterator();
                num2 = null;
                r9 = 0;
                while (it.hasNext()) {
                    Pair pair8 = (Pair) it.next();
                    str22 = str22;
                    str18 = (String) pair8.component1();
                    jSONArray = (JSONArray) pair8.component2();
                    if (jSONArray != null) {
                        num4 = num5;
                        length = jSONArray.length();
                        d3 = d5;
                        i7 = 0;
                        r9 = r9;
                        while (i7 < length) {
                            int i111 = length;
                            jSONObject = jSONArray.getJSONObject(i7);
                            if (Intrinsics.areEqual(str18, "multi")) {
                                i8 = i7;
                                list = listListOf;
                                str19 = str2;
                                strOptString = jSONObject.optString("media_type", str19);
                            } else {
                                i8 = i7;
                                list = listListOf;
                                str19 = str2;
                                if (Intrinsics.areEqual(str18, "tv")) {
                                    strOptString = "tv";
                                } else {
                                    strOptString = str5;
                                }
                            }
                            String str2118 = str18;
                            Object obj110 = coroutine_suspended;
                            iOptInt = jSONObject.optInt("id", -1);
                            if (iOptInt != -1) {
                                d4 = d2;
                                listListOf2 = CollectionsKt.listOf(new String[]{jSONObject.optString("title"), jSONObject.optString("name"), jSONObject.optString("original_title"), jSONObject.optString("original_name")});
                                arrayList = new ArrayList();
                                while (r34.hasNext()) {
                                    List list16 = listListOf2;
                                    if (!StringsKt.isBlank((String) obj6)) {
                                        arrayList.add(obj6);
                                    }
                                    listListOf2 = list16;
                                }
                                ArrayList arrayList9 = arrayList;
                                if (Intrinsics.areEqual(strOptString, "tv")) {
                                    strOptString2 = jSONObject.optString("first_air_date", str19);
                                } else {
                                    strOptString2 = jSONObject.optString("release_date", str19);
                                }
                                Integer intOrNull8 = StringsKt.toIntOrNull(StringsKt.take(strOptString2, 4));
                                str21 = strOptString2;
                                dOptDouble = jSONObject.optDouble("vote_average", Double.NaN);
                                strOptString3 = jSONObject.optString("original_language", str19);
                                strCleanTitle = cleanTitle(str22);
                                it2 = arrayList9.iterator();
                                dMax = 0.0d;
                                while (true) {
                                    str21 = str21;
                                    num2 = num2;
                                    if (it2.hasNext()) {
                                        strCleanTitle2 = cleanTitle((String) it2.next());
                                        if (tokenEquals(strCleanTitle2, strCleanTitle)) {
                                            dMax = 50.0d;
                                        } else {
                                            strCleanTitle = strCleanTitle;
                                            str19 = str19;
                                            it = it;
                                            if (!StringsKt.contains$default(strCleanTitle2, strCleanTitle, false, 2, (Object) null)) {
                                            }
                                            dMax = Math.max(dMax, 20.0d);
                                        }
                                    }
                                }
                                dCoerceAtMost = 0.0d + dMax;
                                if (z3) {
                                    if (CollectionsKt.listOf(new String[]{"hi", "ta", "te", "ml", "kn", "pa", "bn", "mr", "gu"}).contains(strOptString3)) {
                                        dCoerceAtMost += 30.0d;
                                    } else if (Intrinsics.areEqual(strOptString3, "en")) {
                                        dCoerceAtMost -= 20.0d;
                                    }
                                }
                                if (num4 == null) {
                                }
                                if (tvType2 == TvType.TvSeries) {
                                    dCoerceAtMost += 15.0d;
                                }
                                if (tvType2 == TvType.Movie) {
                                    str20 = str5;
                                    if (Intrinsics.areEqual(strOptString, str20)) {
                                        dCoerceAtMost += 15.0d;
                                    }
                                } else {
                                    str20 = str5;
                                }
                                if (d3 != null) {
                                    dAbs = Math.abs(dOptDouble - d3.doubleValue());
                                    if (dAbs <= 0.5d) {
                                        dCoerceAtMost += 10.0d;
                                    } else if (dAbs <= 1.0d) {
                                        dCoerceAtMost += 5.0d;
                                    }
                                }
                                if (jSONObject.has("popularity")) {
                                    dCoerceAtMost += RangesKt.coerceAtMost(jSONObject.optDouble("popularity", 0.0d) / 100.0d, 5.0d);
                                }
                                if (dCoerceAtMost > d4) {
                                    Integer numBoxInt8 = Boxing.boxInt(iOptInt);
                                    d2 = dCoerceAtMost;
                                    AreEqual = Intrinsics.areEqual(strOptString, "tv");
                                    num2 = numBoxInt8;
                                }
                                i7 = i8 + 1;
                                length = i111;
                                listListOf = list;
                                it = it;
                                jSONArray = jSONArray;
                                coroutine_suspended = obj110;
                                str5 = str20;
                                str18 = str2118;
                                str2 = str19;
                                r9 = AreEqual;
                            } else {
                                str19 = str19;
                                d4 = d2;
                                num2 = num2;
                                it = it;
                                str20 = str5;
                                jSONArray = jSONArray;
                            }
                            AreEqual = r9;
                            d2 = d4;
                            num2 = num2;
                            i7 = i8 + 1;
                            length = i111;
                            listListOf = list;
                            it = it;
                            jSONArray = jSONArray;
                            coroutine_suspended = obj110;
                            str5 = str20;
                            str18 = str2118;
                            str2 = str19;
                            r9 = AreEqual;
                        }
                        num5 = num4;
                        d5 = d3;
                        str5 = str5;
                        str2 = str2;
                    } else {
                        str5 = str5;
                        str2 = str2;
                    }
                }
                String str2119 = str22;
                Integer num14 = num5;
                Double d13 = d5;
                List list17 = listListOf;
                Object obj111 = coroutine_suspended;
                String str21110 = str5;
                if (num2 != null) {
                }
                return new Pair((Object) null, (Object) null);
            case 7:
                int i21 = c00131.I$0;
                double d14 = c00131.D$0;
                boolean z17 = c00131.Z$0;
                num3 = (Integer) c00131.L$7;
                str17 = (String) c00131.L$0;
                ResultKt.throwOnFailure(obj4);
                jSONObjectOptJSONObject = new JSONObject(((NiceResponse) obj4).getText()).optJSONObject("external_ids");
                if (jSONObjectOptJSONObject != null) {
                    strOptString4 = jSONObjectOptJSONObject.optString("imdb_id");
                } else {
                    strOptString4 = null;
                }
                return new Pair(num3, strOptString4);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static /* synthetic */ Object searchAndPick$default(String str, Integer num, Double d, boolean z, TvType tvType, Continuation continuation, int i, Object obj) {
        TvType tvType2;
        boolean z2 = (i & 8) != 0 ? false : z;
        if ((i & 16) == 0) {
            tvType2 = tvType;
        } else {
            tvType2 = TvType.Movie;
        }
        return searchAndPick(str, num, d, z2, tvType2, continuation);
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
        C00101 c00101;
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
                String str = imdbId;
                if (str == null || StringsKt.isBlank(str)) {
                    return null;
                }
                String metaType = type == TvType.TvSeries ? "series" : "movie";
                String url = "https://v3-cinemeta.strem.io/meta/" + metaType + '/' + imdbId + ".json";
                try {
                    Requests app = MainActivityKt.getApp();
                    c00102.L$0 = SpillingKt.nullOutSpilledVariable(imdbId);
                    c00102.L$1 = SpillingKt.nullOutSpilledVariable(type);
                    c00102.L$2 = SpillingKt.nullOutSpilledVariable(metaType);
                    c00102.L$3 = SpillingKt.nullOutSpilledVariable(url);
                    c00102.label = 1;
                    try {
                        Object obj = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00102, 4094, (Object) null);
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
        C00111 c00111;
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
        C00111 c00112 = c00111;
        Object $result = c00112.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00112.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (tmdbId == null) {
                    return null;
                }
                String url = type == TvType.Movie ? tmdbAPI3 + "/movie/" + tmdbId.intValue() + "/images?api_key=" + apiKey : tmdbAPI3 + "/tv/" + tmdbId.intValue() + "/images?api_key=" + apiKey;
                try {
                    Result.Companion companion = Result.Companion;
                    Requests app = MainActivityKt.getApp();
                    c00112.L$0 = SpillingKt.nullOutSpilledVariable(tmdbAPI3);
                    c00112.L$1 = SpillingKt.nullOutSpilledVariable(apiKey);
                    c00112.L$2 = SpillingKt.nullOutSpilledVariable(type);
                    c00112.L$3 = SpillingKt.nullOutSpilledVariable(tmdbId);
                    c00112.L$4 = appLangCode;
                    c00112.L$5 = SpillingKt.nullOutSpilledVariable(url);
                    c00112.label = 1;
                    try {
                        Object obj2 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00112, 4094, (Object) null);
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
                appLangCode2 = (String) c00112.L$4;
                tmdbAPI3 = (String) c00112.L$0;
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
