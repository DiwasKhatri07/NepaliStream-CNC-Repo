package com.cncverse;

import android.content.Context;
import android.util.Base64;
import com.cncverse.donation.DonationManager;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.MovieLoadResponse;
import com.lagradost.cloudstream3.MovieSearchResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SportzxVODProvider.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/SportzxProvider/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 42\u00020\u0001:\u00014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010%J\u0016\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010)JF\u0010*\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u00152\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002000.2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u0002000.H\u0096@¢\u0006\u0002\u00103R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u001a\u0010\n\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\rR\u001a\u0010\u0011\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\rR\u0014\u0010\u0014\u001a\u00020\u0015X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u0015X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u00065"}, d2 = {"Lcom/cncverse/SportzxVODProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "customName", "", "catLink", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getCustomName", "()Ljava/lang/String;", "getCatLink", "mainUrl", "getMainUrl", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "lang", "getLang", "setLang", "hasMainPage", "", "getHasMainPage", "()Z", "hasChromecastSupport", "getHasChromecastSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "SportzxProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSportzxVODProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SportzxVODProvider.kt\ncom/cncverse/SportzxVODProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 5 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,192:1\n1642#2,10:193\n1915#2:203\n1916#2:205\n1652#2:206\n1915#2:264\n1915#2,2:265\n1916#2:267\n1586#2:268\n1661#2,3:269\n1#3:204\n1#3:208\n1#3:227\n1#3:246\n63#4:207\n64#4,15:209\n63#4:226\n64#4,15:228\n63#4:245\n64#4,15:247\n50#5:224\n43#5:225\n50#5:243\n43#5:244\n50#5:262\n43#5:263\n*S KotlinDebug\n*F\n+ 1 SportzxVODProvider.kt\ncom/cncverse/SportzxVODProvider\n*L\n45#1:193,10\n45#1:203\n45#1:205\n45#1:206\n111#1:264\n120#1:265,2\n111#1:267\n133#1:268\n133#1:269,3\n45#1:204\n74#1:208\n94#1:227\n103#1:246\n74#1:207\n74#1:209,15\n94#1:226\n94#1:228,15\n103#1:245\n103#1:247,15\n74#1:224\n74#1:225\n94#1:243\n94#1:244\n103#1:262\n103#1:263\n*E\n"})
public final class SportzxVODProvider extends MainAPI {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static Context context;

    @NotNull
    private final String catLink;

    @NotNull
    private final String customName;

    @NotNull
    private String name;

    @NotNull
    private String mainUrl = "https://sportzx.live";

