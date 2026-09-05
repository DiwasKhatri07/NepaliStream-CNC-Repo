package com.tamilblasters;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.MovieLoadResponse;
import com.lagradost.cloudstream3.MovieSearchResponse;
import com.lagradost.cloudstream3.ParCollectionsKt;
import com.lagradost.cloudstream3.SearchResponse;
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
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
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
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
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

/* JADX INFO: compiled from: TamilblastersProvider.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Tamilblasters/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u00019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0096@¢\u0006\u0002\u0010 J\u000e\u0010!\u001a\u0004\u0018\u00010\"*\u00020#H\u0002J\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0%2\u0006\u0010&\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010'J\u0018\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010'JF\u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00172\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u0002010/2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u0002010/H\u0096@¢\u0006\u0002\u00104J\u0016\u00105\u001a\b\u0012\u0004\u0012\u0002060%2\u0006\u00107\u001a\u000208H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u0014\u0010\u0016\u001a\u00020\u0017X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006:"}, d2 = {"Lcom/tamilblasters/TamilblastersProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "streamhg", "name", "getName", "setName", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "lang", "getLang", "setLang", "hasMainPage", "", "getHasMainPage", "()Z", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lorg/jsoup/nodes/Element;", "search", "", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "extractVideos", "Lcom/tamilblasters/TamilblastersProvider$VideoEntry;", "document", "Lorg/jsoup/nodes/Document;", "VideoEntry", "Tamilblasters"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTamilblastersProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TamilblastersProvider.kt\ncom/tamilblasters/TamilblastersProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 5 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,148:1\n1795#2,10:149\n2068#2:159\n2069#2:161\n1805#2:162\n1795#2,10:163\n2068#2:173\n2069#2:175\n1805#2:176\n296#2,2:177\n1739#2:180\n1814#2,3:181\n1795#2,10:207\n2068#2:217\n296#2,2:218\n2069#2:222\n1805#2:223\n1#3:160\n1#3:174\n1#3:179\n1#3:187\n1#3:220\n1#3:221\n93#4,2:184\n63#4:186\n64#4,15:188\n95#4,2:205\n50#5:203\n43#5:204\n*S KotlinDebug\n*F\n+ 1 TamilblastersProvider.kt\ncom/tamilblasters/TamilblastersProvider\n*L\n40#1:149,10\n40#1:159\n40#1:161\n40#1:162\n57#1:163,10\n57#1:173\n57#1:175\n57#1:176\n72#1:177,2\n75#1:180\n75#1:181,3\n141#1:207,10\n141#1:217\n143#1:218,2\n141#1:222\n141#1:223\n40#1:160\n57#1:174\n101#1:187\n141#1:221\n101#1:184,2\n101#1:186\n101#1:188,15\n101#1:205,2\n101#1:203\n101#1:204\n*E\n"})
public final class TamilblastersProvider extends MainAPI {

    @NotNull
    private String mainUrl = (String) BuildersKt.runBlockingK(EmptyCoroutineContext.INSTANCE, new TamilblastersProvider$mainUrl$1(null));

    @NotNull
    private final String streamhg = "https://cavanhabg.com";

    @NotNull
    private String name = "Tamilblasters";

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries});

    @NotNull
    private String lang = "ta";
    private final boolean hasMainPage = true;

    /* JADX INFO: renamed from: com.tamilblasters.TamilblastersProvider$getMainPage$1 */
    /* JADX INFO: compiled from: TamilblastersProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.tamilblasters.TamilblastersProvider", f = "TamilblastersProvider.kt", i = {0, 0, 0}, l = {39}, m = "getMainPage", n = {"request", "url", "page"}, nl = {40}, s = {"L$0", "L$1", "I$0"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TamilblastersProvider.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.tamilblasters.TamilblastersProvider$load$1 */
    /* JADX INFO: compiled from: TamilblastersProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.tamilblasters.TamilblastersProvider", f = "TamilblastersProvider.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {65, 80, 86}, m = "load", n = {"url", "url", "document", "ogdesc", "title", "year", "type", "posterUrl", "plotParagraph", "desc", "episodes", "url", "document", "ogdesc", "title", "year", "type", "posterUrl", "plotParagraph", "desc"}, nl = {66, 86, 74}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8"}, v = 2)
    static final class C00021 extends ContinuationImpl {
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
        int label;
        /* synthetic */ Object result;

        C00021(Continuation<? super C00021> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TamilblastersProvider.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.tamilblasters.TamilblastersProvider$loadLinks$1 */
    /* JADX INFO: compiled from: TamilblastersProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.tamilblasters.TamilblastersProvider", f = "TamilblastersProvider.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {108, 112, 113}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "loadData", "streamurl", "isCasting", "data", "subtitleCallback", "callback", "isCasting", "data", "subtitleCallback", "callback", "doc", "isCasting"}, nl = {109, 113, 135}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0"}, v = 2)
    static final class C00051 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00051(Continuation<? super C00051> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TamilblastersProvider.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.tamilblasters.TamilblastersProvider$search$1 */
    /* JADX INFO: compiled from: TamilblastersProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.tamilblasters.TamilblastersProvider", f = "TamilblastersProvider.kt", i = {0}, l = {56}, m = "search", n = {"query"}, nl = {57}, s = {"L$0"}, v = 2)
    static final class C00071 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00071(Continuation<? super C00071> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TamilblastersProvider.this.search(null, (Continuation) this);
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

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    @NotNull
    public String getLang() {
        return this.lang;
    }

    public void setLang(@NotNull String str) {
        this.lang = str;
    }

    public boolean getHasMainPage() {
        return this.hasMainPage;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00011 c00011;
        int page2 = page;
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
        Object $result = c00011.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00011.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String url = page2 == 1 ? getMainUrl() : getMainUrl() + "/page/" + page2;
                Requests app = MainActivityKt.getApp();
                c00011.L$0 = SpillingKt.nullOutSpilledVariable(request);
                c00011.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00011.I$0 = page2;
                c00011.label = 1;
                $result = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00011, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                page2 = c00011.I$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = document.select("div.article-content-col");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            int page3 = page2;
            Element it = (Element) element$iv$iv$iv;
            SearchResponse searchResult = toSearchResult(it);
            if (searchResult != null) {
                destination$iv$iv.add(searchResult);
            }
            page2 = page3;
        }
        List home = (List) destination$iv$iv;
        return MainAPIKt.newHomePageResponse$default("Home", home, (Boolean) null, 4, (Object) null);
    }

    private final SearchResponse toSearchResult(Element $this$toSearchResult) {
        String name;
        String href;
        Element elementSelectFirst = $this$toSearchResult.selectFirst("h2>a");
        if (elementSelectFirst == null || (name = elementSelectFirst.text()) == null) {
            return null;
        }
        Element elementSelectFirst2 = $this$toSearchResult.selectFirst("img");
        final String posterUrl = elementSelectFirst2 != null ? elementSelectFirst2.attr("src") : null;
        Element elementSelectFirst3 = $this$toSearchResult.selectFirst("a");
        if (elementSelectFirst3 == null || (href = elementSelectFirst3.attr("href")) == null) {
            return null;
        }
        return MainAPIKt.newMovieSearchResponse$default(this, name, href, TvType.Movie, false, new Function1() { // from class: com.tamilblasters.TamilblastersProvider$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return TamilblastersProvider.toSearchResult$lambda$0(posterUrl, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResult$lambda$0(String $posterUrl, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($posterUrl);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        C00071 c00071;
        if (continuation instanceof C00071) {
            c00071 = (C00071) continuation;
            if ((c00071.label & Integer.MIN_VALUE) != 0) {
                c00071.label -= Integer.MIN_VALUE;
            } else {
                c00071 = new C00071(continuation);
            }
        } else {
            c00071 = new C00071(continuation);
        }
        Object $result = c00071.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00071.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                String str = getMainUrl() + "/?s=" + query;
                c00071.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00071.label = 1;
                $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00071, 4094, (Object) null);
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
        Document searchDoc = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = searchDoc.select("div.article-content-col");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element it = (Element) element$iv$iv$iv;
            SearchResponse searchResult = toSearchResult(it);
            if (searchResult != null) {
                destination$iv$iv.add(searchResult);
            }
        }
        return (List) destination$iv$iv;
    }

    /* JADX INFO: compiled from: TamilblastersProvider.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/tamilblasters/TamilblastersProvider$VideoEntry;", "", "title", "", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Tamilblasters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class VideoEntry {

        @NotNull
        private final String title;

        @NotNull
        private final String url;

        public static /* synthetic */ VideoEntry copy$default(VideoEntry videoEntry, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = videoEntry.title;
            }
            if ((i & 2) != 0) {
                str2 = videoEntry.url;
            }
            return videoEntry.copy(str, str2);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @NotNull
        public final VideoEntry copy(@NotNull String title, @NotNull String url) {
            return new VideoEntry(title, url);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VideoEntry)) {
                return false;
            }
            VideoEntry videoEntry = (VideoEntry) other;
            return Intrinsics.areEqual(this.title, videoEntry.title) && Intrinsics.areEqual(this.url, videoEntry.url);
        }

        public int hashCode() {
            return (this.title.hashCode() * 31) + this.url.hashCode();
        }

        @NotNull
        public String toString() {
            return "VideoEntry(title=" + this.title + ", url=" + this.url + ')';
        }

        public VideoEntry(@NotNull String title, @NotNull String url) {
            this.title = title;
            this.url = url;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        public final String getUrl() {
            return this.url;
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x012f  */
    /* JADX WARN: Code duplicated, block: B:34:0x0139  */
    /* JADX WARN: Code duplicated, block: B:35:0x013c  */
    /* JADX WARN: Code duplicated, block: B:38:0x0147  */
    /* JADX WARN: Code duplicated, block: B:39:0x014c  */
    /* JADX WARN: Code duplicated, block: B:43:0x0164  */
    /* JADX WARN: Code duplicated, block: B:50:0x0191  */
    /* JADX WARN: Code duplicated, block: B:54:0x019a A[LOOP:0: B:41:0x015c->B:54:0x019a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:58:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:60:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:63:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:66:0x01e3 A[LOOP:1: B:64:0x01dd->B:66:0x01e3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:69:0x027a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:70:0x027b  */
    /* JADX WARN: Code duplicated, block: B:72:0x0289  */
    /* JADX WARN: Code duplicated, block: B:74:0x02da A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:75:0x02db  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:81:0x01a2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:82:0x01a8 A[SYNTHETIC] */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        C00021 c00021;
        Object obj;
        Object obj2;
        String url2;
        Document document;
        Element elementSelectFirst;
        String strAttr;
        String ogdesc;
        String title;
        MatchResult matchResultFind$default;
        Integer intOrNull;
        Integer year;
        TvType tvType;
        TvType type;
        Element elementSelectFirst2;
        String strAttr2;
        String posterUrl;
        Iterator it;
        String title2;
        Object element$iv;
        Element plotParagraph;
        String desc;
        String desc2;
        Object objNewMovieLoadResponse;
        String desc3;
        String title3;
        Integer year2;
        TvType type2;
        Element plotParagraph2;
        String url3;
        String url4;
        Iterable $this$map$iv;
        int $i$f$map;
        Collection destination$iv$iv;
        Object objNewTvSeriesLoadResponse;
        Element elementSelectFirst3;
        Object $result;
        boolean z;
        String strText;
        List groupValues;
        String str;
        if (continuation instanceof C00021) {
            c00021 = (C00021) continuation;
            if ((c00021.label & Integer.MIN_VALUE) != 0) {
                c00021.label -= Integer.MIN_VALUE;
            } else {
                c00021 = new C00021(continuation);
            }
        } else {
            c00021 = new C00021(continuation);
        }
        C00021 c00022 = c00021;
        Object $result2 = c00022.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00022.label) {
            case 0:
                ResultKt.throwOnFailure($result2);
                Requests app = MainActivityKt.getApp();
                c00022.L$0 = url;
                c00022.label = 1;
                obj = coroutine_suspended;
                obj2 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4094, (Object) null);
                c00022 = c00022;
                if (obj2 == obj) {
                    return obj;
                }
                url2 = url;
                document = ((NiceResponse) obj2).getDocument();
                elementSelectFirst = document.selectFirst("meta[property='og:description']");
                if (elementSelectFirst == null && (strAttr = elementSelectFirst.attr("content")) != null) {
                    ogdesc = strAttr;
                    title = StringsKt.trim(StringsKt.substringBefore$default(StringsKt.substringAfter$default(ogdesc, "Name:", (String) null, 2, (Object) null), "(", (String) null, 2, (Object) null)).toString();
                    matchResultFind$default = Regex.find$default(new Regex("\\((\\d{4})\\)"), ogdesc, 0, 2, (Object) null);
                    if (matchResultFind$default != null || (groupValues = matchResultFind$default.getGroupValues()) == null || (str = (String) groupValues.get(1)) == null) {
                        intOrNull = null;
                    } else {
                        intOrNull = StringsKt.toIntOrNull(str);
                    }
                    year = intOrNull;
                    if (StringsKt.startsWith$default(ogdesc, "Movie", false, 2, (Object) null)) {
                        tvType = TvType.Movie;
                    } else {
                        tvType = TvType.TvSeries;
                    }
                    type = tvType;
                    elementSelectFirst2 = document.selectFirst("meta[property='og:image']");
                    if (elementSelectFirst2 != null) {
                        strAttr2 = elementSelectFirst2.attr("content");
                    } else {
                        strAttr2 = null;
                    }
                    posterUrl = strAttr2;
                    Iterable $this$firstOrNull$iv = document.select("p:has(strong)");
                    it = $this$firstOrNull$iv.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            element$iv = it.next();
                            Element it2 = (Element) element$iv;
                            elementSelectFirst3 = it2.selectFirst("strong");
                            if (elementSelectFirst3 != null || (strText = elementSelectFirst3.text()) == null) {
                                $result = $result2;
                                title2 = title;
                            } else {
                                $result = $result2;
                                title2 = title;
                                z = StringsKt.contains(strText, "plot", true);
                                if (!z) {
                                    title = title2;
                                    $result2 = $result;
                                }
                            }
                            if (!z) {
                                title = title2;
                                $result2 = $result;
                            }
                        } else {
                            title2 = title;
                            element$iv = null;
                        }
                    }
                    plotParagraph = (Element) element$iv;
                    if (plotParagraph != null) {
                        plotParagraph.select("strong").remove();
                        desc = plotParagraph.text();
                        if (desc == null) {
                            desc = "";
                        }
                    } else {
                        desc = "";
                    }
                    if (type == TvType.TvSeries) {
                        desc2 = title2;
                        TvType tvType2 = TvType.Movie;
                        C00043 c00043 = new C00043(posterUrl, year, desc, null);
                        c00022.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                        c00022.L$1 = SpillingKt.nullOutSpilledVariable(document);
                        c00022.L$2 = SpillingKt.nullOutSpilledVariable(ogdesc);
                        c00022.L$3 = SpillingKt.nullOutSpilledVariable(desc2);
                        c00022.L$4 = SpillingKt.nullOutSpilledVariable(year);
                        c00022.L$5 = SpillingKt.nullOutSpilledVariable(type);
                        c00022.L$6 = SpillingKt.nullOutSpilledVariable(posterUrl);
                        c00022.L$7 = SpillingKt.nullOutSpilledVariable(plotParagraph);
                        c00022.L$8 = SpillingKt.nullOutSpilledVariable(desc);
                        c00022.label = 3;
                        objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, desc2, url2, tvType2, url2, c00043, c00022);
                        if (objNewMovieLoadResponse == obj) {
                            return obj;
                        }
                        desc3 = desc;
                        title3 = desc2;
                        year2 = year;
                        type2 = type;
                        plotParagraph2 = plotParagraph;
                        url3 = url2;
                        url4 = posterUrl;
                        return (LoadResponse) objNewMovieLoadResponse;
                    }
                    $this$map$iv = extractVideos(document);
                    $i$f$map = 0;
                    destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    for (Object item$iv$iv : $this$map$iv) {
                        final VideoEntry ep = (VideoEntry) item$iv$iv;
                        destination$iv$iv.add(MainAPIKt.newEpisode(this, AppUtils.INSTANCE.toJson(ep), new Function1() { // from class: com.tamilblasters.TamilblastersProvider$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj3) {
                                return TamilblastersProvider.load$lambda$2$0(ep, (Episode) obj3);
                            }
                        }));
                        $this$map$iv = $this$map$iv;
                        $i$f$map = $i$f$map;
                        url2 = url2;
                    }
                    List episodes = CollectionsKt.reversed((List) destination$iv$iv);
                    TvType tvType3 = TvType.TvSeries;
                    C00032 c00032 = new C00032(posterUrl, year, desc, null);
                    c00022.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(document);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(ogdesc);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(title2);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(year);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(type);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(posterUrl);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(plotParagraph);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(desc);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(episodes);
                    c00022.label = 2;
                    objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, title2, url2, tvType3, episodes, c00032, c00022);
                    if (objNewTvSeriesLoadResponse == obj) {
                        return obj;
                    }
                    return (LoadResponse) objNewTvSeriesLoadResponse;
                }
                return null;
            case 1:
                String url5 = (String) c00022.L$0;
                ResultKt.throwOnFailure($result2);
                obj = coroutine_suspended;
                url2 = url5;
                obj2 = $result2;
                document = ((NiceResponse) obj2).getDocument();
                elementSelectFirst = document.selectFirst("meta[property='og:description']");
                if (elementSelectFirst == null) {
                    return null;
                }
                ogdesc = strAttr;
                title = StringsKt.trim(StringsKt.substringBefore$default(StringsKt.substringAfter$default(ogdesc, "Name:", (String) null, 2, (Object) null), "(", (String) null, 2, (Object) null)).toString();
                matchResultFind$default = Regex.find$default(new Regex("\\((\\d{4})\\)"), ogdesc, 0, 2, (Object) null);
                if (matchResultFind$default != null) {
                    intOrNull = null;
                } else {
                    intOrNull = null;
                }
                year = intOrNull;
                if (StringsKt.startsWith$default(ogdesc, "Movie", false, 2, (Object) null)) {
                    tvType = TvType.Movie;
                } else {
                    tvType = TvType.TvSeries;
                }
                type = tvType;
                elementSelectFirst2 = document.selectFirst("meta[property='og:image']");
                if (elementSelectFirst2 != null) {
                    strAttr2 = elementSelectFirst2.attr("content");
                } else {
                    strAttr2 = null;
                }
                posterUrl = strAttr2;
                Iterable $this$firstOrNull$iv2 = document.select("p:has(strong)");
                it = $this$firstOrNull$iv2.iterator();
                while (true) {
                    if (it.hasNext()) {
                        element$iv = it.next();
                        Element it3 = (Element) element$iv;
                        elementSelectFirst3 = it3.selectFirst("strong");
                        if (elementSelectFirst3 != null) {
                            $result = $result2;
                            title2 = title;
                        } else {
                            $result = $result2;
                            title2 = title;
                        }
                        if (!z) {
                            title = title2;
                            $result2 = $result;
                        }
                    } else {
                        title2 = title;
                        element$iv = null;
                    }
                }
                plotParagraph = (Element) element$iv;
                if (plotParagraph != null) {
                    plotParagraph.select("strong").remove();
                    desc = plotParagraph.text();
                    if (desc == null) {
                        desc = "";
                    }
                } else {
                    desc = "";
                }
                if (type == TvType.TvSeries) {
                    desc2 = title2;
                    TvType tvType4 = TvType.Movie;
                    C00043 c00044 = new C00043(posterUrl, year, desc, null);
                    c00022.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(document);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(ogdesc);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(desc2);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(year);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(type);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(posterUrl);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(plotParagraph);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(desc);
                    c00022.label = 3;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, desc2, url2, tvType4, url2, c00044, c00022);
                    if (objNewMovieLoadResponse == obj) {
                        return obj;
                    }
                    desc3 = desc;
                    title3 = desc2;
                    year2 = year;
                    type2 = type;
                    plotParagraph2 = plotParagraph;
                    url3 = url2;
                    url4 = posterUrl;
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                $this$map$iv = extractVideos(document);
                $i$f$map = 0;
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                while (r13.hasNext()) {
                    final VideoEntry ep2 = (VideoEntry) item$iv$iv;
                    destination$iv$iv.add(MainAPIKt.newEpisode(this, AppUtils.INSTANCE.toJson(ep2), new Function1() { // from class: com.tamilblasters.TamilblastersProvider$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj3) {
                            return TamilblastersProvider.load$lambda$2$0(ep2, (Episode) obj3);
                        }
                    }));
                    $this$map$iv = $this$map$iv;
                    $i$f$map = $i$f$map;
                    url2 = url2;
                }
                List episodes2 = CollectionsKt.reversed((List) destination$iv$iv);
                TvType tvType5 = TvType.TvSeries;
                C00032 c00033 = new C00032(posterUrl, year, desc, null);
                c00022.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00022.L$1 = SpillingKt.nullOutSpilledVariable(document);
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(ogdesc);
                c00022.L$3 = SpillingKt.nullOutSpilledVariable(title2);
                c00022.L$4 = SpillingKt.nullOutSpilledVariable(year);
                c00022.L$5 = SpillingKt.nullOutSpilledVariable(type);
                c00022.L$6 = SpillingKt.nullOutSpilledVariable(posterUrl);
                c00022.L$7 = SpillingKt.nullOutSpilledVariable(plotParagraph);
                c00022.L$8 = SpillingKt.nullOutSpilledVariable(desc);
                c00022.L$9 = SpillingKt.nullOutSpilledVariable(episodes2);
                c00022.label = 2;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, title2, url2, tvType5, episodes2, c00033, c00022);
                if (objNewTvSeriesLoadResponse == obj) {
                    return obj;
                }
                return (LoadResponse) objNewTvSeriesLoadResponse;
            case 2:
                ResultKt.throwOnFailure($result2);
                objNewTvSeriesLoadResponse = $result2;
                return (LoadResponse) objNewTvSeriesLoadResponse;
            case 3:
                desc3 = (String) c00022.L$8;
                plotParagraph2 = (Element) c00022.L$7;
                url4 = (String) c00022.L$6;
                type2 = (TvType) c00022.L$5;
                year2 = (Integer) c00022.L$4;
                title3 = (String) c00022.L$3;
                ogdesc = (String) c00022.L$2;
                document = (Document) c00022.L$1;
                url3 = (String) c00022.L$0;
                ResultKt.throwOnFailure($result2);
                objNewMovieLoadResponse = $result2;
                return (LoadResponse) objNewMovieLoadResponse;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$2$0(VideoEntry $ep, Episode $this$newEpisode) {
        $this$newEpisode.setName($ep.getTitle());
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.tamilblasters.TamilblastersProvider$load$2 */
    /* JADX INFO: compiled from: TamilblastersProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.tamilblasters.TamilblastersProvider$load$2", f = "TamilblastersProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00032 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $desc;
        final /* synthetic */ String $posterUrl;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00032(String str, Integer num, String str2, Continuation<? super C00032> continuation) {
            super(2, continuation);
            this.$posterUrl = str;
            this.$year = num;
            this.$desc = str2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00032 = new C00032(this.$posterUrl, this.$year, this.$desc, continuation);
            c00032.L$0 = obj;
            return c00032;
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
                    $this$newTvSeriesLoadResponse.setPosterUrl(this.$posterUrl);
                    $this$newTvSeriesLoadResponse.setYear(this.$year);
                    $this$newTvSeriesLoadResponse.setPlot(this.$desc);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.tamilblasters.TamilblastersProvider$load$3 */
    /* JADX INFO: compiled from: TamilblastersProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.tamilblasters.TamilblastersProvider$load$3", f = "TamilblastersProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00043 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $desc;
        final /* synthetic */ String $posterUrl;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00043(String str, Integer num, String str2, Continuation<? super C00043> continuation) {
            super(2, continuation);
            this.$posterUrl = str;
            this.$year = num;
            this.$desc = str2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00043 = new C00043(this.$posterUrl, this.$year, this.$desc, continuation);
            c00043.L$0 = obj;
            return c00043;
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
                    $this$newMovieLoadResponse.setPosterUrl(this.$posterUrl);
                    $this$newMovieLoadResponse.setYear(this.$year);
                    $this$newMovieLoadResponse.setPlot(this.$desc);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x010a  */
    /* JADX WARN: Code duplicated, block: B:51:0x0131  */
    /* JADX WARN: Code duplicated, block: B:77:0x026a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:78:0x026b  */
    /* JADX WARN: Code duplicated, block: B:7:0x001e  */
    /* JADX WARN: Code duplicated, block: B:88:0x0111 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00051 c00051;
        boolean z;
        Continuation continuation2;
        Object obj;
        Function1<? super SubtitleFile, Unit> function3;
        Object obj2;
        Function1<? super ExtractorLink, Unit> function4;
        String data2;
        boolean isCasting2;
        Object obj3;
        Object objDecodeFromString;
        DeserializationStrategy deserializationStrategy;
        String value$iv$iv;
        boolean z2;
        List listSelect;
        C00062 c00062;
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
                if (!StringsKt.startsWith$default(data, "{", false, 2, (Object) null)) {
                    Requests app = MainActivityKt.getApp();
                    c00052.L$0 = SpillingKt.nullOutSpilledVariable(data);
                    c00052.L$1 = function1;
                    c00052.L$2 = function2;
                    c00052.Z$0 = isCasting;
                    c00052.label = 2;
                    z = true;
                    continuation2 = null;
                    obj = coroutine_suspended;
                    Object obj4 = Requests.get$default(app, data, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00052, 4094, (Object) null);
                    if (obj4 == obj) {
                        c00052 = c00052;
                        return obj;
                    }
                    c00052 = c00052;
                    function3 = function1;
                    obj2 = obj4;
                    function4 = function2;
                    data2 = data;
                    isCasting2 = isCasting;
                    Document doc = ((NiceResponse) obj2).getDocument();
                    listSelect = doc.select("iframe");
                    c00062 = new C00062(function3, function4, continuation2);
                    c00052.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                    c00052.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                    c00052.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                    c00052.L$3 = SpillingKt.nullOutSpilledVariable(doc);
                    c00052.Z$0 = isCasting2;
                    c00052.label = 3;
                    if (ParCollectionsKt.amap(listSelect, c00062, c00052) == obj) {
                        return obj;
                    }
                    return Boxing.boxBoolean(z);
                }
                AppUtils appUtils = AppUtils.INSTANCE;
                if (data != null) {
                    try {
                        try {
                            Result.Companion companion = Result.Companion;
                            KType kTypeTypeOf = Reflection.typeOf(VideoEntry.class);
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        if (Result.exceptionOrNull-impl(obj3) == null) {
                            if (Result.isFailure-impl(obj3)) {
                                obj3 = null;
                            }
                            deserializationStrategy = (KSerializer) obj3;
                            if (deserializationStrategy != null) {
                                try {
                                    value$iv$iv = data;
                                    try {
                                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv$iv);
                                    } catch (SerializationException e) {
                                        e$iv$iv = e;
                                        ArchComponentExtKt.logError((Throwable) e$iv$iv);
                                        ObjectMapper $this$readValue$iv$iv$iv = MainAPIKt.getMapper();
                                        String content$iv$iv$iv = value$iv$iv;
                                        objDecodeFromString = $this$readValue$iv$iv$iv.readValue(content$iv$iv$iv, new TypeReference<VideoEntry>() { // from class: com.tamilblasters.TamilblastersProvider$loadLinks$$inlined$tryParseJson$1
                                        });
                                    } catch (Throwable th2) {
                                        ObjectMapper $this$readValue$iv$iv$iv2 = MainAPIKt.getMapper();
                                        String content$iv$iv$iv2 = value$iv$iv;
                                        objDecodeFromString = $this$readValue$iv$iv$iv2.readValue(content$iv$iv$iv2, new TypeReference<VideoEntry>() { // from class: com.tamilblasters.TamilblastersProvider$loadLinks$$inlined$tryParseJson$1
                                        });
                                    }
                                } catch (SerializationException e2) {
                                    e$iv$iv = e2;
                                    value$iv$iv = data;
                                } catch (Throwable th3) {
                                    value$iv$iv = data;
                                }
                            } else {
                                value$iv$iv = data;
                            }
                            ObjectMapper $this$readValue$iv$iv$iv3 = MainAPIKt.getMapper();
                            String content$iv$iv$iv3 = value$iv$iv;
                            objDecodeFromString = $this$readValue$iv$iv$iv3.readValue(content$iv$iv$iv3, new TypeReference<VideoEntry>() { // from class: com.tamilblasters.TamilblastersProvider$loadLinks$$inlined$tryParseJson$1
                            });
                        } else {
                            try {
                                Result.Companion companion3 = Result.Companion;
                                obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(VideoEntry.class), (List) null, 2, (Object) null));
                            } catch (Throwable th4) {
                                Result.Companion companion4 = Result.Companion;
                                obj3 = Result.constructor-impl(ResultKt.createFailure(th4));
                            }
                            if (Result.isFailure-impl(obj3)) {
                                obj3 = null;
                            }
                            deserializationStrategy = (KSerializer) obj3;
                            if (deserializationStrategy != null) {
                                value$iv$iv = data;
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv$iv);
                            } else {
                                value$iv$iv = data;
                            }
                            ObjectMapper $this$readValue$iv$iv$iv4 = MainAPIKt.getMapper();
                            String content$iv$iv$iv4 = value$iv$iv;
                            objDecodeFromString = $this$readValue$iv$iv$iv4.readValue(content$iv$iv$iv4, new TypeReference<VideoEntry>() { // from class: com.tamilblasters.TamilblastersProvider$loadLinks$$inlined$tryParseJson$1
                            });
                        }
                    } catch (Exception e3) {
                        objDecodeFromString = null;
                    }
                    break;
                } else {
                    objDecodeFromString = null;
                }
                VideoEntry loadData = (VideoEntry) objDecodeFromString;
                if (loadData == null) {
                    return Boxing.boxBoolean(false);
                }
                String streamurl = loadData.getUrl();
                if (StringsKt.contains$default(streamurl, "hg", false, 2, (Object) null)) {
                    String secondPart = StringsKt.substringAfter$default(streamurl, "/e", (String) null, 2, (Object) null);
                    streamurl = this.streamhg + "/e/" + secondPart;
                }
                String str = getMainUrl() + '/';
                c00052.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00052.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                c00052.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                c00052.L$3 = SpillingKt.nullOutSpilledVariable(loadData);
                c00052.L$4 = SpillingKt.nullOutSpilledVariable(streamurl);
                c00052.Z$0 = isCasting;
                z2 = true;
                c00052.label = 1;
                return ExtractorApiKt.loadExtractor(streamurl, str, function1, function2, c00052) == coroutine_suspended ? coroutine_suspended : Boxing.boxBoolean(z2);
            case 1:
                boolean isCasting3 = c00052.Z$0;
                ResultKt.throwOnFailure($result);
                z2 = true;
            case 2:
                isCasting2 = c00052.Z$0;
                Function1<? super ExtractorLink, Unit> function5 = (Function1) c00052.L$2;
                Function1<? super SubtitleFile, Unit> function6 = (Function1) c00052.L$1;
                data2 = (String) c00052.L$0;
                ResultKt.throwOnFailure($result);
                function4 = function5;
                obj = coroutine_suspended;
                obj2 = $result;
                z = true;
                function3 = function6;
                continuation2 = null;
                Document doc2 = ((NiceResponse) obj2).getDocument();
                listSelect = doc2.select("iframe");
                c00062 = new C00062(function3, function4, continuation2);
                c00052.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00052.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                c00052.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                c00052.L$3 = SpillingKt.nullOutSpilledVariable(doc2);
                c00052.Z$0 = isCasting2;
                c00052.label = 3;
                if (ParCollectionsKt.amap(listSelect, c00062, c00052) == obj) {
                    return obj;
                }
                return Boxing.boxBoolean(z);
            case 3:
                boolean z3 = c00052.Z$0;
                ResultKt.throwOnFailure($result);
                z = true;
                return Boxing.boxBoolean(z);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.tamilblasters.TamilblastersProvider$loadLinks$2 */
    /* JADX INFO: compiled from: TamilblastersProvider.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "iframe", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.tamilblasters.TamilblastersProvider$loadLinks$2", f = "TamilblastersProvider.kt", i = {0, 0, 0, 1, 1, 1}, l = {120, 127}, m = "invokeSuspend", n = {"iframe", "streamurl", "host", "iframe", "streamurl", "host"}, nl = {127, 133}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"}, v = 2)
    static final class C00062 extends SuspendLambda implements Function2<Element, Continuation<? super Object>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00062(Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00062> continuation) {
            super(2, continuation);
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00062 = TamilblastersProvider.this.new C00062(this.$subtitleCallback, this.$callback, continuation);
            c00062.L$0 = obj;
            return c00062;
        }

        public final Object invoke(Element element, Continuation<Object> continuation) {
            return create(element, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object obj;
            String lowerCase;
            Element iframe = (Element) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String streamurl = iframe.attr("src");
                    TamilblastersProvider tamilblastersProvider = TamilblastersProvider.this;
                    try {
                        Result.Companion companion = Result.Companion;
                        String host = new URI(streamurl).getHost();
                        if (host != null) {
                            lowerCase = host.toLowerCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        } else {
                            lowerCase = null;
                        }
                        obj = Result.constructor-impl(lowerCase);
                        break;
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    if (Result.isFailure-impl(obj)) {
                        obj = null;
                    }
                    String host2 = (String) obj;
                    if (host2 == null) {
                        host2 = "";
                    }
                    if (StringsKt.contains$default(host2, "hg", false, 2, (Object) null)) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(iframe);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(streamurl);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(host2);
                        this.label = 1;
                        Object url = new Hgcloud().getUrl(streamurl, TamilblastersProvider.this.getMainUrl(), this.$subtitleCallback, this.$callback, (Continuation) this);
                        return url == coroutine_suspended ? coroutine_suspended : url;
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(iframe);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(streamurl);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(host2);
                    this.label = 2;
                    Object objLoadExtractor = ExtractorApiKt.loadExtractor(streamurl, TamilblastersProvider.this.getMainUrl(), this.$subtitleCallback, this.$callback, (Continuation) this);
                    return objLoadExtractor == coroutine_suspended ? coroutine_suspended : objLoadExtractor;
                case 1:
                    ResultKt.throwOnFailure($result);
                    return $result;
                case 2:
                    ResultKt.throwOnFailure($result);
                    return $result;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    private final List<VideoEntry> extractVideos(Document document) {
        VideoEntry videoEntry;
        Iterable $this$mapNotNull$iv;
        Object element$iv;
        Iterable $this$mapNotNull$iv2 = document.select("iframe");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv2) {
            Element iframe = (Element) element$iv$iv$iv;
            Iterable $this$firstOrNull$iv = iframe.previousElementSiblings();
            Iterator it = $this$firstOrNull$iv.iterator();
            while (true) {
                videoEntry = null;
                if (!it.hasNext()) {
                    $this$mapNotNull$iv = $this$mapNotNull$iv2;
                    element$iv = null;
                    break;
                }
                element$iv = it.next();
                Element it2 = (Element) element$iv;
                $this$mapNotNull$iv = $this$mapNotNull$iv2;
                if (Intrinsics.areEqual(it2.tagName(), "p")) {
                    break;
                }
                $this$mapNotNull$iv2 = $this$mapNotNull$iv;
            }
            Element element = (Element) element$iv;
            String label = element != null ? element.text() : null;
            if (label != null) {
                String it3 = label;
                videoEntry = new VideoEntry(it3, iframe.attr("src"));
            }
            if (videoEntry != null) {
                destination$iv$iv.add(videoEntry);
            }
            $this$mapNotNull$iv2 = $this$mapNotNull$iv;
        }
        return (List) destination$iv$iv;
    }
}
