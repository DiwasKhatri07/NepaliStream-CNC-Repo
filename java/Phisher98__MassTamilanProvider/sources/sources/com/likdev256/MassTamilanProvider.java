package com.likdev256;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.api.Log;
import com.lagradost.cloudstream3.Actor;
import com.lagradost.cloudstream3.ActorData;
import com.lagradost.cloudstream3.ActorRole;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.MainPageData;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.ParCollectionsKt;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvSeriesSearchResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.mvvm.Resource;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.Qualities;
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
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
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

/* JADX INFO: compiled from: MassTamilanProvider.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/MassTamilanProvider/classes.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u00019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u001e\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010%J\u000e\u0010&\u001a\u0004\u0018\u00010'*\u00020(H\u0002J\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020'0\u001c2\u0006\u0010*\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010+J\u0016\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010+JF\u0010/\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u000e2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u000205032\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020503H\u0096@¢\u0006\u0002\u00108R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006:"}, d2 = {"Lcom/likdev256/MassTamilanProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lorg/jsoup/nodes/Element;", "search", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "MassTamilanLinks", "MassTamilanProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMassTamilanProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MassTamilanProvider.kt\ncom/likdev256/MassTamilanProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 5 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,186:1\n1795#2,10:187\n2068#2:197\n2069#2:199\n1805#2:200\n1795#2,10:201\n2068#2:211\n2069#2:213\n1805#2:214\n1739#2:215\n1814#2,2:216\n1739#2:218\n1814#2,3:219\n1739#2:222\n1814#2,3:223\n1739#2:226\n1814#2,3:227\n1816#2:230\n1739#2:231\n1814#2,2:232\n1739#2:234\n1814#2,3:235\n1816#2:238\n1739#2:239\n1814#2,3:240\n1#3:198\n1#3:212\n1#3:244\n63#4:243\n64#4,15:245\n50#5:260\n43#5:261\n*S KotlinDebug\n*F\n+ 1 MassTamilanProvider.kt\ncom/likdev256/MassTamilanProvider\n*L\n38#1:187,10\n38#1:197\n38#1:199\n38#1:200\n60#1:201,10\n60#1:211\n60#1:213\n60#1:214\n82#1:215\n82#1:216,2\n83#1:218\n83#1:219,3\n86#1:222\n86#1:223,3\n96#1:226\n96#1:227,3\n82#1:230\n108#1:231\n108#1:232,2\n109#1:234\n109#1:235,3\n108#1:238\n130#1:239\n130#1:240,3\n38#1:198\n60#1:212\n165#1:244\n165#1:243\n165#1:245,15\n165#1:260\n165#1:261\n*E\n"})
public final class MassTamilanProvider extends MainAPI {

    @NotNull
    private String mainUrl = "https://masstamilan.dev";

    @NotNull
    private String name = "MassTamilan";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "ta";
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Music, TvType.Movie});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to(getMainUrl() + "/latest-updates", "Latest Updates"), TuplesKt.to(getMainUrl() + "/tamil-songs", "Tamil Songs"), TuplesKt.to(getMainUrl() + "/telugu-songs", "Telugu Songs"), TuplesKt.to(getMainUrl() + "/malayalam-songs", "Malayalam Songs"), TuplesKt.to(getMainUrl() + "/hindi-songs", "Hindi Songs")});

    /* JADX INFO: renamed from: com.likdev256.MassTamilanProvider$getMainPage$1 */
    /* JADX INFO: compiled from: MassTamilanProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.likdev256.MassTamilanProvider", f = "MassTamilanProvider.kt", i = {0, 0}, l = {36}, m = "getMainPage", n = {"request", "page"}, nl = {37}, s = {"L$0", "I$0"}, v = 2)
    static final class C00001 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00001(Continuation<? super C00001> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MassTamilanProvider.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.likdev256.MassTamilanProvider$load$1 */
    /* JADX INFO: compiled from: MassTamilanProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.likdev256.MassTamilanProvider", f = "MassTamilanProvider.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {72, 148}, m = "load", n = {"url", "docLink", "url", "docLink", "doc", "title", "poster", "description", "tags", "year", "actors", "episodes", "zipLinks"}, nl = {74, -1}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        Object L$0;
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
        /* synthetic */ Object result;

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MassTamilanProvider.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.likdev256.MassTamilanProvider$loadLinks$1 */
    /* JADX INFO: compiled from: MassTamilanProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.likdev256.MassTamilanProvider", f = "MassTamilanProvider.kt", i = {0, 0, 0, 0}, l = {165}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "isCasting"}, nl = {183}, s = {"L$0", "L$1", "L$2", "Z$0"}, v = 2)
    static final class C00031 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
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
            return MassTamilanProvider.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.likdev256.MassTamilanProvider$search$1 */
    /* JADX INFO: compiled from: MassTamilanProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.likdev256.MassTamilanProvider", f = "MassTamilanProvider.kt", i = {0}, l = {57}, m = "search", n = {"query"}, nl = {60}, s = {"L$0"}, v = 2)
    static final class C00051 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00051(Continuation<? super C00051> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MassTamilanProvider.this.search(null, (Continuation) this);
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
        String str;
        int page2;
        MainPageRequest request2;
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
                Requests app = MainActivityKt.getApp();
                String str2 = request.getData() + "?page=" + page;
                c00001.L$0 = request;
                c00001.I$0 = page;
                c00001.label = 1;
                str = "?page=";
                $result = Requests.get$default(app, str2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00001, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                page2 = page;
                request2 = request;
                break;
                break;
            case 1:
                int page3 = c00001.I$0;
                request2 = (MainPageRequest) c00001.L$0;
                ResultKt.throwOnFailure($result);
                page2 = page3;
                str = "?page=";
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) $result).getDocument();
        Log.INSTANCE.d("Phisher", request2.getData() + str + page2);
        Iterable $this$mapNotNull$iv = document.select("div.a-i");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element it = (Element) element$iv$iv$iv;
            SearchResponse searchResult = toSearchResult(it);
            if (searchResult != null) {
                destination$iv$iv.add(searchResult);
            }
        }
        List home = (List) destination$iv$iv;
        return MainAPIKt.newHomePageResponse(CollectionsKt.arrayListOf(new HomePageList[]{new HomePageList(request2.getName(), home, false, 4, (DefaultConstructorMarker) null)}), Boxing.boxBoolean(true));
    }

    private final SearchResponse toSearchResult(Element $this$toSearchResult) {
        String strText;
        String title;
        Element elementSelectFirst = $this$toSearchResult.selectFirst("div h2");
        if (elementSelectFirst == null || (strText = elementSelectFirst.text()) == null || (title = StringsKt.trim(strText).toString()) == null) {
            return null;
        }
        String href = MainAPIKt.fixUrl(this, getMainUrl() + $this$toSearchResult.select("a").attr("href"));
        MassTamilanProvider massTamilanProvider = this;
        Element elementSelectFirst2 = $this$toSearchResult.selectFirst("a picture img");
        final String posterUrl = MainAPIKt.fixUrlNull(massTamilanProvider, elementSelectFirst2 != null ? elementSelectFirst2.attr("src") : null);
        return MainAPIKt.newTvSeriesSearchResponse$default(this, title, href + ",," + title, TvType.TvSeries, false, new Function1() { // from class: com.likdev256.MassTamilanProvider$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return MassTamilanProvider.toSearchResult$lambda$0(posterUrl, (TvSeriesSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResult$lambda$0(String $posterUrl, TvSeriesSearchResponse $this$newTvSeriesSearchResponse) {
        $this$newTvSeriesSearchResponse.setPosterUrl($posterUrl);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        C00051 c00051;
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
                Requests app = MainActivityKt.getApp();
                String str = getMainUrl() + "/search?keyword=" + query;
                c00051.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00051.label = 1;
                $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00051, 4094, (Object) null);
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
        Document document = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = document.select("div.a-i");
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

    /* JADX INFO: compiled from: MassTamilanProvider.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0016\b\u0001\u0010\u0006\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J9\u0010\u000e\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0016\b\u0003\u0010\u0006\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/likdev256/MassTamilanProvider$MassTamilanLinks;", "", "sourceName", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "sourceLink", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getSourceName", "()Ljava/lang/String;", "getSourceLink", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "MassTamilanProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class MassTamilanLinks {

        @NotNull
        private final String sourceLink;

        @NotNull
        private final String sourceName;

        public static /* synthetic */ MassTamilanLinks copy$default(MassTamilanLinks massTamilanLinks, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = massTamilanLinks.sourceName;
            }
            if ((i & 2) != 0) {
                str2 = massTamilanLinks.sourceLink;
            }
            return massTamilanLinks.copy(str, str2);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getSourceName() {
            return this.sourceName;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getSourceLink() {
            return this.sourceLink;
        }

        @NotNull
        public final MassTamilanLinks copy(@JsonProperty("sourceName") @NotNull String sourceName, @JsonProperty("sourceLink") @NotNull String sourceLink) {
            return new MassTamilanLinks(sourceName, sourceLink);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MassTamilanLinks)) {
                return false;
            }
            MassTamilanLinks massTamilanLinks = (MassTamilanLinks) other;
            return Intrinsics.areEqual(this.sourceName, massTamilanLinks.sourceName) && Intrinsics.areEqual(this.sourceLink, massTamilanLinks.sourceLink);
        }

        public int hashCode() {
            return (this.sourceName.hashCode() * 31) + this.sourceLink.hashCode();
        }

        @NotNull
        public String toString() {
            return "MassTamilanLinks(sourceName=" + this.sourceName + ", sourceLink=" + this.sourceLink + ')';
        }

        public MassTamilanLinks(@JsonProperty("sourceName") @NotNull String sourceName, @JsonProperty("sourceLink") @NotNull String sourceLink) {
            this.sourceName = sourceName;
            this.sourceLink = sourceLink;
        }

        @NotNull
        public final String getSourceName() {
            return this.sourceName;
        }

        @NotNull
        public final String getSourceLink() {
            return this.sourceLink;
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:21:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:25:0x0159  */
    /* JADX WARN: Code duplicated, block: B:28:0x018e A[LOOP:1: B:26:0x0188->B:28:0x018e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:31:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:34:0x01f5 A[LOOP:2: B:32:0x01ef->B:34:0x01f5, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:36:0x0241  */
    /* JADX WARN: Code duplicated, block: B:39:0x0251  */
    /* JADX WARN: Code duplicated, block: B:42:0x0271 A[LOOP:3: B:40:0x026b->B:42:0x0271, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:44:0x02bf  */
    /* JADX WARN: Code duplicated, block: B:49:0x030f  */
    /* JADX WARN: Code duplicated, block: B:52:0x0343 A[LOOP:5: B:50:0x033d->B:52:0x0343, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:57:0x043f A[LOOP:6: B:55:0x0439->B:57:0x043f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:60:0x050a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:61:0x050b  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        C00011 c00011;
        Object obj;
        String url2;
        int i;
        Object obj2;
        String url3;
        String docLink;
        String title;
        Element elementSelectFirst;
        String strAttr;
        final String poster;
        Ref.ObjectRef tags;
        Ref.ObjectRef year;
        Ref.ObjectRef actors;
        Iterable $this$map$iv;
        Collection destination$iv$iv;
        final ArrayList episodes;
        Iterable $this$map$iv2;
        int $i$f$map;
        Collection destination$iv$iv2;
        Iterable $this$mapTo$iv$iv;
        int $i$f$mapTo;
        Iterator it;
        Iterable $this$map$iv3;
        int $i$f$map2;
        Collection destination$iv$iv3;
        Iterable $this$mapTo$iv$iv2;
        int $i$f$mapTo2;
        Iterable $this$map$iv4;
        Collection destination$iv$iv4;
        Iterable $this$mapTo$iv$iv3;
        int $i$f$mapTo3;
        Element me;
        Iterable $this$map$iv5;
        Collection destination$iv$iv5;
        Ref.ObjectRef year2;
        Iterable $this$map$iv6;
        int $i$f$map3;
        Collection destination$iv$iv6;
        Iterable $this$mapTo$iv$iv4;
        int $i$f$mapTo4;
        Iterable $this$map$iv7;
        int $i$f$map4;
        Collection destination$iv$iv7;
        Iterable $this$mapTo$iv$iv5;
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
                String docLink2 = StringsKt.substringBefore$default(url, ",,", (String) null, 2, (Object) null);
                Requests app = MainActivityKt.getApp();
                c00012.L$0 = url;
                c00012.L$1 = docLink2;
                c00012.label = 1;
                obj = coroutine_suspended;
                url2 = ",,";
                i = 2;
                obj2 = Requests.get$default(app, docLink2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00012, 4094, (Object) null);
                c00012 = c00012;
                if (obj2 == obj) {
                    return obj;
                }
                url3 = url;
                docLink = docLink2;
                Document doc = ((NiceResponse) obj2).getDocument();
                title = StringsKt.substringAfter$default(url3, url2, (String) null, i, (Object) null);
                MassTamilanProvider massTamilanProvider = this;
                StringBuilder sbAppend = new StringBuilder().append(getMainUrl());
                elementSelectFirst = doc.selectFirst("figure.ib > picture > img");
                if (elementSelectFirst != null) {
                    strAttr = elementSelectFirst.attr("src");
                } else {
                    strAttr = null;
                }
                poster = MainAPIKt.fixUrlNull(massTamilanProvider, sbAppend.append(strAttr).toString());
                String description = doc.select("#movie-handle").text();
                tags = new Ref.ObjectRef();
                tags.element = CollectionsKt.emptyList();
                year = new Ref.ObjectRef();
                year.element = Boxing.boxInt(0);
                actors = new Ref.ObjectRef();
                actors.element = CollectionsKt.emptyList();
                $this$map$iv = doc.select("#movie-handle b + a");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    me = (Element) item$iv$iv;
                    Object $result2 = $result;
                    $this$map$iv5 = me.select("a[href~=-songs]");
                    String title2 = title;
                    String docLink3 = docLink;
                    Iterable $this$map$iv8 = $this$map$iv;
                    destination$iv$iv5 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv5, 10));
                    for (Object item$iv$iv2 : $this$map$iv5) {
                        destination$iv$iv5.add(((Element) item$iv$iv2).text());
                        $this$map$iv5 = $this$map$iv5;
                    }
                    tags.element = (List) destination$iv$iv5;
                    year.element = StringsKt.toIntOrNull(StringsKt.trim(me.select("a[href~=year]").text()).toString());
                    if (me.select("a[href~=artist]").isEmpty()) {
                        year2 = year;
                    } else {
                        $this$map$iv7 = me.select("a[href~=artist]");
                        $i$f$map4 = 0;
                        destination$iv$iv7 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv7, 10));
                        $this$mapTo$iv$iv5 = $this$map$iv7;
                        for (Object item$iv$iv3 : $this$mapTo$iv$iv5) {
                            destination$iv$iv7.add(new ActorData(new Actor(((Element) item$iv$iv3).text(), (String) null, 2, (DefaultConstructorMarker) null), (ActorRole) null, "Artist", (Actor) null, 10, (DefaultConstructorMarker) null));
                            $this$map$iv7 = $this$map$iv7;
                            year = year;
                            $i$f$map4 = $i$f$map4;
                            $this$mapTo$iv$iv5 = $this$mapTo$iv$iv5;
                        }
                        year2 = year;
                        actors.element = (List) destination$iv$iv7;
                    }
                    if (!me.select("a[href~=music]").isEmpty()) {
                        $this$map$iv6 = me.select("a[href~=music]");
                        $i$f$map3 = 0;
                        destination$iv$iv6 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv6, 10));
                        $this$mapTo$iv$iv4 = $this$map$iv6;
                        $i$f$mapTo4 = 0;
                        for (Object item$iv$iv4 : $this$mapTo$iv$iv4) {
                            destination$iv$iv6.add(new ActorData(new Actor(((Element) item$iv$iv4).text(), (String) null, 2, (DefaultConstructorMarker) null), (ActorRole) null, "Music", (Actor) null, 10, (DefaultConstructorMarker) null));
                            $i$f$mapTo4 = $i$f$mapTo4;
                            $this$map$iv6 = $this$map$iv6;
                            $i$f$map3 = $i$f$map3;
                            $this$mapTo$iv$iv4 = $this$mapTo$iv$iv4;
                        }
                        actors.element = (List) destination$iv$iv6;
                    }
                    destination$iv$iv.add(Unit.INSTANCE);
                    $result = $result2;
                    tags = tags;
                    title = title2;
                    docLink = docLink3;
                    $this$map$iv = $this$map$iv8;
                    year = year2;
                }
                Ref.ObjectRef tags2 = tags;
                Ref.ObjectRef year3 = year;
                String title3 = title;
                String docLink4 = docLink;
                episodes = new ArrayList();
                $this$map$iv2 = doc.select("#tlist > tbody > tr[itemprop]");
                $i$f$map = 0;
                destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                $this$mapTo$iv$iv = $this$map$iv2;
                $i$f$mapTo = 0;
                it = $this$mapTo$iv$iv.iterator();
                while (it.hasNext()) {
                    Object item$iv$iv5 = it.next();
                    final Element me2 = (Element) item$iv$iv5;
                    Iterable $this$map$iv9 = $this$map$iv2;
                    $this$map$iv4 = me2.select("td > a");
                    int $i$f$map5 = $i$f$map;
                    Iterable $this$mapTo$iv$iv6 = $this$mapTo$iv$iv;
                    int $i$f$mapTo5 = $i$f$mapTo;
                    int $i$f$mapTo6 = CollectionsKt.collectionSizeOrDefault($this$map$iv4, 10);
                    destination$iv$iv4 = new ArrayList($i$f$mapTo6);
                    $this$mapTo$iv$iv3 = $this$map$iv4;
                    $i$f$mapTo3 = 0;
                    for (Object item$iv$iv6 : $this$mapTo$iv$iv3) {
                        Iterable $this$map$iv10 = $this$map$iv4;
                        Element it2 = (Element) item$iv$iv6;
                        destination$iv$iv4.add(new MassTamilanLinks(it2.text(), getMainUrl() + it2.attr("href")));
                        $this$map$iv4 = $this$map$iv10;
                        $this$mapTo$iv$iv3 = $this$mapTo$iv$iv3;
                        $i$f$mapTo3 = $i$f$mapTo3;
                        actors = actors;
                        it = it;
                    }
                    List links = (List) destination$iv$iv4;
                    final String epPlot = "Singers: " + me2.select("td > span[itemprop~=item] > span[itemprop~=byArtist]").text() + " && \nDuration: " + me2.select("td > span[itemprop~=item] > span[itemprop~=duration]").text() + " && \nDownloads: " + me2.select("td > span[itemprop~=item] > span[class~=dl-count]").text() + '\n';
                    destination$iv$iv2.add(Boxing.boxBoolean(episodes.add(MainAPIKt.newEpisode(this, AppUtils.INSTANCE.toJson(links), new Function1() { // from class: com.likdev256.MassTamilanProvider$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj3) {
                            return MassTamilanProvider.load$lambda$1$1(me2, poster, epPlot, (Episode) obj3);
                        }
                    }))));
                    $this$map$iv2 = $this$map$iv9;
                    $i$f$map = $i$f$map5;
                    $this$mapTo$iv$iv = $this$mapTo$iv$iv6;
                    $i$f$mapTo = $i$f$mapTo5;
                    actors = actors;
                }
                Ref.ObjectRef actors2 = actors;
                $this$map$iv3 = doc.select("h2.ziparea > a.dlink");
                $i$f$map2 = 0;
                destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                $this$mapTo$iv$iv2 = $this$map$iv3;
                $i$f$mapTo2 = 0;
                for (Object item$iv$iv7 : $this$mapTo$iv$iv2) {
                    Element it3 = (Element) item$iv$iv7;
                    destination$iv$iv3.add(new MassTamilanLinks(it3.text(), getMainUrl() + it3.attr("href")));
                    $this$map$iv3 = $this$map$iv3;
                    $i$f$map2 = $i$f$map2;
                    $this$mapTo$iv$iv2 = $this$mapTo$iv$iv2;
                    $i$f$mapTo2 = $i$f$mapTo2;
                }
                List zipLinks = (List) destination$iv$iv3;
                episodes.add(MainAPIKt.newEpisode(this, AppUtils.INSTANCE.toJson(zipLinks), new Function1() { // from class: com.likdev256.MassTamilanProvider$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj3) {
                        return MassTamilanProvider.load$lambda$3(episodes, (Episode) obj3);
                    }
                }));
                C00025 c00025 = new C00025(poster, year3, tags2, actors2, description, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(docLink4);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(doc);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(title3);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(poster);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(description);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(tags2);
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(year3);
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(actors2);
                c00012.L$9 = SpillingKt.nullOutSpilledVariable(episodes);
                c00012.L$10 = SpillingKt.nullOutSpilledVariable(zipLinks);
                c00012.label = 2;
                $result = MainAPIKt.newTvSeriesLoadResponse(this, title3, docLink4, TvType.TvSeries, episodes, c00025, c00012);
                if ($result == obj) {
                    return obj;
                }
                return $result;
            case 1:
                String docLink5 = (String) c00012.L$1;
                String url4 = (String) c00012.L$0;
                ResultKt.throwOnFailure($result);
                url3 = url4;
                obj = coroutine_suspended;
                url2 = ",,";
                i = 2;
                obj2 = $result;
                docLink = docLink5;
                Document doc2 = ((NiceResponse) obj2).getDocument();
                title = StringsKt.substringAfter$default(url3, url2, (String) null, i, (Object) null);
                MassTamilanProvider massTamilanProvider2 = this;
                StringBuilder sbAppend2 = new StringBuilder().append(getMainUrl());
                elementSelectFirst = doc2.selectFirst("figure.ib > picture > img");
                if (elementSelectFirst != null) {
                    strAttr = elementSelectFirst.attr("src");
                } else {
                    strAttr = null;
                }
                poster = MainAPIKt.fixUrlNull(massTamilanProvider2, sbAppend2.append(strAttr).toString());
                String description2 = doc2.select("#movie-handle").text();
                tags = new Ref.ObjectRef();
                tags.element = CollectionsKt.emptyList();
                year = new Ref.ObjectRef();
                year.element = Boxing.boxInt(0);
                actors = new Ref.ObjectRef();
                actors.element = CollectionsKt.emptyList();
                $this$map$iv = doc2.select("#movie-handle b + a");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                while (r17.hasNext()) {
                    me = (Element) item$iv$iv;
                    Object $result3 = $result;
                    $this$map$iv5 = me.select("a[href~=-songs]");
                    String title4 = title;
                    String docLink6 = docLink;
                    Iterable $this$map$iv11 = $this$map$iv;
                    destination$iv$iv5 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv5, 10));
                    while (r28.hasNext()) {
                        destination$iv$iv5.add(((Element) item$iv$iv2).text());
                        $this$map$iv5 = $this$map$iv5;
                    }
                    tags.element = (List) destination$iv$iv5;
                    year.element = StringsKt.toIntOrNull(StringsKt.trim(me.select("a[href~=year]").text()).toString());
                    if (me.select("a[href~=artist]").isEmpty()) {
                        $this$map$iv7 = me.select("a[href~=artist]");
                        $i$f$map4 = 0;
                        destination$iv$iv7 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv7, 10));
                        $this$mapTo$iv$iv5 = $this$map$iv7;
                        while (r28.hasNext()) {
                            destination$iv$iv7.add(new ActorData(new Actor(((Element) item$iv$iv3).text(), (String) null, 2, (DefaultConstructorMarker) null), (ActorRole) null, "Artist", (Actor) null, 10, (DefaultConstructorMarker) null));
                            $this$map$iv7 = $this$map$iv7;
                            year = year;
                            $i$f$map4 = $i$f$map4;
                            $this$mapTo$iv$iv5 = $this$mapTo$iv$iv5;
                        }
                        year2 = year;
                        actors.element = (List) destination$iv$iv7;
                    } else {
                        year2 = year;
                    }
                    if (!me.select("a[href~=music]").isEmpty()) {
                        $this$map$iv6 = me.select("a[href~=music]");
                        $i$f$map3 = 0;
                        destination$iv$iv6 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv6, 10));
                        $this$mapTo$iv$iv4 = $this$map$iv6;
                        $i$f$mapTo4 = 0;
                        while (r8.hasNext()) {
                            destination$iv$iv6.add(new ActorData(new Actor(((Element) item$iv$iv4).text(), (String) null, 2, (DefaultConstructorMarker) null), (ActorRole) null, "Music", (Actor) null, 10, (DefaultConstructorMarker) null));
                            $i$f$mapTo4 = $i$f$mapTo4;
                            $this$map$iv6 = $this$map$iv6;
                            $i$f$map3 = $i$f$map3;
                            $this$mapTo$iv$iv4 = $this$mapTo$iv$iv4;
                        }
                        actors.element = (List) destination$iv$iv6;
                    }
                    destination$iv$iv.add(Unit.INSTANCE);
                    $result = $result3;
                    tags = tags;
                    title = title4;
                    docLink = docLink6;
                    $this$map$iv = $this$map$iv11;
                    year = year2;
                }
                Ref.ObjectRef tags3 = tags;
                Ref.ObjectRef year4 = year;
                String title5 = title;
                String docLink7 = docLink;
                episodes = new ArrayList();
                $this$map$iv2 = doc2.select("#tlist > tbody > tr[itemprop]");
                $i$f$map = 0;
                destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                $this$mapTo$iv$iv = $this$map$iv2;
                $i$f$mapTo = 0;
                it = $this$mapTo$iv$iv.iterator();
                while (it.hasNext()) {
                    Object item$iv$iv8 = it.next();
                    final Element me3 = (Element) item$iv$iv8;
                    Iterable $this$map$iv12 = $this$map$iv2;
                    $this$map$iv4 = me3.select("td > a");
                    int $i$f$map6 = $i$f$map;
                    Iterable $this$mapTo$iv$iv7 = $this$mapTo$iv$iv;
                    int $i$f$mapTo7 = $i$f$mapTo;
                    int $i$f$mapTo8 = CollectionsKt.collectionSizeOrDefault($this$map$iv4, 10);
                    destination$iv$iv4 = new ArrayList($i$f$mapTo8);
                    $this$mapTo$iv$iv3 = $this$map$iv4;
                    $i$f$mapTo3 = 0;
                    while (r28.hasNext()) {
                        Iterable $this$map$iv13 = $this$map$iv4;
                        Element it4 = (Element) item$iv$iv6;
                        destination$iv$iv4.add(new MassTamilanLinks(it4.text(), getMainUrl() + it4.attr("href")));
                        $this$map$iv4 = $this$map$iv13;
                        $this$mapTo$iv$iv3 = $this$mapTo$iv$iv3;
                        $i$f$mapTo3 = $i$f$mapTo3;
                        actors = actors;
                        it = it;
                    }
                    List links2 = (List) destination$iv$iv4;
                    final String epPlot2 = "Singers: " + me3.select("td > span[itemprop~=item] > span[itemprop~=byArtist]").text() + " && \nDuration: " + me3.select("td > span[itemprop~=item] > span[itemprop~=duration]").text() + " && \nDownloads: " + me3.select("td > span[itemprop~=item] > span[class~=dl-count]").text() + '\n';
                    destination$iv$iv2.add(Boxing.boxBoolean(episodes.add(MainAPIKt.newEpisode(this, AppUtils.INSTANCE.toJson(links2), new Function1() { // from class: com.likdev256.MassTamilanProvider$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj3) {
                            return MassTamilanProvider.load$lambda$1$1(me3, poster, epPlot2, (Episode) obj3);
                        }
                    }))));
                    $this$map$iv2 = $this$map$iv12;
                    $i$f$map = $i$f$map6;
                    $this$mapTo$iv$iv = $this$mapTo$iv$iv7;
                    $i$f$mapTo = $i$f$mapTo7;
                    actors = actors;
                }
                Ref.ObjectRef actors3 = actors;
                $this$map$iv3 = doc2.select("h2.ziparea > a.dlink");
                $i$f$map2 = 0;
                destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                $this$mapTo$iv$iv2 = $this$map$iv3;
                $i$f$mapTo2 = 0;
                while (r7.hasNext()) {
                    Element it5 = (Element) item$iv$iv7;
                    destination$iv$iv3.add(new MassTamilanLinks(it5.text(), getMainUrl() + it5.attr("href")));
                    $this$map$iv3 = $this$map$iv3;
                    $i$f$map2 = $i$f$map2;
                    $this$mapTo$iv$iv2 = $this$mapTo$iv$iv2;
                    $i$f$mapTo2 = $i$f$mapTo2;
                }
                List zipLinks2 = (List) destination$iv$iv3;
                episodes.add(MainAPIKt.newEpisode(this, AppUtils.INSTANCE.toJson(zipLinks2), new Function1() { // from class: com.likdev256.MassTamilanProvider$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj3) {
                        return MassTamilanProvider.load$lambda$3(episodes, (Episode) obj3);
                    }
                }));
                C00025 c00026 = new C00025(poster, year4, tags3, actors3, description2, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(docLink7);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(doc2);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(title5);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(poster);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(description2);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(tags3);
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(year4);
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(actors3);
                c00012.L$9 = SpillingKt.nullOutSpilledVariable(episodes);
                c00012.L$10 = SpillingKt.nullOutSpilledVariable(zipLinks2);
                c00012.label = 2;
                $result = MainAPIKt.newTvSeriesLoadResponse(this, title5, docLink7, TvType.TvSeries, episodes, c00026, c00012);
                if ($result == obj) {
                    return obj;
                }
                return $result;
            case 2:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$1$1(Element $me, String $poster, String $epPlot, Episode $this$newEpisode) {
        $this$newEpisode.setName($me.select("td > span > h2 > span[itemprop~=name] > a").text());
        $this$newEpisode.setSeason(1);
        $this$newEpisode.setEpisode(Integer.valueOf(Integer.parseInt($me.select("td > span[itemprop~=position]").text())));
        $this$newEpisode.setPosterUrl($poster);
        $this$newEpisode.setDescription($epPlot);
        return Unit.INSTANCE;
    }

    static final Unit load$lambda$3(ArrayList $episodes, Episode $this$newEpisode) {
        $this$newEpisode.setName("Full Zip");
        $this$newEpisode.setSeason(1);
        $this$newEpisode.setEpisode(Integer.valueOf($episodes.size() + 1));
        $this$newEpisode.setPosterUrl("https://miro.medium.com/v2/resize:fit:720/format:webp/1*nCwjG9N0CkYXOkznDB7kSw.png");
        $this$newEpisode.setDescription("Zip/Rar links");
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.likdev256.MassTamilanProvider$load$5 */
    /* JADX INFO: compiled from: MassTamilanProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.likdev256.MassTamilanProvider$load$5", f = "MassTamilanProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00025 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<List<ActorData>> $actors;
        final /* synthetic */ String $description;
        final /* synthetic */ String $poster;
        final /* synthetic */ Ref.ObjectRef<List<String>> $tags;
        final /* synthetic */ Ref.ObjectRef<Integer> $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00025(String str, Ref.ObjectRef<Integer> objectRef, Ref.ObjectRef<List<String>> objectRef2, Ref.ObjectRef<List<ActorData>> objectRef3, String str2, Continuation<? super C00025> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$year = objectRef;
            this.$tags = objectRef2;
            this.$actors = objectRef3;
            this.$description = str2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00025 = new C00025(this.$poster, this.$year, this.$tags, this.$actors, this.$description, continuation);
            c00025.L$0 = obj;
            return c00025;
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
                    $this$newTvSeriesLoadResponse.setYear((Integer) this.$year.element);
                    $this$newTvSeriesLoadResponse.setTags((List) this.$tags.element);
                    $this$newTvSeriesLoadResponse.setActors((List) this.$actors.element);
                    $this$newTvSeriesLoadResponse.setPlot(this.$description);
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
                    KType kTypeTypeOf = Reflection.typeOf(ArrayList.class, KTypeProjection.Companion.invariant(Reflection.typeOf(MassTamilanLinks.class)));
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (Result.exceptionOrNull-impl(obj) != null) {
                    try {
                        Result.Companion companion3 = Result.Companion;
                        obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(ArrayList.class), (List) null, 2, (Object) null));
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
                        objDecodeFromString = $this$readValue$iv$iv.readValue(data, new TypeReference<ArrayList<MassTamilanLinks>>() { // from class: com.likdev256.MassTamilanProvider$loadLinks$$inlined$parseJson$1
                        });
                    } catch (Throwable th3) {
                        ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv2.readValue(data, new TypeReference<ArrayList<MassTamilanLinks>>() { // from class: com.likdev256.MassTamilanProvider$loadLinks$$inlined$parseJson$1
                        });
                    }
                } else {
                    ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv3.readValue(data, new TypeReference<ArrayList<MassTamilanLinks>>() { // from class: com.likdev256.MassTamilanProvider$loadLinks$$inlined$parseJson$1
                    });
                }
                C00042 c00042 = new C00042(function2, this, null);
                c00032.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                c00032.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                c00032.Z$0 = isCasting;
                c00032.label = 1;
                if (ParCollectionsKt.amap((List) objDecodeFromString, c00042, c00032) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.likdev256.MassTamilanProvider$loadLinks$2 */
    /* JADX INFO: compiled from: MassTamilanProvider.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/lagradost/cloudstream3/mvvm/Resource;", "", "it", "Lcom/likdev256/MassTamilanProvider$MassTamilanLinks;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.likdev256.MassTamilanProvider$loadLinks$2", f = "MassTamilanProvider.kt", i = {0}, l = {167}, m = "invokeSuspend", n = {"it"}, nl = {179}, s = {"L$0"}, v = 2)
    static final class C00042 extends SuspendLambda implements Function2<MassTamilanLinks, Continuation<? super Resource<? extends Unit>>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MassTamilanProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00042(Function1<? super ExtractorLink, Unit> function1, MassTamilanProvider massTamilanProvider, Continuation<? super C00042> continuation) {
            super(2, continuation);
            this.$callback = function1;
            this.this$0 = massTamilanProvider;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00042 = new C00042(this.$callback, this.this$0, continuation);
            c00042.L$0 = obj;
            return c00042;
        }

        public final Object invoke(MassTamilanLinks massTamilanLinks, Continuation<? super Resource<Unit>> continuation) {
            return create(massTamilanLinks, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            MassTamilanLinks it = (MassTamilanLinks) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                    this.label = 1;
                    Object objSafeApiCall = ArchComponentExtKt.safeApiCall(new AnonymousClass1(this.$callback, it, this.this$0, null), (Continuation) this);
                    if (objSafeApiCall == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return objSafeApiCall;
                case 1:
                    ResultKt.throwOnFailure($result);
                    return $result;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.likdev256.MassTamilanProvider$loadLinks$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: MassTamilanProvider.kt */
        @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.likdev256.MassTamilanProvider$loadLinks$2$1", f = "MassTamilanProvider.kt", i = {}, l = {169}, m = "invokeSuspend", n = {}, nl = {168}, s = {}, v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
            final /* synthetic */ MassTamilanLinks $it;
            Object L$0;
            int label;
            final /* synthetic */ MassTamilanProvider this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(Function1<? super ExtractorLink, Unit> function1, MassTamilanLinks massTamilanLinks, MassTamilanProvider massTamilanProvider, Continuation<? super AnonymousClass1> continuation) {
                super(1, continuation);
                this.$callback = function1;
                this.$it = massTamilanLinks;
                this.this$0 = massTamilanProvider;
            }

            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new AnonymousClass1(this.$callback, this.$it, this.this$0, continuation);
            }

            public final Object invoke(Continuation<? super Unit> continuation) {
                return create(continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object $result) {
                Object objNewExtractorLink;
                Function1<ExtractorLink, Unit> function1;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Function1<ExtractorLink, Unit> function2 = this.$callback;
                        this.L$0 = function2;
                        this.label = 1;
                        objNewExtractorLink = ExtractorApiKt.newExtractorLink(this.$it.getSourceName(), this.$it.getSourceName(), "https://goodproxy.goodproxy.workers.dev/fetch?url=" + this.$it.getSourceLink(), ExtractorApiKt.getINFER_TYPE(), new C00061(this.this$0, null), (Continuation) this);
                        if (objNewExtractorLink == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function1 = function2;
                        break;
                        break;
                    case 1:
                        function1 = (Function1) this.L$0;
                        ResultKt.throwOnFailure($result);
                        objNewExtractorLink = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                function1.invoke(objNewExtractorLink);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.likdev256.MassTamilanProvider$loadLinks$2$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: MassTamilanProvider.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
            @DebugMetadata(c = "com.likdev256.MassTamilanProvider$loadLinks$2$1$1", f = "MassTamilanProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
            static final class C00061 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
                private /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ MassTamilanProvider this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00061(MassTamilanProvider massTamilanProvider, Continuation<? super C00061> continuation) {
                    super(2, continuation);
                    this.this$0 = massTamilanProvider;
                }

                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    Continuation<Unit> c00061 = new C00061(this.this$0, continuation);
                    c00061.L$0 = obj;
                    return c00061;
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
                            $this$newExtractorLink.setReferer(this.this$0.getMainUrl() + '/');
                            $this$newExtractorLink.setQuality(Qualities.Unknown.getValue());
                            return Unit.INSTANCE;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
        }
    }
}
