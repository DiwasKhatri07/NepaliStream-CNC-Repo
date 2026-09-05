package com.Desicinemas;

import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainPageData;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.ParCollectionsKt;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvSeriesSearchResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: BollyzoneProvider.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Desicinemas/classes.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0018\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0096@¢\u0006\u0002\u0010\u001fJ\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u00162\u0006\u0010\"\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010#J\u0014\u0010$\u001a\u00020%*\u00020&2\u0006\u0010\u0012\u001a\u00020\nH\u0002J\u000e\u0010'\u001a\u0004\u0018\u00010!*\u00020&H\u0002J\u0018\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010#JF\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020,2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u000202002\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020200H\u0096@¢\u0006\u0002\u00105J\f\u00106\u001a\u00020\n*\u00020&H\u0002R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u00067"}, d2 = {"Lcom/Desicinemas/BollyzoneProvider;", "Lcom/Desicinemas/DesicinemasProvider;", "<init>", "()V", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "lang", "", "getLang", "()Ljava/lang/String;", "setLang", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "name", "getName", "setName", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toHomePageList", "Lcom/lagradost/cloudstream3/HomePageList;", "Lorg/jsoup/nodes/Element;", "toHomePageResult", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getImageAttr", "Desicinemas"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBollyzoneProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BollyzoneProvider.kt\ncom/Desicinemas/BollyzoneProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,225:1\n777#2:226\n873#2,2:227\n296#2,2:229\n1795#2,10:231\n2068#2:241\n2069#2:243\n1805#2:244\n1960#2,3:245\n1795#2,10:248\n2068#2:258\n2069#2:260\n1805#2:261\n1795#2,10:262\n2068#2:272\n2069#2:274\n1805#2:275\n1739#2:276\n1814#2,3:277\n1795#2,10:280\n2068#2:290\n2069#2:292\n1805#2:293\n1544#2:294\n1633#2,2:295\n1795#2,10:297\n2068#2:307\n2069#2:310\n1805#2:311\n1635#2,3:312\n1#3:242\n1#3:259\n1#3:273\n1#3:291\n1#3:308\n1#3:309\n*S KotlinDebug\n*F\n+ 1 BollyzoneProvider.kt\ncom/Desicinemas/BollyzoneProvider\n*L\n39#1:226\n39#1:227,2\n46#1:229,2\n56#1:231,10\n56#1:241\n56#1:243\n56#1:244\n63#1:245,3\n76#1:248,10\n76#1:258\n76#1:260\n76#1:261\n81#1:262,10\n81#1:272\n81#1:274\n81#1:275\n118#1:276\n118#1:277,3\n121#1:280,10\n121#1:290\n121#1:292\n121#1:293\n126#1:294\n126#1:295,2\n130#1:297,10\n130#1:307\n130#1:310\n130#1:311\n126#1:312,3\n56#1:242\n76#1:259\n81#1:273\n121#1:291\n130#1:309\n*E\n"})
public final class BollyzoneProvider extends DesicinemasProvider {

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(TvType.TvSeries);

    @NotNull
    private String lang = "hi";

    @NotNull
    private String mainUrl = "https://www.bollyzone.to";

    @NotNull
    private String name = "Bollyzone";

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to(getProxy() + "?url=" + getMainUrl() + "/series/", "Episodes"), TuplesKt.to(getProxy() + "?url=" + getMainUrl() + "/tv-channels/", "Series")});

    /* JADX INFO: renamed from: com.Desicinemas.BollyzoneProvider$getMainPage$1 */
    /* JADX INFO: compiled from: BollyzoneProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Desicinemas.BollyzoneProvider", f = "BollyzoneProvider.kt", i = {0, 0, 0}, l = {35}, m = "getMainPage", n = {"request", "url", "page"}, nl = {37}, s = {"L$0", "L$1", "I$0"}, v = 2)
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
            return BollyzoneProvider.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Desicinemas.BollyzoneProvider$load$1 */
    /* JADX INFO: compiled from: BollyzoneProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Desicinemas.BollyzoneProvider", f = "BollyzoneProvider.kt", i = {0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {100, 107, 128, 144}, m = "load", n = {"url", "url", "doc", "title", "posterUrl", "url", "doc", "title", "posterUrl", "description", "tags", "dateRegex", "$this$flatMap$iv", "$this$flatMapTo$iv$iv", "destination$iv$iv", "element$iv$iv", "pageUrl", "lastPageNumber", "page", "url", "doc", "title", "posterUrl", "description", "tags", "dateRegex", "episodes", "lastPageNumber"}, nl = {103, 115, 130, -1}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
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
            return BollyzoneProvider.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Desicinemas.BollyzoneProvider$loadLinks$1 */
    /* JADX INFO: compiled from: BollyzoneProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Desicinemas.BollyzoneProvider", f = "BollyzoneProvider.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {157, 159}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "isCasting", "data", "subtitleCallback", "callback", "isCasting"}, nl = {158, 214}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "Z$0"}, v = 2)
    static final class C00041 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
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
            return BollyzoneProvider.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Desicinemas.BollyzoneProvider$search$1 */
    /* JADX INFO: compiled from: BollyzoneProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Desicinemas.BollyzoneProvider", f = "BollyzoneProvider.kt", i = {0, 0, 1, 1, 1}, l = {70, 72}, m = "search", n = {"query", "url", "query", "url", "<unused var>"}, nl = {71, 69}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"}, v = 2)
    static final class C00061 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00061(Continuation<? super C00061> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BollyzoneProvider.this.search(null, (Continuation) this);
        }
    }

    @Override // com.Desicinemas.DesicinemasProvider
    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    @Override // com.Desicinemas.DesicinemasProvider
    @NotNull
    public String getLang() {
        return this.lang;
    }

    @Override // com.Desicinemas.DesicinemasProvider
    public void setLang(@NotNull String str) {
        this.lang = str;
    }

    @Override // com.Desicinemas.DesicinemasProvider
    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    @Override // com.Desicinemas.DesicinemasProvider
    public void setMainUrl(@NotNull String str) {
        this.mainUrl = str;
    }

    @Override // com.Desicinemas.DesicinemasProvider
    @NotNull
    public String getName() {
        return this.name;
    }

    @Override // com.Desicinemas.DesicinemasProvider
    public void setName(@NotNull String str) {
        this.name = str;
    }

    @Override // com.Desicinemas.DesicinemasProvider
    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01ab A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:96:0x019b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:98:0x0199 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:99:0x01b0 A[SYNTHETIC] */
    @Override // com.Desicinemas.DesicinemasProvider
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00001 c00001;
        String url;
        boolean hasNext;
        String strText;
        String sectionName;
        Object element$iv;
        Element movieListDiv;
        HomePageList list;
        Element it;
        int page2 = page;
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
                String url2 = page2 == 1 ? request.getData() : request.getData() + "page/" + page2 + '/';
                Requests app = UtilsKt.getApp();
                String str = getMainUrl() + '/';
                c00001.L$0 = SpillingKt.nullOutSpilledVariable(request);
                c00001.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                c00001.I$0 = page2;
                c00001.label = 1;
                url = url2;
                $result = Requests.get$default(app, url, (Map) null, str, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00001, 4090, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                page2 = c00001.I$0;
                url = (String) c00001.L$1;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document doc = ((NiceResponse) $result).getDocument();
        List homePageList = new ArrayList();
        Iterable $this$filter$iv = doc.select("h2.Title");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            Element it2 = (Element) element$iv$iv;
            int page3 = page2;
            String url3 = url;
            if (StringsKt.contains(it2.text(), "Shows", true)) {
                destination$iv$iv.add(element$iv$iv);
            }
            page2 = page3;
            url = url3;
        }
        List<Element> headers = (List) destination$iv$iv;
        for (Element header : headers) {
            Element elementSelectFirst = header.selectFirst("a");
            if (elementSelectFirst != null && (strText = elementSelectFirst.text()) != null && (sectionName = StringsKt.trim(strText).toString()) != null) {
                Iterable $this$firstOrNull$iv = header.nextElementSiblings();
                Iterator it3 = $this$firstOrNull$iv.iterator();
                do {
                    if (it3.hasNext()) {
                        element$iv = it3.next();
                        it = (Element) element$iv;
                    } else {
                        element$iv = null;
                    }
                    movieListDiv = (Element) element$iv;
                    if (movieListDiv == null) {
                        list = toHomePageList(movieListDiv, sectionName);
                        if (!list.getList().isEmpty()) {
                            homePageList.add(list);
                        }
                    }
                } while (!(Intrinsics.areEqual(it.tagName(), "div") && it.hasClass("MovieListTop")));
                movieListDiv = (Element) element$iv;
                if (movieListDiv == null) {
                    list = toHomePageList(movieListDiv, sectionName);
                    if (!list.getList().isEmpty()) {
                        homePageList.add(list);
                    }
                }
            }
        }
        if (homePageList.isEmpty()) {
            Iterable $this$mapNotNull$iv = doc.select("ul.MovieList li.TPostMv");
            Collection destination$iv$iv2 = new ArrayList();
            for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                List headers2 = headers;
                Element it4 = (Element) element$iv$iv$iv;
                SearchResponse homePageResult = toHomePageResult(it4);
                if (homePageResult != null) {
                    destination$iv$iv2.add(homePageResult);
                }
                headers = headers2;
            }
            List fallbackItems = (List) destination$iv$iv2;
            if (!fallbackItems.isEmpty()) {
                homePageList.add(new HomePageList("Latest", fallbackItems, false, 4, (DefaultConstructorMarker) null));
            }
        }
        List $this$any$iv = homePageList;
        if (($this$any$iv instanceof Collection) && $this$any$iv.isEmpty()) {
            hasNext = false;
        } else {
            Iterator it5 = $this$any$iv.iterator();
            while (true) {
                if (it5.hasNext()) {
                    Object element$iv2 = it5.next();
                    HomePageList it6 = (HomePageList) element$iv2;
                    if (!it6.getList().isEmpty()) {
                        hasNext = true;
                    }
                } else {
                    hasNext = false;
                }
            }
        }
        return MainAPIKt.newHomePageResponse(homePageList, Boxing.boxBoolean(hasNext));
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0180 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:37:0x0181  */
    /* JADX WARN: Code duplicated, block: B:42:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:44:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:58:0x01c6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Override // com.Desicinemas.DesicinemasProvider
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        C00061 c00061;
        Object obj;
        char c;
        String url;
        Object $result;
        String query2;
        String query3;
        String url2;
        String url3;
        String query4;
        String url4;
        Document doc;
        Iterable $this$mapNotNull$iv;
        Collection destination$iv$iv;
        SearchResponse homePageResult;
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
        C00061 c00062 = c00061;
        Object $result2 = c00062.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00062.label) {
            case 0:
                ResultKt.throwOnFailure($result2);
                String url5 = getMainUrl() + "/?s=" + query;
                try {
                    Requests app = UtilsKt.getApp();
                    String str = getMainUrl() + '/';
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(query);
                    c00062.L$1 = url5;
                    c00062.label = 1;
                    obj = coroutine_suspended;
                    c = '/';
                    try {
                        Object obj2 = Requests.get$default(app, url5, (Map) null, str, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00062, 4090, (Object) null);
                        c00062 = c00062;
                        if (obj2 == obj) {
                            return obj;
                        }
                        query3 = query;
                        url2 = url5;
                        $result2 = obj2;
                        try {
                            doc = ((NiceResponse) $result2).getDocument();
                        } catch (Exception e) {
                            $result = e;
                            url = url2;
                            query2 = query3;
                            Object obj3 = $result;
                            Requests app2 = UtilsKt.getApp();
                            String str2 = getProxy() + "?url=" + url;
                            String url6 = getMainUrl() + c;
                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(query2);
                            c00062.L$1 = SpillingKt.nullOutSpilledVariable(url);
                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(obj3);
                            c00062.label = 2;
                            url3 = url;
                            $result2 = Requests.get$default(app2, str2, (Map) null, url6, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00062, 4090, (Object) null);
                            if ($result2 == obj) {
                                return obj;
                            }
                            query4 = query2;
                            url4 = url3;
                            doc = ((NiceResponse) $result2).getDocument();
                        }
                        $this$mapNotNull$iv = doc.select("ul.MovieList li.TPostMv");
                        destination$iv$iv = new ArrayList();
                        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                            Element it = (Element) element$iv$iv$iv;
                            Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                            homePageResult = toHomePageResult(it);
                            if (homePageResult != null) {
                                destination$iv$iv.add(homePageResult);
                            }
                            $this$mapNotNull$iv = $this$mapNotNull$iv2;
                        }
                        return (List) destination$iv$iv;
                    } catch (Exception e2) {
                        c00062 = c00062;
                        url = url5;
                        $result = e2;
                        query2 = query;
                        Object obj4 = $result;
                        Requests app3 = UtilsKt.getApp();
                        String str3 = getProxy() + "?url=" + url;
                        String url7 = getMainUrl() + c;
                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(query2);
                        c00062.L$1 = SpillingKt.nullOutSpilledVariable(url);
                        c00062.L$2 = SpillingKt.nullOutSpilledVariable(obj4);
                        c00062.label = 2;
                        url3 = url;
                        $result2 = Requests.get$default(app3, str3, (Map) null, url7, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00062, 4090, (Object) null);
                        if ($result2 == obj) {
                            return obj;
                        }
                        query4 = query2;
                        url4 = url3;
                        doc = ((NiceResponse) $result2).getDocument();
                        $this$mapNotNull$iv = doc.select("ul.MovieList li.TPostMv");
                        destination$iv$iv = new ArrayList();
                        while (r10.hasNext()) {
                            Element it2 = (Element) element$iv$iv$iv;
                            Iterable $this$mapNotNull$iv3 = $this$mapNotNull$iv;
                            homePageResult = toHomePageResult(it2);
                            if (homePageResult != null) {
                                destination$iv$iv.add(homePageResult);
                            }
                            $this$mapNotNull$iv = $this$mapNotNull$iv3;
                        }
                        return (List) destination$iv$iv;
                    }
                } catch (Exception e3) {
                    obj = coroutine_suspended;
                    c = '/';
                    url = url5;
                    $result = e3;
                    query2 = query;
                }
                break;
            case 1:
                url2 = (String) c00062.L$1;
                query3 = (String) c00062.L$0;
                try {
                    ResultKt.throwOnFailure($result2);
                    obj = coroutine_suspended;
                    c = '/';
                    doc = ((NiceResponse) $result2).getDocument();
                } catch (Exception e4) {
                    obj = coroutine_suspended;
                    url = url2;
                    c = '/';
                    $result = e4;
                    query2 = query3;
                    Object obj5 = $result;
                    Requests app4 = UtilsKt.getApp();
                    String str4 = getProxy() + "?url=" + url;
                    String url8 = getMainUrl() + c;
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(query2);
                    c00062.L$1 = SpillingKt.nullOutSpilledVariable(url);
                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(obj5);
                    c00062.label = 2;
                    url3 = url;
                    $result2 = Requests.get$default(app4, str4, (Map) null, url8, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00062, 4090, (Object) null);
                    if ($result2 == obj) {
                        return obj;
                    }
                    query4 = query2;
                    url4 = url3;
                    doc = ((NiceResponse) $result2).getDocument();
                    $this$mapNotNull$iv = doc.select("ul.MovieList li.TPostMv");
                    destination$iv$iv = new ArrayList();
                    while (r10.hasNext()) {
                        Element it3 = (Element) element$iv$iv$iv;
                        Iterable $this$mapNotNull$iv4 = $this$mapNotNull$iv;
                        homePageResult = toHomePageResult(it3);
                        if (homePageResult != null) {
                            destination$iv$iv.add(homePageResult);
                        }
                        $this$mapNotNull$iv = $this$mapNotNull$iv4;
                    }
                    return (List) destination$iv$iv;
                }
                $this$mapNotNull$iv = doc.select("ul.MovieList li.TPostMv");
                destination$iv$iv = new ArrayList();
                while (r10.hasNext()) {
                    Element it4 = (Element) element$iv$iv$iv;
                    Iterable $this$mapNotNull$iv5 = $this$mapNotNull$iv;
                    homePageResult = toHomePageResult(it4);
                    if (homePageResult != null) {
                        destination$iv$iv.add(homePageResult);
                    }
                    $this$mapNotNull$iv = $this$mapNotNull$iv5;
                }
                return (List) destination$iv$iv;
            case 2:
                url4 = (String) c00062.L$1;
                query4 = (String) c00062.L$0;
                ResultKt.throwOnFailure($result2);
                doc = ((NiceResponse) $result2).getDocument();
                $this$mapNotNull$iv = doc.select("ul.MovieList li.TPostMv");
                destination$iv$iv = new ArrayList();
                while (r10.hasNext()) {
                    Element it5 = (Element) element$iv$iv$iv;
                    Iterable $this$mapNotNull$iv6 = $this$mapNotNull$iv;
                    homePageResult = toHomePageResult(it5);
                    if (homePageResult != null) {
                        destination$iv$iv.add(homePageResult);
                    }
                    $this$mapNotNull$iv = $this$mapNotNull$iv6;
                }
                return (List) destination$iv$iv;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final HomePageList toHomePageList(Element $this$toHomePageList, String name) {
        Iterable $this$mapNotNull$iv = $this$toHomePageList.select("div.TPostMv");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element it = (Element) element$iv$iv$iv;
            SearchResponse homePageResult = toHomePageResult(it);
            if (homePageResult != null) {
                destination$iv$iv.add(homePageResult);
            }
        }
        List items = (List) destination$iv$iv;
        return new HomePageList(name, items, false, 4, (DefaultConstructorMarker) null);
    }

    private final SearchResponse toHomePageResult(Element $this$toHomePageResult) {
        String strText;
        String title;
        Element elementSelectFirst = $this$toHomePageResult.selectFirst("h2.Title");
        if (elementSelectFirst == null || (strText = elementSelectFirst.text()) == null || (title = StringsKt.trim(strText).toString()) == null) {
            return null;
        }
        BollyzoneProvider bollyzoneProvider = this;
        Element elementSelectFirst2 = $this$toHomePageResult.selectFirst("a");
        String href = MainAPIKt.fixUrlNull(bollyzoneProvider, elementSelectFirst2 != null ? elementSelectFirst2.attr("href") : null);
        if (href == null) {
            return null;
        }
        Element img = $this$toHomePageResult.selectFirst("img");
        final String posterUrl = MainAPIKt.fixUrlNull(this, img != null ? getImageAttr(img) : null);
        return MainAPIKt.newTvSeriesSearchResponse$default(this, title, href, (TvType) null, false, new Function1() { // from class: com.Desicinemas.BollyzoneProvider$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return BollyzoneProvider.toHomePageResult$lambda$0(posterUrl, (TvSeriesSearchResponse) obj);
            }
        }, 12, (Object) null);
    }

    static final Unit toHomePageResult$lambda$0(String $posterUrl, TvSeriesSearchResponse $this$newTvSeriesSearchResponse) {
        $this$newTvSeriesSearchResponse.setPosterUrl($posterUrl);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x047e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x0305  */
    /* JADX WARN: Code duplicated, block: B:65:0x03a1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:66:0x03a2  */
    /* JADX WARN: Code duplicated, block: B:70:0x03e2  */
    /* JADX WARN: Code duplicated, block: B:72:0x040d  */
    /* JADX WARN: Code duplicated, block: B:73:0x0413  */
    /* JADX WARN: Code duplicated, block: B:75:0x041b  */
    /* JADX WARN: Code duplicated, block: B:78:0x042c  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:80:0x042f  */
    /* JADX WARN: Code duplicated, block: B:81:0x0445  */
    /* JADX WARN: Code duplicated, block: B:83:0x0450  */
    /* JADX WARN: Code duplicated, block: B:85:0x0456 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:86:0x0458  */
    /* JADX WARN: Code duplicated, block: B:87:0x045b  */
    /* JADX WARN: Code duplicated, block: B:90:0x047a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x03a2 -> B:67:0x03b3). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @Override // com.Desicinemas.DesicinemasProvider
    @org.jetbrains.annotations.Nullable
    public java.lang.Object load(@org.jetbrains.annotations.NotNull java.lang.String r47, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r48) {
        /*
            Method dump skipped, instruction units count: 1350
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.Desicinemas.BollyzoneProvider.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.Desicinemas.BollyzoneProvider$load$3 */
    /* JADX INFO: compiled from: BollyzoneProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Desicinemas.BollyzoneProvider$load$3", f = "BollyzoneProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nBollyzoneProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BollyzoneProvider.kt\ncom/Desicinemas/BollyzoneProvider$load$3\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,225:1\n1739#2:226\n1814#2,3:227\n*S KotlinDebug\n*F\n+ 1 BollyzoneProvider.kt\ncom/Desicinemas/BollyzoneProvider$load$3\n*L\n110#1:226\n110#1:227,3\n*E\n"})
    static final class C00023 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ Document $doc;
        final /* synthetic */ String $posterUrl;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00023(String str, Document document, Continuation<? super C00023> continuation) {
            super(2, continuation);
            this.$posterUrl = str;
            this.$doc = document;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00023 = new C00023(this.$posterUrl, this.$doc, continuation);
            c00023.L$0 = obj;
            return c00023;
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
                    Element elementSelectFirst = this.$doc.selectFirst(".Description p");
                    $this$newTvSeriesLoadResponse.setPlot(elementSelectFirst != null ? elementSelectFirst.text() : null);
                    Iterable $this$map$iv = this.$doc.select(".Genre a");
                    Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    for (Object item$iv$iv : $this$map$iv) {
                        Element it = (Element) item$iv$iv;
                        destination$iv$iv.add(it.text());
                    }
                    $this$newTvSeriesLoadResponse.setTags((List) destination$iv$iv);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    static final Unit load$lambda$0(String $title, Episode $this$newEpisode) {
        $this$newEpisode.setName($title);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$3$0$1(String $epName, BollyzoneProvider this$0, String $epPoster, Episode $this$newEpisode) {
        $this$newEpisode.setName($epName);
        $this$newEpisode.setPosterUrl(this$0.getProxy() + "?url=" + $epPoster);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.Desicinemas.BollyzoneProvider$load$4 */
    /* JADX INFO: compiled from: BollyzoneProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Desicinemas.BollyzoneProvider$load$4", f = "BollyzoneProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00034 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $description;
        final /* synthetic */ String $posterUrl;
        final /* synthetic */ List<String> $tags;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00034(String str, String str2, List<String> list, Continuation<? super C00034> continuation) {
            super(2, continuation);
            this.$posterUrl = str;
            this.$description = str2;
            this.$tags = list;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00034 = new C00034(this.$posterUrl, this.$description, this.$tags, continuation);
            c00034.L$0 = obj;
            return c00034;
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
                    $this$newTvSeriesLoadResponse.setPlot(this.$description);
                    $this$newTvSeriesLoadResponse.setTags(this.$tags);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0115 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Override // com.Desicinemas.DesicinemasProvider
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00041 c00041;
        boolean z;
        Object obj;
        C00041 c00042;
        String data2;
        boolean isCasting2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        List listSelect;
        C00052 c00052;
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
        Object $result = c00041.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00041.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = UtilsKt.getApp();
                String str = getProxy() + "?url=" + data;
                String mainUrl = getMainUrl();
                c00041.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00041.L$1 = function1;
                c00041.L$2 = function2;
                c00041.Z$0 = isCasting;
                c00041.label = 1;
                z = true;
                C00041 c00043 = c00041;
                obj = coroutine_suspended;
                $result = Requests.get$default(app, str, (Map) null, mainUrl, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00043, 4090, (Object) null);
                c00042 = c00043;
                if ($result == obj) {
                    return obj;
                }
                data2 = data;
                isCasting2 = isCasting;
                function3 = function1;
                function4 = function2;
                listSelect = ((NiceResponse) $result).getDocument().select(".MovieList .OptionBx");
                c00052 = new C00052(function3, function4, null);
                c00042.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00042.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                c00042.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                c00042.Z$0 = isCasting2;
                c00042.label = 2;
                if (ParCollectionsKt.amap(listSelect, c00052, c00042) == obj) {
                    return obj;
                }
                return Boxing.boxBoolean(z);
            case 1:
                isCasting2 = c00041.Z$0;
                function4 = (Function1) c00041.L$2;
                function3 = (Function1) c00041.L$1;
                data2 = (String) c00041.L$0;
                ResultKt.throwOnFailure($result);
                c00042 = c00041;
                obj = coroutine_suspended;
                z = true;
                listSelect = ((NiceResponse) $result).getDocument().select(".MovieList .OptionBx");
                c00052 = new C00052(function3, function4, null);
                c00042.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00042.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                c00042.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                c00042.Z$0 = isCasting2;
                c00042.label = 2;
                if (ParCollectionsKt.amap(listSelect, c00052, c00042) == obj) {
                    return obj;
                }
                return Boxing.boxBoolean(z);
            case 2:
                boolean z2 = c00041.Z$0;
                ResultKt.throwOnFailure($result);
                z = true;
                return Boxing.boxBoolean(z);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.Desicinemas.BollyzoneProvider$loadLinks$2 */
    /* JADX INFO: compiled from: BollyzoneProvider.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "it", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Desicinemas.BollyzoneProvider$loadLinks$2", f = "BollyzoneProvider.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3}, l = {173, 180, 194, 205}, m = "invokeSuspend", n = {"it", "name", "link", "headers", "it", "name", "link", "headers", "src", "doc", "iframe", "it", "name", "link", "headers", "src", "doc", "iframe", "iframeURL", "pathParts", "token", "type", "playerUrl", "it", "name", "link", "headers", "src", "doc", "iframe", "iframeURL"}, nl = {174, 183, 201, 212}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"}, v = 2)
    static final class C00052 extends SuspendLambda implements Function2<Element, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00052(Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00052> continuation) {
            super(2, continuation);
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00052 = BollyzoneProvider.this.new C00052(this.$subtitleCallback, this.$callback, continuation);
            c00052.L$0 = obj;
            return c00052;
        }

        public final Object invoke(Element element, Continuation<? super Unit> continuation) {
            return create(element, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:16:0x015b  */
        /* JADX WARN: Code duplicated, block: B:17:0x0160  */
        /* JADX WARN: Code duplicated, block: B:19:0x0163  */
        /* JADX WARN: Code duplicated, block: B:22:0x018f A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:23:0x0190  */
        /* JADX WARN: Code duplicated, block: B:26:0x019c  */
        /* JADX WARN: Code duplicated, block: B:28:0x01a4  */
        /* JADX WARN: Code duplicated, block: B:29:0x01ab  */
        /* JADX WARN: Code duplicated, block: B:30:0x01ae A[PHI: r4
          0x01ae: PHI (r4v7 java.lang.String) = (r4v6 java.lang.String), (r4v14 java.lang.String) binds: [B:25:0x019a, B:28:0x01a4] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:33:0x01b7  */
        /* JADX WARN: Code duplicated, block: B:37:0x01c0  */
        /* JADX WARN: Code duplicated, block: B:39:0x01c3  */
        /* JADX WARN: Code duplicated, block: B:41:0x01cc  */
        /* JADX WARN: Code duplicated, block: B:43:0x01cf  */
        /* JADX WARN: Code duplicated, block: B:45:0x01f5  */
        /* JADX WARN: Code duplicated, block: B:47:0x01f8  */
        /* JADX WARN: Code duplicated, block: B:49:0x0294 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:50:0x0295  */
        /* JADX WARN: Code duplicated, block: B:53:0x02a4  */
        /* JADX WARN: Code duplicated, block: B:55:0x02fb A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:56:0x02fc  */
        public final Object invokeSuspend(Object $result) {
            String link;
            Object obj;
            String name;
            Map headers;
            NiceResponse src;
            Document doc;
            Element elementSelectFirst;
            String iframe;
            Object objResolveIframeSrc;
            Map headers2;
            String iframe2;
            Document doc2;
            String name2;
            String strAttr;
            String str;
            String iframeURL;
            String str2;
            boolean z;
            List pathParts;
            String playerUrl;
            Element elementSelectFirst2;
            Element it = (Element) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String name3 = it.select("p.AAIco-dns").text();
                    link = it.select("a").attr("href");
                    Map headers3 = MapsKt.mapOf(new Pair[]{TuplesKt.to("referer", BollyzoneProvider.this.getMainUrl()), TuplesKt.to("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:139.0) Gecko/20100101 Firefox/139.0"), TuplesKt.to("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8"), TuplesKt.to("Accept-Language", "en-US,en;q=0.5"), TuplesKt.to("Connection", "keep-alive"), TuplesKt.to("Cache-Control", "no-cache")});
                    this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                    this.L$1 = name3;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(link);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(headers3);
                    this.label = 1;
                    obj = Requests.get$default(UtilsKt.getApp(), link, headers3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4092, (Object) null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    name = name3;
                    headers = headers3;
                    src = (NiceResponse) obj;
                    doc = src.getDocument();
                    elementSelectFirst = doc.selectFirst("#Proceed a[href], a.button.button1, a.button1");
                    if (elementSelectFirst != null) {
                        iframe = elementSelectFirst.attr("href");
                    } else {
                        iframe = null;
                    }
                    if (iframe == null) {
                        iframe = "";
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                    this.L$1 = name;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(link);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(headers);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(src);
                    this.L$5 = doc;
                    this.L$6 = iframe;
                    this.label = 2;
                    objResolveIframeSrc = UtilsKt.resolveIframeSrc(iframe, (Continuation) this);
                    if (objResolveIframeSrc == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    headers2 = headers;
                    iframe2 = iframe;
                    doc2 = doc;
                    name2 = name;
                    strAttr = (String) objResolveIframeSrc;
                    if (strAttr != null) {
                        str = strAttr;
                    } else {
                        elementSelectFirst2 = doc2.selectFirst("IFRAME");
                        if (elementSelectFirst2 != null) {
                            strAttr = elementSelectFirst2.attr("src");
                            str = strAttr;
                        } else {
                            str = null;
                        }
                    }
                    iframeURL = str;
                    str2 = iframeURL;
                    if (str2 != null || StringsKt.isBlank(str2)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(name2);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(link);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(headers2);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(src);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(doc2);
                        this.L$6 = SpillingKt.nullOutSpilledVariable(iframe2);
                        this.L$7 = SpillingKt.nullOutSpilledVariable(iframeURL);
                        this.label = 4;
                        if (UtilsKt.loadSourceNameExtractor$default(name2, iframeURL, BollyzoneProvider.this.getMainUrl(), this.$subtitleCallback, this.$callback, null, null, (Continuation) this, 96, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    if (StringsKt.isBlank(iframe2)) {
                        return Unit.INSTANCE;
                    }
                    pathParts = StringsKt.split$default(StringsKt.trimEnd(iframe2, new char[]{'/'}), new char[]{'/'}, false, 0, 6, (Object) null);
                    if (pathParts.size() < 2) {
                        return Unit.INSTANCE;
                    }
                    String token = (String) CollectionsKt.last(pathParts);
                    String type = (String) CollectionsKt.last(CollectionsKt.dropLast(pathParts, 1));
                    playerUrl = "https://flow.tvlogy.to/" + type + '/' + token + '/';
                    this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(name2);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(link);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(headers2);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(src);
                    this.L$5 = SpillingKt.nullOutSpilledVariable(doc2);
                    this.L$6 = SpillingKt.nullOutSpilledVariable(iframe2);
                    this.L$7 = SpillingKt.nullOutSpilledVariable(iframeURL);
                    this.L$8 = SpillingKt.nullOutSpilledVariable(pathParts);
                    this.L$9 = SpillingKt.nullOutSpilledVariable(token);
                    this.L$10 = SpillingKt.nullOutSpilledVariable(type);
                    this.L$11 = SpillingKt.nullOutSpilledVariable(playerUrl);
                    this.label = 3;
                    if (UtilsKt.loadSourceNameExtractor$default(name2, playerUrl, BollyzoneProvider.this.getMainUrl(), this.$subtitleCallback, this.$callback, null, null, (Continuation) this, 96, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                case 1:
                    headers = (Map) this.L$3;
                    String link2 = (String) this.L$2;
                    String name4 = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    link = link2;
                    name = name4;
                    obj = $result;
                    src = (NiceResponse) obj;
                    doc = src.getDocument();
                    elementSelectFirst = doc.selectFirst("#Proceed a[href], a.button.button1, a.button1");
                    if (elementSelectFirst != null) {
                        iframe = elementSelectFirst.attr("href");
                    } else {
                        iframe = null;
                    }
                    if (iframe == null) {
                        iframe = "";
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                    this.L$1 = name;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(link);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(headers);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(src);
                    this.L$5 = doc;
                    this.L$6 = iframe;
                    this.label = 2;
                    objResolveIframeSrc = UtilsKt.resolveIframeSrc(iframe, (Continuation) this);
                    if (objResolveIframeSrc == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    headers2 = headers;
                    iframe2 = iframe;
                    doc2 = doc;
                    name2 = name;
                    strAttr = (String) objResolveIframeSrc;
                    if (strAttr != null) {
                        str = strAttr;
                    } else {
                        elementSelectFirst2 = doc2.selectFirst("IFRAME");
                        if (elementSelectFirst2 != null) {
                            strAttr = elementSelectFirst2.attr("src");
                            str = strAttr;
                        } else {
                            str = null;
                        }
                    }
                    iframeURL = str;
                    str2 = iframeURL;
                    if (str2 != null) {
                        z = true;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(name2);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(link);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(headers2);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(src);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(doc2);
                        this.L$6 = SpillingKt.nullOutSpilledVariable(iframe2);
                        this.L$7 = SpillingKt.nullOutSpilledVariable(iframeURL);
                        this.label = 4;
                        if (UtilsKt.loadSourceNameExtractor$default(name2, iframeURL, BollyzoneProvider.this.getMainUrl(), this.$subtitleCallback, this.$callback, null, null, (Continuation) this, 96, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    if (StringsKt.isBlank(iframe2)) {
                        return Unit.INSTANCE;
                    }
                    pathParts = StringsKt.split$default(StringsKt.trimEnd(iframe2, new char[]{'/'}), new char[]{'/'}, false, 0, 6, (Object) null);
                    if (pathParts.size() < 2) {
                        return Unit.INSTANCE;
                    }
                    String token2 = (String) CollectionsKt.last(pathParts);
                    String type2 = (String) CollectionsKt.last(CollectionsKt.dropLast(pathParts, 1));
                    playerUrl = "https://flow.tvlogy.to/" + type2 + '/' + token2 + '/';
                    this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(name2);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(link);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(headers2);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(src);
                    this.L$5 = SpillingKt.nullOutSpilledVariable(doc2);
                    this.L$6 = SpillingKt.nullOutSpilledVariable(iframe2);
                    this.L$7 = SpillingKt.nullOutSpilledVariable(iframeURL);
                    this.L$8 = SpillingKt.nullOutSpilledVariable(pathParts);
                    this.L$9 = SpillingKt.nullOutSpilledVariable(token2);
                    this.L$10 = SpillingKt.nullOutSpilledVariable(type2);
                    this.L$11 = SpillingKt.nullOutSpilledVariable(playerUrl);
                    this.label = 3;
                    if (UtilsKt.loadSourceNameExtractor$default(name2, playerUrl, BollyzoneProvider.this.getMainUrl(), this.$subtitleCallback, this.$callback, null, null, (Continuation) this, 96, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                case 2:
                    iframe2 = (String) this.L$6;
                    doc2 = (Document) this.L$5;
                    src = (NiceResponse) this.L$4;
                    headers2 = (Map) this.L$3;
                    link = (String) this.L$2;
                    String name5 = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    objResolveIframeSrc = $result;
                    name2 = name5;
                    strAttr = (String) objResolveIframeSrc;
                    if (strAttr != null) {
                        str = strAttr;
                    } else {
                        elementSelectFirst2 = doc2.selectFirst("IFRAME");
                        if (elementSelectFirst2 != null) {
                            strAttr = elementSelectFirst2.attr("src");
                            str = strAttr;
                        } else {
                            str = null;
                        }
                    }
                    iframeURL = str;
                    str2 = iframeURL;
                    if (str2 != null) {
                        z = true;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(name2);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(link);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(headers2);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(src);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(doc2);
                        this.L$6 = SpillingKt.nullOutSpilledVariable(iframe2);
                        this.L$7 = SpillingKt.nullOutSpilledVariable(iframeURL);
                        this.label = 4;
                        if (UtilsKt.loadSourceNameExtractor$default(name2, iframeURL, BollyzoneProvider.this.getMainUrl(), this.$subtitleCallback, this.$callback, null, null, (Continuation) this, 96, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    if (StringsKt.isBlank(iframe2)) {
                        return Unit.INSTANCE;
                    }
                    pathParts = StringsKt.split$default(StringsKt.trimEnd(iframe2, new char[]{'/'}), new char[]{'/'}, false, 0, 6, (Object) null);
                    if (pathParts.size() < 2) {
                        return Unit.INSTANCE;
                    }
                    String token3 = (String) CollectionsKt.last(pathParts);
                    String type3 = (String) CollectionsKt.last(CollectionsKt.dropLast(pathParts, 1));
                    playerUrl = "https://flow.tvlogy.to/" + type3 + '/' + token3 + '/';
                    this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(name2);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(link);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(headers2);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(src);
                    this.L$5 = SpillingKt.nullOutSpilledVariable(doc2);
                    this.L$6 = SpillingKt.nullOutSpilledVariable(iframe2);
                    this.L$7 = SpillingKt.nullOutSpilledVariable(iframeURL);
                    this.L$8 = SpillingKt.nullOutSpilledVariable(pathParts);
                    this.L$9 = SpillingKt.nullOutSpilledVariable(token3);
                    this.L$10 = SpillingKt.nullOutSpilledVariable(type3);
                    this.L$11 = SpillingKt.nullOutSpilledVariable(playerUrl);
                    this.label = 3;
                    if (UtilsKt.loadSourceNameExtractor$default(name2, playerUrl, BollyzoneProvider.this.getMainUrl(), this.$subtitleCallback, this.$callback, null, null, (Continuation) this, 96, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                case 3:
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                case 4:
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    private final String getImageAttr(Element $this$getImageAttr) {
        if ($this$getImageAttr.hasAttr("data-src")) {
            return $this$getImageAttr.attr("data-src");
        }
        if ($this$getImageAttr.hasAttr("src")) {
            return $this$getImageAttr.attr("src");
        }
        return $this$getImageAttr.attr("src");
    }
}
