package com.hindmoviez;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.plugins.BasePlugin;
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: hindmoviezPlugin.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Hindmoviez/Phisher98/java/classes.dex */
@CloudstreamPlugin
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016Ê\u0001\u0002\b\b¨\u0006\u0007"}, d2 = {"Lcom/hindmoviez/HindmoviezPlugin;", "Lcom/lagradost/cloudstream3/plugins/BasePlugin;", "<init>", "()V", "load", "", "Companion", "Hindmoviez", "Lcom/lagradost/cloudstream3/plugins/CloudstreamPlugin;"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class HindmoviezPlugin extends BasePlugin {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String DOMAINS_URL = "https://raw.githubusercontent.com/phisher98/TVVVV/refs/heads/main/domains.json";

    @Nullable
    private static Companion.Domains cachedDomains;

    public void load() {
        registerMainAPI(new Hindmoviez());
        registerExtractorAPI(new Gdshine());
    }

    /* JADX INFO: compiled from: hindmoviezPlugin.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/hindmoviez/HindmoviezPlugin$Companion;", "", "<init>", "()V", "DOMAINS_URL", "", "cachedDomains", "Lcom/hindmoviez/HindmoviezPlugin$Companion$Domains;", "getCachedDomains", "()Lcom/hindmoviez/HindmoviezPlugin$Companion$Domains;", "setCachedDomains", "(Lcom/hindmoviez/HindmoviezPlugin$Companion$Domains;)V", "getDomains", "forceRefresh", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Domains", "Hindmoviez"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nhindmoviezPlugin.kt\nKotlin\n*S Kotlin\n*F\n+ 1 hindmoviezPlugin.kt\ncom/hindmoviez/HindmoviezPlugin$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,37:1\n1#2:38\n1#2:42\n93#3,2:39\n63#3:41\n64#3,15:43\n95#3,2:60\n50#4:58\n43#4:59\n*S KotlinDebug\n*F\n+ 1 hindmoviezPlugin.kt\ncom/hindmoviez/HindmoviezPlugin$Companion\n*L\n24#1:42\n24#1:39,2\n24#1:41\n24#1:43,15\n24#1:60,2\n24#1:58\n24#1:59\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Nullable
        public final Domains getCachedDomains() {
            return HindmoviezPlugin.cachedDomains;
        }

        public final void setCachedDomains(@Nullable Domains domains) {
            HindmoviezPlugin.cachedDomains = domains;
        }

        public static /* synthetic */ Object getDomains$default(Companion companion, boolean z, Continuation continuation, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return companion.getDomains(z, continuation);
        }

        /* JADX WARN: Code duplicated, block: B:103:0x011b A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:34:0x00b2  */
        /* JADX WARN: Code duplicated, block: B:35:0x00b7  */
        /* JADX WARN: Code duplicated, block: B:47:0x010e A[Catch: Exception -> 0x014f, PHI: r0
          0x010e: PHI (r0v28 java.lang.Object) = (r0v19 java.lang.Object), (r0v22 java.lang.Object), (r0v27 java.lang.Object) binds: [B:41:0x00e2, B:46:0x0103, B:43:0x00e5] A[DONT_GENERATE, DONT_INLINE], TryCatch #1 {Exception -> 0x014f, blocks: (B:40:0x00de, B:47:0x010e, B:50:0x0115, B:59:0x0132, B:58:0x012c, B:46:0x0103, B:39:0x00d4, B:43:0x00e5, B:36:0x00bb, B:53:0x011b), top: B:87:0x00bb, inners: #2, #4, #6, #12 }] */
        /* JADX WARN: Code duplicated, block: B:49:0x0114  */
        /* JADX WARN: Code duplicated, block: B:59:0x0132 A[Catch: Exception -> 0x014f, TRY_LEAVE, TryCatch #1 {Exception -> 0x014f, blocks: (B:40:0x00de, B:47:0x010e, B:50:0x0115, B:59:0x0132, B:58:0x012c, B:46:0x0103, B:39:0x00d4, B:43:0x00e5, B:36:0x00bb, B:53:0x011b), top: B:87:0x00bb, inners: #2, #4, #6, #12 }] */
        /* JADX WARN: Code duplicated, block: B:7:0x001a  */
        /* JADX WARN: Code duplicated, block: B:88:0x00e5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Nullable
        public final Object getDomains(boolean forceRefresh, @NotNull Continuation<? super Domains> continuation) {
            HindmoviezPlugin$Companion$getDomains$1 hindmoviezPlugin$Companion$getDomains$1;
            Object obj;
            List list;
            Companion companion;
            String it;
            Object obj2;
            Object objDecodeFromString;
            Object obj3;
            DeserializationStrategy deserializationStrategy;
            if (continuation instanceof HindmoviezPlugin$Companion$getDomains$1) {
                hindmoviezPlugin$Companion$getDomains$1 = (HindmoviezPlugin$Companion$getDomains$1) continuation;
                if ((hindmoviezPlugin$Companion$getDomains$1.label & Integer.MIN_VALUE) != 0) {
                    hindmoviezPlugin$Companion$getDomains$1.label -= Integer.MIN_VALUE;
                } else {
                    hindmoviezPlugin$Companion$getDomains$1 = new HindmoviezPlugin$Companion$getDomains$1(this, continuation);
                }
            } else {
                hindmoviezPlugin$Companion$getDomains$1 = new HindmoviezPlugin$Companion$getDomains$1(this, continuation);
            }
            HindmoviezPlugin$Companion$getDomains$1 hindmoviezPlugin$Companion$getDomains$2 = hindmoviezPlugin$Companion$getDomains$1;
            Object $result = hindmoviezPlugin$Companion$getDomains$2.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (hindmoviezPlugin$Companion$getDomains$2.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    if (getCachedDomains() == null || forceRefresh) {
                        try {
                            Requests app = MainActivityKt.getApp();
                            try {
                                hindmoviezPlugin$Companion$getDomains$2.L$0 = this;
                                hindmoviezPlugin$Companion$getDomains$2.Z$0 = forceRefresh;
                                hindmoviezPlugin$Companion$getDomains$2.label = 1;
                                list = null;
                                try {
                                    $result = Requests.get$default(app, HindmoviezPlugin.DOMAINS_URL, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, hindmoviezPlugin$Companion$getDomains$2, 4094, (Object) null);
                                    if ($result == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    companion = this;
                                    try {
                                        it = ((NiceResponse) $result).getText();
                                        AppUtils appUtils = AppUtils.INSTANCE;
                                        if (it == null) {
                                            obj3 = list;
                                            obj = obj3;
                                        } else {
                                            try {
                                                try {
                                                    Result.Companion companion2 = Result.Companion;
                                                    KType kTypeTypeOf = Reflection.typeOf(Domains.class);
                                                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                                    obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                                                } catch (Throwable th) {
                                                    Result.Companion companion3 = Result.Companion;
                                                    obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                                                }
                                                if (Result.exceptionOrNull-impl(obj2) != null) {
                                                    try {
                                                        Result.Companion companion4 = Result.Companion;
                                                        obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Domains.class), list, 2, list));
                                                    } catch (Throwable th2) {
                                                        Result.Companion companion5 = Result.Companion;
                                                        obj2 = Result.constructor-impl(ResultKt.createFailure(th2));
                                                    }
                                                    if (Result.isFailure-impl(obj2)) {
                                                        obj2 = list;
                                                    }
                                                    deserializationStrategy = (KSerializer) obj2;
                                                    if (deserializationStrategy != null) {
                                                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, it);
                                                        obj = list;
                                                    } else {
                                                        ObjectMapper $this$readValue$iv$iv$iv = MainAPIKt.getMapper();
                                                        obj = list;
                                                        objDecodeFromString = $this$readValue$iv$iv$iv.readValue(it, new TypeReference<Domains>() { // from class: com.hindmoviez.HindmoviezPlugin$Companion$getDomains$lambda$0$$inlined$tryParseJson$1
                                                        });
                                                    }
                                                    break;
                                                } else {
                                                    if (Result.isFailure-impl(obj2)) {
                                                        obj2 = list;
                                                    }
                                                    deserializationStrategy = (KSerializer) obj2;
                                                    if (deserializationStrategy != null) {
                                                        try {
                                                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, it);
                                                            obj = list;
                                                        } catch (SerializationException e) {
                                                            ArchComponentExtKt.logError(e);
                                                            ObjectMapper $this$readValue$iv$iv$iv2 = MainAPIKt.getMapper();
                                                            obj = list;
                                                            try {
                                                                objDecodeFromString = $this$readValue$iv$iv$iv2.readValue(it, new TypeReference<Domains>() { // from class: com.hindmoviez.HindmoviezPlugin$Companion$getDomains$lambda$0$$inlined$tryParseJson$1
                                                                });
                                                            } catch (Exception e2) {
                                                                objDecodeFromString = obj;
                                                            }
                                                        } catch (Throwable th3) {
                                                            ObjectMapper $this$readValue$iv$iv$iv3 = MainAPIKt.getMapper();
                                                            obj = list;
                                                            objDecodeFromString = $this$readValue$iv$iv$iv3.readValue(it, new TypeReference<Domains>() { // from class: com.hindmoviez.HindmoviezPlugin$Companion$getDomains$lambda$0$$inlined$tryParseJson$1
                                                            });
                                                        }
                                                    } else {
                                                        ObjectMapper $this$readValue$iv$iv$iv4 = MainAPIKt.getMapper();
                                                        obj = list;
                                                        objDecodeFromString = $this$readValue$iv$iv$iv4.readValue(it, new TypeReference<Domains>() { // from class: com.hindmoviez.HindmoviezPlugin$Companion$getDomains$lambda$0$$inlined$tryParseJson$1
                                                        });
                                                    }
                                                }
                                            } catch (Exception e3) {
                                                obj = list;
                                                objDecodeFromString = obj;
                                                obj3 = objDecodeFromString;
                                                companion.setCachedDomains((Domains) obj3);
                                                return getCachedDomains();
                                            }
                                            obj3 = objDecodeFromString;
                                        }
                                        try {
                                            companion.setCachedDomains((Domains) obj3);
                                        } catch (Exception e4) {
                                            e = e4;
                                            e.printStackTrace();
                                            return obj;
                                        }
                                    } catch (Exception e5) {
                                        e = e5;
                                        obj = list;
                                    }
                                } catch (Exception e6) {
                                    e = e6;
                                    obj = null;
                                    e.printStackTrace();
                                    return obj;
                                }
                            } catch (Exception e7) {
                                e = e7;
                                obj = null;
                            }
                        } catch (Exception e8) {
                            e = e8;
                            obj = null;
                        }
                        break;
                    }
                    return getCachedDomains();
                case 1:
                    boolean z = hindmoviezPlugin$Companion$getDomains$2.Z$0;
                    Companion companion6 = (Companion) hindmoviezPlugin$Companion$getDomains$2.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        list = null;
                        companion = companion6;
                        it = ((NiceResponse) $result).getText();
                        AppUtils appUtils2 = AppUtils.INSTANCE;
                        if (it == null) {
                            obj3 = list;
                            obj = obj3;
                        } else {
                            Result.Companion companion7 = Result.Companion;
                            KType kTypeTypeOf2 = Reflection.typeOf(Domains.class);
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                            if (Result.exceptionOrNull-impl(obj2) != null) {
                                if (Result.isFailure-impl(obj2)) {
                                    obj2 = list;
                                }
                                deserializationStrategy = (KSerializer) obj2;
                                if (deserializationStrategy != null) {
                                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, it);
                                    obj = list;
                                } else {
                                    ObjectMapper $this$readValue$iv$iv$iv5 = MainAPIKt.getMapper();
                                    obj = list;
                                    objDecodeFromString = $this$readValue$iv$iv$iv5.readValue(it, new TypeReference<Domains>() { // from class: com.hindmoviez.HindmoviezPlugin$Companion$getDomains$lambda$0$$inlined$tryParseJson$1
                                    });
                                }
                            } else {
                                Result.Companion companion8 = Result.Companion;
                                obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Domains.class), list, 2, list));
                                if (Result.isFailure-impl(obj2)) {
                                    obj2 = list;
                                }
                                deserializationStrategy = (KSerializer) obj2;
                                if (deserializationStrategy != null) {
                                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, it);
                                    obj = list;
                                } else {
                                    ObjectMapper $this$readValue$iv$iv$iv6 = MainAPIKt.getMapper();
                                    obj = list;
                                    objDecodeFromString = $this$readValue$iv$iv$iv6.readValue(it, new TypeReference<Domains>() { // from class: com.hindmoviez.HindmoviezPlugin$Companion$getDomains$lambda$0$$inlined$tryParseJson$1
                                    });
                                }
                            }
                            obj3 = objDecodeFromString;
                        }
                        companion.setCachedDomains((Domains) obj3);
                        return getCachedDomains();
                    } catch (Exception e9) {
                        e = e9;
                        obj = null;
                        e.printStackTrace();
                        return obj;
                    }
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: hindmoviezPlugin.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/hindmoviez/HindmoviezPlugin$Companion$Domains;", "", "hindmoviez", "", "<init>", "(Ljava/lang/String;)V", "getHindmoviez", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "Hindmoviez"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final /* data */ class Domains {

            @NotNull
            private final String hindmoviez;

            public static /* synthetic */ Domains copy$default(Domains domains, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = domains.hindmoviez;
                }
                return domains.copy(str);
            }

            @NotNull
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getHindmoviez() {
                return this.hindmoviez;
            }

            @NotNull
            public final Domains copy(@NotNull String hindmoviez) {
                return new Domains(hindmoviez);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Domains) && Intrinsics.areEqual(this.hindmoviez, ((Domains) other).hindmoviez);
            }

            public int hashCode() {
                return this.hindmoviez.hashCode();
            }

            @NotNull
            public String toString() {
                return "Domains(hindmoviez=" + this.hindmoviez + ')';
            }

            public Domains(@NotNull String hindmoviez) {
                this.hindmoviez = hindmoviez;
            }

            @NotNull
            public final String getHindmoviez() {
                return this.hindmoviez;
            }
        }
    }
}
