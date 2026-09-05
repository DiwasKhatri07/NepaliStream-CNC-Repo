package com.phisher98;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.DrmExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import com.lagradost.cloudstream3.utils.Qualities;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
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

/* JADX INFO: compiled from: PirateIPTV.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/QuickIPTV/classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JF\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00112\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001f2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020!0\u001fH\u0096@¢\u0006\u0002\u0010$R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006%"}, d2 = {"Lcom/phisher98/PirateIPTV;", "Lcom/phisher98/SportsIPTV;", "<init>", "()V", "lang", "", "getLang", "()Ljava/lang/String;", "setLang", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "hasChromecastSupport", "getHasChromecastSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "QuickIPTV"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPirateIPTV.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PirateIPTV.kt\ncom/phisher98/PirateIPTV\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,78:1\n63#2:79\n64#2,15:81\n1#3:80\n50#4:96\n43#4:97\n*S KotlinDebug\n*F\n+ 1 PirateIPTV.kt\ncom/phisher98/PirateIPTV\n*L\n30#1:79\n30#1:81,15\n30#1:80\n30#1:96\n30#1:97\n*E\n"})
public final class PirateIPTV extends SportsIPTV {

    @NotNull
    private String lang = "en";

    @NotNull
    private String mainUrl = "https://raw.githubusercontent.com/FunctionError/PiratesTvPlus/refs/heads/main/PiratesPlus.m3u";

    @NotNull
    private String name = "Pirate IPTV";
    private final boolean hasMainPage = true;
    private final boolean hasChromecastSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(TvType.Live);

    /* JADX INFO: renamed from: com.phisher98.PirateIPTV$loadLinks$1 */
    /* JADX INFO: compiled from: PirateIPTV.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.PirateIPTV", f = "PirateIPTV.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {34, 51, 65}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "loadData", "isCasting", "data", "subtitleCallback", "callback", "loadData", "isCasting", "data", "subtitleCallback", "callback", "loadData", "isCasting"}, nl = {33, 50, 64}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0"}, v = 2)
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
            return PirateIPTV.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    @Override // com.phisher98.SportsIPTV
    @NotNull
    public String getLang() {
        return this.lang;
    }

    @Override // com.phisher98.SportsIPTV
    public void setLang(@NotNull String str) {
        this.lang = str;
    }

    @Override // com.phisher98.SportsIPTV
    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    @Override // com.phisher98.SportsIPTV
    public void setMainUrl(@NotNull String str) {
        this.mainUrl = str;
    }

    @Override // com.phisher98.SportsIPTV
    @NotNull
    public String getName() {
        return this.name;
    }

    @Override // com.phisher98.SportsIPTV
    public void setName(@NotNull String str) {
        this.name = str;
    }

    @Override // com.phisher98.SportsIPTV
    public boolean getHasMainPage() {
        return this.hasMainPage;
    }

    @Override // com.phisher98.SportsIPTV
    public boolean getHasChromecastSupport() {
        return this.hasChromecastSupport;
    }

    @Override // com.phisher98.SportsIPTV
    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    @Override // com.phisher98.SportsIPTV
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00041 c00041;
        PirateIPTV pirateIPTV;
        Object obj;
        Object objDecodeFromString;
        Object objNewExtractorLink;
        Function1<? super ExtractorLink, Unit> function3;
        Object objNewExtractorLink2;
        Function1<? super ExtractorLink, Unit> function4;
        Object objNewDrmExtractorLink;
        Function1<? super ExtractorLink, Unit> function5;
        if (continuation instanceof C00041) {
            c00041 = (C00041) continuation;
            if ((c00041.label & Integer.MIN_VALUE) != 0) {
                c00041.label -= Integer.MIN_VALUE;
                pirateIPTV = this;
            } else {
                pirateIPTV = this;
                c00041 = pirateIPTV.new C00041(continuation);
            }
        } else {
            pirateIPTV = this;
            c00041 = pirateIPTV.new C00041(continuation);
        }
        C00041 c00042 = c00041;
        Object $result = c00042.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00042.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                AppUtils appUtils = AppUtils.INSTANCE;
                try {
                    Result.Companion companion = Result.Companion;
                    KType kTypeTypeOf = Reflection.typeOf(SportsIPTV.LoadData.class);
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
                        obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(SportsIPTV.LoadData.class), (List) null, 2, (Object) null));
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
                        objDecodeFromString = $this$readValue$iv$iv.readValue(data, new TypeReference<SportsIPTV.LoadData>() { // from class: com.phisher98.PirateIPTV$loadLinks$$inlined$parseJson$1
                        });
                    } catch (Throwable th3) {
                        ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv2.readValue(data, new TypeReference<SportsIPTV.LoadData>() { // from class: com.phisher98.PirateIPTV$loadLinks$$inlined$parseJson$1
                        });
                    }
                    break;
                } else {
                    ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv3.readValue(data, new TypeReference<SportsIPTV.LoadData>() { // from class: com.phisher98.PirateIPTV$loadLinks$$inlined$parseJson$1
                    });
                }
                SportsIPTV.LoadData loadData = (SportsIPTV.LoadData) objDecodeFromString;
                if (StringsKt.contains$default(loadData.getUrl(), "mpd", false, 2, (Object) null)) {
                    String name = pirateIPTV.getName();
                    String name2 = pirateIPTV.getName();
                    String url = loadData.getUrl();
                    ExtractorLinkType infer_type = ExtractorApiKt.getINFER_TYPE();
                    UUID uuidRandomUUID = UUID.randomUUID();
                    C00052 c00052 = new C00052(loadData, null);
                    c00042.L$0 = SpillingKt.nullOutSpilledVariable(data);
                    c00042.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                    c00042.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                    c00042.L$3 = SpillingKt.nullOutSpilledVariable(loadData);
                    c00042.L$4 = function2;
                    c00042.Z$0 = isCasting;
                    c00042.label = 1;
                    objNewDrmExtractorLink = ExtractorApiKt.newDrmExtractorLink(name, name2, url, infer_type, uuidRandomUUID, c00052, c00042);
                    if (objNewDrmExtractorLink == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function5 = function2;
                    function5.invoke(objNewDrmExtractorLink);
                    return Boxing.boxBoolean(true);
                }
                if (StringsKt.contains$default(loadData.getUrl(), "&e=.m3u", false, 2, (Object) null)) {
                    String name3 = pirateIPTV.getName();
                    String name4 = pirateIPTV.getName();
                    String url2 = loadData.getUrl();
                    ExtractorLinkType extractorLinkType = ExtractorLinkType.M3U8;
                    C00063 c00063 = new C00063(null);
                    c00042.L$0 = SpillingKt.nullOutSpilledVariable(data);
                    c00042.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                    c00042.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                    c00042.L$3 = SpillingKt.nullOutSpilledVariable(loadData);
                    c00042.L$4 = function2;
                    c00042.Z$0 = isCasting;
                    c00042.label = 2;
                    objNewExtractorLink2 = ExtractorApiKt.newExtractorLink(name3, name4, url2, extractorLinkType, c00063, c00042);
                    if (objNewExtractorLink2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function4 = function2;
                    function4.invoke(objNewExtractorLink2);
                    return Boxing.boxBoolean(true);
                }
                String name5 = pirateIPTV.getName();
                String title = loadData.getTitle();
                String url3 = loadData.getUrl();
                ExtractorLinkType infer_type2 = ExtractorApiKt.getINFER_TYPE();
                C00074 c00074 = new C00074(null);
                c00042.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00042.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                c00042.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                c00042.L$3 = SpillingKt.nullOutSpilledVariable(loadData);
                c00042.L$4 = function2;
                c00042.Z$0 = isCasting;
                c00042.label = 3;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(name5, title, url3, infer_type2, c00074, c00042);
                if (objNewExtractorLink == coroutine_suspended) {
                    return coroutine_suspended;
                }
                function3 = function2;
                function3.invoke(objNewExtractorLink);
                return Boxing.boxBoolean(true);
            case 1:
                boolean isCasting2 = c00042.Z$0;
                function5 = (Function1) c00042.L$4;
                ResultKt.throwOnFailure($result);
                objNewDrmExtractorLink = $result;
                function5.invoke(objNewDrmExtractorLink);
                return Boxing.boxBoolean(true);
            case 2:
                boolean isCasting3 = c00042.Z$0;
                function4 = (Function1) c00042.L$4;
                ResultKt.throwOnFailure($result);
                objNewExtractorLink2 = $result;
                function4.invoke(objNewExtractorLink2);
                return Boxing.boxBoolean(true);
            case 3:
                boolean z = c00042.Z$0;
                function3 = (Function1) c00042.L$4;
                ResultKt.throwOnFailure($result);
                objNewExtractorLink = $result;
                function3.invoke(objNewExtractorLink);
                return Boxing.boxBoolean(true);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.phisher98.PirateIPTV$loadLinks$2 */
    /* JADX INFO: compiled from: PirateIPTV.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/DrmExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.PirateIPTV$loadLinks$2", f = "PirateIPTV.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00052 extends SuspendLambda implements Function2<DrmExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ SportsIPTV.LoadData $loadData;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00052(SportsIPTV.LoadData loadData, Continuation<? super C00052> continuation) {
            super(2, continuation);
            this.$loadData = loadData;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00052 = new C00052(this.$loadData, continuation);
            c00052.L$0 = obj;
            return c00052;
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
                    $this$newDrmExtractorLink.setKey(StringsKt.trim(this.$loadData.getKey()).toString());
                    $this$newDrmExtractorLink.setKid(StringsKt.trim(this.$loadData.getKeyid()).toString());
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.phisher98.PirateIPTV$loadLinks$3 */
    /* JADX INFO: compiled from: PirateIPTV.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.PirateIPTV$loadLinks$3", f = "PirateIPTV.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00063 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C00063(Continuation<? super C00063> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00063 = new C00063(continuation);
            c00063.L$0 = obj;
            return c00063;
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
                    $this$newExtractorLink.setReferer("https://embedme.top/");
                    $this$newExtractorLink.setQuality(Qualities.Unknown.getValue());
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.phisher98.PirateIPTV$loadLinks$4 */
    /* JADX INFO: compiled from: PirateIPTV.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.PirateIPTV$loadLinks$4", f = "PirateIPTV.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00074 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C00074(Continuation<? super C00074> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00074 = new C00074(continuation);
            c00074.L$0 = obj;
            return c00074;
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
                    $this$newExtractorLink.setReferer("https://embedme.top/");
                    $this$newExtractorLink.setQuality(Qualities.Unknown.getValue());
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