    @NotNull
    private String lang = "ta";
    private final boolean hasMainPage = true;
    private final boolean hasChromecastSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries, TvType.Live});

    /* JADX INFO: renamed from: com.cncverse.SportzxVODProvider$getMainPage$1 */
    /* JADX INFO: compiled from: SportzxVODProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.SportzxVODProvider", f = "SportzxVODProvider.kt", i = {0, 0}, l = {43}, m = "getMainPage", n = {"request", "page"}, nl = {45}, s = {"L$0", "I$0"}, v = 2)
    static final class C00311 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00311(Continuation<? super C00311> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SportzxVODProvider.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.SportzxVODProvider$loadLinks$1 */
    /* JADX INFO: compiled from: SportzxVODProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.SportzxVODProvider", f = "SportzxVODProvider.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {96, 144, 159, 177}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "loadData", "isCasting", "data", "subtitleCallback", "callback", "loadData", "streamJson", "streams", "$this$forEach$iv", "element$iv", "stream", "link", "serverName", "parts", "url", "customHeaders", "apiParts", "keyId", "key", "kidHex", "keyHex", "kidB64", "keyB64", "isCasting", "$i$f$forEach", "$i$a$-forEach-SportzxVODProvider$loadLinks$2", "data", "subtitleCallback", "callback", "loadData", "streamJson", "streams", "$this$forEach$iv", "element$iv", "stream", "link", "serverName", "parts", "url", "customHeaders", "apiParts", "keyId", "key", "kidHex", "keyHex", "kidB64", "keyB64", "isCasting", "$i$f$forEach", "$i$a$-forEach-SportzxVODProvider$loadLinks$2", "data", "subtitleCallback", "callback", "loadData", "streamJson", "streams", "$this$forEach$iv", "element$iv", "stream", "link", "serverName", "parts", "url", "customHeaders", "type", "isCasting", "$i$f$forEach", "$i$a$-forEach-SportzxVODProvider$loadLinks$2"}, nl = {97, 143, 158, 176}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "Z$0", "I$0", "I$1"}, v = 2)
    static final class C00331 extends ContinuationImpl {
        int I$0;
        int I$1;
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
        Object L$20;
        Object L$21;
        Object L$22;
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

        C00331(Continuation<? super C00331> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SportzxVODProvider.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    public SportzxVODProvider(@NotNull String customName, @NotNull String catLink) {
        this.customName = customName;
        this.catLink = catLink;
        this.name = this.customName;
    }

    @NotNull
    public final String getCustomName() {
        return this.customName;
    }

    @NotNull
    public final String getCatLink() {
        return this.catLink;
    }

    /* JADX INFO: compiled from: SportzxVODProvider.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/cncverse/SportzxVODProvider$Companion;", "", "<init>", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "SportzxProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Nullable
        public final Context getContext() {
            return SportzxVODProvider.context;
        }

        public final void setContext(@Nullable Context context) {
            SportzxVODProvider.context = context;
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
    public String getLang() {
        return this.lang;
    }

    public void setLang(@NotNull String str) {
        this.lang = str;
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
        C00311 c00311;
        Object obj;
        MovieSearchResponse movieSearchResponseNewMovieSearchResponse$default;
        if (continuation instanceof C00311) {
            c00311 = (C00311) continuation;
            if ((c00311.label & Integer.MIN_VALUE) != 0) {
                c00311.label -= Integer.MIN_VALUE;
            } else {
                c00311 = new C00311(continuation);
            }
        } else {
            c00311 = new C00311(continuation);
        }
        Object $result = c00311.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00311.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                DonationManager.INSTANCE.checkAndShow(getName());
                SportzxProviderManager sportzxProviderManager = SportzxProviderManager.INSTANCE;
                String str = this.catLink;
                c00311.L$0 = SpillingKt.nullOutSpilledVariable(request);
                c00311.I$0 = page;
                c00311.label = 1;
                Object objFetchVODCategory = sportzxProviderManager.fetchVODCategory(str, c00311);
                if (objFetchVODCategory == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = objFetchVODCategory;
                break;
                break;
            case 1:
                int i = c00311.I$0;
                ResultKt.throwOnFailure($result);
                obj = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Iterable items = (List) obj;
        Iterable $this$mapNotNull$iv = items;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            final SportzxVODData item = (SportzxVODData) element$iv$iv$iv;
            String id = item.getId();
            if (id == null) {
                movieSearchResponseNewMovieSearchResponse$default = null;
            } else {
                String title = item.getTitle();
                String str2 = title == null ? "Unknown" : title;
                String image = item.getImage();
                String cat = item.getCat();
                List<String> formats = item.getFormats();
                if (formats == null) {
                    formats = CollectionsKt.emptyList();
                }
                SportzxVODLoadData loadData = new SportzxVODLoadData(id, str2, image, cat, formats);
                SportzxVODProvider sportzxVODProvider = this;
                String title2 = item.getTitle();
                movieSearchResponseNewMovieSearchResponse$default = MainAPIKt.newMovieSearchResponse$default(sportzxVODProvider, title2 == null ? "Unknown" : title2, AppUtils.INSTANCE.toJson(loadData), (TvType) null, false, new Function1() { // from class: com.cncverse.SportzxVODProvider$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj2) {
                        return SportzxVODProvider.getMainPage$lambda$0$0(item, (MovieSearchResponse) obj2);
                    }
                }, 12, (Object) null);
            }
            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                destination$iv$iv.add(movieSearchResponseNewMovieSearchResponse$default);
            }
            c00311 = c00311;
            $result = $result;
        }
        List searchResponses = (List) destination$iv$iv;
        return MainAPIKt.newHomePageResponse$default(new HomePageList(this.customName, searchResponses, false, 4, (DefaultConstructorMarker) null), (Boolean) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMainPage$lambda$0$0(SportzxVODData $item, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($item.getImage());
        return Unit.INSTANCE;
    }

    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        Object obj;
        Object objDecodeFromString;
        AppUtils appUtils = AppUtils.INSTANCE;
        try {
            Result.Companion companion = Result.Companion;
            KType kTypeTypeOf = Reflection.typeOf(SportzxVODLoadData.class);
            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
            obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            try {
                Result.Companion companion3 = Result.Companion;
                obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(SportzxVODLoadData.class), (List) null, 2, (Object) null));
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
                objDecodeFromString = $this$readValue$iv$iv.readValue(url, new TypeReference<SportzxVODLoadData>() { // from class: com.cncverse.SportzxVODProvider$load$$inlined$parseJson$1
                });
            } catch (Throwable th3) {
                ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                objDecodeFromString = $this$readValue$iv$iv2.readValue(url, new TypeReference<SportzxVODLoadData>() { // from class: com.cncverse.SportzxVODProvider$load$$inlined$parseJson$1
                });
            }
        } else {
            ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
            objDecodeFromString = $this$readValue$iv$iv3.readValue(url, new TypeReference<SportzxVODLoadData>() { // from class: com.cncverse.SportzxVODProvider$load$$inlined$parseJson$1
            });
        }
        SportzxVODLoadData data = (SportzxVODLoadData) objDecodeFromString;
        StringBuilder $this$load_u24lambda_u240 = new StringBuilder();
        $this$load_u24lambda_u240.append("📡 Available Formats: " + data.getFormats().size());
        String plot = $this$load_u24lambda_u240.toString();
        return MainAPIKt.newMovieLoadResponse(this, data.getTitle(), url, TvType.Movie, url, new C00322(data, plot, null), continuation);
    }

    /* JADX INFO: renamed from: com.cncverse.SportzxVODProvider$load$2 */
    /* JADX INFO: compiled from: SportzxVODProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.SportzxVODProvider$load$2", f = "SportzxVODProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00322 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ SportzxVODLoadData $data;
        final /* synthetic */ String $plot;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00322(SportzxVODLoadData sportzxVODLoadData, String str, Continuation<? super C00322> continuation) {
            super(2, continuation);
            this.$data = sportzxVODLoadData;
            this.$plot = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00322 = new C00322(this.$data, this.$plot, continuation);
            c00322.L$0 = obj;
            return c00322;
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
                    $this$newMovieLoadResponse.setPosterUrl(this.$data.getPoster());
                    $this$newMovieLoadResponse.setPlot(this.$plot);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0428  */
    /* JADX WARN: Code duplicated, block: B:103:0x0438  */
    /* JADX WARN: Code duplicated, block: B:105:0x046f  */
    /* JADX WARN: Code duplicated, block: B:107:0x0481  */
    /* JADX WARN: Code duplicated, block: B:110:0x04a9  */
    /* JADX WARN: Code duplicated, block: B:112:0x04d6  */
    /* JADX WARN: Code duplicated, block: B:115:0x050a  */
    /* JADX WARN: Code duplicated, block: B:118:0x0512  */
    /* JADX WARN: Code duplicated, block: B:120:0x052c  */
    /* JADX WARN: Code duplicated, block: B:122:0x058c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:128:0x0668  */
    /* JADX WARN: Code duplicated, block: B:130:0x070f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:131:0x0710  */
    /* JADX WARN: Code duplicated, block: B:133:0x073b  */
    /* JADX WARN: Code duplicated, block: B:134:0x073d  */
    /* JADX WARN: Code duplicated, block: B:137:0x0754  */
    /* JADX WARN: Code duplicated, block: B:144:0x077d  */
    /* JADX WARN: Code duplicated, block: B:147:0x080c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:148:0x080d  */
    /* JADX WARN: Code duplicated, block: B:151:0x084c  */
    /* JADX WARN: Code duplicated, block: B:187:0x04fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:97:0x040d  */
    /* JADX WARN: Code duplicated, block: B:99:0x041e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:148:0x080d -> B:149:0x0827). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object loadLinks(@org.jetbrains.annotations.NotNull java.lang.String r43, boolean r44, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r45, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r46, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r47) {
        /*
            Method dump skipped, instruction units count: 2218
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cncverse.SportzxVODProvider.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final String loadLinks$lambda$0$hexToBase64Url(String hex) {
        try {
            Iterable $this$map$iv = StringsKt.chunked(hex, 2);
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                String it = (String) item$iv$iv;
                destination$iv$iv.add(Byte.valueOf((byte) Integer.parseInt(it, CharsKt.checkRadix(16))));
            }
            byte[] bytes = CollectionsKt.toByteArray((List) destination$iv$iv);
            return Base64.encodeToString(bytes, 11);
        } catch (Exception e) {
            return null;
        }
    }
}
