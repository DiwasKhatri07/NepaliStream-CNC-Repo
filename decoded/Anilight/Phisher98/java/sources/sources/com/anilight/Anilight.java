package com.anilight;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.AnimeLoadResponse;
import com.lagradost.cloudstream3.AnimeSearchResponse;
import com.lagradost.cloudstream3.DubStatus;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.ErrorLoadingException;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.MainPageData;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.ParCollectionsKt;
import com.lagradost.cloudstream3.Score;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlin.text.StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Anilight.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Anilight/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u00002\u00020\u0001:\u00149:;<=>?@ABCDEFGHIJKLB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u001e\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010%J\f\u0010&\u001a\u00020'*\u00020(H\u0002J\u001e\u0010)\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u001c2\u0006\u0010*\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010+J\u0016\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010+JF\u0010/\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u000e2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u000205032\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020503H\u0096@¢\u0006\u0002\u00108R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006M"}, d2 = {"Lcom/anilight/Anilight;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lcom/anilight/Anilight$Media;", "search", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "LinkData", "ProviderInfo", "FilterResponse", "PageInfo", "Media", "Title", "CoverImage", "DetailResponse", "WatchResponse", "Episode", "Servers", "Provider", "SourcesResponse", "Source", "Track", "Tmdb", "Logos", "AniZipResponse", "AniZipEpisode", "AniZipMappings", "Anilight"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAnilight.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Anilight.kt\ncom/anilight/Anilight\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 6 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,303:1\n73#2,5:304\n73#2,5:313\n73#2,5:322\n73#2,5:327\n73#2,5:332\n1739#3:309\n1814#3,3:310\n1739#3:318\n1814#3,3:319\n1795#3,10:337\n2068#3:347\n2069#3:349\n1805#3:350\n1795#3,10:351\n2068#3:361\n2069#3:363\n1805#3:364\n1739#3:365\n1814#3,3:366\n1739#3:369\n1814#3,3:370\n1#4:348\n1#4:362\n1#4:374\n1#4:392\n63#5:373\n64#5,15:375\n50#6:390\n43#6:391\n*S KotlinDebug\n*F\n+ 1 Anilight.kt\ncom/anilight/Anilight\n*L\n34#1:304,5\n55#1:313,5\n60#1:322,5\n68#1:327,5\n71#1:332,5\n35#1:309\n35#1:310,3\n56#1:318\n56#1:319,3\n74#1:337,10\n74#1:347\n74#1:349\n74#1:350\n77#1:351,10\n77#1:361\n77#1:363\n77#1:364\n81#1:365\n81#1:366,3\n96#1:369\n96#1:370,3\n74#1:348\n77#1:362\n131#1:374\n131#1:373\n131#1:375,15\n131#1:390\n131#1:391\n*E\n"})
public final class Anilight extends MainAPI {

    @NotNull
    private String mainUrl = "https://anilight.live";

