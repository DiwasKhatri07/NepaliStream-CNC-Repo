package com.RowdyAvocado;

import android.content.Context;
import com.cncverse.donation.DonationManager;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lagradost.cloudstream3.AnimeSearchResponse;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.MainPageData;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.MovieLoadResponse;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import com.lagradost.cloudstream3.utils.Qualities;
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
import kotlin.ResultKt;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: LibriVoxAudiobook.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/LibriVoxAudiobook/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 72\u00020\u0001:\u0003789B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u001e\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010%J\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u001c2\u0006\u0010(\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010)J\u0018\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010)JF\u0010-\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u000e2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u000203012\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020301H\u0096@¢\u0006\u0002\u00106R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006:"}, d2 = {"Lcom/RowdyAvocado/LibriVoxAudiobook;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "BookList", "Book", "LibriVoxAudiobook_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nLibriVoxAudiobook.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LibriVoxAudiobook.kt\ncom/RowdyAvocado/LibriVoxAudiobook\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,157:1\n62#2:158\n62#2:173\n1642#3,10:159\n1915#3:169\n1916#3:171\n1652#3:172\n1586#3:174\n1661#3,3:175\n1642#3,10:178\n1915#3:188\n1916#3:190\n1652#3:191\n1#4:170\n1#4:189\n*S KotlinDebug\n*F\n+ 1 LibriVoxAudiobook.kt\ncom/RowdyAvocado/LibriVoxAudiobook\n*L\n56#1:158\n78#1:173\n58#1:159,10\n58#1:169\n58#1:171\n58#1:172\n80#1:174\n80#1:175,3\n104#1:178,10\n104#1:188\n104#1:190\n104#1:191\n58#1:170\n104#1:189\n*E\n"})
public final class LibriVoxAudiobook extends MainAPI {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static Context context;

    @NotNull
    private String mainUrl = "https://librivox.org";

    @NotNull
    private String name = "Librivox Audiobook";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "en";
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(TvType.Others);

    @NotNull
    private final List<MainPageData> mainPage = CollectionsKt.listOf(new MainPageData("Latest Audiobook", "https://librivox.org/api/feed/audiobooks/title/?format=json", false, 4, (DefaultConstructorMarker) null));

