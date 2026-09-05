package com.anineko;

import com.lagradost.cloudstream3.AnimeLoadResponse;
import com.lagradost.cloudstream3.AnimeSearchResponse;
import com.lagradost.cloudstream3.DubStatus;
import com.lagradost.cloudstream3.Episode;
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
import com.lagradost.cloudstream3.ShowStatus;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.utils.ExtractorLink;
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
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* JADX INFO: compiled from: Anineko.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Anineko/classes.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u001e\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010%J\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u001c2\u0006\u0010(\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010)J\u0018\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010)JF\u0010-\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u000e2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u000203012\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020301H\u0096@¢\u0006\u0002\u00106R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u00067"}, d2 = {"Lcom/anineko/Anineko;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Anineko"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAnineko.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Anineko.kt\ncom/anineko/Anineko\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,321:1\n1795#2,10:322\n2068#2:332\n2069#2:334\n1805#2:335\n1795#2,10:336\n2068#2:346\n2069#2:348\n1805#2:349\n1739#2:351\n1814#2,3:352\n2068#2:355\n1739#2:356\n1814#2,3:357\n2069#2:360\n296#2,2:361\n777#2:363\n873#2,2:364\n1#3:333\n1#3:347\n1#3:350\n*S KotlinDebug\n*F\n+ 1 Anineko.kt\ncom/anineko/Anineko\n*L\n57#1:322,10\n57#1:332\n57#1:334\n57#1:335\n85#1:336,10\n85#1:346\n85#1:348\n85#1:349\n119#1:351\n119#1:352,3\n148#1:355\n166#1:356\n166#1:357,3\n148#1:360\n194#1:361,2\n225#1:363\n225#1:364,2\n57#1:333\n85#1:347\n*E\n"})
public final class Anineko extends MainAPI {

    @NotNull
    private String mainUrl = "https://anineko.to";