    @NotNull
    private String name = "Anilight";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "en";
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Anime, TvType.AnimeMovie, TvType.OVA});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("sort=TRENDING_DESC", "Trending"), TuplesKt.to("status=RELEASING&sort=POPULARITY_DESC", "Popular Releasing"), TuplesKt.to("sort=POPULARITY_DESC", "Popular"), TuplesKt.to("sort=SCORE_DESC", "Highest Rated")});

    /* JADX INFO: renamed from: com.anilight.Anilight$getMainPage$1 */
    /* JADX INFO: compiled from: Anilight.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.anilight.Anilight", f = "Anilight.kt", i = {0, 0, 0}, l = {34}, m = "getMainPage", n = {"request", "url", "page"}, nl = {304}, s = {"L$0", "L$1", "I$0"}, v = 2)
    static final class C00001 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00001(Continuation<? super C00001> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Anilight.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.anilight.Anilight$load$1 */
    /* JADX INFO: compiled from: Anilight.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.anilight.Anilight", f = "Anilight.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {60, 68, 71, 111}, m = "load", n = {"url", "url", "res", "title", "posterUrl", "backgroundUrl", "description", "logoUrl", "watchUrl", "url", "res", "title", "posterUrl", "backgroundUrl", "description", "logoUrl", "watchUrl", "watchRes", "it", "url", "res", "title", "posterUrl", "backgroundUrl", "description", "logoUrl", "watchUrl", "watchRes", "anizipRes", "dubProviders", "subProviders", "subEpisodes", "dubEpisodes"}, nl = {304, 309, 314, -1}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
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

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Anilight.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.anilight.Anilight$loadLinks$1 */
    /* JADX INFO: compiled from: Anilight.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.anilight.Anilight", f = "Anilight.kt", i = {0, 0, 0, 0, 0}, l = {133}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "parsedData", "isCasting"}, nl = {166}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0"}, v = 2)
    static final class C00031 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00031(Continuation<? super C00031> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Anilight.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.anilight.Anilight$search$1 */
    /* JADX INFO: compiled from: Anilight.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.anilight.Anilight", f = "Anilight.kt", i = {0, 0}, l = {55}, m = "search", n = {"query", "url"}, nl = {304}, s = {"L$0", "L$1"}, v = 2)
    static final class C00051 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00051(Continuation<? super C00051> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Anilight.this.search(null, (Continuation) this);
        }
    }

    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    public void setMainUrl(@NotNull String str) {
        this.mainUrl = str;
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    public void setName(@NotNull String str) {
        this.name = str;
    }

    public boolean getHasMainPage() {
        return this.hasMainPage;
    }

    @NotNull
    public String getLang() {
        return this.lang;
    }

    public void setLang(@NotNull String str) {
        this.lang = str;
    }

    public boolean getHasDownloadSupport() {
        return this.hasDownloadSupport;
    }

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00001 c00001;
        MainPageRequest request2;
        Object safe;
        List home;
        Boolean hasNextPage;
        if (continuation instanceof C00001) {
            c00001 = (C00001) continuation;
            if ((c00001.label & Integer.MIN_VALUE) != 0) {
                c00001.label -= Integer.MIN_VALUE;
            } else {
                c00001 = new C00001(continuation);
            }
        } else {
            c00001 = new C00001(continuation);
        }
        Object $result = c00001.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00001.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String url = "https://api.anilight.live/api/filter?page=" + page + '&' + request.getData();
                Requests app = MainActivityKt.getApp();
                c00001.L$0 = request;
                c00001.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00001.I$0 = page;
                c00001.label = 1;
                $result = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00001, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request2 = request;
                break;
                break;
            case 1:
                int i = c00001.I$0;
                request2 = (MainPageRequest) c00001.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse this_$iv = (NiceResponse) $result;
        try {
            ResponseParser parser = this_$iv.getParser();
            Intrinsics.checkNotNull(parser);
            safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(FilterResponse.class));
        } catch (Exception e$iv) {
            e$iv.printStackTrace();
            safe = null;
        }
        FilterResponse res = (FilterResponse) safe;
        boolean zBooleanValue = false;
        if (res == null) {
            return MainAPIKt.newHomePageResponse(request2.getName(), CollectionsKt.emptyList(), Boxing.boxBoolean(false));
        }
        Iterable media = res.getMedia();
        if (media != null) {
            Iterable $this$map$iv = media;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                Media it = (Media) item$iv$iv;
                destination$iv$iv.add(toSearchResult(it));
            }
            home = (List) destination$iv$iv;
        } else {
            home = CollectionsKt.emptyList();
        }
        String name = request2.getName();
        PageInfo pageInfo = res.getPageInfo();
        if (pageInfo != null && (hasNextPage = pageInfo.getHasNextPage()) != null) {
            zBooleanValue = hasNextPage.booleanValue();
        }
        return MainAPIKt.newHomePageResponse(name, home, Boxing.boxBoolean(zBooleanValue));
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0053 A[PHI: r0
      0x0053: PHI (r0v21 java.lang.String) = (r0v17 java.lang.String), (r0v22 java.lang.String) binds: [B:29:0x0061, B:22:0x0050] A[DONT_GENERATE, DONT_INLINE]] */
    private final SearchResponse toSearchResult(final Media $this$toSearchResult) {
        String romaji;
        String extraLarge;
        String url = "https://api.anilight.live/api/anime/" + $this$toSearchResult.getSlug();
        Title title = $this$toSearchResult.getTitle();
        String large = null;
        if (title == null || (romaji = title.getEnglish()) == null) {
            Title title2 = $this$toSearchResult.getTitle();
            romaji = title2 != null ? title2.getRomaji() : null;
            if (romaji == null) {
                Title title3 = $this$toSearchResult.getTitle();
                romaji = title3 != null ? title3.getNative() : null;
                if (romaji == null) {
                    romaji = "";
                }
            }
        }
        String title4 = romaji;
        Tmdb tmdb = $this$toSearchResult.getTmdb();
        if (tmdb == null || (extraLarge = tmdb.getPoster()) == null) {
            CoverImage coverImage = $this$toSearchResult.getCoverImage();
            extraLarge = coverImage != null ? coverImage.getExtraLarge() : null;
            if (extraLarge == null) {
                CoverImage coverImage2 = $this$toSearchResult.getCoverImage();
                if (coverImage2 != null) {
                    large = coverImage2.getLarge();
                }
            } else {
                large = extraLarge;
            }
        } else {
            large = extraLarge;
        }
        final String poster = large;
        return MainAPIKt.newAnimeSearchResponse$default(this, title4, url, TvType.Anime, false, new Function1() { // from class: com.anilight.Anilight$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return Anilight.toSearchResult$lambda$0(poster, $this$toSearchResult, (AnimeSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResult$lambda$0(String $poster, Media $this_toSearchResult, AnimeSearchResponse $this$newAnimeSearchResponse) {
        $this$newAnimeSearchResponse.setPosterUrl($poster);
        Integer episodes = $this_toSearchResult.getEpisodes();
        if (episodes != null) {
            int it = episodes.intValue();
            MainAPIKt.addSub($this$newAnimeSearchResponse, Integer.valueOf(it));
        }
        Integer averageScore = $this_toSearchResult.getAverageScore();
        if (averageScore != null) {
            int it2 = averageScore.intValue();
            $this$newAnimeSearchResponse.setScore(Score.Companion.from10(String.valueOf(((double) it2) / 10.0d)));
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        C00051 c00051;
        Object obj;
        Object safe;
        Iterable media;
        if (continuation instanceof C00051) {
            c00051 = (C00051) continuation;
            if ((c00051.label & Integer.MIN_VALUE) != 0) {
                c00051.label -= Integer.MIN_VALUE;
            } else {
                c00051 = new C00051(continuation);
            }
        } else {
            c00051 = new C00051(continuation);
        }
        C00051 c00052 = c00051;
        Object $result = c00052.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00052.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String url = "https://api.anilight.live/api/filter?page=1&search=" + query;
                Requests app = MainActivityKt.getApp();
                c00052.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00052.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00052.label = 1;
                obj = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00052, 4094, (Object) null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                obj = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse this_$iv = (NiceResponse) obj;
        try {
            ResponseParser parser = this_$iv.getParser();
            Intrinsics.checkNotNull(parser);
            safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(FilterResponse.class));
        } catch (Exception e$iv) {
            e$iv.printStackTrace();
            safe = null;
        }
        FilterResponse res = (FilterResponse) safe;
        if (res == null || (media = res.getMedia()) == null) {
            return null;
        }
        Iterable $this$map$iv = media;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Media it = (Media) item$iv$iv;
            destination$iv$iv.add(toSearchResult(it));
        }
        return (List) destination$iv$iv;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.lagradost.cloudstream3.ErrorLoadingException */
    /* JADX WARN: Code duplicated, block: B:104:0x033f  */
    /* JADX WARN: Code duplicated, block: B:107:0x0368  */
    /* JADX WARN: Code duplicated, block: B:124:0x03d7  */
    /* JADX WARN: Code duplicated, block: B:127:0x03e7  */
    /* JADX WARN: Code duplicated, block: B:144:0x0456  */
    /* JADX WARN: Code duplicated, block: B:147:0x0468  */
    /* JADX WARN: Code duplicated, block: B:150:0x0482  */
    /* JADX WARN: Code duplicated, block: B:152:0x048d  */
    /* JADX WARN: Code duplicated, block: B:155:0x04a2  */
    /* JADX WARN: Code duplicated, block: B:158:0x04b6  */
    /* JADX WARN: Code duplicated, block: B:159:0x04c1  */
    /* JADX WARN: Code duplicated, block: B:162:0x04ca  */
    /* JADX WARN: Code duplicated, block: B:163:0x04d5  */
    /* JADX WARN: Code duplicated, block: B:166:0x050f  */
    /* JADX WARN: Code duplicated, block: B:169:0x051e  */
    /* JADX WARN: Code duplicated, block: B:172:0x053a  */
    /* JADX WARN: Code duplicated, block: B:174:0x0544  */
    /* JADX WARN: Code duplicated, block: B:177:0x0559  */
    /* JADX WARN: Code duplicated, block: B:180:0x056d  */
    /* JADX WARN: Code duplicated, block: B:181:0x0578  */
    /* JADX WARN: Code duplicated, block: B:184:0x0581  */
    /* JADX WARN: Code duplicated, block: B:185:0x058c  */
    /* JADX WARN: Code duplicated, block: B:188:0x05c3  */
    /* JADX WARN: Code duplicated, block: B:191:0x0646 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:192:0x0647  */
    /* JADX WARN: Code duplicated, block: B:194:0x065f  */
    /* JADX WARN: Code duplicated, block: B:196:0x0667  */
    /* JADX WARN: Code duplicated, block: B:27:0x0152  */
    /* JADX WARN: Code duplicated, block: B:31:0x015e  */
    /* JADX WARN: Code duplicated, block: B:33:0x0164  */
    /* JADX WARN: Code duplicated, block: B:34:0x0169  */
    /* JADX WARN: Code duplicated, block: B:36:0x016d  */
    /* JADX WARN: Code duplicated, block: B:38:0x0173  */
    /* JADX WARN: Code duplicated, block: B:39:0x0178  */
    /* JADX WARN: Code duplicated, block: B:41:0x017c  */
    /* JADX WARN: Code duplicated, block: B:46:0x018a  */
    /* JADX WARN: Code duplicated, block: B:48:0x0190  */
    /* JADX WARN: Code duplicated, block: B:49:0x0195  */
    /* JADX WARN: Code duplicated, block: B:51:0x0199  */
    /* JADX WARN: Code duplicated, block: B:53:0x019f  */
    /* JADX WARN: Code duplicated, block: B:54:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:59:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:68:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:70:0x01da  */
    /* JADX WARN: Code duplicated, block: B:75:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:78:0x0248 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:79:0x0249  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:87:0x027d  */
    /* JADX WARN: Code duplicated, block: B:89:0x0283  */
    /* JADX WARN: Code duplicated, block: B:91:0x02f2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:92:0x02f3  */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) throws ErrorLoadingException {
        C00011 c00011;
        Object obj;
        String url2;
        Object safe;
        DetailResponse res;
        Title title;
        Title title2;
        String title3;
        Title title4;
        Tmdb tmdb;
        CoverImage coverImage;
        String posterUrl;
        CoverImage coverImage2;
        Tmdb tmdb2;
        String backgroundUrl;
        String description;
        Tmdb tmdb3;
        Tmdb tmdb4;
        String logoUrl;
        Logos logos;
        List<String> japanese;
        String watchUrl;
        String backgroundUrl2;
        String logoUrl2;
        String posterUrl2;
        String url3;
        String title5;
        DetailResponse res2;
        String logoUrl3;
        String backgroundUrl3;
        String url4;
        String posterUrl3;
        String description2;
        String description3;
        String watchUrl2;
        Logos logos2;
        List<String> english;
        Object safe2;
        WatchResponse watchRes;
        Integer anilistId;
        WatchResponse watchRes2;
        AniZipResponse aniZipResponse;
        String posterUrl4;
        String url5;
        String title6;
        String logoUrl4;
        String logoUrl5;
        DetailResponse res3;
        String backgroundUrl4;
        String backgroundUrl5;
        String description4;
        String backgroundUrl6;
        String posterUrl5;
        String title7;
        DetailResponse res4;
        String url6;
        String logoUrl6;
        WatchResponse watchRes3;
        String watchUrl3;
        String posterUrl6;
        String url7;
        String title8;
        String backgroundUrl7;
        DetailResponse res5;
        String logoUrl7;
        String description5;
        AniZipResponse anizipRes;
        Servers servers;
        WatchResponse watchRes4;
        List listEmptyList;
        List dubProviders;
        Servers servers2;
        String title9;
        List listEmptyList2;
        List subProviders;
        Iterable episodes;
        String url8;
        List subEpisodes;
        Iterable episodes2;
        List subProviders2;
        List dubEpisodes;
        Iterable $this$map$iv;
        int $i$f$map;
        Collection destination$iv$iv;
        Iterable $this$mapTo$iv$iv;
        int $i$f$mapTo;
        final AniZipEpisode anizipEp;
        Integer id;
        int $i$f$map2;
        Integer number;
        int iIntValue;
        Map<String, AniZipEpisode> episodes3;
        Iterable $this$map$iv2;
        int $i$f$map3;
        Collection destination$iv$iv2;
        Iterable $this$mapTo$iv$iv2;
        int $i$f$mapTo2;
        final AniZipEpisode anizipEp2;
        Integer id2;
        int $i$f$map4;
        Integer number2;
        int iIntValue2;
        Map<String, AniZipEpisode> episodes4;
        Iterable subProviders3;
        ProviderInfo providerInfo;
        Iterable dubProviders2;
        ProviderInfo providerInfo2;
        Object safe3;
        if (continuation instanceof C00011) {
            c00011 = (C00011) continuation;
            if ((c00011.label & Integer.MIN_VALUE) != 0) {
                c00011.label -= Integer.MIN_VALUE;
            } else {
                c00011 = new C00011(continuation);
            }
        } else {
            c00011 = new C00011(continuation);
        }
        C00011 c00012 = c00011;
        Object $result = c00012.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00012.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                c00012.L$0 = url;
                c00012.label = 1;
                obj = coroutine_suspended;
                $result = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00012, 4094, (Object) null);
                c00012 = c00012;
                if ($result == obj) {
                    return obj;
                }
                url2 = url;
                NiceResponse this_$iv = (NiceResponse) $result;
                try {
                    ResponseParser parser = this_$iv.getParser();
                    Intrinsics.checkNotNull(parser);
                    safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(DetailResponse.class));
                    break;
                } catch (Exception e$iv) {
                    e$iv.printStackTrace();
                    safe = null;
                }
                res = (DetailResponse) safe;
                if (res != null) {
                    throw new ErrorLoadingException("Failed to load anime");
                }
                title = res.getTitle();
                if (title != null || (title3 = title.getEnglish()) == null) {
                    title2 = res.getTitle();
                    if (title2 != null) {
                        title3 = title2.getRomaji();
                    } else {
                        title3 = null;
                    }
                    if (title3 == null) {
                        title4 = res.getTitle();
                        if (title4 != null) {
                            title3 = title4.getNative();
                        } else {
                            title3 = null;
                        }
                        if (title3 == null) {
                            title3 = "";
                        }
                    }
                }
                tmdb = res.getTmdb();
                if (tmdb != null || (posterUrl = tmdb.getPoster()) == null) {
                    coverImage = res.getCoverImage();
                    if (coverImage != null) {
                        posterUrl = coverImage.getExtraLarge();
                    } else {
                        posterUrl = null;
                    }
                    if (posterUrl == null) {
                        coverImage2 = res.getCoverImage();
                        if (coverImage2 != null) {
                            posterUrl = coverImage2.getLarge();
                        } else {
                            posterUrl = null;
                        }
                    }
                }
                tmdb2 = res.getTmdb();
                if (tmdb2 != null || (backgroundUrl = tmdb2.getBackdrop()) == null) {
                    backgroundUrl = res.getBannerImage();
                }
                description = res.getDescription();
                tmdb3 = res.getTmdb();
                if (tmdb3 != null || (logos2 = tmdb3.getLogos()) == null || (english = logos2.getEnglish()) == null || (logoUrl = (String) CollectionsKt.firstOrNull(english)) == null) {
                    tmdb4 = res.getTmdb();
                    if (tmdb4 != null || (logos = tmdb4.getLogos()) == null || (japanese = logos.getJapanese()) == null) {
                        logoUrl = null;
                    } else {
                        logoUrl = (String) CollectionsKt.firstOrNull(japanese);
                    }
                }
                watchUrl = StringsKt.replace$default(url2, "/api/anime/", "/api/watch/", false, 4, (Object) null);
                Requests app2 = MainActivityKt.getApp();
                c00012.L$0 = url2;
                c00012.L$1 = res;
                c00012.L$2 = title3;
                c00012.L$3 = posterUrl;
                c00012.L$4 = backgroundUrl;
                c00012.L$5 = description;
                c00012.L$6 = logoUrl;
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(watchUrl);
                c00012.label = 2;
                backgroundUrl2 = backgroundUrl;
                logoUrl2 = logoUrl;
                posterUrl2 = posterUrl;
                C00011 c00013 = c00012;
                url3 = url2;
                title5 = title3;
                $result = Requests.get$default(app2, watchUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00013, 4094, (Object) null);
                c00012 = c00013;
                if ($result == obj) {
                    return obj;
                }
                res2 = res;
                logoUrl3 = description;
                backgroundUrl3 = posterUrl2;
                url4 = url3;
                posterUrl3 = title5;
                description2 = backgroundUrl2;
                description3 = watchUrl;
                watchUrl2 = logoUrl2;
                NiceResponse this_$iv2 = (NiceResponse) $result;
                try {
                    ResponseParser parser2 = this_$iv2.getParser();
                    Intrinsics.checkNotNull(parser2);
                    safe2 = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(WatchResponse.class));
                    break;
                } catch (Exception e$iv2) {
                    e$iv2.printStackTrace();
                    safe2 = null;
                }
                watchRes = (WatchResponse) safe2;
                if (watchRes == null) {
                    throw new ErrorLoadingException("Failed to load episodes");
                }
                anilistId = res2.getAnilistId();
                if (anilistId != null) {
                    int it = anilistId.intValue();
                    c00012.L$0 = url4;
                    c00012.L$1 = res2;
                    c00012.L$2 = posterUrl3;
                    c00012.L$3 = backgroundUrl3;
                    c00012.L$4 = description2;
                    c00012.L$5 = logoUrl3;
                    c00012.L$6 = watchUrl2;
                    c00012.L$7 = SpillingKt.nullOutSpilledVariable(description3);
                    c00012.L$8 = watchRes;
                    c00012.I$0 = it;
                    c00012.label = 3;
                    description4 = logoUrl3;
                    backgroundUrl6 = description2;
                    posterUrl5 = backgroundUrl3;
                    title7 = posterUrl3;
                    C00011 c00014 = c00012;
                    res4 = res2;
                    url6 = url4;
                    logoUrl6 = watchUrl2;
                    $result = Requests.get$default(MainActivityKt.getApp(), "https://api.ani.zip/mappings?anilist_id=" + it, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00014, 4094, (Object) null);
                    c00012 = c00014;
                    if ($result == obj) {
                        return obj;
                    }
                    watchRes3 = watchRes;
                    watchUrl3 = description3;
                    posterUrl6 = posterUrl5;
                    url7 = url6;
                    title8 = title7;
                    backgroundUrl7 = backgroundUrl6;
                    res5 = res4;
                    logoUrl7 = logoUrl6;
                    description5 = description4;
                    NiceResponse this_$iv3 = (NiceResponse) $result;
                    try {
                        ResponseParser parser3 = this_$iv3.getParser();
                        Intrinsics.checkNotNull(parser3);
                        try {
                            safe3 = parser3.parseSafe(this_$iv3.getText(), Reflection.getOrCreateKotlinClass(AniZipResponse.class));
                        } catch (Exception e) {
                            e$iv = e;
                            e$iv.printStackTrace();
                            safe3 = null;
                        }
                    } catch (Exception e2) {
                        e$iv = e2;
                    }
                    aniZipResponse = (AniZipResponse) safe3;
                    watchRes2 = watchRes3;
                    logoUrl4 = logoUrl7;
                    logoUrl5 = description5;
                    backgroundUrl4 = backgroundUrl7;
                    backgroundUrl5 = posterUrl6;
                    title6 = title8;
                    res3 = res5;
                    url5 = url7;
                    posterUrl4 = watchUrl3;
                    break;
                } else {
                    String logoUrl8 = watchUrl2;
                    String description6 = logoUrl3;
                    String backgroundUrl8 = description2;
                    String posterUrl7 = backgroundUrl3;
                    String title10 = posterUrl3;
                    watchRes2 = watchRes;
                    aniZipResponse = null;
                    posterUrl4 = description3;
                    url5 = url4;
                    title6 = title10;
                    logoUrl4 = logoUrl8;
                    logoUrl5 = description6;
                    res3 = res2;
                    backgroundUrl4 = backgroundUrl8;
                    backgroundUrl5 = posterUrl7;
                }
                anizipRes = aniZipResponse;
                servers = watchRes2.getServers();
                if (servers != null || (dubProviders2 = servers.getDubProviders()) == null) {
                    watchRes4 = watchRes2;
                    listEmptyList = CollectionsKt.emptyList();
                } else {
                    Iterable $this$mapNotNull$iv = dubProviders2;
                    int $i$f$mapNotNull = 0;
                    Collection destination$iv$iv3 = new ArrayList();
                    for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                        Provider it2 = (Provider) element$iv$iv$iv;
                        if (it2.getId() != null) {
                            String id3 = it2.getId();
                            String tip = it2.getTip();
                            providerInfo2 = new ProviderInfo(id3, tip == null ? "" : tip);
                        } else {
                            providerInfo2 = null;
                        }
                        if (providerInfo2 != null) {
                            destination$iv$iv3.add(providerInfo2);
                        }
                        $this$mapNotNull$iv = $this$mapNotNull$iv;
                        watchRes2 = watchRes2;
                        $i$f$mapNotNull = $i$f$mapNotNull;
                    }
                    watchRes4 = watchRes2;
                    listEmptyList = (List) destination$iv$iv3;
                }
                dubProviders = listEmptyList;
                servers2 = watchRes4.getServers();
                if (servers2 != null || (subProviders3 = servers2.getSubProviders()) == null) {
                    title9 = title6;
                    listEmptyList2 = CollectionsKt.emptyList();
                } else {
                    Iterable $this$mapNotNull$iv2 = subProviders3;
                    int $i$f$mapNotNull2 = 0;
                    Collection destination$iv$iv4 = new ArrayList();
                    for (Object element$iv$iv$iv2 : $this$mapNotNull$iv2) {
                        Provider it3 = (Provider) element$iv$iv$iv2;
                        if (it3.getId() != null) {
                            String id4 = it3.getId();
                            String tip2 = it3.getTip();
                            String title11 = tip2 == null ? "" : tip2;
                            providerInfo = new ProviderInfo(id4, title11);
                        } else {
                            providerInfo = null;
                        }
                        if (providerInfo != null) {
                            destination$iv$iv4.add(providerInfo);
                        }
                        $this$mapNotNull$iv2 = $this$mapNotNull$iv2;
                        $i$f$mapNotNull2 = $i$f$mapNotNull2;
                        title6 = title6;
                    }
                    title9 = title6;
                    listEmptyList2 = (List) destination$iv$iv4;
                }
                subProviders = listEmptyList2;
                episodes = watchRes4.getEpisodes();
                if (episodes != null) {
                    $this$map$iv2 = episodes;
                    $i$f$map3 = 0;
                    destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                    $this$mapTo$iv$iv2 = $this$map$iv2;
                    $i$f$mapTo2 = 0;
                    for (Object item$iv$iv : $this$mapTo$iv$iv2) {
                        final Episode ep = (Episode) item$iv$iv;
                        if (anizipRes != null || (episodes4 = anizipRes.getEpisodes()) == null) {
                            anizipEp2 = null;
                        } else {
                            anizipEp2 = episodes4.get(String.valueOf(ep.getNumber()));
                        }
                        Anilight anilight = this;
                        Iterable $this$map$iv3 = $this$map$iv2;
                        AppUtils appUtils = AppUtils.INSTANCE;
                        String url9 = url5;
                        id2 = watchRes4.getId();
                        if (id2 != null) {
                            $i$f$map4 = id2.intValue();
                        } else {
                            $i$f$map4 = 0;
                        }
                        number2 = ep.getNumber();
                        if (number2 != null) {
                            iIntValue2 = number2.intValue();
                        } else {
                            iIntValue2 = 0;
                        }
                        destination$iv$iv2.add(MainAPIKt.newEpisode(anilight, appUtils.toJson(new LinkData($i$f$map4, iIntValue2, subProviders, "sub")), new Function1() { // from class: com.anilight.Anilight$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj2) {
                                return Anilight.load$lambda$3$0(ep, anizipEp2, (Episode) obj2);
                            }
                        }));
                        $this$map$iv2 = $this$map$iv3;
                        url5 = url9;
                        $i$f$map3 = $i$f$map3;
                        $this$mapTo$iv$iv2 = $this$mapTo$iv$iv2;
                        $i$f$mapTo2 = $i$f$mapTo2;
                    }
                    url8 = url5;
                    subEpisodes = (List) destination$iv$iv2;
                } else {
                    url8 = url5;
                    subEpisodes = CollectionsKt.emptyList();
                }
                episodes2 = watchRes4.getEpisodes();
                if (episodes2 != null) {
                    $this$map$iv = episodes2;
                    $i$f$map = 0;
                    destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    $this$mapTo$iv$iv = $this$map$iv;
                    $i$f$mapTo = 0;
                    for (Object item$iv$iv2 : $this$mapTo$iv$iv) {
                        final Episode ep2 = (Episode) item$iv$iv2;
                        if (anizipRes != null || (episodes3 = anizipRes.getEpisodes()) == null) {
                            anizipEp = null;
                        } else {
                            anizipEp = episodes3.get(String.valueOf(ep2.getNumber()));
                        }
                        Anilight anilight2 = this;
                        List subProviders4 = subProviders;
                        AppUtils appUtils2 = AppUtils.INSTANCE;
                        Iterable $this$map$iv4 = $this$map$iv;
                        id = watchRes4.getId();
                        if (id != null) {
                            $i$f$map2 = id.intValue();
                        } else {
                            $i$f$map2 = 0;
                        }
                        number = ep2.getNumber();
                        if (number != null) {
                            iIntValue = number.intValue();
                        } else {
                            iIntValue = 0;
                        }
                        destination$iv$iv.add(MainAPIKt.newEpisode(anilight2, appUtils2.toJson(new LinkData($i$f$map2, iIntValue, dubProviders, "dub")), new Function1() { // from class: com.anilight.Anilight$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj2) {
                                return Anilight.load$lambda$4$0(ep2, anizipEp, (Episode) obj2);
                            }
                        }));
                        $this$map$iv = $this$map$iv4;
                        $i$f$map = $i$f$map;
                        $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                        $i$f$mapTo = $i$f$mapTo;
                        subProviders = subProviders4;
                    }
                    subProviders2 = subProviders;
                    dubEpisodes = (List) destination$iv$iv;
                } else {
                    subProviders2 = subProviders;
                    dubEpisodes = CollectionsKt.emptyList();
                }
                TvType tvType = TvType.Anime;
                C00022 c00022 = new C00022(subProviders2, subEpisodes, dubProviders, dubEpisodes, backgroundUrl5, backgroundUrl4, logoUrl4, logoUrl5, res3, anizipRes, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url8);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(res3);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(title9);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(backgroundUrl5);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(backgroundUrl4);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(logoUrl5);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(logoUrl4);
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(posterUrl4);
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(watchRes4);
                c00012.L$9 = SpillingKt.nullOutSpilledVariable(anizipRes);
                c00012.L$10 = SpillingKt.nullOutSpilledVariable(dubProviders);
                c00012.L$11 = SpillingKt.nullOutSpilledVariable(subProviders2);
                c00012.L$12 = SpillingKt.nullOutSpilledVariable(subEpisodes);
                c00012.L$13 = SpillingKt.nullOutSpilledVariable(dubEpisodes);
                c00012.label = 4;
                $result = MainAPIKt.newAnimeLoadResponse$default(this, title9, url8, tvType, false, c00022, c00012, 8, (Object) null);
                if ($result == obj) {
                    return obj;
                }
                return $result;
            case 1:
                String url10 = (String) c00012.L$0;
                ResultKt.throwOnFailure($result);
                url2 = url10;
                obj = coroutine_suspended;
                NiceResponse this_$iv4 = (NiceResponse) $result;
                ResponseParser parser4 = this_$iv4.getParser();
                Intrinsics.checkNotNull(parser4);
                safe = parser4.parseSafe(this_$iv4.getText(), Reflection.getOrCreateKotlinClass(DetailResponse.class));
                res = (DetailResponse) safe;
                if (res != null) {
                    throw new ErrorLoadingException("Failed to load anime");
                }
                title = res.getTitle();
                if (title != null) {
                    title2 = res.getTitle();
                    if (title2 != null) {
                        title3 = title2.getRomaji();
                    } else {
                        title3 = null;
                    }
                    if (title3 == null) {
                        title4 = res.getTitle();
                        if (title4 != null) {
                            title3 = title4.getNative();
                        } else {
                            title3 = null;
                        }
                        if (title3 == null) {
                            title3 = "";
                        }
                    }
                } else {
                    title2 = res.getTitle();
                    if (title2 != null) {
                        title3 = title2.getRomaji();
                    } else {
                        title3 = null;
                    }
                    if (title3 == null) {
                        title4 = res.getTitle();
                        if (title4 != null) {
                            title3 = title4.getNative();
                        } else {
                            title3 = null;
                        }
                        if (title3 == null) {
                            title3 = "";
                        }
                    }
                }
                tmdb = res.getTmdb();
                if (tmdb != null) {
                    coverImage = res.getCoverImage();
                    if (coverImage != null) {
                        posterUrl = coverImage.getExtraLarge();
                    } else {
                        posterUrl = null;
                    }
                    if (posterUrl == null) {
                        coverImage2 = res.getCoverImage();
                        if (coverImage2 != null) {
                            posterUrl = coverImage2.getLarge();
                        } else {
                            posterUrl = null;
                        }
                    }
                } else {
                    coverImage = res.getCoverImage();
                    if (coverImage != null) {
                        posterUrl = coverImage.getExtraLarge();
                    } else {
                        posterUrl = null;
                    }
                    if (posterUrl == null) {
                        coverImage2 = res.getCoverImage();
                        if (coverImage2 != null) {
                            posterUrl = coverImage2.getLarge();
                        } else {
                            posterUrl = null;
                        }
                    }
                }
                tmdb2 = res.getTmdb();
                if (tmdb2 != null) {
                    backgroundUrl = res.getBannerImage();
                } else {
                    backgroundUrl = res.getBannerImage();
                }
                description = res.getDescription();
                tmdb3 = res.getTmdb();
                if (tmdb3 != null) {
                    tmdb4 = res.getTmdb();
                    if (tmdb4 != null) {
                        logoUrl = null;
                    } else {
                        logoUrl = null;
                    }
                } else {
                    tmdb4 = res.getTmdb();
                    if (tmdb4 != null) {
                        logoUrl = null;
                    } else {
                        logoUrl = null;
                    }
                }
                watchUrl = StringsKt.replace$default(url2, "/api/anime/", "/api/watch/", false, 4, (Object) null);
                Requests app3 = MainActivityKt.getApp();
                c00012.L$0 = url2;
                c00012.L$1 = res;
                c00012.L$2 = title3;
                c00012.L$3 = posterUrl;
                c00012.L$4 = backgroundUrl;
                c00012.L$5 = description;
                c00012.L$6 = logoUrl;
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(watchUrl);
                c00012.label = 2;
                backgroundUrl2 = backgroundUrl;
                logoUrl2 = logoUrl;
                posterUrl2 = posterUrl;
                C00011 c00015 = c00012;
                url3 = url2;
                title5 = title3;
                $result = Requests.get$default(app3, watchUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00015, 4094, (Object) null);
                c00012 = c00015;
                if ($result == obj) {
                    return obj;
                }
                res2 = res;
                logoUrl3 = description;
                backgroundUrl3 = posterUrl2;
                url4 = url3;
                posterUrl3 = title5;
                description2 = backgroundUrl2;
                description3 = watchUrl;
                watchUrl2 = logoUrl2;
                NiceResponse this_$iv5 = (NiceResponse) $result;
                ResponseParser parser5 = this_$iv5.getParser();
                Intrinsics.checkNotNull(parser5);
                safe2 = parser5.parseSafe(this_$iv5.getText(), Reflection.getOrCreateKotlinClass(WatchResponse.class));
                watchRes = (WatchResponse) safe2;
                if (watchRes == null) {
                    throw new ErrorLoadingException("Failed to load episodes");
                }
                anilistId = res2.getAnilistId();
                if (anilistId != null) {
                    int it4 = anilistId.intValue();
                    c00012.L$0 = url4;
                    c00012.L$1 = res2;
                    c00012.L$2 = posterUrl3;
                    c00012.L$3 = backgroundUrl3;
                    c00012.L$4 = description2;
                    c00012.L$5 = logoUrl3;
                    c00012.L$6 = watchUrl2;
                    c00012.L$7 = SpillingKt.nullOutSpilledVariable(description3);
                    c00012.L$8 = watchRes;
                    c00012.I$0 = it4;
                    c00012.label = 3;
                    description4 = logoUrl3;
                    backgroundUrl6 = description2;
                    posterUrl5 = backgroundUrl3;
                    title7 = posterUrl3;
                    C00011 c00016 = c00012;
                    res4 = res2;
                    url6 = url4;
                    logoUrl6 = watchUrl2;
                    $result = Requests.get$default(MainActivityKt.getApp(), "https://api.ani.zip/mappings?anilist_id=" + it4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00016, 4094, (Object) null);
                    c00012 = c00016;
                    if ($result == obj) {
                        return obj;
                    }
                    watchRes3 = watchRes;
                    watchUrl3 = description3;
                    posterUrl6 = posterUrl5;
                    url7 = url6;
                    title8 = title7;
                    backgroundUrl7 = backgroundUrl6;
                    res5 = res4;
                    logoUrl7 = logoUrl6;
                    description5 = description4;
                    NiceResponse this_$iv6 = (NiceResponse) $result;
                    ResponseParser parser6 = this_$iv6.getParser();
                    Intrinsics.checkNotNull(parser6);
                    safe3 = parser6.parseSafe(this_$iv6.getText(), Reflection.getOrCreateKotlinClass(AniZipResponse.class));
                    aniZipResponse = (AniZipResponse) safe3;
                    watchRes2 = watchRes3;
                    logoUrl4 = logoUrl7;
                    logoUrl5 = description5;
                    backgroundUrl4 = backgroundUrl7;
                    backgroundUrl5 = posterUrl6;
                    title6 = title8;
                    res3 = res5;
                    url5 = url7;
                    posterUrl4 = watchUrl3;
                } else {
                    String logoUrl9 = watchUrl2;
                    String description7 = logoUrl3;
                    String backgroundUrl9 = description2;
                    String posterUrl8 = backgroundUrl3;
                    String title12 = posterUrl3;
                    watchRes2 = watchRes;
                    aniZipResponse = null;
                    posterUrl4 = description3;
                    url5 = url4;
                    title6 = title12;
                    logoUrl4 = logoUrl9;
                    logoUrl5 = description7;
                    res3 = res2;
                    backgroundUrl4 = backgroundUrl9;
                    backgroundUrl5 = posterUrl8;
                }
                anizipRes = aniZipResponse;
                servers = watchRes2.getServers();
                if (servers != null) {
                    watchRes4 = watchRes2;
                    listEmptyList = CollectionsKt.emptyList();
                } else {
                    watchRes4 = watchRes2;
                    listEmptyList = CollectionsKt.emptyList();
                }
                dubProviders = listEmptyList;
                servers2 = watchRes4.getServers();
                if (servers2 != null) {
                    title9 = title6;
                    listEmptyList2 = CollectionsKt.emptyList();
                } else {
                    title9 = title6;
                    listEmptyList2 = CollectionsKt.emptyList();
                }
                subProviders = listEmptyList2;
                episodes = watchRes4.getEpisodes();
                if (episodes != null) {
                    $this$map$iv2 = episodes;
                    $i$f$map3 = 0;
                    destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                    $this$mapTo$iv$iv2 = $this$map$iv2;
                    $i$f$mapTo2 = 0;
                    while (r13.hasNext()) {
                        final Episode ep3 = (Episode) item$iv$iv;
                        if (anizipRes != null) {
                            anizipEp2 = null;
                        } else {
                            anizipEp2 = null;
                        }
                        Anilight anilight3 = this;
                        Iterable $this$map$iv5 = $this$map$iv2;
                        AppUtils appUtils3 = AppUtils.INSTANCE;
                        String url11 = url5;
                        id2 = watchRes4.getId();
                        if (id2 != null) {
                            $i$f$map4 = id2.intValue();
                        } else {
                            $i$f$map4 = 0;
                        }
                        number2 = ep3.getNumber();
                        if (number2 != null) {
                            iIntValue2 = number2.intValue();
                        } else {
                            iIntValue2 = 0;
                        }
                        destination$iv$iv2.add(MainAPIKt.newEpisode(anilight3, appUtils3.toJson(new LinkData($i$f$map4, iIntValue2, subProviders, "sub")), new Function1() { // from class: com.anilight.Anilight$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj2) {
                                return Anilight.load$lambda$3$0(ep3, anizipEp2, (Episode) obj2);
                            }
                        }));
                        $this$map$iv2 = $this$map$iv5;
                        url5 = url11;
                        $i$f$map3 = $i$f$map3;
                        $this$mapTo$iv$iv2 = $this$mapTo$iv$iv2;
                        $i$f$mapTo2 = $i$f$mapTo2;
                    }
                    url8 = url5;
                    subEpisodes = (List) destination$iv$iv2;
                } else {
                    url8 = url5;
                    subEpisodes = CollectionsKt.emptyList();
                }
                episodes2 = watchRes4.getEpisodes();
                if (episodes2 != null) {
                    $this$map$iv = episodes2;
                    $i$f$map = 0;
                    destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    $this$mapTo$iv$iv = $this$map$iv;
                    $i$f$mapTo = 0;
                    while (r8.hasNext()) {
                        final Episode ep4 = (Episode) item$iv$iv2;
                        if (anizipRes != null) {
                            anizipEp = null;
                        } else {
                            anizipEp = null;
                        }
                        Anilight anilight4 = this;
                        List subProviders5 = subProviders;
                        AppUtils appUtils4 = AppUtils.INSTANCE;
                        Iterable $this$map$iv6 = $this$map$iv;
                        id = watchRes4.getId();
                        if (id != null) {
                            $i$f$map2 = id.intValue();
                        } else {
                            $i$f$map2 = 0;
                        }
                        number = ep4.getNumber();
                        if (number != null) {
                            iIntValue = number.intValue();
                        } else {
                            iIntValue = 0;
                        }
                        destination$iv$iv.add(MainAPIKt.newEpisode(anilight4, appUtils4.toJson(new LinkData($i$f$map2, iIntValue, dubProviders, "dub")), new Function1() { // from class: com.anilight.Anilight$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj2) {
                                return Anilight.load$lambda$4$0(ep4, anizipEp, (Episode) obj2);
                            }
                        }));
                        $this$map$iv = $this$map$iv6;
                        $i$f$map = $i$f$map;
                        $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                        $i$f$mapTo = $i$f$mapTo;
                        subProviders = subProviders5;
                    }
                    subProviders2 = subProviders;
                    dubEpisodes = (List) destination$iv$iv;
                } else {
                    subProviders2 = subProviders;
                    dubEpisodes = CollectionsKt.emptyList();
                }
                TvType tvType2 = TvType.Anime;
                C00022 c00023 = new C00022(subProviders2, subEpisodes, dubProviders, dubEpisodes, backgroundUrl5, backgroundUrl4, logoUrl4, logoUrl5, res3, anizipRes, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url8);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(res3);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(title9);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(backgroundUrl5);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(backgroundUrl4);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(logoUrl5);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(logoUrl4);
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(posterUrl4);
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(watchRes4);
                c00012.L$9 = SpillingKt.nullOutSpilledVariable(anizipRes);
                c00012.L$10 = SpillingKt.nullOutSpilledVariable(dubProviders);
                c00012.L$11 = SpillingKt.nullOutSpilledVariable(subProviders2);
                c00012.L$12 = SpillingKt.nullOutSpilledVariable(subEpisodes);
                c00012.L$13 = SpillingKt.nullOutSpilledVariable(dubEpisodes);
                c00012.label = 4;
                $result = MainAPIKt.newAnimeLoadResponse$default(this, title9, url8, tvType2, false, c00023, c00012, 8, (Object) null);
                if ($result == obj) {
                    return obj;
                }
                return $result;
            case 2:
                String watchUrl4 = (String) c00012.L$7;
                String logoUrl10 = (String) c00012.L$6;
                String description8 = (String) c00012.L$5;
                String backgroundUrl10 = (String) c00012.L$4;
                String posterUrl9 = (String) c00012.L$3;
                String title13 = (String) c00012.L$2;
                DetailResponse res6 = (DetailResponse) c00012.L$1;
                String url12 = (String) c00012.L$0;
                ResultKt.throwOnFailure($result);
                description3 = watchUrl4;
                obj = coroutine_suspended;
                watchUrl2 = logoUrl10;
                logoUrl3 = description8;
                description2 = backgroundUrl10;
                backgroundUrl3 = posterUrl9;
                posterUrl3 = title13;
                res2 = res6;
                url4 = url12;
                NiceResponse this_$iv7 = (NiceResponse) $result;
                ResponseParser parser7 = this_$iv7.getParser();
                Intrinsics.checkNotNull(parser7);
                safe2 = parser7.parseSafe(this_$iv7.getText(), Reflection.getOrCreateKotlinClass(WatchResponse.class));
                watchRes = (WatchResponse) safe2;
                if (watchRes == null) {
                    throw new ErrorLoadingException("Failed to load episodes");
                }
                anilistId = res2.getAnilistId();
                if (anilistId != null) {
                    int it5 = anilistId.intValue();
                    c00012.L$0 = url4;
                    c00012.L$1 = res2;
                    c00012.L$2 = posterUrl3;
                    c00012.L$3 = backgroundUrl3;
                    c00012.L$4 = description2;
                    c00012.L$5 = logoUrl3;
                    c00012.L$6 = watchUrl2;
                    c00012.L$7 = SpillingKt.nullOutSpilledVariable(description3);
                    c00012.L$8 = watchRes;
                    c00012.I$0 = it5;
                    c00012.label = 3;
                    description4 = logoUrl3;
                    backgroundUrl6 = description2;
                    posterUrl5 = backgroundUrl3;
                    title7 = posterUrl3;
                    C00011 c00017 = c00012;
                    res4 = res2;
                    url6 = url4;
                    logoUrl6 = watchUrl2;
                    $result = Requests.get$default(MainActivityKt.getApp(), "https://api.ani.zip/mappings?anilist_id=" + it5, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00017, 4094, (Object) null);
                    c00012 = c00017;
                    if ($result == obj) {
                        return obj;
                    }
                    watchRes3 = watchRes;
                    watchUrl3 = description3;
                    posterUrl6 = posterUrl5;
                    url7 = url6;
                    title8 = title7;
                    backgroundUrl7 = backgroundUrl6;
                    res5 = res4;
                    logoUrl7 = logoUrl6;
                    description5 = description4;
                    NiceResponse this_$iv8 = (NiceResponse) $result;
                    ResponseParser parser8 = this_$iv8.getParser();
                    Intrinsics.checkNotNull(parser8);
                    safe3 = parser8.parseSafe(this_$iv8.getText(), Reflection.getOrCreateKotlinClass(AniZipResponse.class));
                    aniZipResponse = (AniZipResponse) safe3;
                    watchRes2 = watchRes3;
                    logoUrl4 = logoUrl7;
                    logoUrl5 = description5;
                    backgroundUrl4 = backgroundUrl7;
                    backgroundUrl5 = posterUrl6;
                    title6 = title8;
                    res3 = res5;
                    url5 = url7;
                    posterUrl4 = watchUrl3;
                } else {
                    String logoUrl11 = watchUrl2;
                    String description9 = logoUrl3;
                    String backgroundUrl11 = description2;
                    String posterUrl10 = backgroundUrl3;
                    String title14 = posterUrl3;
                    watchRes2 = watchRes;
                    aniZipResponse = null;
                    posterUrl4 = description3;
                    url5 = url4;
                    title6 = title14;
                    logoUrl4 = logoUrl11;
                    logoUrl5 = description9;
                    res3 = res2;
                    backgroundUrl4 = backgroundUrl11;
                    backgroundUrl5 = posterUrl10;
                }
                anizipRes = aniZipResponse;
                servers = watchRes2.getServers();
                if (servers != null) {
                    watchRes4 = watchRes2;
                    listEmptyList = CollectionsKt.emptyList();
                } else {
                    watchRes4 = watchRes2;
                    listEmptyList = CollectionsKt.emptyList();
                }
                dubProviders = listEmptyList;
                servers2 = watchRes4.getServers();
                if (servers2 != null) {
                    title9 = title6;
                    listEmptyList2 = CollectionsKt.emptyList();
                } else {
                    title9 = title6;
                    listEmptyList2 = CollectionsKt.emptyList();
                }
                subProviders = listEmptyList2;
                episodes = watchRes4.getEpisodes();
                if (episodes != null) {
                    $this$map$iv2 = episodes;
                    $i$f$map3 = 0;
                    destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                    $this$mapTo$iv$iv2 = $this$map$iv2;
                    $i$f$mapTo2 = 0;
                    while (r13.hasNext()) {
                        final Episode ep5 = (Episode) item$iv$iv;
                        if (anizipRes != null) {
                            anizipEp2 = null;
                        } else {
                            anizipEp2 = null;
                        }
                        Anilight anilight5 = this;
                        Iterable $this$map$iv7 = $this$map$iv2;
                        AppUtils appUtils5 = AppUtils.INSTANCE;
                        String url13 = url5;
                        id2 = watchRes4.getId();
                        if (id2 != null) {
                            $i$f$map4 = id2.intValue();
                        } else {
                            $i$f$map4 = 0;
                        }
                        number2 = ep5.getNumber();
                        if (number2 != null) {
                            iIntValue2 = number2.intValue();
                        } else {
                            iIntValue2 = 0;
                        }
                        destination$iv$iv2.add(MainAPIKt.newEpisode(anilight5, appUtils5.toJson(new LinkData($i$f$map4, iIntValue2, subProviders, "sub")), new Function1() { // from class: com.anilight.Anilight$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj2) {
                                return Anilight.load$lambda$3$0(ep5, anizipEp2, (Episode) obj2);
                            }
                        }));
                        $this$map$iv2 = $this$map$iv7;
                        url5 = url13;
                        $i$f$map3 = $i$f$map3;
                        $this$mapTo$iv$iv2 = $this$mapTo$iv$iv2;
                        $i$f$mapTo2 = $i$f$mapTo2;
                    }
                    url8 = url5;
                    subEpisodes = (List) destination$iv$iv2;
                } else {
                    url8 = url5;
                    subEpisodes = CollectionsKt.emptyList();
                }
                episodes2 = watchRes4.getEpisodes();
                if (episodes2 != null) {
                    $this$map$iv = episodes2;
                    $i$f$map = 0;
                    destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    $this$mapTo$iv$iv = $this$map$iv;
                    $i$f$mapTo = 0;
                    while (r8.hasNext()) {
                        final Episode ep6 = (Episode) item$iv$iv2;
                        if (anizipRes != null) {
                            anizipEp = null;
                        } else {
                            anizipEp = null;
                        }
                        Anilight anilight6 = this;
                        List subProviders6 = subProviders;
                        AppUtils appUtils6 = AppUtils.INSTANCE;
                        Iterable $this$map$iv8 = $this$map$iv;
                        id = watchRes4.getId();
                        if (id != null) {
                            $i$f$map2 = id.intValue();
                        } else {
                            $i$f$map2 = 0;
                        }
                        number = ep6.getNumber();
                        if (number != null) {
                            iIntValue = number.intValue();
                        } else {
                            iIntValue = 0;
                        }
                        destination$iv$iv.add(MainAPIKt.newEpisode(anilight6, appUtils6.toJson(new LinkData($i$f$map2, iIntValue, dubProviders, "dub")), new Function1() { // from class: com.anilight.Anilight$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj2) {
                                return Anilight.load$lambda$4$0(ep6, anizipEp, (Episode) obj2);
                            }
                        }));
                        $this$map$iv = $this$map$iv8;
                        $i$f$map = $i$f$map;
                        $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                        $i$f$mapTo = $i$f$mapTo;
                        subProviders = subProviders6;
                    }
                    subProviders2 = subProviders;
                    dubEpisodes = (List) destination$iv$iv;
                } else {
                    subProviders2 = subProviders;
                    dubEpisodes = CollectionsKt.emptyList();
                }
                TvType tvType3 = TvType.Anime;
                C00022 c00024 = new C00022(subProviders2, subEpisodes, dubProviders, dubEpisodes, backgroundUrl5, backgroundUrl4, logoUrl4, logoUrl5, res3, anizipRes, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url8);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(res3);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(title9);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(backgroundUrl5);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(backgroundUrl4);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(logoUrl5);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(logoUrl4);
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(posterUrl4);
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(watchRes4);
                c00012.L$9 = SpillingKt.nullOutSpilledVariable(anizipRes);
                c00012.L$10 = SpillingKt.nullOutSpilledVariable(dubProviders);
                c00012.L$11 = SpillingKt.nullOutSpilledVariable(subProviders2);
                c00012.L$12 = SpillingKt.nullOutSpilledVariable(subEpisodes);
                c00012.L$13 = SpillingKt.nullOutSpilledVariable(dubEpisodes);
                c00012.label = 4;
                $result = MainAPIKt.newAnimeLoadResponse$default(this, title9, url8, tvType3, false, c00024, c00012, 8, (Object) null);
                if ($result == obj) {
                    return obj;
                }
                return $result;
            case 3:
                int i = c00012.I$0;
                watchRes3 = (WatchResponse) c00012.L$8;
                watchUrl3 = (String) c00012.L$7;
                logoUrl7 = (String) c00012.L$6;
                description5 = (String) c00012.L$5;
                backgroundUrl7 = (String) c00012.L$4;
                posterUrl6 = (String) c00012.L$3;
                title8 = (String) c00012.L$2;
                res5 = (DetailResponse) c00012.L$1;
                url7 = (String) c00012.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                NiceResponse this_$iv9 = (NiceResponse) $result;
                ResponseParser parser9 = this_$iv9.getParser();
                Intrinsics.checkNotNull(parser9);
                safe3 = parser9.parseSafe(this_$iv9.getText(), Reflection.getOrCreateKotlinClass(AniZipResponse.class));
                aniZipResponse = (AniZipResponse) safe3;
                watchRes2 = watchRes3;
                logoUrl4 = logoUrl7;
                logoUrl5 = description5;
                backgroundUrl4 = backgroundUrl7;
                backgroundUrl5 = posterUrl6;
                title6 = title8;
                res3 = res5;
                url5 = url7;
                posterUrl4 = watchUrl3;
                anizipRes = aniZipResponse;
                servers = watchRes2.getServers();
                if (servers != null) {
                    watchRes4 = watchRes2;
                    listEmptyList = CollectionsKt.emptyList();
                } else {
                    watchRes4 = watchRes2;
                    listEmptyList = CollectionsKt.emptyList();
                }
                dubProviders = listEmptyList;
                servers2 = watchRes4.getServers();
                if (servers2 != null) {
                    title9 = title6;
                    listEmptyList2 = CollectionsKt.emptyList();
                } else {
                    title9 = title6;
                    listEmptyList2 = CollectionsKt.emptyList();
                }
                subProviders = listEmptyList2;
                episodes = watchRes4.getEpisodes();
                if (episodes != null) {
                    $this$map$iv2 = episodes;
                    $i$f$map3 = 0;
                    destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                    $this$mapTo$iv$iv2 = $this$map$iv2;
                    $i$f$mapTo2 = 0;
                    while (r13.hasNext()) {
                        final Episode ep7 = (Episode) item$iv$iv;
                        if (anizipRes != null) {
                            anizipEp2 = null;
                        } else {
                            anizipEp2 = null;
                        }
                        Anilight anilight7 = this;
                        Iterable $this$map$iv9 = $this$map$iv2;
                        AppUtils appUtils7 = AppUtils.INSTANCE;
                        String url14 = url5;
                        id2 = watchRes4.getId();
                        if (id2 != null) {
                            $i$f$map4 = id2.intValue();
                        } else {
                            $i$f$map4 = 0;
                        }
                        number2 = ep7.getNumber();
                        if (number2 != null) {
                            iIntValue2 = number2.intValue();
                        } else {
                            iIntValue2 = 0;
                        }
                        destination$iv$iv2.add(MainAPIKt.newEpisode(anilight7, appUtils7.toJson(new LinkData($i$f$map4, iIntValue2, subProviders, "sub")), new Function1() { // from class: com.anilight.Anilight$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj2) {
                                return Anilight.load$lambda$3$0(ep7, anizipEp2, (Episode) obj2);
                            }
                        }));
                        $this$map$iv2 = $this$map$iv9;
                        url5 = url14;
                        $i$f$map3 = $i$f$map3;
                        $this$mapTo$iv$iv2 = $this$mapTo$iv$iv2;
                        $i$f$mapTo2 = $i$f$mapTo2;
                    }
                    url8 = url5;
                    subEpisodes = (List) destination$iv$iv2;
                } else {
                    url8 = url5;
                    subEpisodes = CollectionsKt.emptyList();
                }
                episodes2 = watchRes4.getEpisodes();
                if (episodes2 != null) {
                    $this$map$iv = episodes2;
                    $i$f$map = 0;
                    destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    $this$mapTo$iv$iv = $this$map$iv;
                    $i$f$mapTo = 0;
                    while (r8.hasNext()) {
                        final Episode ep8 = (Episode) item$iv$iv2;
                        if (anizipRes != null) {
                            anizipEp = null;
                        } else {
                            anizipEp = null;
                        }
                        Anilight anilight8 = this;
                        List subProviders7 = subProviders;
                        AppUtils appUtils8 = AppUtils.INSTANCE;
                        Iterable $this$map$iv10 = $this$map$iv;
                        id = watchRes4.getId();
                        if (id != null) {
                            $i$f$map2 = id.intValue();
                        } else {
                            $i$f$map2 = 0;
                        }
                        number = ep8.getNumber();
                        if (number != null) {
                            iIntValue = number.intValue();
                        } else {
                            iIntValue = 0;
                        }
                        destination$iv$iv.add(MainAPIKt.newEpisode(anilight8, appUtils8.toJson(new LinkData($i$f$map2, iIntValue, dubProviders, "dub")), new Function1() { // from class: com.anilight.Anilight$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj2) {
                                return Anilight.load$lambda$4$0(ep8, anizipEp, (Episode) obj2);
                            }
                        }));
                        $this$map$iv = $this$map$iv10;
                        $i$f$map = $i$f$map;
                        $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                        $i$f$mapTo = $i$f$mapTo;
                        subProviders = subProviders7;
                    }
                    subProviders2 = subProviders;
                    dubEpisodes = (List) destination$iv$iv;
                } else {
                    subProviders2 = subProviders;
                    dubEpisodes = CollectionsKt.emptyList();
                }
                TvType tvType4 = TvType.Anime;
                C00022 c00025 = new C00022(subProviders2, subEpisodes, dubProviders, dubEpisodes, backgroundUrl5, backgroundUrl4, logoUrl4, logoUrl5, res3, anizipRes, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url8);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(res3);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(title9);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(backgroundUrl5);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(backgroundUrl4);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(logoUrl5);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(logoUrl4);
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(posterUrl4);
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(watchRes4);
                c00012.L$9 = SpillingKt.nullOutSpilledVariable(anizipRes);
                c00012.L$10 = SpillingKt.nullOutSpilledVariable(dubProviders);
                c00012.L$11 = SpillingKt.nullOutSpilledVariable(subProviders2);
                c00012.L$12 = SpillingKt.nullOutSpilledVariable(subEpisodes);
                c00012.L$13 = SpillingKt.nullOutSpilledVariable(dubEpisodes);
                c00012.label = 4;
                $result = MainAPIKt.newAnimeLoadResponse$default(this, title9, url8, tvType4, false, c00025, c00012, 8, (Object) null);
                if ($result == obj) {
                    return obj;
                }
                return $result;
            case 4:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$3$0(Episode $ep, AniZipEpisode $anizipEp, com.lagradost.cloudstream3.Episode $this$newEpisode) {
        String airDate;
        String it;
        Map<String, String> title;
        Map<String, String> title2;
        String title3 = $ep.getTitle();
        if (title3 == null) {
            title3 = ($anizipEp == null || (title2 = $anizipEp.getTitle()) == null) ? null : title2.get("en");
            if (title3 == null) {
                title3 = ($anizipEp == null || (title = $anizipEp.getTitle()) == null) ? null : title.get("romaji");
            }
        }
        $this$newEpisode.setName(title3);
        $this$newEpisode.setEpisode($ep.getNumber());
        String img = $ep.getImg();
        if (img == null) {
            img = $anizipEp != null ? $anizipEp.getImage() : null;
        }
        $this$newEpisode.setPosterUrl(img);
        String description = $ep.getDescription();
        if (description == null) {
            description = $anizipEp != null ? $anizipEp.getOverview() : null;
        }
        $this$newEpisode.setDescription(description);
        if ($anizipEp != null && (it = $anizipEp.getRating()) != null) {
            $this$newEpisode.setScore(Score.Companion.from10(it));
        }
        if ($anizipEp == null || (airDate = $anizipEp.getAirDateUtc()) == null) {
            airDate = $anizipEp != null ? $anizipEp.getAirDate() : null;
        }
        MainAPIKt.addDate$default($this$newEpisode, airDate, (String) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$4$0(Episode $ep, AniZipEpisode $anizipEp, com.lagradost.cloudstream3.Episode $this$newEpisode) {
        String airDate;
        String it;
        Map<String, String> title;
        Map<String, String> title2;
        String title3 = $ep.getTitle();
        if (title3 == null) {
            title3 = ($anizipEp == null || (title2 = $anizipEp.getTitle()) == null) ? null : title2.get("en");
            if (title3 == null) {
                title3 = ($anizipEp == null || (title = $anizipEp.getTitle()) == null) ? null : title.get("romaji");
            }
        }
        $this$newEpisode.setName(title3);
        $this$newEpisode.setEpisode($ep.getNumber());
        String img = $ep.getImg();
        if (img == null) {
            img = $anizipEp != null ? $anizipEp.getImage() : null;
        }
        $this$newEpisode.setPosterUrl(img);
        String description = $ep.getDescription();
        if (description == null) {
            description = $anizipEp != null ? $anizipEp.getOverview() : null;
        }
        $this$newEpisode.setDescription(description);
        if ($anizipEp != null && (it = $anizipEp.getRating()) != null) {
            $this$newEpisode.setScore(Score.Companion.from10(it));
        }
        if ($anizipEp == null || (airDate = $anizipEp.getAirDateUtc()) == null) {
            airDate = $anizipEp != null ? $anizipEp.getAirDate() : null;
        }
        MainAPIKt.addDate$default($this$newEpisode, airDate, (String) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.anilight.Anilight$load$2 */
    /* JADX INFO: compiled from: Anilight.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/AnimeLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.anilight.Anilight$load$2", f = "Anilight.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nAnilight.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Anilight.kt\ncom/anilight/Anilight$load$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,303:1\n1#2:304\n*E\n"})
    static final class C00022 extends SuspendLambda implements Function2<AnimeLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ AniZipResponse $anizipRes;
        final /* synthetic */ String $backgroundUrl;
        final /* synthetic */ String $description;
        final /* synthetic */ List<com.lagradost.cloudstream3.Episode> $dubEpisodes;
        final /* synthetic */ List<ProviderInfo> $dubProviders;
        final /* synthetic */ String $logoUrl;
        final /* synthetic */ String $posterUrl;
        final /* synthetic */ DetailResponse $res;
        final /* synthetic */ List<com.lagradost.cloudstream3.Episode> $subEpisodes;
        final /* synthetic */ List<ProviderInfo> $subProviders;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00022(List<ProviderInfo> list, List<com.lagradost.cloudstream3.Episode> list2, List<ProviderInfo> list3, List<com.lagradost.cloudstream3.Episode> list4, String str, String str2, String str3, String str4, DetailResponse detailResponse, AniZipResponse aniZipResponse, Continuation<? super C00022> continuation) {
            super(2, continuation);
            this.$subProviders = list;
            this.$subEpisodes = list2;
            this.$dubProviders = list3;
            this.$dubEpisodes = list4;
            this.$posterUrl = str;
            this.$backgroundUrl = str2;
            this.$logoUrl = str3;
            this.$description = str4;
            this.$res = detailResponse;
            this.$anizipRes = aniZipResponse;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00022 = new C00022(this.$subProviders, this.$subEpisodes, this.$dubProviders, this.$dubEpisodes, this.$posterUrl, this.$backgroundUrl, this.$logoUrl, this.$description, this.$res, this.$anizipRes, continuation);
            c00022.L$0 = obj;
            return c00022;
        }

        public final Object invoke(AnimeLoadResponse animeLoadResponse, Continuation<? super Unit> continuation) {
            return create(animeLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            AniZipMappings mappings;
            Integer mal_id;
            AniZipMappings mappings2;
            Integer anilist_id;
            LoadResponse loadResponse = (AnimeLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    if (!this.$subProviders.isEmpty()) {
                        MainAPIKt.addEpisodes(loadResponse, DubStatus.Subbed, this.$subEpisodes);
                    }
                    if (!this.$dubProviders.isEmpty()) {
                        MainAPIKt.addEpisodes(loadResponse, DubStatus.Dubbed, this.$dubEpisodes);
                    }
                    loadResponse.setPosterUrl(this.$posterUrl);
                    loadResponse.setBackgroundPosterUrl(this.$backgroundUrl);
                    try {
                        loadResponse.setLogoUrl(this.$logoUrl);
                        break;
                    } catch (Throwable th) {
                    }
                    loadResponse.setPlot(this.$description);
                    loadResponse.setTags(this.$res.getGenres());
                    Integer idMal = this.$res.getIdMal();
                    if (idMal != null) {
                        int it = idMal.intValue();
                        LoadResponse.Companion.addMalId(loadResponse, Boxing.boxInt(it));
                    } else {
                        AniZipResponse aniZipResponse = this.$anizipRes;
                        if (aniZipResponse != null && (mappings = aniZipResponse.getMappings()) != null && (mal_id = mappings.getMal_id()) != null) {
                            int it2 = mal_id.intValue();
                            LoadResponse.Companion.addMalId(loadResponse, Boxing.boxInt(it2));
                        }
                    }
                    Integer anilistId = this.$res.getAnilistId();
                    if (anilistId != null) {
                        int it3 = anilistId.intValue();
                        LoadResponse.Companion.addAniListId(loadResponse, Boxing.boxInt(it3));
                    } else {
                        AniZipResponse aniZipResponse2 = this.$anizipRes;
                        if (aniZipResponse2 != null && (mappings2 = aniZipResponse2.getMappings()) != null && (anilist_id = mappings2.getAnilist_id()) != null) {
                            int it4 = anilist_id.intValue();
                            LoadResponse.Companion.addAniListId(loadResponse, Boxing.boxInt(it4));
                        }
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00031 c00031;
        Object obj;
        Object objDecodeFromString;
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
                AppUtils appUtils = AppUtils.INSTANCE;
                try {
                    Result.Companion companion = Result.Companion;
                    KType kTypeTypeOf = Reflection.typeOf(LinkData.class);
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (Result.exceptionOrNull-impl(obj) != null) {
                    try {
                        Result.Companion companion3 = Result.Companion;
                        obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(LinkData.class), (List) null, 2, (Object) null));
                    } catch (Throwable th2) {
                        Result.Companion companion4 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th2));
                    }
                }
                if (Result.isFailure-impl(obj)) {
                    obj = null;
                }
                DeserializationStrategy deserializationStrategy = (KSerializer) obj;
                if (deserializationStrategy != null) {
                    try {
                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, data);
                    } catch (SerializationException e) {
                        ArchComponentExtKt.logError(e);
                        ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv.readValue(data, new TypeReference<LinkData>() { // from class: com.anilight.Anilight$loadLinks$$inlined$parseJson$1
                        });
                    } catch (Throwable th3) {
                        ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv2.readValue(data, new TypeReference<LinkData>() { // from class: com.anilight.Anilight$loadLinks$$inlined$parseJson$1
                        });
                    }
                } else {
                    ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv3.readValue(data, new TypeReference<LinkData>() { // from class: com.anilight.Anilight$loadLinks$$inlined$parseJson$1
                    });
                }
                LinkData parsedData = (LinkData) objDecodeFromString;
                List<ProviderInfo> providers = parsedData.getProviders();
                C00042 c00042 = new C00042(parsedData, function1, function2, null);
                c00032.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                c00032.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                c00032.L$3 = SpillingKt.nullOutSpilledVariable(parsedData);
                c00032.Z$0 = isCasting;
                c00032.label = 1;
                if (ParCollectionsKt.amap(providers, c00042, c00032) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                boolean z = c00032.Z$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Boxing.boxBoolean(true);
    }

    /* JADX INFO: renamed from: com.anilight.Anilight$loadLinks$2 */
    /* JADX INFO: compiled from: Anilight.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "provider", "Lcom/anilight/Anilight$ProviderInfo;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.anilight.Anilight$loadLinks$2", f = "Anilight.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2}, l = {135, 140, 152}, m = "invokeSuspend", n = {"provider", "url", "provider", "url", "res", "$this$forEach$iv", "element$iv", "track", "provider", "url", "res", "$this$forEach$iv", "element$iv", "source", "nameStr"}, nl = {304, 139, 151}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$7", "L$8", "L$10"}, v = 2)
    @SourceDebugExtension({"SMAP\nAnilight.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Anilight.kt\ncom/anilight/Anilight$loadLinks$2\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,303:1\n73#2,5:304\n2068#3,2:309\n2068#3:311\n2069#3:313\n1#4:312\n*S KotlinDebug\n*F\n+ 1 Anilight.kt\ncom/anilight/Anilight$loadLinks$2\n*L\n135#1:304,5\n137#1:309,2\n148#1:311\n148#1:313\n*E\n"})
    static final class C00042 extends SuspendLambda implements Function2<ProviderInfo, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ LinkData $parsedData;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$10;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00042(LinkData linkData, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00042> continuation) {
            super(2, continuation);
            this.$parsedData = linkData;
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00042 = new C00042(this.$parsedData, this.$subtitleCallback, this.$callback, continuation);
            c00042.L$0 = obj;
            return c00042;
        }

        public final Object invoke(ProviderInfo providerInfo, Continuation<? super Unit> continuation) {
            return create(providerInfo, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:24:0x014f  */
        /* JADX WARN: Code duplicated, block: B:26:0x015d  */
        /* JADX WARN: Code duplicated, block: B:28:0x0169  */
        /* JADX WARN: Code duplicated, block: B:34:0x0181  */
        /* JADX WARN: Code duplicated, block: B:39:0x01c2 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:40:0x01c3  */
        /* JADX WARN: Code duplicated, block: B:42:0x01cb  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x01c3 -> B:41:0x01c4). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:96:0x0399 -> B:97:0x03a6). Please report as a decompilation issue!!! */
        /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
            java.lang.StackOverflowError
            	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
            	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
            */
        public final java.lang.Object invokeSuspend(java.lang.Object r36) {
            /*
                Method dump skipped, instruction units count: 1000
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.anilight.Anilight.C00042.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: compiled from: Anilight.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0014\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\tHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/anilight/Anilight$LinkData;", "", "id", "", "epNum", "providers", "", "Lcom/anilight/Anilight$ProviderInfo;", "type", "", "<init>", "(IILjava/util/List;Ljava/lang/String;)V", "getId", "()I", "getEpNum", "getProviders", "()Ljava/util/List;", "getType", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "Anilight"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class LinkData {
        private final int epNum;
        private final int id;

        @NotNull
        private final List<ProviderInfo> providers;

        @NotNull
        private final String type;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ LinkData copy$default(LinkData linkData, int i, int i2, List list, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = linkData.id;
            }
            if ((i3 & 2) != 0) {
                i2 = linkData.epNum;
            }
            if ((i3 & 4) != 0) {
                list = linkData.providers;
            }
            if ((i3 & 8) != 0) {
                str = linkData.type;
            }
            return linkData.copy(i, i2, list, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getEpNum() {
            return this.epNum;
        }

        @NotNull
        public final List<ProviderInfo> component3() {
            return this.providers;
        }

        @NotNull
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @NotNull
        public final LinkData copy(int id, int epNum, @NotNull List<ProviderInfo> providers, @NotNull String type) {
            return new LinkData(id, epNum, providers, type);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LinkData)) {
                return false;
            }
            LinkData linkData = (LinkData) other;
            return this.id == linkData.id && this.epNum == linkData.epNum && Intrinsics.areEqual(this.providers, linkData.providers) && Intrinsics.areEqual(this.type, linkData.type);
        }

        public int hashCode() {
            return (((((this.id * 31) + this.epNum) * 31) + this.providers.hashCode()) * 31) + this.type.hashCode();
        }

        @NotNull
        public String toString() {
            return "LinkData(id=" + this.id + ", epNum=" + this.epNum + ", providers=" + this.providers + ", type=" + this.type + ')';
        }

        public LinkData(int id, int epNum, @NotNull List<ProviderInfo> list, @NotNull String type) {
            this.id = id;
            this.epNum = epNum;
            this.providers = list;
            this.type = type;
        }

        public final int getId() {
            return this.id;
        }

        public final int getEpNum() {
            return this.epNum;
        }

        @NotNull
        public final List<ProviderInfo> getProviders() {
            return this.providers;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }
    }

    /* JADX INFO: compiled from: Anilight.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/anilight/Anilight$ProviderInfo;", "", "id", "", "tip", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getTip", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Anilight"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class ProviderInfo {

        @NotNull
        private final String id;

        @NotNull
        private final String tip;

        public static /* synthetic */ ProviderInfo copy$default(ProviderInfo providerInfo, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = providerInfo.id;
            }
            if ((i & 2) != 0) {
                str2 = providerInfo.tip;
            }
            return providerInfo.copy(str, str2);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTip() {
            return this.tip;
        }

        @NotNull
        public final ProviderInfo copy(@NotNull String id, @NotNull String tip) {
            return new ProviderInfo(id, tip);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ProviderInfo)) {
                return false;
            }
            ProviderInfo providerInfo = (ProviderInfo) other;
            return Intrinsics.areEqual(this.id, providerInfo.id) && Intrinsics.areEqual(this.tip, providerInfo.tip);
        }

        public int hashCode() {
            return (this.id.hashCode() * 31) + this.tip.hashCode();
        }

        @NotNull
        public String toString() {
            return "ProviderInfo(id=" + this.id + ", tip=" + this.tip + ')';
        }

        public ProviderInfo(@NotNull String id, @NotNull String tip) {
            this.id = id;
            this.tip = tip;
        }

        @NotNull
        public final String getId() {
            return this.id;
        }

        @NotNull
        public final String getTip() {
            return this.tip;
        }
    }

    /* JADX INFO: compiled from: Anilight.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/anilight/Anilight$FilterResponse;", "", "pageInfo", "Lcom/anilight/Anilight$PageInfo;", "media", "", "Lcom/anilight/Anilight$Media;", "<init>", "(Lcom/anilight/Anilight$PageInfo;Ljava/util/List;)V", "getPageInfo", "()Lcom/anilight/Anilight$PageInfo;", "getMedia", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Anilight"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class FilterResponse {

        @Nullable
        private final List<Media> media;

        @Nullable
        private final PageInfo pageInfo;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ FilterResponse copy$default(FilterResponse filterResponse, PageInfo pageInfo, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                pageInfo = filterResponse.pageInfo;
            }
            if ((i & 2) != 0) {
                list = filterResponse.media;
            }
            return filterResponse.copy(pageInfo, list);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final PageInfo getPageInfo() {
            return this.pageInfo;
        }

        @Nullable
        public final List<Media> component2() {
            return this.media;
        }

        @NotNull
        public final FilterResponse copy(@Nullable PageInfo pageInfo, @Nullable List<Media> media) {
            return new FilterResponse(pageInfo, media);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FilterResponse)) {
                return false;
            }
            FilterResponse filterResponse = (FilterResponse) other;
            return Intrinsics.areEqual(this.pageInfo, filterResponse.pageInfo) && Intrinsics.areEqual(this.media, filterResponse.media);
        }

        public int hashCode() {
            return ((this.pageInfo == null ? 0 : this.pageInfo.hashCode()) * 31) + (this.media != null ? this.media.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "FilterResponse(pageInfo=" + this.pageInfo + ", media=" + this.media + ')';
        }

        public FilterResponse(@Nullable PageInfo pageInfo, @Nullable List<Media> list) {
            this.pageInfo = pageInfo;
            this.media = list;
        }

        @Nullable
        public final PageInfo getPageInfo() {
            return this.pageInfo;
        }

        @Nullable
        public final List<Media> getMedia() {
            return this.media;
        }
    }

    /* JADX INFO: compiled from: Anilight.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ&\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/anilight/Anilight$PageInfo;", "", "hasNextPage", "", "total", "", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getHasNextPage", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTotal", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/anilight/Anilight$PageInfo;", "equals", "other", "hashCode", "toString", "", "Anilight"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class PageInfo {

        @Nullable
        private final Boolean hasNextPage;

        @Nullable
        private final Integer total;

        public static /* synthetic */ PageInfo copy$default(PageInfo pageInfo, Boolean bool, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = pageInfo.hasNextPage;
            }
            if ((i & 2) != 0) {
                num = pageInfo.total;
            }
            return pageInfo.copy(bool, num);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Boolean getHasNextPage() {
            return this.hasNextPage;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getTotal() {
            return this.total;
        }

        @NotNull
        public final PageInfo copy(@Nullable Boolean hasNextPage, @Nullable Integer total) {
            return new PageInfo(hasNextPage, total);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PageInfo)) {
                return false;
            }
            PageInfo pageInfo = (PageInfo) other;
            return Intrinsics.areEqual(this.hasNextPage, pageInfo.hasNextPage) && Intrinsics.areEqual(this.total, pageInfo.total);
        }

        public int hashCode() {
            return ((this.hasNextPage == null ? 0 : this.hasNextPage.hashCode()) * 31) + (this.total != null ? this.total.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "PageInfo(hasNextPage=" + this.hasNextPage + ", total=" + this.total + ')';
        }

        public PageInfo(@Nullable Boolean hasNextPage, @Nullable Integer total) {
            this.hasNextPage = hasNextPage;
            this.total = total;
        }

        @Nullable
        public final Boolean getHasNextPage() {
            return this.hasNextPage;
        }

        @Nullable
        public final Integer getTotal() {
            return this.total;
        }
    }

    /* JADX INFO: compiled from: Anilight.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\rHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u008c\u0001\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00100J\u0014\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00104\u001a\u00020\u0003HÖ\u0081\u0004J\n\u00105\u001a\u00020\u0005HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0019\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b#\u0010\u0015R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b$\u0010\u0015¨\u00066"}, d2 = {"Lcom/anilight/Anilight$Media;", "", "id", "", "slug", "", "title", "Lcom/anilight/Anilight$Title;", "coverImage", "Lcom/anilight/Anilight$CoverImage;", "bannerImage", "description", "genres", "", "tmdb", "Lcom/anilight/Anilight$Tmdb;", "episodes", "averageScore", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/anilight/Anilight$Title;Lcom/anilight/Anilight$CoverImage;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/anilight/Anilight$Tmdb;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSlug", "()Ljava/lang/String;", "getTitle", "()Lcom/anilight/Anilight$Title;", "getCoverImage", "()Lcom/anilight/Anilight$CoverImage;", "getBannerImage", "getDescription", "getGenres", "()Ljava/util/List;", "getTmdb", "()Lcom/anilight/Anilight$Tmdb;", "getEpisodes", "getAverageScore", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/anilight/Anilight$Title;Lcom/anilight/Anilight$CoverImage;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/anilight/Anilight$Tmdb;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/anilight/Anilight$Media;", "equals", "", "other", "hashCode", "toString", "Anilight"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Media {

        @Nullable
        private final Integer averageScore;

        @Nullable
        private final String bannerImage;

        @Nullable
        private final CoverImage coverImage;

        @Nullable
        private final String description;

        @Nullable
        private final Integer episodes;

        @Nullable
        private final List<String> genres;

        @Nullable
        private final Integer id;

        @Nullable
        private final String slug;

        @Nullable
        private final Title title;

        @Nullable
        private final Tmdb tmdb;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Media copy$default(Media media, Integer num, String str, Title title, CoverImage coverImage, String str2, String str3, List list, Tmdb tmdb, Integer num2, Integer num3, int i, Object obj) {
            if ((i & 1) != 0) {
                num = media.id;
            }
            if ((i & 2) != 0) {
                str = media.slug;
            }
            if ((i & 4) != 0) {
                title = media.title;
            }
            if ((i & 8) != 0) {
                coverImage = media.coverImage;
            }
            if ((i & 16) != 0) {
                str2 = media.bannerImage;
            }
            if ((i & 32) != 0) {
                str3 = media.description;
            }
            if ((i & 64) != 0) {
                list = media.genres;
            }
            if ((i & 128) != 0) {
                tmdb = media.tmdb;
            }
            if ((i & 256) != 0) {
                num2 = media.episodes;
            }
            if ((i & 512) != 0) {
                num3 = media.averageScore;
            }
            Integer num4 = num2;
            Integer num5 = num3;
            List list2 = list;
            Tmdb tmdb2 = tmdb;
            String str4 = str2;
            String str5 = str3;
            return media.copy(num, str, title, coverImage, str4, str5, list2, tmdb2, num4, num5);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final Integer getAverageScore() {
            return this.averageScore;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getSlug() {
            return this.slug;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Title getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final CoverImage getCoverImage() {
            return this.coverImage;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getBannerImage() {
            return this.bannerImage;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        public final List<String> component7() {
            return this.genres;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Tmdb getTmdb() {
            return this.tmdb;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Integer getEpisodes() {
            return this.episodes;
        }

        @NotNull
        public final Media copy(@Nullable Integer id, @Nullable String slug, @Nullable Title title, @Nullable CoverImage coverImage, @Nullable String bannerImage, @Nullable String description, @Nullable List<String> genres, @Nullable Tmdb tmdb, @Nullable Integer episodes, @Nullable Integer averageScore) {
            return new Media(id, slug, title, coverImage, bannerImage, description, genres, tmdb, episodes, averageScore);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Media)) {
                return false;
            }
            Media media = (Media) other;
            return Intrinsics.areEqual(this.id, media.id) && Intrinsics.areEqual(this.slug, media.slug) && Intrinsics.areEqual(this.title, media.title) && Intrinsics.areEqual(this.coverImage, media.coverImage) && Intrinsics.areEqual(this.bannerImage, media.bannerImage) && Intrinsics.areEqual(this.description, media.description) && Intrinsics.areEqual(this.genres, media.genres) && Intrinsics.areEqual(this.tmdb, media.tmdb) && Intrinsics.areEqual(this.episodes, media.episodes) && Intrinsics.areEqual(this.averageScore, media.averageScore);
        }

        public int hashCode() {
            return ((((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.slug == null ? 0 : this.slug.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.coverImage == null ? 0 : this.coverImage.hashCode())) * 31) + (this.bannerImage == null ? 0 : this.bannerImage.hashCode())) * 31) + (this.description == null ? 0 : this.description.hashCode())) * 31) + (this.genres == null ? 0 : this.genres.hashCode())) * 31) + (this.tmdb == null ? 0 : this.tmdb.hashCode())) * 31) + (this.episodes == null ? 0 : this.episodes.hashCode())) * 31) + (this.averageScore != null ? this.averageScore.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Media(id=" + this.id + ", slug=" + this.slug + ", title=" + this.title + ", coverImage=" + this.coverImage + ", bannerImage=" + this.bannerImage + ", description=" + this.description + ", genres=" + this.genres + ", tmdb=" + this.tmdb + ", episodes=" + this.episodes + ", averageScore=" + this.averageScore + ')';
        }

        public Media(@Nullable Integer id, @Nullable String slug, @Nullable Title title, @Nullable CoverImage coverImage, @Nullable String bannerImage, @Nullable String description, @Nullable List<String> list, @Nullable Tmdb tmdb, @Nullable Integer episodes, @Nullable Integer averageScore) {
            this.id = id;
            this.slug = slug;
            this.title = title;
            this.coverImage = coverImage;
            this.bannerImage = bannerImage;
            this.description = description;
            this.genres = list;
            this.tmdb = tmdb;
            this.episodes = episodes;
            this.averageScore = averageScore;
        }

        @Nullable
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        public final String getSlug() {
            return this.slug;
        }

        @Nullable
        public final Title getTitle() {
            return this.title;
        }

        @Nullable
        public final CoverImage getCoverImage() {
            return this.coverImage;
        }

        @Nullable
        public final String getBannerImage() {
            return this.bannerImage;
        }

        @Nullable
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        public final List<String> getGenres() {
            return this.genres;
        }

        @Nullable
        public final Tmdb getTmdb() {
            return this.tmdb;
        }

        @Nullable
        public final Integer getEpisodes() {
            return this.episodes;
        }

        @Nullable
        public final Integer getAverageScore() {
            return this.averageScore;
        }
    }

    /* JADX INFO: compiled from: Anilight.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/anilight/Anilight$Title;", "", "romaji", "", "english", "native", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getRomaji", "()Ljava/lang/String;", "getEnglish", "getNative", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Anilight"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Title {

        @Nullable
        private final String english;

        @Nullable
        private final String native;

        @Nullable
        private final String romaji;

        public static /* synthetic */ Title copy$default(Title title, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = title.romaji;
            }
            if ((i & 2) != 0) {
                str2 = title.english;
            }
            if ((i & 4) != 0) {
                str3 = title.native;
            }
            return title.copy(str, str2, str3);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getRomaji() {
            return this.romaji;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getEnglish() {
            return this.english;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getNative() {
            return this.native;
        }

        @NotNull
        public final Title copy(@Nullable String romaji, @Nullable String english, @Nullable String str) {
            return new Title(romaji, english, str);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Title)) {
                return false;
            }
            Title title = (Title) other;
            return Intrinsics.areEqual(this.romaji, title.romaji) && Intrinsics.areEqual(this.english, title.english) && Intrinsics.areEqual(this.native, title.native);
        }

        public int hashCode() {
            return ((((this.romaji == null ? 0 : this.romaji.hashCode()) * 31) + (this.english == null ? 0 : this.english.hashCode())) * 31) + (this.native != null ? this.native.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Title(romaji=" + this.romaji + ", english=" + this.english + ", native=" + this.native + ')';
        }

        public Title(@Nullable String romaji, @Nullable String english, @Nullable String str) {
            this.romaji = romaji;
            this.english = english;
            this.native = str;
        }

        @Nullable
        public final String getRomaji() {
            return this.romaji;
        }

        @Nullable
        public final String getEnglish() {
            return this.english;
        }

        @Nullable
        public final String getNative() {
            return this.native;
        }
    }

    /* JADX INFO: compiled from: Anilight.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/anilight/Anilight$CoverImage;", "", "large", "", "extraLarge", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getLarge", "()Ljava/lang/String;", "getExtraLarge", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Anilight"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class CoverImage {

        @Nullable
        private final String extraLarge;

        @Nullable
        private final String large;

        public static /* synthetic */ CoverImage copy$default(CoverImage coverImage, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = coverImage.large;
            }
            if ((i & 2) != 0) {
                str2 = coverImage.extraLarge;
            }
            return coverImage.copy(str, str2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getLarge() {
            return this.large;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getExtraLarge() {
            return this.extraLarge;
        }

        @NotNull
        public final CoverImage copy(@Nullable String large, @Nullable String extraLarge) {
            return new CoverImage(large, extraLarge);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CoverImage)) {
                return false;
            }
            CoverImage coverImage = (CoverImage) other;
            return Intrinsics.areEqual(this.large, coverImage.large) && Intrinsics.areEqual(this.extraLarge, coverImage.extraLarge);
        }

        public int hashCode() {
            return ((this.large == null ? 0 : this.large.hashCode()) * 31) + (this.extraLarge != null ? this.extraLarge.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "CoverImage(large=" + this.large + ", extraLarge=" + this.extraLarge + ')';
        }

        public CoverImage(@Nullable String large, @Nullable String extraLarge) {
            this.large = large;
            this.extraLarge = extraLarge;
        }

        @Nullable
        public final String getLarge() {
            return this.large;
        }

        @Nullable
        public final String getExtraLarge() {
            return this.extraLarge;
        }
    }

    /* JADX INFO: compiled from: Anilight.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010)\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000fHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u008c\u0001\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u00100J\u0014\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00104\u001a\u00020\u0003HÖ\u0081\u0004J\n\u00105\u001a\u00020\u0005HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0019\u0010\u0015R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001a\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u00066"}, d2 = {"Lcom/anilight/Anilight$DetailResponse;", "", "id", "", "slug", "", "anilistId", "idMal", "title", "Lcom/anilight/Anilight$Title;", "coverImage", "Lcom/anilight/Anilight$CoverImage;", "bannerImage", "description", "genres", "", "tmdb", "Lcom/anilight/Anilight$Tmdb;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/anilight/Anilight$Title;Lcom/anilight/Anilight$CoverImage;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/anilight/Anilight$Tmdb;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSlug", "()Ljava/lang/String;", "getAnilistId", "getIdMal", "getTitle", "()Lcom/anilight/Anilight$Title;", "getCoverImage", "()Lcom/anilight/Anilight$CoverImage;", "getBannerImage", "getDescription", "getGenres", "()Ljava/util/List;", "getTmdb", "()Lcom/anilight/Anilight$Tmdb;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/anilight/Anilight$Title;Lcom/anilight/Anilight$CoverImage;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/anilight/Anilight$Tmdb;)Lcom/anilight/Anilight$DetailResponse;", "equals", "", "other", "hashCode", "toString", "Anilight"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class DetailResponse {

        @Nullable
        private final Integer anilistId;

        @Nullable
        private final String bannerImage;

        @Nullable
        private final CoverImage coverImage;

        @Nullable
        private final String description;

        @Nullable
        private final List<String> genres;

        @Nullable
        private final Integer id;

        @Nullable
        private final Integer idMal;

        @Nullable
        private final String slug;

        @Nullable
        private final Title title;

        @Nullable
        private final Tmdb tmdb;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DetailResponse copy$default(DetailResponse detailResponse, Integer num, String str, Integer num2, Integer num3, Title title, CoverImage coverImage, String str2, String str3, List list, Tmdb tmdb, int i, Object obj) {
            if ((i & 1) != 0) {
                num = detailResponse.id;
            }
            if ((i & 2) != 0) {
                str = detailResponse.slug;
            }
            if ((i & 4) != 0) {
                num2 = detailResponse.anilistId;
            }
            if ((i & 8) != 0) {
                num3 = detailResponse.idMal;
            }
            if ((i & 16) != 0) {
                title = detailResponse.title;
            }
            if ((i & 32) != 0) {
                coverImage = detailResponse.coverImage;
            }
            if ((i & 64) != 0) {
                str2 = detailResponse.bannerImage;
            }
            if ((i & 128) != 0) {
                str3 = detailResponse.description;
            }
            if ((i & 256) != 0) {
                list = detailResponse.genres;
            }
            if ((i & 512) != 0) {
                tmdb = detailResponse.tmdb;
            }
            List list2 = list;
            Tmdb tmdb2 = tmdb;
            String str4 = str2;
            String str5 = str3;
            Title title2 = title;
            CoverImage coverImage2 = coverImage;
            return detailResponse.copy(num, str, num2, num3, title2, coverImage2, str4, str5, list2, tmdb2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final Tmdb getTmdb() {
            return this.tmdb;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getSlug() {
            return this.slug;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getAnilistId() {
            return this.anilistId;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getIdMal() {
            return this.idMal;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Title getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final CoverImage getCoverImage() {
            return this.coverImage;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getBannerImage() {
            return this.bannerImage;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        public final List<String> component9() {
            return this.genres;
        }

        @NotNull
        public final DetailResponse copy(@Nullable Integer id, @Nullable String slug, @Nullable Integer anilistId, @Nullable Integer idMal, @Nullable Title title, @Nullable CoverImage coverImage, @Nullable String bannerImage, @Nullable String description, @Nullable List<String> genres, @Nullable Tmdb tmdb) {
            return new DetailResponse(id, slug, anilistId, idMal, title, coverImage, bannerImage, description, genres, tmdb);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DetailResponse)) {
                return false;
            }
            DetailResponse detailResponse = (DetailResponse) other;
            return Intrinsics.areEqual(this.id, detailResponse.id) && Intrinsics.areEqual(this.slug, detailResponse.slug) && Intrinsics.areEqual(this.anilistId, detailResponse.anilistId) && Intrinsics.areEqual(this.idMal, detailResponse.idMal) && Intrinsics.areEqual(this.title, detailResponse.title) && Intrinsics.areEqual(this.coverImage, detailResponse.coverImage) && Intrinsics.areEqual(this.bannerImage, detailResponse.bannerImage) && Intrinsics.areEqual(this.description, detailResponse.description) && Intrinsics.areEqual(this.genres, detailResponse.genres) && Intrinsics.areEqual(this.tmdb, detailResponse.tmdb);
        }

        public int hashCode() {
            return ((((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.slug == null ? 0 : this.slug.hashCode())) * 31) + (this.anilistId == null ? 0 : this.anilistId.hashCode())) * 31) + (this.idMal == null ? 0 : this.idMal.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.coverImage == null ? 0 : this.coverImage.hashCode())) * 31) + (this.bannerImage == null ? 0 : this.bannerImage.hashCode())) * 31) + (this.description == null ? 0 : this.description.hashCode())) * 31) + (this.genres == null ? 0 : this.genres.hashCode())) * 31) + (this.tmdb != null ? this.tmdb.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "DetailResponse(id=" + this.id + ", slug=" + this.slug + ", anilistId=" + this.anilistId + ", idMal=" + this.idMal + ", title=" + this.title + ", coverImage=" + this.coverImage + ", bannerImage=" + this.bannerImage + ", description=" + this.description + ", genres=" + this.genres + ", tmdb=" + this.tmdb + ')';
        }

        public DetailResponse(@Nullable Integer id, @Nullable String slug, @Nullable Integer anilistId, @Nullable Integer idMal, @Nullable Title title, @Nullable CoverImage coverImage, @Nullable String bannerImage, @Nullable String description, @Nullable List<String> list, @Nullable Tmdb tmdb) {
            this.id = id;
            this.slug = slug;
            this.anilistId = anilistId;
            this.idMal = idMal;
            this.title = title;
            this.coverImage = coverImage;
            this.bannerImage = bannerImage;
            this.description = description;
            this.genres = list;
            this.tmdb = tmdb;
        }

        @Nullable
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        public final String getSlug() {
            return this.slug;
        }

        @Nullable
        public final Integer getAnilistId() {
            return this.anilistId;
        }

        @Nullable
        public final Integer getIdMal() {
            return this.idMal;
        }

        @Nullable
        public final Title getTitle() {
            return this.title;
        }

        @Nullable
        public final CoverImage getCoverImage() {
            return this.coverImage;
        }

        @Nullable
        public final String getBannerImage() {
            return this.bannerImage;
        }

        @Nullable
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        public final List<String> getGenres() {
            return this.genres;
        }

        @Nullable
        public final Tmdb getTmdb() {
            return this.tmdb;
        }
    }

    /* JADX INFO: compiled from: Anilight.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J8\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u001cHÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/anilight/Anilight$WatchResponse;", "", "id", "", "episodes", "", "Lcom/anilight/Anilight$Episode;", "servers", "Lcom/anilight/Anilight$Servers;", "<init>", "(Ljava/lang/Integer;Ljava/util/List;Lcom/anilight/Anilight$Servers;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEpisodes", "()Ljava/util/List;", "getServers", "()Lcom/anilight/Anilight$Servers;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/util/List;Lcom/anilight/Anilight$Servers;)Lcom/anilight/Anilight$WatchResponse;", "equals", "", "other", "hashCode", "toString", "", "Anilight"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class WatchResponse {

        @Nullable
        private final List<Episode> episodes;

        @Nullable
        private final Integer id;

        @Nullable
        private final Servers servers;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ WatchResponse copy$default(WatchResponse watchResponse, Integer num, List list, Servers servers, int i, Object obj) {
            if ((i & 1) != 0) {
                num = watchResponse.id;
            }
            if ((i & 2) != 0) {
                list = watchResponse.episodes;
            }
            if ((i & 4) != 0) {
                servers = watchResponse.servers;
            }
            return watchResponse.copy(num, list, servers);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        public final List<Episode> component2() {
            return this.episodes;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Servers getServers() {
            return this.servers;
        }

        @NotNull
        public final WatchResponse copy(@Nullable Integer id, @Nullable List<Episode> episodes, @Nullable Servers servers) {
            return new WatchResponse(id, episodes, servers);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WatchResponse)) {
                return false;
            }
            WatchResponse watchResponse = (WatchResponse) other;
            return Intrinsics.areEqual(this.id, watchResponse.id) && Intrinsics.areEqual(this.episodes, watchResponse.episodes) && Intrinsics.areEqual(this.servers, watchResponse.servers);
        }

        public int hashCode() {
            return ((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.episodes == null ? 0 : this.episodes.hashCode())) * 31) + (this.servers != null ? this.servers.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "WatchResponse(id=" + this.id + ", episodes=" + this.episodes + ", servers=" + this.servers + ')';
        }

        public WatchResponse(@Nullable Integer id, @Nullable List<Episode> list, @Nullable Servers servers) {
            this.id = id;
            this.episodes = list;
            this.servers = servers;
        }

        @Nullable
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        public final List<Episode> getEpisodes() {
            return this.episodes;
        }

        @Nullable
        public final Servers getServers() {
            return this.servers;
        }
    }

    /* JADX INFO: compiled from: Anilight.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J>\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0005HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/anilight/Anilight$Episode;", "", "number", "", "title", "", "description", "img", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getNumber", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTitle", "()Ljava/lang/String;", "getDescription", "getImg", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/anilight/Anilight$Episode;", "equals", "", "other", "hashCode", "toString", "Anilight"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Episode {

        @Nullable
        private final String description;

        @Nullable
        private final String img;

        @Nullable
        private final Integer number;

        @Nullable
        private final String title;

        public static /* synthetic */ Episode copy$default(Episode episode, Integer num, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                num = episode.number;
            }
            if ((i & 2) != 0) {
                str = episode.title;
            }
            if ((i & 4) != 0) {
                str2 = episode.description;
            }
            if ((i & 8) != 0) {
                str3 = episode.img;
            }
            return episode.copy(num, str, str2, str3);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getNumber() {
            return this.number;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getImg() {
            return this.img;
        }

        @NotNull
        public final Episode copy(@Nullable Integer number, @Nullable String title, @Nullable String description, @Nullable String img) {
            return new Episode(number, title, description, img);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Episode)) {
                return false;
            }
            Episode episode = (Episode) other;
            return Intrinsics.areEqual(this.number, episode.number) && Intrinsics.areEqual(this.title, episode.title) && Intrinsics.areEqual(this.description, episode.description) && Intrinsics.areEqual(this.img, episode.img);
        }

        public int hashCode() {
            return ((((((this.number == null ? 0 : this.number.hashCode()) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.description == null ? 0 : this.description.hashCode())) * 31) + (this.img != null ? this.img.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Episode(number=" + this.number + ", title=" + this.title + ", description=" + this.description + ", img=" + this.img + ')';
        }

        public Episode(@Nullable Integer number, @Nullable String title, @Nullable String description, @Nullable String img) {
            this.number = number;
            this.title = title;
            this.description = description;
            this.img = img;
        }

        @Nullable
        public final Integer getNumber() {
            return this.number;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        public final String getImg() {
            return this.img;
        }
    }

    /* JADX INFO: compiled from: Anilight.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\r\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/anilight/Anilight$Servers;", "", "dubProviders", "", "Lcom/anilight/Anilight$Provider;", "subProviders", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getDubProviders", "()Ljava/util/List;", "getSubProviders", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Anilight"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Servers {

        @Nullable
        private final List<Provider> dubProviders;

        @Nullable
        private final List<Provider> subProviders;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Servers copy$default(Servers servers, List list, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = servers.dubProviders;
            }
            if ((i & 2) != 0) {
                list2 = servers.subProviders;
            }
            return servers.copy(list, list2);
        }

        @Nullable
        public final List<Provider> component1() {
            return this.dubProviders;
        }

        @Nullable
        public final List<Provider> component2() {
            return this.subProviders;
        }

        @NotNull
        public final Servers copy(@Nullable List<Provider> dubProviders, @Nullable List<Provider> subProviders) {
            return new Servers(dubProviders, subProviders);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Servers)) {
                return false;
            }
            Servers servers = (Servers) other;
            return Intrinsics.areEqual(this.dubProviders, servers.dubProviders) && Intrinsics.areEqual(this.subProviders, servers.subProviders);
        }

        public int hashCode() {
            return ((this.dubProviders == null ? 0 : this.dubProviders.hashCode()) * 31) + (this.subProviders != null ? this.subProviders.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Servers(dubProviders=" + this.dubProviders + ", subProviders=" + this.subProviders + ')';
        }

        public Servers(@Nullable List<Provider> list, @Nullable List<Provider> list2) {
            this.dubProviders = list;
            this.subProviders = list2;
        }

        @Nullable
        public final List<Provider> getDubProviders() {
            return this.dubProviders;
        }

        @Nullable
        public final List<Provider> getSubProviders() {
            return this.subProviders;
        }
    }

    /* JADX INFO: compiled from: Anilight.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/anilight/Anilight$Provider;", "", "id", "", "tip", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getTip", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Anilight"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Provider {

        @Nullable
        private final String id;

        @Nullable
        private final String tip;

        public static /* synthetic */ Provider copy$default(Provider provider, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = provider.id;
            }
            if ((i & 2) != 0) {
                str2 = provider.tip;
            }
            return provider.copy(str, str2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTip() {
            return this.tip;
        }

        @NotNull
        public final Provider copy(@Nullable String id, @Nullable String tip) {
            return new Provider(id, tip);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Provider)) {
                return false;
            }
            Provider provider = (Provider) other;
            return Intrinsics.areEqual(this.id, provider.id) && Intrinsics.areEqual(this.tip, provider.tip);
        }

        public int hashCode() {
            return ((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.tip != null ? this.tip.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Provider(id=" + this.id + ", tip=" + this.tip + ')';
        }

        public Provider(@Nullable String id, @Nullable String tip) {
            this.id = id;
            this.tip = tip;
        }

        @Nullable
        public final String getId() {
            return this.id;
        }

        @Nullable
        public final String getTip() {
            return this.tip;
        }
    }

    /* JADX INFO: compiled from: Anilight.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/anilight/Anilight$SourcesResponse;", "", "sources", "", "Lcom/anilight/Anilight$Source;", "tracks", "Lcom/anilight/Anilight$Track;", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getSources", "()Ljava/util/List;", "getTracks", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Anilight"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class SourcesResponse {

        @Nullable
        private final List<Source> sources;

        @Nullable
        private final List<Track> tracks;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SourcesResponse copy$default(SourcesResponse sourcesResponse, List list, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = sourcesResponse.sources;
            }
            if ((i & 2) != 0) {
                list2 = sourcesResponse.tracks;
            }
            return sourcesResponse.copy(list, list2);
        }

        @Nullable
        public final List<Source> component1() {
            return this.sources;
        }

        @Nullable
        public final List<Track> component2() {
            return this.tracks;
        }

        @NotNull
        public final SourcesResponse copy(@Nullable List<Source> sources, @Nullable List<Track> tracks) {
            return new SourcesResponse(sources, tracks);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SourcesResponse)) {
                return false;
            }
            SourcesResponse sourcesResponse = (SourcesResponse) other;
            return Intrinsics.areEqual(this.sources, sourcesResponse.sources) && Intrinsics.areEqual(this.tracks, sourcesResponse.tracks);
        }

        public int hashCode() {
            return ((this.sources == null ? 0 : this.sources.hashCode()) * 31) + (this.tracks != null ? this.tracks.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "SourcesResponse(sources=" + this.sources + ", tracks=" + this.tracks + ')';
        }

        public SourcesResponse(@Nullable List<Source> list, @Nullable List<Track> list2) {
            this.sources = list;
            this.tracks = list2;
        }

        @Nullable
        public final List<Source> getSources() {
            return this.sources;
        }

        @Nullable
        public final List<Track> getTracks() {
            return this.tracks;
        }
    }

    /* JADX INFO: compiled from: Anilight.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/anilight/Anilight$Source;", "", "url", "", "type", "quality", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getType", "getQuality", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Anilight"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Source {

        @Nullable
        private final String quality;

        @Nullable
        private final String type;

        @Nullable
        private final String url;

        public static /* synthetic */ Source copy$default(Source source, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = source.url;
            }
            if ((i & 2) != 0) {
                str2 = source.type;
            }
            if ((i & 4) != 0) {
                str3 = source.quality;
            }
            return source.copy(str, str2, str3);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getQuality() {
            return this.quality;
        }

        @NotNull
        public final Source copy(@Nullable String url, @Nullable String type, @Nullable String quality) {
            return new Source(url, type, quality);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Source)) {
                return false;
            }
            Source source = (Source) other;
            return Intrinsics.areEqual(this.url, source.url) && Intrinsics.areEqual(this.type, source.type) && Intrinsics.areEqual(this.quality, source.quality);
        }

        public int hashCode() {
            return ((((this.url == null ? 0 : this.url.hashCode()) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.quality != null ? this.quality.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Source(url=" + this.url + ", type=" + this.type + ", quality=" + this.quality + ')';
        }

        public Source(@Nullable String url, @Nullable String type, @Nullable String quality) {
            this.url = url;
            this.type = type;
            this.quality = quality;
        }

        @Nullable
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }

        @Nullable
        public final String getQuality() {
            return this.quality;
        }
    }

    /* JADX INFO: compiled from: Anilight.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/anilight/Anilight$Track;", "", "url", "", "lang", "label", "kind", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getLang", "getLabel", "getKind", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "Anilight"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Track {

        @Nullable
        private final String kind;

        @Nullable
        private final String label;

        @Nullable
        private final String lang;

        @Nullable
        private final String url;

        public static /* synthetic */ Track copy$default(Track track, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = track.url;
            }
            if ((i & 2) != 0) {
                str2 = track.lang;
            }
            if ((i & 4) != 0) {
                str3 = track.label;
            }
            if ((i & 8) != 0) {
                str4 = track.kind;
            }
            return track.copy(str, str2, str3, str4);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getLang() {
            return this.lang;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getLabel() {
            return this.label;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getKind() {
            return this.kind;
        }

        @NotNull
        public final Track copy(@Nullable String url, @Nullable String lang, @Nullable String label, @Nullable String kind) {
            return new Track(url, lang, label, kind);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Track)) {
                return false;
            }
            Track track = (Track) other;
            return Intrinsics.areEqual(this.url, track.url) && Intrinsics.areEqual(this.lang, track.lang) && Intrinsics.areEqual(this.label, track.label) && Intrinsics.areEqual(this.kind, track.kind);
        }

        public int hashCode() {
            return ((((((this.url == null ? 0 : this.url.hashCode()) * 31) + (this.lang == null ? 0 : this.lang.hashCode())) * 31) + (this.label == null ? 0 : this.label.hashCode())) * 31) + (this.kind != null ? this.kind.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Track(url=" + this.url + ", lang=" + this.lang + ", label=" + this.label + ", kind=" + this.kind + ')';
        }

        public Track(@Nullable String url, @Nullable String lang, @Nullable String label, @Nullable String kind) {
            this.url = url;
            this.lang = lang;
            this.label = label;
            this.kind = kind;
        }

        @Nullable
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        public final String getLang() {
            return this.lang;
        }

        @Nullable
        public final String getLabel() {
            return this.label;
        }

        @Nullable
        public final String getKind() {
            return this.kind;
        }
    }

    /* JADX INFO: compiled from: Anilight.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/anilight/Anilight$Tmdb;", "", "poster", "", "backdrop", "logos", "Lcom/anilight/Anilight$Logos;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/anilight/Anilight$Logos;)V", "getPoster", "()Ljava/lang/String;", "getBackdrop", "getLogos", "()Lcom/anilight/Anilight$Logos;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Anilight"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Tmdb {

        @Nullable
        private final String backdrop;

        @Nullable
        private final Logos logos;

        @Nullable
        private final String poster;

        public static /* synthetic */ Tmdb copy$default(Tmdb tmdb, String str, String str2, Logos logos, int i, Object obj) {
            if ((i & 1) != 0) {
                str = tmdb.poster;
            }
            if ((i & 2) != 0) {
                str2 = tmdb.backdrop;
            }
            if ((i & 4) != 0) {
                logos = tmdb.logos;
            }
            return tmdb.copy(str, str2, logos);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getPoster() {
            return this.poster;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getBackdrop() {
            return this.backdrop;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Logos getLogos() {
            return this.logos;
        }

        @NotNull
        public final Tmdb copy(@Nullable String poster, @Nullable String backdrop, @Nullable Logos logos) {
            return new Tmdb(poster, backdrop, logos);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Tmdb)) {
                return false;
            }
            Tmdb tmdb = (Tmdb) other;
            return Intrinsics.areEqual(this.poster, tmdb.poster) && Intrinsics.areEqual(this.backdrop, tmdb.backdrop) && Intrinsics.areEqual(this.logos, tmdb.logos);
        }

        public int hashCode() {
            return ((((this.poster == null ? 0 : this.poster.hashCode()) * 31) + (this.backdrop == null ? 0 : this.backdrop.hashCode())) * 31) + (this.logos != null ? this.logos.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Tmdb(poster=" + this.poster + ", backdrop=" + this.backdrop + ", logos=" + this.logos + ')';
        }

        public Tmdb(@Nullable String poster, @Nullable String backdrop, @Nullable Logos logos) {
            this.poster = poster;
            this.backdrop = backdrop;
            this.logos = logos;
        }

        @Nullable
        public final String getPoster() {
            return this.poster;
        }

        @Nullable
        public final String getBackdrop() {
            return this.backdrop;
        }

        @Nullable
        public final Logos getLogos() {
            return this.logos;
        }
    }

    /* JADX INFO: compiled from: Anilight.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\r\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0004HÖ\u0081\u0004R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/anilight/Anilight$Logos;", "", "english", "", "", "japanese", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getEnglish", "()Ljava/util/List;", "getJapanese", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Anilight"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Logos {

        @Nullable
        private final List<String> english;

        @Nullable
        private final List<String> japanese;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Logos copy$default(Logos logos, List list, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = logos.english;
            }
            if ((i & 2) != 0) {
                list2 = logos.japanese;
            }
            return logos.copy(list, list2);
        }

        @Nullable
        public final List<String> component1() {
            return this.english;
        }

        @Nullable
        public final List<String> component2() {
            return this.japanese;
        }

        @NotNull
        public final Logos copy(@Nullable List<String> english, @Nullable List<String> japanese) {
            return new Logos(english, japanese);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Logos)) {
                return false;
            }
            Logos logos = (Logos) other;
            return Intrinsics.areEqual(this.english, logos.english) && Intrinsics.areEqual(this.japanese, logos.japanese);
        }

        public int hashCode() {
            return ((this.english == null ? 0 : this.english.hashCode()) * 31) + (this.japanese != null ? this.japanese.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Logos(english=" + this.english + ", japanese=" + this.japanese + ')';
        }

        public Logos(@Nullable List<String> list, @Nullable List<String> list2) {
            this.english = list;
            this.japanese = list2;
        }

        @Nullable
        public final List<String> getEnglish() {
            return this.english;
        }

        @Nullable
        public final List<String> getJapanese() {
            return this.japanese;
        }
    }

    /* JADX INFO: compiled from: Anilight.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0004HÖ\u0081\u0004R\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/anilight/Anilight$AniZipResponse;", "", "episodes", "", "", "Lcom/anilight/Anilight$AniZipEpisode;", "mappings", "Lcom/anilight/Anilight$AniZipMappings;", "<init>", "(Ljava/util/Map;Lcom/anilight/Anilight$AniZipMappings;)V", "getEpisodes", "()Ljava/util/Map;", "getMappings", "()Lcom/anilight/Anilight$AniZipMappings;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Anilight"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class AniZipResponse {

        @Nullable
        private final Map<String, AniZipEpisode> episodes;

        @Nullable
        private final AniZipMappings mappings;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AniZipResponse copy$default(AniZipResponse aniZipResponse, Map map, AniZipMappings aniZipMappings, int i, Object obj) {
            if ((i & 1) != 0) {
                map = aniZipResponse.episodes;
            }
            if ((i & 2) != 0) {
                aniZipMappings = aniZipResponse.mappings;
            }
            return aniZipResponse.copy(map, aniZipMappings);
        }

        @Nullable
        public final Map<String, AniZipEpisode> component1() {
            return this.episodes;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final AniZipMappings getMappings() {
            return this.mappings;
        }

        @NotNull
        public final AniZipResponse copy(@Nullable Map<String, AniZipEpisode> episodes, @Nullable AniZipMappings mappings) {
            return new AniZipResponse(episodes, mappings);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AniZipResponse)) {
                return false;
            }
            AniZipResponse aniZipResponse = (AniZipResponse) other;
            return Intrinsics.areEqual(this.episodes, aniZipResponse.episodes) && Intrinsics.areEqual(this.mappings, aniZipResponse.mappings);
        }

        public int hashCode() {
            return ((this.episodes == null ? 0 : this.episodes.hashCode()) * 31) + (this.mappings != null ? this.mappings.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "AniZipResponse(episodes=" + this.episodes + ", mappings=" + this.mappings + ')';
        }

        public AniZipResponse(@Nullable Map<String, AniZipEpisode> map, @Nullable AniZipMappings mappings) {
            this.episodes = map;
            this.mappings = mappings;
        }

        @Nullable
        public final Map<String, AniZipEpisode> getEpisodes() {
            return this.episodes;
        }

        @Nullable
        public final AniZipMappings getMappings() {
            return this.mappings;
        }
    }

    /* JADX INFO: compiled from: Anilight.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010!\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0004HÆ\u0003Jz\u0010#\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010$J\u0014\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010(\u001a\u00020\bHÖ\u0081\u0004J\n\u0010)\u001a\u00020\u0004HÖ\u0081\u0004R\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0015\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0018\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012¨\u0006*"}, d2 = {"Lcom/anilight/Anilight$AniZipEpisode;", "", "title", "", "", "overview", "image", "absoluteEpisodeNumber", "", "rating", "runtime", "airDateUtc", "airDate", "<init>", "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/util/Map;", "getOverview", "()Ljava/lang/String;", "getImage", "getAbsoluteEpisodeNumber", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRating", "getRuntime", "getAirDateUtc", "getAirDate", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/anilight/Anilight$AniZipEpisode;", "equals", "", "other", "hashCode", "toString", "Anilight"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class AniZipEpisode {

        @Nullable
        private final Integer absoluteEpisodeNumber;

        @Nullable
        private final String airDate;

        @Nullable
        private final String airDateUtc;

        @Nullable
        private final String image;

        @Nullable
        private final String overview;

        @Nullable
        private final String rating;

        @Nullable
        private final Integer runtime;

        @Nullable
        private final Map<String, String> title;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AniZipEpisode copy$default(AniZipEpisode aniZipEpisode, Map map, String str, String str2, Integer num, String str3, Integer num2, String str4, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                map = aniZipEpisode.title;
            }
            if ((i & 2) != 0) {
                str = aniZipEpisode.overview;
            }
            if ((i & 4) != 0) {
                str2 = aniZipEpisode.image;
            }
            if ((i & 8) != 0) {
                num = aniZipEpisode.absoluteEpisodeNumber;
            }
            if ((i & 16) != 0) {
                str3 = aniZipEpisode.rating;
            }
            if ((i & 32) != 0) {
                num2 = aniZipEpisode.runtime;
            }
            if ((i & 64) != 0) {
                str4 = aniZipEpisode.airDateUtc;
            }
            if ((i & 128) != 0) {
                str5 = aniZipEpisode.airDate;
            }
            String str6 = str4;
            String str7 = str5;
            String str8 = str3;
            Integer num3 = num2;
            return aniZipEpisode.copy(map, str, str2, num, str8, num3, str6, str7);
        }

        @Nullable
        public final Map<String, String> component1() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getOverview() {
            return this.overview;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getImage() {
            return this.image;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getAbsoluteEpisodeNumber() {
            return this.absoluteEpisodeNumber;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getRating() {
            return this.rating;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Integer getRuntime() {
            return this.runtime;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getAirDateUtc() {
            return this.airDateUtc;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getAirDate() {
            return this.airDate;
        }

        @NotNull
        public final AniZipEpisode copy(@Nullable Map<String, String> title, @Nullable String overview, @Nullable String image, @Nullable Integer absoluteEpisodeNumber, @Nullable String rating, @Nullable Integer runtime, @Nullable String airDateUtc, @Nullable String airDate) {
            return new AniZipEpisode(title, overview, image, absoluteEpisodeNumber, rating, runtime, airDateUtc, airDate);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AniZipEpisode)) {
                return false;
            }
            AniZipEpisode aniZipEpisode = (AniZipEpisode) other;
            return Intrinsics.areEqual(this.title, aniZipEpisode.title) && Intrinsics.areEqual(this.overview, aniZipEpisode.overview) && Intrinsics.areEqual(this.image, aniZipEpisode.image) && Intrinsics.areEqual(this.absoluteEpisodeNumber, aniZipEpisode.absoluteEpisodeNumber) && Intrinsics.areEqual(this.rating, aniZipEpisode.rating) && Intrinsics.areEqual(this.runtime, aniZipEpisode.runtime) && Intrinsics.areEqual(this.airDateUtc, aniZipEpisode.airDateUtc) && Intrinsics.areEqual(this.airDate, aniZipEpisode.airDate);
        }

        public int hashCode() {
            return ((((((((((((((this.title == null ? 0 : this.title.hashCode()) * 31) + (this.overview == null ? 0 : this.overview.hashCode())) * 31) + (this.image == null ? 0 : this.image.hashCode())) * 31) + (this.absoluteEpisodeNumber == null ? 0 : this.absoluteEpisodeNumber.hashCode())) * 31) + (this.rating == null ? 0 : this.rating.hashCode())) * 31) + (this.runtime == null ? 0 : this.runtime.hashCode())) * 31) + (this.airDateUtc == null ? 0 : this.airDateUtc.hashCode())) * 31) + (this.airDate != null ? this.airDate.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "AniZipEpisode(title=" + this.title + ", overview=" + this.overview + ", image=" + this.image + ", absoluteEpisodeNumber=" + this.absoluteEpisodeNumber + ", rating=" + this.rating + ", runtime=" + this.runtime + ", airDateUtc=" + this.airDateUtc + ", airDate=" + this.airDate + ')';
        }

        public AniZipEpisode(@Nullable Map<String, String> map, @Nullable String overview, @Nullable String image, @Nullable Integer absoluteEpisodeNumber, @Nullable String rating, @Nullable Integer runtime, @Nullable String airDateUtc, @Nullable String airDate) {
            this.title = map;
            this.overview = overview;
            this.image = image;
            this.absoluteEpisodeNumber = absoluteEpisodeNumber;
            this.rating = rating;
            this.runtime = runtime;
            this.airDateUtc = airDateUtc;
            this.airDate = airDate;
        }

        @Nullable
        public final Map<String, String> getTitle() {
            return this.title;
        }

        @Nullable
        public final String getOverview() {
            return this.overview;
        }

        @Nullable
        public final String getImage() {
            return this.image;
        }

        @Nullable
        public final Integer getAbsoluteEpisodeNumber() {
            return this.absoluteEpisodeNumber;
        }

        @Nullable
        public final String getRating() {
            return this.rating;
        }

        @Nullable
        public final Integer getRuntime() {
            return this.runtime;
        }

        @Nullable
        public final String getAirDateUtc() {
            return this.airDateUtc;
        }

        @Nullable
        public final String getAirDate() {
            return this.airDate;
        }
    }

    /* JADX INFO: compiled from: Anilight.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J>\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0006HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/anilight/Anilight$AniZipMappings;", "", "mal_id", "", "anilist_id", "imdb_id", "", "themoviedb_id", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getMal_id", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAnilist_id", "getImdb_id", "()Ljava/lang/String;", "getThemoviedb_id", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/anilight/Anilight$AniZipMappings;", "equals", "", "other", "hashCode", "toString", "Anilight"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class AniZipMappings {

        @Nullable
        private final Integer anilist_id;

        @Nullable
        private final String imdb_id;

        @Nullable
        private final Integer mal_id;

        @Nullable
        private final String themoviedb_id;

        public static /* synthetic */ AniZipMappings copy$default(AniZipMappings aniZipMappings, Integer num, Integer num2, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                num = aniZipMappings.mal_id;
            }
            if ((i & 2) != 0) {
                num2 = aniZipMappings.anilist_id;
            }
            if ((i & 4) != 0) {
                str = aniZipMappings.imdb_id;
            }
            if ((i & 8) != 0) {
                str2 = aniZipMappings.themoviedb_id;
            }
            return aniZipMappings.copy(num, num2, str, str2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getMal_id() {
            return this.mal_id;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getAnilist_id() {
            return this.anilist_id;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getImdb_id() {
            return this.imdb_id;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getThemoviedb_id() {
            return this.themoviedb_id;
        }

        @NotNull
        public final AniZipMappings copy(@Nullable Integer mal_id, @Nullable Integer anilist_id, @Nullable String imdb_id, @Nullable String themoviedb_id) {
            return new AniZipMappings(mal_id, anilist_id, imdb_id, themoviedb_id);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AniZipMappings)) {
                return false;
            }
            AniZipMappings aniZipMappings = (AniZipMappings) other;
            return Intrinsics.areEqual(this.mal_id, aniZipMappings.mal_id) && Intrinsics.areEqual(this.anilist_id, aniZipMappings.anilist_id) && Intrinsics.areEqual(this.imdb_id, aniZipMappings.imdb_id) && Intrinsics.areEqual(this.themoviedb_id, aniZipMappings.themoviedb_id);
        }

        public int hashCode() {
            return ((((((this.mal_id == null ? 0 : this.mal_id.hashCode()) * 31) + (this.anilist_id == null ? 0 : this.anilist_id.hashCode())) * 31) + (this.imdb_id == null ? 0 : this.imdb_id.hashCode())) * 31) + (this.themoviedb_id != null ? this.themoviedb_id.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "AniZipMappings(mal_id=" + this.mal_id + ", anilist_id=" + this.anilist_id + ", imdb_id=" + this.imdb_id + ", themoviedb_id=" + this.themoviedb_id + ')';
        }

        public AniZipMappings(@Nullable Integer mal_id, @Nullable Integer anilist_id, @Nullable String imdb_id, @Nullable String themoviedb_id) {
            this.mal_id = mal_id;
            this.anilist_id = anilist_id;
            this.imdb_id = imdb_id;
            this.themoviedb_id = themoviedb_id;
        }

        @Nullable
        public final Integer getMal_id() {
            return this.mal_id;
        }

        @Nullable
        public final Integer getAnilist_id() {
            return this.anilist_id;
        }

        @Nullable
        public final String getImdb_id() {
            return this.imdb_id;
        }

        @Nullable
        public final String getThemoviedb_id() {
            return this.themoviedb_id;
        }
    }
}