    /* JADX INFO: renamed from: com.RowdyAvocado.LibriVoxAudiobook$getMainPage$1 */
    /* JADX INFO: compiled from: LibriVoxAudiobook.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.RowdyAvocado.LibriVoxAudiobook", f = "LibriVoxAudiobook.kt", i = {0, 0, 0}, l = {56}, m = "getMainPage", n = {"request", "reqlink", "page"}, nl = {158}, s = {"L$0", "L$1", "I$0"}, v = 2)
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
            return LibriVoxAudiobook.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.RowdyAvocado.LibriVoxAudiobook$load$1 */
    /* JADX INFO: compiled from: LibriVoxAudiobook.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.RowdyAvocado.LibriVoxAudiobook", f = "LibriVoxAudiobook.kt", i = {0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {91, 113, 118}, m = "load", n = {"url", "url", "document", "title", "poster", "tvType", "episodes", "url", "document", "title", "poster", "tvType"}, nl = {93, 118, 101}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LibriVoxAudiobook.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.RowdyAvocado.LibriVoxAudiobook$loadLinks$1 */
    /* JADX INFO: compiled from: LibriVoxAudiobook.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.RowdyAvocado.LibriVoxAudiobook", f = "LibriVoxAudiobook.kt", i = {0, 0, 0, 0, 0}, l = {134}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "name", "isCasting"}, nl = {133}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0"}, v = 2)
    static final class C00041 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00041(Continuation<? super C00041> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LibriVoxAudiobook.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.RowdyAvocado.LibriVoxAudiobook$search$1 */
    /* JADX INFO: compiled from: LibriVoxAudiobook.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.RowdyAvocado.LibriVoxAudiobook", f = "LibriVoxAudiobook.kt", i = {0, 0}, l = {78}, m = "search", n = {"query", "reqlink"}, nl = {158}, s = {"L$0", "L$1"}, v = 2)
    static final class C00061 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00061(Continuation<? super C00061> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LibriVoxAudiobook.this.search(null, (Continuation) this);
        }
    }

    /* JADX INFO: compiled from: LibriVoxAudiobook.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/RowdyAvocado/LibriVoxAudiobook$Companion;", "", "<init>", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "LibriVoxAudiobook_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Nullable
        public final Context getContext() {
            return LibriVoxAudiobook.context;
        }

        public final void setContext(@Nullable Context context) {
            LibriVoxAudiobook.context = context;
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

    /* JADX WARN: Code duplicated, block: B:22:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:24:0x0119  */
    /* JADX WARN: Code duplicated, block: B:32:0x0122 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00001 c00001;
        List listEmptyList;
        MainPageRequest request2;
        Collection destination$iv$iv;
        AnimeSearchResponse animeSearchResponseNewAnimeSearchResponse$default;
        LibriVoxAudiobook libriVoxAudiobook = this;
        if (continuation instanceof C00001) {
            c00001 = (C00001) continuation;
            if ((c00001.label & Integer.MIN_VALUE) != 0) {
                c00001.label -= Integer.MIN_VALUE;
            } else {
                c00001 = libriVoxAudiobook.new C00001(continuation);
            }
        } else {
            c00001 = libriVoxAudiobook.new C00001(continuation);
        }
        Object $result = c00001.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00001.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                DonationManager.INSTANCE.checkAndShow(libriVoxAudiobook.getName());
                String reqlink = request.getData();
                if (Intrinsics.areEqual(request.getName(), "Latest Audiobook")) {
                    Requests app = MainActivityKt.getApp();
                    c00001.L$0 = request;
                    c00001.L$1 = SpillingKt.nullOutSpilledVariable(reqlink);
                    c00001.I$0 = page;
                    c00001.label = 1;
                    $result = Requests.get$default(app, reqlink, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00001, 4094, (Object) null);
                    if ($result == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    request2 = request;
                    NiceResponse this_$iv = (NiceResponse) $result;
                    ResponseParser parser = this_$iv.getParser();
                    Intrinsics.checkNotNull(parser);
                    BookList jason = (BookList) parser.parse(this_$iv.getText(), Reflection.getOrCreateKotlinClass(BookList.class));
                    Iterable $this$mapNotNull$iv = jason.getBooks();
                    destination$iv$iv = new ArrayList();
                    for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                        Book it = (Book) element$iv$iv$iv;
                        String title = it.getTitle();
                        Intrinsics.checkNotNull(title);
                        String url = it.getUrl();
                        Intrinsics.checkNotNull(url);
                        animeSearchResponseNewAnimeSearchResponse$default = MainAPIKt.newAnimeSearchResponse$default(libriVoxAudiobook, title, url, TvType.Anime, false, new Function1() { // from class: com.RowdyAvocado.LibriVoxAudiobook$$ExternalSyntheticLambda2
                            public final Object invoke(Object obj) {
                                return LibriVoxAudiobook.getMainPage$lambda$0$0((AnimeSearchResponse) obj);
                            }
                        }, 8, (Object) null);
                        if (animeSearchResponseNewAnimeSearchResponse$default != null) {
                            destination$iv$iv.add(animeSearchResponseNewAnimeSearchResponse$default);
                        }
                        libriVoxAudiobook = this;
                    }
                    listEmptyList = (List) destination$iv$iv;
                } else {
                    listEmptyList = CollectionsKt.emptyList();
                    request2 = request;
                }
                List home = listEmptyList;
                return MainAPIKt.newHomePageResponse(CollectionsKt.listOf(new HomePageList(request2.getName(), home, false, 4, (DefaultConstructorMarker) null)), Boxing.boxBoolean(!home.isEmpty()));
            case 1:
                int i = c00001.I$0;
                request2 = (MainPageRequest) c00001.L$0;
                ResultKt.throwOnFailure($result);
                NiceResponse this_$iv2 = (NiceResponse) $result;
                ResponseParser parser2 = this_$iv2.getParser();
                Intrinsics.checkNotNull(parser2);
                BookList jason2 = (BookList) parser2.parse(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(BookList.class));
                Iterable $this$mapNotNull$iv2 = jason2.getBooks();
                destination$iv$iv = new ArrayList();
                while (r13.hasNext()) {
                    Book it2 = (Book) element$iv$iv$iv;
                    String title2 = it2.getTitle();
                    Intrinsics.checkNotNull(title2);
                    String url2 = it2.getUrl();
                    Intrinsics.checkNotNull(url2);
                    animeSearchResponseNewAnimeSearchResponse$default = MainAPIKt.newAnimeSearchResponse$default(libriVoxAudiobook, title2, url2, TvType.Anime, false, new Function1() { // from class: com.RowdyAvocado.LibriVoxAudiobook$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj) {
                            return LibriVoxAudiobook.getMainPage$lambda$0$0((AnimeSearchResponse) obj);
                        }
                    }, 8, (Object) null);
                    if (animeSearchResponseNewAnimeSearchResponse$default != null) {
                        destination$iv$iv.add(animeSearchResponseNewAnimeSearchResponse$default);
                    }
                    libriVoxAudiobook = this;
                }
                listEmptyList = (List) destination$iv$iv;
                List home2 = listEmptyList;
                return MainAPIKt.newHomePageResponse(CollectionsKt.listOf(new HomePageList(request2.getName(), home2, false, 4, (DefaultConstructorMarker) null)), Boxing.boxBoolean(!home2.isEmpty()));
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMainPage$lambda$0$0(AnimeSearchResponse $this$newAnimeSearchResponse) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        C00061 c00061;
        if (continuation instanceof C00061) {
            c00061 = (C00061) continuation;
            if ((c00061.label & Integer.MIN_VALUE) != 0) {
                c00061.label -= Integer.MIN_VALUE;
            } else {
                c00061 = new C00061(continuation);
            }
        } else {
            c00061 = new C00061(continuation);
        }
        Object $result = c00061.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00061.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String reqlink = "https://librivox.org/api/feed/audiobooks/?title=" + query + "&format=json";
                Requests app = MainActivityKt.getApp();
                c00061.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00061.L$1 = SpillingKt.nullOutSpilledVariable(reqlink);
                c00061.label = 1;
                $result = Requests.get$default(app, reqlink, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00061, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse this_$iv = (NiceResponse) $result;
        ResponseParser parser = this_$iv.getParser();
        Intrinsics.checkNotNull(parser);
        BookList jason = (BookList) parser.parse(this_$iv.getText(), Reflection.getOrCreateKotlinClass(BookList.class));
        Iterable $this$map$iv = jason.getBooks();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Book it = (Book) item$iv$iv;
            String title = it.getTitle();
            Intrinsics.checkNotNull(title);
            String url = it.getUrl();
            Intrinsics.checkNotNull(url);
            destination$iv$iv.add(MainAPIKt.newAnimeSearchResponse$default(this, title, url, TvType.Anime, false, new Function1() { // from class: com.RowdyAvocado.LibriVoxAudiobook$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    return LibriVoxAudiobook.search$lambda$0$0((AnimeSearchResponse) obj);
                }
            }, 8, (Object) null));
        }
        return (List) destination$iv$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit search$lambda$0$0(AnimeSearchResponse $this$newAnimeSearchResponse) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        C00011 c00011;
        Object obj;
        Object obj2;
        String url2;
        Element elementSelectFirst;
        String strText;
        String strAttr;
        Object objNewMovieLoadResponse;
        String url3;
        Document document;
        TvType tvType;
        String url4;
        String title;
        Object objNewTvSeriesLoadResponse;
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
                obj2 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00012, 4094, (Object) null);
                c00012 = c00012;
                if (obj2 == obj) {
                    return obj;
                }
                url2 = url;
                Document document2 = ((NiceResponse) obj2).getDocument();
                elementSelectFirst = document2.selectFirst("div.content-wrap h1");
                if (elementSelectFirst != null || (strText = elementSelectFirst.text()) == null) {
                    return null;
                }
                String title2 = StringsKt.trim(strText).toString();
                if (title2 == null) {
                    return null;
                }
                Element elementSelectFirst2 = document2.selectFirst("div.book-page-book-cover img");
                if (elementSelectFirst2 == null || (strAttr = elementSelectFirst2.attr("src")) == null) {
                    strAttr = "https://librivox.org/images/librivox-logo.png";
                }
                String poster = strAttr;
                TvType tvType2 = TvType.TvSeries;
                if (tvType2 != TvType.TvSeries) {
                    TvType tvType3 = TvType.Movie;
                    C00033 c00033 = new C00033(poster, null);
                    c00012.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c00012.L$1 = SpillingKt.nullOutSpilledVariable(document2);
                    c00012.L$2 = SpillingKt.nullOutSpilledVariable(title2);
                    c00012.L$3 = SpillingKt.nullOutSpilledVariable(poster);
                    c00012.L$4 = SpillingKt.nullOutSpilledVariable(tvType2);
                    c00012.label = 3;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title2, url2, tvType3, url2, c00033, c00012);
                    if (objNewMovieLoadResponse == obj) {
                        return obj;
                    }
                    url3 = url2;
                    document = document2;
                    tvType = tvType2;
                    url4 = title2;
                    title = poster;
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                Iterable $this$mapNotNull$iv = document2.select("a.chapter-name");
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                    Element it = (Element) element$iv$iv$iv;
                    LibriVoxAudiobook libriVoxAudiobook = this;
                    Object $result2 = $result;
                    String strAttr2 = it.attr("href");
                    if (strAttr2 == null) {
                        return null;
                    }
                    String href = MainAPIKt.fixUrl(libriVoxAudiobook, strAttr2);
                    final String name = StringsKt.trim(it.text()).toString();
                    String title3 = title2;
                    Episode episodeNewEpisode = MainAPIKt.newEpisode(this, href, new Function1() { // from class: com.RowdyAvocado.LibriVoxAudiobook$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj3) {
                            return LibriVoxAudiobook.load$lambda$0$0(name, (Episode) obj3);
                        }
                    });
                    if (episodeNewEpisode != null) {
                        destination$iv$iv.add(episodeNewEpisode);
                    }
                    $result = $result2;
                    title2 = title3;
                }
                String title4 = title2;
                List episodes = (List) destination$iv$iv;
                TvType tvType4 = TvType.TvSeries;
                C00022 c00022 = new C00022(poster, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(document2);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(title4);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(poster);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(tvType2);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(episodes);
                c00012.label = 2;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, title4, url2, tvType4, episodes, c00022, c00012);
                return objNewTvSeriesLoadResponse == obj ? obj : (LoadResponse) objNewTvSeriesLoadResponse;
            case 1:
                String url5 = (String) c00012.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                url2 = url5;
                obj2 = $result;
                Document document3 = ((NiceResponse) obj2).getDocument();
                elementSelectFirst = document3.selectFirst("div.content-wrap h1");
                if (elementSelectFirst != null) {
                    break;
                }
                return null;
            case 2:
                ResultKt.throwOnFailure($result);
                objNewTvSeriesLoadResponse = $result;
            case 3:
                tvType = (TvType) c00012.L$4;
                title = (String) c00012.L$3;
                url4 = (String) c00012.L$2;
                document = (Document) c00012.L$1;
                url3 = (String) c00012.L$0;
                ResultKt.throwOnFailure($result);
                objNewMovieLoadResponse = $result;
                return (LoadResponse) objNewMovieLoadResponse;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$0$0(String $name, Episode $this$newEpisode) {
        $this$newEpisode.setName($name);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.RowdyAvocado.LibriVoxAudiobook$load$2 */
    /* JADX INFO: compiled from: LibriVoxAudiobook.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.RowdyAvocado.LibriVoxAudiobook$load$2", f = "LibriVoxAudiobook.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00022 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $poster;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00022(String str, Continuation<? super C00022> continuation) {
            super(2, continuation);
            this.$poster = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00022 = new C00022(this.$poster, continuation);
            c00022.L$0 = obj;
            return c00022;
        }

        public final Object invoke(TvSeriesLoadResponse tvSeriesLoadResponse, Continuation<? super Unit> continuation) {
            return create(tvSeriesLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            TvSeriesLoadResponse $this$newTvSeriesLoadResponse = (TvSeriesLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newTvSeriesLoadResponse.setPosterUrl(this.$poster.toString());
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.RowdyAvocado.LibriVoxAudiobook$load$3 */
    /* JADX INFO: compiled from: LibriVoxAudiobook.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.RowdyAvocado.LibriVoxAudiobook$load$3", f = "LibriVoxAudiobook.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00033 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $poster;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00033(String str, Continuation<? super C00033> continuation) {
            super(2, continuation);
            this.$poster = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00033 = new C00033(this.$poster, continuation);
            c00033.L$0 = obj;
            return c00033;
        }

        public final Object invoke(MovieLoadResponse movieLoadResponse, Continuation<? super Unit> continuation) {
            return create(movieLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            MovieLoadResponse $this$newMovieLoadResponse = (MovieLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newMovieLoadResponse.setPosterUrl(this.$poster.toString());
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00041 c00041;
        Object objNewExtractorLink;
        if (continuation instanceof C00041) {
            c00041 = (C00041) continuation;
            if ((c00041.label & Integer.MIN_VALUE) != 0) {
                c00041.label -= Integer.MIN_VALUE;
            } else {
                c00041 = new C00041(continuation);
            }
        } else {
            c00041 = new C00041(continuation);
        }
        C00041 c00042 = c00041;
        Object $result = c00042.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00042.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                ExtractorLinkType infer_type = ExtractorApiKt.getINFER_TYPE();
                C00052 c00052 = new C00052(null);
                c00042.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00042.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                c00042.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                c00042.L$3 = SpillingKt.nullOutSpilledVariable("Librivox Audiobook");
                c00042.L$4 = function2;
                c00042.Z$0 = isCasting;
                c00042.label = 1;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink("Librivox Audiobook", "Librivox Audiobook", data, infer_type, c00052, c00042);
                if (objNewExtractorLink == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                boolean isCasting2 = c00042.Z$0;
                Function1<? super ExtractorLink, Unit> function3 = (Function1) c00042.L$4;
                ResultKt.throwOnFailure($result);
                function2 = function3;
                objNewExtractorLink = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        function2.invoke(objNewExtractorLink);
        return Boxing.boxBoolean(true);
    }

    /* JADX INFO: renamed from: com.RowdyAvocado.LibriVoxAudiobook$loadLinks$2 */
    /* JADX INFO: compiled from: LibriVoxAudiobook.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.RowdyAvocado.LibriVoxAudiobook$loadLinks$2", f = "LibriVoxAudiobook.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00052 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C00052(Continuation<? super C00052> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00052 = LibriVoxAudiobook.this.new C00052(continuation);
            c00052.L$0 = obj;
            return c00052;
        }

        public final Object invoke(ExtractorLink extractorLink, Continuation<? super Unit> continuation) {
            return create(extractorLink, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            ExtractorLink $this$newExtractorLink = (ExtractorLink) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newExtractorLink.setReferer(LibriVoxAudiobook.this.getMainUrl() + '/');
                    $this$newExtractorLink.setQuality(Qualities.P360.getValue());
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: compiled from: LibriVoxAudiobook.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0018\b\u0003\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J#\u0010\u000b\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0001J\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004R&\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/RowdyAvocado/LibriVoxAudiobook$BookList;", "", "books", "Ljava/util/ArrayList;", "Lcom/RowdyAvocado/LibriVoxAudiobook$Book;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/util/ArrayList;)V", "getBooks", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "LibriVoxAudiobook_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class BookList {

        @JsonProperty("books")
        @NotNull
        private final ArrayList<Book> books;

        /* JADX WARN: Illegal instructions before constructor call */
        public BookList() {
            ArrayList arrayList = null;
            this(arrayList, 1, arrayList);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ BookList copy$default(BookList bookList, ArrayList arrayList, int i, Object obj) {
            if ((i & 1) != 0) {
                arrayList = bookList.books;
            }
            return bookList.copy(arrayList);
        }

        @NotNull
        public final ArrayList<Book> component1() {
            return this.books;
        }

        @NotNull
        public final BookList copy(@JsonProperty("books") @NotNull ArrayList<Book> books) {
            return new BookList(books);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof BookList) && Intrinsics.areEqual(this.books, ((BookList) other).books);
        }

