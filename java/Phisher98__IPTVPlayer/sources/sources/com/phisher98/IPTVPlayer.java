package com.phisher98;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LiveSearchResponse;
import com.lagradost.cloudstream3.LiveStreamLoadResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.DrmExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import com.lagradost.cloudstream3.utils.Qualities;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
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

/* JADX INFO: compiled from: IPTVPlayer.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/IPTVPlayer/classes.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u00014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0096@¢\u0006\u0002\u0010!J\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010%\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010&J\u0016\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010&JF\u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u00112\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002000.2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u0002000.H\u0096@¢\u0006\u0002\u00103R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u00065"}, d2 = {"Lcom/phisher98/IPTVPlayer;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "lang", "", "getLang", "()Ljava/lang/String;", "setLang", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "hasChromecastSupport", "getHasChromecastSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "LoadData", "IPTVPlayer"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nIPTVPlayer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IPTVPlayer.kt\ncom/phisher98/IPTVPlayer\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 5 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 6 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 7 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,416:1\n1665#2:417\n1691#2,3:418\n1694#2,3:428\n1739#2:434\n1814#2,3:435\n777#2:439\n873#2,2:440\n1739#2:442\n1814#2,3:443\n460#3,7:421\n129#4:431\n158#4,2:432\n160#4:438\n63#5:446\n64#5,15:448\n63#5:465\n64#5,15:467\n1#6:447\n1#6:466\n50#7:463\n43#7:464\n50#7:482\n43#7:483\n*S KotlinDebug\n*F\n+ 1 IPTVPlayer.kt\ncom/phisher98/IPTVPlayer\n*L\n30#1:417\n30#1:418,3\n30#1:428,3\n32#1:434\n32#1:435,3\n56#1:439\n56#1:440,2\n56#1:442\n56#1:443,3\n30#1:421,7\n30#1:431\n30#1:432,2\n30#1:438\n73#1:446\n73#1:448,15\n94#1:465\n94#1:467,15\n73#1:447\n94#1:466\n73#1:463\n73#1:464\n94#1:482\n94#1:483\n*E\n"})
public final class IPTVPlayer extends MainAPI {

    @NotNull
    private String lang = "hi";

    @NotNull
    private String mainUrl = "https://raw.githubusercontent.com/phisher98/TVVVV/main/15APR2024.m3u";

    @NotNull
    private String name = "IPTV Player";
    private final boolean hasMainPage = true;
    private final boolean hasChromecastSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(TvType.Live);

    /* JADX INFO: renamed from: com.phisher98.IPTVPlayer$getMainPage$1 */
    /* JADX INFO: compiled from: IPTVPlayer.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.IPTVPlayer", f = "IPTVPlayer.kt", i = {0, 0}, l = {29}, m = "getMainPage", n = {"request", "page"}, nl = {30}, s = {"L$0", "I$0"}, v = 2)
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
            return IPTVPlayer.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.IPTVPlayer$loadLinks$1 */
    /* JADX INFO: compiled from: IPTVPlayer.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.IPTVPlayer", f = "IPTVPlayer.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {98, 116, 131}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "loadData", "isCasting", "data", "subtitleCallback", "callback", "loadData", "isCasting", "data", "subtitleCallback", "callback", "loadData", "isCasting"}, nl = {97, 115, 130}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0"}, v = 2)
    static final class C00021 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00021(Continuation<? super C00021> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return IPTVPlayer.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.IPTVPlayer$search$1 */
    /* JADX INFO: compiled from: IPTVPlayer.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.IPTVPlayer", f = "IPTVPlayer.kt", i = {0}, l = {55}, m = "search", n = {"query"}, nl = {56}, s = {"L$0"}, v = 2)
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
            return IPTVPlayer.this.search(null, (Continuation) this);
        }
    }

    @NotNull
    public String getLang() {
        return this.lang;
    }

    public void setLang(@NotNull String str) {
        this.lang = str;
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

    public boolean getHasChromecastSupport() {
        return this.hasChromecastSupport;
    }

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00001 c00001;
        int page2;
        IptvPlaylistParser iptvPlaylistParser;
        Object answer$iv$iv$iv;
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
                IptvPlaylistParser iptvPlaylistParser2 = new IptvPlaylistParser();
                Requests app = MainActivityKt.getApp();
                String mainUrl = getMainUrl();
                c00001.L$0 = SpillingKt.nullOutSpilledVariable(request);
                c00001.L$1 = iptvPlaylistParser2;
                c00001.I$0 = page;
                c00001.label = 1;
                $result = Requests.get$default(app, mainUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00001, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                page2 = page;
                iptvPlaylistParser = iptvPlaylistParser2;
                break;
                break;
            case 1:
                page2 = c00001.I$0;
                iptvPlaylistParser = (IptvPlaylistParser) c00001.L$1;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Playlist data = iptvPlaylistParser.parseM3U(((NiceResponse) $result).getText());
        Iterable $this$groupBy$iv = data.getItems();
        Map $this$map$iv = new LinkedHashMap();
        for (Object element$iv$iv : $this$groupBy$iv) {
            PlaylistItem it = (PlaylistItem) element$iv$iv;
            String str = it.getAttributes().get("group-title");
            Object value$iv$iv$iv = $this$map$iv.get(str);
            if (value$iv$iv$iv == null) {
                Object answer$iv$iv$iv2 = (List) new ArrayList();
                answer$iv$iv$iv = answer$iv$iv$iv2;
                $this$map$iv.put(str, answer$iv$iv$iv);
            } else {
                answer$iv$iv$iv = value$iv$iv$iv;
            }
            List list$iv$iv = (List) answer$iv$iv$iv;
            list$iv$iv.add(element$iv$iv);
        }
        int $i$f$map = 0;
        Collection destination$iv$iv = new ArrayList($this$map$iv.size());
        Map $this$mapTo$iv$iv = $this$map$iv;
        for (Map.Entry item$iv$iv : $this$mapTo$iv$iv.entrySet()) {
            String title = (String) item$iv$iv.getKey();
            if (title == null) {
                title = "";
            }
            Iterable $this$map$iv2 = (Iterable) item$iv$iv.getValue();
            int $i$f$map2 = $i$f$map;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
            Iterable<PlaylistItem> $this$mapTo$iv$iv2 = $this$map$iv2;
            for (final PlaylistItem channel : $this$mapTo$iv$iv2) {
                Iterable $this$mapTo$iv$iv3 = $this$mapTo$iv$iv2;
                String streamurl = String.valueOf(channel.getUrl());
                String channelname = String.valueOf(channel.getTitle());
                Playlist data2 = data;
                final String posterurl = String.valueOf(channel.getAttributes().get("tvg-logo"));
                String nation = String.valueOf(channel.getAttributes().get("group-title"));
                String key = String.valueOf(channel.getAttributes().get("key"));
                String keyid = String.valueOf(channel.getAttributes().get("keyid"));
                destination$iv$iv2.add(MainAPIKt.newLiveSearchResponse$default(this, channelname, AppUtils.INSTANCE.toJson(new LoadData(streamurl, channelname, posterurl, nation, key, keyid)), TvType.Live, false, new Function1() { // from class: com.phisher98.IPTVPlayer$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        return IPTVPlayer.getMainPage$lambda$1$0$0(posterurl, channel, (LiveSearchResponse) obj);
                    }
                }, 8, (Object) null));
                $this$mapTo$iv$iv2 = $this$mapTo$iv$iv3;
                data = data2;
                page2 = page2;
                $this$mapTo$iv$iv = $this$mapTo$iv$iv;
            }
            List show = (List) destination$iv$iv2;
            destination$iv$iv.add(new HomePageList(title, show, true));
            $i$f$map = $i$f$map2;
        }
        return MainAPIKt.newHomePageResponse$default((List) destination$iv$iv, (Boolean) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMainPage$lambda$1$0$0(String $posterurl, PlaylistItem $channel, LiveSearchResponse $this$newLiveSearchResponse) {
        $this$newLiveSearchResponse.setPosterUrl($posterurl);
        $this$newLiveSearchResponse.getApiName();
        $this$newLiveSearchResponse.setLang($channel.getAttributes().get("group-title"));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        C00061 c00061;
        boolean z;
        String query2;
        IptvPlaylistParser iptvPlaylistParser;
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
                IptvPlaylistParser iptvPlaylistParser2 = new IptvPlaylistParser();
                Requests app = MainActivityKt.getApp();
                String mainUrl = getMainUrl();
                c00061.L$0 = query;
                c00061.L$1 = iptvPlaylistParser2;
                c00061.label = 1;
                z = true;
                $result = Requests.get$default(app, mainUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00061, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                query2 = query;
                iptvPlaylistParser = iptvPlaylistParser2;
                break;
                break;
            case 1:
                iptvPlaylistParser = (IptvPlaylistParser) c00061.L$1;
                query2 = (String) c00061.L$0;
                ResultKt.throwOnFailure($result);
                z = true;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Playlist data = iptvPlaylistParser.parseM3U(((NiceResponse) $result).getText());
        Iterable $this$filter$iv = data.getItems();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            PlaylistItem it = (PlaylistItem) element$iv$iv;
            String title = it.getTitle();
            if (title != null ? StringsKt.contains(title, query2, z) : false) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable $this$map$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            final PlaylistItem channel = (PlaylistItem) item$iv$iv;
            String streamurl = String.valueOf(channel.getUrl());
            String channelname = String.valueOf(channel.getTitle());
            final String posterurl = String.valueOf(channel.getAttributes().get("tvg-logo"));
            String nation = String.valueOf(channel.getAttributes().get("group-title"));
            String key = String.valueOf(channel.getAttributes().get("key"));
            String keyid = String.valueOf(channel.getAttributes().get("keyid"));
            destination$iv$iv2.add(MainAPIKt.newLiveSearchResponse$default(this, channelname, AppUtils.INSTANCE.toJson(new LoadData(streamurl, channelname, posterurl, nation, key, keyid)), TvType.Live, false, new Function1() { // from class: com.phisher98.IPTVPlayer$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    return IPTVPlayer.search$lambda$1$0(posterurl, channel, (LiveSearchResponse) obj);
                }
            }, 8, (Object) null));
            $this$map$iv = $this$map$iv;
        }
        return (List) destination$iv$iv2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit search$lambda$1$0(String $posterurl, PlaylistItem $channel, LiveSearchResponse $this$newLiveSearchResponse) {
        $this$newLiveSearchResponse.setPosterUrl($posterurl);
        $this$newLiveSearchResponse.getApiName();
        $this$newLiveSearchResponse.setLang($channel.getAttributes().get("group-title"));
        return Unit.INSTANCE;
    }

    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        Object obj;
        Object objDecodeFromString;
        AppUtils appUtils = AppUtils.INSTANCE;
        try {
            Result.Companion companion = Result.Companion;
            KType kTypeTypeOf = Reflection.typeOf(LoadData.class);
            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
            obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            try {
                Result.Companion companion3 = Result.Companion;
                obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(LoadData.class), (List) null, 2, (Object) null));
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
                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, url);
            } catch (SerializationException e) {
                ArchComponentExtKt.logError(e);
                ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                objDecodeFromString = $this$readValue$iv$iv.readValue(url, new TypeReference<LoadData>() { // from class: com.phisher98.IPTVPlayer$load$$inlined$parseJson$1
                });
            } catch (Throwable th3) {
                ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                objDecodeFromString = $this$readValue$iv$iv2.readValue(url, new TypeReference<LoadData>() { // from class: com.phisher98.IPTVPlayer$load$$inlined$parseJson$1
                });
            }
        } else {
            ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
            objDecodeFromString = $this$readValue$iv$iv3.readValue(url, new TypeReference<LoadData>() { // from class: com.phisher98.IPTVPlayer$load$$inlined$parseJson$1
            });
        }
        LoadData data = (LoadData) objDecodeFromString;
        return MainAPIKt.newLiveStreamLoadResponse(this, data.getTitle(), data.getUrl(), url, new C00012(data, null), continuation);
    }

    /* JADX INFO: renamed from: com.phisher98.IPTVPlayer$load$2 */
    /* JADX INFO: compiled from: IPTVPlayer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/LiveStreamLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.IPTVPlayer$load$2", f = "IPTVPlayer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00012 extends SuspendLambda implements Function2<LiveStreamLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ LoadData $data;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00012(LoadData loadData, Continuation<? super C00012> continuation) {
            super(2, continuation);
            this.$data = loadData;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00012 = new C00012(this.$data, continuation);
            c00012.L$0 = obj;
            return c00012;
        }

        public final Object invoke(LiveStreamLoadResponse liveStreamLoadResponse, Continuation<? super Unit> continuation) {
            return create(liveStreamLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            LiveStreamLoadResponse $this$newLiveStreamLoadResponse = (LiveStreamLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newLiveStreamLoadResponse.setPosterUrl(this.$data.getPoster());
                    $this$newLiveStreamLoadResponse.setPlot(this.$data.getNation());
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: compiled from: IPTVPlayer.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/phisher98/IPTVPlayer$LoadData;", "", "url", "", "title", "poster", "nation", "key", "keyid", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getTitle", "getPoster", "getNation", "getKey", "getKeyid", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "IPTVPlayer"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class LoadData {

        @NotNull
        private final String key;

        @NotNull
        private final String keyid;

        @NotNull
        private final String nation;

        @NotNull
        private final String poster;

        @NotNull
        private final String title;

        @NotNull
        private final String url;

        public static /* synthetic */ LoadData copy$default(LoadData loadData, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
            if ((i & 1) != 0) {
                str = loadData.url;
            }
            if ((i & 2) != 0) {
                str2 = loadData.title;
            }
            if ((i & 4) != 0) {
                str3 = loadData.poster;
            }
            if ((i & 8) != 0) {
                str4 = loadData.nation;
            }
            if ((i & 16) != 0) {
                str5 = loadData.key;
            }
            if ((i & 32) != 0) {
                str6 = loadData.keyid;
            }
            String str7 = str5;
            String str8 = str6;
            return loadData.copy(str, str2, str3, str4, str7, str8);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getPoster() {
            return this.poster;
        }

        @NotNull
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getNation() {
            return this.nation;
        }

        @NotNull
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getKey() {
            return this.key;
        }

        @NotNull
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getKeyid() {
            return this.keyid;
        }

        @NotNull
        public final LoadData copy(@NotNull String url, @NotNull String title, @NotNull String poster, @NotNull String nation, @NotNull String key, @NotNull String keyid) {
            return new LoadData(url, title, poster, nation, key, keyid);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LoadData)) {
                return false;
            }
            LoadData loadData = (LoadData) other;
            return Intrinsics.areEqual(this.url, loadData.url) && Intrinsics.areEqual(this.title, loadData.title) && Intrinsics.areEqual(this.poster, loadData.poster) && Intrinsics.areEqual(this.nation, loadData.nation) && Intrinsics.areEqual(this.key, loadData.key) && Intrinsics.areEqual(this.keyid, loadData.keyid);
        }

        public int hashCode() {
            return (((((((((this.url.hashCode() * 31) + this.title.hashCode()) * 31) + this.poster.hashCode()) * 31) + this.nation.hashCode()) * 31) + this.key.hashCode()) * 31) + this.keyid.hashCode();
        }

        @NotNull
        public String toString() {
            return "LoadData(url=" + this.url + ", title=" + this.title + ", poster=" + this.poster + ", nation=" + this.nation + ", key=" + this.key + ", keyid=" + this.keyid + ')';
        }

        public LoadData(@NotNull String url, @NotNull String title, @NotNull String poster, @NotNull String nation, @NotNull String key, @NotNull String keyid) {
            this.url = url;
            this.title = title;
            this.poster = poster;
            this.nation = nation;
            this.key = key;
            this.keyid = keyid;
        }

        @NotNull
        public final String getUrl() {
            return this.url;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        public final String getPoster() {
            return this.poster;
        }

        @NotNull
        public final String getNation() {
            return this.nation;
        }

        @NotNull
        public final String getKey() {
            return this.key;
        }

        @NotNull
        public final String getKeyid() {
            return this.keyid;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00021 c00021;
        IPTVPlayer iPTVPlayer;
        Object obj;
        Object objDecodeFromString;
        Object objNewExtractorLink;
        Function1<? super ExtractorLink, Unit> function3;
        Object objNewExtractorLink2;
        Function1<? super ExtractorLink, Unit> function4;
        Object objNewDrmExtractorLink;
        Function1<? super ExtractorLink, Unit> function5;
        if (continuation instanceof C00021) {
            c00021 = (C00021) continuation;
            if ((c00021.label & Integer.MIN_VALUE) != 0) {
                c00021.label -= Integer.MIN_VALUE;
                iPTVPlayer = this;
            } else {
                iPTVPlayer = this;
                c00021 = iPTVPlayer.new C00021(continuation);
            }
        } else {
            iPTVPlayer = this;
            c00021 = iPTVPlayer.new C00021(continuation);
        }
        C00021 c00022 = c00021;
        Object $result = c00022.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00022.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                AppUtils appUtils = AppUtils.INSTANCE;
                try {
                    Result.Companion companion = Result.Companion;
                    KType kTypeTypeOf = Reflection.typeOf(LoadData.class);
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
                        obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(LoadData.class), (List) null, 2, (Object) null));
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
                        objDecodeFromString = $this$readValue$iv$iv.readValue(data, new TypeReference<LoadData>() { // from class: com.phisher98.IPTVPlayer$loadLinks$$inlined$parseJson$1
                        });
                    } catch (Throwable th3) {
                        ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv2.readValue(data, new TypeReference<LoadData>() { // from class: com.phisher98.IPTVPlayer$loadLinks$$inlined$parseJson$1
                        });
                    }
                    break;
                } else {
                    ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv3.readValue(data, new TypeReference<LoadData>() { // from class: com.phisher98.IPTVPlayer$loadLinks$$inlined$parseJson$1
                    });
                }
                LoadData loadData = (LoadData) objDecodeFromString;
                if (StringsKt.contains$default(loadData.getUrl(), "mpd", false, 2, (Object) null)) {
                    String name = iPTVPlayer.getName();
                    String name2 = iPTVPlayer.getName();
                    String url = loadData.getUrl();
                    ExtractorLinkType infer_type = ExtractorApiKt.getINFER_TYPE();
                    UUID uuidRandomUUID = UUID.randomUUID();
                    C00032 c00032 = new C00032(loadData, null);
                    c00022.L$0 = SpillingKt.nullOutSpilledVariable(data);
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(loadData);
                    c00022.L$4 = function2;
                    c00022.Z$0 = isCasting;
                    c00022.label = 1;
                    objNewDrmExtractorLink = ExtractorApiKt.newDrmExtractorLink(name, name2, url, infer_type, uuidRandomUUID, c00032, c00022);
                    if (objNewDrmExtractorLink == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function5 = function2;
                    function5.invoke(objNewDrmExtractorLink);
                    return Boxing.boxBoolean(true);
                }
                if (StringsKt.contains$default(loadData.getUrl(), "&e=.m3u", false, 2, (Object) null)) {
                    String name3 = iPTVPlayer.getName();
                    String name4 = iPTVPlayer.getName();
                    String url2 = loadData.getUrl();
                    ExtractorLinkType extractorLinkType = ExtractorLinkType.M3U8;
                    C00043 c00043 = new C00043(null);
                    c00022.L$0 = SpillingKt.nullOutSpilledVariable(data);
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(loadData);
                    c00022.L$4 = function2;
                    c00022.Z$0 = isCasting;
                    c00022.label = 2;
                    objNewExtractorLink2 = ExtractorApiKt.newExtractorLink(name3, name4, url2, extractorLinkType, c00043, c00022);
                    if (objNewExtractorLink2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function4 = function2;
                    function4.invoke(objNewExtractorLink2);
                    return Boxing.boxBoolean(true);
                }
                String name5 = iPTVPlayer.getName();
                String title = loadData.getTitle();
                String url3 = loadData.getUrl();
                ExtractorLinkType infer_type2 = ExtractorApiKt.getINFER_TYPE();
                C00054 c00054 = new C00054(null);
                c00022.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00022.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                c00022.L$3 = SpillingKt.nullOutSpilledVariable(loadData);
                c00022.L$4 = function2;
                c00022.Z$0 = isCasting;
                c00022.label = 3;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(name5, title, url3, infer_type2, c00054, c00022);
                if (objNewExtractorLink == coroutine_suspended) {
                    return coroutine_suspended;
                }
                function3 = function2;
                function3.invoke(objNewExtractorLink);
                return Boxing.boxBoolean(true);
            case 1:
                boolean isCasting2 = c00022.Z$0;
                function5 = (Function1) c00022.L$4;
                ResultKt.throwOnFailure($result);
                objNewDrmExtractorLink = $result;
                function5.invoke(objNewDrmExtractorLink);
                return Boxing.boxBoolean(true);
            case 2:
                boolean isCasting3 = c00022.Z$0;
                function4 = (Function1) c00022.L$4;
                ResultKt.throwOnFailure($result);
                objNewExtractorLink2 = $result;
                function4.invoke(objNewExtractorLink2);
                return Boxing.boxBoolean(true);
            case 3:
                boolean z = c00022.Z$0;
                function3 = (Function1) c00022.L$4;
                ResultKt.throwOnFailure($result);
                objNewExtractorLink = $result;
                function3.invoke(objNewExtractorLink);
                return Boxing.boxBoolean(true);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.phisher98.IPTVPlayer$loadLinks$2 */
    /* JADX INFO: compiled from: IPTVPlayer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/DrmExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.IPTVPlayer$loadLinks$2", f = "IPTVPlayer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00032 extends SuspendLambda implements Function2<DrmExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ LoadData $loadData;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00032(LoadData loadData, Continuation<? super C00032> continuation) {
            super(2, continuation);
            this.$loadData = loadData;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00032 = new C00032(this.$loadData, continuation);
            c00032.L$0 = obj;
            return c00032;
        }

        public final Object invoke(DrmExtractorLink drmExtractorLink, Continuation<? super Unit> continuation) {
            return create(drmExtractorLink, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            DrmExtractorLink $this$newDrmExtractorLink = (DrmExtractorLink) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newDrmExtractorLink.setQuality(Qualities.Unknown.getValue());
                    $this$newDrmExtractorLink.setKey(StringsKt.trim(this.$loadData.getKey()).toString());
                    $this$newDrmExtractorLink.setKid(StringsKt.trim(this.$loadData.getKeyid()).toString());
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.phisher98.IPTVPlayer$loadLinks$3 */
    /* JADX INFO: compiled from: IPTVPlayer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.IPTVPlayer$loadLinks$3", f = "IPTVPlayer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00043 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C00043(Continuation<? super C00043> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00043 = new C00043(continuation);
            c00043.L$0 = obj;
            return c00043;
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
                    $this$newExtractorLink.setReferer("");
                    $this$newExtractorLink.setQuality(Qualities.Unknown.getValue());
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.phisher98.IPTVPlayer$loadLinks$4 */
    /* JADX INFO: compiled from: IPTVPlayer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.IPTVPlayer$loadLinks$4", f = "IPTVPlayer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00054 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C00054(Continuation<? super C00054> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00054 = new C00054(continuation);
            c00054.L$0 = obj;
            return c00054;
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
                    $this$newExtractorLink.setReferer("");
                    $this$newExtractorLink.setQuality(Qualities.Unknown.getValue());
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
