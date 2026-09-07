package com.AniVortex;

import com.lagradost.cloudstream3.Actor;
import com.lagradost.cloudstream3.ActorData;
import com.lagradost.cloudstream3.ActorRole;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: AniVortexTmdb.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/AniVortex/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0002JR\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0086@¢\u0006\u0002\u0010\u0013J*\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0015\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0016\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u0017J \u0010\u0018\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0082@¢\u0006\u0002\u0010\u001aJ \u0010\u001b\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u001dJ\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/AniVortex/AniVortexTmdb;", "", "<init>", "()V", "TMDB_API", "", "TMDB_KEY", "TMDB_IMG", "cleanSearchTitle", "title", "fetchMetadata", "Lcom/AniVortex/TmdbMetadata;", "originalTitle", "year", "", "isMovie", "", "explicitTmdbId", "explicitImdbId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZLjava/lang/Integer;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchTmdbId", "query", "type", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findTmdbIdByImdb", "imdbId", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchDetails", "tmdbId", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "extractLogoUrl", "imagesObj", "Lorg/json/JSONObject;", "AniVortex"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAniVortexTmdb.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AniVortexTmdb.kt\ncom/AniVortex/AniVortexTmdb\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,219:1\n1#2:220\n1#2:232\n1#2:246\n1795#3,10:221\n2068#3:231\n2069#3:233\n1805#3:234\n1795#3,10:235\n2068#3:245\n2069#3:247\n1805#3:248\n*S KotlinDebug\n*F\n+ 1 AniVortexTmdb.kt\ncom/AniVortex/AniVortexTmdb\n*L\n123#1:232\n128#1:246\n123#1:221,10\n123#1:231\n123#1:233\n123#1:234\n128#1:235,10\n128#1:245\n128#1:247\n128#1:248\n*E\n"})
public final class AniVortexTmdb {

    @NotNull
    public static final AniVortexTmdb INSTANCE = new AniVortexTmdb();

    @NotNull
    private static final String TMDB_API = "https://api.themoviedb.org/3";

    @NotNull
    private static final String TMDB_IMG = "https://image.tmdb.org/t/p";

    @NotNull
    private static final String TMDB_KEY = "1865f43a0549ca50d341dd9ab8b29f49";

