package com.hdo;

import android.content.Context;
import android.util.Log;
import com.cncverse.donation.DonationManager;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.metaproviders.TmdbLink;
import com.lagradost.cloudstream3.metaproviders.TmdbProvider;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: HDO.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/HDOProvider/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 32\u00020\u0001:\u000534567B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0096@¢\u0006\u0002\u0010\"JF\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u000b2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)0'2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020)0'H\u0096@¢\u0006\u0002\u0010,J\f\u0010-\u001a\u00020.*\u00020/H\u0002J*\u00100\u001a\u00020\u000b2\u0006\u00101\u001a\u00020.2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020)0'H\u0082@¢\u0006\u0002\u00102R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0007\"\u0004\b\u0010\u0010\tR\u0014\u0010\u0011\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0014\u0010\u0013\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\rR\u0014\u0010\u0015\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\rR\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u00068"}, d2 = {"Lcom/hdo/HDO;", "Lcom/lagradost/cloudstream3/metaproviders/TmdbProvider;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "instantLinkLoading", "getInstantLinkLoading", "useMetaLoadResponse", "getUseMetaLoadResponse", "hasQuickSearch", "getHasQuickSearch", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toLinkData", "Lcom/hdo/HDO$HulaMovieInfo;", "Lcom/lagradost/cloudstream3/metaproviders/TmdbLink;", "callHulaApiServer", "mediaData", "(Lcom/hdo/HDO$HulaMovieInfo;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "HulaMovieInfo", "HulaApiResponse", "HulaResult", "HulaTrack", "HDOProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nHDO.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HDO.kt\ncom/hdo/HDO\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,223:1\n63#2:224\n64#2,15:226\n63#2:244\n64#2,15:246\n1#3:225\n1#3:243\n1#3:245\n50#4:241\n43#4:242\n50#4:261\n43#4:262\n*S KotlinDebug\n*F\n+ 1 HDO.kt\ncom/hdo/HDO\n*L\n48#1:224\n48#1:226,15\n160#1:244\n160#1:246,15\n48#1:225\n160#1:245\n48#1:241\n48#1:242\n160#1:261\n160#1:262\n*E\n"})
public final class HDO extends TmdbProvider {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static Context cont;

    @NotNull
    private String name = "HDO";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "ta";
    private final boolean instantLinkLoading = true;
    private final boolean useMetaLoadResponse = true;
    private final boolean hasQuickSearch = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries});

    /* JADX INFO: renamed from: com.hdo.HDO$callHulaApiServer$1 */
    /* JADX INFO: compiled from: HDO.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.hdo.HDO", f = "HDO.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2}, l = {154, 179, 196}, m = "callHulaApiServer", n = {"mediaData", "callback", "apiUrl", "mediaData", "callback", "apiUrl", "response", "apiResponse", "result", "referer", "headers", "track", "quality", "mediaData", "callback", "apiUrl", "response", "apiResponse", "result", "referer", "headers"}, nl = {155, 178, 195}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$7", "L$8", "L$10", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$7", "L$8"}, v = 2)
    static final class C00021 extends ContinuationImpl {
        int I$0;
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

        C00021(Continuation<? super C00021> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HDO.this.callHulaApiServer(null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.hdo.HDO$loadLinks$1 */
    /* JADX INFO: compiled from: HDO.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.hdo.HDO", f = "HDO.kt", i = {0, 0, 0, 0, 0}, l = {53}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "mediaData", "isCasting"}, nl = {79}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0"}, v = 2)
    static final class C00051 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
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
            return HDO.this.loadLinks(null, false, null, null, (Continuation) this);
        }
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

    public boolean getInstantLinkLoading() {
        return this.instantLinkLoading;
    }

    public boolean getUseMetaLoadResponse() {
        return this.useMetaLoadResponse;
    }

    public boolean getHasQuickSearch() {
        return this.hasQuickSearch;
    }

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    /* JADX INFO: compiled from: HDO.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/hdo/HDO$Companion;", "", "<init>", "()V", "cont", "Landroid/content/Context;", "getCont", "()Landroid/content/Context;", "setCont", "(Landroid/content/Context;)V", "HDOProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Nullable
        public final Context getCont() {
            return HDO.cont;
        }

        public final void setCont(@Nullable Context context) {
            HDO.cont = context;
        }
    }

    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        DonationManager.INSTANCE.checkAndShow(getName());
        return super.getMainPage(page, request, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00051 c00051;
        Object obj;
        Object objDecodeFromString;
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
                AppUtils appUtils = AppUtils.INSTANCE;
                try {
                    Result.Companion companion = Result.Companion;
                    KType kTypeTypeOf = Reflection.typeOf(TmdbLink.class);
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (Result.exceptionOrNull-impl(obj) != null) {
                    try {
                        Result.Companion companion3 = Result.Companion;
                        obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(TmdbLink.class), (List) null, 2, (Object) null));
                    } catch (Throwable th2) {
                        Result.Companion companion4 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th2));
                    }
                }
                DeserializationStrategy deserializationStrategy = (KSerializer) (Result.isFailure-impl(obj) ? null : obj);
                if (deserializationStrategy != null) {
                    try {
                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, data);
                    } catch (SerializationException e) {
                        ArchComponentExtKt.logError(e);
                        ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv.readValue(data, new TypeReference<TmdbLink>() { // from class: com.hdo.HDO$loadLinks$$inlined$parseJson$1
                        });
                    } catch (Throwable th3) {
                        ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv2.readValue(data, new TypeReference<TmdbLink>() { // from class: com.hdo.HDO$loadLinks$$inlined$parseJson$1
                        });
                    }
                } else {
                    ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv3.readValue(data, new TypeReference<TmdbLink>() { // from class: com.hdo.HDO$loadLinks$$inlined$parseJson$1
                    });
                }
                HulaMovieInfo mediaData = toLinkData((TmdbLink) objDecodeFromString);
                Log.d("HDOProvider", "Loading links for: " + mediaData.getTitle() + " (" + mediaData.getType() + ')');
                C00062 c00062 = new C00062(mediaData, function1, this, function2, null);
                c00052.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00052.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                c00052.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                c00052.L$3 = SpillingKt.nullOutSpilledVariable(mediaData);
                c00052.Z$0 = isCasting;
                c00052.label = 1;
                if (ArchComponentExtKt.safeApiCall(c00062, c00052) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                boolean z = c00052.Z$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Boxing.boxBoolean(true);
    }

    /* JADX INFO: renamed from: com.hdo.HDO$loadLinks$2 */
    /* JADX INFO: compiled from: HDO.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.hdo.HDO$loadLinks$2", f = "HDO.kt", i = {}, l = {54, 61, 70}, m = "invokeSuspend", n = {}, nl = {61, 69, 72}, s = {}, v = 2)
    static final class C00062 extends SuspendLambda implements Function1<Continuation<? super Integer>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ HulaMovieInfo $mediaData;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        int label;
        final /* synthetic */ HDO this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00062(HulaMovieInfo hulaMovieInfo, Function1<? super SubtitleFile, Unit> function1, HDO hdo, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00062> continuation) {
            super(1, continuation);
            this.$mediaData = hulaMovieInfo;
            this.$subtitleCallback = function1;
            this.this$0 = hdo;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00062(this.$mediaData, this.$subtitleCallback, this.this$0, this.$callback, continuation);
        }

        public final Object invoke(Continuation<? super Integer> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:14:0x0068 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:17:0x0080 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:20:0x0089  */
        /* JADX WARN: Code duplicated, block: B:21:0x0090  */
        public final Object invokeSuspend(Object $result) {
            Object objCallHulaApiServer;
            boolean hasResults;
            int iW;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (SubUtils.INSTANCE.invokeWyZIESUBAPI(this.$mediaData.getImdbId(), this.$mediaData.getSeason(), this.$mediaData.getEpisode(), this.$subtitleCallback, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    this.label = 2;
                    if (SubUtils.INSTANCE.invokeSubtitleAPI(this.$mediaData.getImdbId(), this.$mediaData.getSeason(), this.$mediaData.getEpisode(), this.$subtitleCallback, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Log.d("HDOProvider", "Calling Hula API server...");
                    this.label = 3;
                    objCallHulaApiServer = this.this$0.callHulaApiServer(this.$mediaData, this.$callback, (Continuation) this);
                    if (objCallHulaApiServer == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    hasResults = ((Boolean) objCallHulaApiServer).booleanValue();
                    if (hasResults) {
                        iW = Log.d("HDOProvider", "Successfully loaded video links from Hula API");
                    } else {
                        iW = Log.w("HDOProvider", "Failed to load video links from Hula API");
                    }
                    return Boxing.boxInt(iW);
                case 1:
                    ResultKt.throwOnFailure($result);
                    this.label = 2;
                    if (SubUtils.INSTANCE.invokeSubtitleAPI(this.$mediaData.getImdbId(), this.$mediaData.getSeason(), this.$mediaData.getEpisode(), this.$subtitleCallback, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Log.d("HDOProvider", "Calling Hula API server...");
                    this.label = 3;
                    objCallHulaApiServer = this.this$0.callHulaApiServer(this.$mediaData, this.$callback, (Continuation) this);
                    if (objCallHulaApiServer == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    hasResults = ((Boolean) objCallHulaApiServer).booleanValue();
                    if (hasResults) {
                        iW = Log.d("HDOProvider", "Successfully loaded video links from Hula API");
                    } else {
                        iW = Log.w("HDOProvider", "Failed to load video links from Hula API");
                    }
                    return Boxing.boxInt(iW);
                case 2:
                    ResultKt.throwOnFailure($result);
                    Log.d("HDOProvider", "Calling Hula API server...");
                    this.label = 3;
                    objCallHulaApiServer = this.this$0.callHulaApiServer(this.$mediaData, this.$callback, (Continuation) this);
                    if (objCallHulaApiServer == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    hasResults = ((Boolean) objCallHulaApiServer).booleanValue();
                    if (hasResults) {
                        iW = Log.d("HDOProvider", "Successfully loaded video links from Hula API");
                    } else {
                        iW = Log.w("HDOProvider", "Failed to load video links from Hula API");
                    }
                    return Boxing.boxInt(iW);
                case 3:
                    ResultKt.throwOnFailure($result);
                    objCallHulaApiServer = $result;
                    hasResults = ((Boolean) objCallHulaApiServer).booleanValue();
                    if (hasResults) {
                        iW = Log.d("HDOProvider", "Successfully loaded video links from Hula API");
                    } else {
                        iW = Log.w("HDOProvider", "Failed to load video links from Hula API");
                    }
                    return Boxing.boxInt(iW);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: compiled from: HDO.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jb\u0010\u001e\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0014\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010#\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010$\u001a\u00020\u0003HÖ\u0081\u0004R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0013\u0010\u0010R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0014\u0010\u0010R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0015\u0010\u0010R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006%"}, d2 = {"Lcom/hdo/HDO$HulaMovieInfo;", "", "imdbId", "", "tmdbId", "", "title", "year", "season", "episode", "type", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getImdbId", "()Ljava/lang/String;", "getTmdbId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTitle", "getYear", "getSeason", "getEpisode", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/hdo/HDO$HulaMovieInfo;", "equals", "", "other", "hashCode", "toString", "HDOProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class HulaMovieInfo {

        @JsonProperty("episode")
        @Nullable
        private final Integer episode;

        @JsonProperty("imdbId")
        @Nullable
        private final String imdbId;

        @JsonProperty("season")
        @Nullable
        private final Integer season;

        @JsonProperty("title")
        @Nullable
        private final String title;

        @JsonProperty("tmdbId")
        @Nullable
        private final Integer tmdbId;

        @JsonProperty("type")
        @Nullable
        private final String type;

        @JsonProperty("year")
        @Nullable
        private final Integer year;

        public HulaMovieInfo() {
            this(null, null, null, null, null, null, null, 127, null);
        }

        public static /* synthetic */ HulaMovieInfo copy$default(HulaMovieInfo hulaMovieInfo, String str, Integer num, String str2, Integer num2, Integer num3, Integer num4, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = hulaMovieInfo.imdbId;
            }
            if ((i & 2) != 0) {
                num = hulaMovieInfo.tmdbId;
            }
            if ((i & 4) != 0) {
                str2 = hulaMovieInfo.title;
            }
            if ((i & 8) != 0) {
                num2 = hulaMovieInfo.year;
            }
            if ((i & 16) != 0) {
                num3 = hulaMovieInfo.season;
            }
            if ((i & 32) != 0) {
                num4 = hulaMovieInfo.episode;
            }
            if ((i & 64) != 0) {
                str3 = hulaMovieInfo.type;
            }
            Integer num5 = num4;
            String str4 = str3;
            Integer num6 = num3;
            String str5 = str2;
            return hulaMovieInfo.copy(str, num, str5, num2, num6, num5, str4);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getImdbId() {
            return this.imdbId;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getTmdbId() {
            return this.tmdbId;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getYear() {
            return this.year;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Integer getSeason() {
            return this.season;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Integer getEpisode() {
            return this.episode;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @NotNull
        public final HulaMovieInfo copy(@JsonProperty("imdbId") @Nullable String imdbId, @JsonProperty("tmdbId") @Nullable Integer tmdbId, @JsonProperty("title") @Nullable String title, @JsonProperty("year") @Nullable Integer year, @JsonProperty("season") @Nullable Integer season, @JsonProperty("episode") @Nullable Integer episode, @JsonProperty("type") @Nullable String type) {
            return new HulaMovieInfo(imdbId, tmdbId, title, year, season, episode, type);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HulaMovieInfo)) {
                return false;
            }
            HulaMovieInfo hulaMovieInfo = (HulaMovieInfo) other;
            return Intrinsics.areEqual(this.imdbId, hulaMovieInfo.imdbId) && Intrinsics.areEqual(this.tmdbId, hulaMovieInfo.tmdbId) && Intrinsics.areEqual(this.title, hulaMovieInfo.title) && Intrinsics.areEqual(this.year, hulaMovieInfo.year) && Intrinsics.areEqual(this.season, hulaMovieInfo.season) && Intrinsics.areEqual(this.episode, hulaMovieInfo.episode) && Intrinsics.areEqual(this.type, hulaMovieInfo.type);
        }

        public int hashCode() {
            return ((((((((((((this.imdbId == null ? 0 : this.imdbId.hashCode()) * 31) + (this.tmdbId == null ? 0 : this.tmdbId.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.year == null ? 0 : this.year.hashCode())) * 31) + (this.season == null ? 0 : this.season.hashCode())) * 31) + (this.episode == null ? 0 : this.episode.hashCode())) * 31) + (this.type != null ? this.type.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "HulaMovieInfo(imdbId=" + this.imdbId + ", tmdbId=" + this.tmdbId + ", title=" + this.title + ", year=" + this.year + ", season=" + this.season + ", episode=" + this.episode + ", type=" + this.type + ')';
        }

        public HulaMovieInfo(@JsonProperty("imdbId") @Nullable String imdbId, @JsonProperty("tmdbId") @Nullable Integer tmdbId, @JsonProperty("title") @Nullable String title, @JsonProperty("year") @Nullable Integer year, @JsonProperty("season") @Nullable Integer season, @JsonProperty("episode") @Nullable Integer episode, @JsonProperty("type") @Nullable String type) {
            this.imdbId = imdbId;
            this.tmdbId = tmdbId;
            this.title = title;
            this.year = year;
            this.season = season;
            this.episode = episode;
            this.type = type;
        }

        public /* synthetic */ HulaMovieInfo(String str, Integer num, String str2, Integer num2, Integer num3, Integer num4, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? null : num3, (i & 32) != 0 ? null : num4, (i & 64) != 0 ? null : str3);
        }

        @Nullable
        public final String getImdbId() {
            return this.imdbId;
        }

        @Nullable
        public final Integer getTmdbId() {
            return this.tmdbId;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final Integer getYear() {
            return this.year;
        }

        @Nullable
        public final Integer getSeason() {
            return this.season;
        }

        @Nullable
        public final Integer getEpisode() {
            return this.episode;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }
    }

    /* JADX INFO: compiled from: HDO.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0003\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J/\u0010\u0014\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\u000e\b\u0003\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/hdo/HDO$HulaApiResponse;", "", "query", "Lcom/hdo/HDO$HulaMovieInfo;", "count", "", "results", "", "Lcom/hdo/HDO$HulaResult;", "<init>", "(Lcom/hdo/HDO$HulaMovieInfo;ILjava/util/List;)V", "getQuery", "()Lcom/hdo/HDO$HulaMovieInfo;", "getCount", "()I", "getResults", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "HDOProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class HulaApiResponse {

        @JsonProperty("count")
        private final int count;

        @JsonProperty("query")
        @Nullable
        private final HulaMovieInfo query;

        @JsonProperty("results")
        @NotNull
        private final List<HulaResult> results;

        public HulaApiResponse() {
            this(null, 0, null, 7, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ HulaApiResponse copy$default(HulaApiResponse hulaApiResponse, HulaMovieInfo hulaMovieInfo, int i, List list, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                hulaMovieInfo = hulaApiResponse.query;
            }
            if ((i2 & 2) != 0) {
                i = hulaApiResponse.count;
            }
            if ((i2 & 4) != 0) {
                list = hulaApiResponse.results;
            }
            return hulaApiResponse.copy(hulaMovieInfo, i, list);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final HulaMovieInfo getQuery() {
            return this.query;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getCount() {
            return this.count;
        }

        @NotNull
        public final List<HulaResult> component3() {
            return this.results;
        }

        @NotNull
        public final HulaApiResponse copy(@JsonProperty("query") @Nullable HulaMovieInfo query, @JsonProperty("count") int count, @JsonProperty("results") @NotNull List<HulaResult> results) {
            return new HulaApiResponse(query, count, results);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HulaApiResponse)) {
                return false;
            }
            HulaApiResponse hulaApiResponse = (HulaApiResponse) other;
            return Intrinsics.areEqual(this.query, hulaApiResponse.query) && this.count == hulaApiResponse.count && Intrinsics.areEqual(this.results, hulaApiResponse.results);
        }

        public int hashCode() {
            return ((((this.query == null ? 0 : this.query.hashCode()) * 31) + this.count) * 31) + this.results.hashCode();
        }

        @NotNull
        public String toString() {
            return "HulaApiResponse(query=" + this.query + ", count=" + this.count + ", results=" + this.results + ')';
        }

        public HulaApiResponse(@JsonProperty("query") @Nullable HulaMovieInfo query, @JsonProperty("count") int count, @JsonProperty("results") @NotNull List<HulaResult> list) {
            this.query = query;
            this.count = count;
            this.results = list;
        }

        public /* synthetic */ HulaApiResponse(HulaMovieInfo hulaMovieInfo, int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? null : hulaMovieInfo, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? CollectionsKt.emptyList() : list);
        }

        @Nullable
        public final HulaMovieInfo getQuery() {
            return this.query;
        }

        public final int getCount() {
            return this.count;
        }

        @NotNull
        public final List<HulaResult> getResults() {
            return this.results;
        }
    }

    /* JADX INFO: compiled from: HDO.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0003\u0010\b\u001a\u00020\u0003\u0012\u0014\b\u0003\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n\u0012\u000e\b\u0003\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u0015\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\nHÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003Jg\u0010\"\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\u00032\u0014\b\u0003\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n2\u000e\b\u0003\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0001J\u0014\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010&\u001a\u00020\u0007HÖ\u0081\u0004J\n\u0010'\u001a\u00020\u0003HÖ\u0081\u0004R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\"\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006("}, d2 = {"Lcom/hdo/HDO$HulaResult;", "", "provider", "", "host", "type", "quality", "", "url", "headers", "", "tracks", "", "Lcom/hdo/HDO$HulaTrack;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/util/Map;Ljava/util/List;)V", "getProvider", "()Ljava/lang/String;", "getHost", "getType", "getQuality", "()I", "getUrl", "getHeaders", "()Ljava/util/Map;", "getTracks", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "HDOProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class HulaResult {

        @JsonProperty("headers")
        @NotNull
        private final Map<String, String> headers;

        @JsonProperty("host")
        @Nullable
        private final String host;

        @JsonProperty("provider")
        @Nullable
        private final String provider;

        @JsonProperty("quality")
        private final int quality;

        @JsonProperty("tracks")
        @NotNull
        private final List<HulaTrack> tracks;

        @JsonProperty("type")
        @Nullable
        private final String type;

        @JsonProperty("url")
        @NotNull
        private final String url;

        public HulaResult() {
            this(null, null, null, 0, null, null, null, 127, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ HulaResult copy$default(HulaResult hulaResult, String str, String str2, String str3, int i, String str4, Map map, List list, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = hulaResult.provider;
            }
            if ((i2 & 2) != 0) {
                str2 = hulaResult.host;
            }
            if ((i2 & 4) != 0) {
                str3 = hulaResult.type;
            }
            if ((i2 & 8) != 0) {
                i = hulaResult.quality;
            }
            if ((i2 & 16) != 0) {
                str4 = hulaResult.url;
            }
            if ((i2 & 32) != 0) {
                map = hulaResult.headers;
            }
            if ((i2 & 64) != 0) {
                list = hulaResult.tracks;
            }
            Map map2 = map;
            List list2 = list;
            String str5 = str4;
            String str6 = str3;
            return hulaResult.copy(str, str2, str6, i, str5, map2, list2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getProvider() {
            return this.provider;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getHost() {
            return this.host;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getQuality() {
            return this.quality;
        }

        @NotNull
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @NotNull
        public final Map<String, String> component6() {
            return this.headers;
        }

        @NotNull
        public final List<HulaTrack> component7() {
            return this.tracks;
        }

        @NotNull
        public final HulaResult copy(@JsonProperty("provider") @Nullable String provider, @JsonProperty("host") @Nullable String host, @JsonProperty("type") @Nullable String type, @JsonProperty("quality") int quality, @JsonProperty("url") @NotNull String url, @JsonProperty("headers") @NotNull Map<String, String> headers, @JsonProperty("tracks") @NotNull List<HulaTrack> tracks) {
            return new HulaResult(provider, host, type, quality, url, headers, tracks);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HulaResult)) {
                return false;
            }
            HulaResult hulaResult = (HulaResult) other;
            return Intrinsics.areEqual(this.provider, hulaResult.provider) && Intrinsics.areEqual(this.host, hulaResult.host) && Intrinsics.areEqual(this.type, hulaResult.type) && this.quality == hulaResult.quality && Intrinsics.areEqual(this.url, hulaResult.url) && Intrinsics.areEqual(this.headers, hulaResult.headers) && Intrinsics.areEqual(this.tracks, hulaResult.tracks);
        }

        public int hashCode() {
            return ((((((((((((this.provider == null ? 0 : this.provider.hashCode()) * 31) + (this.host == null ? 0 : this.host.hashCode())) * 31) + (this.type != null ? this.type.hashCode() : 0)) * 31) + this.quality) * 31) + this.url.hashCode()) * 31) + this.headers.hashCode()) * 31) + this.tracks.hashCode();
        }

        @NotNull
        public String toString() {
            return "HulaResult(provider=" + this.provider + ", host=" + this.host + ", type=" + this.type + ", quality=" + this.quality + ", url=" + this.url + ", headers=" + this.headers + ", tracks=" + this.tracks + ')';
        }

        public HulaResult(@JsonProperty("provider") @Nullable String provider, @JsonProperty("host") @Nullable String host, @JsonProperty("type") @Nullable String type, @JsonProperty("quality") int quality, @JsonProperty("url") @NotNull String url, @JsonProperty("headers") @NotNull Map<String, String> map, @JsonProperty("tracks") @NotNull List<HulaTrack> list) {
            this.provider = provider;
            this.host = host;
            this.type = type;
            this.quality = quality;
            this.url = url;
            this.headers = map;
            this.tracks = list;
        }

        public /* synthetic */ HulaResult(String str, String str2, String str3, int i, String str4, Map map, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? 720 : i, (i2 & 16) != 0 ? "" : str4, (i2 & 32) != 0 ? MapsKt.emptyMap() : map, (i2 & 64) != 0 ? CollectionsKt.emptyList() : list);
        }

        @Nullable
        public final String getProvider() {
            return this.provider;
        }

        @Nullable
        public final String getHost() {
            return this.host;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }

        public final int getQuality() {
            return this.quality;
        }

        @NotNull
        public final String getUrl() {
            return this.url;
        }

        @NotNull
        public final Map<String, String> getHeaders() {
            return this.headers;
        }

        @NotNull
        public final List<HulaTrack> getTracks() {
            return this.tracks;
        }
    }

    /* JADX INFO: compiled from: HDO.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/hdo/HDO$HulaTrack;", "", "file", "", "quality", "", "<init>", "(Ljava/lang/String;I)V", "getFile", "()Ljava/lang/String;", "getQuality", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "HDOProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class HulaTrack {

        @JsonProperty("file")
        @NotNull
        private final String file;

        @JsonProperty("quality")
        private final int quality;

        /* JADX WARN: Illegal instructions before constructor call */
        public HulaTrack() {
            String str = null;
            this(str, 0, 3, str);
        }

        public static /* synthetic */ HulaTrack copy$default(HulaTrack hulaTrack, String str, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = hulaTrack.file;
            }
            if ((i2 & 2) != 0) {
                i = hulaTrack.quality;
            }
            return hulaTrack.copy(str, i);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getFile() {
            return this.file;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getQuality() {
            return this.quality;
        }

        @NotNull
        public final HulaTrack copy(@JsonProperty("file") @NotNull String file, @JsonProperty("quality") int quality) {
            return new HulaTrack(file, quality);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HulaTrack)) {
                return false;
            }
            HulaTrack hulaTrack = (HulaTrack) other;
            return Intrinsics.areEqual(this.file, hulaTrack.file) && this.quality == hulaTrack.quality;
        }

        public int hashCode() {
            return (this.file.hashCode() * 31) + this.quality;
        }

        @NotNull
        public String toString() {
            return "HulaTrack(file=" + this.file + ", quality=" + this.quality + ')';
        }

        public HulaTrack(@JsonProperty("file") @NotNull String file, @JsonProperty("quality") int quality) {
            this.file = file;
            this.quality = quality;
        }

        public /* synthetic */ HulaTrack(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 720 : i);
        }

        @NotNull
        public final String getFile() {
            return this.file;
        }

        public final int getQuality() {
            return this.quality;
        }
    }

    private final HulaMovieInfo toLinkData(TmdbLink $this$toLinkData) {
        String strSubstringAfterLast;
        String strSubstringBefore;
        boolean isMovie = $this$toLinkData.getSeason() == null;
        String imdbID = $this$toLinkData.getImdbID();
        Integer tmdbID = $this$toLinkData.getTmdbID();
        String movieName = $this$toLinkData.getMovieName();
        String movieName2 = $this$toLinkData.getMovieName();
        return new HulaMovieInfo(imdbID, tmdbID, movieName, (movieName2 == null || (strSubstringAfterLast = StringsKt.substringAfterLast(movieName2, "(", "")) == null || (strSubstringBefore = StringsKt.substringBefore(strSubstringAfterLast, ")", "")) == null) ? null : StringsKt.toIntOrNull(strSubstringBefore), $this$toLinkData.getSeason(), $this$toLinkData.getEpisode(), isMovie ? "movie" : "tv");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:127:0x0492 A[Catch: Exception -> 0x05de, TryCatch #6 {Exception -> 0x05de, blocks: (B:125:0x048c, B:127:0x0492, B:132:0x04a9, B:135:0x04b6), top: B:223:0x048c }] */
    /* JADX WARN: Code duplicated, block: B:129:0x04a4  */
    /* JADX WARN: Code duplicated, block: B:130:0x04a6  */
    /* JADX WARN: Code duplicated, block: B:134:0x04b4  */
    /* JADX WARN: Code duplicated, block: B:141:0x052f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:142:0x0530  */
    /* JADX WARN: Code duplicated, block: B:161:0x05bf A[LOOP:1: B:223:0x048c->B:161:0x05bf, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:272:0x04a9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:148:0x056c -> B:223:0x048c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:162:0x05cb -> B:253:0x042a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:183:0x068e -> B:231:0x069d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:199:0x0730 -> B:253:0x042a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object callHulaApiServer(com.hdo.HDO.HulaMovieInfo r32, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r33, kotlin.coroutines.Continuation<? super java.lang.Boolean> r34) {
        /*
            Method dump skipped, instruction units count: 1976
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hdo.HDO.callHulaApiServer(com.hdo.HDO$HulaMovieInfo, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.hdo.HDO$callHulaApiServer$2 */
    /* JADX INFO: compiled from: HDO.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.hdo.HDO$callHulaApiServer$2", f = "HDO.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00032 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ Map<String, String> $headers;
        final /* synthetic */ int $quality;
        final /* synthetic */ String $referer;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00032(int i, String str, Map<String, String> map, Continuation<? super C00032> continuation) {
            super(2, continuation);
            this.$quality = i;
            this.$referer = str;
            this.$headers = map;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00032 = new C00032(this.$quality, this.$referer, this.$headers, continuation);
            c00032.L$0 = obj;
            return c00032;
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
                    $this$newExtractorLink.setQuality(this.$quality);
                    $this$newExtractorLink.setReferer(this.$referer);
                    $this$newExtractorLink.setHeaders(this.$headers);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.hdo.HDO$callHulaApiServer$3 */
    /* JADX INFO: compiled from: HDO.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.hdo.HDO$callHulaApiServer$3", f = "HDO.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00043 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ Map<String, String> $headers;
        final /* synthetic */ String $referer;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00043(String str, Map<String, String> map, Continuation<? super C00043> continuation) {
            super(2, continuation);
            this.$referer = str;
            this.$headers = map;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00043 = new C00043(this.$referer, this.$headers, continuation);
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
                    $this$newExtractorLink.setQuality(720);
                    $this$newExtractorLink.setReferer(this.$referer);
                    $this$newExtractorLink.setHeaders(this.$headers);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
