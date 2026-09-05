package com.phisher98;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.AnimeSearchResponse;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.ErrorLoadingException;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.MainPageData;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.MovieLoadResponse;
import com.lagradost.cloudstream3.ParCollectionsKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.reflect.KType;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* JADX INFO: compiled from: OnePace.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/AnimeDekhoProvider/classes.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u001c\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010#J\f\u0010$\u001a\u00020%*\u00020&H\u0002J\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020%0\u001a2\u0006\u0010(\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010)J\u0016\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010)JF\u0010-\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u000e2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u000203012\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020301H\u0096@¢\u0006\u0002\u00106J\f\u00107\u001a\u00020\u0005*\u00020&H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u00069"}, d2 = {"Lcom/phisher98/OnepaceProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/AnimeSearchResponse;", "Lorg/jsoup/nodes/Element;", "search", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getsrcAttribute", "Media", "AnimeDekhoProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nOnePace.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OnePace.kt\ncom/phisher98/OnepaceProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 5 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,154:1\n1739#2:155\n1814#2,3:156\n1795#2,10:159\n2068#2:169\n2069#2:171\n1805#2:172\n1795#2,10:192\n2068#2:202\n2069#2:204\n1805#2:205\n1#3:170\n1#3:174\n1#3:203\n1#3:207\n63#4:173\n64#4,15:175\n63#4:206\n64#4,15:208\n50#5:190\n43#5:191\n50#5:223\n43#5:224\n*S KotlinDebug\n*F\n+ 1 OnePace.kt\ncom/phisher98/OnepaceProvider\n*L\n34#1:155\n34#1:156,3\n73#1:159,10\n73#1:169\n73#1:171\n73#1:172\n101#1:192,10\n101#1:202\n101#1:204\n101#1:205\n73#1:170\n79#1:174\n101#1:203\n128#1:207\n79#1:173\n79#1:175,15\n128#1:206\n128#1:208,15\n79#1:190\n79#1:191\n128#1:223\n128#1:224\n*E\n"})
public class OnepaceProvider extends MainAPI {

    @NotNull
    private String mainUrl = "https://onepace.me";