    /* JADX INFO: renamed from: com.AniVortex.AniVortexTmdb$fetchDetails$1 */
    /* JADX INFO: compiled from: AniVortexTmdb.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.AniVortex.AniVortexTmdb", f = "AniVortexTmdb.kt", i = {0, 0, 0, 0}, l = {98}, m = "fetchDetails", n = {"type", "url", "$this$fetchDetails_u24lambda_u240", "tmdbId"}, nl = {98}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 2)
    static final class C00201 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00201(Continuation<? super C00201> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AniVortexTmdb.this.fetchDetails(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.AniVortex.AniVortexTmdb$fetchMetadata$1 */
    /* JADX INFO: compiled from: AniVortexTmdb.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.AniVortex.AniVortexTmdb", f = "AniVortexTmdb.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4}, l = {48, 54, 58, 64, 71}, m = "fetchMetadata", n = {"title", "originalTitle", "year", "explicitTmdbId", "explicitImdbId", "tmdbType", "resolvedTmdbId", "isMovie", "title", "originalTitle", "year", "explicitTmdbId", "explicitImdbId", "tmdbType", "resolvedTmdbId", "cleanTitle", "isMovie", "title", "originalTitle", "year", "explicitTmdbId", "explicitImdbId", "tmdbType", "resolvedTmdbId", "cleanTitle", "isMovie", "title", "originalTitle", "year", "explicitTmdbId", "explicitImdbId", "tmdbType", "resolvedTmdbId", "cleanTitle", "cleanOrig", "isMovie", "title", "originalTitle", "year", "explicitTmdbId", "explicitImdbId", "tmdbType", "resolvedTmdbId", "isMovie"}, nl = {52, 57, 62, 68, -1}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0"}, v = 2)
    static final class C00211 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00211(Continuation<? super C00211> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AniVortexTmdb.this.fetchMetadata(null, null, null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.AniVortex.AniVortexTmdb$findTmdbIdByImdb$1 */
    /* JADX INFO: compiled from: AniVortexTmdb.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.AniVortex.AniVortexTmdb", f = "AniVortexTmdb.kt", i = {0, 0, 0, 0}, l = {90}, m = "findTmdbIdByImdb", n = {"imdbId", "url", "$this$findTmdbIdByImdb_u24lambda_u240", "isMovie"}, nl = {90}, s = {"L$0", "L$1", "L$2", "Z$0"}, v = 2)
    static final class C00221 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00221(Continuation<? super C00221> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AniVortexTmdb.this.findTmdbIdByImdb(null, false, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.AniVortex.AniVortexTmdb$searchTmdbId$1 */
    /* JADX INFO: compiled from: AniVortexTmdb.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.AniVortex.AniVortexTmdb", f = "AniVortexTmdb.kt", i = {0, 0, 0, 0, 0, 0}, l = {81}, m = "searchTmdbId", n = {"query", "year", "type", "yearParam", "url", "$this$searchTmdbId_u24lambda_u240"}, nl = {81}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
    static final class C00231 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C00231(Continuation<? super C00231> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AniVortexTmdb.this.searchTmdbId(null, null, null, (Continuation) this);
        }
    }

    private AniVortexTmdb() {
    }

    private final String cleanSearchTitle(String title) {
        return StringsKt.trim(new Regex("\\[.*?]|\\(.*?\\)|\\{.*?\\}").replace(new Regex("(?i)\\b(?:hindi|english|tamil|telugu|dub|dubbed|sub|subbed|multi|dual\\s*audio)\\b.*").replace(new Regex("(?i)\\b(?:season|s)\\s*\\d+.*").replace(new Regex("\\((?:19|20)\\d{2}\\)").replace(title, ""), ""), ""), "")).toString();
    }

    public static /* synthetic */ Object fetchMetadata$default(AniVortexTmdb aniVortexTmdb, String str, String str2, Integer num, boolean z, Integer num2, String str3, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        if ((i & 16) != 0) {
            num2 = null;
        }
        if ((i & 32) != 0) {
            str3 = null;
        }
        return aniVortexTmdb.fetchMetadata(str, str2, num, z, num2, str3, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0177  */
    /* JADX WARN: Code duplicated, block: B:40:0x01a6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:41:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:44:0x01b5 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:52:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:54:0x0204  */
    /* JADX WARN: Code duplicated, block: B:58:0x020e  */
    /* JADX WARN: Code duplicated, block: B:60:0x0212  */
    /* JADX WARN: Code duplicated, block: B:62:0x0255 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:65:0x0265  */
    /* JADX WARN: Code duplicated, block: B:67:0x026e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:68:0x026f  */
    /* JADX WARN: Code duplicated, block: B:70:0x02ae A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:71:0x02af  */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    @Nullable
    public final Object fetchMetadata(@NotNull String title, @Nullable String originalTitle, @Nullable Integer year, boolean isMovie, @Nullable Integer explicitTmdbId, @Nullable String explicitImdbId, @NotNull Continuation<? super TmdbMetadata> continuation) {
        C00211 c00211;
        String tmdbType;
        String originalTitle2;
        Integer year2;
        String title2;
        Integer resolvedTmdbId;
        String explicitImdbId2;
        Integer explicitTmdbId2;
        Object obj;
        Integer resolvedTmdbId2;
        String originalTitle3;
        Integer explicitTmdbId3;
        String explicitImdbId3;
        String cleanOrig;
        String cleanTitle;
        Object objSearchTmdbId;
        Integer explicitTmdbId4;
        String cleanTitle2;
        String originalTitle4;
        String tmdbType2;
        Integer year3;
        Integer resolvedTmdbId3;
        String title3;
        String tmdbType3;
        Integer explicitTmdbId5;
        String originalTitle5;
        String title4;
        Object objSearchTmdbId2;
        String title5;
        String str;
        boolean z;
        Object objSearchTmdbId3;
        Object objFetchDetails;
        boolean isMovie2 = isMovie;
        if (continuation instanceof C00211) {
            c00211 = (C00211) continuation;
            if ((c00211.label & Integer.MIN_VALUE) != 0) {
                c00211.label -= Integer.MIN_VALUE;
            } else {
                c00211 = new C00211(continuation);
            }
        } else {
            c00211 = new C00211(continuation);
        }
        Object $result = c00211.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String originalTitle6 = null;
        switch (c00211.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String tmdbType4 = isMovie2 ? "movie" : "tv";
                if (explicitTmdbId == null) {
                    String str2 = explicitImdbId;
                    if (!(str2 == null || StringsKt.isBlank(str2))) {
                        tmdbType = title;
                        c00211.L$0 = tmdbType;
                        originalTitle2 = originalTitle;
                        c00211.L$1 = originalTitle2;
                        year2 = year;
                        c00211.L$2 = year2;
                        c00211.L$3 = SpillingKt.nullOutSpilledVariable(explicitTmdbId);
                        c00211.L$4 = SpillingKt.nullOutSpilledVariable(explicitImdbId);
                        c00211.L$5 = tmdbType4;
                        c00211.L$6 = SpillingKt.nullOutSpilledVariable(explicitTmdbId);
                        c00211.Z$0 = isMovie2;
                        c00211.label = 1;
                        Object objFindTmdbIdByImdb = findTmdbIdByImdb(explicitImdbId, isMovie2, c00211);
                        if (objFindTmdbIdByImdb == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = objFindTmdbIdByImdb;
                        title2 = tmdbType4;
                        explicitImdbId2 = explicitImdbId;
                        explicitTmdbId2 = explicitTmdbId;
                        resolvedTmdbId = (Integer) obj;
                    }
                    if (resolvedTmdbId == null) {
                        cleanTitle = cleanSearchTitle(tmdbType);
                        c00211.L$0 = SpillingKt.nullOutSpilledVariable(tmdbType);
                        c00211.L$1 = originalTitle2;
                        c00211.L$2 = year2;
                        c00211.L$3 = SpillingKt.nullOutSpilledVariable(explicitTmdbId2);
                        c00211.L$4 = SpillingKt.nullOutSpilledVariable(explicitImdbId2);
                        c00211.L$5 = title2;
                        c00211.L$6 = SpillingKt.nullOutSpilledVariable(resolvedTmdbId);
                        c00211.L$7 = cleanTitle;
                        c00211.Z$0 = isMovie2;
                        c00211.label = 2;
                        objSearchTmdbId = searchTmdbId(cleanTitle, year2, title2, c00211);
                        if (objSearchTmdbId == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Integer num = year2;
                        explicitTmdbId4 = explicitTmdbId2;
                        explicitImdbId3 = explicitImdbId2;
                        cleanTitle2 = cleanTitle;
                        originalTitle4 = originalTitle2;
                        tmdbType2 = title2;
                        year3 = num;
                        resolvedTmdbId3 = (Integer) objSearchTmdbId;
                        if (resolvedTmdbId3 == null || year3 == null) {
                            String str3 = originalTitle4;
                            title3 = tmdbType;
                            tmdbType3 = tmdbType2;
                            explicitTmdbId5 = explicitTmdbId4;
                            year2 = year3;
                            originalTitle5 = str3;
                            resolvedTmdbId2 = resolvedTmdbId3;
                            title4 = cleanTitle2;
                        } else {
                            c00211.L$0 = SpillingKt.nullOutSpilledVariable(tmdbType);
                            c00211.L$1 = originalTitle4;
                            c00211.L$2 = year3;
                            c00211.L$3 = SpillingKt.nullOutSpilledVariable(explicitTmdbId4);
                            c00211.L$4 = SpillingKt.nullOutSpilledVariable(explicitImdbId3);
                            c00211.L$5 = tmdbType2;
                            c00211.L$6 = SpillingKt.nullOutSpilledVariable(resolvedTmdbId3);
                            c00211.L$7 = SpillingKt.nullOutSpilledVariable(cleanTitle2);
                            c00211.Z$0 = isMovie2;
                            c00211.label = 3;
                            objSearchTmdbId2 = searchTmdbId(cleanTitle2, null, tmdbType2, c00211);
                            if (objSearchTmdbId2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            title5 = tmdbType;
                            resolvedTmdbId2 = (Integer) objSearchTmdbId2;
                            tmdbType3 = tmdbType2;
                            explicitTmdbId5 = explicitTmdbId4;
                            year2 = year3;
                            originalTitle5 = originalTitle4;
                            title3 = title5;
                            title4 = cleanTitle2;
                        }
                        if (resolvedTmdbId2 == null) {
                            str = originalTitle5;
                            if (str != null || StringsKt.isBlank(str)) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (!z) {
                                String cleanOrig2 = cleanSearchTitle(originalTitle5);
                                c00211.L$0 = SpillingKt.nullOutSpilledVariable(title3);
                                c00211.L$1 = SpillingKt.nullOutSpilledVariable(originalTitle5);
                                c00211.L$2 = SpillingKt.nullOutSpilledVariable(year2);
                                c00211.L$3 = SpillingKt.nullOutSpilledVariable(explicitTmdbId5);
                                c00211.L$4 = SpillingKt.nullOutSpilledVariable(explicitImdbId3);
                                c00211.L$5 = tmdbType3;
                                c00211.L$6 = SpillingKt.nullOutSpilledVariable(resolvedTmdbId2);
                                c00211.L$7 = SpillingKt.nullOutSpilledVariable(title4);
                                c00211.L$8 = SpillingKt.nullOutSpilledVariable(cleanOrig2);
                                c00211.Z$0 = isMovie2;
                                c00211.label = 4;
                                objSearchTmdbId3 = searchTmdbId(cleanOrig2, year2, tmdbType3, c00211);
                                if (objSearchTmdbId3 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                resolvedTmdbId2 = (Integer) objSearchTmdbId3;
                                cleanOrig = tmdbType3;
                                explicitTmdbId3 = explicitTmdbId5;
                                originalTitle3 = originalTitle5;
                                tmdbType = title3;
                            }
                        }
                        originalTitle6 = null;
                        cleanOrig = tmdbType3;
                        explicitTmdbId3 = explicitTmdbId5;
                        originalTitle3 = originalTitle5;
                        tmdbType = title3;
                    } else {
                        originalTitle6 = null;
                        resolvedTmdbId2 = resolvedTmdbId;
                        originalTitle3 = originalTitle2;
                        explicitTmdbId3 = explicitTmdbId2;
                        explicitImdbId3 = explicitImdbId2;
                        cleanOrig = title2;
                    }
                    if (resolvedTmdbId2 == null) {
                        return originalTitle6;
                    }
                    int iIntValue = resolvedTmdbId2.intValue();
                    c00211.L$0 = SpillingKt.nullOutSpilledVariable(tmdbType);
                    c00211.L$1 = SpillingKt.nullOutSpilledVariable(originalTitle3);
                    c00211.L$2 = SpillingKt.nullOutSpilledVariable(year2);
                    c00211.L$3 = SpillingKt.nullOutSpilledVariable(explicitTmdbId3);
                    c00211.L$4 = SpillingKt.nullOutSpilledVariable(explicitImdbId3);
                    c00211.L$5 = SpillingKt.nullOutSpilledVariable(cleanOrig);
                    c00211.L$6 = SpillingKt.nullOutSpilledVariable(resolvedTmdbId2);
                    String str4 = originalTitle6;
                    c00211.L$7 = str4;
                    c00211.L$8 = str4;
                    c00211.Z$0 = isMovie2;
                    c00211.label = 5;
                    objFetchDetails = fetchDetails(iIntValue, cleanOrig, c00211);
                    if (objFetchDetails == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return objFetchDetails;
                }
                tmdbType = title;
                originalTitle2 = originalTitle;
                year2 = year;
                title2 = tmdbType4;
                resolvedTmdbId = explicitTmdbId;
                explicitImdbId2 = explicitImdbId;
                explicitTmdbId2 = explicitTmdbId;
                if (resolvedTmdbId == null) {
                    cleanTitle = cleanSearchTitle(tmdbType);
                    c00211.L$0 = SpillingKt.nullOutSpilledVariable(tmdbType);
                    c00211.L$1 = originalTitle2;
                    c00211.L$2 = year2;
                    c00211.L$3 = SpillingKt.nullOutSpilledVariable(explicitTmdbId2);
                    c00211.L$4 = SpillingKt.nullOutSpilledVariable(explicitImdbId2);
                    c00211.L$5 = title2;
                    c00211.L$6 = SpillingKt.nullOutSpilledVariable(resolvedTmdbId);
                    c00211.L$7 = cleanTitle;
                    c00211.Z$0 = isMovie2;
                    c00211.label = 2;
                    objSearchTmdbId = searchTmdbId(cleanTitle, year2, title2, c00211);
                    if (objSearchTmdbId == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Integer num2 = year2;
                    explicitTmdbId4 = explicitTmdbId2;
                    explicitImdbId3 = explicitImdbId2;
                    cleanTitle2 = cleanTitle;
                    originalTitle4 = originalTitle2;
                    tmdbType2 = title2;
                    year3 = num2;
                    resolvedTmdbId3 = (Integer) objSearchTmdbId;
                    if (resolvedTmdbId3 == null) {
                    }
                    String str5 = originalTitle4;
                    title3 = tmdbType;
                    tmdbType3 = tmdbType2;
                    explicitTmdbId5 = explicitTmdbId4;
                    year2 = year3;
                    originalTitle5 = str5;
                    resolvedTmdbId2 = resolvedTmdbId3;
                    title4 = cleanTitle2;
                    if (resolvedTmdbId2 == null) {
                        str = originalTitle5;
                        if (str != null) {
                            z = true;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            String cleanOrig3 = cleanSearchTitle(originalTitle5);
                            c00211.L$0 = SpillingKt.nullOutSpilledVariable(title3);
                            c00211.L$1 = SpillingKt.nullOutSpilledVariable(originalTitle5);
                            c00211.L$2 = SpillingKt.nullOutSpilledVariable(year2);
                            c00211.L$3 = SpillingKt.nullOutSpilledVariable(explicitTmdbId5);
                            c00211.L$4 = SpillingKt.nullOutSpilledVariable(explicitImdbId3);
                            c00211.L$5 = tmdbType3;
                            c00211.L$6 = SpillingKt.nullOutSpilledVariable(resolvedTmdbId2);
                            c00211.L$7 = SpillingKt.nullOutSpilledVariable(title4);
                            c00211.L$8 = SpillingKt.nullOutSpilledVariable(cleanOrig3);
                            c00211.Z$0 = isMovie2;
                            c00211.label = 4;
                            objSearchTmdbId3 = searchTmdbId(cleanOrig3, year2, tmdbType3, c00211);
                            if (objSearchTmdbId3 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            resolvedTmdbId2 = (Integer) objSearchTmdbId3;
                            cleanOrig = tmdbType3;
                            explicitTmdbId3 = explicitTmdbId5;
                            originalTitle3 = originalTitle5;
                            tmdbType = title3;
                        }
                    }
                    originalTitle6 = null;
                    cleanOrig = tmdbType3;
                    explicitTmdbId3 = explicitTmdbId5;
                    originalTitle3 = originalTitle5;
                    tmdbType = title3;
                } else {
                    originalTitle6 = null;
                    resolvedTmdbId2 = resolvedTmdbId;
                    originalTitle3 = originalTitle2;
                    explicitTmdbId3 = explicitTmdbId2;
                    explicitImdbId3 = explicitImdbId2;
                    cleanOrig = title2;
                }
                if (resolvedTmdbId2 == null) {
                    return originalTitle6;
                }
                int iIntValue2 = resolvedTmdbId2.intValue();
                c00211.L$0 = SpillingKt.nullOutSpilledVariable(tmdbType);
                c00211.L$1 = SpillingKt.nullOutSpilledVariable(originalTitle3);
                c00211.L$2 = SpillingKt.nullOutSpilledVariable(year2);
                c00211.L$3 = SpillingKt.nullOutSpilledVariable(explicitTmdbId3);
                c00211.L$4 = SpillingKt.nullOutSpilledVariable(explicitImdbId3);
                c00211.L$5 = SpillingKt.nullOutSpilledVariable(cleanOrig);
                c00211.L$6 = SpillingKt.nullOutSpilledVariable(resolvedTmdbId2);
                String str6 = originalTitle6;
                c00211.L$7 = str6;
                c00211.L$8 = str6;
                c00211.Z$0 = isMovie2;
                c00211.label = 5;
                objFetchDetails = fetchDetails(iIntValue2, cleanOrig, c00211);
                if (objFetchDetails == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return objFetchDetails;
            case 1:
                isMovie2 = c00211.Z$0;
                String tmdbType5 = (String) c00211.L$5;
                String explicitImdbId4 = (String) c00211.L$4;
                Integer explicitTmdbId6 = (Integer) c00211.L$3;
                Integer year4 = (Integer) c00211.L$2;
                String originalTitle7 = (String) c00211.L$1;
                String title6 = (String) c00211.L$0;
                ResultKt.throwOnFailure($result);
                explicitImdbId2 = explicitImdbId4;
                explicitTmdbId2 = explicitTmdbId6;
                tmdbType = title6;
                title2 = tmdbType5;
                year2 = year4;
                originalTitle2 = originalTitle7;
                obj = $result;
                resolvedTmdbId = (Integer) obj;
                if (resolvedTmdbId == null) {
                    cleanTitle = cleanSearchTitle(tmdbType);
                    c00211.L$0 = SpillingKt.nullOutSpilledVariable(tmdbType);
                    c00211.L$1 = originalTitle2;
                    c00211.L$2 = year2;
                    c00211.L$3 = SpillingKt.nullOutSpilledVariable(explicitTmdbId2);
                    c00211.L$4 = SpillingKt.nullOutSpilledVariable(explicitImdbId2);
                    c00211.L$5 = title2;
                    c00211.L$6 = SpillingKt.nullOutSpilledVariable(resolvedTmdbId);
                    c00211.L$7 = cleanTitle;
                    c00211.Z$0 = isMovie2;
                    c00211.label = 2;
                    objSearchTmdbId = searchTmdbId(cleanTitle, year2, title2, c00211);
                    if (objSearchTmdbId == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Integer num3 = year2;
                    explicitTmdbId4 = explicitTmdbId2;
                    explicitImdbId3 = explicitImdbId2;
                    cleanTitle2 = cleanTitle;
                    originalTitle4 = originalTitle2;
                    tmdbType2 = title2;
                    year3 = num3;
                    resolvedTmdbId3 = (Integer) objSearchTmdbId;
                    if (resolvedTmdbId3 == null) {
                    }
                    String str7 = originalTitle4;
                    title3 = tmdbType;
                    tmdbType3 = tmdbType2;
                    explicitTmdbId5 = explicitTmdbId4;
                    year2 = year3;
                    originalTitle5 = str7;
                    resolvedTmdbId2 = resolvedTmdbId3;
                    title4 = cleanTitle2;
                    if (resolvedTmdbId2 == null) {
                        str = originalTitle5;
                        if (str != null) {
                            z = true;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            String cleanOrig4 = cleanSearchTitle(originalTitle5);
                            c00211.L$0 = SpillingKt.nullOutSpilledVariable(title3);
                            c00211.L$1 = SpillingKt.nullOutSpilledVariable(originalTitle5);
                            c00211.L$2 = SpillingKt.nullOutSpilledVariable(year2);
                            c00211.L$3 = SpillingKt.nullOutSpilledVariable(explicitTmdbId5);
                            c00211.L$4 = SpillingKt.nullOutSpilledVariable(explicitImdbId3);
                            c00211.L$5 = tmdbType3;
                            c00211.L$6 = SpillingKt.nullOutSpilledVariable(resolvedTmdbId2);
                            c00211.L$7 = SpillingKt.nullOutSpilledVariable(title4);
                            c00211.L$8 = SpillingKt.nullOutSpilledVariable(cleanOrig4);
                            c00211.Z$0 = isMovie2;
                            c00211.label = 4;
                            objSearchTmdbId3 = searchTmdbId(cleanOrig4, year2, tmdbType3, c00211);
                            if (objSearchTmdbId3 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            resolvedTmdbId2 = (Integer) objSearchTmdbId3;
                            cleanOrig = tmdbType3;
                            explicitTmdbId3 = explicitTmdbId5;
                            originalTitle3 = originalTitle5;
                            tmdbType = title3;
                        }
                    }
                    originalTitle6 = null;
                    cleanOrig = tmdbType3;
                    explicitTmdbId3 = explicitTmdbId5;
                    originalTitle3 = originalTitle5;
                    tmdbType = title3;
                } else {
                    originalTitle6 = null;
                    resolvedTmdbId2 = resolvedTmdbId;
                    originalTitle3 = originalTitle2;
                    explicitTmdbId3 = explicitTmdbId2;
                    explicitImdbId3 = explicitImdbId2;
                    cleanOrig = title2;
                }
                if (resolvedTmdbId2 == null) {
                    return originalTitle6;
                }
                int iIntValue3 = resolvedTmdbId2.intValue();
                c00211.L$0 = SpillingKt.nullOutSpilledVariable(tmdbType);
                c00211.L$1 = SpillingKt.nullOutSpilledVariable(originalTitle3);
                c00211.L$2 = SpillingKt.nullOutSpilledVariable(year2);
                c00211.L$3 = SpillingKt.nullOutSpilledVariable(explicitTmdbId3);
                c00211.L$4 = SpillingKt.nullOutSpilledVariable(explicitImdbId3);
                c00211.L$5 = SpillingKt.nullOutSpilledVariable(cleanOrig);
                c00211.L$6 = SpillingKt.nullOutSpilledVariable(resolvedTmdbId2);
                String str8 = originalTitle6;
                c00211.L$7 = str8;
                c00211.L$8 = str8;
                c00211.Z$0 = isMovie2;
                c00211.label = 5;
                objFetchDetails = fetchDetails(iIntValue3, cleanOrig, c00211);
                if (objFetchDetails == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return objFetchDetails;
            case 2:
                isMovie2 = c00211.Z$0;
                cleanTitle2 = (String) c00211.L$7;
                String tmdbType6 = (String) c00211.L$5;
                explicitImdbId3 = (String) c00211.L$4;
                Integer explicitTmdbId7 = (Integer) c00211.L$3;
                Integer year5 = (Integer) c00211.L$2;
                String originalTitle8 = (String) c00211.L$1;
                String title7 = (String) c00211.L$0;
                ResultKt.throwOnFailure($result);
                tmdbType2 = tmdbType6;
                tmdbType = title7;
                originalTitle4 = originalTitle8;
                year3 = year5;
                explicitTmdbId4 = explicitTmdbId7;
                objSearchTmdbId = $result;
                resolvedTmdbId3 = (Integer) objSearchTmdbId;
                if (resolvedTmdbId3 == null) {
                }
                String str9 = originalTitle4;
                title3 = tmdbType;
                tmdbType3 = tmdbType2;
                explicitTmdbId5 = explicitTmdbId4;
                year2 = year3;
                originalTitle5 = str9;
                resolvedTmdbId2 = resolvedTmdbId3;
                title4 = cleanTitle2;
                if (resolvedTmdbId2 == null) {
                    str = originalTitle5;
                    if (str != null) {
                        z = true;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        String cleanOrig5 = cleanSearchTitle(originalTitle5);
                        c00211.L$0 = SpillingKt.nullOutSpilledVariable(title3);
                        c00211.L$1 = SpillingKt.nullOutSpilledVariable(originalTitle5);
                        c00211.L$2 = SpillingKt.nullOutSpilledVariable(year2);
                        c00211.L$3 = SpillingKt.nullOutSpilledVariable(explicitTmdbId5);
                        c00211.L$4 = SpillingKt.nullOutSpilledVariable(explicitImdbId3);
                        c00211.L$5 = tmdbType3;
                        c00211.L$6 = SpillingKt.nullOutSpilledVariable(resolvedTmdbId2);
                        c00211.L$7 = SpillingKt.nullOutSpilledVariable(title4);
                        c00211.L$8 = SpillingKt.nullOutSpilledVariable(cleanOrig5);
                        c00211.Z$0 = isMovie2;
                        c00211.label = 4;
                        objSearchTmdbId3 = searchTmdbId(cleanOrig5, year2, tmdbType3, c00211);
                        if (objSearchTmdbId3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        resolvedTmdbId2 = (Integer) objSearchTmdbId3;
                        cleanOrig = tmdbType3;
                        explicitTmdbId3 = explicitTmdbId5;
                        originalTitle3 = originalTitle5;
                        tmdbType = title3;
                    }
                    if (resolvedTmdbId2 == null) {
                        return originalTitle6;
                    }
                    int iIntValue4 = resolvedTmdbId2.intValue();
                    c00211.L$0 = SpillingKt.nullOutSpilledVariable(tmdbType);
                    c00211.L$1 = SpillingKt.nullOutSpilledVariable(originalTitle3);
                    c00211.L$2 = SpillingKt.nullOutSpilledVariable(year2);
                    c00211.L$3 = SpillingKt.nullOutSpilledVariable(explicitTmdbId3);
                    c00211.L$4 = SpillingKt.nullOutSpilledVariable(explicitImdbId3);
                    c00211.L$5 = SpillingKt.nullOutSpilledVariable(cleanOrig);
                    c00211.L$6 = SpillingKt.nullOutSpilledVariable(resolvedTmdbId2);
                    String str10 = originalTitle6;
                    c00211.L$7 = str10;
                    c00211.L$8 = str10;
                    c00211.Z$0 = isMovie2;
                    c00211.label = 5;
                    objFetchDetails = fetchDetails(iIntValue4, cleanOrig, c00211);
                    if (objFetchDetails == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return objFetchDetails;
                }
                originalTitle6 = null;
                cleanOrig = tmdbType3;
                explicitTmdbId3 = explicitTmdbId5;
                originalTitle3 = originalTitle5;
                tmdbType = title3;
                if (resolvedTmdbId2 == null) {
                    return originalTitle6;
                }
                int iIntValue5 = resolvedTmdbId2.intValue();
                c00211.L$0 = SpillingKt.nullOutSpilledVariable(tmdbType);
                c00211.L$1 = SpillingKt.nullOutSpilledVariable(originalTitle3);
                c00211.L$2 = SpillingKt.nullOutSpilledVariable(year2);
                c00211.L$3 = SpillingKt.nullOutSpilledVariable(explicitTmdbId3);
                c00211.L$4 = SpillingKt.nullOutSpilledVariable(explicitImdbId3);
                c00211.L$5 = SpillingKt.nullOutSpilledVariable(cleanOrig);
                c00211.L$6 = SpillingKt.nullOutSpilledVariable(resolvedTmdbId2);
                String str11 = originalTitle6;
                c00211.L$7 = str11;
                c00211.L$8 = str11;
                c00211.Z$0 = isMovie2;
                c00211.label = 5;
                objFetchDetails = fetchDetails(iIntValue5, cleanOrig, c00211);
                if (objFetchDetails == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return objFetchDetails;
            case 3:
                isMovie2 = c00211.Z$0;
                cleanTitle2 = (String) c00211.L$7;
                tmdbType2 = (String) c00211.L$5;
                explicitImdbId3 = (String) c00211.L$4;
                explicitTmdbId4 = (Integer) c00211.L$3;
                year3 = (Integer) c00211.L$2;
                originalTitle4 = (String) c00211.L$1;
                title5 = (String) c00211.L$0;
                ResultKt.throwOnFailure($result);
                objSearchTmdbId2 = $result;
                resolvedTmdbId2 = (Integer) objSearchTmdbId2;
                tmdbType3 = tmdbType2;
                explicitTmdbId5 = explicitTmdbId4;
                year2 = year3;
                originalTitle5 = originalTitle4;
                title3 = title5;
                title4 = cleanTitle2;
                if (resolvedTmdbId2 == null) {
                    str = originalTitle5;
                    if (str != null) {
                        z = true;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        String cleanOrig6 = cleanSearchTitle(originalTitle5);
                        c00211.L$0 = SpillingKt.nullOutSpilledVariable(title3);
                        c00211.L$1 = SpillingKt.nullOutSpilledVariable(originalTitle5);
                        c00211.L$2 = SpillingKt.nullOutSpilledVariable(year2);
                        c00211.L$3 = SpillingKt.nullOutSpilledVariable(explicitTmdbId5);
                        c00211.L$4 = SpillingKt.nullOutSpilledVariable(explicitImdbId3);
                        c00211.L$5 = tmdbType3;
                        c00211.L$6 = SpillingKt.nullOutSpilledVariable(resolvedTmdbId2);
                        c00211.L$7 = SpillingKt.nullOutSpilledVariable(title4);
                        c00211.L$8 = SpillingKt.nullOutSpilledVariable(cleanOrig6);
                        c00211.Z$0 = isMovie2;
                        c00211.label = 4;
                        objSearchTmdbId3 = searchTmdbId(cleanOrig6, year2, tmdbType3, c00211);
                        if (objSearchTmdbId3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        resolvedTmdbId2 = (Integer) objSearchTmdbId3;
                        cleanOrig = tmdbType3;
                        explicitTmdbId3 = explicitTmdbId5;
                        originalTitle3 = originalTitle5;
                        tmdbType = title3;
                    }
                    if (resolvedTmdbId2 == null) {
                        return originalTitle6;
                    }
                    int iIntValue6 = resolvedTmdbId2.intValue();
                    c00211.L$0 = SpillingKt.nullOutSpilledVariable(tmdbType);
                    c00211.L$1 = SpillingKt.nullOutSpilledVariable(originalTitle3);
                    c00211.L$2 = SpillingKt.nullOutSpilledVariable(year2);
                    c00211.L$3 = SpillingKt.nullOutSpilledVariable(explicitTmdbId3);
                    c00211.L$4 = SpillingKt.nullOutSpilledVariable(explicitImdbId3);
                    c00211.L$5 = SpillingKt.nullOutSpilledVariable(cleanOrig);
                    c00211.L$6 = SpillingKt.nullOutSpilledVariable(resolvedTmdbId2);
                    String str12 = originalTitle6;
                    c00211.L$7 = str12;
                    c00211.L$8 = str12;
                    c00211.Z$0 = isMovie2;
                    c00211.label = 5;
                    objFetchDetails = fetchDetails(iIntValue6, cleanOrig, c00211);
                    if (objFetchDetails == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return objFetchDetails;
                }
                originalTitle6 = null;
                cleanOrig = tmdbType3;
                explicitTmdbId3 = explicitTmdbId5;
                originalTitle3 = originalTitle5;
                tmdbType = title3;
                if (resolvedTmdbId2 == null) {
                    return originalTitle6;
                }
                int iIntValue7 = resolvedTmdbId2.intValue();
                c00211.L$0 = SpillingKt.nullOutSpilledVariable(tmdbType);
                c00211.L$1 = SpillingKt.nullOutSpilledVariable(originalTitle3);
                c00211.L$2 = SpillingKt.nullOutSpilledVariable(year2);
                c00211.L$3 = SpillingKt.nullOutSpilledVariable(explicitTmdbId3);
                c00211.L$4 = SpillingKt.nullOutSpilledVariable(explicitImdbId3);
                c00211.L$5 = SpillingKt.nullOutSpilledVariable(cleanOrig);
                c00211.L$6 = SpillingKt.nullOutSpilledVariable(resolvedTmdbId2);
                String str13 = originalTitle6;
                c00211.L$7 = str13;
                c00211.L$8 = str13;
                c00211.Z$0 = isMovie2;
                c00211.label = 5;
                objFetchDetails = fetchDetails(iIntValue7, cleanOrig, c00211);
                if (objFetchDetails == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return objFetchDetails;
            case 4:
                isMovie2 = c00211.Z$0;
                tmdbType3 = (String) c00211.L$5;
                explicitImdbId3 = (String) c00211.L$4;
                explicitTmdbId5 = (Integer) c00211.L$3;
                year2 = (Integer) c00211.L$2;
                originalTitle5 = (String) c00211.L$1;
                title3 = (String) c00211.L$0;
                ResultKt.throwOnFailure($result);
                objSearchTmdbId3 = $result;
                resolvedTmdbId2 = (Integer) objSearchTmdbId3;
                cleanOrig = tmdbType3;
                explicitTmdbId3 = explicitTmdbId5;
                originalTitle3 = originalTitle5;
                tmdbType = title3;
                if (resolvedTmdbId2 == null) {
                    return originalTitle6;
                }
                int iIntValue8 = resolvedTmdbId2.intValue();
                c00211.L$0 = SpillingKt.nullOutSpilledVariable(tmdbType);
                c00211.L$1 = SpillingKt.nullOutSpilledVariable(originalTitle3);
                c00211.L$2 = SpillingKt.nullOutSpilledVariable(year2);
                c00211.L$3 = SpillingKt.nullOutSpilledVariable(explicitTmdbId3);
                c00211.L$4 = SpillingKt.nullOutSpilledVariable(explicitImdbId3);
                c00211.L$5 = SpillingKt.nullOutSpilledVariable(cleanOrig);
                c00211.L$6 = SpillingKt.nullOutSpilledVariable(resolvedTmdbId2);
                String str14 = originalTitle6;
                c00211.L$7 = str14;
                c00211.L$8 = str14;
                c00211.Z$0 = isMovie2;
                c00211.label = 5;
                objFetchDetails = fetchDetails(iIntValue8, cleanOrig, c00211);
                if (objFetchDetails == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return objFetchDetails;
            case 5:
                boolean z2 = c00211.Z$0;
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:45:0x016c  */
    /* JADX WARN: Code duplicated, block: B:48:0x0172 A[ADDED_TO_REGION, RETURN] */
    /* JADX WARN: Code duplicated, block: B:49:0x0173  */
    /* JADX WARN: Code duplicated, block: B:57:0x018f  */
    /* JADX WARN: Code duplicated, block: B:59:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:61:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:71:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:72:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    public final Object searchTmdbId(String query, Integer year, String type, Continuation<? super Integer> continuation) {
        C00231 c00231;
        String yearParam;
        StringBuilder sb;
        String str;
        Object obj;
        String res;
        JSONArray results;
        JSONObject jSONObjectOptJSONObject;
        Integer numBoxInt;
        int it;
        if (continuation instanceof C00231) {
            c00231 = (C00231) continuation;
            if ((c00231.label & Integer.MIN_VALUE) != 0) {
                c00231.label -= Integer.MIN_VALUE;
            } else {
                c00231 = new C00231(continuation);
            }
        } else {
            c00231 = new C00231(continuation);
        }
        C00231 c00232 = c00231;
        Object $result = c00232.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00232.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (StringsKt.isBlank(query)) {
                    return null;
                }
                if (year != null) {
                    if (Intrinsics.areEqual(type, "movie")) {
                        sb = new StringBuilder();
                        str = "&year=";
                    } else {
                        sb = new StringBuilder();
                        str = "&first_air_date_year=";
                    }
                    yearParam = sb.append(str).append(year.intValue()).toString();
                } else {
                    yearParam = "";
                }
                String url = "https://api.themoviedb.org/3/search/" + type + "?api_key=1865f43a0549ca50d341dd9ab8b29f49&query=" + query + yearParam + "&include_adult=false";
                try {
                    Result.Companion companion = Result.Companion;
                    AniVortexTmdb $this$searchTmdbId_u24lambda_u240 = this;
                    Requests app = MainActivityKt.getApp();
                    c00232.L$0 = SpillingKt.nullOutSpilledVariable(query);
                    c00232.L$1 = SpillingKt.nullOutSpilledVariable(year);
                    c00232.L$2 = SpillingKt.nullOutSpilledVariable(type);
                    c00232.L$3 = SpillingKt.nullOutSpilledVariable(yearParam);
                    c00232.L$4 = SpillingKt.nullOutSpilledVariable(url);
                    c00232.L$5 = SpillingKt.nullOutSpilledVariable($this$searchTmdbId_u24lambda_u240);
                    c00232.label = 1;
                    try {
                        Object obj2 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00232, 4094, (Object) null);
                        if (obj2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result = obj2;
                        try {
                            obj = Result.constructor-impl(((NiceResponse) $result).getText());
                            break;
                        } catch (Throwable th) {
                            th = th;
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        if (Result.isFailure-impl(obj)) {
                            obj = null;
                        }
                        res = (String) obj;
                        if (res != null || (results = new JSONObject(res).optJSONArray("results")) == null || results.length() == 0) {
                            return null;
                        }
                        jSONObjectOptJSONObject = results.optJSONObject(0);
                        if (jSONObjectOptJSONObject != null) {
                            return null;
                        }
                        numBoxInt = Boxing.boxInt(jSONObjectOptJSONObject.optInt("id"));
                        it = numBoxInt.intValue();
                        if (it > 0) {
                            return numBoxInt;
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        Result.Companion companion3 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                        if (Result.isFailure-impl(obj)) {
                            obj = null;
                        }
                        res = (String) obj;
                        if (res != null) {
                            return null;
                        }
                        jSONObjectOptJSONObject = results.optJSONObject(0);
                        if (jSONObjectOptJSONObject != null) {
                            return null;
                        }
                        numBoxInt = Boxing.boxInt(jSONObjectOptJSONObject.optInt("id"));
                        it = numBoxInt.intValue();
                        if (it > 0) {
                            return numBoxInt;
                        }
                        return null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
                break;
            case 1:
                try {
                    ResultKt.throwOnFailure($result);
                    obj = Result.constructor-impl(((NiceResponse) $result).getText());
                    break;
                } catch (Throwable th4) {
                    th = th4;
                    Result.Companion companion4 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                    if (Result.isFailure-impl(obj)) {
                        obj = null;
                    }
                    res = (String) obj;
                    if (res != null) {
                        return null;
                    }
                    jSONObjectOptJSONObject = results.optJSONObject(0);
                    if (jSONObjectOptJSONObject != null) {
                        return null;
                    }
                    numBoxInt = Boxing.boxInt(jSONObjectOptJSONObject.optInt("id"));
                    it = numBoxInt.intValue();
                    if (it > 0) {
                        return numBoxInt;
                    }
                    return null;
                }
                if (Result.isFailure-impl(obj)) {
                    obj = null;
                }
                res = (String) obj;
                if (res != null) {
                    return null;
                }
                jSONObjectOptJSONObject = results.optJSONObject(0);
                if (jSONObjectOptJSONObject != null) {
                    return null;
                }
                numBoxInt = Boxing.boxInt(jSONObjectOptJSONObject.optInt("id"));
                it = numBoxInt.intValue();
                if (it > 0) {
                    return numBoxInt;
                }
                return null;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:35:0x0102  */
    /* JADX WARN: Code duplicated, block: B:38:0x0107 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:39:0x0108  */
    /* JADX WARN: Code duplicated, block: B:41:0x010f  */
    /* JADX WARN: Code duplicated, block: B:42:0x0112  */
    /* JADX WARN: Code duplicated, block: B:45:0x011a  */
    /* JADX WARN: Code duplicated, block: B:62:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object findTmdbIdByImdb(String imdbId, boolean isMovie, Continuation<? super Integer> continuation) {
        C00221 c00221;
        boolean z;
        boolean isMovie2;
        Object obj;
        String res;
        String key;
        JSONArray jSONArrayOptJSONArray;
        JSONObject jSONObjectOptJSONObject;
        if (continuation instanceof C00221) {
            c00221 = (C00221) continuation;
            if ((c00221.label & Integer.MIN_VALUE) != 0) {
                c00221.label -= Integer.MIN_VALUE;
            } else {
                c00221 = new C00221(continuation);
            }
        } else {
            c00221 = new C00221(continuation);
        }
        C00221 c00222 = c00221;
        Object $result = c00222.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00222.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String url = "https://api.themoviedb.org/3/find/" + imdbId + "?api_key=1865f43a0549ca50d341dd9ab8b29f49&external_source=imdb_id";
                try {
                    Result.Companion companion = Result.Companion;
                    AniVortexTmdb $this$findTmdbIdByImdb_u24lambda_u240 = this;
                    Requests app = MainActivityKt.getApp();
                    c00222.L$0 = SpillingKt.nullOutSpilledVariable(imdbId);
                    c00222.L$1 = SpillingKt.nullOutSpilledVariable(url);
                    c00222.L$2 = SpillingKt.nullOutSpilledVariable($this$findTmdbIdByImdb_u24lambda_u240);
                    c00222.Z$0 = isMovie;
                    c00222.label = 1;
                    z = true;
                    try {
                        Object obj2 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00222, 4094, (Object) null);
                        if (obj2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        isMovie2 = isMovie;
                        $result = obj2;
                        try {
                            obj = Result.constructor-impl(((NiceResponse) $result).getText());
                            break;
                        } catch (Throwable th) {
                            th = th;
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        if (Result.isFailure-impl(obj)) {
                            obj = null;
                        }
                        res = (String) obj;
                        if (res == null) {
                            return null;
                        }
                        JSONObject obj3 = new JSONObject(res);
                        if (isMovie2) {
                            key = "movie_results";
                        } else {
                            key = "tv_results";
                        }
                        jSONArrayOptJSONArray = obj3.optJSONArray(key);
                        if (jSONArrayOptJSONArray != null || (jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0)) == null) {
                            return null;
                        }
                        Integer numBoxInt = Boxing.boxInt(jSONObjectOptJSONObject.optInt("id"));
                        int it = numBoxInt.intValue();
                        if (it <= 0) {
                            z = false;
                        }
                        if (z) {
                            return numBoxInt;
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        isMovie2 = isMovie;
                        Result.Companion companion3 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                        if (Result.isFailure-impl(obj)) {
                            obj = null;
                        }
                        res = (String) obj;
                        if (res == null) {
                            return null;
                        }
                        JSONObject obj4 = new JSONObject(res);
                        if (isMovie2) {
                            key = "movie_results";
                        } else {
                            key = "tv_results";
                        }
                        jSONArrayOptJSONArray = obj4.optJSONArray(key);
                        if (jSONArrayOptJSONArray != null) {
                            return null;
                        }
                        return null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    z = true;
                    isMovie2 = isMovie;
                }
                break;
            case 1:
                isMovie2 = c00222.Z$0;
                try {
                    ResultKt.throwOnFailure($result);
                    z = true;
                    obj = Result.constructor-impl(((NiceResponse) $result).getText());
                    break;
                } catch (Throwable th4) {
                    th = th4;
                    z = true;
                    Result.Companion companion4 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                    if (Result.isFailure-impl(obj)) {
                        obj = null;
                    }
                    res = (String) obj;
                    if (res == null) {
                        return null;
                    }
                    JSONObject obj5 = new JSONObject(res);
                    if (isMovie2) {
                        key = "movie_results";
                    } else {
                        key = "tv_results";
                    }
                    jSONArrayOptJSONArray = obj5.optJSONArray(key);
                    if (jSONArrayOptJSONArray != null) {
                        return null;
                    }
                    return null;
                }
                if (Result.isFailure-impl(obj)) {
                    obj = null;
                }
                res = (String) obj;
                if (res == null) {
                    return null;
                }
                JSONObject obj6 = new JSONObject(res);
                if (isMovie2) {
                    key = "movie_results";
                } else {
                    key = "tv_results";
                }
                jSONArrayOptJSONArray = obj6.optJSONArray(key);
                if (jSONArrayOptJSONArray != null) {
                    return null;
                }
                return null;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:123:0x035c  */
    /* JADX WARN: Code duplicated, block: B:126:0x0366  */
    /* JADX WARN: Code duplicated, block: B:145:0x03ca  */
    /* JADX WARN: Code duplicated, block: B:147:0x03d1  */
    /* JADX WARN: Code duplicated, block: B:149:0x03d7  */
    /* JADX WARN: Code duplicated, block: B:150:0x03db  */
    /* JADX WARN: Code duplicated, block: B:158:0x0400  */
    /* JADX WARN: Code duplicated, block: B:159:0x0417  */
    /* JADX WARN: Code duplicated, block: B:161:0x041b  */
    /* JADX WARN: Code duplicated, block: B:174:0x0241 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:35:0x010d  */
    /* JADX WARN: Code duplicated, block: B:38:0x0112 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:39:0x0113  */
    /* JADX WARN: Code duplicated, block: B:42:0x012a  */
    /* JADX WARN: Code duplicated, block: B:44:0x012d  */
    /* JADX WARN: Code duplicated, block: B:45:0x0143  */
    /* JADX WARN: Code duplicated, block: B:49:0x0158  */
    /* JADX WARN: Code duplicated, block: B:52:0x015d  */
    /* JADX WARN: Code duplicated, block: B:53:0x0173  */
    /* JADX WARN: Code duplicated, block: B:56:0x0187  */
    /* JADX WARN: Code duplicated, block: B:61:0x019d  */
    /* JADX WARN: Code duplicated, block: B:64:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:65:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:68:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:69:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:71:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:72:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:75:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:78:0x020b  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:80:0x0225  */
    /* JADX WARN: Code duplicated, block: B:85:0x023a  */
    /* JADX WARN: Code duplicated, block: B:87:0x023d  */
    /* JADX WARN: Code duplicated, block: B:90:0x0250  */
    /* JADX WARN: Code duplicated, block: B:93:0x025c  */
    public final Object fetchDetails(int tmdbId, String type, Continuation<? super TmdbMetadata> continuation) {
        C00201 c00201;
        int tmdbId2;
        Object obj;
        String text;
        String backdropPath;
        String it;
        String posterPath;
        String posterUrl;
        JSONObject jSONObjectOptJSONObject;
        String imdbId;
        String it2;
        String overview;
        Double dBoxDouble;
        double it3;
        boolean z;
        Double rating;
        JSONArray arr;
        List genres;
        JSONObject jSONObjectOptJSONObject2;
        List actors;
        JSONObject jSONObjectOptJSONObject3;
        String trailerUrl;
        JSONArray arr2;
        String str;
        int i;
        int length;
        JSONObject vid;
        String site;
        int i2;
        int i3;
        String youtubeKey;
        JSONArray arr3;
        JSONArray arr4;
        String profileUrl;
        ActorData actorData;
        Collection destination$iv$iv;
        IntIterator it4;
        JSONObject jSONObjectOptJSONObject4;
        String n;
        String it5;
        if (continuation instanceof C00201) {
            c00201 = (C00201) continuation;
            if ((c00201.label & Integer.MIN_VALUE) != 0) {
                c00201.label -= Integer.MIN_VALUE;
            } else {
                c00201 = new C00201(continuation);
            }
        } else {
            c00201 = new C00201(continuation);
        }
        C00201 c00202 = c00201;
        Object $result = c00202.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00202.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String url = "https://api.themoviedb.org/3/" + type + '/' + tmdbId + "?api_key=1865f43a0549ca50d341dd9ab8b29f49&append_to_response=images,credits,external_ids,videos&include_image_language=en,hi,ja,null";
                try {
                    Result.Companion companion = Result.Companion;
                    AniVortexTmdb $this$fetchDetails_u24lambda_u240 = this;
                    Requests app = MainActivityKt.getApp();
                    c00202.L$0 = SpillingKt.nullOutSpilledVariable(type);
                    c00202.L$1 = SpillingKt.nullOutSpilledVariable(url);
                    c00202.L$2 = SpillingKt.nullOutSpilledVariable($this$fetchDetails_u24lambda_u240);
                    c00202.I$0 = tmdbId;
                    c00202.label = 1;
                    try {
                        Object obj2 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00202, 4094, (Object) null);
                        if (obj2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result = obj2;
                        tmdbId2 = tmdbId;
                        try {
                            obj = Result.constructor-impl(((NiceResponse) $result).getText());
                            break;
                        } catch (Throwable th) {
                            th = th;
                            Object $result2 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        if (Result.isFailure-impl(obj)) {
                            obj = null;
                        }
                        text = (String) obj;
                        if (text == null) {
                            return null;
                        }
                        JSONObject json = new JSONObject(text);
                        backdropPath = json.optString("backdrop_path");
                        if (StringsKt.isBlank(backdropPath)) {
                            backdropPath = null;
                        }
                        if (backdropPath != null) {
                            String it6 = backdropPath;
                            it = "https://image.tmdb.org/t/p/original" + it6;
                        } else {
                            it = null;
                        }
                        String backdropUrl = it;
                        posterPath = json.optString("poster_path");
                        if (StringsKt.isBlank(posterPath)) {
                            posterPath = null;
                        }
                        if (posterPath != null) {
                            String it7 = posterPath;
                            posterUrl = "https://image.tmdb.org/t/p/w500" + it7;
                        } else {
                            posterUrl = null;
                        }
                        String logoUrl = extractLogoUrl(json.optJSONObject("images"));
                        jSONObjectOptJSONObject = json.optJSONObject("external_ids");
                        if (jSONObjectOptJSONObject != null || (it5 = jSONObjectOptJSONObject.optString("imdb_id")) == null || StringsKt.isBlank(it5)) {
                            imdbId = null;
                        } else {
                            imdbId = it5;
                        }
                        it2 = json.optString("overview");
                        if (StringsKt.isBlank(it2)) {
                            overview = null;
                        } else {
                            overview = it2;
                        }
                        dBoxDouble = Boxing.boxDouble(json.optDouble("vote_average", 0.0d));
                        it3 = dBoxDouble.doubleValue();
                        if (it3 > 0.0d) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            rating = dBoxDouble;
                        } else {
                            rating = null;
                        }
                        arr = json.optJSONArray("genres");
                        if (arr != null) {
                            Iterable $this$mapNotNull$iv = RangesKt.until(0, arr.length());
                            destination$iv$iv = new ArrayList();
                            it4 = $this$mapNotNull$iv.iterator();
                            while (it4.hasNext()) {
                                int element$iv$iv$iv = it4.nextInt();
                                String text2 = text;
                                jSONObjectOptJSONObject4 = arr.optJSONObject(element$iv$iv$iv);
                                if (jSONObjectOptJSONObject4 != null || (n = jSONObjectOptJSONObject4.optString("name")) == null || StringsKt.isBlank(n)) {
                                    n = null;
                                }
                                if (n != null) {
                                    destination$iv$iv.add(n);
                                }
                                text = text2;
                            }
                            genres = (List) destination$iv$iv;
                        } else {
                            genres = null;
                        }
                        jSONObjectOptJSONObject2 = json.optJSONObject("credits");
                        if (jSONObjectOptJSONObject2 != null || (arr3 = jSONObjectOptJSONObject2.optJSONArray("cast")) == null) {
                            actors = null;
                        } else {
                            int i4 = 0;
                            Iterable $this$mapNotNull$iv2 = RangesKt.until(0, Math.min(arr3.length(), 15));
                            Collection destination$iv$iv2 = new ArrayList();
                            IntIterator it8 = $this$mapNotNull$iv2.iterator();
                            while (it8.hasNext()) {
                                int element$iv$iv$iv2 = it8.nextInt();
                                JSONObject actorObj = arr3.optJSONObject(element$iv$iv$iv2);
                                if (actorObj == null) {
                                    arr4 = arr3;
                                    i4 = i4;
                                    actorData = null;
                                } else {
                                    arr4 = arr3;
                                    String it9 = actorObj.optString("name");
                                    if (StringsKt.isBlank(it9)) {
                                        it9 = null;
                                    }
                                    if (it9 == null) {
                                        i4 = i4;
                                        actorData = null;
                                    } else {
                                        String name = it9;
                                        String profilePath = actorObj.optString("profile_path");
                                        if (StringsKt.isBlank(profilePath)) {
                                            profilePath = null;
                                        }
                                        if (profilePath != null) {
                                            String it10 = profilePath;
                                            profileUrl = "https://image.tmdb.org/t/p/w500" + it10;
                                        } else {
                                            profileUrl = null;
                                        }
                                        String it11 = actorObj.optString("character");
                                        if (StringsKt.isBlank(it11)) {
                                            it11 = null;
                                        }
                                        String character = it11;
                                        actorData = new ActorData(new Actor(name, profileUrl), (ActorRole) null, character, (Actor) null, 10, (DefaultConstructorMarker) null);
                                    }
                                }
                                if (actorData != null) {
                                    destination$iv$iv2.add(actorData);
                                }
                                arr3 = arr4;
                                i4 = i4;
                            }
                            actors = (List) destination$iv$iv2;
                        }
                        jSONObjectOptJSONObject3 = json.optJSONObject("videos");
                        if (jSONObjectOptJSONObject3 != null || (arr2 = jSONObjectOptJSONObject3.optJSONArray("results")) == null) {
                            trailerUrl = null;
                        } else {
                            int i5 = 0;
                            String youtubeKey2 = null;
                            int i6 = 0;
                            int length2 = arr2.length();
                            while (i6 < length2) {
                                JSONObject vid2 = arr2.optJSONObject(i6);
                                if (vid2 == null) {
                                    i3 = i5;
                                    youtubeKey = youtubeKey2;
                                } else {
                                    i3 = i5;
                                    String site2 = vid2.optString("site");
                                    youtubeKey = youtubeKey2;
                                    String vidType = vid2.optString("type");
                                    String key = vid2.optString("key");
                                    if (StringsKt.equals(site2, "YouTube", true) && StringsKt.equals(vidType, "Trailer", true) && !StringsKt.isBlank(key)) {
                                        youtubeKey2 = key;
                                        if (youtubeKey2 == null) {
                                            i = 0;
                                            length = arr2.length();
                                            while (i < length) {
                                                vid = arr2.optJSONObject(i);
                                                if (vid == null) {
                                                    i2 = i;
                                                } else {
                                                    site = vid.optString("site");
                                                    String key2 = vid.optString("key");
                                                    i2 = i;
                                                    if (StringsKt.equals(site, "YouTube", true) && !StringsKt.isBlank(key2)) {
                                                        youtubeKey2 = key2;
                                                    }
                                                }
                                                i = i2 + 1;
                                            }
                                        }
                                        if (youtubeKey2 != null) {
                                            String it12 = youtubeKey2;
                                            str = "https://www.youtube.com/watch?v=" + it12;
                                        } else {
                                            str = null;
                                        }
                                        trailerUrl = str;
                                    }
                                }
                                i6++;
                                i5 = i3;
                                youtubeKey2 = youtubeKey;
                            }
                            if (youtubeKey2 == null) {
                                i = 0;
                                length = arr2.length();
                                while (i < length) {
                                    vid = arr2.optJSONObject(i);
                                    if (vid == null) {
                                        i2 = i;
                                    } else {
                                        site = vid.optString("site");
                                        String key3 = vid.optString("key");
                                        i2 = i;
                                        if (StringsKt.equals(site, "YouTube", true)) {
                                            continue;
                                        }
                                    }
                                    i = i2 + 1;
                                }
                            }
                            if (youtubeKey2 != null) {
                                String it13 = youtubeKey2;
                                str = "https://www.youtube.com/watch?v=" + it13;
                            } else {
                                str = null;
                            }
                            trailerUrl = str;
                        }
                        return new TmdbMetadata(Boxing.boxInt(tmdbId2), imdbId, logoUrl, backdropUrl, posterUrl, overview, rating, genres, actors, trailerUrl);
                    } catch (Throwable th2) {
                        th = th2;
                        tmdbId2 = tmdbId;
                        Object $result3 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                        if (Result.isFailure-impl(obj)) {
                            obj = null;
                        }
                        text = (String) obj;
                        if (text == null) {
                            return null;
                        }
                        JSONObject json2 = new JSONObject(text);
                        backdropPath = json2.optString("backdrop_path");
                        if (StringsKt.isBlank(backdropPath)) {
                            backdropPath = null;
                        }
                        if (backdropPath != null) {
                            String it14 = backdropPath;
                            it = "https://image.tmdb.org/t/p/original" + it14;
                        } else {
                            it = null;
                        }
                        String backdropUrl2 = it;
                        posterPath = json2.optString("poster_path");
                        if (StringsKt.isBlank(posterPath)) {
                            posterPath = null;
                        }
                        if (posterPath != null) {
                            String it15 = posterPath;
                            posterUrl = "https://image.tmdb.org/t/p/w500" + it15;
                        } else {
                            posterUrl = null;
                        }
                        String logoUrl2 = extractLogoUrl(json2.optJSONObject("images"));
                        jSONObjectOptJSONObject = json2.optJSONObject("external_ids");
                        if (jSONObjectOptJSONObject != null) {
                            imdbId = null;
                        } else {
                            imdbId = null;
                        }
                        it2 = json2.optString("overview");
                        if (StringsKt.isBlank(it2)) {
                            overview = it2;
                        } else {
                            overview = null;
                        }
                        dBoxDouble = Boxing.boxDouble(json2.optDouble("vote_average", 0.0d));
                        it3 = dBoxDouble.doubleValue();
                        if (it3 > 0.0d) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            rating = dBoxDouble;
                        } else {
                            rating = null;
                        }
                        arr = json2.optJSONArray("genres");
                        if (arr != null) {
                            Iterable $this$mapNotNull$iv3 = RangesKt.until(0, arr.length());
                            destination$iv$iv = new ArrayList();
                            it4 = $this$mapNotNull$iv3.iterator();
                            while (it4.hasNext()) {
                                int element$iv$iv$iv3 = it4.nextInt();
                                String text3 = text;
                                jSONObjectOptJSONObject4 = arr.optJSONObject(element$iv$iv$iv3);
                                if (jSONObjectOptJSONObject4 != null) {
                                    n = null;
                                } else {
                                    n = null;
                                }
                                if (n != null) {
                                    destination$iv$iv.add(n);
                                }
                                text = text3;
                            }
                            genres = (List) destination$iv$iv;
                        } else {
                            genres = null;
                        }
                        jSONObjectOptJSONObject2 = json2.optJSONObject("credits");
                        if (jSONObjectOptJSONObject2 != null) {
                            actors = null;
                        } else {
                            actors = null;
                        }
                        jSONObjectOptJSONObject3 = json2.optJSONObject("videos");
                        if (jSONObjectOptJSONObject3 != null) {
                            trailerUrl = null;
                        } else {
                            trailerUrl = null;
                        }
                        return new TmdbMetadata(Boxing.boxInt(tmdbId2), imdbId, logoUrl2, backdropUrl2, posterUrl, overview, rating, genres, actors, trailerUrl);
                    }
                } catch (Throwable th3) {
                    th = th3;
                    tmdbId2 = tmdbId;
                }
                break;
            case 1:
                int tmdbId3 = c00202.I$0;
                try {
                    ResultKt.throwOnFailure($result);
                    tmdbId2 = tmdbId3;
                    obj = Result.constructor-impl(((NiceResponse) $result).getText());
                    break;
                } catch (Throwable th4) {
                    th = th4;
                    tmdbId2 = tmdbId3;
                    Object $result4 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                    if (Result.isFailure-impl(obj)) {
                        obj = null;
                    }
                    text = (String) obj;
                    if (text == null) {
                        return null;
                    }
                    JSONObject json3 = new JSONObject(text);
                    backdropPath = json3.optString("backdrop_path");
                    if (StringsKt.isBlank(backdropPath)) {
                        backdropPath = null;
                    }
                    if (backdropPath != null) {
                        String it16 = backdropPath;
                        it = "https://image.tmdb.org/t/p/original" + it16;
                    } else {
                        it = null;
                    }
                    String backdropUrl3 = it;
                    posterPath = json3.optString("poster_path");
                    if (StringsKt.isBlank(posterPath)) {
                        posterPath = null;
                    }
                    if (posterPath != null) {
                        String it17 = posterPath;
                        posterUrl = "https://image.tmdb.org/t/p/w500" + it17;
                    } else {
                        posterUrl = null;
                    }
                    String logoUrl3 = extractLogoUrl(json3.optJSONObject("images"));
                    jSONObjectOptJSONObject = json3.optJSONObject("external_ids");
                    if (jSONObjectOptJSONObject != null) {
                        imdbId = null;
                    } else {
                        imdbId = null;
                    }
                    it2 = json3.optString("overview");
                    if (StringsKt.isBlank(it2)) {
                        overview = it2;
                    } else {
                        overview = null;
                    }
                    dBoxDouble = Boxing.boxDouble(json3.optDouble("vote_average", 0.0d));
                    it3 = dBoxDouble.doubleValue();
                    if (it3 > 0.0d) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        rating = dBoxDouble;
                    } else {
                        rating = null;
                    }
                    arr = json3.optJSONArray("genres");
                    if (arr != null) {
                        Iterable $this$mapNotNull$iv4 = RangesKt.until(0, arr.length());
                        destination$iv$iv = new ArrayList();
                        it4 = $this$mapNotNull$iv4.iterator();
                        while (it4.hasNext()) {
                            int element$iv$iv$iv4 = it4.nextInt();
                            String text4 = text;
                            jSONObjectOptJSONObject4 = arr.optJSONObject(element$iv$iv$iv4);
                            if (jSONObjectOptJSONObject4 != null) {
                                n = null;
                            } else {
                                n = null;
                            }
                            if (n != null) {
                                destination$iv$iv.add(n);
                            }
                            text = text4;
                        }
                        genres = (List) destination$iv$iv;
                    } else {
                        genres = null;
                    }
                    jSONObjectOptJSONObject2 = json3.optJSONObject("credits");
                    if (jSONObjectOptJSONObject2 != null) {
                        actors = null;
                    } else {
                        actors = null;
                    }
                    jSONObjectOptJSONObject3 = json3.optJSONObject("videos");
                    if (jSONObjectOptJSONObject3 != null) {
                        trailerUrl = null;
                    } else {
                        trailerUrl = null;
                    }
                    return new TmdbMetadata(Boxing.boxInt(tmdbId2), imdbId, logoUrl3, backdropUrl3, posterUrl, overview, rating, genres, actors, trailerUrl);
                }
                if (Result.isFailure-impl(obj)) {
                    obj = null;
                }
                text = (String) obj;
                if (text == null) {
                    return null;
                }
                JSONObject json4 = new JSONObject(text);
                backdropPath = json4.optString("backdrop_path");
                if (StringsKt.isBlank(backdropPath)) {
                    backdropPath = null;
                }
                if (backdropPath != null) {
                    String it18 = backdropPath;
                    it = "https://image.tmdb.org/t/p/original" + it18;
                } else {
                    it = null;
                }
                String backdropUrl4 = it;
                posterPath = json4.optString("poster_path");
                if (StringsKt.isBlank(posterPath)) {
                    posterPath = null;
                }
                if (posterPath != null) {
                    String it19 = posterPath;
                    posterUrl = "https://image.tmdb.org/t/p/w500" + it19;
                } else {
                    posterUrl = null;
                }
                String logoUrl4 = extractLogoUrl(json4.optJSONObject("images"));
                jSONObjectOptJSONObject = json4.optJSONObject("external_ids");
                if (jSONObjectOptJSONObject != null) {
                    imdbId = null;
                } else {
                    imdbId = null;
                }
                it2 = json4.optString("overview");
                if (StringsKt.isBlank(it2)) {
                    overview = it2;
                } else {
                    overview = null;
                }
                dBoxDouble = Boxing.boxDouble(json4.optDouble("vote_average", 0.0d));
                it3 = dBoxDouble.doubleValue();
                if (it3 > 0.0d) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    rating = dBoxDouble;
                } else {
                    rating = null;
                }
                arr = json4.optJSONArray("genres");
                if (arr != null) {
                    Iterable $this$mapNotNull$iv5 = RangesKt.until(0, arr.length());
                    destination$iv$iv = new ArrayList();
                    it4 = $this$mapNotNull$iv5.iterator();
                    while (it4.hasNext()) {
                        int element$iv$iv$iv5 = it4.nextInt();
                        String text5 = text;
                        jSONObjectOptJSONObject4 = arr.optJSONObject(element$iv$iv$iv5);
                        if (jSONObjectOptJSONObject4 != null) {
                            n = null;
                        } else {
                            n = null;
                        }
                        if (n != null) {
                            destination$iv$iv.add(n);
                        }
                        text = text5;
                    }
                    genres = (List) destination$iv$iv;
                } else {
                    genres = null;
                }
                jSONObjectOptJSONObject2 = json4.optJSONObject("credits");
                if (jSONObjectOptJSONObject2 != null) {
                    actors = null;
                } else {
                    actors = null;
                }
                jSONObjectOptJSONObject3 = json4.optJSONObject("videos");
                if (jSONObjectOptJSONObject3 != null) {
                    trailerUrl = null;
                } else {
                    trailerUrl = null;
                }
                return new TmdbMetadata(Boxing.boxInt(tmdbId2), imdbId, logoUrl4, backdropUrl4, posterUrl, overview, rating, genres, actors, trailerUrl);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final String extractLogoUrl(JSONObject imagesObj) {
        JSONArray logos;
        if (imagesObj == null || (logos = imagesObj.optJSONArray("logos")) == null || logos.length() == 0) {
            return null;
        }
        int length = logos.length();
        for (int i = 0; i < length; i++) {
            JSONObject logo = logos.optJSONObject(i);
            if (logo != null) {
                String p = extractLogoUrl$path(logo);
                if (!StringsKt.isBlank(p) && !extractLogoUrl$isSvg(logo)) {
                    String lang = StringsKt.trim(logo.optString("iso_639_1")).toString().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lang, "toLowerCase(...)");
                    if (Intrinsics.areEqual(lang, "en")) {
                        return extractLogoUrl$urlOf(logo);
                    }
                }
            }
        }
        int length2 = logos.length();
        for (int i2 = 0; i2 < length2; i2++) {
            JSONObject logo2 = logos.optJSONObject(i2);
            if (logo2 != null) {
                String p2 = extractLogoUrl$path(logo2);
                if (StringsKt.isBlank(p2)) {
                    continue;
                } else {
                    String lang2 = StringsKt.trim(logo2.optString("iso_639_1")).toString().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lang2, "toLowerCase(...)");
                    if (Intrinsics.areEqual(lang2, "en")) {
                        return extractLogoUrl$urlOf(logo2);
                    }
                }
            }
        }
        int length3 = logos.length();
        for (int i3 = 0; i3 < length3; i3++) {
            JSONObject logo3 = logos.optJSONObject(i3);
            if (logo3 != null) {
                String p3 = extractLogoUrl$path(logo3);
                if (!StringsKt.isBlank(p3) && !extractLogoUrl$isSvg(logo3)) {
                    return extractLogoUrl$urlOf(logo3);
                }
            }
        }
        JSONObject first = logos.optJSONObject(0);
        if (first == null) {
            return null;
        }
        String p4 = extractLogoUrl$path(first);
        if (StringsKt.isBlank(p4)) {
            return null;
        }
        return extractLogoUrl$urlOf(first);
    }

    private static final String extractLogoUrl$path(JSONObject o) {
        return o.optString("file_path");
    }

    private static final boolean extractLogoUrl$isSvg(JSONObject o) {
        return StringsKt.endsWith(extractLogoUrl$path(o), ".svg", true);
    }

    private static final String extractLogoUrl$urlOf(JSONObject o) {
        return "https://image.tmdb.org/t/p/w500" + extractLogoUrl$path(o);
    }
}