        public int hashCode() {
            return this.books.hashCode();
        }

        @NotNull
        public String toString() {
            return "BookList(books=" + this.books + ')';
        }

        public BookList(@JsonProperty("books") @NotNull ArrayList<Book> arrayList) {
            this.books = arrayList;
        }

        public /* synthetic */ BookList(ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new ArrayList() : arrayList);
        }

        @NotNull
        public final ArrayList<Book> getBooks() {
            return this.books;
        }
    }

    /* JADX INFO: compiled from: LibriVoxAudiobook.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/RowdyAvocado/LibriVoxAudiobook$Book;", "", "id", "", "title", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getTitle", "getUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "LibriVoxAudiobook_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Book {

        @JsonProperty("id")
        @Nullable
        private final String id;

        @JsonProperty("title")
        @Nullable
        private final String title;

        @JsonProperty("url_librivox")
        @Nullable
        private final String url;

        public Book() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ Book copy$default(Book book, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = book.id;
            }
            if ((i & 2) != 0) {
                str2 = book.title;
            }
            if ((i & 4) != 0) {
                str3 = book.url;
            }
            return book.copy(str, str2, str3);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @NotNull
        public final Book copy(@JsonProperty("id") @Nullable String id, @JsonProperty("title") @Nullable String title, @JsonProperty("url_librivox") @Nullable String url) {
            return new Book(id, title, url);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Book)) {
                return false;
            }
            Book book = (Book) other;
            return Intrinsics.areEqual(this.id, book.id) && Intrinsics.areEqual(this.title, book.title) && Intrinsics.areEqual(this.url, book.url);
        }

        public int hashCode() {
            return ((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.url != null ? this.url.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Book(id=" + this.id + ", title=" + this.title + ", url=" + this.url + ')';
        }

        public Book(@JsonProperty("id") @Nullable String id, @JsonProperty("title") @Nullable String title, @JsonProperty("url_librivox") @Nullable String url) {
            this.id = id;
            this.title = title;
            this.url = url;
        }

        public /* synthetic */ Book(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
        }

        @Nullable
        public final String getId() {
            return this.id;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final String getUrl() {
            return this.url;
        }
    }
}