    @NotNull
    private String name = "OnePace";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "en";

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(TvType.Anime);

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("/series/one-pace-english-sub/", "One Pace English Sub"), TuplesKt.to("/series/one-pace-english-dub/", "One Pace English Dub")});

    /* JADX INFO: renamed from: com.phisher98.OnepaceProvider$getMainPage$1 */
    /* JADX INFO: compiled from: OnePace.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.OnepaceProvider", f = "OnePace.kt", i = {0, 0, 0, 0}, l = {32}, m = "getMainPage$suspendImpl", n = {"$this", "request", "link", "page"}, nl = {34}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 2)
    static final class C00171 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00171(Continuation<? super C00171> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OnepaceProvider.getMainPage$suspendImpl(OnepaceProvider.this, 0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.OnepaceProvider$load$1 */
    /* JADX INFO: compiled from: OnePace.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.OnepaceProvider", f = "OnePace.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {80, 92, 114}, m = "load$suspendImpl", n = {"$this", "url", "media", "$this", "url", "media", "document", "ArcINT", "element", "title", "poster", "plot", "year", "lst", "$this", "url", "media", "document", "ArcINT", "element", "title", "poster", "plot", "year", "lst", "episodes"}, nl = {81, 101, 91}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11"}, v = 2)
    static final class C00181 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
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

        C00181(Continuation<? super C00181> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OnepaceProvider.load$suspendImpl(OnepaceProvider.this, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.OnepaceProvider$loadLinks$1 */
    /* JADX INFO: compiled from: OnePace.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.OnepaceProvider", f = "OnePace.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {129, 131}, m = "loadLinks$suspendImpl", n = {"$this", "data", "subtitleCallback", "callback", "media", "isCasting", "$this", "data", "subtitleCallback", "callback", "media", "body", "term", "isCasting"}, nl = {130, 137}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0"}, v = 2)
    static final class C00211 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
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
            return OnepaceProvider.loadLinks$suspendImpl(OnepaceProvider.this, null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.OnepaceProvider$search$1 */
    /* JADX INFO: compiled from: OnePace.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.OnepaceProvider", f = "OnePace.kt", i = {0, 0}, l = {72}, m = "search$suspendImpl", n = {"$this", "query"}, nl = {73}, s = {"L$0", "L$1"}, v = 2)
    static final class C00231 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00231(Continuation<? super C00231> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OnepaceProvider.search$suspendImpl(OnepaceProvider.this, null, (Continuation) this);
        }
    }

    @Nullable
    public Object getMainPage(int i, @NotNull MainPageRequest mainPageRequest, @NotNull Continuation<? super HomePageResponse> continuation) {
        return getMainPage$suspendImpl(this, i, mainPageRequest, continuation);
    }

    @Nullable
    public Object load(@NotNull String str, @NotNull Continuation<? super LoadResponse> continuation) {
        return load$suspendImpl(this, str, continuation);
    }

    @Nullable
    public Object loadLinks(@NotNull String str, boolean z, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        return loadLinks$suspendImpl(this, str, z, function1, function2, continuation);
    }

    @Nullable
    public Object search(@NotNull String str, @NotNull Continuation<? super List<AnimeSearchResponse>> continuation) {
        return search$suspendImpl(this, str, continuation);
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

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    static /* synthetic */ Object getMainPage$suspendImpl(OnepaceProvider $this, int page, MainPageRequest request, Continuation<? super HomePageResponse> continuation) {
        C00171 c00171;
        MainPageRequest request2;
        OnepaceProvider $this2 = $this;
        if (continuation instanceof C00171) {
            c00171 = (C00171) continuation;
            if ((c00171.label & Integer.MIN_VALUE) != 0) {
                c00171.label -= Integer.MIN_VALUE;
            } else {
                c00171 = $this2.new C00171(continuation);
            }
        } else {
            c00171 = $this2.new C00171(continuation);
        }
        Object $result = c00171.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00171.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String link = $this2.getMainUrl() + request.getData();
                Requests app = MainActivityKt.getApp();
                c00171.L$0 = $this2;
                c00171.L$1 = request;
                c00171.L$2 = SpillingKt.nullOutSpilledVariable(link);
                c00171.I$0 = page;
                c00171.label = 1;
                $result = Requests.get$default(app, link, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00171, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request2 = request;
                break;
                break;
            case 1:
                int i = c00171.I$0;
                request2 = (MainPageRequest) c00171.L$1;
                $this2 = (OnepaceProvider) c00171.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) $result).getDocument();
        Iterable $this$map$iv = document.select("div.seasons.aa-crd > div.seasons-bx");
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Element it = (Element) item$iv$iv;
            destination$iv$iv.add($this2.toSearchResult(it));
        }
        List home = (List) destination$iv$iv;
        return MainAPIKt.newHomePageResponse$default(request2.getName(), home, (Boolean) null, 4, (Object) null);
    }

    private final AnimeSearchResponse toSearchResult(Element $this$toSearchResult) {
        String strText;
        final boolean dubtype;
        final boolean subtype;
        Element elementSelectFirst = $this$toSearchResult.selectFirst("picture img");
        String hreftitle = elementSelectFirst != null ? elementSelectFirst.attr("alt") : null;
        String href = "";
        Intrinsics.checkNotNull(hreftitle);
        if (hreftitle.length() > 0) {
            if (StringsKt.contains$default(hreftitle, "Dub", false, 2, (Object) null)) {
                href = "https://onepace.me/series/one-pace-english-dub";
            } else {
                href = "https://onepace.me/series/one-pace-english-sub";
            }
        }
        Element elementSelectFirst2 = $this$toSearchResult.selectFirst("p");
        if (elementSelectFirst2 == null || (strText = elementSelectFirst2.text()) == null) {
            strText = "";
        }
        String title = strText;
        Element elementSelectFirst3 = $this$toSearchResult.selectFirst("img");
        final String posterUrl = elementSelectFirst3 != null ? getsrcAttribute(elementSelectFirst3) : null;
        if (StringsKt.contains$default(hreftitle, "Dub", false, 2, (Object) null)) {
            dubtype = true;
            subtype = false;
        } else {
            dubtype = false;
            subtype = true;
        }
        return MainAPIKt.newAnimeSearchResponse(this, title, AppUtils.INSTANCE.toJson(new Media(href, posterUrl, title)), TvType.Anime, false, new Function1() { // from class: com.phisher98.OnepaceProvider$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return OnepaceProvider.toSearchResult$lambda$0(posterUrl, dubtype, subtype, (AnimeSearchResponse) obj);
            }
        });
    }

    static final Unit toSearchResult$lambda$0(String $posterUrl, boolean $dubtype, boolean $subtype, AnimeSearchResponse $this$newAnimeSearchResponse) {
        $this$newAnimeSearchResponse.setPosterUrl($posterUrl);
        MainAPIKt.addDubStatus$default($this$newAnimeSearchResponse, $dubtype, $subtype, (Integer) null, (Integer) null, 12, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    static /* synthetic */ Object search$suspendImpl(OnepaceProvider $this, String query, Continuation<? super List<AnimeSearchResponse>> continuation) {
        C00231 c00231;
        OnepaceProvider $this2 = $this;
        if (continuation instanceof C00231) {
            c00231 = (C00231) continuation;
            if ((c00231.label & Integer.MIN_VALUE) != 0) {
                c00231.label -= Integer.MIN_VALUE;
            } else {
                c00231 = $this2.new C00231(continuation);
            }
        } else {
            c00231 = $this2.new C00231(continuation);
        }
        Object $result = c00231.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00231.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                String str = $this2.getMainUrl() + "/?s=" + query;
                c00231.L$0 = $this2;
                c00231.L$1 = SpillingKt.nullOutSpilledVariable(query);
                c00231.label = 1;
                $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00231, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                $this2 = (OnepaceProvider) c00231.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = document.select("ul[data-results] li article");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element it = (Element) element$iv$iv$iv;
            AnimeSearchResponse searchResult = $this2.toSearchResult(it);
            if (searchResult != null) {
                destination$iv$iv.add(searchResult);
            }
        }
        return (List) destination$iv$iv;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x033b  */
    /* JADX WARN: Code duplicated, block: B:101:0x0344  */
    /* JADX WARN: Code duplicated, block: B:103:0x0350  */
    /* JADX WARN: Code duplicated, block: B:104:0x0355  */
    /* JADX WARN: Code duplicated, block: B:106:0x039b  */
    /* JADX WARN: Code duplicated, block: B:109:0x03a8  */
    /* JADX WARN: Code duplicated, block: B:113:0x042c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:114:0x042d  */
    /* JADX WARN: Code duplicated, block: B:125:0x03ac A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:46:0x01af  */
    /* JADX WARN: Code duplicated, block: B:49:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:56:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:58:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:59:0x0202  */
    /* JADX WARN: Code duplicated, block: B:67:0x0222  */
    /* JADX WARN: Code duplicated, block: B:69:0x022a  */
    /* JADX WARN: Code duplicated, block: B:72:0x0237  */
    /* JADX WARN: Code duplicated, block: B:75:0x023c  */
    /* JADX WARN: Code duplicated, block: B:76:0x0241  */
    /* JADX WARN: Code duplicated, block: B:79:0x0247  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:80:0x024c  */
    /* JADX WARN: Code duplicated, block: B:83:0x0258  */
    /* JADX WARN: Code duplicated, block: B:85:0x02d3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:86:0x02d4  */
    /* JADX WARN: Code duplicated, block: B:88:0x02e4  */
    /* JADX WARN: Code duplicated, block: B:91:0x0305  */
    /* JADX WARN: Code duplicated, block: B:95:0x0325  */
    /* JADX WARN: Code duplicated, block: B:98:0x0331  */
    static /* synthetic */ Object load$suspendImpl(OnepaceProvider $this, String url, Continuation<? super LoadResponse> continuation) {
        C00181 c00181;
        Object obj;
        Object objDecodeFromString;
        int i;
        Object obj2;
        int i2;
        String url2;
        Media media;
        OnepaceProvider it$iv$iv;
        Document document;
        String mediaType;
        String strSubstringAfter$default;
        String ArcINT;
        Element element;
        String mediaType2;
        String title;
        Element elementSelectFirst;
        Element elementSelectFirst2;
        String strAttr;
        String plot;
        Element elementSelectFirst3;
        Element elementSelectFirst4;
        String strSubstringBefore$default;
        String strAttr2;
        Integer year;
        Elements elementsSelect;
        Elements lst;
        Integer year2;
        Iterable $this$mapNotNull$iv;
        int $i$f$mapNotNull;
        Collection destination$iv$iv;
        Element element2;
        String title2;
        String poster;
        String plot2;
        Elements lst2;
        Element element3;
        String poster2;
        Integer year3;
        OnepaceProvider $this2;
        Element it;
        Element elementSelectFirst5;
        final String name;
        Element elementSelectFirst6;
        String url3;
        Episode episodeNewEpisode;
        String href;
        Element elementSelectFirst7;
        String strText;
        String strText2;
        String strText3;
        if (continuation instanceof C00181) {
            c00181 = (C00181) continuation;
            if ((c00181.label & Integer.MIN_VALUE) != 0) {
                c00181.label -= Integer.MIN_VALUE;
            } else {
                c00181 = $this.new C00181(continuation);
            }
        } else {
            c00181 = $this.new C00181(continuation);
        }
        C00181 c00182 = c00181;
        Object $result = c00182.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00182.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                AppUtils appUtils = AppUtils.INSTANCE;
                try {
                    Result.Companion companion = Result.Companion;
                    KType kTypeTypeOf = Reflection.typeOf(Media.class);
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                    break;
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (Result.exceptionOrNull-impl(obj) != null) {
                    try {
                        Result.Companion companion3 = Result.Companion;
                        obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Media.class), (List) null, 2, (Object) null));
                    } catch (Throwable th2) {
                        Result.Companion companion4 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th2));
                    }
                    break;
                }
                if (Result.isFailure-impl(obj)) {
                    obj = null;
                }
                DeserializationStrategy deserializationStrategy = (KSerializer) obj;
                if (deserializationStrategy != null) {
                    try {
                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, url);
                    } catch (SerializationException e) {
                        ArchComponentExtKt.logError(e);
                        ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv.readValue(url, new TypeReference<Media>() { // from class: com.phisher98.OnepaceProvider$load$suspendImpl$$inlined$parseJson$1
                        });
                    } catch (Throwable th3) {
                        ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv2.readValue(url, new TypeReference<Media>() { // from class: com.phisher98.OnepaceProvider$load$suspendImpl$$inlined$parseJson$1
                        });
                    }
                    break;
                } else {
                    ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv3.readValue(url, new TypeReference<Media>() { // from class: com.phisher98.OnepaceProvider$load$suspendImpl$$inlined$parseJson$1
                    });
                }
                Media media2 = (Media) objDecodeFromString;
                Requests app = MainActivityKt.getApp();
                String url4 = media2.getUrl();
                c00182.L$0 = $this;
                c00182.L$1 = url;
                c00182.L$2 = media2;
                c00182.label = 1;
                i = 1;
                obj2 = coroutine_suspended;
                i2 = 2;
                $result = Requests.get$default(app, url4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00182, 4094, (Object) null);
                c00182 = c00182;
                if ($result == obj2) {
                    return obj2;
                }
                url2 = url;
                media = media2;
                it$iv$iv = $this;
                document = ((NiceResponse) $result).getDocument();
                mediaType = media.getMediaType();
                if (mediaType != null) {
                    strSubstringAfter$default = StringsKt.substringAfter$default(mediaType, "Arc ", (String) null, i2, (Object) null);
                } else {
                    strSubstringAfter$default = null;
                }
                ArcINT = strSubstringAfter$default;
                element = document.selectFirst("div.seasons.aa-crd > div.seasons-bx:contains(" + ArcINT + ')');
                mediaType2 = media.getMediaType();
                if (mediaType2 == null) {
                    mediaType2 = "No Title";
                }
                title = mediaType2;
                elementSelectFirst = document.selectFirst("div.entry-content p");
                if (elementSelectFirst != null || (strText3 = elementSelectFirst.text()) == null || (strAttr = StringsKt.trim(strText3).toString()) == null) {
                    elementSelectFirst2 = document.selectFirst("meta[name=twitter:description]");
                    if (elementSelectFirst2 != null) {
                        strAttr = elementSelectFirst2.attr("content");
                    } else {
                        strAttr = null;
                    }
                }
                plot = strAttr;
                elementSelectFirst3 = document.selectFirst("span.year");
                if (elementSelectFirst3 != null || (strText2 = elementSelectFirst3.text()) == null || (strSubstringBefore$default = StringsKt.trim(strText2).toString()) == null) {
                    elementSelectFirst4 = document.selectFirst("meta[property=og:updated_time]");
                    if (elementSelectFirst4 != null || (strAttr2 = elementSelectFirst4.attr("content")) == null) {
                        strSubstringBefore$default = null;
                    } else {
                        strSubstringBefore$default = StringsKt.substringBefore$default(strAttr2, "-", (String) null, i2, (Object) null);
                    }
                }
                if (strSubstringBefore$default != null) {
                    year = StringsKt.toIntOrNull(strSubstringBefore$default);
                } else {
                    year = null;
                }
                if (element != null) {
                    elementsSelect = element.select("ul.seasons-lst.anm-a li");
                } else {
                    elementsSelect = null;
                }
                lst = elementsSelect;
                Intrinsics.checkNotNull(lst);
                if (lst.isEmpty()) {
                    TvType tvType = TvType.Movie;
                    String json = AppUtils.INSTANCE.toJson(new com.phisher98.Media(media.getUrl(), null, Boxing.boxInt(i), 2, null));
                    C00192 c00192 = new C00192("https://images3.alphacoders.com/134/1342304.jpeg", plot, year, null);
                    c00182.L$0 = SpillingKt.nullOutSpilledVariable(it$iv$iv);
                    c00182.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                    c00182.L$2 = SpillingKt.nullOutSpilledVariable(media);
                    c00182.L$3 = SpillingKt.nullOutSpilledVariable(document);
                    c00182.L$4 = SpillingKt.nullOutSpilledVariable(ArcINT);
                    c00182.L$5 = SpillingKt.nullOutSpilledVariable(element);
                    c00182.L$6 = SpillingKt.nullOutSpilledVariable(title);
                    c00182.L$7 = SpillingKt.nullOutSpilledVariable("https://images3.alphacoders.com/134/1342304.jpeg");
                    c00182.L$8 = SpillingKt.nullOutSpilledVariable(plot);
                    c00182.L$9 = SpillingKt.nullOutSpilledVariable(year);
                    c00182.L$10 = SpillingKt.nullOutSpilledVariable(lst);
                    c00182.label = 2;
                    $result = MainAPIKt.newMovieLoadResponse(it$iv$iv, title, url2, tvType, json, c00192, c00182);
                    if ($result == obj2) {
                        return obj2;
                    }
                    return (LoadResponse) $result;
                }
                year2 = year;
                $this$mapNotNull$iv = element.select("ul.seasons-lst.anm-a li");
                $i$f$mapNotNull = 0;
                destination$iv$iv = new ArrayList();
                for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                    $this2 = it$iv$iv;
                    it = (Element) element$iv$iv$iv;
                    Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                    elementSelectFirst5 = it.selectFirst("h3.title");
                    if (elementSelectFirst5 != null || (name = elementSelectFirst5.ownText()) == null) {
                        name = "null";
                    }
                    String title3 = title;
                    elementSelectFirst6 = it.selectFirst("a");
                    if (elementSelectFirst6 != null) {
                        url3 = url2;
                        href = elementSelectFirst6.attr("href");
                        if (href == null) {
                            final String poster3 = "https://raw.githubusercontent.com/phisher98/TVVVV/refs/heads/main/OnePack.png";
                            elementSelectFirst7 = it.selectFirst("h3.title > span");
                            if (elementSelectFirst7 != null) {
                                strText = elementSelectFirst7.text();
                            } else {
                                strText = null;
                            }
                            $i$f$mapNotNull = $i$f$mapNotNull;
                            element = element;
                            String seasonnumber = StringsKt.substringBefore$default(StringsKt.substringAfter$default(String.valueOf(strText), "S", (String) null, 2, (Object) null), "-", (String) null, 2, (Object) null);
                            final Integer season = StringsKt.toIntOrNull(seasonnumber);
                            String seasonnumber2 = AppUtils.INSTANCE.toJson(new AnimeDekhoProvider.Media(href, null, Boxing.boxInt(2), 2, null));
                            episodeNewEpisode = MainAPIKt.newEpisode($this2, seasonnumber2, new Function1() { // from class: com.phisher98.OnepaceProvider$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj3) {
                                    return OnepaceProvider.load$lambda$0$0(name, poster3, season, (Episode) obj3);
                                }
                            });
                        }
                        if (episodeNewEpisode != null) {
                            destination$iv$iv.add(episodeNewEpisode);
                        }
                        it$iv$iv = $this2;
                        $this$mapNotNull$iv = $this$mapNotNull$iv2;
                        element = element;
                        title = title3;
                        url2 = url3;
                        $i$f$mapNotNull = $i$f$mapNotNull;
                    } else {
                        url3 = url2;
                    }
                    episodeNewEpisode = null;
                    if (episodeNewEpisode != null) {
                        destination$iv$iv.add(episodeNewEpisode);
                    }
                    it$iv$iv = $this2;
                    $this$mapNotNull$iv = $this$mapNotNull$iv2;
                    element = element;
                    title = title3;
                    url2 = url3;
                    $i$f$mapNotNull = $i$f$mapNotNull;
                }
                OnepaceProvider $this3 = it$iv$iv;
                element2 = element;
                List episodes = (List) destination$iv$iv;
                TvType tvType2 = TvType.TvSeries;
                C00203 c00203 = new C00203("https://images3.alphacoders.com/134/1342304.jpeg", plot, year2, null);
                c00182.L$0 = SpillingKt.nullOutSpilledVariable($this3);
                c00182.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                c00182.L$2 = SpillingKt.nullOutSpilledVariable(media);
                c00182.L$3 = SpillingKt.nullOutSpilledVariable(document);
                c00182.L$4 = SpillingKt.nullOutSpilledVariable(ArcINT);
                c00182.L$5 = SpillingKt.nullOutSpilledVariable(element2);
                c00182.L$6 = SpillingKt.nullOutSpilledVariable(title);
                c00182.L$7 = SpillingKt.nullOutSpilledVariable("https://images3.alphacoders.com/134/1342304.jpeg");
                c00182.L$8 = SpillingKt.nullOutSpilledVariable(plot);
                c00182.L$9 = SpillingKt.nullOutSpilledVariable(year2);
                c00182.L$10 = SpillingKt.nullOutSpilledVariable(lst);
                c00182.L$11 = SpillingKt.nullOutSpilledVariable(episodes);
                c00182.label = 3;
                $result = MainAPIKt.newTvSeriesLoadResponse($this3, title, url2, tvType2, episodes, c00203, c00182);
                if ($result == obj2) {
                    return obj2;
                }
                title2 = title;
                poster = "https://images3.alphacoders.com/134/1342304.jpeg";
                plot2 = plot;
                lst2 = lst;
                element3 = element2;
                poster2 = url2;
                year3 = year2;
                return (LoadResponse) $result;
            case 1:
                Media media3 = (Media) c00182.L$2;
                String url5 = (String) c00182.L$1;
                OnepaceProvider $this4 = (OnepaceProvider) c00182.L$0;
                ResultKt.throwOnFailure($result);
                media = media3;
                it$iv$iv = $this4;
                obj2 = coroutine_suspended;
                url2 = url5;
                i2 = 2;
                i = 1;
                document = ((NiceResponse) $result).getDocument();
                mediaType = media.getMediaType();
                if (mediaType != null) {
                    strSubstringAfter$default = StringsKt.substringAfter$default(mediaType, "Arc ", (String) null, i2, (Object) null);
                } else {
                    strSubstringAfter$default = null;
                }
                ArcINT = strSubstringAfter$default;
                element = document.selectFirst("div.seasons.aa-crd > div.seasons-bx:contains(" + ArcINT + ')');
                mediaType2 = media.getMediaType();
                if (mediaType2 == null) {
                    mediaType2 = "No Title";
                }
                title = mediaType2;
                elementSelectFirst = document.selectFirst("div.entry-content p");
                if (elementSelectFirst != null) {
                    elementSelectFirst2 = document.selectFirst("meta[name=twitter:description]");
                    if (elementSelectFirst2 != null) {
                        strAttr = elementSelectFirst2.attr("content");
                    } else {
                        strAttr = null;
                    }
                } else {
                    elementSelectFirst2 = document.selectFirst("meta[name=twitter:description]");
                    if (elementSelectFirst2 != null) {
                        strAttr = elementSelectFirst2.attr("content");
                    } else {
                        strAttr = null;
                    }
                }
                plot = strAttr;
                elementSelectFirst3 = document.selectFirst("span.year");
                if (elementSelectFirst3 != null) {
                    elementSelectFirst4 = document.selectFirst("meta[property=og:updated_time]");
                    if (elementSelectFirst4 != null) {
                        strSubstringBefore$default = null;
                    } else {
                        strSubstringBefore$default = null;
                    }
                } else {
                    elementSelectFirst4 = document.selectFirst("meta[property=og:updated_time]");
                    if (elementSelectFirst4 != null) {
                        strSubstringBefore$default = null;
                    } else {
                        strSubstringBefore$default = null;
                    }
                }
                if (strSubstringBefore$default != null) {
                    year = StringsKt.toIntOrNull(strSubstringBefore$default);
                } else {
                    year = null;
                }
                if (element != null) {
                    elementsSelect = element.select("ul.seasons-lst.anm-a li");
                } else {
                    elementsSelect = null;
                }
                lst = elementsSelect;
                Intrinsics.checkNotNull(lst);
                if (lst.isEmpty()) {
                    TvType tvType3 = TvType.Movie;
                    String json2 = AppUtils.INSTANCE.toJson(new com.phisher98.Media(media.getUrl(), null, Boxing.boxInt(i), 2, null));
                    C00192 c00193 = new C00192("https://images3.alphacoders.com/134/1342304.jpeg", plot, year, null);
                    c00182.L$0 = SpillingKt.nullOutSpilledVariable(it$iv$iv);
                    c00182.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                    c00182.L$2 = SpillingKt.nullOutSpilledVariable(media);
                    c00182.L$3 = SpillingKt.nullOutSpilledVariable(document);
                    c00182.L$4 = SpillingKt.nullOutSpilledVariable(ArcINT);
                    c00182.L$5 = SpillingKt.nullOutSpilledVariable(element);
                    c00182.L$6 = SpillingKt.nullOutSpilledVariable(title);
                    c00182.L$7 = SpillingKt.nullOutSpilledVariable("https://images3.alphacoders.com/134/1342304.jpeg");
                    c00182.L$8 = SpillingKt.nullOutSpilledVariable(plot);
                    c00182.L$9 = SpillingKt.nullOutSpilledVariable(year);
                    c00182.L$10 = SpillingKt.nullOutSpilledVariable(lst);
                    c00182.label = 2;
                    $result = MainAPIKt.newMovieLoadResponse(it$iv$iv, title, url2, tvType3, json2, c00193, c00182);
                    if ($result == obj2) {
                        return obj2;
                    }
                    return (LoadResponse) $result;
                }
                year2 = year;
                $this$mapNotNull$iv = element.select("ul.seasons-lst.anm-a li");
                $i$f$mapNotNull = 0;
                destination$iv$iv = new ArrayList();
                while (r24.hasNext()) {
                    $this2 = it$iv$iv;
                    it = (Element) element$iv$iv$iv;
                    Iterable $this$mapNotNull$iv3 = $this$mapNotNull$iv;
                    elementSelectFirst5 = it.selectFirst("h3.title");
                    if (elementSelectFirst5 != null) {
                        name = "null";
                    } else {
                        name = "null";
                    }
                    String title4 = title;
                    elementSelectFirst6 = it.selectFirst("a");
                    if (elementSelectFirst6 != null) {
                        url3 = url2;
                        href = elementSelectFirst6.attr("href");
                        if (href == null) {
                            final String poster4 = "https://raw.githubusercontent.com/phisher98/TVVVV/refs/heads/main/OnePack.png";
                            elementSelectFirst7 = it.selectFirst("h3.title > span");
                            if (elementSelectFirst7 != null) {
                                strText = elementSelectFirst7.text();
                            } else {
                                strText = null;
                            }
                            $i$f$mapNotNull = $i$f$mapNotNull;
                            element = element;
                            String seasonnumber3 = StringsKt.substringBefore$default(StringsKt.substringAfter$default(String.valueOf(strText), "S", (String) null, 2, (Object) null), "-", (String) null, 2, (Object) null);
                            final Integer season2 = StringsKt.toIntOrNull(seasonnumber3);
                            String seasonnumber4 = AppUtils.INSTANCE.toJson(new AnimeDekhoProvider.Media(href, null, Boxing.boxInt(2), 2, null));
                            episodeNewEpisode = MainAPIKt.newEpisode($this2, seasonnumber4, new Function1() { // from class: com.phisher98.OnepaceProvider$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj3) {
                                    return OnepaceProvider.load$lambda$0$0(name, poster4, season2, (Episode) obj3);
                                }
                            });
                        }
                        if (episodeNewEpisode != null) {
                            destination$iv$iv.add(episodeNewEpisode);
                        }
                        it$iv$iv = $this2;
                        $this$mapNotNull$iv = $this$mapNotNull$iv3;
                        element = element;
                        title = title4;
                        url2 = url3;
                        $i$f$mapNotNull = $i$f$mapNotNull;
                    } else {
                        url3 = url2;
                    }
                    episodeNewEpisode = null;
                    if (episodeNewEpisode != null) {
                        destination$iv$iv.add(episodeNewEpisode);
                    }
                    it$iv$iv = $this2;
                    $this$mapNotNull$iv = $this$mapNotNull$iv3;
                    element = element;
                    title = title4;
                    url2 = url3;
                    $i$f$mapNotNull = $i$f$mapNotNull;
                }
                OnepaceProvider $this5 = it$iv$iv;
                element2 = element;
                List episodes2 = (List) destination$iv$iv;
                TvType tvType4 = TvType.TvSeries;
                C00203 c00204 = new C00203("https://images3.alphacoders.com/134/1342304.jpeg", plot, year2, null);
                c00182.L$0 = SpillingKt.nullOutSpilledVariable($this5);
                c00182.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                c00182.L$2 = SpillingKt.nullOutSpilledVariable(media);
                c00182.L$3 = SpillingKt.nullOutSpilledVariable(document);
                c00182.L$4 = SpillingKt.nullOutSpilledVariable(ArcINT);
                c00182.L$5 = SpillingKt.nullOutSpilledVariable(element2);
                c00182.L$6 = SpillingKt.nullOutSpilledVariable(title);
                c00182.L$7 = SpillingKt.nullOutSpilledVariable("https://images3.alphacoders.com/134/1342304.jpeg");
                c00182.L$8 = SpillingKt.nullOutSpilledVariable(plot);
                c00182.L$9 = SpillingKt.nullOutSpilledVariable(year2);
                c00182.L$10 = SpillingKt.nullOutSpilledVariable(lst);
                c00182.L$11 = SpillingKt.nullOutSpilledVariable(episodes2);
                c00182.label = 3;
                $result = MainAPIKt.newTvSeriesLoadResponse($this5, title, url2, tvType4, episodes2, c00204, c00182);
                if ($result == obj2) {
                    return obj2;
                }
                title2 = title;
                poster = "https://images3.alphacoders.com/134/1342304.jpeg";
                plot2 = plot;
                lst2 = lst;
                element3 = element2;
                poster2 = url2;
                year3 = year2;
                return (LoadResponse) $result;
            case 2:
                ResultKt.throwOnFailure($result);
                return (LoadResponse) $result;
            case 3:
                lst2 = (Elements) c00182.L$10;
                year3 = (Integer) c00182.L$9;
                plot2 = (String) c00182.L$8;
                poster = (String) c00182.L$7;
                title2 = (String) c00182.L$6;
                element3 = (Element) c00182.L$5;
                ArcINT = (String) c00182.L$4;
                document = (Document) c00182.L$3;
                media = (Media) c00182.L$2;
                poster2 = (String) c00182.L$1;
                ResultKt.throwOnFailure($result);
                return (LoadResponse) $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.phisher98.OnepaceProvider$load$2 */
    /* JADX INFO: compiled from: OnePace.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.OnepaceProvider$load$2", f = "OnePace.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00192 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $plot;
        final /* synthetic */ String $poster;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00192(String str, String str2, Integer num, Continuation<? super C00192> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$plot = str2;
            this.$year = num;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00192 = new C00192(this.$poster, this.$plot, this.$year, continuation);
            c00192.L$0 = obj;
            return c00192;
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
                    $this$newMovieLoadResponse.setPosterUrl(this.$poster);
                    $this$newMovieLoadResponse.setPlot(this.$plot);
                    $this$newMovieLoadResponse.setYear(this.$year);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$0$0(String $name, String $poster, Integer $season, Episode $this$newEpisode) {
        $this$newEpisode.setName($name);
        $this$newEpisode.setPosterUrl($poster);
        $this$newEpisode.setSeason($season);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.phisher98.OnepaceProvider$load$3 */
    /* JADX INFO: compiled from: OnePace.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.OnepaceProvider$load$3", f = "OnePace.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00203 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $plot;
        final /* synthetic */ String $poster;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00203(String str, String str2, Integer num, Continuation<? super C00203> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$plot = str2;
            this.$year = num;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00203 = new C00203(this.$poster, this.$plot, this.$year, continuation);
            c00203.L$0 = obj;
            return c00203;
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
                    $this$newTvSeriesLoadResponse.setPosterUrl(this.$poster);
                    $this$newTvSeriesLoadResponse.setPlot(this.$plot);
                    $this$newTvSeriesLoadResponse.setYear(this.$year);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.lagradost.cloudstream3.ErrorLoadingException */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    static /* synthetic */ Object loadLinks$suspendImpl(OnepaceProvider $this, String data, boolean isCasting, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super Boolean> continuation) throws ErrorLoadingException {
        C00211 c00211;
        Object obj;
        Object objDecodeFromString;
        Object obj2;
        int i;
        OnepaceProvider $this2;
        String data2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        Media media;
        boolean isCasting2;
        Element elementSelectFirst;
        String body;
        List groupValues;
        boolean z;
        if (continuation instanceof C00211) {
            c00211 = (C00211) continuation;
            if ((c00211.label & Integer.MIN_VALUE) != 0) {
                c00211.label -= Integer.MIN_VALUE;
            } else {
                c00211 = $this.new C00211(continuation);
            }
        } else {
            c00211 = $this.new C00211(continuation);
        }
        C00211 c00212 = c00211;
        Object $result = c00212.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00212.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                AppUtils appUtils = AppUtils.INSTANCE;
                try {
                    Result.Companion companion = Result.Companion;
                    KType kTypeTypeOf = Reflection.typeOf(Media.class);
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                    break;
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (Result.exceptionOrNull-impl(obj) != null) {
                    try {
                        Result.Companion companion3 = Result.Companion;
                        obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Media.class), (List) null, 2, (Object) null));
                    } catch (Throwable th2) {
                        Result.Companion companion4 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th2));
                    }
                    break;
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
                        objDecodeFromString = $this$readValue$iv$iv.readValue(data, new TypeReference<Media>() { // from class: com.phisher98.OnepaceProvider$loadLinks$suspendImpl$$inlined$parseJson$1
                        });
                    } catch (Throwable th3) {
                        ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv2.readValue(data, new TypeReference<Media>() { // from class: com.phisher98.OnepaceProvider$loadLinks$suspendImpl$$inlined$parseJson$1
                        });
                    }
                    break;
                } else {
                    ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv3.readValue(data, new TypeReference<Media>() { // from class: com.phisher98.OnepaceProvider$loadLinks$suspendImpl$$inlined$parseJson$1
                    });
                }
                Media media2 = (Media) objDecodeFromString;
                Requests app = MainActivityKt.getApp();
                String url = media2.getUrl();
                c00212.L$0 = $this;
                c00212.L$1 = SpillingKt.nullOutSpilledVariable(data);
                c00212.L$2 = function1;
                c00212.L$3 = function2;
                c00212.L$4 = media2;
                c00212.Z$0 = isCasting;
                c00212.label = 1;
                obj2 = coroutine_suspended;
                i = 2;
                $result = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00212, 4094, (Object) null);
                c00212 = c00212;
                if ($result == obj2) {
                    return obj2;
                }
                $this2 = $this;
                data2 = data;
                function3 = function1;
                function4 = function2;
                media = media2;
                isCasting2 = isCasting;
                elementSelectFirst = ((NiceResponse) $result).getDocument().selectFirst("body");
                if (elementSelectFirst != null || (body = elementSelectFirst.attr("class")) == null) {
                    return Boxing.boxBoolean(false);
                }
                MatchResult matchResultFind$default = Regex.find$default(new Regex("(?:term|postid)-(\\d+)"), body, 0, i, (Object) null);
                if (matchResultFind$default != null && (groupValues = matchResultFind$default.getGroupValues()) != null) {
                    z = true;
                    String term = (String) groupValues.get(1);
                    if (term != null) {
                        List list = CollectionsKt.toList(new IntRange(0, 4));
                        C00222 c00222 = $this2.new C00222(term, media, function3, function4, null);
                        c00212.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                        c00212.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                        c00212.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                        c00212.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                        c00212.L$4 = SpillingKt.nullOutSpilledVariable(media);
                        c00212.L$5 = SpillingKt.nullOutSpilledVariable(body);
                        c00212.L$6 = SpillingKt.nullOutSpilledVariable(term);
                        c00212.Z$0 = isCasting2;
                        c00212.label = i;
                        if (ParCollectionsKt.amap(list, c00222, c00212) == obj2) {
                            return obj2;
                        }
                        return Boxing.boxBoolean(z);
                    }
                }
                throw new ErrorLoadingException("no id found");
            case 1:
                isCasting2 = c00212.Z$0;
                Media media3 = (Media) c00212.L$4;
                function4 = (Function1) c00212.L$3;
                Function1<? super SubtitleFile, Unit> function5 = (Function1) c00212.L$2;
                data2 = (String) c00212.L$1;
                OnepaceProvider $this3 = (OnepaceProvider) c00212.L$0;
                ResultKt.throwOnFailure($result);
                $this2 = $this3;
                obj2 = coroutine_suspended;
                media = media3;
                function3 = function5;
                i = 2;
                elementSelectFirst = ((NiceResponse) $result).getDocument().selectFirst("body");
                if (elementSelectFirst != null) {
                    break;
                }
                return Boxing.boxBoolean(false);
            case 2:
                boolean z2 = c00212.Z$0;
                ResultKt.throwOnFailure($result);
                z = true;
                return Boxing.boxBoolean(z);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.phisher98.OnepaceProvider$loadLinks$2 */
    /* JADX INFO: compiled from: OnePace.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "i", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.OnepaceProvider$loadLinks$2", f = "OnePace.kt", i = {0, 1, 1}, l = {132, 135}, m = "invokeSuspend", n = {"i", "link", "i"}, nl = {133, 136}, s = {"I$0", "L$0", "I$0"}, v = 2)
    static final class C00222 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Media $media;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        final /* synthetic */ String $term;
        /* synthetic */ int I$0;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00222(String str, Media media, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00222> continuation) {
            super(2, continuation);
            this.$term = str;
            this.$media = media;
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00222 = OnepaceProvider.this.new C00222(this.$term, this.$media, this.$subtitleCallback, this.$callback, continuation);
            c00222.I$0 = ((Number) obj).intValue();
            return c00222;
        }

        public final Object invoke(int i, Continuation<? super Unit> continuation) {
            return create(Integer.valueOf(i), continuation).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke(((Number) obj).intValue(), (Continuation<? super Unit>) obj2);
        }

        public final Object invokeSuspend(Object $result) {
            Object obj;
            Element elementSelectFirst;
            String link;
            int i = this.I$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.I$0 = i;
                    this.label = 1;
                    obj = Requests.get$default(MainActivityKt.getApp(), OnepaceProvider.this.getMainUrl() + "/?trdekho=" + i + "&trid=" + this.$term + "&trtype=" + this.$media.getMediaType(), (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4094, (Object) null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    elementSelectFirst = ((NiceResponse) obj).getDocument().selectFirst("iframe");
                    if (elementSelectFirst != null || (link = elementSelectFirst.attr("src")) == null) {
                        return Unit.INSTANCE;
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(link);
                    this.I$0 = i;
                    this.label = 2;
                    if (ExtractorApiKt.loadExtractor(link, this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                case 1:
                    ResultKt.throwOnFailure($result);
                    obj = $result;
                    elementSelectFirst = ((NiceResponse) obj).getDocument().selectFirst("iframe");
                    if (elementSelectFirst != null) {
                        break;
                    }
                    return Unit.INSTANCE;
                case 2:
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: compiled from: OnePace.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/phisher98/OnepaceProvider$Media;", "", "url", "", "poster", "mediaType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getPoster", "getMediaType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "AnimeDekhoProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Media {

        @Nullable
        private final String mediaType;

        @Nullable
        private final String poster;

        @NotNull
        private final String url;

        public static /* synthetic */ Media copy$default(Media media, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = media.url;
            }
            if ((i & 2) != 0) {
                str2 = media.poster;
            }
            if ((i & 4) != 0) {
                str3 = media.mediaType;
            }
            return media.copy(str, str2, str3);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getPoster() {
            return this.poster;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getMediaType() {
            return this.mediaType;
        }

        @NotNull
        public final Media copy(@NotNull String url, @Nullable String poster, @Nullable String mediaType) {
            return new Media(url, poster, mediaType);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Media)) {
                return false;
            }
            Media media = (Media) other;
            return Intrinsics.areEqual(this.url, media.url) && Intrinsics.areEqual(this.poster, media.poster) && Intrinsics.areEqual(this.mediaType, media.mediaType);
        }

        public int hashCode() {
            return (((this.url.hashCode() * 31) + (this.poster == null ? 0 : this.poster.hashCode())) * 31) + (this.mediaType != null ? this.mediaType.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Media(url=" + this.url + ", poster=" + this.poster + ", mediaType=" + this.mediaType + ')';
        }

        public Media(@NotNull String url, @Nullable String poster, @Nullable String mediaType) {
            this.url = url;
            this.poster = poster;
            this.mediaType = mediaType;
        }

        public /* synthetic */ Media(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
        }

        @Nullable
        public final String getMediaType() {
            return this.mediaType;
        }

        @Nullable
        public final String getPoster() {
            return this.poster;
        }

        @NotNull
        public final String getUrl() {
            return this.url;
        }
    }

    private final String getsrcAttribute(Element $this$getsrcAttribute) {
        String src = $this$getsrcAttribute.attr("src");
        String dataSrc = $this$getsrcAttribute.attr("data-src");
        String lazysrc = $this$getsrcAttribute.attr("data-lazy-src");
        if (StringsKt.startsWith$default(src, "http", false, 2, (Object) null)) {
            return src;
        }
        if (StringsKt.startsWith$default(dataSrc, "http", false, 2, (Object) null)) {
            return dataSrc;
        }
        return StringsKt.startsWith$default(lazysrc, "http", false, 2, (Object) null) ? lazysrc : "";
    }
}