    @NotNull
    private String name = "Anineko";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "en";
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Anime, TvType.AnimeMovie, TvType.OVA});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("/new-releases", "New Releases"), TuplesKt.to("/updates", "Latest Updates"), TuplesKt.to("/ongoing", "Ongoing")});

    /* JADX INFO: renamed from: com.anineko.Anineko$getMainPage$1 */
    /* JADX INFO: compiled from: Anineko.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.anineko.Anineko", f = "Anineko.kt", i = {0, 0, 0}, l = {55}, m = "getMainPage", n = {"request", "url", "page"}, nl = {57}, s = {"L$0", "L$1", "I$0"}, v = 2)
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
            return Anineko.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.anineko.Anineko$load$1 */
    /* JADX INFO: compiled from: Anineko.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.anineko.Anineko", f = "Anineko.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {108, 137, 141, 196}, m = "load", n = {"url", "url", "doc", "title", "altTitle", "poster", "bgStyle", "background", "plot", "tags", "year", "typeText", "tvType", "statusText", "showStatus", "searchTitle", "url", "doc", "title", "altTitle", "poster", "bgStyle", "background", "plot", "tags", "year", "typeText", "tvType", "statusText", "showStatus", "searchTitle", "anilistId", "animeMetaData", "aniZipUrl", "url", "doc", "title", "altTitle", "poster", "bgStyle", "background", "plot", "tags", "year", "typeText", "tvType", "statusText", "showStatus", "searchTitle", "anilistId", "animeMetaData", "subEpisodes", "dubEpisodes", "fanartUrl"}, nl = {110, 138, 142, -1}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$16;
        Object L$17;
        Object L$18;
        Object L$19;
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
            return Anineko.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.anineko.Anineko$loadLinks$1 */
    /* JADX INFO: compiled from: Anineko.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.anineko.Anineko", f = "Anineko.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {221, 233}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "parts", "url", "audioType", "isCasting", "data", "subtitleCallback", "callback", "parts", "url", "audioType", "doc", "panels", "targetPanels", "isCasting"}, nl = {223, 317}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "Z$0"}, v = 2)
    static final class C00031 extends ContinuationImpl {
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

        C00031(Continuation<? super C00031> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Anineko.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.anineko.Anineko$search$1 */
    /* JADX INFO: compiled from: Anineko.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.anineko.Anineko", f = "Anineko.kt", i = {0, 0}, l = {83}, m = "search", n = {"query", "url"}, nl = {85}, s = {"L$0", "L$1"}, v = 2)
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
            return Anineko.this.search(null, (Continuation) this);
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

    /* JADX WARN: Code duplicated, block: B:57:0x019a  */
    /* JADX WARN: Code duplicated, block: B:63:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:69:0x01dc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00001 c00001;
        String url;
        MainPageRequest request2;
        int page2;
        AnimeSearchResponse animeSearchResponseNewAnimeSearchResponse$default;
        String strAttr;
        Element elementSelectFirst;
        String strText;
        String strText2;
        String strText3;
        int page3 = page;
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
                String url2 = getMainUrl() + request.getData() + "?page=" + page3;
                Requests app = MainActivityKt.getApp();
                c00001.L$0 = request;
                c00001.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                c00001.I$0 = page3;
                c00001.label = 1;
                url = url2;
                $result = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00001, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request2 = request;
                break;
                break;
            case 1:
                page3 = c00001.I$0;
                url = (String) c00001.L$1;
                request2 = (MainPageRequest) c00001.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document doc = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = doc.select(".nv-anime-card");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element element = (Element) element$iv$iv$iv;
            Element elementSelectFirst2 = element.selectFirst("a.nv-anime-thumb");
            if (elementSelectFirst2 != null) {
                page2 = page3;
                String href = elementSelectFirst2.attr("href");
                if (href != null) {
                    Element elementSelectFirst3 = element.selectFirst("h3.nv-anime-title a");
                    if (elementSelectFirst3 == null || (strText3 = elementSelectFirst3.text()) == null) {
                        Element elementSelectFirst4 = element.selectFirst("img");
                        strAttr = elementSelectFirst4 != null ? elementSelectFirst4.attr("alt") : null;
                        if (strAttr == null) {
                            $this$mapNotNull$iv = $this$mapNotNull$iv;
                            url = url;
                            request2 = request2;
                            animeSearchResponseNewAnimeSearchResponse$default = null;
                        }
                    } else {
                        strAttr = strText3;
                        doc = doc;
                    }
                    String title = strAttr;
                    Element elementSelectFirst5 = element.selectFirst("img");
                    final String posterUrl = elementSelectFirst5 != null ? elementSelectFirst5.attr("src") : null;
                    Element elementSelectFirst6 = element.selectFirst(".nv-stat-cc");
                    if (elementSelectFirst6 == null || (strText2 = elementSelectFirst6.text()) == null) {
                        $this$mapNotNull$iv = $this$mapNotNull$iv;
                        url = url;
                    } else {
                        $this$mapNotNull$iv = $this$mapNotNull$iv;
                        url = url;
                        String strReplace = new Regex("[^0-9]").replace(strText2, "");
                        final Integer subCount = strReplace != null ? StringsKt.toIntOrNull(strReplace) : null;
                        elementSelectFirst = element.selectFirst(".nv-stat-dub span");
                        if (elementSelectFirst != null || (strText = elementSelectFirst.text()) == null) {
                            request2 = request2;
                        } else {
                            request2 = request2;
                            String strReplace2 = new Regex("[^0-9]").replace(strText, "");
                            final Integer dubCount = strReplace2 != null ? StringsKt.toIntOrNull(strReplace2) : null;
                            animeSearchResponseNewAnimeSearchResponse$default = MainAPIKt.newAnimeSearchResponse$default(this, title, getMainUrl() + href, TvType.Anime, false, new Function1() { // from class: com.anineko.Anineko$$ExternalSyntheticLambda3
                                public final Object invoke(Object obj) {
                                    return Anineko.getMainPage$lambda$0$0(posterUrl, dubCount, subCount, (AnimeSearchResponse) obj);
                                }
                            }, 8, (Object) null);
                        }
                        animeSearchResponseNewAnimeSearchResponse$default = MainAPIKt.newAnimeSearchResponse$default(this, title, getMainUrl() + href, TvType.Anime, false, new Function1() { // from class: com.anineko.Anineko$$ExternalSyntheticLambda3
                            public final Object invoke(Object obj) {
                                return Anineko.getMainPage$lambda$0$0(posterUrl, dubCount, subCount, (AnimeSearchResponse) obj);
                            }
                        }, 8, (Object) null);
                    }
                    elementSelectFirst = element.selectFirst(".nv-stat-dub span");
                    if (elementSelectFirst != null) {
                        request2 = request2;
                    } else {
                        request2 = request2;
                    }
                    animeSearchResponseNewAnimeSearchResponse$default = MainAPIKt.newAnimeSearchResponse$default(this, title, getMainUrl() + href, TvType.Anime, false, new Function1() { // from class: com.anineko.Anineko$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj) {
                            return Anineko.getMainPage$lambda$0$0(posterUrl, dubCount, subCount, (AnimeSearchResponse) obj);
                        }
                    }, 8, (Object) null);
                }
                if (animeSearchResponseNewAnimeSearchResponse$default != null) {
                    destination$iv$iv.add(animeSearchResponseNewAnimeSearchResponse$default);
                }
                page3 = page2;
                doc = doc;
                $this$mapNotNull$iv = $this$mapNotNull$iv;
                url = url;
                request2 = request2;
            } else {
                page2 = page3;
            }
            animeSearchResponseNewAnimeSearchResponse$default = null;
            if (animeSearchResponseNewAnimeSearchResponse$default != null) {
                destination$iv$iv.add(animeSearchResponseNewAnimeSearchResponse$default);
            }
            page3 = page2;
            doc = doc;
            $this$mapNotNull$iv = $this$mapNotNull$iv;
            url = url;
            request2 = request2;
        }
        List list = (List) destination$iv$iv;
        return MainAPIKt.newHomePageResponse$default(request2.getName(), list, (Boolean) null, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMainPage$lambda$0$0(String $posterUrl, Integer $dubCount, Integer $subCount, AnimeSearchResponse $this$newAnimeSearchResponse) {
        $this$newAnimeSearchResponse.setPosterUrl($posterUrl);
        MainAPIKt.addDubStatus($this$newAnimeSearchResponse, $dubCount != null, $subCount != null, $dubCount, $subCount);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:57:0x0195  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        C00051 c00051;
        String url;
        String query2;
        Document doc;
        Iterable $this$mapNotNull$iv;
        String query3;
        int $i$f$mapNotNull;
        String strAttr;
        Element elementSelectFirst;
        String strText;
        String strText2;
        String strText3;
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
        Object $result = c00051.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00051.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String url2 = getMainUrl() + "/browser?keyword=" + query;
                Requests app = MainActivityKt.getApp();
                c00051.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00051.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                c00051.label = 1;
                url = url2;
                $result = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00051, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                query2 = query;
                break;
                break;
            case 1:
                url = (String) c00051.L$1;
                query2 = (String) c00051.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document doc2 = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv2 = doc2.select(".nv-anime-card");
        int $i$f$mapNotNull2 = 0;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv2) {
            Element element = (Element) element$iv$iv$iv;
            Element elementSelectFirst2 = element.selectFirst("a.nv-anime-thumb");
            Integer numNewAnimeSearchResponse$default = null;
            if (elementSelectFirst2 != null) {
                doc = doc2;
                String href = elementSelectFirst2.attr("href");
                if (href == null) {
                    $this$mapNotNull$iv = $this$mapNotNull$iv2;
                    url = url;
                    query3 = query2;
                    $i$f$mapNotNull = $i$f$mapNotNull2;
                } else {
                    Element elementSelectFirst3 = element.selectFirst("h3.nv-anime-title a");
                    if (elementSelectFirst3 == null || (strText3 = elementSelectFirst3.text()) == null) {
                        $this$mapNotNull$iv = $this$mapNotNull$iv2;
                        Element elementSelectFirst4 = element.selectFirst("img");
                        strAttr = elementSelectFirst4 != null ? elementSelectFirst4.attr("alt") : null;
                        if (strAttr == null) {
                            query3 = query2;
                            $i$f$mapNotNull = $i$f$mapNotNull2;
                        }
                    } else {
                        $this$mapNotNull$iv = $this$mapNotNull$iv2;
                        strAttr = strText3;
                        url = url;
                    }
                    String title = strAttr;
                    Element elementSelectFirst5 = element.selectFirst("img");
                    final String posterUrl = elementSelectFirst5 != null ? elementSelectFirst5.attr("src") : null;
                    Element elementSelectFirst6 = element.selectFirst(".nv-stat-cc");
                    if (elementSelectFirst6 == null || (strText2 = elementSelectFirst6.text()) == null) {
                        query3 = query2;
                        $i$f$mapNotNull = $i$f$mapNotNull2;
                    } else {
                        query3 = query2;
                        $i$f$mapNotNull = $i$f$mapNotNull2;
                        String strReplace = new Regex("[^0-9]").replace(strText2, "");
                        final Integer subCount = strReplace != null ? StringsKt.toIntOrNull(strReplace) : null;
                        elementSelectFirst = element.selectFirst(".nv-stat-dub span");
                        if (elementSelectFirst == null && (strText = elementSelectFirst.text()) != null) {
                            String strReplace2 = new Regex("[^0-9]").replace(strText, "");
                            if (strReplace2 != null) {
                                numNewAnimeSearchResponse$default = StringsKt.toIntOrNull(strReplace2);
                            }
                        }
                        final Integer dubCount = numNewAnimeSearchResponse$default;
                        numNewAnimeSearchResponse$default = MainAPIKt.newAnimeSearchResponse$default(this, title, getMainUrl() + href, TvType.Anime, false, new Function1() { // from class: com.anineko.Anineko$$ExternalSyntheticLambda2
                            public final Object invoke(Object obj) {
                                return Anineko.search$lambda$0$0(posterUrl, dubCount, subCount, (AnimeSearchResponse) obj);
                            }
                        }, 8, (Object) null);
                    }
                    elementSelectFirst = element.selectFirst(".nv-stat-dub span");
                    if (elementSelectFirst == null) {
                    }
                    final Integer dubCount2 = numNewAnimeSearchResponse$default;
                    numNewAnimeSearchResponse$default = MainAPIKt.newAnimeSearchResponse$default(this, title, getMainUrl() + href, TvType.Anime, false, new Function1() { // from class: com.anineko.Anineko$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj) {
                            return Anineko.search$lambda$0$0(posterUrl, dubCount2, subCount, (AnimeSearchResponse) obj);
                        }
                    }, 8, (Object) null);
                }
            } else {
                doc = doc2;
                $this$mapNotNull$iv = $this$mapNotNull$iv2;
                url = url;
                query3 = query2;
                $i$f$mapNotNull = $i$f$mapNotNull2;
            }
            if (numNewAnimeSearchResponse$default != null) {
                destination$iv$iv.add(numNewAnimeSearchResponse$default);
            }
            doc2 = doc;
            $this$mapNotNull$iv2 = $this$mapNotNull$iv;
            url = url;
            query2 = query3;
            $i$f$mapNotNull2 = $i$f$mapNotNull;
        }
        return (List) destination$iv$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit search$lambda$0$0(String $posterUrl, Integer $dubCount, Integer $subCount, AnimeSearchResponse $this$newAnimeSearchResponse) {
        $this$newAnimeSearchResponse.setPosterUrl($posterUrl);
        MainAPIKt.addDubStatus($this$newAnimeSearchResponse, $dubCount != null, $subCount != null, $dubCount, $subCount);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0334  */
    /* JADX WARN: Code duplicated, block: B:101:0x0337  */
    /* JADX WARN: Code duplicated, block: B:104:0x033c  */
    /* JADX WARN: Code duplicated, block: B:105:0x033e  */
    /* JADX WARN: Code duplicated, block: B:108:0x037b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:109:0x037c  */
    /* JADX WARN: Code duplicated, block: B:112:0x03a0  */
    /* JADX WARN: Code duplicated, block: B:114:0x0438 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:115:0x0439  */
    /* JADX WARN: Code duplicated, block: B:117:0x0474  */
    /* JADX WARN: Code duplicated, block: B:121:0x04c6  */
    /* JADX WARN: Code duplicated, block: B:123:0x04d9  */
    /* JADX WARN: Code duplicated, block: B:125:0x04e3  */
    /* JADX WARN: Code duplicated, block: B:126:0x04eb  */
    /* JADX WARN: Code duplicated, block: B:128:0x04f3  */
    /* JADX WARN: Code duplicated, block: B:129:0x04f8  */
    /* JADX WARN: Code duplicated, block: B:132:0x0500  */
    /* JADX WARN: Code duplicated, block: B:134:0x0517  */
    /* JADX WARN: Code duplicated, block: B:135:0x051c  */
    /* JADX WARN: Code duplicated, block: B:139:0x052c  */
    /* JADX WARN: Code duplicated, block: B:145:0x0547  */
    /* JADX WARN: Code duplicated, block: B:148:0x054d  */
    /* JADX WARN: Code duplicated, block: B:154:0x0564  */
    /* JADX WARN: Code duplicated, block: B:156:0x0568  */
    /* JADX WARN: Code duplicated, block: B:158:0x0570  */
    /* JADX WARN: Code duplicated, block: B:159:0x0577  */
    /* JADX WARN: Code duplicated, block: B:162:0x057d  */
    /* JADX WARN: Code duplicated, block: B:163:0x057f  */
    /* JADX WARN: Code duplicated, block: B:166:0x0591  */
    /* JADX WARN: Code duplicated, block: B:168:0x0597  */
    /* JADX WARN: Code duplicated, block: B:170:0x059d  */
    /* JADX WARN: Code duplicated, block: B:173:0x05ab  */
    /* JADX WARN: Code duplicated, block: B:175:0x05af  */
    /* JADX WARN: Code duplicated, block: B:177:0x05b5  */
    /* JADX WARN: Code duplicated, block: B:180:0x05c3  */
    /* JADX WARN: Code duplicated, block: B:182:0x05c7  */
    /* JADX WARN: Code duplicated, block: B:183:0x05ca A[PHI: r8
      0x05ca: PHI (r8v36 com.lagradost.cloudstream3.ShowStatus) = 
      (r8v35 com.lagradost.cloudstream3.ShowStatus)
      (r8v38 com.lagradost.cloudstream3.ShowStatus)
      (r8v40 com.lagradost.cloudstream3.ShowStatus)
     binds: [B:167:0x0595, B:174:0x05ad, B:181:0x05c5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:184:0x05cd  */
    /* JADX WARN: Code duplicated, block: B:187:0x05d4  */
    /* JADX WARN: Code duplicated, block: B:189:0x05da  */
    /* JADX WARN: Code duplicated, block: B:192:0x05e0  */
    /* JADX WARN: Code duplicated, block: B:196:0x05ea  */
    /* JADX WARN: Code duplicated, block: B:198:0x05f0  */
    /* JADX WARN: Code duplicated, block: B:203:0x0603  */
    /* JADX WARN: Code duplicated, block: B:205:0x0607  */
    /* JADX WARN: Code duplicated, block: B:206:0x060a  */
    /* JADX WARN: Code duplicated, block: B:208:0x060e  */
    /* JADX WARN: Code duplicated, block: B:209:0x0615  */
    /* JADX WARN: Code duplicated, block: B:211:0x0619  */
    /* JADX WARN: Code duplicated, block: B:212:0x0620  */
    /* JADX WARN: Code duplicated, block: B:214:0x0624  */
    /* JADX WARN: Code duplicated, block: B:215:0x062b  */
    /* JADX WARN: Code duplicated, block: B:219:0x0653 A[LOOP:1: B:217:0x064d->B:219:0x0653, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:222:0x0685  */
    /* JADX WARN: Code duplicated, block: B:228:0x0698  */
    /* JADX WARN: Code duplicated, block: B:22:0x01de  */
    /* JADX WARN: Code duplicated, block: B:231:0x06a1 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:234:0x06a9  */
    /* JADX WARN: Code duplicated, block: B:236:0x06dc  */
    /* JADX WARN: Code duplicated, block: B:238:0x070a  */
    /* JADX WARN: Code duplicated, block: B:242:0x072e  */
    /* JADX WARN: Code duplicated, block: B:24:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:257:0x0766  */
    /* JADX WARN: Code duplicated, block: B:25:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:260:0x0808 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:261:0x0809  */
    /* JADX WARN: Code duplicated, block: B:263:0x081e  */
    /* JADX WARN: Code duplicated, block: B:269:0x0712 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:27:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:28:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:31:0x0202  */
    /* JADX WARN: Code duplicated, block: B:32:0x0209  */
    /* JADX WARN: Code duplicated, block: B:35:0x0212  */
    /* JADX WARN: Code duplicated, block: B:36:0x0219  */
    /* JADX WARN: Code duplicated, block: B:48:0x024c  */
    /* JADX WARN: Code duplicated, block: B:49:0x0251  */
    /* JADX WARN: Code duplicated, block: B:53:0x027a A[LOOP:3: B:51:0x0274->B:53:0x027a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:59:0x02a6  */
    /* JADX WARN: Code duplicated, block: B:62:0x02b0  */
    /* JADX WARN: Code duplicated, block: B:63:0x02b5  */
    /* JADX WARN: Code duplicated, block: B:69:0x02cb  */
    /* JADX WARN: Code duplicated, block: B:71:0x02ce  */
    /* JADX WARN: Code duplicated, block: B:72:0x02d1  */
    /* JADX WARN: Code duplicated, block: B:76:0x02e2  */
    /* JADX WARN: Code duplicated, block: B:78:0x02e5  */
    /* JADX WARN: Code duplicated, block: B:79:0x02e8  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:82:0x02f3  */
    /* JADX WARN: Code duplicated, block: B:83:0x02f8  */
    /* JADX WARN: Code duplicated, block: B:86:0x02fd  */
    /* JADX WARN: Code duplicated, block: B:88:0x0311  */
    /* JADX WARN: Code duplicated, block: B:89:0x0313  */
    /* JADX WARN: Code duplicated, block: B:92:0x031a  */
    /* JADX WARN: Code duplicated, block: B:93:0x031e  */
    /* JADX WARN: Code duplicated, block: B:94:0x0320  */
    /* JADX WARN: Code duplicated, block: B:97:0x0330 A[ADDED_TO_REGION] */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        C00011 c00011;
        Object obj;
        ShowStatus showStatus;
        Object obj2;
        String url2;
        Document doc;
        Element elementSelectFirst;
        ShowStatus showStatusText;
        Element elementSelectFirst2;
        ShowStatus showStatusText2;
        Element elementSelectFirst3;
        ShowStatus showStatusAttr;
        Element elementSelectFirst4;
        ShowStatus showStatusAttr2;
        boolean z;
        ShowStatus showStatus2;
        Element elementSelectFirst5;
        ShowStatus showStatusText3;
        ShowStatus showStatus3;
        ShowStatus showStatus4;
        Collection destination$iv$iv;
        List tags;
        Element elementSelectFirst6;
        ShowStatus intOrNull;
        Element elementSelectFirst7;
        ShowStatus showStatusText4;
        boolean z2;
        boolean z3;
        TvType tvType;
        Element elementSelectFirst8;
        ShowStatus showStatusText5;
        ShowStatus showStatus5;
        boolean z4;
        ShowStatus showStatus6;
        ShowStatus showStatus7;
        Object anilistId;
        List tags2;
        Document doc2;
        ShowStatus showStatus8;
        ShowStatus showStatus9;
        ShowStatus showStatus10;
        TvType tvType2;
        ShowStatus showStatus11;
        ShowStatus showStatus12;
        String url3;
        ShowStatus showStatus13;
        ShowStatus showStatus14;
        ShowStatus showStatus15;
        ShowStatus showStatus16;
        ShowStatus showStatus17;
        ShowStatus showStatus18;
        String strText;
        MatchResult matchResultFind$default;
        List groupValues;
        Integer anilistId2;
        Ref.ObjectRef animeMetaData;
        ShowStatus showStatus19;
        String url4;
        ShowStatus showStatus20;
        ShowStatus showStatus21;
        ShowStatus showStatus22;
        ShowStatus showStatus23;
        TvType tvType3;
        Integer anilistId3;
        Ref.ObjectRef animeMetaData2;
        List tags3;
        ShowStatus showStatus24;
        ShowStatus showStatus25;
        ShowStatus showStatus26;
        Document doc3;
        List tags4;
        ShowStatus showStatus27;
        ShowStatus showStatus28;
        ShowStatus showStatus29;
        TvType tvType4;
        ShowStatus showStatus30;
        ShowStatus showStatus31;
        ShowStatus showStatus32;
        Object obj3;
        ShowStatus showStatus33;
        ShowStatus showStatus34;
        ShowStatus showStatus35;
        TvType tvType5;
        Integer anilistId4;
        Ref.ObjectRef animeMetaData3;
        List tags5;
        ShowStatus showStatus36;
        Document doc4;
        List subEpisodes;
        List dubEpisodes;
        Iterable $this$forEach$iv;
        MetaAnimeData metaAnimeData;
        ShowStatus showStatus37;
        Object objNewAnimeLoadResponse$default;
        Iterable images;
        Object element$iv;
        ImageData imageData;
        ShowStatus url5;
        ImageData it;
        Element ep;
        Element elementSelectFirst9;
        ShowStatus showStatus38;
        String url6;
        TvType tvType6;
        Iterable $this$forEach$iv2;
        String epHref;
        Element elementSelectFirst10;
        ShowStatus showStatusText6;
        ShowStatus showStatus39;
        ShowStatus intOrNull2;
        final ShowStatus showStatus40;
        MetaAnimeData metaAnimeData2;
        MetaEpisode metaEpisode;
        ShowStatus showStatus41;
        String str;
        final ShowStatus showStatus42;
        String str2;
        MetaAnimeData metaAnimeData3;
        MetaAnimeData metaAnimeData4;
        Map<String, String> titles;
        Map<String, String> titles2;
        Map<String, String> title;
        Map<String, String> title2;
        String overview;
        final String description;
        MetaAnimeData metaAnimeData5;
        ShowStatus url7;
        final ShowStatus showStatus43;
        List<ImageData> images2;
        ImageData imageData2;
        final ShowStatus rating;
        final ShowStatus runtime;
        final ShowStatus airDateUtc;
        Iterable $this$map$iv;
        Collection destination$iv$iv2;
        List badges;
        boolean hasSub;
        boolean hasDub;
        ShowStatus image;
        Map<String, String> title3;
        String str3;
        Map<String, MetaEpisode> episodes;
        String strReplace;
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
                obj = coroutine_suspended;
                Requests app = MainActivityKt.getApp();
                c00012.L$0 = url;
                c00012.label = 1;
                showStatus = null;
                Object obj4 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00012, 4094, (Object) null);
                c00012 = c00012;
                if (obj4 == obj) {
                    return obj;
                }
                obj2 = obj4;
                url2 = url;
                doc = ((NiceResponse) obj2).getDocument();
                elementSelectFirst = doc.selectFirst("h1");
                if (elementSelectFirst != null) {
                    return showStatus;
                }
                showStatusText = elementSelectFirst.text();
                if (showStatusText == null) {
                    return showStatus;
                }
                elementSelectFirst2 = doc.selectFirst(".nv-info-alt-title");
                if (elementSelectFirst2 != null) {
                    showStatusText2 = elementSelectFirst2.text();
                } else {
                    showStatusText2 = showStatus;
                }
                elementSelectFirst3 = doc.selectFirst("aside.nv-info-poster img");
                if (elementSelectFirst3 != null) {
                    showStatusAttr = elementSelectFirst3.attr("src");
                } else {
                    showStatusAttr = showStatus;
                }
                elementSelectFirst4 = doc.selectFirst(".nv-info-bg");
                if (elementSelectFirst4 != null) {
                    showStatusAttr2 = elementSelectFirst4.attr("style");
                } else {
                    showStatusAttr2 = showStatus;
                }
                if (showStatusAttr2 != null || (matchResultFind$default = Regex.find$default(new Regex("url\\(['\"]?(.*?)['\"]?\\)"), (CharSequence) showStatusAttr2, 0, 2, showStatus)) == null || (groupValues = matchResultFind$default.getGroupValues()) == null) {
                    z = true;
                    showStatus2 = showStatus;
                } else {
                    z = true;
                    showStatus2 = (String) groupValues.get(1);
                }
                elementSelectFirst5 = doc.selectFirst("p.nv-info-desc");
                if (elementSelectFirst5 != null) {
                    showStatusText3 = elementSelectFirst5.text();
                } else {
                    showStatusText3 = showStatus;
                }
                Iterable $this$map$iv2 = doc.select(".nv-info-tags span");
                showStatus3 = showStatus;
                showStatus4 = showStatusAttr2;
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                for (Object item$iv$iv : $this$map$iv2) {
                    Element it2 = (Element) item$iv$iv;
                    destination$iv$iv.add(it2.text());
                }
                tags = (List) destination$iv$iv;
                elementSelectFirst6 = doc.selectFirst(".nv-info-stats div:contains(Release) strong");
                if (elementSelectFirst6 != null || (strText = elementSelectFirst6.text()) == null) {
                    intOrNull = showStatus3;
                } else {
                    intOrNull = StringsKt.toIntOrNull(strText);
                }
                elementSelectFirst7 = doc.selectFirst(".nv-info-stats div:contains(Type) strong");
                if (elementSelectFirst7 != null) {
                    showStatusText4 = elementSelectFirst7.text();
                } else {
                    showStatusText4 = showStatus3;
                }
                if (showStatusText4 == null && StringsKt.contains((CharSequence) showStatusText4, "Movie", z) == z) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    tvType = TvType.AnimeMovie;
                } else {
                    if (showStatusText4 == null && StringsKt.contains((CharSequence) showStatusText4, "OVA", z) == z) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                        tvType = TvType.OVA;
                    } else {
                        tvType = TvType.Anime;
                    }
                }
                elementSelectFirst8 = doc.selectFirst(".nv-info-stats div:contains(Status) strong");
                if (elementSelectFirst8 != null) {
                    showStatusText5 = elementSelectFirst8.text();
                } else {
                    showStatusText5 = showStatus3;
                }
                if (showStatusText5 != null) {
                    showStatus5 = showStatusText2;
                    z4 = StringsKt.contains((CharSequence) showStatusText5, "Currently Airing", true);
                    if (z4) {
                        showStatus6 = ShowStatus.Ongoing;
                    } else if (showStatusText5 == null && StringsKt.contains((CharSequence) showStatusText5, "Completed", true)) {
                        showStatus6 = ShowStatus.Completed;
                    } else {
                        showStatus6 = showStatus3;
                    }
                    if (showStatus5 == null) {
                        showStatus7 = showStatusText;
                    } else {
                        showStatus7 = showStatus5;
                    }
                    c00012.L$0 = url2;
                    c00012.L$1 = doc;
                    c00012.L$2 = showStatusText;
                    c00012.L$3 = SpillingKt.nullOutSpilledVariable(showStatus5);
                    c00012.L$4 = showStatusAttr;
                    c00012.L$5 = SpillingKt.nullOutSpilledVariable(showStatus4);
                    c00012.L$6 = showStatus2;
                    c00012.L$7 = showStatusText3;
                    c00012.L$8 = tags;
                    c00012.L$9 = intOrNull;
                    c00012.L$10 = SpillingKt.nullOutSpilledVariable(showStatusText4);
                    c00012.L$11 = tvType;
                    c00012.L$12 = SpillingKt.nullOutSpilledVariable(showStatusText5);
                    c00012.L$13 = showStatus6;
                    c00012.L$14 = SpillingKt.nullOutSpilledVariable(showStatus7);
                    c00012.label = 2;
                    anilistId = AninekoUtilsKt.getAnilistId(showStatus7, c00012);
                    if (anilistId == obj) {
                        return obj;
                    }
                    ShowStatus showStatus44 = showStatusAttr;
                    tags2 = tags;
                    doc2 = doc;
                    showStatus8 = showStatus44;
                    TvType tvType7 = tvType;
                    showStatus9 = showStatus6;
                    showStatus10 = showStatusText3;
                    tvType2 = tvType7;
                    showStatus11 = showStatus4;
                    showStatus12 = showStatus7;
                    url3 = url2;
                    showStatus13 = showStatusText;
                    showStatus14 = intOrNull;
                    showStatus15 = showStatusText4;
                    showStatus16 = showStatus2;
                    showStatus17 = showStatusText5;
                    showStatus18 = showStatus5;
                    anilistId2 = (Integer) anilistId;
                    animeMetaData = new Ref.ObjectRef();
                    if (anilistId2 != null) {
                        String aniZipUrl = "https://api.ani.zip/mappings?anilist_id=" + anilistId2.intValue();
                        Requests app2 = MainActivityKt.getApp();
                        c00012.L$0 = url3;
                        c00012.L$1 = doc2;
                        c00012.L$2 = showStatus13;
                        doc3 = doc2;
                        c00012.L$3 = SpillingKt.nullOutSpilledVariable(showStatus18);
                        c00012.L$4 = showStatus8;
                        c00012.L$5 = SpillingKt.nullOutSpilledVariable(showStatus11);
                        c00012.L$6 = showStatus16;
                        c00012.L$7 = showStatus10;
                        c00012.L$8 = tags2;
                        c00012.L$9 = showStatus14;
                        c00012.L$10 = SpillingKt.nullOutSpilledVariable(showStatus15);
                        c00012.L$11 = tvType2;
                        c00012.L$12 = SpillingKt.nullOutSpilledVariable(showStatus17);
                        c00012.L$13 = showStatus9;
                        c00012.L$14 = SpillingKt.nullOutSpilledVariable(showStatus12);
                        c00012.L$15 = anilistId2;
                        c00012.L$16 = animeMetaData;
                        c00012.L$17 = SpillingKt.nullOutSpilledVariable(aniZipUrl);
                        c00012.label = 3;
                        tags4 = tags2;
                        showStatus27 = showStatus16;
                        showStatus28 = showStatus10;
                        C00011 c00013 = c00012;
                        showStatus29 = showStatus9;
                        tvType4 = tvType2;
                        showStatus30 = showStatus8;
                        showStatus31 = showStatus13;
                        showStatus32 = showStatus14;
                        obj3 = Requests.get$default(app2, aniZipUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00013, 4094, (Object) null);
                        c00012 = c00013;
                        if (obj3 == obj) {
                            return obj;
                        }
                        showStatus33 = showStatus12;
                        showStatus20 = showStatus17;
                        showStatus21 = showStatus15;
                        showStatus34 = showStatus28;
                        showStatus35 = showStatus29;
                        tvType5 = tvType4;
                        anilistId4 = anilistId2;
                        animeMetaData3 = animeMetaData;
                        tags5 = tags4;
                        showStatus36 = showStatus27;
                        doc4 = doc3;
                        String aniZipResponse = ((NiceResponse) obj3).getText();
                        animeMetaData3.element = AninekoUtilsKt.parseAnimeData(aniZipResponse);
                        Ref.ObjectRef objectRef = animeMetaData3;
                        url4 = url3;
                        animeMetaData2 = objectRef;
                        tags3 = tags5;
                        showStatus19 = showStatus36;
                        showStatus22 = showStatus34;
                        anilistId3 = anilistId4;
                        showStatus12 = showStatus33;
                        showStatus23 = showStatus35;
                        tvType3 = tvType5;
                        doc2 = doc4;
                        showStatus24 = showStatus32;
                        showStatus25 = showStatus30;
                        showStatus26 = showStatus31;
                    } else {
                        ShowStatus showStatus45 = showStatus14;
                        List tags6 = tags2;
                        showStatus19 = showStatus16;
                        url4 = url3;
                        showStatus20 = showStatus17;
                        showStatus21 = showStatus15;
                        showStatus22 = showStatus10;
                        showStatus23 = showStatus9;
                        tvType3 = tvType2;
                        anilistId3 = anilistId2;
                        animeMetaData2 = animeMetaData;
                        tags3 = tags6;
                        showStatus24 = showStatus45;
                        showStatus25 = showStatus8;
                        showStatus26 = showStatus13;
                    }
                    subEpisodes = new ArrayList();
                    dubEpisodes = new ArrayList();
                    $this$forEach$iv = doc2.select(".nv-info-episode-item");
                    for (Object element$iv2 : $this$forEach$iv) {
                        ep = (Element) element$iv2;
                        Document doc5 = doc2;
                        elementSelectFirst9 = ep.selectFirst("a.nv-info-episode-main");
                        if (elementSelectFirst9 != null) {
                            showStatus38 = showStatus26;
                            epHref = elementSelectFirst9.attr("href");
                            if (epHref == null) {
                                url6 = url4;
                                tvType6 = tvType3;
                                $this$forEach$iv2 = $this$forEach$iv;
                            } else {
                                elementSelectFirst10 = ep.selectFirst("a.nv-info-episode-main strong");
                                if (elementSelectFirst10 != null) {
                                    showStatusText6 = elementSelectFirst10.text();
                                } else {
                                    showStatusText6 = showStatus3;
                                }
                                showStatus39 = showStatusText6;
                                if (showStatus39 != null) {
                                    url6 = url4;
                                    tvType6 = tvType3;
                                    $this$forEach$iv2 = $this$forEach$iv;
                                    strReplace = new Regex("[^0-9]").replace((CharSequence) showStatus39, "");
                                    if (strReplace != null) {
                                        intOrNull2 = StringsKt.toIntOrNull(strReplace);
                                    }
                                    showStatus40 = intOrNull2;
                                    metaAnimeData2 = (MetaAnimeData) animeMetaData2.element;
                                    if (metaAnimeData2 != null || (episodes = metaAnimeData2.getEpisodes()) == null) {
                                        metaEpisode = showStatus3;
                                    } else {
                                        metaEpisode = episodes.get(showStatus40 != null ? String.valueOf(showStatus40.intValue()) : showStatus3);
                                    }
                                    if (metaEpisode != null || (title3 = metaEpisode.getTitle()) == null || (str3 = title3.get("en")) == null) {
                                        if (metaEpisode != null) {
                                            showStatus41 = "";
                                            title2 = metaEpisode.getTitle();
                                            if (title2 != null) {
                                                str = title2.get("x-jat");
                                            }
                                            if (str == null) {
                                                if (metaEpisode != null || (title = metaEpisode.getTitle()) == null) {
                                                    str2 = showStatus3;
                                                } else {
                                                    str2 = title.get("ja");
                                                }
                                                if (str2 != null) {
                                                    showStatus42 = str2;
                                                } else {
                                                    metaAnimeData3 = (MetaAnimeData) animeMetaData2.element;
                                                    if (metaAnimeData3 != null || (titles2 = metaAnimeData3.getTitles()) == null) {
                                                        str2 = showStatus3;
                                                    } else {
                                                        str2 = titles2.get("en");
                                                    }
                                                    if (str2 != null) {
                                                        showStatus42 = str2;
                                                    } else {
                                                        metaAnimeData4 = (MetaAnimeData) animeMetaData2.element;
                                                        if (metaAnimeData4 != null || (titles = metaAnimeData4.getTitles()) == null) {
                                                            str2 = showStatus3;
                                                        } else {
                                                            str2 = titles.get("x-jat");
                                                        }
                                                        if (str2 == null) {
                                                            showStatus42 = showStatus39;
                                                        } else {
                                                            showStatus42 = str2;
                                                        }
                                                    }
                                                }
                                            } else {
                                                metaEpisode = metaEpisode;
                                                showStatus42 = str;
                                            }
                                        } else {
                                            showStatus41 = "";
                                        }
                                        str = showStatus3;
                                        if (str == null) {
                                            if (metaEpisode != null) {
                                                str2 = showStatus3;
                                            } else {
                                                str2 = showStatus3;
                                            }
                                            if (str2 != null) {
                                                showStatus42 = str2;
                                            } else {
                                                metaAnimeData3 = (MetaAnimeData) animeMetaData2.element;
                                                if (metaAnimeData3 != null) {
                                                    str2 = showStatus3;
                                                } else {
                                                    str2 = showStatus3;
                                                }
                                                if (str2 != null) {
                                                    showStatus42 = str2;
                                                } else {
                                                    metaAnimeData4 = (MetaAnimeData) animeMetaData2.element;
                                                    if (metaAnimeData4 != null) {
                                                        str2 = showStatus3;
                                                    } else {
                                                        str2 = showStatus3;
                                                    }
                                                    if (str2 == null) {
                                                        showStatus42 = showStatus39;
                                                    } else {
                                                        showStatus42 = str2;
                                                    }
                                                }
                                            }
                                        } else {
                                            metaEpisode = metaEpisode;
                                            showStatus42 = str;
                                        }
                                    } else {
                                        showStatus41 = "";
                                        showStatus42 = str3;
                                        metaEpisode = metaEpisode;
                                    }
                                    if (metaEpisode != null || (overview = metaEpisode.getOverview()) == null) {
                                        overview = "No summary available";
                                    }
                                    description = overview;
                                    if (metaEpisode != null || (image = metaEpisode.getImage()) == null) {
                                        metaAnimeData5 = (MetaAnimeData) animeMetaData2.element;
                                        if (metaAnimeData5 != null || (images2 = metaAnimeData5.getImages()) == null || (imageData2 = (ImageData) CollectionsKt.firstOrNull(images2)) == null) {
                                            url7 = showStatus3;
                                        } else {
                                            url7 = imageData2.getUrl();
                                        }
                                        if (url7 == null) {
                                            showStatus43 = showStatus41;
                                        } else {
                                            showStatus43 = url7;
                                        }
                                    } else {
                                        showStatus43 = image;
                                    }
                                    if (metaEpisode != null) {
                                        rating = metaEpisode.getRating();
                                    } else {
                                        rating = showStatus3;
                                    }
                                    if (metaEpisode != null) {
                                        runtime = metaEpisode.getRuntime();
                                    } else {
                                        runtime = showStatus3;
                                    }
                                    if (metaEpisode != null) {
                                        airDateUtc = metaEpisode.getAirDateUtc();
                                    } else {
                                        airDateUtc = showStatus3;
                                    }
                                    $this$map$iv = ep.select(".nv-info-episode-badges span");
                                    int $i$f$map = CollectionsKt.collectionSizeOrDefault($this$map$iv, 10);
                                    destination$iv$iv2 = new ArrayList($i$f$map);
                                    for (Object item$iv$iv2 : $this$map$iv) {
                                        Element it3 = (Element) item$iv$iv2;
                                        Iterable $this$map$iv3 = $this$map$iv;
                                        String lowerCase = it3.text().toLowerCase(Locale.ROOT);
                                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                        destination$iv$iv2.add(lowerCase);
                                        $this$map$iv = $this$map$iv3;
                                    }
                                    badges = (List) destination$iv$iv2;
                                    if (!badges.contains("sub") || badges.contains("hsub") || badges.contains("hardsub")) {
                                        hasSub = true;
                                    } else {
                                        hasSub = false;
                                    }
                                    hasDub = badges.contains("dub");
                                    if (hasSub || !hasDub) {
                                        subEpisodes.add(MainAPIKt.newEpisode(this, getMainUrl() + epHref + "|sub", new Function1() { // from class: com.anineko.Anineko$$ExternalSyntheticLambda0
                                            public final Object invoke(Object obj5) {
                                                return Anineko.load$lambda$2$1(showStatus42, showStatus40, description, showStatus43, rating, runtime, airDateUtc, (Episode) obj5);
                                            }
                                        }));
                                    }
                                    if (hasDub) {
                                        dubEpisodes.add(MainAPIKt.newEpisode(this, getMainUrl() + epHref + "|dub", new Function1() { // from class: com.anineko.Anineko$$ExternalSyntheticLambda1
                                            public final Object invoke(Object obj5) {
                                                return Anineko.load$lambda$2$2(showStatus42, showStatus40, description, showStatus43, rating, runtime, airDateUtc, (Episode) obj5);
                                            }
                                        }));
                                    }
                                } else {
                                    url6 = url4;
                                    tvType6 = tvType3;
                                    $this$forEach$iv2 = $this$forEach$iv;
                                }
                                intOrNull2 = showStatus3;
                                showStatus40 = intOrNull2;
                                metaAnimeData2 = (MetaAnimeData) animeMetaData2.element;
                                if (metaAnimeData2 != null) {
                                    metaEpisode = showStatus3;
                                } else {
                                    metaEpisode = showStatus3;
                                }
                                if (metaEpisode != null) {
                                    if (metaEpisode != null) {
                                        showStatus41 = "";
                                        title2 = metaEpisode.getTitle();
                                        if (title2 != null) {
                                            str = title2.get("x-jat");
                                        }
                                        if (str == null) {
                                            if (metaEpisode != null) {
                                                str2 = showStatus3;
                                            } else {
                                                str2 = showStatus3;
                                            }
                                            if (str2 != null) {
                                                showStatus42 = str2;
                                            } else {
                                                metaAnimeData3 = (MetaAnimeData) animeMetaData2.element;
                                                if (metaAnimeData3 != null) {
                                                    str2 = showStatus3;
                                                } else {
                                                    str2 = showStatus3;
                                                }
                                                if (str2 != null) {
                                                    showStatus42 = str2;
                                                } else {
                                                    metaAnimeData4 = (MetaAnimeData) animeMetaData2.element;
                                                    if (metaAnimeData4 != null) {
                                                        str2 = showStatus3;
                                                    } else {
                                                        str2 = showStatus3;
                                                    }
                                                    if (str2 == null) {
                                                        showStatus42 = showStatus39;
                                                    } else {
                                                        showStatus42 = str2;
                                                    }
                                                }
                                            }
                                        } else {
                                            metaEpisode = metaEpisode;
                                            showStatus42 = str;
                                        }
                                    } else {
                                        showStatus41 = "";
                                    }
                                    str = showStatus3;
                                    if (str == null) {
                                        if (metaEpisode != null) {
                                            str2 = showStatus3;
                                        } else {
                                            str2 = showStatus3;
                                        }
                                        if (str2 != null) {
                                            showStatus42 = str2;
                                        } else {
                                            metaAnimeData3 = (MetaAnimeData) animeMetaData2.element;
                                            if (metaAnimeData3 != null) {
                                                str2 = showStatus3;
                                            } else {
                                                str2 = showStatus3;
                                            }
                                            if (str2 != null) {
                                                showStatus42 = str2;
                                            } else {
                                                metaAnimeData4 = (MetaAnimeData) animeMetaData2.element;
                                                if (metaAnimeData4 != null) {
                                                    str2 = showStatus3;
                                                } else {
                                                    str2 = showStatus3;
                                                }
                                                if (str2 == null) {
                                                    showStatus42 = showStatus39;
                                                } else {
                                                    showStatus42 = str2;
                                                }
                                            }
                                        }
                                    } else {
                                        metaEpisode = metaEpisode;
                                        showStatus42 = str;
                                    }
                                } else {
                                    if (metaEpisode != null) {
                                        showStatus41 = "";
                                        title2 = metaEpisode.getTitle();
                                        if (title2 != null) {
                                            str = title2.get("x-jat");
                                        }
                                        if (str == null) {
                                            if (metaEpisode != null) {
                                                str2 = showStatus3;
                                            } else {
                                                str2 = showStatus3;
                                            }
                                            if (str2 != null) {
                                                showStatus42 = str2;
                                            } else {
                                                metaAnimeData3 = (MetaAnimeData) animeMetaData2.element;
                                                if (metaAnimeData3 != null) {
                                                    str2 = showStatus3;
                                                } else {
                                                    str2 = showStatus3;
                                                }
                                                if (str2 != null) {
                                                    showStatus42 = str2;
                                                } else {
                                                    metaAnimeData4 = (MetaAnimeData) animeMetaData2.element;
                                                    if (metaAnimeData4 != null) {
                                                        str2 = showStatus3;
                                                    } else {
                                                        str2 = showStatus3;
                                                    }
                                                    if (str2 == null) {
                                                        showStatus42 = showStatus39;
                                                    } else {
                                                        showStatus42 = str2;
                                                    }
                                                }
                                            }
                                        } else {
                                            metaEpisode = metaEpisode;
                                            showStatus42 = str;
                                        }
                                    } else {
                                        showStatus41 = "";
                                    }
                                    str = showStatus3;
                                    if (str == null) {
                                        if (metaEpisode != null) {
                                            str2 = showStatus3;
                                        } else {
                                            str2 = showStatus3;
                                        }
                                        if (str2 != null) {
                                            showStatus42 = str2;
                                        } else {
                                            metaAnimeData3 = (MetaAnimeData) animeMetaData2.element;
                                            if (metaAnimeData3 != null) {
                                                str2 = showStatus3;
                                            } else {
                                                str2 = showStatus3;
                                            }
                                            if (str2 != null) {
                                                showStatus42 = str2;
                                            } else {
                                                metaAnimeData4 = (MetaAnimeData) animeMetaData2.element;
                                                if (metaAnimeData4 != null) {
                                                    str2 = showStatus3;
                                                } else {
                                                    str2 = showStatus3;
                                                }
                                                if (str2 == null) {
                                                    showStatus42 = showStatus39;
                                                } else {
                                                    showStatus42 = str2;
                                                }
                                            }
                                        }
                                    } else {
                                        metaEpisode = metaEpisode;
                                        showStatus42 = str;
                                    }
                                }
                                if (metaEpisode != null) {
                                    overview = "No summary available";
                                } else {
                                    overview = "No summary available";
                                }
                                description = overview;
                                if (metaEpisode != null) {
                                    metaAnimeData5 = (MetaAnimeData) animeMetaData2.element;
                                    if (metaAnimeData5 != null) {
                                        url7 = showStatus3;
                                    } else {
                                        url7 = showStatus3;
                                    }
                                    if (url7 == null) {
                                        showStatus43 = showStatus41;
                                    } else {
                                        showStatus43 = url7;
                                    }
                                } else {
                                    metaAnimeData5 = (MetaAnimeData) animeMetaData2.element;
                                    if (metaAnimeData5 != null) {
                                        url7 = showStatus3;
                                    } else {
                                        url7 = showStatus3;
                                    }
                                    if (url7 == null) {
                                        showStatus43 = showStatus41;
                                    } else {
                                        showStatus43 = url7;
                                    }
                                }
                                if (metaEpisode != null) {
                                    rating = metaEpisode.getRating();
                                } else {
                                    rating = showStatus3;
                                }
                                if (metaEpisode != null) {
                                    runtime = metaEpisode.getRuntime();
                                } else {
                                    runtime = showStatus3;
                                }
                                if (metaEpisode != null) {
                                    airDateUtc = metaEpisode.getAirDateUtc();
                                } else {
                                    airDateUtc = showStatus3;
                                }
                                $this$map$iv = ep.select(".nv-info-episode-badges span");
                                int $i$f$map2 = CollectionsKt.collectionSizeOrDefault($this$map$iv, 10);
                                destination$iv$iv2 = new ArrayList($i$f$map2);
                                while (r31.hasNext()) {
                                    Element it4 = (Element) item$iv$iv2;
                                    Iterable $this$map$iv4 = $this$map$iv;
                                    String lowerCase2 = it4.text().toLowerCase(Locale.ROOT);
                                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                                    destination$iv$iv2.add(lowerCase2);
                                    $this$map$iv = $this$map$iv4;
                                }
                                badges = (List) destination$iv$iv2;
                                if (badges.contains("sub")) {
                                    hasSub = true;
                                } else {
                                    hasSub = true;
                                }
                                hasDub = badges.contains("dub");
                                if (hasSub) {
                                    subEpisodes.add(MainAPIKt.newEpisode(this, getMainUrl() + epHref + "|sub", new Function1() { // from class: com.anineko.Anineko$$ExternalSyntheticLambda0
                                        public final Object invoke(Object obj5) {
                                            return Anineko.load$lambda$2$1(showStatus42, showStatus40, description, showStatus43, rating, runtime, airDateUtc, (Episode) obj5);
                                        }
                                    }));
                                } else {
                                    subEpisodes.add(MainAPIKt.newEpisode(this, getMainUrl() + epHref + "|sub", new Function1() { // from class: com.anineko.Anineko$$ExternalSyntheticLambda0
                                        public final Object invoke(Object obj5) {
                                            return Anineko.load$lambda$2$1(showStatus42, showStatus40, description, showStatus43, rating, runtime, airDateUtc, (Episode) obj5);
                                        }
                                    }));
                                }
                                if (hasDub) {
                                    dubEpisodes.add(MainAPIKt.newEpisode(this, getMainUrl() + epHref + "|dub", new Function1() { // from class: com.anineko.Anineko$$ExternalSyntheticLambda1
                                        public final Object invoke(Object obj5) {
                                            return Anineko.load$lambda$2$2(showStatus42, showStatus40, description, showStatus43, rating, runtime, airDateUtc, (Episode) obj5);
                                        }
                                    }));
                                }
                            }
                        } else {
                            showStatus38 = showStatus26;
                            url6 = url4;
                            tvType6 = tvType3;
                            $this$forEach$iv2 = $this$forEach$iv;
                        }
                        showStatus26 = showStatus38;
                        doc2 = doc5;
                        url4 = url6;
                        tvType3 = tvType6;
                        $this$forEach$iv = $this$forEach$iv2;
                    }
                    Document doc6 = doc2;
                    ShowStatus showStatus46 = showStatus26;
                    String url8 = url4;
                    TvType tvType8 = tvType3;
                    metaAnimeData = (MetaAnimeData) animeMetaData2.element;
                    if (metaAnimeData != null || (images = metaAnimeData.getImages()) == null) {
                        showStatus37 = showStatus19;
                    } else {
                        Iterable $this$firstOrNull$iv = images;
                        Iterator it5 = $this$firstOrNull$iv.iterator();
                        do {
                            if (it5.hasNext()) {
                                element$iv = it5.next();
                                it = (ImageData) element$iv;
                            } else {
                                element$iv = showStatus3;
                            }
                            imageData = (ImageData) element$iv;
                            if (imageData != null || (url5 = imageData.getUrl()) == null) {
                                showStatus37 = showStatus19;
                            } else {
                                showStatus37 = url5;
                            }
                        } while (!Intrinsics.areEqual(it.getCoverType(), "Fanart"));
                        imageData = (ImageData) element$iv;
                        if (imageData != null) {
                            showStatus37 = showStatus19;
                        } else {
                            showStatus37 = showStatus19;
                        }
                    }
                    C00023 c00023 = new C00023(showStatus25, showStatus37, showStatus24, showStatus22, tags3, showStatus23, anilistId3, subEpisodes, dubEpisodes, null);
                    c00012.L$0 = SpillingKt.nullOutSpilledVariable(url8);
                    c00012.L$1 = SpillingKt.nullOutSpilledVariable(doc6);
                    c00012.L$2 = SpillingKt.nullOutSpilledVariable(showStatus46);
                    c00012.L$3 = SpillingKt.nullOutSpilledVariable(showStatus18);
                    c00012.L$4 = SpillingKt.nullOutSpilledVariable(showStatus25);
                    c00012.L$5 = SpillingKt.nullOutSpilledVariable(showStatus11);
                    c00012.L$6 = SpillingKt.nullOutSpilledVariable(showStatus19);
                    c00012.L$7 = SpillingKt.nullOutSpilledVariable(showStatus22);
                    c00012.L$8 = SpillingKt.nullOutSpilledVariable(tags3);
                    c00012.L$9 = SpillingKt.nullOutSpilledVariable(showStatus24);
                    c00012.L$10 = SpillingKt.nullOutSpilledVariable(showStatus21);
                    c00012.L$11 = SpillingKt.nullOutSpilledVariable(tvType8);
                    c00012.L$12 = SpillingKt.nullOutSpilledVariable(showStatus20);
                    c00012.L$13 = SpillingKt.nullOutSpilledVariable(showStatus23);
                    c00012.L$14 = SpillingKt.nullOutSpilledVariable(showStatus12);
                    c00012.L$15 = SpillingKt.nullOutSpilledVariable(anilistId3);
                    c00012.L$16 = SpillingKt.nullOutSpilledVariable(animeMetaData2);
                    c00012.L$17 = SpillingKt.nullOutSpilledVariable(subEpisodes);
                    c00012.L$18 = SpillingKt.nullOutSpilledVariable(dubEpisodes);
                    c00012.L$19 = SpillingKt.nullOutSpilledVariable(showStatus37);
                    c00012.label = 4;
                    objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, showStatus46, url8, tvType8, false, c00023, c00012, 8, (Object) null);
                    if (objNewAnimeLoadResponse$default == obj) {
                        return obj;
                    }
                    return objNewAnimeLoadResponse$default;
                }
                showStatus5 = showStatusText2;
                if (z4) {
                    showStatus6 = ShowStatus.Ongoing;
                } else if (showStatusText5 == null && StringsKt.contains((CharSequence) showStatusText5, "Completed", true)) {
                    showStatus6 = ShowStatus.Completed;
                } else {
                    showStatus6 = showStatus3;
                }
                if (showStatus5 == null) {
                    showStatus7 = showStatusText;
                } else {
                    showStatus7 = showStatus5;
                }
                c00012.L$0 = url2;
                c00012.L$1 = doc;
                c00012.L$2 = showStatusText;
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(showStatus5);
                c00012.L$4 = showStatusAttr;
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(showStatus4);
                c00012.L$6 = showStatus2;
                c00012.L$7 = showStatusText3;
                c00012.L$8 = tags;
                c00012.L$9 = intOrNull;
                c00012.L$10 = SpillingKt.nullOutSpilledVariable(showStatusText4);
                c00012.L$11 = tvType;
                c00012.L$12 = SpillingKt.nullOutSpilledVariable(showStatusText5);
                c00012.L$13 = showStatus6;
                c00012.L$14 = SpillingKt.nullOutSpilledVariable(showStatus7);
                c00012.label = 2;
                anilistId = AninekoUtilsKt.getAnilistId(showStatus7, c00012);
                if (anilistId == obj) {
                    return obj;
                }
                ShowStatus showStatus47 = showStatusAttr;
                tags2 = tags;
                doc2 = doc;
                showStatus8 = showStatus47;
                TvType tvType9 = tvType;
                showStatus9 = showStatus6;
                showStatus10 = showStatusText3;
                tvType2 = tvType9;
                showStatus11 = showStatus4;
                showStatus12 = showStatus7;
                url3 = url2;
                showStatus13 = showStatusText;
                showStatus14 = intOrNull;
                showStatus15 = showStatusText4;
                showStatus16 = showStatus2;
                showStatus17 = showStatusText5;
                showStatus18 = showStatus5;
                anilistId2 = (Integer) anilistId;
                animeMetaData = new Ref.ObjectRef();
                if (anilistId2 != null) {
                    String aniZipUrl2 = "https://api.ani.zip/mappings?anilist_id=" + anilistId2.intValue();
                    Requests app3 = MainActivityKt.getApp();
                    c00012.L$0 = url3;
                    c00012.L$1 = doc2;
                    c00012.L$2 = showStatus13;
                    doc3 = doc2;
                    c00012.L$3 = SpillingKt.nullOutSpilledVariable(showStatus18);
                    c00012.L$4 = showStatus8;
                    c00012.L$5 = SpillingKt.nullOutSpilledVariable(showStatus11);
                    c00012.L$6 = showStatus16;
                    c00012.L$7 = showStatus10;
                    c00012.L$8 = tags2;
                    c00012.L$9 = showStatus14;
                    c00012.L$10 = SpillingKt.nullOutSpilledVariable(showStatus15);
                    c00012.L$11 = tvType2;
                    c00012.L$12 = SpillingKt.nullOutSpilledVariable(showStatus17);
                    c00012.L$13 = showStatus9;
                    c00012.L$14 = SpillingKt.nullOutSpilledVariable(showStatus12);
                    c00012.L$15 = anilistId2;
                    c00012.L$16 = animeMetaData;
                    c00012.L$17 = SpillingKt.nullOutSpilledVariable(aniZipUrl2);
                    c00012.label = 3;
                    tags4 = tags2;
                    showStatus27 = showStatus16;
                    showStatus28 = showStatus10;
                    C00011 c00014 = c00012;
                    showStatus29 = showStatus9;
                    tvType4 = tvType2;
                    showStatus30 = showStatus8;
                    showStatus31 = showStatus13;
                    showStatus32 = showStatus14;
                    obj3 = Requests.get$default(app3, aniZipUrl2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00014, 4094, (Object) null);
                    c00012 = c00014;
                    if (obj3 == obj) {
                        return obj;
                    }
                    showStatus33 = showStatus12;
                    showStatus20 = showStatus17;
                    showStatus21 = showStatus15;
                    showStatus34 = showStatus28;
                    showStatus35 = showStatus29;
                    tvType5 = tvType4;
                    anilistId4 = anilistId2;
                    animeMetaData3 = animeMetaData;
                    tags5 = tags4;
                    showStatus36 = showStatus27;
                    doc4 = doc3;
                    String aniZipResponse2 = ((NiceResponse) obj3).getText();
                    animeMetaData3.element = AninekoUtilsKt.parseAnimeData(aniZipResponse2);
                    Ref.ObjectRef objectRef2 = animeMetaData3;
                    url4 = url3;
                    animeMetaData2 = objectRef2;
                    tags3 = tags5;
                    showStatus19 = showStatus36;
                    showStatus22 = showStatus34;
                    anilistId3 = anilistId4;
                    showStatus12 = showStatus33;
                    showStatus23 = showStatus35;
                    tvType3 = tvType5;
                    doc2 = doc4;
                    showStatus24 = showStatus32;
                    showStatus25 = showStatus30;
                    showStatus26 = showStatus31;
                } else {
                    ShowStatus showStatus48 = showStatus14;
                    List tags7 = tags2;
                    showStatus19 = showStatus16;
                    url4 = url3;
                    showStatus20 = showStatus17;
                    showStatus21 = showStatus15;
                    showStatus22 = showStatus10;
                    showStatus23 = showStatus9;
                    tvType3 = tvType2;
                    anilistId3 = anilistId2;
                    animeMetaData2 = animeMetaData;
                    tags3 = tags7;
                    showStatus24 = showStatus48;
                    showStatus25 = showStatus8;
                    showStatus26 = showStatus13;
                }
                subEpisodes = new ArrayList();
                dubEpisodes = new ArrayList();
                $this$forEach$iv = doc2.select(".nv-info-episode-item");
                while (r11.hasNext()) {
                    ep = (Element) element$iv2;
                    Document doc7 = doc2;
                    elementSelectFirst9 = ep.selectFirst("a.nv-info-episode-main");
                    if (elementSelectFirst9 != null) {
                        showStatus38 = showStatus26;
                        epHref = elementSelectFirst9.attr("href");
                        if (epHref == null) {
                            url6 = url4;
                            tvType6 = tvType3;
                            $this$forEach$iv2 = $this$forEach$iv;
                        } else {
                            elementSelectFirst10 = ep.selectFirst("a.nv-info-episode-main strong");
                            if (elementSelectFirst10 != null) {
                                showStatusText6 = elementSelectFirst10.text();
                            } else {
                                showStatusText6 = showStatus3;
                            }
                            showStatus39 = showStatusText6;
                            if (showStatus39 != null) {
                                url6 = url4;
                                tvType6 = tvType3;
                                $this$forEach$iv2 = $this$forEach$iv;
                                strReplace = new Regex("[^0-9]").replace((CharSequence) showStatus39, "");
                                if (strReplace != null) {
                                    intOrNull2 = StringsKt.toIntOrNull(strReplace);
                                }
                                showStatus40 = intOrNull2;
                                metaAnimeData2 = (MetaAnimeData) animeMetaData2.element;
                                if (metaAnimeData2 != null) {
                                    metaEpisode = showStatus3;
                                } else {
                                    metaEpisode = showStatus3;
                                }
                                if (metaEpisode != null) {
                                    if (metaEpisode != null) {
                                        showStatus41 = "";
                                        title2 = metaEpisode.getTitle();
                                        if (title2 != null) {
                                            str = title2.get("x-jat");
                                        }
                                        if (str == null) {
                                            if (metaEpisode != null) {
                                                str2 = showStatus3;
                                            } else {
                                                str2 = showStatus3;
                                            }
                                            if (str2 != null) {
                                                showStatus42 = str2;
                                            } else {
                                                metaAnimeData3 = (MetaAnimeData) animeMetaData2.element;
                                                if (metaAnimeData3 != null) {
                                                    str2 = showStatus3;
                                                } else {
                                                    str2 = showStatus3;
                                                }
                                                if (str2 != null) {
                                                    showStatus42 = str2;
                                                } else {
                                                    metaAnimeData4 = (MetaAnimeData) animeMetaData2.element;
                                                    if (metaAnimeData4 != null) {
                                                        str2 = showStatus3;
                                                    } else {
                                                        str2 = showStatus3;
                                                    }
                                                    if (str2 == null) {
                                                        showStatus42 = showStatus39;
                                                    } else {
                                                        showStatus42 = str2;
                                                    }
                                                }
                                            }
                                        } else {
                                            metaEpisode = metaEpisode;
                                            showStatus42 = str;
                                        }
                                    } else {
                                        showStatus41 = "";
                                    }
                                    str = showStatus3;
                                    if (str == null) {
                                        if (metaEpisode != null) {
                                            str2 = showStatus3;
                                        } else {
                                            str2 = showStatus3;
                                        }
                                        if (str2 != null) {
                                            showStatus42 = str2;
                                        } else {
                                            metaAnimeData3 = (MetaAnimeData) animeMetaData2.element;
                                            if (metaAnimeData3 != null) {
                                                str2 = showStatus3;
                                            } else {
                                                str2 = showStatus3;
                                            }
                                            if (str2 != null) {
                                                showStatus42 = str2;
                                            } else {
                                                metaAnimeData4 = (MetaAnimeData) animeMetaData2.element;
                                                if (metaAnimeData4 != null) {
                                                    str2 = showStatus3;
                                                } else {
                                                    str2 = showStatus3;
                                                }
                                                if (str2 == null) {
                                                    showStatus42 = showStatus39;
                                                } else {
                                                    showStatus42 = str2;
                                                }
                                            }
                                        }
                                    } else {
                                        metaEpisode = metaEpisode;
                                        showStatus42 = str;
                                    }
                                } else {
                                    if (metaEpisode != null) {
                                        showStatus41 = "";
                                        title2 = metaEpisode.getTitle();
                                        if (title2 != null) {
                                            str = title2.get("x-jat");
                                        }
                                        if (str == null) {
                                            if (metaEpisode != null) {
                                                str2 = showStatus3;
                                            } else {
                                                str2 = showStatus3;
                                            }
                                            if (str2 != null) {
                                                showStatus42 = str2;
                                            } else {
                                                metaAnimeData3 = (MetaAnimeData) animeMetaData2.element;
                                                if (metaAnimeData3 != null) {
                                                    str2 = showStatus3;
                                                } else {
                                                    str2 = showStatus3;
                                                }
                                                if (str2 != null) {
                                                    showStatus42 = str2;
                                                } else {
                                                    metaAnimeData4 = (MetaAnimeData) animeMetaData2.element;
                                                    if (metaAnimeData4 != null) {
                                                        str2 = showStatus3;
                                                    } else {
                                                        str2 = showStatus3;
                                                    }
                                                    if (str2 == null) {
                                                        showStatus42 = showStatus39;
                                                    } else {
                                                        showStatus42 = str2;
                                                    }
                                                }
                                            }
                                        } else {
                                            metaEpisode = metaEpisode;
                                            showStatus42 = str;
                                        }
                                    } else {
                                        showStatus41 = "";
                                    }
                                    str = showStatus3;
                                    if (str == null) {
                                        if (metaEpisode != null) {
                                            str2 = showStatus3;
                                        } else {
                                            str2 = showStatus3;
                                        }
                                        if (str2 != null) {
                                            showStatus42 = str2;
                                        } else {
                                            metaAnimeData3 = (MetaAnimeData) animeMetaData2.element;
                                            if (metaAnimeData3 != null) {
                                                str2 = showStatus3;
                                            } else {
                                                str2 = showStatus3;
                                            }
                                            if (str2 != null) {
                                                showStatus42 = str2;
                                            } else {
                                                metaAnimeData4 = (MetaAnimeData) animeMetaData2.element;
                                                if (metaAnimeData4 != null) {
                                                    str2 = showStatus3;
                                                } else {
                                                    str2 = showStatus3;
                                                }
                                                if (str2 == null) {
                                                    showStatus42 = showStatus39;
                                                } else {
                                                    showStatus42 = str2;
                                                }
                                            }
                                        }
                                    } else {
                                        metaEpisode = metaEpisode;
                                        showStatus42 = str;
                                    }
                                }
                                if (metaEpisode != null) {
                                    overview = "No summary available";
                                } else {
                                    overview = "No summary available";
                                }
                                description = overview;
                                if (metaEpisode != null) {
                                    metaAnimeData5 = (MetaAnimeData) animeMetaData2.element;
                                    if (metaAnimeData5 != null) {
                                        url7 = showStatus3;
                                    } else {
                                        url7 = showStatus3;
                                    }
                                    if (url7 == null) {
                                        showStatus43 = showStatus41;
                                    } else {
                                        showStatus43 = url7;
                                    }
                                } else {
                                    metaAnimeData5 = (MetaAnimeData) animeMetaData2.element;
                                    if (metaAnimeData5 != null) {
                                        url7 = showStatus3;
                                    } else {
                                        url7 = showStatus3;
                                    }
                                    if (url7 == null) {
                                        showStatus43 = showStatus41;
                                    } else {
                                        showStatus43 = url7;
                                    }
                                }
                                if (metaEpisode != null) {
                                    rating = metaEpisode.getRating();
                                } else {
                                    rating = showStatus3;
                                }
                                if (metaEpisode != null) {
                                    runtime = metaEpisode.getRuntime();
                                } else {
                                    runtime = showStatus3;
                                }
                                if (metaEpisode != null) {
                                    airDateUtc = metaEpisode.getAirDateUtc();
                                } else {
                                    airDateUtc = showStatus3;
                                }
                                $this$map$iv = ep.select(".nv-info-episode-badges span");
                                int $i$f$map3 = CollectionsKt.collectionSizeOrDefault($this$map$iv, 10);
                                destination$iv$iv2 = new ArrayList($i$f$map3);
                                while (r31.hasNext()) {
                                    Element it6 = (Element) item$iv$iv2;
                                    Iterable $this$map$iv5 = $this$map$iv;
                                    String lowerCase3 = it6.text().toLowerCase(Locale.ROOT);
                                    Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                                    destination$iv$iv2.add(lowerCase3);
                                    $this$map$iv = $this$map$iv5;
                                }
                                badges = (List) destination$iv$iv2;
                                if (badges.contains("sub")) {
                                    hasSub = true;
                                } else {
                                    hasSub = true;
                                }
                                hasDub = badges.contains("dub");
                                if (hasSub) {
                                    subEpisodes.add(MainAPIKt.newEpisode(this, getMainUrl() + epHref + "|sub", new Function1() { // from class: com.anineko.Anineko$$ExternalSyntheticLambda0
                                        public final Object invoke(Object obj5) {
                                            return Anineko.load$lambda$2$1(showStatus42, showStatus40, description, showStatus43, rating, runtime, airDateUtc, (Episode) obj5);
                                        }
                                    }));
                                } else {
                                    subEpisodes.add(MainAPIKt.newEpisode(this, getMainUrl() + epHref + "|sub", new Function1() { // from class: com.anineko.Anineko$$ExternalSyntheticLambda0
                                        public final Object invoke(Object obj5) {
                                            return Anineko.load$lambda$2$1(showStatus42, showStatus40, description, showStatus43, rating, runtime, airDateUtc, (Episode) obj5);
                                        }
                                    }));
                                }
                                if (hasDub) {
                                    dubEpisodes.add(MainAPIKt.newEpisode(this, getMainUrl() + epHref + "|dub", new Function1() { // from class: com.anineko.Anineko$$ExternalSyntheticLambda1
                                        public final Object invoke(Object obj5) {
                                            return Anineko.load$lambda$2$2(showStatus42, showStatus40, description, showStatus43, rating, runtime, airDateUtc, (Episode) obj5);
                                        }
                                    }));
                                }
                            } else {
                                url6 = url4;
                                tvType6 = tvType3;
                                $this$forEach$iv2 = $this$forEach$iv;
                            }
                            intOrNull2 = showStatus3;
                            showStatus40 = intOrNull2;
                            metaAnimeData2 = (MetaAnimeData) animeMetaData2.element;
                            if (metaAnimeData2 != null) {
                                metaEpisode = showStatus3;
                            } else {
                                metaEpisode = showStatus3;
                            }
                            if (metaEpisode != null) {
                                if (metaEpisode != null) {
                                    showStatus41 = "";
                                    title2 = metaEpisode.getTitle();
                                    if (title2 != null) {
                                        str = title2.get("x-jat");
                                    }
                                    if (str == null) {
                                        if (metaEpisode != null) {
                                            str2 = showStatus3;
                                        } else {
                                            str2 = showStatus3;
                                        }
                                        if (str2 != null) {
                                            showStatus42 = str2;
                                        } else {
                                            metaAnimeData3 = (MetaAnimeData) animeMetaData2.element;
                                            if (metaAnimeData3 != null) {
                                                str2 = showStatus3;
                                            } else {
                                                str2 = showStatus3;
                                            }
                                            if (str2 != null) {
                                                showStatus42 = str2;
                                            } else {
                                                metaAnimeData4 = (MetaAnimeData) animeMetaData2.element;
                                                if (metaAnimeData4 != null) {
                                                    str2 = showStatus3;
                                                } else {
                                                    str2 = showStatus3;
                                                }
                                                if (str2 == null) {
                                                    showStatus42 = showStatus39;
                                                } else {
                                                    showStatus42 = str2;
                                                }
                                            }
                                        }
                                    } else {
                                        metaEpisode = metaEpisode;
                                        showStatus42 = str;
                                    }
                                } else {
                                    showStatus41 = "";
                                }
                                str = showStatus3;
                                if (str == null) {
                                    if (metaEpisode != null) {
                                        str2 = showStatus3;
                                    } else {
                                        str2 = showStatus3;
                                    }
                                    if (str2 != null) {
                                        showStatus42 = str2;
                                    } else {
                                        metaAnimeData3 = (MetaAnimeData) animeMetaData2.element;
                                        if (metaAnimeData3 != null) {
                                            str2 = showStatus3;
                                        } else {
                                            str2 = showStatus3;
                                        }
                                        if (str2 != null) {
                                            showStatus42 = str2;
                                        } else {
                                            metaAnimeData4 = (MetaAnimeData) animeMetaData2.element;
                                            if (metaAnimeData4 != null) {
                                                str2 = showStatus3;
                                            } else {
                                                str2 = showStatus3;
                                            }
                                            if (str2 == null) {
                                                showStatus42 = showStatus39;
                                            } else {
                                                showStatus42 = str2;
                                            }
                                        }
                                    }
                                } else {
                                    metaEpisode = metaEpisode;
                                    showStatus42 = str;
                                }
                            } else {
                                if (metaEpisode != null) {
                                    showStatus41 = "";
                                    title2 = metaEpisode.getTitle();
                                    if (title2 != null) {
                                        str = title2.get("x-jat");
                                    }
                                    if (str == null) {
                                        if (metaEpisode != null) {
                                            str2 = showStatus3;
                                        } else {
                                            str2 = showStatus3;
                                        }
                                        if (str2 != null) {
                                            showStatus42 = str2;
                                        } else {
                                            metaAnimeData3 = (MetaAnimeData) animeMetaData2.element;
                                            if (metaAnimeData3 != null) {
                                                str2 = showStatus3;
                                            } else {
                                                str2 = showStatus3;
                                            }
                                            if (str2 != null) {
                                                showStatus42 = str2;
                                            } else {
                                                metaAnimeData4 = (MetaAnimeData) animeMetaData2.element;
                                                if (metaAnimeData4 != null) {
                                                    str2 = showStatus3;
                                                } else {
                                                    str2 = showStatus3;
                                                }
                                                if (str2 == null) {
                                                    showStatus42 = showStatus39;
                                                } else {
                                                    showStatus42 = str2;
                                                }
                                            }
                                        }
                                    } else {
                                        metaEpisode = metaEpisode;
                                        showStatus42 = str;
                                    }
                                } else {
                                    showStatus41 = "";
                                }
                                str = showStatus3;
                                if (str == null) {
                                    if (metaEpisode != null) {
                                        str2 = showStatus3;
                                    } else {
                                        str2 = showStatus3;
                                    }
                                    if (str2 != null) {
                                        showStatus42 = str2;
                                    } else {
                                        metaAnimeData3 = (MetaAnimeData) animeMetaData2.element;
                                        if (metaAnimeData3 != null) {
                                            str2 = showStatus3;
                                        } else {
                                            str2 = showStatus3;
                                        }
                                        if (str2 != null) {
                                            showStatus42 = str2;
                                        } else {
                                            metaAnimeData4 = (MetaAnimeData) animeMetaData2.element;
                                            if (metaAnimeData4 != null) {
                                                str2 = showStatus3;
                                            } else {
                                                str2 = showStatus3;
                                            }
                                            if (str2 == null) {
                                                showStatus42 = showStatus39;
                                            } else {
                                                showStatus42 = str2;
                                            }
                                        }
                                    }
                                } else {
                                    metaEpisode = metaEpisode;
                                    showStatus42 = str;
                                }
                            }
                            if (metaEpisode != null) {
                                overview = "No summary available";
                            } else {
                                overview = "No summary available";
                            }
                            description = overview;
                            if (metaEpisode != null) {
                                metaAnimeData5 = (MetaAnimeData) animeMetaData2.element;
                                if (metaAnimeData5 != null) {
                                    url7 = showStatus3;
                                } else {
                                    url7 = showStatus3;
                                }
                                if (url7 == null) {
                                    showStatus43 = showStatus41;
                                } else {
                                    showStatus43 = url7;
                                }
                            } else {
                                metaAnimeData5 = (MetaAnimeData) animeMetaData2.element;
                                if (metaAnimeData5 != null) {
                                    url7 = showStatus3;
                                } else {
                                    url7 = showStatus3;
                                }
                                if (url7 == null) {
                                    showStatus43 = showStatus41;
                                } else {
                                    showStatus43 = url7;
                                }
                            }
                            if (metaEpisode != null) {
                                rating = metaEpisode.getRating();
                            } else {
                                rating = showStatus3;
                            }
                            if (metaEpisode != null) {
                                runtime = metaEpisode.getRuntime();
                            } else {
                                runtime = showStatus3;
                            }
                            if (metaEpisode != null) {
                                airDateUtc = metaEpisode.getAirDateUtc();
                            } else {
                                airDateUtc = showStatus3;
                            }
                            $this$map$iv = ep.select(".nv-info-episode-badges span");
                            int $i$f$map4 = CollectionsKt.collectionSizeOrDefault($this$map$iv, 10);
                            destination$iv$iv2 = new ArrayList($i$f$map4);
                            while (r31.hasNext()) {
                                Element it7 = (Element) item$iv$iv2;
                                Iterable $this$map$iv6 = $this$map$iv;
                                String lowerCase4 = it7.text().toLowerCase(Locale.ROOT);
                                Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
                                destination$iv$iv2.add(lowerCase4);
                                $this$map$iv = $this$map$iv6;
                            }
                            badges = (List) destination$iv$iv2;
                            if (badges.contains("sub")) {
                                hasSub = true;
                            } else {
                                hasSub = true;
                            }
                            hasDub = badges.contains("dub");
                            if (hasSub) {
                                subEpisodes.add(MainAPIKt.newEpisode(this, getMainUrl() + epHref + "|sub", new Function1() { // from class: com.anineko.Anineko$$ExternalSyntheticLambda0
                                    public final Object invoke(Object obj5) {
                                        return Anineko.load$lambda$2$1(showStatus42, showStatus40, description, showStatus43, rating, runtime, airDateUtc, (Episode) obj5);
                                    }
                                }));
                            } else {
                                subEpisodes.add(MainAPIKt.newEpisode(this, getMainUrl() + epHref + "|sub", new Function1() { // from class: com.anineko.Anineko$$ExternalSyntheticLambda0
                                    public final Object invoke(Object obj5) {
                                        return Anineko.load$lambda$2$1(showStatus42, showStatus40, description, showStatus43, rating, runtime, airDateUtc, (Episode) obj5);
                                    }
                                }));
                            }
                            if (hasDub) {
                                dubEpisodes.add(MainAPIKt.newEpisode(this, getMainUrl() + epHref + "|dub", new Function1() { // from class: com.anineko.Anineko$$ExternalSyntheticLambda1
                                    public final Object invoke(Object obj5) {
                                        return Anineko.load$lambda$2$2(showStatus42, showStatus40, description, showStatus43, rating, runtime, airDateUtc, (Episode) obj5);
                                    }
                                }));
                            }
                        }
                    } else {
                        showStatus38 = showStatus26;
                        url6 = url4;
                        tvType6 = tvType3;
                        $this$forEach$iv2 = $this$forEach$iv;
                    }
                    showStatus26 = showStatus38;
                    doc2 = doc7;
                    url4 = url6;
                    tvType3 = tvType6;
                    $this$forEach$iv = $this$forEach$iv2;
                }
                Document doc8 = doc2;
                ShowStatus showStatus49 = showStatus26;
                String url9 = url4;
                TvType tvType10 = tvType3;
                metaAnimeData = (MetaAnimeData) animeMetaData2.element;
                if (metaAnimeData != null) {
                    showStatus37 = showStatus19;
                } else {
                    showStatus37 = showStatus19;
                }
                C00023 c00024 = new C00023(showStatus25, showStatus37, showStatus24, showStatus22, tags3, showStatus23, anilistId3, subEpisodes, dubEpisodes, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url9);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(doc8);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(showStatus49);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(showStatus18);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(showStatus25);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(showStatus11);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(showStatus19);
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(showStatus22);
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(tags3);
                c00012.L$9 = SpillingKt.nullOutSpilledVariable(showStatus24);
                c00012.L$10 = SpillingKt.nullOutSpilledVariable(showStatus21);
                c00012.L$11 = SpillingKt.nullOutSpilledVariable(tvType10);
                c00012.L$12 = SpillingKt.nullOutSpilledVariable(showStatus20);
                c00012.L$13 = SpillingKt.nullOutSpilledVariable(showStatus23);
                c00012.L$14 = SpillingKt.nullOutSpilledVariable(showStatus12);
                c00012.L$15 = SpillingKt.nullOutSpilledVariable(anilistId3);
                c00012.L$16 = SpillingKt.nullOutSpilledVariable(animeMetaData2);
                c00012.L$17 = SpillingKt.nullOutSpilledVariable(subEpisodes);
                c00012.L$18 = SpillingKt.nullOutSpilledVariable(dubEpisodes);
                c00012.L$19 = SpillingKt.nullOutSpilledVariable(showStatus37);
                c00012.label = 4;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, showStatus49, url9, tvType10, false, c00024, c00012, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj) {
                    return obj;
                }
                return objNewAnimeLoadResponse$default;
            case 1:
                String url10 = (String) c00012.L$0;
                ResultKt.throwOnFailure($result);
                url2 = url10;
                obj = coroutine_suspended;
                obj2 = $result;
                showStatus = null;
                doc = ((NiceResponse) obj2).getDocument();
                elementSelectFirst = doc.selectFirst("h1");
                if (elementSelectFirst != null) {
                    return showStatus;
                }
                showStatusText = elementSelectFirst.text();
                if (showStatusText == null) {
                    return showStatus;
                }
                elementSelectFirst2 = doc.selectFirst(".nv-info-alt-title");
                if (elementSelectFirst2 != null) {
                    showStatusText2 = elementSelectFirst2.text();
                } else {
                    showStatusText2 = showStatus;
                }
                elementSelectFirst3 = doc.selectFirst("aside.nv-info-poster img");
                if (elementSelectFirst3 != null) {
                    showStatusAttr = elementSelectFirst3.attr("src");
                } else {
                    showStatusAttr = showStatus;
                }
                elementSelectFirst4 = doc.selectFirst(".nv-info-bg");
                if (elementSelectFirst4 != null) {
                    showStatusAttr2 = elementSelectFirst4.attr("style");
                } else {
                    showStatusAttr2 = showStatus;
                }
                if (showStatusAttr2 != null) {
                    z = true;
                    showStatus2 = showStatus;
                } else {
                    z = true;
                    showStatus2 = showStatus;
                }
                elementSelectFirst5 = doc.selectFirst("p.nv-info-desc");
                if (elementSelectFirst5 != null) {
                    showStatusText3 = elementSelectFirst5.text();
                } else {
                    showStatusText3 = showStatus;
                }
                Iterable $this$map$iv7 = doc.select(".nv-info-tags span");
                showStatus3 = showStatus;
                showStatus4 = showStatusAttr2;
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv7, 10));
                while (r19.hasNext()) {
                    Element it8 = (Element) item$iv$iv;
                    destination$iv$iv.add(it8.text());
                }
                tags = (List) destination$iv$iv;
                elementSelectFirst6 = doc.selectFirst(".nv-info-stats div:contains(Release) strong");
                if (elementSelectFirst6 != null) {
                    intOrNull = showStatus3;
                } else {
                    intOrNull = showStatus3;
                }
                elementSelectFirst7 = doc.selectFirst(".nv-info-stats div:contains(Type) strong");
                if (elementSelectFirst7 != null) {
                    showStatusText4 = elementSelectFirst7.text();
                } else {
                    showStatusText4 = showStatus3;
                }
                if (showStatusText4 == null) {
                    z2 = false;
                } else {
                    z2 = false;
                }
                if (z2) {
                    tvType = TvType.AnimeMovie;
                } else {
                    if (showStatusText4 == null) {
                        z3 = false;
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                        tvType = TvType.OVA;
                    } else {
                        tvType = TvType.Anime;
                    }
                }
                elementSelectFirst8 = doc.selectFirst(".nv-info-stats div:contains(Status) strong");
                if (elementSelectFirst8 != null) {
                    showStatusText5 = elementSelectFirst8.text();
                } else {
                    showStatusText5 = showStatus3;
                }
                if (showStatusText5 != null) {
                    showStatus5 = showStatusText2;
                    if (StringsKt.contains((CharSequence) showStatusText5, "Currently Airing", true)) {
                    }
                    if (z4) {
                        showStatus6 = ShowStatus.Ongoing;
                    } else {
                        if (showStatusText5 == null) {
                            break;
                        }
                        if (showStatusText5 == null && StringsKt.contains((CharSequence) showStatusText5, "Completed", true)) {
                            showStatus6 = ShowStatus.Completed;
                        } else {
                            showStatus6 = showStatus3;
                        }
                    }
                    if (showStatus5 == null) {
                        showStatus7 = showStatusText;
                    } else {
                        showStatus7 = showStatus5;
                    }
                    c00012.L$0 = url2;
                    c00012.L$1 = doc;
                    c00012.L$2 = showStatusText;
                    c00012.L$3 = SpillingKt.nullOutSpilledVariable(showStatus5);
                    c00012.L$4 = showStatusAttr;
                    c00012.L$5 = SpillingKt.nullOutSpilledVariable(showStatus4);
                    c00012.L$6 = showStatus2;
                    c00012.L$7 = showStatusText3;
                    c00012.L$8 = tags;
                    c00012.L$9 = intOrNull;
                    c00012.L$10 = SpillingKt.nullOutSpilledVariable(showStatusText4);
                    c00012.L$11 = tvType;
                    c00012.L$12 = SpillingKt.nullOutSpilledVariable(showStatusText5);
                    c00012.L$13 = showStatus6;
                    c00012.L$14 = SpillingKt.nullOutSpilledVariable(showStatus7);
                    c00012.label = 2;
                    anilistId = AninekoUtilsKt.getAnilistId(showStatus7, c00012);
                    if (anilistId == obj) {
                        return obj;
                    }
                    ShowStatus showStatus410 = showStatusAttr;
                    tags2 = tags;
                    doc2 = doc;
                    showStatus8 = showStatus410;
                    TvType tvType11 = tvType;
                    showStatus9 = showStatus6;
                    showStatus10 = showStatusText3;
                    tvType2 = tvType11;
                    showStatus11 = showStatus4;
                    showStatus12 = showStatus7;
                    url3 = url2;
                    showStatus13 = showStatusText;
                    showStatus14 = intOrNull;
                    showStatus15 = showStatusText4;
                    showStatus16 = showStatus2;
                    showStatus17 = showStatusText5;
                    showStatus18 = showStatus5;
                    anilistId2 = (Integer) anilistId;
                    animeMetaData = new Ref.ObjectRef();
                    if (anilistId2 != null) {
                        String aniZipUrl3 = "https://api.ani.zip/mappings?anilist_id=" + anilistId2.intValue();
                        Requests app4 = MainActivityKt.getApp();
                        c00012.L$0 = url3;
                        c00012.L$1 = doc2;
                        c00012.L$2 = showStatus13;
                        doc3 = doc2;
                        c00012.L$3 = SpillingKt.nullOutSpilledVariable(showStatus18);
                        c00012.L$4 = showStatus8;
                        c00012.L$5 = SpillingKt.nullOutSpilledVariable(showStatus11);
                        c00012.L$6 = showStatus16;
                        c00012.L$7 = showStatus10;
                        c00012.L$8 = tags2;
                        c00012.L$9 = showStatus14;
                        c00012.L$10 = SpillingKt.nullOutSpilledVariable(showStatus15);
                        c00012.L$11 = tvType2;
                        c00012.L$12 = SpillingKt.nullOutSpilledVariable(showStatus17);
                        c00012.L$13 = showStatus9;
                        c00012.L$14 = SpillingKt.nullOutSpilledVariable(showStatus12);
                        c00012.L$15 = anilistId2;
                        c00012.L$16 = animeMetaData;
                        c00012.L$17 = SpillingKt.nullOutSpilledVariable(aniZipUrl3);
                        c00012.label = 3;
                        tags4 = tags2;
                        showStatus27 = showStatus16;
                        showStatus28 = showStatus10;
                        C00011 c00015 = c00012;
                        showStatus29 = showStatus9;
                        tvType4 = tvType2;
                        showStatus30 = showStatus8;
                        showStatus31 = showStatus13;
                        showStatus32 = showStatus14;
                        obj3 = Requests.get$default(app4, aniZipUrl3, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00015, 4094, (Object) null);
                        c00012 = c00015;
                        if (obj3 == obj) {
                            return obj;
                        }
                        showStatus33 = showStatus12;
                        showStatus20 = showStatus17;
                        showStatus21 = showStatus15;
                        showStatus34 = showStatus28;
                        showStatus35 = showStatus29;
                        tvType5 = tvType4;
                        anilistId4 = anilistId2;
                        animeMetaData3 = animeMetaData;
                        tags5 = tags4;
                        showStatus36 = showStatus27;
                        doc4 = doc3;
                        String aniZipResponse3 = ((NiceResponse) obj3).getText();
                        animeMetaData3.element = AninekoUtilsKt.parseAnimeData(aniZipResponse3);
                        Ref.ObjectRef objectRef3 = animeMetaData3;
                        url4 = url3;
                        animeMetaData2 = objectRef3;
                        tags3 = tags5;
                        showStatus19 = showStatus36;
                        showStatus22 = showStatus34;
                        anilistId3 = anilistId4;
                        showStatus12 = showStatus33;
                        showStatus23 = showStatus35;
                        tvType3 = tvType5;
                        doc2 = doc4;
                        showStatus24 = showStatus32;
                        showStatus25 = showStatus30;
                        showStatus26 = showStatus31;
                    } else {
                        ShowStatus showStatus411 = showStatus14;
                        List tags8 = tags2;
                        showStatus19 = showStatus16;
                        url4 = url3;
                        showStatus20 = showStatus17;
                        showStatus21 = showStatus15;
                        showStatus22 = showStatus10;
                        showStatus23 = showStatus9;
                        tvType3 = tvType2;
                        anilistId3 = anilistId2;
                        animeMetaData2 = animeMetaData;
                        tags3 = tags8;
                        showStatus24 = showStatus411;
                        showStatus25 = showStatus8;
                        showStatus26 = showStatus13;
                    }
                    subEpisodes = new ArrayList();
                    dubEpisodes = new ArrayList();
                    $this$forEach$iv = doc2.select(".nv-info-episode-item");
                    while (r11.hasNext()) {
                        ep = (Element) element$iv2;
                        Document doc9 = doc2;
                        elementSelectFirst9 = ep.selectFirst("a.nv-info-episode-main");
                        if (elementSelectFirst9 != null) {
                            showStatus38 = showStatus26;
                            epHref = elementSelectFirst9.attr("href");
                            if (epHref == null) {
                                url6 = url4;
                                tvType6 = tvType3;
                                $this$forEach$iv2 = $this$forEach$iv;
                            } else {
                                elementSelectFirst10 = ep.selectFirst("a.nv-info-episode-main strong");
                                if (elementSelectFirst10 != null) {
                                    showStatusText6 = elementSelectFirst10.text();
                                } else {
                                    showStatusText6 = showStatus3;
                                }
                                showStatus39 = showStatusText6;
                                if (showStatus39 != null) {
                                    url6 = url4;
                                    tvType6 = tvType3;
                                    $this$forEach$iv2 = $this$forEach$iv;
                                    strReplace = new Regex("[^0-9]").replace((CharSequence) showStatus39, "");
                                    if (strReplace != null) {
                                        intOrNull2 = StringsKt.toIntOrNull(strReplace);
                                    }
                                    showStatus40 = intOrNull2;
                                    metaAnimeData2 = (MetaAnimeData) animeMetaData2.element;
                                    if (metaAnimeData2 != null) {
                                        metaEpisode = showStatus3;
                                    } else {
                                        metaEpisode = showStatus3;
                                    }
                                    if (metaEpisode != null) {
                                        if (metaEpisode != null) {
                                            showStatus41 = "";
                                            title2 = metaEpisode.getTitle();
                                            if (title2 != null) {
                                                str = title2.get("x-jat");
                                            }
                                            if (str == null) {
                                                if (metaEpisode != null) {
                                                    str2 = showStatus3;
                                                } else {
                                                    str2 = showStatus3;
                                                }
                                                if (str2 != null) {
                                                    showStatus42 = str2;
                                                } else {
                                                    metaAnimeData3 = (MetaAnimeData) animeMetaData2.element;
                                                    if (metaAnimeData3 != null) {
                                                        str2 = showStatus3;
                                                    } else {
                                                        str2 = showStatus3;
                                                    }
                                                    if (str2 != null) {
                                                        showStatus42 = str2;
                                                    } else {
                                                        metaAnimeData4 = (MetaAnimeData) animeMetaData2.element;
                                                        if (metaAnimeData4 != null) {
                                                            str2 = showStatus3;
                                                        } else {
                                                            str2 = showStatus3;
                                                        }
                                                        if (str2 == null) {
                                                            showStatus42 = showStatus39;
                                                        } else {
                                                            showStatus42 = str2;
                                                        }
                                                    }
                                                }
                                            } else {
                                                metaEpisode = metaEpisode;
                                                showStatus42 = str;
                                            }
                                        } else {
                                            showStatus41 = "";
                                        }
                                        str = showStatus3;
                                        if (str == null) {
                                            if (metaEpisode != null) {
                                                str2 = showStatus3;
                                            } else {
                                                str2 = showStatus3;
                                            }
                                            if (str2 != null) {
                                                showStatus42 = str2;
                                            } else {
                                                metaAnimeData3 = (MetaAnimeData) animeMetaData2.element;
                                                if (metaAnimeData3 != null) {
                                                    str2 = showStatus3;
                                                } else {
                                                    str2 = showStatus3;
                                                }
                                                if (str2 != null) {
                                                    showStatus42 = str2;
                                                } else {
                                                    metaAnimeData4 = (MetaAnimeData) animeMetaData2.element;
                                                    if (metaAnimeData4 != null) {
                                                        str2 = showStatus3;
                                                    } else {
                                                        str2 = showStatus3;
                                                    }
                                                    if (str2 == null) {
                                                        showStatus42 = showStatus39;
                                                    } else {
                                                        showStatus42 = str2;
                                                    }
                                                }
                                            }
                                        } else {
                                            metaEpisode = metaEpisode;
                                            showStatus42 = str;
                                        }
                                    } else {
                                        if (metaEpisode != null) {
                                            showStatus41 = "";
                                            title2 = metaEpisode.getTitle();
                                            if (title2 != null) {
                                                str = title2.get("x-jat");
                                            }
                                            if (str == null) {
                                                if (metaEpisode != null) {
                                                    str2 = showStatus3;
                                                } else {
                                                    str2 = showStatus3;
                                                }
                                                if (str2 != null) {
                                                    showStatus42 = str2;
                                                } else {
                                                    metaAnimeData3 = (MetaAnimeData) animeMetaData2.element;
                                                    if (metaAnimeData3 != null) {
                                                        str2 = showStatus3;
                                                    } else {
                                                        str2 = showStatus3;
                                                    }
                                                    if (str2 != null) {
                                                        showStatus42 = str2;
                                                    } else {
                                                        metaAnimeData4 = (MetaAnimeData) animeMetaData2.element;
                                                        if (metaAnimeData4 != null) {
                                                            str2 = showStatus3;
                                                        } else {
                                                            str2 = showStatus3;
                                                        }
                                                        if (str2 == null) {
                                                            showStatus42 = showStatus39;
                                                        } else {
                                                            showStatus42 = str2;
                                                        }
                                                    }
                                                }
                                            } else {
                                                metaEpisode = metaEpisode;
                                                showStatus42 = str;
                                            }
                                        } else {
                                            showStatus41 = "";
                                        }
                                        str = showStatus3;
                                        if (str == null) {
                                            if (metaEpisode != null) {
                                                str2 = showStatus3;
                                            } else {
                                                str2 = showStatus3;
                                            }
                                            if (str2 != null) {
                                                showStatus42 = str2;
                                            } else {
                                                metaAnimeData3 = (MetaAnimeData) animeMetaData2.element;
                                                if (metaAnimeData3 != null) {
                                                    str2 = showStatus3;
                                                } else {
                                                    str2 = showStatus3;
                                                }
                                                if (str2 != null) {
                                                    showStatus42 = str2;
                                                } else {
                                                    metaAnimeData4 = (MetaAnimeData) animeMetaData2.element;
                                                    if (metaAnimeData4 != null) {
                                                        str2 = showStatus3;
                                                    } else {
                                                        str2 = showStatus3;
                                                    }
                                                    if (str2 == null) {
                                                        showStatus42 = showStatus39;
                                                    } else {
                                                        showStatus42 = str2;
                                                    }
                                                }
                                            }
                                        } else {
                                            metaEpisode = metaEpisode;
                                            showStatus42 = str;
                                        }
                                    }
                                    if (metaEpisode != null) {
                                        overview = "No summary available";
                                    } else {
                                        overview = "No summary available";
                                    }
                                    description = overview;
                                    if (metaEpisode != null) {
                                        metaAnimeData5 = (MetaAnimeData) animeMetaData2.element;
                                        if (metaAnimeData5 != null) {
                                            url7 = showStatus3;
                                        } else {
                                            url7 = showStatus3;
                                        }
                                        if (url7 == null) {
                                            showStatus43 = showStatus41;
                                        } else {
                                            showStatus43 = url7;
                                        }
                                    } else {
                                        metaAnimeData5 = (MetaAnimeData) animeMetaData2.element;
                                        if (metaAnimeData5 != null) {
                                            url7 = showStatus3;
                                        } else {
                                            url7 = showStatus3;
                                        }
                                        if (url7 == null) {
                                            showStatus43 = showStatus41;
                                        } else {
                                            showStatus43 = url7;
                                        }
                                    }
                                    if (metaEpisode != null) {
                                        rating = metaEpisode.getRating();
                                    } else {
                                        rating = showStatus3;
                                    }
                                    if (metaEpisode != null) {
                                        runtime = metaEpisode.getRuntime();
                                    } else {
                                        runtime = showStatus3;
                                    }
                                    if (metaEpisode != null) {
                                        airDateUtc = metaEpisode.getAirDateUtc();
                                    } else {
                                        airDateUtc = showStatus3;
                                    }
                                    $this$map$iv = ep.select(".nv-info-episode-badges span");
                                    int $i$f$map5 = CollectionsKt.collectionSizeOrDefault($this$map$iv, 10);
                                    destination$iv$iv2 = new ArrayList($i$f$map5);
                                    while (r31.hasNext()) {
                                        Element it9 = (Element) item$iv$iv2;
                                        Iterable $this$map$iv8 = $this$map$iv;
                                        String lowerCase5 = it9.text().toLowerCase(Locale.ROOT);
                                        Intrinsics.checkNotNullExpressionValue(lowerCase5, "toLowerCase(...)");
                                        destination$iv$iv2.add(lowerCase5);
                                        $this$map$iv = $this$map$iv8;
                                    }
                                    badges = (List) destination$iv$iv2;
                                    if (badges.contains("sub")) {
                                        hasSub = true;
                                    } else {
                                        hasSub = true;
                                    }
                                    hasDub = badges.contains("dub");
                                    if (hasSub) {
                                        subEpisodes.add(MainAPIKt.newEpisode(this, getMainUrl() + epHref + "|sub", new Function1() { // from class: com.anineko.Anineko$$ExternalSyntheticLambda0
                                            public final Object invoke(Object obj5) {
                                                return Anineko.load$lambda$2$1(showStatus42, showStatus40, description, showStatus43, rating, runtime, airDateUtc, (Episode) obj5);
                                            }
                                        }));
                                    } else {
                                        subEpisodes.add(MainAPIKt.newEpisode(this, getMainUrl() + epHref + "|sub", new Function1() { // from class: com.anineko.Anineko$$ExternalSyntheticLambda0
                                            public final Object invoke(Object obj5) {
                                                return Anineko.load$lambda$2$1(showStatus42, showStatus40, description, showStatus43, rating, runtime, airDateUtc, (Episode) obj5);
                                            }
                                        }));
                                    }
                                    if (hasDub) {
                                        dubEpisodes.add(MainAPIKt.newEpisode(this, getMainUrl() + epHref + "|dub", new Function1() { // from class: com.anineko.Anineko$$ExternalSyntheticLambda1
                                            public final Object invoke(Object obj5) {
                                                return Anineko.load$lambda$2$2(showStatus42, showStatus40, description, showStatus43, rating, runtime, airDateUtc, (Episode) obj5);
                                            }
                                        }));
                                    }
                                } else {
                                    url6 = url4;
                                    tvType6 = tvType3;
                                    $this$forEach$iv2 = $this$forEach$iv;
                                }
                                intOrNull2 = showStatus3;
                                showStatus40 = intOrNull2;
                                metaAnimeData2 = (MetaAnimeData) animeMetaData2.element;
                                if (metaAnimeData2 != null) {
                                    metaEpisode = showStatus3;
                                } else {
                                    metaEpisode = showStatus3;
                                }
                                if (metaEpisode != null) {
                                    if (metaEpisode != null) {
                                        showStatus41 = "";
                                        title2 = metaEpisode.getTitle();
                                        if (title2 != null) {
                                            str = title2.get("x-jat");
                                        }
                                        if (str == null) {
                                            if (metaEpisode != null) {
                                                str2 = showStatus3;
                                            } else {
                                                str2 = showStatus3;
                                            }
                                            if (str2 != null) {
                                                showStatus42 = str2;
                                            } else {
                                                metaAnimeData3 = (MetaAnimeData) animeMetaData2.element;
                                                if (metaAnimeData3 != null) {
                                                    str2 = showStatus3;
                                                } else {
                                                    str2 = showStatus3;
                                                }
                                                if (str2 != null) {
                                                    showStatus42 = str2;
                                                } else {
                                                    metaAnimeData4 = (MetaAnimeData) animeMetaData2.element;
                                                    if (metaAnimeData4 != null) {
                                                        str2 = showStatus3;
                                                    } else {
                                                        str2 = showStatus3;
                                                    }
                                                    if (str2 == null) {
                                                        showStatus42 = showStatus39;
                                                    } else {
                                                        showStatus42 = str2;
                                                    }
                                                }
                                            }
                                        } else {
                                            metaEpisode = metaEpisode;
                                            showStatus42 = str;
                                        }
                                    } else {
                                        showStatus41 = "";
                                    }
                                    str = showStatus3;
                                    if (str == null) {
                                        if (metaEpisode != null) {
                                            str2 = showStatus3;
                                        } else {
                                            str2 = showStatus3;
                                        }
                                        if (str2 != null) {
                                            showStatus42 = str2;
                                        } else {
                                            metaAnimeData3 = (MetaAnimeData) animeMetaData2.element;
                                            if (metaAnimeData3 != null) {
                                                str2 = showStatus3;
                                            } else {
                                                str2 = showStatus3;
                                            }
                                            if (str2 != null) {
                                                showStatus42 = str2;
                                            } else {
                                                metaAnimeData4 = (MetaAnimeData) animeMetaData2.element;
                                                if (metaAnimeData4 != null) {
                                                    str2 = showStatus3;
                                                } else {
                                                    str2 = showStatus3;
                                                }
                                                if (str2 == null) {
                                                    showStatus42 = showStatus39;
                                                } else {
                                                    showStatus42 = str2;
                                                }
                                            }
                                        }
                                    } else {
                                        metaEpisode = metaEpisode;
                                        showStatus42 = str;
                                    }
                                } else {
                                    if (metaEpisode != null) {
                                        showStatus41 = "";
                                        title2 = metaEpisode.getTitle();
                                        if (title2 != null) {
                                            str = title2.get("x-jat");
                                        }
                                        if (str == null) {
                                            if (metaEpisode != null) {
                                                str2 = showStatus3;
                                            } else {
                                                str2 = showStatus3;
                                            }
                                            if (str2 != null) {
                                                showStatus42 = str2;
                                            } else {
                                                metaAnimeData3 = (MetaAnimeData) animeMetaData2.element;
                                                if (metaAnimeData3 != null) {
                                                    str2 = showStatus3;
                                                } else {
                                                    str2 = showStatus3;
                                                }
                                                if (str2 != null) {
                                                    showStatus42 = str2;
                                                } else {
                                                    metaAnimeData4 = (MetaAnimeData) animeMetaData2.element;
                                                    if (metaAnimeData4 != null) {
                                                        str2 = showStatus3;
                                                    } else {
                                                        str2 = showStatus3;
                                                    }
                                                    if (str2 == null) {
                                                        showStatus42 = showStatus39;
                                                    } else {
                                                        showStatus42 = str2;
                                                    }
                                                }
                                            }
                                        } else {
                                            metaEpisode = metaEpisode;
                                            showStatus42 = str;
                                        }
                                    } else {
                                        showStatus41 = "";
                                    }
                                    str = showStatus3;
                                    if (str == null) {
                                        if (metaEpisode != null) {
                                            str2 = showStatus3;
                                        } else {
                                            str2 = showStatus3;
                                        }
                                        if (str2 != null) {
                                            showStatus42 = str2;
                                        } else {
                                            metaAnimeData3 = (MetaAnimeData) animeMetaData2.element;
                                            if (metaAnimeData3 != null) {
                                                str2 = showStatus3;
                                            } else {
                                                str2 = showStatus3;
                                            }
                                            if (str2 != null) {
                                                showStatus42 = str2;
                                            } else {
                                                metaAnimeData4 = (MetaAnimeData) animeMetaData2.element;
                                                if (metaAnimeData4 != null) {
                                                    str2 = showStatus3;
                                                } else {
                                                    str2 = showStatus3;
                                                }
                                                if (str2 == null) {
                                                    showStatus42 = showStatus39;
                                                } else {
                                                    showStatus42 = str2;
                                                }
                                            }
                                        }
                                    } else {
                                        metaEpisode = metaEpisode;
                                        showStatus42 = str;
                                    }
                                }
                                if (metaEpisode != null) {
                                    overview = "No summary available";
                                } else {
                                    overview = "No summary available";
                                }
                                description = overview;
                                if (metaEpisode != null) {
                                    metaAnimeData5 = (MetaAnimeData) animeMetaData2.element;
                                    if (metaAnimeData5 != null) {
                                        url7 = showStatus3;
                                    } else {
                                        url7 = showStatus3;
                                    }
                                    if (url7 == null) {
                                        showStatus43 = showStatus41;
                                    } else {
                                        showStatus43 = url7;
                                    }
                                } else {
                                    metaAnimeData5 = (MetaAnimeData) animeMetaData2.element;
                                    if (metaAnimeData5 != null) {
                                        url7 = showStatus3;
                                    } else {
                                        url7 = showStatus3;
                                    }
                                    if (url7 == null) {
                                        showStatus43 = showStatus41;
                                    } else {
                                        showStatus43 = url7;
                                    }
                                }
                                if (metaEpisode != null) {
                                    rating = metaEpisode.getRating();
                                } else {
                                    rating = showStatus3;
                                }
                                if (metaEpisode != null) {
                                    runtime = metaEpisode.getRuntime();
                                } else {
                                    runtime = showStatus3;
                                }
                                if (metaEpisode != null) {
                                    airDateUtc = metaEpisode.getAirDateUtc();
                                } else {
                                    airDateUtc = showStatus3;
                                }
                                $this$map$iv = ep.select(".nv-info-episode-badges span");
                                int $i$f$map6 = CollectionsKt.collectionSizeOrDefault($this$map$iv, 10);
                                destination$iv$iv2 = new ArrayList($i$f$map6);
                                while (r31.hasNext()) {
                                    Element it10 = (Element) item$iv$iv2;
                                    Iterable $this$map$iv9 = $this$map$iv;
                                    String lowerCase6 = it10.text().toLowerCase(Locale.ROOT);
                                    Intrinsics.checkNotNullExpressionValue(lowerCase6, "toLowerCase(...)");
                                    destination$iv$iv2.add(lowerCase6);
                                    $this$map$iv = $this$map$iv9;
                                }
                                badges = (List) destination$iv$iv2;
                                if (badges.contains("sub")) {
                                    hasSub = true;
                                } else {
                                    hasSub = true;
                                }
                                hasDub = badges.contains("dub");
                                if (hasSub) {
                                    subEpisodes.add(MainAPIKt.newEpisode(this, getMainUrl() + epHref + "|sub", new Function1() { // from class: com.anineko.Anineko$$ExternalSyntheticLambda0
                                        public final Object invoke(Object obj5) {
                                            return Anineko.load$lambda$2$1(showStatus42, showStatus40, description, showStatus43, rating, runtime, airDateUtc, (Episode) obj5);
                                        }
                                    }));
                                } else {
                                    subEpisodes.add(MainAPIKt.newEpisode(this, getMainUrl() + epHref + "|sub", new Function1() { // from class: com.anineko.Anineko$$ExternalSyntheticLambda0
                                        public final Object invoke(Object obj5) {
                                            return Anineko.load$lambda$2$1(showStatus42, showStatus40, description, showStatus43, rating, runtime, airDateUtc, (Episode) obj5);
                                        }
                                    }));
                                }
                                if (hasDub) {
                                    dubEpisodes.add(MainAPIKt.newEpisode(this, getMainUrl() + epHref + "|dub", new Function1() { // from class: com.anineko.Anineko$$ExternalSyntheticLambda1
                                        public final Object invoke(Object obj5) {
                                            return Anineko.load$lambda$2$2(showStatus42, showStatus40, description, showStatus43, rating, runtime, airDateUtc, (Episode) obj5);
                                        }
                                    }));
                                }
                            }
                        } else {
                            showStatus38 = showStatus26;
                            url6 = url4;
                            tvType6 = tvType3;
                            $this$forEach$iv2 = $this$forEach$iv;
                        }
                        showStatus26 = showStatus38;
                        doc2 = doc9;
                        url4 = url6;
                        tvType3 = tvType6;
                        $this$forEach$iv = $this$forEach$iv2;
                    }
                    Document doc10 = doc2;
                    ShowStatus showStatus412 = showStatus26;
                    String url11 = url4;
                    TvType tvType12 = tvType3;
                    metaAnimeData = (MetaAnimeData) animeMetaData2.element;
                    if (metaAnimeData != null) {
                        showStatus37 = showStatus19;
                    } else {
                        showStatus37 = showStatus19;
                    }
                    C00023 c00025 = new C00023(showStatus25, showStatus37, showStatus24, showStatus22, tags3, showStatus23, anilistId3, subEpisodes, dubEpisodes, null);
                    c00012.L$0 = SpillingKt.nullOutSpilledVariable(url11);
                    c00012.L$1 = SpillingKt.nullOutSpilledVariable(doc10);
                    c00012.L$2 = SpillingKt.nullOutSpilledVariable(showStatus412);
                    c00012.L$3 = SpillingKt.nullOutSpilledVariable(showStatus18);
                    c00012.L$4 = SpillingKt.nullOutSpilledVariable(showStatus25);
                    c00012.L$5 = SpillingKt.nullOutSpilledVariable(showStatus11);
                    c00012.L$6 = SpillingKt.nullOutSpilledVariable(showStatus19);
                    c00012.L$7 = SpillingKt.nullOutSpilledVariable(showStatus22);
                    c00012.L$8 = SpillingKt.nullOutSpilledVariable(tags3);
                    c00012.L$9 = SpillingKt.nullOutSpilledVariable(showStatus24);
                    c00012.L$10 = SpillingKt.nullOutSpilledVariable(showStatus21);
                    c00012.L$11 = SpillingKt.nullOutSpilledVariable(tvType12);
                    c00012.L$12 = SpillingKt.nullOutSpilledVariable(showStatus20);
                    c00012.L$13 = SpillingKt.nullOutSpilledVariable(showStatus23);
                    c00012.L$14 = SpillingKt.nullOutSpilledVariable(showStatus12);
                    c00012.L$15 = SpillingKt.nullOutSpilledVariable(anilistId3);
                    c00012.L$16 = SpillingKt.nullOutSpilledVariable(animeMetaData2);
                    c00012.L$17 = SpillingKt.nullOutSpilledVariable(subEpisodes);
                    c00012.L$18 = SpillingKt.nullOutSpilledVariable(dubEpisodes);
                    c00012.L$19 = SpillingKt.nullOutSpilledVariable(showStatus37);
                    c00012.label = 4;
                    objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, showStatus412, url11, tvType12, false, c00025, c00012, 8, (Object) null);
                    if (objNewAnimeLoadResponse$default == obj) {
                        return obj;
                    }
                    return objNewAnimeLoadResponse$default;
                }
                showStatus5 = showStatusText2;
                if (z4) {
                    showStatus6 = ShowStatus.Ongoing;
                } else {
                    if (showStatusText5 == null) {
                        break;
                    }
                    if (showStatusText5 == null && StringsKt.contains((CharSequence) showStatusText5, "Completed", true)) {
                        showStatus6 = ShowStatus.Completed;
                    } else {
                        showStatus6 = showStatus3;
                    }
                }
                if (showStatus5 == null) {
                    showStatus7 = showStatusText;
                } else {
                    showStatus7 = showStatus5;
                }
                c00012.L$0 = url2;
                c00012.L$1 = doc;
                c00012.L$2 = showStatusText;
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(showStatus5);
                c00012.L$4 = showStatusAttr;
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(showStatus4);
                c00012.L$6 = showStatus2;
                c00012.L$7 = showStatusText3;
                c00012.L$8 = tags;
                c00012.L$9 = intOrNull;
                c00012.L$10 = SpillingKt.nullOutSpilledVariable(showStatusText4);
                c00012.L$11 = tvType;
                c00012.L$12 = SpillingKt.nullOutSpilledVariable(showStatusText5);
                c00012.L$13 = showStatus6;
                c00012.L$14 = SpillingKt.nullOutSpilledVariable(showStatus7);
                c00012.label = 2;
                anilistId = AninekoUtilsKt.getAnilistId(showStatus7, c00012);
                if (anilistId == obj) {
                    return obj;
                }
                ShowStatus showStatus413 = showStatusAttr;
                tags2 = tags;
                doc2 = doc;
                showStatus8 = showStatus413;
                TvType tvType13 = tvType;
                showStatus9 = showStatus6;
                showStatus10 = showStatusText3;
                tvType2 = tvType13;
                showStatus11 = showStatus4;
                showStatus12 = showStatus7;
                url3 = url2;
                showStatus13 = showStatusText;
                showStatus14 = intOrNull;
                showStatus15 = showStatusText4;
                showStatus16 = showStatus2;
                showStatus17 = showStatusText5;
                showStatus18 = showStatus5;
                anilistId2 = (Integer) anilistId;
                animeMetaData = new Ref.ObjectRef();
                if (anilistId2 != null) {
                    String aniZipUrl4 = "https://api.ani.zip/mappings?anilist_id=" + anilistId2.intValue();
                    Requests app5 = MainActivityKt.getApp();
                    c00012.L$0 = url3;
                    c00012.L$1 = doc2;
                    c00012.L$2 = showStatus13;
                    doc3 = doc2;
                    c00012.L$3 = SpillingKt.nullOutSpilledVariable(showStatus18);
                    c00012.L$4 = showStatus8;
                    c00012.L$5 = SpillingKt.nullOutSpilledVariable(showStatus11);
                    c00012.L$6 = showStatus16;
                    c00012.L$7 = showStatus10;
                    c00012.L$8 = tags2;
                    c00012.L$9 = showStatus14;
                    c00012.L$10 = SpillingKt.nullOutSpilledVariable(showStatus15);
                    c00012.L$11 = tvType2;
                    c00012.L$12 = SpillingKt.nullOutSpilledVariable(showStatus17);
                    c00012.L$13 = showStatus9;
                    c00012.L$14 = SpillingKt.nullOutSpilledVariable(showStatus12);
                    c00012.L$15 = anilistId2;
                    c00012.L$16 = animeMetaData;
                    c00012.L$17 = SpillingKt.nullOutSpilledVariable(aniZipUrl4);
                    c00012.label = 3;
                    tags4 = tags2;
                    showStatus27 = showStatus16;
                    showStatus28 = showStatus10;
                    C00011 c00016 = c00012;
                    showStatus29 = showStatus9;
                    tvType4 = tvType2;
                    showStatus30 = showStatus8;
                    showStatus31 = showStatus13;
                    showStatus32 = showStatus14;
                    obj3 = Requests.get$default(app5, aniZipUrl4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00016, 4094, (Object) null);
                    c00012 = c00016;
                    if (obj3 == obj) {
                        return obj;
                    }
                    showStatus33 = showStatus12;
                    showStatus20 = showStatus17;
                    showStatus21 = showStatus15;
                    showStatus34 = showStatus28;
                    showStatus35 = showStatus29;
                    tvType5 = tvType4;
                    anilistId4 = anilistId2;
                    animeMetaData3 = animeMetaData;
                    tags5 = tags4;
                    showStatus36 = showStatus27;
                    doc4 = doc3;
                    String aniZipResponse4 = ((NiceResponse) obj3).getText();
                    animeMetaData3.element = AninekoUtilsKt.parseAnimeData(aniZipResponse4);
                    Ref.ObjectRef objectRef4 = animeMetaData3;
                    url4 = url3;
                    animeMetaData2 = objectRef4;
                    tags3 = tags5;
                    showStatus19 = showStatus36;
                    showStatus22 = showStatus34;
                    anilistId3 = anilistId4;
                    showStatus12 = showStatus33;
                    showStatus23 = showStatus35;
                    tvType3 = tvType5;
                    doc2 = doc4;
                    showStatus24 = showStatus32;
                    showStatus25 = showStatus30;
                    showStatus26 = showStatus31;
                } else {
                    ShowStatus showStatus414 = showStatus14;
                    List tags9 = tags2;
                    showStatus19 = showStatus16;
                    url4 = url3;
                    showStatus20 = showStatus17;
                    showStatus21 = showStatus15;
                    showStatus22 = showStatus10;
                    showStatus23 = showStatus9;
                    tvType3 = tvType2;
                    anilistId3 = anilistId2;
                    animeMetaData2 = animeMetaData;
                    tags3 = tags9;
                    showStatus24 = showStatus414;
                    showStatus25 = showStatus8;
                    showStatus26 = showStatus13;
                }
                subEpisodes = new ArrayList();
                dubEpisodes = new ArrayList();
                $this$forEach$iv = doc2.select(".nv-info-episode-item");
                while (r11.hasNext()) {
                    ep = (Element) element$iv2;
                    Document doc11 = doc2;
                    elementSelectFirst9 = ep.selectFirst("a.nv-info-episode-main");
                    if (elementSelectFirst9 != null) {
                        showStatus38 = showStatus26;
                        epHref = elementSelectFirst9.attr("href");
                        if (epHref == null) {
                            url6 = url4;
                            tvType6 = tvType3;
                            $this$forEach$iv2 = $this$forEach$iv;
                        } else {
                            elementSelectFirst10 = ep.selectFirst("a.nv-info-episode-main strong");
                            if (elementSelectFirst10 != null) {
                                showStatusText6 = elementSelectFirst10.text();
                            } else {
                                showStatusText6 = showStatus3;
                            }
                            showStatus39 = showStatusText6;
                            if (showStatus39 != null) {
                                url6 = url4;
                                tvType6 = tvType3;
                                $this$forEach$iv2 = $this$forEach$iv;
                                strReplace = new Regex("[^0-9]").replace((CharSequence) showStatus39, "");
                                if (strReplace != null) {
                                    intOrNull2 = StringsKt.toIntOrNull(strReplace);
                                }
                                showStatus40 = intOrNull2;
                                metaAnimeData2 = (MetaAnimeData) animeMetaData2.element;
                                if (metaAnimeData2 != null) {
                                    metaEpisode = showStatus3;
                                } else {
                                    metaEpisode = showStatus3;
                                }
                                if (metaEpisode != null) {
                                    if (metaEpisode != null) {
                                        showStatus41 = "";
                                        title2 = metaEpisode.getTitle();
                                        if (title2 != null) {
                                            str = title2.get("x-jat");
                                        }
                                        if (str == null) {
                                            if (metaEpisode != null) {
                                                str2 = showStatus3;
                                            } else {
                                                str2 = showStatus3;
                                            }
                                            if (str2 != null) {
                                                showStatus42 = str2;
                                            } else {
                                                metaAnimeData3 = (MetaAnimeData) animeMetaData2.element;
                                                if (metaAnimeData3 != null) {
                                                    str2 = showStatus3;
                                                } else {
                                                    str2 = showStatus3;
                                                }
                                                if (str2 != null) {
                                                    showStatus42 = str2;
                                                } else {
                                                    metaAnimeData4 = (MetaAnimeData) animeMetaData2.element;
                                                    if (metaAnimeData4 != null) {
                                                        str2 = showStatus3;
                                                    } else {
                                                        str2 = showStatus3;
                                                    }
                                                    if (str2 == null) {
                                                        showStatus42 = showStatus39;
                                                    } else {
                                                        showStatus42 = str2;
                                                    }
                                                }
                                            }
                                        } else {
                                            metaEpisode = metaEpisode;
                                            showStatus42 = str;
                                        }
                                    } else {
                                        showStatus41 = "";
                                    }
                                    str = showStatus3;
                                    if (str == null) {
                                        if (metaEpisode != null) {
                                            str2 = showStatus3;
                                        } else {
                                            str2 = showStatus3;
                                        }
                                        if (str2 != null) {
                                            showStatus42 = str2;
                                        } else {
                                            metaAnimeData3 = (MetaAnimeData) animeMetaData2.element;
                                            if (metaAnimeData3 != null) {
                                                str2 = showStatus3;
                                            } else {
                                                str2 = showStatus3;
                                            }
                                            if (str2 != null) {
                                                showStatus42 = str2;
                                            } else {
                                                metaAnimeData4 = (MetaAnimeData) animeMetaData2.element;
                                                if (metaAnimeData4 != null) {
                                                    str2 = showStatus3;
                                                } else {
                                                    str2 = showStatus3;
                                                }
                                                if (str2 == null) {
                                                    showStatus42 = showStatus39;
                                                } else {
                                                    showStatus42 = str2;
                                                }
                                            }
                                        }
                                    } else {
                                        metaEpisode = metaEpisode;
                                        showStatus42 = str;
                                    }
                                } else {
                                    if (metaEpisode != null) {
                                        showStatus41 = "";
                                        title2 = metaEpisode.getTitle();
                                        if (title2 != null) {
                                            str = title2.get("x-jat");
                                        }
                                        if (str == null) {
                                            if (metaEpisode != null) {
                                                str2 = showStatus3;
                                            } else {
                                                str2 = showStatus3;
                                            }
                                            if (str2 != null) {
                                                showStatus42 = str2;
                                            } else {
                                                metaAnimeData3 = (MetaAnimeData) animeMetaData2.element;
                                                if (metaAnimeData3 != null) {
                                                    str2 = showStatus3;
                                                } else {
                                                    str2 = showStatus3;
                                                }
                                                if (str2 != null) {
                                                    showStatus42 = str2;
                                                } else {
                                                    metaAnimeData4 = (MetaAnimeData) animeMetaData2.element;
                                                    if (metaAnimeData4 != null) {
                                                        str2 = showStatus3;
                                                    } else {
                                                        str2 = showStatus3;
                                                    }
                                                    if (str2 == null) {
                                                        showStatus42 = showStatus39;
                                                    } else {
                                                        showStatus42 = str2;
                                                    }
                                                }
                                            }
                                        } else {
                                            metaEpisode = metaEpisode;
                                            showStatus42 = str;
                                        }
                                    } else {
                                        showStatus41 = "";
                                    }
                                    str = showStatus3;
                                    if (str == null) {
                                        if (metaEpisode != null) {
                                            str2 = showStatus3;
                                        } else {
                                            str2 = showStatus3;
                                        }
                                        if (str2 != null) {
                                            showStatus42 = str2;
                                        } else {
                                            metaAnimeData3 = (MetaAnimeData) animeMetaData2.element;
                                            if (metaAnimeData3 != null) {
                                                str2 = showStatus3;
                                            } else {
                                                str2 = showStatus3;
                                            }
                                            if (str2 != null) {
                                                showStatus42 = str2;
                                            } else {
                                                metaAnimeData4 = (MetaAnimeData) animeMetaData2.element;
                                                if (metaAnimeData4 != null) {
                                                    str2 = showStatus3;
                                                } else {
                                                    str2 = showStatus3;
                                                }
                                                if (str2 == null) {
                                                    showStatus42 = showStatus39;
                                                } else {
                                                    showStatus42 = str2;
                                                }
                                            }
                                        }
                                    } else {
                                        metaEpisode = metaEpisode;
                                        showStatus42 = str;
                                    }
                                }
                                if (metaEpisode != null) {
                                    overview = "No summary available";
                                } else {
                                    overview = "No summary available";
                                }
                                description = overview;
                                if (metaEpisode != null) {
                                    metaAnimeData5 = (MetaAnimeData) animeMetaData2.element;
                                    if (metaAnimeData5 != null) {
                                        url7 = showStatus3;
                                    } else {
                                        url7 = showStatus3;
                                    }
                                    if (url7 == null) {
                                        showStatus43 = showStatus41;
                                    } else {
                                        showStatus43 = url7;
                                    }
                                } else {
                                    metaAnimeData5 = (MetaAnimeData) animeMetaData2.element;
                                    if (metaAnimeData5 != null) {
                                        url7 = showStatus3;
                                    } else {
                                        url7 = showStatus3;
                                    }
                                    if (url7 == null) {
                                        showStatus43 = showStatus41;
                                    } else {
                                        showStatus43 = url7;
                                    }
                                }
                                if (metaEpisode != null) {
                                    rating = metaEpisode.getRating();
                                } else {
                                    rating = showStatus3;
                                }
                                if (metaEpisode != null) {
                                    runtime = metaEpisode.getRuntime();
                                } else {
                                    runtime = showStatus3;
                                }
                                if (metaEpisode != null) {
                                    airDateUtc = metaEpisode.getAirDateUtc();
                                } else {
                                    airDateUtc = showStatus3;
                                }
                                $this$map$iv = ep.select(".nv-info-episode-badges span");
                                int $i$f$map7 = CollectionsKt.collectionSizeOrDefault($this$map$iv, 10);
                                destination$iv$iv2 = new ArrayList($i$f$map7);
                                while (r31.hasNext()) {
                                    Element it11 = (Element) item$iv$iv2;
                                    Iterable $this$map$iv10 = $this$map$iv;
                                    String lowerCase7 = it11.text().toLowerCase(Locale.ROOT);
                                    Intrinsics.checkNotNullExpressionValue(lowerCase7, "toLowerCase(...)");
                                    destination$iv$iv2.add(lowerCase7);
                                    $this$map$iv = $this$map$iv10;
                                }
                                badges = (List) destination$iv$iv2;
                                if (badges.contains("sub")) {
                                    hasSub = true;
                                } else {
                                    hasSub = true;
                                }
                                hasDub = badges.contains("dub");
                                if (hasSub) {
                                    subEpisodes.add(MainAPIKt.newEpisode(this, getMainUrl() + epHref + "|sub", new Function1() { // from class: com.anineko.Anineko$$ExternalSyntheticLambda0
                                        public final Object invoke(Object obj5) {
                                            return Anineko.load$lambda$2$1(showStatus42, showStatus40, description, showStatus43, rating, runtime, airDateUtc, (Episode) obj5);
                                        }
                                    }));
                                } else {
                                    subEpisodes.add(MainAPIKt.newEpisode(this, getMainUrl() + epHref + "|sub", new Function1() { // from class: com.anineko.Anineko$$ExternalSyntheticLambda0
                                        public final Object invoke(Object obj5) {
                                            return Anineko.load$lambda$2$1(showStatus42, showStatus40, description, showStatus43, rating, runtime, airDateUtc, (Episode) obj5);
                                        }
                                    }));
                                }
                                if (hasDub) {
                                    dubEpisodes.add(MainAPIKt.newEpisode(this, getMainUrl() + epHref + "|dub", new Function1() { // from class: com.anineko.Anineko$$ExternalSyntheticLambda1
                                        public final Object invoke(Object obj5) {
                                            return Anineko.load$lambda$2$2(showStatus42, showStatus40, description, showStatus43, rating, runtime, airDateUtc, (Episode) obj5);
                                        }
                                    }));
                                }
                            } else {
                                url6 = url4;
                                tvType6 = tvType3;
                                $this$forEach$iv2 = $this$forEach$iv;
                            }
                            intOrNull2 = showStatus3;
                            showStatus40 = intOrNull2;
                            metaAnimeData2 = (MetaAnimeData) animeMetaData2.element;
                            if (metaAnimeData2 != null) {
                                metaEpisode = showStatus3;
                            } else {
                                metaEpisode = showStatus3;
                            }
                            if (metaEpisode != null) {
                                if (metaEpisode != null) {
                                    showStatus41 = "";
                                    title2 = metaEpisode.getTitle();
                                    if (title2 != null) {
                                        str = title2.get("x-jat");
                                    }
                                    if (str == null) {
                                        if (metaEpisode != null) {
                                            str2 = showStatus3;
                                        } else {
                                            str2 = showStatus3;
                                        }
                                        if (str2 != null) {
                                            showStatus42 = str2;
                                        } else {
                                            metaAnimeData3 = (MetaAnimeData) animeMetaData2.element;
                                            if (metaAnimeData3 != null) {
                                                str2 = showStatus3;
                                            } else {
                                                str2 = showStatus3;
                                            }
                                            if (str2 != null) {
                                                showStatus42 = str2;
                                            } else {
                                                metaAnimeData4 = (MetaAnimeData) animeMetaData2.element;
                                                if (metaAnimeData4 != null) {
                                                    str2 = showStatus3;
                                                } else {
                                                    str2 = showStatus3;
                                                }
                                                if (str2 == null) {
                                                    showStatus42 = showStatus39;
                                                } else {
                                                    showStatus42 = str2;
                                                }
                                            }
                                        }
                                    } else {
                                        metaEpisode = metaEpisode;
                                        showStatus42 = str;
                                    }
                                } else {
                                    showStatus41 = "";
                                }
                                str = showStatus3;
                                if (str == null) {
                                    if (metaEpisode != null) {
                                        str2 = showStatus3;
                                    } else {
                                        str2 = showStatus3;
                                    }
                                    if (str2 != null) {
                                        showStatus42 = str2;
                                    } else {
                                        metaAnimeData3 = (MetaAnimeData) animeMetaData2.element;
                                        if (metaAnimeData3 != null) {
                                            str2 = showStatus3;
                                        } else {
                                            str2 = showStatus3;
                                        }
                                        if (str2 != null) {
                                            showStatus42 = str2;
                                        } else {
                                            metaAnimeData4 = (MetaAnimeData) animeMetaData2.element;
                                            if (metaAnimeData4 != null) {
                                                str2 = showStatus3;
                                            } else {
                                                str2 = showStatus3;
                                            }
                                            if (str2 == null) {
                                                showStatus42 = showStatus39;
                                            } else {
                                                showStatus42 = str2;
                                            }
                                        }
                                    }
                                } else {
                                    metaEpisode = metaEpisode;
                                    showStatus42 = str;
                                }
                            } else {
                                if (metaEpisode != null) {
                                    showStatus41 = "";
                                    title2 = metaEpisode.getTitle();
                                    if (title2 != null) {
                                        str = title2.get("x-jat");
                                    }
                                    if (str == null) {
                                        if (metaEpisode != null) {
                                            str2 = showStatus3;
                                        } else {
                                            str2 = showStatus3;
                                        }
                                        if (str2 != null) {
                                            showStatus42 = str2;
                                        } else {
                                            metaAnimeData3 = (MetaAnimeData) animeMetaData2.element;
                                            if (metaAnimeData3 != null) {
                                                str2 = showStatus3;
                                            } else {
                                                str2 = showStatus3;
                                            }
                                            if (str2 != null) {
                                                showStatus42 = str2;
                                            } else {
                                                metaAnimeData4 = (MetaAnimeData) animeMetaData2.element;
                                                if (metaAnimeData4 != null) {
                                                    str2 = showStatus3;
                                                } else {
                                                    str2 = showStatus3;
                                                }
                                                if (str2 == null) {
                                                    showStatus42 = showStatus39;
                                                } else {
                                                    showStatus42 = str2;
                                                }
                                            }
                                        }
                                    } else {
                                        metaEpisode = metaEpisode;
                                        showStatus42 = str;
                                    }
                                } else {
                                    showStatus41 = "";
                                }
                                str = showStatus3;
                                if (str == null) {
                                    if (metaEpisode != null) {
                                        str2 = showStatus3;
                                    } else {
                                        str2 = showStatus3;
                                    }
                                    if (str2 != null) {
                                        showStatus42 = str2;
                                    } else {
                                        metaAnimeData3 = (MetaAnimeData) animeMetaData2.element;
                                        if (metaAnimeData3 != null) {
                                            str2 = showStatus3;
                                        } else {
                                            str2 = showStatus3;
                                        }
                                        if (str2 != null) {
                                            showStatus42 = str2;
                                        } else {
                                            metaAnimeData4 = (MetaAnimeData) animeMetaData2.element;
                                            if (metaAnimeData4 != null) {
                                                str2 = showStatus3;
                                            } else {
                                                str2 = showStatus3;
                                            }
                                            if (str2 == null) {
                                                showStatus42 = showStatus39;
                                            } else {
                                                showStatus42 = str2;
                                            }
                                        }
                                    }
                                } else {
                                    metaEpisode = metaEpisode;
                                    showStatus42 = str;
                                }
                            }
                            if (metaEpisode != null) {
                                overview = "No summary available";
                            } else {
                                overview = "No summary available";
                            }
                            description = overview;
                            if (metaEpisode != null) {
                                metaAnimeData5 = (MetaAnimeData) animeMetaData2.element;
                                if (metaAnimeData5 != null) {
                                    url7 = showStatus3;
                                } else {
                                    url7 = showStatus3;
                                }
                                if (url7 == null) {
                                    showStatus43 = showStatus41;
                                } else {
                                    showStatus43 = url7;
                                }
                            } else {
                                metaAnimeData5 = (MetaAnimeData) animeMetaData2.element;
                                if (metaAnimeData5 != null) {
                                    url7 = showStatus3;
                                } else {
                                    url7 = showStatus3;
                                }
                                if (url7 == null) {
                                    showStatus43 = showStatus41;
                                } else {
                                    showStatus43 = url7;
                                }
                            }
                            if (metaEpisode != null) {
                                rating = metaEpisode.getRating();
                            } else {
                                rating = showStatus3;
                            }
                            if (metaEpisode != null) {
                                runtime = metaEpisode.getRuntime();
                            } else {
                                runtime = showStatus3;
                            }
                            if (metaEpisode != null) {
                                airDateUtc = metaEpisode.getAirDateUtc();
                            } else {
                                airDateUtc = showStatus3;
                            }
                            $this$map$iv = ep.select(".nv-info-episode-badges span");
                            int $i$f$map8 = CollectionsKt.collectionSizeOrDefault($this$map$iv, 10);
                            destination$iv$iv2 = new ArrayList($i$f$map8);
                            while (r31.hasNext()) {
                                Element it12 = (Element) item$iv$iv2;
                                Iterable $this$map$iv11 = $this$map$iv;
                                String lowerCase8 = it12.text().toLowerCase(Locale.ROOT);
                                Intrinsics.checkNotNullExpressionValue(lowerCase8, "toLowerCase(...)");
                                destination$iv$iv2.add(lowerCase8);
                                $this$map$iv = $this$map$iv11;
                            }
                            badges = (List) destination$iv$iv2;
                            if (badges.contains("sub")) {
                                hasSub = true;
                            } else {
                                hasSub = true;
                            }
                            hasDub = badges.contains("dub");
                            if (hasSub) {
                                subEpisodes.add(MainAPIKt.newEpisode(this, getMainUrl() + epHref + "|sub", new Function1() { // from class: com.anineko.Anineko$$ExternalSyntheticLambda0
                                    public final Object invoke(Object obj5) {
                                        return Anineko.load$lambda$2$1(showStatus42, showStatus40, description, showStatus43, rating, runtime, airDateUtc, (Episode) obj5);
                                    }
                                }));
                            } else {
                                subEpisodes.add(MainAPIKt.newEpisode(this, getMainUrl() + epHref + "|sub", new Function1() { // from class: com.anineko.Anineko$$ExternalSyntheticLambda0
                                    public final Object invoke(Object obj5) {
                                        return Anineko.load$lambda$2$1(showStatus42, showStatus40, description, showStatus43, rating, runtime, airDateUtc, (Episode) obj5);
                                    }
                                }));
                            }
                            if (hasDub) {
                                dubEpisodes.add(MainAPIKt.newEpisode(this, getMainUrl() + epHref + "|dub", new Function1() { // from class: com.anineko.Anineko$$ExternalSyntheticLambda1
                                    public final Object invoke(Object obj5) {
                                        return Anineko.load$lambda$2$2(showStatus42, showStatus40, description, showStatus43, rating, runtime, airDateUtc, (Episode) obj5);
                                    }
                                }));
                            }
                        }
                    } else {
                        showStatus38 = showStatus26;
                        url6 = url4;
                        tvType6 = tvType3;
                        $this$forEach$iv2 = $this$forEach$iv;
                    }
                    showStatus26 = showStatus38;
                    doc2 = doc11;
                    url4 = url6;
                    tvType3 = tvType6;
                    $this$forEach$iv = $this$forEach$iv2;
                }
                Document doc12 = doc2;
                ShowStatus showStatus415 = showStatus26;
                String url12 = url4;
                TvType tvType14 = tvType3;
                metaAnimeData = (MetaAnimeData) animeMetaData2.element;
                if (metaAnimeData != null) {
                    showStatus37 = showStatus19;
                } else {
                    showStatus37 = showStatus19;
                }
                C00023 c00026 = new C00023(showStatus25, showStatus37, showStatus24, showStatus22, tags3, showStatus23, anilistId3, subEpisodes, dubEpisodes, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url12);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(doc12);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(showStatus415);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(showStatus18);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(showStatus25);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(showStatus11);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(showStatus19);
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(showStatus22);
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(tags3);
                c00012.L$9 = SpillingKt.nullOutSpilledVariable(showStatus24);
                c00012.L$10 = SpillingKt.nullOutSpilledVariable(showStatus21);
                c00012.L$11 = SpillingKt.nullOutSpilledVariable(tvType14);
                c00012.L$12 = SpillingKt.nullOutSpilledVariable(showStatus20);
                c00012.L$13 = SpillingKt.nullOutSpilledVariable(showStatus23);
                c00012.L$14 = SpillingKt.nullOutSpilledVariable(showStatus12);
                c00012.L$15 = SpillingKt.nullOutSpilledVariable(anilistId3);
                c00012.L$16 = SpillingKt.nullOutSpilledVariable(animeMetaData2);
                c00012.L$17 = SpillingKt.nullOutSpilledVariable(subEpisodes);
                c00012.L$18 = SpillingKt.nullOutSpilledVariable(dubEpisodes);
                c00012.L$19 = SpillingKt.nullOutSpilledVariable(showStatus37);
                c00012.label = 4;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, showStatus415, url12, tvType14, false, c00026, c00012, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj) {
                    return obj;
                }
                return objNewAnimeLoadResponse$default;
            case 2:
                ShowStatus showStatus50 = (String) c00012.L$14;
                ShowStatus showStatus51 = (ShowStatus) c00012.L$13;
                ShowStatus showStatus52 = (String) c00012.L$12;
                TvType tvType15 = (TvType) c00012.L$11;
                ShowStatus showStatus53 = (String) c00012.L$10;
                ShowStatus showStatus54 = (Integer) c00012.L$9;
                List tags10 = (List) c00012.L$8;
                ShowStatus showStatus55 = (String) c00012.L$7;
                ShowStatus showStatus56 = (String) c00012.L$6;
                ShowStatus showStatus57 = (String) c00012.L$5;
                ShowStatus showStatus58 = (String) c00012.L$4;
                ShowStatus showStatus59 = (String) c00012.L$3;
                ShowStatus showStatus60 = (String) c00012.L$2;
                Document doc13 = (Document) c00012.L$1;
                String url13 = (String) c00012.L$0;
                ResultKt.throwOnFailure($result);
                showStatus17 = showStatus52;
                showStatus15 = showStatus53;
                showStatus14 = showStatus54;
                showStatus10 = showStatus55;
                showStatus16 = showStatus56;
                showStatus11 = showStatus57;
                showStatus12 = showStatus50;
                doc2 = doc13;
                showStatus3 = null;
                tvType2 = tvType15;
                tags2 = tags10;
                url3 = url13;
                obj = coroutine_suspended;
                showStatus9 = showStatus51;
                showStatus8 = showStatus58;
                showStatus13 = showStatus60;
                anilistId = $result;
                showStatus18 = showStatus59;
                anilistId2 = (Integer) anilistId;
                animeMetaData = new Ref.ObjectRef();
                if (anilistId2 != null) {
                    String aniZipUrl5 = "https://api.ani.zip/mappings?anilist_id=" + anilistId2.intValue();
                    Requests app6 = MainActivityKt.getApp();
                    c00012.L$0 = url3;
                    c00012.L$1 = doc2;
                    c00012.L$2 = showStatus13;
                    doc3 = doc2;
                    c00012.L$3 = SpillingKt.nullOutSpilledVariable(showStatus18);
                    c00012.L$4 = showStatus8;
                    c00012.L$5 = SpillingKt.nullOutSpilledVariable(showStatus11);
                    c00012.L$6 = showStatus16;
                    c00012.L$7 = showStatus10;
                    c00012.L$8 = tags2;
                    c00012.L$9 = showStatus14;
                    c00012.L$10 = SpillingKt.nullOutSpilledVariable(showStatus15);
                    c00012.L$11 = tvType2;
                    c00012.L$12 = SpillingKt.nullOutSpilledVariable(showStatus17);
                    c00012.L$13 = showStatus9;
                    c00012.L$14 = SpillingKt.nullOutSpilledVariable(showStatus12);
                    c00012.L$15 = anilistId2;
                    c00012.L$16 = animeMetaData;
                    c00012.L$17 = SpillingKt.nullOutSpilledVariable(aniZipUrl5);
                    c00012.label = 3;
                    tags4 = tags2;
                    showStatus27 = showStatus16;
                    showStatus28 = showStatus10;
                    C00011 c00017 = c00012;
                    showStatus29 = showStatus9;
                    tvType4 = tvType2;
                    showStatus30 = showStatus8;
                    showStatus31 = showStatus13;
                    showStatus32 = showStatus14;
                    obj3 = Requests.get$default(app6, aniZipUrl5, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00017, 4094, (Object) null);
                    c00012 = c00017;
                    if (obj3 == obj) {
                        return obj;
                    }
                    showStatus33 = showStatus12;
                    showStatus20 = showStatus17;
                    showStatus21 = showStatus15;
                    showStatus34 = showStatus28;
                    showStatus35 = showStatus29;
                    tvType5 = tvType4;
                    anilistId4 = anilistId2;
                    animeMetaData3 = animeMetaData;
                    tags5 = tags4;
                    showStatus36 = showStatus27;
                    doc4 = doc3;
                    String aniZipResponse5 = ((NiceResponse) obj3).getText();
                    animeMetaData3.element = AninekoUtilsKt.parseAnimeData(aniZipResponse5);
                    Ref.ObjectRef objectRef5 = animeMetaData3;
                    url4 = url3;
                    animeMetaData2 = objectRef5;
                    tags3 = tags5;
                    showStatus19 = showStatus36;
                    showStatus22 = showStatus34;
                    anilistId3 = anilistId4;
                    showStatus12 = showStatus33;
                    showStatus23 = showStatus35;
                    tvType3 = tvType5;
                    doc2 = doc4;
                    showStatus24 = showStatus32;
                    showStatus25 = showStatus30;
                    showStatus26 = showStatus31;
                } else {
                    ShowStatus showStatus416 = showStatus14;
                    List tags11 = tags2;
                    showStatus19 = showStatus16;
                    url4 = url3;
                    showStatus20 = showStatus17;
                    showStatus21 = showStatus15;
                    showStatus22 = showStatus10;
                    showStatus23 = showStatus9;
                    tvType3 = tvType2;
                    anilistId3 = anilistId2;
                    animeMetaData2 = animeMetaData;
                    tags3 = tags11;
                    showStatus24 = showStatus416;
                    showStatus25 = showStatus8;
                    showStatus26 = showStatus13;
                }
                subEpisodes = new ArrayList();
                dubEpisodes = new ArrayList();
                $this$forEach$iv = doc2.select(".nv-info-episode-item");
                while (r11.hasNext()) {
                    ep = (Element) element$iv2;
                    Document doc14 = doc2;
                    elementSelectFirst9 = ep.selectFirst("a.nv-info-episode-main");
                    if (elementSelectFirst9 != null) {
                        showStatus38 = showStatus26;
                        epHref = elementSelectFirst9.attr("href");
                        if (epHref == null) {
                            url6 = url4;
                            tvType6 = tvType3;
                            $this$forEach$iv2 = $this$forEach$iv;
                        } else {
                            elementSelectFirst10 = ep.selectFirst("a.nv-info-episode-main strong");
                            if (elementSelectFirst10 != null) {
                                showStatusText6 = elementSelectFirst10.text();
                            } else {
                                showStatusText6 = showStatus3;
                            }
                            showStatus39 = showStatusText6;
                            if (showStatus39 != null) {
                                url6 = url4;
                                tvType6 = tvType3;
                                $this$forEach$iv2 = $this$forEach$iv;
                                strReplace = new Regex("[^0-9]").replace((CharSequence) showStatus39, "");
                                if (strReplace != null) {
                                    intOrNull2 = StringsKt.toIntOrNull(strReplace);
                                }
                                showStatus40 = intOrNull2;
                                metaAnimeData2 = (MetaAnimeData) animeMetaData2.element;
                                if (metaAnimeData2 != null) {
                                    metaEpisode = showStatus3;
                                } else {
                                    metaEpisode = showStatus3;
                                }
                                if (metaEpisode != null) {
                                    if (metaEpisode != null) {
                                        showStatus41 = "";
                                        title2 = metaEpisode.getTitle();
                                        if (title2 != null) {
                                            str = title2.get("x-jat");
                                        }
                                        if (str == null) {
                                            if (metaEpisode != null) {
                                                str2 = showStatus3;
                                            } else {
                                                str2 = showStatus3;
                                            }
                                            if (str2 != null) {
                                                showStatus42 = str2;
                                            } else {
                                                metaAnimeData3 = (MetaAnimeData) animeMetaData2.element;
                                                if (metaAnimeData3 != null) {
                                                    str2 = showStatus3;
                                                } else {
                                                    str2 = showStatus3;
                                                }
                                                if (str2 != null) {
                                                    showStatus42 = str2;
                                                } else {
                                                    metaAnimeData4 = (MetaAnimeData) animeMetaData2.element;
                                                    if (metaAnimeData4 != null) {
                                                        str2 = showStatus3;
                                                    } else {
                                                        str2 = showStatus3;
                                                    }
                                                    if (str2 == null) {
                                                        showStatus42 = showStatus39;
                                                    } else {
                                                        showStatus42 = str2;
                                                    }
                                                }
                                            }
                                        } else {
                                            metaEpisode = metaEpisode;
                                            showStatus42 = str;
                                        }
                                    } else {
                                        showStatus41 = "";
                                    }
                                    str = showStatus3;
                                    if (str == null) {
                                        if (metaEpisode != null) {
                                            str2 = showStatus3;
                                        } else {
                                            str2 = showStatus3;
                                        }
                                        if (str2 != null) {
                                            showStatus42 = str2;
                                        } else {
                                            metaAnimeData3 = (MetaAnimeData) animeMetaData2.element;
                                            if (metaAnimeData3 != null) {
                                                str2 = showStatus3;
                                            } else {
                                                str2 = showStatus3;
                                            }
                                            if (str2 != null) {
                                                showStatus42 = str2;
                                            } else {
                                                metaAnimeData4 = (MetaAnimeData) animeMetaData2.element;
                                                if (metaAnimeData4 != null) {
                                                    str2 = showStatus3;
                                                } else {
                                                    str2 = showStatus3;
                                                }
                                                if (str2 == null) {
                                                    showStatus42 = showStatus39;
                                                } else {
                                                    showStatus42 = str2;
                                                }
                                            }
                                        }
                                    } else {
                                        metaEpisode = metaEpisode;
                                        showStatus42 = str;
                                    }
                                } else {
                                    if (metaEpisode != null) {
                                        showStatus41 = "";
                                        title2 = metaEpisode.getTitle();
                                        if (title2 != null) {
                                            str = title2.get("x-jat");
                                        }
                                        if (str == null) {
                                            if (metaEpisode != null) {
                                                str2 = showStatus3;
                                            } else {
                                                str2 = showStatus3;
                                            }
                                            if (str2 != null) {
                                                showStatus42 = str2;
                                            } else {
                                                metaAnimeData3 = (MetaAnimeData) animeMetaData2.element;
                                                if (metaAnimeData3 != null) {
                                                    str2 = showStatus3;
                                                } else {
                                                    str2 = showStatus3;
                                                }
                                                if (str2 != null) {
                                                    showStatus42 = str2;
                                                } else {
                                                    metaAnimeData4 = (MetaAnimeData) animeMetaData2.element;
                                                    if (metaAnimeData4 != null) {
                                                        str2 = showStatus3;
                                                    } else {
                                                        str2 = showStatus3;
                                                    }
                                                    if (str2 == null) {
                                                        showStatus42 = showStatus39;
                                                    } else {
                                                        showStatus42 = str2;
                                                    }
                                                }
                                            }
                                        } else {
                                            metaEpisode = metaEpisode;
                                            showStatus42 = str;
                                        }
                                    } else {
                                        showStatus41 = "";
                                    }
                                    str = showStatus3;
                                    if (str == null) {
                                        if (metaEpisode != null) {
                                            str2 = showStatus3;
                                        } else {
                                            str2 = showStatus3;
                                        }
                                        if (str2 != null) {
                                            showStatus42 = str2;
                                        } else {
                                            metaAnimeData3 = (MetaAnimeData) animeMetaData2.element;
                                            if (metaAnimeData3 != null) {
                                                str2 = showStatus3;
                                            } else {
                                                str2 = showStatus3;
                                            }
                                            if (str2 != null) {
                                                showStatus42 = str2;
                                            } else {
                                                metaAnimeData4 = (MetaAnimeData) animeMetaData2.element;
                                                if (metaAnimeData4 != null) {
                                                    str2 = showStatus3;
                                                } else {
                                                    str2 = showStatus3;
                                                }
                                                if (str2 == null) {
                                                    showStatus42 = showStatus39;
                                                } else {
                                                    showStatus42 = str2;
                                                }
                                            }
                                        }
                                    } else {
                                        metaEpisode = metaEpisode;
                                        showStatus42 = str;
                                    }
                                }
                                if (metaEpisode != null) {
                                    overview = "No summary available";
                                } else {
                                    overview = "No summary available";
                                }
                                description = overview;
                                if (metaEpisode != null) {
                                    metaAnimeData5 = (MetaAnimeData) animeMetaData2.element;
                                    if (metaAnimeData5 != null) {
                                        url7 = showStatus3;
                                    } else {
                                        url7 = showStatus3;
                                    }
                                    if (url7 == null) {
                                        showStatus43 = showStatus41;
                                    } else {
                                        showStatus43 = url7;
                                    }
                                } else {
                                    metaAnimeData5 = (MetaAnimeData) animeMetaData2.element;
                                    if (metaAnimeData5 != null) {
                                        url7 = showStatus3;
                                    } else {
                                        url7 = showStatus3;
                                    }
                                    if (url7 == null) {
                                        showStatus43 = showStatus41;
                                    } else {
                                        showStatus43 = url7;
                                    }
                                }
                                if (metaEpisode != null) {
                                    rating = metaEpisode.getRating();
                                } else {
                                    rating = showStatus3;
                                }
                                if (metaEpisode != null) {
                                    runtime = metaEpisode.getRuntime();
                                } else {
                                    runtime = showStatus3;
                                }
                                if (metaEpisode != null) {
                                    airDateUtc = metaEpisode.getAirDateUtc();
                                } else {
                                    airDateUtc = showStatus3;
                                }
                                $this$map$iv = ep.select(".nv-info-episode-badges span");
                                int $i$f$map9 = CollectionsKt.collectionSizeOrDefault($this$map$iv, 10);
                                destination$iv$iv2 = new ArrayList($i$f$map9);
                                while (r31.hasNext()) {
                                    Element it13 = (Element) item$iv$iv2;
                                    Iterable $this$map$iv12 = $this$map$iv;
                                    String lowerCase9 = it13.text().toLowerCase(Locale.ROOT);
                                    Intrinsics.checkNotNullExpressionValue(lowerCase9, "toLowerCase(...)");
                                    destination$iv$iv2.add(lowerCase9);
                                    $this$map$iv = $this$map$iv12;
                                }
                                badges = (List) destination$iv$iv2;
                                if (badges.contains("sub")) {
                                    hasSub = true;
                                } else {
                                    hasSub = true;
                                }
                                hasDub = badges.contains("dub");
                                if (hasSub) {
                                    subEpisodes.add(MainAPIKt.newEpisode(this, getMainUrl() + epHref + "|sub", new Function1() { // from class: com.anineko.Anineko$$ExternalSyntheticLambda0
                                        public final Object invoke(Object obj5) {
                                            return Anineko.load$lambda$2$1(showStatus42, showStatus40, description, showStatus43, rating, runtime, airDateUtc, (Episode) obj5);
                                        }
                                    }));
                                } else {
                                    subEpisodes.add(MainAPIKt.newEpisode(this, getMainUrl() + epHref + "|sub", new Function1() { // from class: com.anineko.Anineko$$ExternalSyntheticLambda0
                                        public final Object invoke(Object obj5) {
                                            return Anineko.load$lambda$2$1(showStatus42, showStatus40, description, showStatus43, rating, runtime, airDateUtc, (Episode) obj5);
                                        }
                                    }));
                                }
                                if (hasDub) {
                                    dubEpisodes.add(MainAPIKt.newEpisode(this, getMainUrl() + epHref + "|dub", new Function1() { // from class: com.anineko.Anineko$$ExternalSyntheticLambda1
                                        public final Object invoke(Object obj5) {
                                            return Anineko.load$lambda$2$2(showStatus42, showStatus40, description, showStatus43, rating, runtime, airDateUtc, (Episode) obj5);
                                        }
                                    }));
                                }
                            } else {
                                url6 = url4;
                                tvType6 = tvType3;
                                $this$forEach$iv2 = $this$forEach$iv;
                            }
                            intOrNull2 = showStatus3;
                            showStatus40 = intOrNull2;
                            metaAnimeData2 = (MetaAnimeData) animeMetaData2.element;
                            if (metaAnimeData2 != null) {
                                metaEpisode = showStatus3;
                            } else {
                                metaEpisode = showStatus3;
                            }
                            if (metaEpisode != null) {
                                if (metaEpisode != null) {
                                    showStatus41 = "";
                                    title2 = metaEpisode.getTitle();
                                    if (title2 != null) {
                                        str = title2.get("x-jat");
                                    }
                                    if (str == null) {
                                        if (metaEpisode != null) {
                                            str2 = showStatus3;
                                        } else {
                                            str2 = showStatus3;
                                        }
                                        if (str2 != null) {
                                            showStatus42 = str2;
                                        } else {
                                            metaAnimeData3 = (MetaAnimeData) animeMetaData2.element;
                                            if (metaAnimeData3 != null) {
                                                str2 = showStatus3;
                                            } else {
                                                str2 = showStatus3;
                                            }
                                            if (str2 != null) {
                                                showStatus42 = str2;
                                            } else {
                                                metaAnimeData4 = (MetaAnimeData) animeMetaData2.element;
                                                if (metaAnimeData4 != null) {
                                                    str2 = showStatus3;
                                                } else {
                                                    str2 = showStatus3;
                                                }
                                                if (str2 == null) {
                                                    showStatus42 = showStatus39;
                                                } else {
                                                    showStatus42 = str2;
                                                }
                                            }
                                        }
                                    } else {
                                        metaEpisode = metaEpisode;
                                        showStatus42 = str;
                                    }
                                } else {
                                    showStatus41 = "";
                                }
                                str = showStatus3;
                                if (str == null) {
                                    if (metaEpisode != null) {
                                        str2 = showStatus3;
                                    } else {
                                        str2 = showStatus3;
                                    }
                                    if (str2 != null) {
                                        showStatus42 = str2;
                                    } else {
                                        metaAnimeData3 = (MetaAnimeData) animeMetaData2.element;
                                        if (metaAnimeData3 != null) {
                                            str2 = showStatus3;
                                        } else {
                                            str2 = showStatus3;
                                        }
                                        if (str2 != null) {
                                            showStatus42 = str2;
                                        } else {
                                            metaAnimeData4 = (MetaAnimeData) animeMetaData2.element;
                                            if (metaAnimeData4 != null) {
                                                str2 = showStatus3;
                                            } else {
                                                str2 = showStatus3;
                                            }
                                            if (str2 == null) {
                                                showStatus42 = showStatus39;
                                            } else {
                                                showStatus42 = str2;
                                            }
                                        }
                                    }
                                } else {
                                    metaEpisode = metaEpisode;
                                    showStatus42 = str;
                                }
                            } else {
                                if (metaEpisode != null) {
                                    showStatus41 = "";
                                    title2 = metaEpisode.getTitle();
                                    if (title2 != null) {
                                        str = title2.get("x-jat");
                                    }
                                    if (str == null) {
                                        if (metaEpisode != null) {
                                            str2 = showStatus3;
                                        } else {
                                            str2 = showStatus3;
                                        }
                                        if (str2 != null) {
                                            showStatus42 = str2;
                                        } else {
                                            metaAnimeData3 = (MetaAnimeData) animeMetaData2.element;
                                            if (metaAnimeData3 != null) {
                                                str2 = showStatus3;
                                            } else {
                                                str2 = showStatus3;
                                            }
                                            if (str2 != null) {
                                                showStatus42 = str2;
                                            } else {
                                                metaAnimeData4 = (MetaAnimeData) animeMetaData2.element;
                                                if (metaAnimeData4 != null) {
                                                    str2 = showStatus3;
                                                } else {
                                                    str2 = showStatus3;
                                                }
                                                if (str2 == null) {
                                                    showStatus42 = showStatus39;
                                                } else {
                                                    showStatus42 = str2;
                                                }
                                            }
                                        }
                                    } else {
                                        metaEpisode = metaEpisode;
                                        showStatus42 = str;
                                    }
                                } else {
                                    showStatus41 = "";
                                }
                                str = showStatus3;
                                if (str == null) {
                                    if (metaEpisode != null) {
                                        str2 = showStatus3;
                                    } else {
                                        str2 = showStatus3;
                                    }
                                    if (str2 != null) {
                                        showStatus42 = str2;
                                    } else {
                                        metaAnimeData3 = (MetaAnimeData) animeMetaData2.element;
                                        if (metaAnimeData3 != null) {
                                            str2 = showStatus3;
                                        } else {
                                            str2 = showStatus3;
                                        }
                                        if (str2 != null) {
                                            showStatus42 = str2;
                                        } else {
                                            metaAnimeData4 = (MetaAnimeData) animeMetaData2.element;
                                            if (metaAnimeData4 != null) {
                                                str2 = showStatus3;
                                            } else {
                                                str2 = showStatus3;
                                            }
                                            if (str2 == null) {
                                                showStatus42 = showStatus39;
                                            } else {
                                                showStatus42 = str2;
                                            }
                                        }
                                    }
                                } else {
                                    metaEpisode = metaEpisode;
                                    showStatus42 = str;
                                }
                            }
                            if (metaEpisode != null) {
                                overview = "No summary available";
                            } else {
                                overview = "No summary available";
                            }
                            description = overview;
                            if (metaEpisode != null) {
                                metaAnimeData5 = (MetaAnimeData) animeMetaData2.element;
                                if (metaAnimeData5 != null) {
                                    url7 = showStatus3;
                                } else {
                                    url7 = showStatus3;
                                }
                                if (url7 == null) {
                                    showStatus43 = showStatus41;
                                } else {
                                    showStatus43 = url7;
                                }
                            } else {
                                metaAnimeData5 = (MetaAnimeData) animeMetaData2.element;
                                if (metaAnimeData5 != null) {
                                    url7 = showStatus3;
                                } else {
                                    url7 = showStatus3;
                                }
                                if (url7 == null) {
                                    showStatus43 = showStatus41;
                                } else {
                                    showStatus43 = url7;
                                }
                            }
                            if (metaEpisode != null) {
                                rating = metaEpisode.getRating();
                            } else {
                                rating = showStatus3;
                            }
                            if (metaEpisode != null) {
                                runtime = metaEpisode.getRuntime();
                            } else {
                                runtime = showStatus3;
                            }
                            if (metaEpisode != null) {
                                airDateUtc = metaEpisode.getAirDateUtc();
                            } else {
                                airDateUtc = showStatus3;
                            }
                            $this$map$iv = ep.select(".nv-info-episode-badges span");
                            int $i$f$map10 = CollectionsKt.collectionSizeOrDefault($this$map$iv, 10);
                            destination$iv$iv2 = new ArrayList($i$f$map10);
                            while (r31.hasNext()) {
                                Element it14 = (Element) item$iv$iv2;
                                Iterable $this$map$iv13 = $this$map$iv;
                                String lowerCase10 = it14.text().toLowerCase(Locale.ROOT);
                                Intrinsics.checkNotNullExpressionValue(lowerCase10, "toLowerCase(...)");
                                destination$iv$iv2.add(lowerCase10);
                                $this$map$iv = $this$map$iv13;
                            }
                            badges = (List) destination$iv$iv2;
                            if (badges.contains("sub")) {
                                hasSub = true;
                            } else {
                                hasSub = true;
                            }
                            hasDub = badges.contains("dub");
                            if (hasSub) {
                                subEpisodes.add(MainAPIKt.newEpisode(this, getMainUrl() + epHref + "|sub", new Function1() { // from class: com.anineko.Anineko$$ExternalSyntheticLambda0
                                    public final Object invoke(Object obj5) {
                                        return Anineko.load$lambda$2$1(showStatus42, showStatus40, description, showStatus43, rating, runtime, airDateUtc, (Episode) obj5);
                                    }
                                }));
                            } else {
                                subEpisodes.add(MainAPIKt.newEpisode(this, getMainUrl() + epHref + "|sub", new Function1() { // from class: com.anineko.Anineko$$ExternalSyntheticLambda0
                                    public final Object invoke(Object obj5) {
                                        return Anineko.load$lambda$2$1(showStatus42, showStatus40, description, showStatus43, rating, runtime, airDateUtc, (Episode) obj5);
                                    }
                                }));
                            }
                            if (hasDub) {
                                dubEpisodes.add(MainAPIKt.newEpisode(this, getMainUrl() + epHref + "|dub", new Function1() { // from class: com.anineko.Anineko$$ExternalSyntheticLambda1
                                    public final Object invoke(Object obj5) {
                                        return Anineko.load$lambda$2$2(showStatus42, showStatus40, description, showStatus43, rating, runtime, airDateUtc, (Episode) obj5);
                                    }
                                }));
                            }
                        }
                    } else {
                        showStatus38 = showStatus26;
                        url6 = url4;
                        tvType6 = tvType3;
                        $this$forEach$iv2 = $this$forEach$iv;
                    }
                    showStatus26 = showStatus38;
                    doc2 = doc14;
                    url4 = url6;
                    tvType3 = tvType6;
                    $this$forEach$iv = $this$forEach$iv2;
                }
                Document doc15 = doc2;
                ShowStatus showStatus417 = showStatus26;
                String url14 = url4;
                TvType tvType16 = tvType3;
                metaAnimeData = (MetaAnimeData) animeMetaData2.element;
                if (metaAnimeData != null) {
                    showStatus37 = showStatus19;
                } else {
                    showStatus37 = showStatus19;
                }
                C00023 c00027 = new C00023(showStatus25, showStatus37, showStatus24, showStatus22, tags3, showStatus23, anilistId3, subEpisodes, dubEpisodes, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url14);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(doc15);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(showStatus417);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(showStatus18);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(showStatus25);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(showStatus11);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(showStatus19);
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(showStatus22);
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(tags3);
                c00012.L$9 = SpillingKt.nullOutSpilledVariable(showStatus24);
                c00012.L$10 = SpillingKt.nullOutSpilledVariable(showStatus21);
                c00012.L$11 = SpillingKt.nullOutSpilledVariable(tvType16);
                c00012.L$12 = SpillingKt.nullOutSpilledVariable(showStatus20);
                c00012.L$13 = SpillingKt.nullOutSpilledVariable(showStatus23);
                c00012.L$14 = SpillingKt.nullOutSpilledVariable(showStatus12);
                c00012.L$15 = SpillingKt.nullOutSpilledVariable(anilistId3);
                c00012.L$16 = SpillingKt.nullOutSpilledVariable(animeMetaData2);
                c00012.L$17 = SpillingKt.nullOutSpilledVariable(subEpisodes);
                c00012.L$18 = SpillingKt.nullOutSpilledVariable(dubEpisodes);
                c00012.L$19 = SpillingKt.nullOutSpilledVariable(showStatus37);
                c00012.label = 4;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, showStatus417, url14, tvType16, false, c00027, c00012, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj) {
                    return obj;
                }
                return objNewAnimeLoadResponse$default;
            case 3:
                Ref.ObjectRef animeMetaData4 = (Ref.ObjectRef) c00012.L$16;
                anilistId4 = (Integer) c00012.L$15;
                showStatus33 = (String) c00012.L$14;
                showStatus35 = (ShowStatus) c00012.L$13;
                showStatus20 = (String) c00012.L$12;
                tvType5 = (TvType) c00012.L$11;
                showStatus21 = (String) c00012.L$10;
                ShowStatus showStatus61 = (Integer) c00012.L$9;
                tags5 = (List) c00012.L$8;
                showStatus34 = (String) c00012.L$7;
                showStatus36 = (String) c00012.L$6;
                ShowStatus showStatus62 = (String) c00012.L$5;
                ShowStatus showStatus63 = (String) c00012.L$4;
                ShowStatus showStatus64 = (String) c00012.L$3;
                ShowStatus showStatus65 = (String) c00012.L$2;
                doc4 = (Document) c00012.L$1;
                String url15 = (String) c00012.L$0;
                ResultKt.throwOnFailure($result);
                showStatus11 = showStatus62;
                showStatus18 = showStatus64;
                showStatus32 = showStatus61;
                showStatus30 = showStatus63;
                showStatus31 = showStatus65;
                showStatus3 = null;
                animeMetaData3 = animeMetaData4;
                url3 = url15;
                obj = coroutine_suspended;
                obj3 = $result;
                String aniZipResponse6 = ((NiceResponse) obj3).getText();
                animeMetaData3.element = AninekoUtilsKt.parseAnimeData(aniZipResponse6);
                Ref.ObjectRef objectRef6 = animeMetaData3;
                url4 = url3;
                animeMetaData2 = objectRef6;
                tags3 = tags5;
                showStatus19 = showStatus36;
                showStatus22 = showStatus34;
                anilistId3 = anilistId4;
                showStatus12 = showStatus33;
                showStatus23 = showStatus35;
                tvType3 = tvType5;
                doc2 = doc4;
                showStatus24 = showStatus32;
                showStatus25 = showStatus30;
                showStatus26 = showStatus31;
                subEpisodes = new ArrayList();
                dubEpisodes = new ArrayList();
                $this$forEach$iv = doc2.select(".nv-info-episode-item");
                while (r11.hasNext()) {
                    ep = (Element) element$iv2;
                    Document doc16 = doc2;
                    elementSelectFirst9 = ep.selectFirst("a.nv-info-episode-main");
                    if (elementSelectFirst9 != null) {
                        showStatus38 = showStatus26;
                        epHref = elementSelectFirst9.attr("href");
                        if (epHref == null) {
                            url6 = url4;
                            tvType6 = tvType3;
                            $this$forEach$iv2 = $this$forEach$iv;
                        } else {
                            elementSelectFirst10 = ep.selectFirst("a.nv-info-episode-main strong");
                            if (elementSelectFirst10 != null) {
                                showStatusText6 = elementSelectFirst10.text();
                            } else {
                                showStatusText6 = showStatus3;
                            }
                            showStatus39 = showStatusText6;
                            if (showStatus39 != null) {
                                url6 = url4;
                                tvType6 = tvType3;
                                $this$forEach$iv2 = $this$forEach$iv;
                                strReplace = new Regex("[^0-9]").replace((CharSequence) showStatus39, "");
                                if (strReplace != null) {
                                    intOrNull2 = StringsKt.toIntOrNull(strReplace);
                                }
                                showStatus40 = intOrNull2;
                                metaAnimeData2 = (MetaAnimeData) animeMetaData2.element;
                                if (metaAnimeData2 != null) {
                                    metaEpisode = showStatus3;
                                } else {
                                    metaEpisode = showStatus3;
                                }
                                if (metaEpisode != null) {
                                    if (metaEpisode != null) {
                                        showStatus41 = "";
                                        title2 = metaEpisode.getTitle();
                                        if (title2 != null) {
                                            str = title2.get("x-jat");
                                        }
                                        if (str == null) {
                                            if (metaEpisode != null) {
                                                str2 = showStatus3;
                                            } else {
                                                str2 = showStatus3;
                                            }
                                            if (str2 != null) {
                                                showStatus42 = str2;
                                            } else {
                                                metaAnimeData3 = (MetaAnimeData) animeMetaData2.element;
                                                if (metaAnimeData3 != null) {
                                                    str2 = showStatus3;
                                                } else {
                                                    str2 = showStatus3;
                                                }
                                                if (str2 != null) {
                                                    showStatus42 = str2;
                                                } else {
                                                    metaAnimeData4 = (MetaAnimeData) animeMetaData2.element;
                                                    if (metaAnimeData4 != null) {
                                                        str2 = showStatus3;
                                                    } else {
                                                        str2 = showStatus3;
                                                    }
                                                    if (str2 == null) {
                                                        showStatus42 = showStatus39;
                                                    } else {
                                                        showStatus42 = str2;
                                                    }
                                                }
                                            }
                                        } else {
                                            metaEpisode = metaEpisode;
                                            showStatus42 = str;
                                        }
                                    } else {
                                        showStatus41 = "";
                                    }
                                    str = showStatus3;
                                    if (str == null) {
                                        if (metaEpisode != null) {
                                            str2 = showStatus3;
                                        } else {
                                            str2 = showStatus3;
                                        }
                                        if (str2 != null) {
                                            showStatus42 = str2;
                                        } else {
                                            metaAnimeData3 = (MetaAnimeData) animeMetaData2.element;
                                            if (metaAnimeData3 != null) {
                                                str2 = showStatus3;
                                            } else {
                                                str2 = showStatus3;
                                            }
                                            if (str2 != null) {
                                                showStatus42 = str2;
                                            } else {
                                                metaAnimeData4 = (MetaAnimeData) animeMetaData2.element;
                                                if (metaAnimeData4 != null) {
                                                    str2 = showStatus3;
                                                } else {
                                                    str2 = showStatus3;
                                                }
                                                if (str2 == null) {
                                                    showStatus42 = showStatus39;
                                                } else {
                                                    showStatus42 = str2;
                                                }
                                            }
                                        }
                                    } else {
                                        metaEpisode = metaEpisode;
                                        showStatus42 = str;
                                    }
                                } else {
                                    if (metaEpisode != null) {
                                        showStatus41 = "";
                                        title2 = metaEpisode.getTitle();
                                        if (title2 != null) {
                                            str = title2.get("x-jat");
                                        }
                                        if (str == null) {
                                            if (metaEpisode != null) {
                                                str2 = showStatus3;
                                            } else {
                                                str2 = showStatus3;
                                            }
                                            if (str2 != null) {
                                                showStatus42 = str2;
                                            } else {
                                                metaAnimeData3 = (MetaAnimeData) animeMetaData2.element;
                                                if (metaAnimeData3 != null) {
                                                    str2 = showStatus3;
                                                } else {
                                                    str2 = showStatus3;
                                                }
                                                if (str2 != null) {
                                                    showStatus42 = str2;
                                                } else {
                                                    metaAnimeData4 = (MetaAnimeData) animeMetaData2.element;
                                                    if (metaAnimeData4 != null) {
                                                        str2 = showStatus3;
                                                    } else {
                                                        str2 = showStatus3;
                                                    }
                                                    if (str2 == null) {
                                                        showStatus42 = showStatus39;
                                                    } else {
                                                        showStatus42 = str2;
                                                    }
                                                }
                                            }
                                        } else {
                                            metaEpisode = metaEpisode;
                                            showStatus42 = str;
                                        }
                                    } else {
                                        showStatus41 = "";
                                    }
                                    str = showStatus3;
                                    if (str == null) {
                                        if (metaEpisode != null) {
                                            str2 = showStatus3;
                                        } else {
                                            str2 = showStatus3;
                                        }
                                        if (str2 != null) {
                                            showStatus42 = str2;
                                        } else {
                                            metaAnimeData3 = (MetaAnimeData) animeMetaData2.element;
                                            if (metaAnimeData3 != null) {
                                                str2 = showStatus3;
                                            } else {
                                                str2 = showStatus3;
                                            }
                                            if (str2 != null) {
                                                showStatus42 = str2;
                                            } else {
                                                metaAnimeData4 = (MetaAnimeData) animeMetaData2.element;
                                                if (metaAnimeData4 != null) {
                                                    str2 = showStatus3;
                                                } else {
                                                    str2 = showStatus3;
                                                }
                                                if (str2 == null) {
                                                    showStatus42 = showStatus39;
                                                } else {
                                                    showStatus42 = str2;
                                                }
                                            }
                                        }
                                    } else {
                                        metaEpisode = metaEpisode;
                                        showStatus42 = str;
                                    }
                                }
                                if (metaEpisode != null) {
                                    overview = "No summary available";
                                } else {
                                    overview = "No summary available";
                                }
                                description = overview;
                                if (metaEpisode != null) {
                                    metaAnimeData5 = (MetaAnimeData) animeMetaData2.element;
                                    if (metaAnimeData5 != null) {
                                        url7 = showStatus3;
                                    } else {
                                        url7 = showStatus3;
                                    }
                                    if (url7 == null) {
                                        showStatus43 = showStatus41;
                                    } else {
                                        showStatus43 = url7;
                                    }
                                } else {
                                    metaAnimeData5 = (MetaAnimeData) animeMetaData2.element;
                                    if (metaAnimeData5 != null) {
                                        url7 = showStatus3;
                                    } else {
                                        url7 = showStatus3;
                                    }
                                    if (url7 == null) {
                                        showStatus43 = showStatus41;
                                    } else {
                                        showStatus43 = url7;
                                    }
                                }
                                if (metaEpisode != null) {
                                    rating = metaEpisode.getRating();
                                } else {
                                    rating = showStatus3;
                                }
                                if (metaEpisode != null) {
                                    runtime = metaEpisode.getRuntime();
                                } else {
                                    runtime = showStatus3;
                                }
                                if (metaEpisode != null) {
                                    airDateUtc = metaEpisode.getAirDateUtc();
                                } else {
                                    airDateUtc = showStatus3;
                                }
                                $this$map$iv = ep.select(".nv-info-episode-badges span");
                                int $i$f$map11 = CollectionsKt.collectionSizeOrDefault($this$map$iv, 10);
                                destination$iv$iv2 = new ArrayList($i$f$map11);
                                while (r31.hasNext()) {
                                    Element it15 = (Element) item$iv$iv2;
                                    Iterable $this$map$iv14 = $this$map$iv;
                                    String lowerCase11 = it15.text().toLowerCase(Locale.ROOT);
                                    Intrinsics.checkNotNullExpressionValue(lowerCase11, "toLowerCase(...)");
                                    destination$iv$iv2.add(lowerCase11);
                                    $this$map$iv = $this$map$iv14;
                                }
                                badges = (List) destination$iv$iv2;
                                if (badges.contains("sub")) {
                                    hasSub = true;
                                } else {
                                    hasSub = true;
                                }
                                hasDub = badges.contains("dub");
                                if (hasSub) {
                                    subEpisodes.add(MainAPIKt.newEpisode(this, getMainUrl() + epHref + "|sub", new Function1() { // from class: com.anineko.Anineko$$ExternalSyntheticLambda0
                                        public final Object invoke(Object obj5) {
                                            return Anineko.load$lambda$2$1(showStatus42, showStatus40, description, showStatus43, rating, runtime, airDateUtc, (Episode) obj5);
                                        }
                                    }));
                                } else {
                                    subEpisodes.add(MainAPIKt.newEpisode(this, getMainUrl() + epHref + "|sub", new Function1() { // from class: com.anineko.Anineko$$ExternalSyntheticLambda0
                                        public final Object invoke(Object obj5) {
                                            return Anineko.load$lambda$2$1(showStatus42, showStatus40, description, showStatus43, rating, runtime, airDateUtc, (Episode) obj5);
                                        }
                                    }));
                                }
                                if (hasDub) {
                                    dubEpisodes.add(MainAPIKt.newEpisode(this, getMainUrl() + epHref + "|dub", new Function1() { // from class: com.anineko.Anineko$$ExternalSyntheticLambda1
                                        public final Object invoke(Object obj5) {
                                            return Anineko.load$lambda$2$2(showStatus42, showStatus40, description, showStatus43, rating, runtime, airDateUtc, (Episode) obj5);
                                        }
                                    }));
                                }
                            } else {
                                url6 = url4;
                                tvType6 = tvType3;
                                $this$forEach$iv2 = $this$forEach$iv;
                            }
                            intOrNull2 = showStatus3;
                            showStatus40 = intOrNull2;
                            metaAnimeData2 = (MetaAnimeData) animeMetaData2.element;
                            if (metaAnimeData2 != null) {
                                metaEpisode = showStatus3;
                            } else {
                                metaEpisode = showStatus3;
                            }
                            if (metaEpisode != null) {
                                if (metaEpisode != null) {
                                    showStatus41 = "";
                                    title2 = metaEpisode.getTitle();
                                    if (title2 != null) {
                                        str = title2.get("x-jat");
                                    }
                                    if (str == null) {
                                        if (metaEpisode != null) {
                                            str2 = showStatus3;
                                        } else {
                                            str2 = showStatus3;
                                        }
                                        if (str2 != null) {
                                            showStatus42 = str2;
                                        } else {
                                            metaAnimeData3 = (MetaAnimeData) animeMetaData2.element;
                                            if (metaAnimeData3 != null) {
                                                str2 = showStatus3;
                                            } else {
                                                str2 = showStatus3;
                                            }
                                            if (str2 != null) {
                                                showStatus42 = str2;
                                            } else {
                                                metaAnimeData4 = (MetaAnimeData) animeMetaData2.element;
                                                if (metaAnimeData4 != null) {
                                                    str2 = showStatus3;
                                                } else {
                                                    str2 = showStatus3;
                                                }
                                                if (str2 == null) {
                                                    showStatus42 = showStatus39;
                                                } else {
                                                    showStatus42 = str2;
                                                }
                                            }
                                        }
                                    } else {
                                        metaEpisode = metaEpisode;
                                        showStatus42 = str;
                                    }
                                } else {
                                    showStatus41 = "";
                                }
                                str = showStatus3;
                                if (str == null) {
                                    if (metaEpisode != null) {
                                        str2 = showStatus3;
                                    } else {
                                        str2 = showStatus3;
                                    }
                                    if (str2 != null) {
                                        showStatus42 = str2;
                                    } else {
                                        metaAnimeData3 = (MetaAnimeData) animeMetaData2.element;
                                        if (metaAnimeData3 != null) {
                                            str2 = showStatus3;
                                        } else {
                                            str2 = showStatus3;
                                        }
                                        if (str2 != null) {
                                            showStatus42 = str2;
                                        } else {
                                            metaAnimeData4 = (MetaAnimeData) animeMetaData2.element;
                                            if (metaAnimeData4 != null) {
                                                str2 = showStatus3;
                                            } else {
                                                str2 = showStatus3;
                                            }
                                            if (str2 == null) {
                                                showStatus42 = showStatus39;
                                            } else {
                                                showStatus42 = str2;
                                            }
                                        }
                                    }
                                } else {
                                    metaEpisode = metaEpisode;
                                    showStatus42 = str;
                                }
                            } else {
                                if (metaEpisode != null) {
                                    showStatus41 = "";
                                    title2 = metaEpisode.getTitle();
                                    if (title2 != null) {
                                        str = title2.get("x-jat");
                                    }
                                    if (str == null) {
                                        if (metaEpisode != null) {
                                            str2 = showStatus3;
                                        } else {
                                            str2 = showStatus3;
                                        }
                                        if (str2 != null) {
                                            showStatus42 = str2;
                                        } else {
                                            metaAnimeData3 = (MetaAnimeData) animeMetaData2.element;
                                            if (metaAnimeData3 != null) {
                                                str2 = showStatus3;
                                            } else {
                                                str2 = showStatus3;
                                            }
                                            if (str2 != null) {
                                                showStatus42 = str2;
                                            } else {
                                                metaAnimeData4 = (MetaAnimeData) animeMetaData2.element;
                                                if (metaAnimeData4 != null) {
                                                    str2 = showStatus3;
                                                } else {
                                                    str2 = showStatus3;
                                                }
                                                if (str2 == null) {
                                                    showStatus42 = showStatus39;
                                                } else {
                                                    showStatus42 = str2;
                                                }
                                            }
                                        }
                                    } else {
                                        metaEpisode = metaEpisode;
                                        showStatus42 = str;
                                    }
                                } else {
                                    showStatus41 = "";
                                }
                                str = showStatus3;
                                if (str == null) {
                                    if (metaEpisode != null) {
                                        str2 = showStatus3;
                                    } else {
                                        str2 = showStatus3;
                                    }
                                    if (str2 != null) {
                                        showStatus42 = str2;
                                    } else {
                                        metaAnimeData3 = (MetaAnimeData) animeMetaData2.element;
                                        if (metaAnimeData3 != null) {
                                            str2 = showStatus3;
                                        } else {
                                            str2 = showStatus3;
                                        }
                                        if (str2 != null) {
                                            showStatus42 = str2;
                                        } else {
                                            metaAnimeData4 = (MetaAnimeData) animeMetaData2.element;
                                            if (metaAnimeData4 != null) {
                                                str2 = showStatus3;
                                            } else {
                                                str2 = showStatus3;
                                            }
                                            if (str2 == null) {
                                                showStatus42 = showStatus39;
                                            } else {
                                                showStatus42 = str2;
                                            }
                                        }
                                    }
                                } else {
                                    metaEpisode = metaEpisode;
                                    showStatus42 = str;
                                }
                            }
                            if (metaEpisode != null) {
                                overview = "No summary available";
                            } else {
                                overview = "No summary available";
                            }
                            description = overview;
                            if (metaEpisode != null) {
                                metaAnimeData5 = (MetaAnimeData) animeMetaData2.element;
                                if (metaAnimeData5 != null) {
                                    url7 = showStatus3;
                                } else {
                                    url7 = showStatus3;
                                }
                                if (url7 == null) {
                                    showStatus43 = showStatus41;
                                } else {
                                    showStatus43 = url7;
                                }
                            } else {
                                metaAnimeData5 = (MetaAnimeData) animeMetaData2.element;
                                if (metaAnimeData5 != null) {
                                    url7 = showStatus3;
                                } else {
                                    url7 = showStatus3;
                                }
                                if (url7 == null) {
                                    showStatus43 = showStatus41;
                                } else {
                                    showStatus43 = url7;
                                }
                            }
                            if (metaEpisode != null) {
                                rating = metaEpisode.getRating();
                            } else {
                                rating = showStatus3;
                            }
                            if (metaEpisode != null) {
                                runtime = metaEpisode.getRuntime();
                            } else {
                                runtime = showStatus3;
                            }
                            if (metaEpisode != null) {
                                airDateUtc = metaEpisode.getAirDateUtc();
                            } else {
                                airDateUtc = showStatus3;
                            }
                            $this$map$iv = ep.select(".nv-info-episode-badges span");
                            int $i$f$map12 = CollectionsKt.collectionSizeOrDefault($this$map$iv, 10);
                            destination$iv$iv2 = new ArrayList($i$f$map12);
                            while (r31.hasNext()) {
                                Element it16 = (Element) item$iv$iv2;
                                Iterable $this$map$iv15 = $this$map$iv;
                                String lowerCase12 = it16.text().toLowerCase(Locale.ROOT);
                                Intrinsics.checkNotNullExpressionValue(lowerCase12, "toLowerCase(...)");
                                destination$iv$iv2.add(lowerCase12);
                                $this$map$iv = $this$map$iv15;
                            }
                            badges = (List) destination$iv$iv2;
                            if (badges.contains("sub")) {
                                hasSub = true;
                            } else {
                                hasSub = true;
                            }
                            hasDub = badges.contains("dub");
                            if (hasSub) {
                                subEpisodes.add(MainAPIKt.newEpisode(this, getMainUrl() + epHref + "|sub", new Function1() { // from class: com.anineko.Anineko$$ExternalSyntheticLambda0
                                    public final Object invoke(Object obj5) {
                                        return Anineko.load$lambda$2$1(showStatus42, showStatus40, description, showStatus43, rating, runtime, airDateUtc, (Episode) obj5);
                                    }
                                }));
                            } else {
                                subEpisodes.add(MainAPIKt.newEpisode(this, getMainUrl() + epHref + "|sub", new Function1() { // from class: com.anineko.Anineko$$ExternalSyntheticLambda0
                                    public final Object invoke(Object obj5) {
                                        return Anineko.load$lambda$2$1(showStatus42, showStatus40, description, showStatus43, rating, runtime, airDateUtc, (Episode) obj5);
                                    }
                                }));
                            }
                            if (hasDub) {
                                dubEpisodes.add(MainAPIKt.newEpisode(this, getMainUrl() + epHref + "|dub", new Function1() { // from class: com.anineko.Anineko$$ExternalSyntheticLambda1
                                    public final Object invoke(Object obj5) {
                                        return Anineko.load$lambda$2$2(showStatus42, showStatus40, description, showStatus43, rating, runtime, airDateUtc, (Episode) obj5);
                                    }
                                }));
                            }
                        }
                    } else {
                        showStatus38 = showStatus26;
                        url6 = url4;
                        tvType6 = tvType3;
                        $this$forEach$iv2 = $this$forEach$iv;
                    }
                    showStatus26 = showStatus38;
                    doc2 = doc16;
                    url4 = url6;
                    tvType3 = tvType6;
                    $this$forEach$iv = $this$forEach$iv2;
                }
                Document doc17 = doc2;
                ShowStatus showStatus418 = showStatus26;
                String url16 = url4;
                TvType tvType17 = tvType3;
                metaAnimeData = (MetaAnimeData) animeMetaData2.element;
                if (metaAnimeData != null) {
                    showStatus37 = showStatus19;
                } else {
                    showStatus37 = showStatus19;
                }
                C00023 c00028 = new C00023(showStatus25, showStatus37, showStatus24, showStatus22, tags3, showStatus23, anilistId3, subEpisodes, dubEpisodes, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url16);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(doc17);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(showStatus418);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(showStatus18);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(showStatus25);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(showStatus11);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(showStatus19);
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(showStatus22);
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(tags3);
                c00012.L$9 = SpillingKt.nullOutSpilledVariable(showStatus24);
                c00012.L$10 = SpillingKt.nullOutSpilledVariable(showStatus21);
                c00012.L$11 = SpillingKt.nullOutSpilledVariable(tvType17);
                c00012.L$12 = SpillingKt.nullOutSpilledVariable(showStatus20);
                c00012.L$13 = SpillingKt.nullOutSpilledVariable(showStatus23);
                c00012.L$14 = SpillingKt.nullOutSpilledVariable(showStatus12);
                c00012.L$15 = SpillingKt.nullOutSpilledVariable(anilistId3);
                c00012.L$16 = SpillingKt.nullOutSpilledVariable(animeMetaData2);
                c00012.L$17 = SpillingKt.nullOutSpilledVariable(subEpisodes);
                c00012.L$18 = SpillingKt.nullOutSpilledVariable(dubEpisodes);
                c00012.L$19 = SpillingKt.nullOutSpilledVariable(showStatus37);
                c00012.label = 4;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, showStatus418, url16, tvType17, false, c00028, c00012, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj) {
                    return obj;
                }
                return objNewAnimeLoadResponse$default;
            case 4:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$2$1(String $finalName, Integer $epNum, String $description, String $thumbnail, String $rating, Integer $runtime, String $airDate, Episode $this$newEpisode) {
        $this$newEpisode.setName($finalName);
        $this$newEpisode.setEpisode($epNum);
        $this$newEpisode.setDescription($description);
        $this$newEpisode.setPosterUrl($thumbnail);
        $this$newEpisode.setScore(Score.Companion.from10($rating));
        $this$newEpisode.setRunTime($runtime);
        MainAPIKt.addDate$default($this$newEpisode, $airDate, (String) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$2$2(String $finalName, Integer $epNum, String $description, String $thumbnail, String $rating, Integer $runtime, String $airDate, Episode $this$newEpisode) {
        $this$newEpisode.setName($finalName);
        $this$newEpisode.setEpisode($epNum);
        $this$newEpisode.setDescription($description);
        $this$newEpisode.setPosterUrl($thumbnail);
        $this$newEpisode.setScore(Score.Companion.from10($rating));
        $this$newEpisode.setRunTime($runtime);
        MainAPIKt.addDate$default($this$newEpisode, $airDate, (String) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.anineko.Anineko$load$3 */
    /* JADX INFO: compiled from: Anineko.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/AnimeLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.anineko.Anineko$load$3", f = "Anineko.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00023 extends SuspendLambda implements Function2<AnimeLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ Integer $anilistId;
        final /* synthetic */ List<Episode> $dubEpisodes;
        final /* synthetic */ String $fanartUrl;
        final /* synthetic */ String $plot;
        final /* synthetic */ String $poster;
        final /* synthetic */ ShowStatus $showStatus;
        final /* synthetic */ List<Episode> $subEpisodes;
        final /* synthetic */ List<String> $tags;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00023(String str, String str2, Integer num, String str3, List<String> list, ShowStatus showStatus, Integer num2, List<Episode> list2, List<Episode> list3, Continuation<? super C00023> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$fanartUrl = str2;
            this.$year = num;
            this.$plot = str3;
            this.$tags = list;
            this.$showStatus = showStatus;
            this.$anilistId = num2;
            this.$subEpisodes = list2;
            this.$dubEpisodes = list3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00023 = new C00023(this.$poster, this.$fanartUrl, this.$year, this.$plot, this.$tags, this.$showStatus, this.$anilistId, this.$subEpisodes, this.$dubEpisodes, continuation);
            c00023.L$0 = obj;
            return c00023;
        }

        public final Object invoke(AnimeLoadResponse animeLoadResponse, Continuation<? super Unit> continuation) {
            return create(animeLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            LoadResponse loadResponse = (AnimeLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    loadResponse.setPosterUrl(this.$poster);
                    loadResponse.setBackgroundPosterUrl(this.$fanartUrl);
                    loadResponse.setYear(this.$year);
                    loadResponse.setPlot(this.$plot);
                    loadResponse.setTags(this.$tags);
                    loadResponse.setShowStatus(this.$showStatus);
                    if (this.$anilistId != null) {
                        LoadResponse.Companion.addAniListId(loadResponse, this.$anilistId);
                    }
                    if (!this.$subEpisodes.isEmpty()) {
                        MainAPIKt.addEpisodes(loadResponse, DubStatus.Subbed, this.$subEpisodes);
                    }
                    if (!this.$dubEpisodes.isEmpty()) {
                        MainAPIKt.addEpisodes(loadResponse, DubStatus.Dubbed, this.$dubEpisodes);
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0136  */
    /* JADX WARN: Code duplicated, block: B:26:0x0151  */
    /* JADX WARN: Code duplicated, block: B:28:0x0177  */
    /* JADX WARN: Code duplicated, block: B:29:0x018d  */
    /* JADX WARN: Code duplicated, block: B:31:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:32:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:34:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:37:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:40:0x021b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:41:0x021c  */
    /* JADX WARN: Code duplicated, block: B:46:0x01ac A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00031 c00031;
        List parts;
        boolean z;
        Object obj;
        C00031 c00032;
        String data2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        String url;
        String url2;
        boolean isCasting2;
        Document doc;
        Elements panels;
        Elements panels2;
        Document doc2;
        String audioType;
        String url3;
        List targetPanels;
        C00042 c00042;
        Iterable $this$filter$iv;
        Collection destination$iv$iv;
        String dataId;
        Document doc3;
        String audioType2;
        String url4;
        boolean zContains$default;
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
        Object $result = c00031.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00031.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                List parts2 = StringsKt.split$default(data, new String[]{"|"}, false, 0, 6, (Object) null);
                String url5 = (String) parts2.get(0);
                String audioType3 = (String) CollectionsKt.getOrNull(parts2, 1);
                if (audioType3 == null) {
                    audioType3 = "sub";
                }
                Requests app = MainActivityKt.getApp();
                c00031.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00031.L$1 = function1;
                c00031.L$2 = function2;
                c00031.L$3 = SpillingKt.nullOutSpilledVariable(parts2);
                c00031.L$4 = SpillingKt.nullOutSpilledVariable(url5);
                c00031.L$5 = audioType3;
                c00031.Z$0 = isCasting;
                c00031.label = 1;
                String audioType4 = audioType3;
                parts = parts2;
                z = true;
                C00031 c00033 = c00031;
                obj = coroutine_suspended;
                $result = Requests.get$default(app, url5, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00033, 4094, (Object) null);
                c00032 = c00033;
                if ($result == obj) {
                    return obj;
                }
                data2 = data;
                function3 = function1;
                function4 = function2;
                url = url5;
                url2 = audioType4;
                isCasting2 = isCasting;
                doc = ((NiceResponse) $result).getDocument();
                panels = doc.select(".nv-server-grid");
                if (!((Collection) panels).isEmpty()) {
                    $this$filter$iv = (Iterable) panels;
                    destination$iv$iv = new ArrayList();
                    for (Object element$iv$iv : $this$filter$iv) {
                        Element it = (Element) element$iv$iv;
                        Iterable $this$filter$iv2 = $this$filter$iv;
                        Elements panels3 = panels;
                        dataId = it.attr("data-id").toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(dataId, "toLowerCase(...)");
                        if (Intrinsics.areEqual(url2, "dub")) {
                            doc3 = doc;
                            audioType2 = url2;
                            url4 = url;
                            zContains$default = StringsKt.contains$default(dataId, "dub", false, 2, (Object) null);
                        } else {
                            doc3 = doc;
                            audioType2 = url2;
                            url4 = url;
                            if (StringsKt.contains$default(dataId, "dub", false, 2, (Object) null)) {
                                zContains$default = false;
                            } else {
                                zContains$default = true;
                            }
                        }
                        if (zContains$default) {
                            destination$iv$iv.add(element$iv$iv);
                        }
                        $this$filter$iv = $this$filter$iv2;
                        panels = panels3;
                        url2 = audioType2;
                        doc = doc3;
                        url = url4;
                    }
                    panels2 = panels;
                    doc2 = doc;
                    audioType = url2;
                    url3 = url;
                    targetPanels = (List) destination$iv$iv;
                } else {
                    panels2 = panels;
                    doc2 = doc;
                    audioType = url2;
                    url3 = url;
                    targetPanels = CollectionsKt.listOf(doc2);
                }
                c00042 = new C00042(function3, this, function4, null);
                c00032.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                c00032.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                c00032.L$3 = SpillingKt.nullOutSpilledVariable(parts);
                c00032.L$4 = SpillingKt.nullOutSpilledVariable(url3);
                c00032.L$5 = SpillingKt.nullOutSpilledVariable(audioType);
                c00032.L$6 = SpillingKt.nullOutSpilledVariable(doc2);
                c00032.L$7 = SpillingKt.nullOutSpilledVariable(panels2);
                c00032.L$8 = SpillingKt.nullOutSpilledVariable(targetPanels);
                c00032.Z$0 = isCasting2;
                c00032.label = 2;
                if (ParCollectionsKt.amap(targetPanels, c00042, c00032) == obj) {
                    return obj;
                }
                return Boxing.boxBoolean(z);
            case 1:
                isCasting2 = c00031.Z$0;
                String audioType5 = (String) c00031.L$5;
                String url6 = (String) c00031.L$4;
                List parts3 = (List) c00031.L$3;
                function4 = (Function1) c00031.L$2;
                function3 = (Function1) c00031.L$1;
                data2 = (String) c00031.L$0;
                ResultKt.throwOnFailure($result);
                c00032 = c00031;
                obj = coroutine_suspended;
                parts = parts3;
                z = true;
                url = url6;
                url2 = audioType5;
                doc = ((NiceResponse) $result).getDocument();
                panels = doc.select(".nv-server-grid");
                if (!((Collection) panels).isEmpty()) {
                    $this$filter$iv = (Iterable) panels;
                    destination$iv$iv = new ArrayList();
                    while (r18.hasNext()) {
                        Element it2 = (Element) element$iv$iv;
                        Iterable $this$filter$iv3 = $this$filter$iv;
                        Elements panels4 = panels;
                        dataId = it2.attr("data-id").toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(dataId, "toLowerCase(...)");
                        if (Intrinsics.areEqual(url2, "dub")) {
                            doc3 = doc;
                            audioType2 = url2;
                            url4 = url;
                            zContains$default = StringsKt.contains$default(dataId, "dub", false, 2, (Object) null);
                        } else {
                            doc3 = doc;
                            audioType2 = url2;
                            url4 = url;
                            if (StringsKt.contains$default(dataId, "dub", false, 2, (Object) null)) {
                                zContains$default = true;
                            } else {
                                zContains$default = false;
                            }
                        }
                        if (zContains$default) {
                            destination$iv$iv.add(element$iv$iv);
                        }
                        $this$filter$iv = $this$filter$iv3;
                        panels = panels4;
                        url2 = audioType2;
                        doc = doc3;
                        url = url4;
                    }
                    panels2 = panels;
                    doc2 = doc;
                    audioType = url2;
                    url3 = url;
                    targetPanels = (List) destination$iv$iv;
                } else {
                    panels2 = panels;
                    doc2 = doc;
                    audioType = url2;
                    url3 = url;
                    targetPanels = CollectionsKt.listOf(doc2);
                }
                c00042 = new C00042(function3, this, function4, null);
                c00032.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                c00032.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                c00032.L$3 = SpillingKt.nullOutSpilledVariable(parts);
                c00032.L$4 = SpillingKt.nullOutSpilledVariable(url3);
                c00032.L$5 = SpillingKt.nullOutSpilledVariable(audioType);
                c00032.L$6 = SpillingKt.nullOutSpilledVariable(doc2);
                c00032.L$7 = SpillingKt.nullOutSpilledVariable(panels2);
                c00032.L$8 = SpillingKt.nullOutSpilledVariable(targetPanels);
                c00032.Z$0 = isCasting2;
                c00032.label = 2;
                if (ParCollectionsKt.amap(targetPanels, c00042, c00032) == obj) {
                    return obj;
                }
                return Boxing.boxBoolean(z);
            case 2:
                boolean z2 = c00031.Z$0;
                ResultKt.throwOnFailure($result);
                z = true;
                return Boxing.boxBoolean(z);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.anineko.Anineko$loadLinks$2 */
    /* JADX INFO: compiled from: Anineko.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u000b\u0010\u0003\u001a\u00070\u0004¢\u0006\u0002\b\u0005H\n"}, d2 = {"<anonymous>", "", "", "panel", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.anineko.Anineko$loadLinks$2", f = "Anineko.kt", i = {0}, l = {234}, m = "invokeSuspend", n = {"panel"}, nl = {314}, s = {"L$0"}, v = 2)
    static final class C00042 extends SuspendLambda implements Function2<Element, Continuation<? super List<? extends Unit>>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ Anineko this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00042(Function1<? super SubtitleFile, Unit> function1, Anineko anineko, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00042> continuation) {
            super(2, continuation);
            this.$subtitleCallback = function1;
            this.this$0 = anineko;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00042 = new C00042(this.$subtitleCallback, this.this$0, this.$callback, continuation);
            c00042.L$0 = obj;
            return c00042;
        }

        public final Object invoke(Element element, Continuation<? super List<Unit>> continuation) {
            return create(element, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.anineko.Anineko$loadLinks$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: Anineko.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "serverBtn", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.anineko.Anineko$loadLinks$2$1", f = "Anineko.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6}, l = {243, 247, 267, 279, 283, 297, 301}, m = "invokeSuspend", n = {"serverBtn", "videoUrl", "serverName", "typeName", "subMatch", "subUrl", "subLang", "serverBtn", "videoUrl", "serverName", "typeName", "subMatch", "finalUrl", "serverBtn", "videoUrl", "serverName", "typeName", "subMatch", "finalUrl", "embedDoc", "hlsRegexes", "m3u8Url", "sourceName", "serverBtn", "videoUrl", "serverName", "typeName", "subMatch", "finalUrl", "embedDoc", "hlsRegexes", "m3u8Url", "host", "extractor", "links", "serverBtn", "videoUrl", "serverName", "typeName", "subMatch", "finalUrl", "embedDoc", "hlsRegexes", "m3u8Url", "host", "extractor", "links", "$this$forEach$iv", "element$iv", "link", "serverBtn", "videoUrl", "serverName", "typeName", "subMatch", "finalUrl", "embedDoc", "hlsRegexes", "m3u8Url", "links", "serverBtn", "videoUrl", "serverName", "typeName", "subMatch", "finalUrl", "embedDoc", "hlsRegexes", "m3u8Url", "links", "$this$forEach$iv", "element$iv", "link"}, nl = {246, 250, 271, 282, 293, 300, 311}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$15", "L$16", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$13", "L$14"}, v = 2)
        @SourceDebugExtension({"SMAP\nAnineko.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Anineko.kt\ncom/anineko/Anineko$loadLinks$2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,321:1\n2068#2,2:322\n2068#2,2:324\n2068#2,2:326\n*S KotlinDebug\n*F\n+ 1 Anineko.kt\ncom/anineko/Anineko$loadLinks$2$1\n*L\n271#1:322,2\n282#1:324,2\n300#1:326,2\n*E\n"})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<Element, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
            final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
            /* synthetic */ Object L$0;
            Object L$1;
            Object L$10;
            Object L$11;
            Object L$12;
            Object L$13;
            Object L$14;
            Object L$15;
            Object L$16;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            Object L$7;
            Object L$8;
            Object L$9;
            int label;
            final /* synthetic */ Anineko this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(Function1<? super SubtitleFile, Unit> function1, Anineko anineko, Function1<? super ExtractorLink, Unit> function2, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$subtitleCallback = function1;
                this.this$0 = anineko;
                this.$callback = function2;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$subtitleCallback, this.this$0, this.$callback, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            public final Object invoke(Element element, Continuation<? super Unit> continuation) {
                return create(element, continuation).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code duplicated, block: B:75:0x04e4  */
            /* JADX WARN: Code duplicated, block: B:77:0x0508  */
            /* JADX WARN: Code duplicated, block: B:78:0x051a  */
            /* JADX WARN: Code duplicated, block: B:81:0x052e  */
            /* JADX WARN: Code duplicated, block: B:82:0x0531  */
            /* JADX WARN: Code duplicated, block: B:85:0x05a4 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:86:0x05a5  */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r18v11 */
            /* JADX WARN: Type inference failed for: r18v7 */
            /* JADX WARN: Type inference failed for: r18v8, types: [java.lang.Object] */
            /* JADX WARN: Type inference failed for: r20v10 */
            /* JADX WARN: Type inference failed for: r20v11 */
            /* JADX WARN: Type inference failed for: r20v14 */
            /* JADX WARN: Type inference failed for: r6v10, types: [com.anineko.Anineko$loadLinks$2$1$extractor$1, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r6v12 */
            /* JADX WARN: Type inference failed for: r6v23 */
            /* JADX WARN: Type inference failed for: r6v47 */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:107:0x073b -> B:108:0x0752). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:86:0x05a5 -> B:87:0x05bc). Please report as a decompilation issue!!! */
            /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
                java.lang.StackOverflowError
                	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
                	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
                */
            public final java.lang.Object invokeSuspend(java.lang.Object r35) {
                /*
                    Method dump skipped, instruction units count: 1942
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.anineko.Anineko.C00042.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            static final Unit invokeSuspend$lambda$0(List $links, ExtractorLink link) {
                $links.add(link);
                return Unit.INSTANCE;
            }

            static final Unit invokeSuspend$lambda$2(List $links, ExtractorLink link) {
                $links.add(link);
                return Unit.INSTANCE;
            }
        }

        public final Object invokeSuspend(Object $result) {
            Element panel = (Element) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(panel);
                    this.label = 1;
                    Object objAmap = ParCollectionsKt.amap(panel.select(".server-video"), new AnonymousClass1(this.$subtitleCallback, this.this$0, this.$callback, null), (Continuation) this);
                    if (objAmap == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return objAmap;
                case 1:
                    ResultKt.throwOnFailure($result);
                    return $result;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
