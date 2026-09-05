package com.DoraBash;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import com.fasterxml.jackson.core.type.TypeReference;
import com.lagradost.cloudstream3.CloudStreamApp;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.extractors.ByseVepoin;
import com.lagradost.cloudstream3.extractors.FileMoon;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin;
import com.lagradost.cloudstream3.plugins.Plugin;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.DataStore;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DoraBashProvider.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/DoraBash/classes.dex */
@CloudstreamPlugin
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016Ê\u0001\u0002\b\b¨\u0006\u0007"}, d2 = {"Lcom/DoraBash/DoraBashProvider;", "Lcom/lagradost/cloudstream3/plugins/Plugin;", "<init>", "()V", "load", "", "Companion", "DoraBash", "Lcom/lagradost/cloudstream3/plugins/CloudstreamPlugin;"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class DoraBashProvider extends Plugin {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    public void load() {
        registerMainAPI(new DoraBash());
        registerExtractorAPI(new Vtbe());
        registerExtractorAPI((ExtractorApi) new waaw());
        registerExtractorAPI((ExtractorApi) new wishfast());
        registerExtractorAPI((ExtractorApi) new FileMoonIN());
        registerExtractorAPI((ExtractorApi) new FileMoon());
        registerExtractorAPI((ExtractorApi) new ByseVepoin());
        registerExtractorAPI(new Abyass());
        registerExtractorAPI(new ByseSX());
        setOpenSettings(new Function1() { // from class: com.DoraBash.DoraBashProvider$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return DoraBashProvider.load$lambda$0(this.f$0, (Context) obj);
            }
        });
    }

    static final Unit load$lambda$0(DoraBashProvider this$0, Context ctx) {
        Intrinsics.checkNotNull(ctx, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        AppCompatActivity activity = (AppCompatActivity) ctx;
        DoraBashSettingsFragment frag = new DoraBashSettingsFragment(this$0);
        frag.show(activity.getSupportFragmentManager(), "");
        return Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: DoraBashProvider.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR$\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00118F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/DoraBash/DoraBashProvider$Companion;", "", "<init>", "()V", "value", "", "cfCookies", "getCfCookies", "()Ljava/lang/String;", "setCfCookies", "(Ljava/lang/String;)V", "cfUserAgent", "getCfUserAgent", "setCfUserAgent", "cfCookieHost", "getCfCookieHost", "setCfCookieHost", "", "cfWebviewEnabled", "getCfWebviewEnabled", "()Z", "setCfWebviewEnabled", "(Z)V", "DoraBash"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nDoraBashProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DoraBashProvider.kt\ncom/DoraBash/DoraBashProvider$Companion\n+ 2 CloudStreamApp.kt\ncom/lagradost/cloudstream3/CloudStreamApp$Companion\n+ 3 DataStore.kt\ncom/lagradost/cloudstream3/utils/DataStore\n+ 4 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 6 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,57:1\n144#2:58\n144#2:84\n144#2:110\n144#2:136\n231#3:59\n222#3,3:60\n225#3,2:82\n231#3:85\n222#3,3:86\n225#3,2:108\n231#3:111\n222#3,3:112\n225#3,2:134\n231#3:137\n222#3,3:138\n225#3,2:160\n63#4:63\n64#4,15:65\n63#4:89\n64#4,15:91\n63#4:115\n64#4,15:117\n63#4:141\n64#4,15:143\n1#5:64\n1#5:90\n1#5:116\n1#5:142\n50#6:80\n43#6:81\n50#6:106\n43#6:107\n50#6:132\n43#6:133\n50#6:158\n43#6:159\n*S KotlinDebug\n*F\n+ 1 DoraBashProvider.kt\ncom/DoraBash/DoraBashProvider$Companion\n*L\n33#1:58\n39#1:84\n45#1:110\n52#1:136\n33#1:59\n33#1:60,3\n33#1:82,2\n39#1:85\n39#1:86,3\n39#1:108,2\n45#1:111\n45#1:112,3\n45#1:134,2\n52#1:137\n52#1:138,3\n52#1:160,2\n33#1:63\n33#1:65,15\n39#1:89\n39#1:91,15\n45#1:115\n45#1:117,15\n52#1:141\n52#1:143,15\n33#1:64\n39#1:90\n45#1:116\n52#1:142\n33#1:80\n33#1:81\n39#1:106\n39#1:107\n45#1:132\n45#1:133\n52#1:158\n52#1:159\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final String getCfCookies() {
            Object objDecodeFromString;
            Object obj;
            String path$iv;
            CloudStreamApp.Companion this_$iv = CloudStreamApp.Companion;
            Context context = this_$iv.getContext();
            if (context != null) {
                try {
                    String string = DataStore.INSTANCE.getSharedPrefs(context).getString("DORABASH_CF_COOKIES", null);
                    if (string == null) {
                        objDecodeFromString = null;
                    } else {
                        AppUtils appUtils = AppUtils.INSTANCE;
                        try {
                            Result.Companion companion = Result.Companion;
                            KType kTypeTypeOf = Reflection.typeOf(String.class);
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        if (Result.exceptionOrNull-impl(obj) == null) {
                            path$iv = null;
                        } else {
                            try {
                                Result.Companion companion3 = Result.Companion;
                                try {
                                    path$iv = null;
                                    try {
                                        obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(String.class), (List) null, 2, (Object) null));
                                    } catch (Throwable th2) {
                                        th = th2;
                                        try {
                                            Result.Companion companion4 = Result.Companion;
                                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                                        } catch (Exception e) {
                                            objDecodeFromString = null;
                                        }
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    path$iv = null;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                path$iv = null;
                            }
                        }
                        if (Result.isFailure-impl(obj)) {
                            obj = path$iv;
                        }
                        DeserializationStrategy deserializationStrategy = (KSerializer) obj;
                        if (deserializationStrategy != null) {
                            try {
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, string);
                            } catch (SerializationException e2) {
                                ArchComponentExtKt.logError(e2);
                                objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String>() { // from class: com.DoraBash.DoraBashProvider$Companion$special$$inlined$getKey$1
                                });
                            } catch (Throwable th5) {
                                objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String>() { // from class: com.DoraBash.DoraBashProvider$Companion$special$$inlined$getKey$1
                                });
                            }
                        } else {
                            objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String>() { // from class: com.DoraBash.DoraBashProvider$Companion$special$$inlined$getKey$1
                            });
                        }
                    }
                } catch (Exception e3) {
                }
            } else {
                objDecodeFromString = null;
            }
            String str = (String) objDecodeFromString;
            return str == null ? "" : str;
        }

        public final void setCfCookies(@NotNull String value) {
            CloudStreamApp.Companion.setKey("DORABASH_CF_COOKIES", value);
        }

        @NotNull
        public final String getCfUserAgent() {
            Object objDecodeFromString;
            Object obj;
            String path$iv;
            CloudStreamApp.Companion this_$iv = CloudStreamApp.Companion;
            Context context = this_$iv.getContext();
            if (context != null) {
                try {
                    String string = DataStore.INSTANCE.getSharedPrefs(context).getString("DORABASH_CF_USER_AGENT", null);
                    if (string == null) {
                        objDecodeFromString = null;
                    } else {
                        AppUtils appUtils = AppUtils.INSTANCE;
                        try {
                            Result.Companion companion = Result.Companion;
                            KType kTypeTypeOf = Reflection.typeOf(String.class);
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        if (Result.exceptionOrNull-impl(obj) == null) {
                            path$iv = null;
                        } else {
                            try {
                                Result.Companion companion3 = Result.Companion;
                                try {
                                    path$iv = null;
                                    try {
                                        obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(String.class), (List) null, 2, (Object) null));
                                    } catch (Throwable th2) {
                                        th = th2;
                                        try {
                                            Result.Companion companion4 = Result.Companion;
                                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                                        } catch (Exception e) {
                                            objDecodeFromString = null;
                                        }
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    path$iv = null;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                path$iv = null;
                            }
                        }
                        if (Result.isFailure-impl(obj)) {
                            obj = path$iv;
                        }
                        DeserializationStrategy deserializationStrategy = (KSerializer) obj;
                        if (deserializationStrategy != null) {
                            try {
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, string);
                            } catch (SerializationException e2) {
                                ArchComponentExtKt.logError(e2);
                                objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String>() { // from class: com.DoraBash.DoraBashProvider$Companion$special$$inlined$getKey$2
                                });
                            } catch (Throwable th5) {
                                objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String>() { // from class: com.DoraBash.DoraBashProvider$Companion$special$$inlined$getKey$2
                                });
                            }
                        } else {
                            objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String>() { // from class: com.DoraBash.DoraBashProvider$Companion$special$$inlined$getKey$2
                            });
                        }
                    }
                } catch (Exception e3) {
                }
            } else {
                objDecodeFromString = null;
            }
            String str = (String) objDecodeFromString;
            return str == null ? "" : str;
        }

        public final void setCfUserAgent(@NotNull String value) {
            CloudStreamApp.Companion.setKey("DORABASH_CF_USER_AGENT", value);
        }

        @NotNull
        public final String getCfCookieHost() {
            Object objDecodeFromString;
            Object obj;
            String path$iv;
            CloudStreamApp.Companion this_$iv = CloudStreamApp.Companion;
            Context context = this_$iv.getContext();
            if (context != null) {
                try {
                    String string = DataStore.INSTANCE.getSharedPrefs(context).getString("DORABASH_CF_COOKIE_HOST", null);
                    if (string == null) {
                        objDecodeFromString = null;
                    } else {
                        AppUtils appUtils = AppUtils.INSTANCE;
                        try {
                            Result.Companion companion = Result.Companion;
                            KType kTypeTypeOf = Reflection.typeOf(String.class);
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        if (Result.exceptionOrNull-impl(obj) == null) {
                            path$iv = null;
                        } else {
                            try {
                                Result.Companion companion3 = Result.Companion;
                                try {
                                    path$iv = null;
                                    try {
                                        obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(String.class), (List) null, 2, (Object) null));
                                    } catch (Throwable th2) {
                                        th = th2;
                                        try {
                                            Result.Companion companion4 = Result.Companion;
                                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                                        } catch (Exception e) {
                                            objDecodeFromString = null;
                                        }
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    path$iv = null;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                path$iv = null;
                            }
                        }
                        if (Result.isFailure-impl(obj)) {
                            obj = path$iv;
                        }
                        DeserializationStrategy deserializationStrategy = (KSerializer) obj;
                        if (deserializationStrategy != null) {
                            try {
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, string);
                            } catch (SerializationException e2) {
                                ArchComponentExtKt.logError(e2);
                                objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String>() { // from class: com.DoraBash.DoraBashProvider$Companion$special$$inlined$getKey$3
                                });
                            } catch (Throwable th5) {
                                objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String>() { // from class: com.DoraBash.DoraBashProvider$Companion$special$$inlined$getKey$3
                                });
                            }
                        } else {
                            objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String>() { // from class: com.DoraBash.DoraBashProvider$Companion$special$$inlined$getKey$3
                            });
                        }
                    }
                } catch (Exception e3) {
                }
            } else {
                objDecodeFromString = null;
            }
            String str = (String) objDecodeFromString;
            return str == null ? "" : str;
        }

        public final void setCfCookieHost(@NotNull String value) {
            CloudStreamApp.Companion.setKey("DORABASH_CF_COOKIE_HOST", value);
        }

        public final boolean getCfWebviewEnabled() {
            Object objDecodeFromString;
            Object obj;
            String path$iv;
            CloudStreamApp.Companion this_$iv = CloudStreamApp.Companion;
            Context context = this_$iv.getContext();
            if (context != null) {
                try {
                    String string = DataStore.INSTANCE.getSharedPrefs(context).getString("DORABASH_CF_WEBVIEW_ENABLED", null);
                    if (string == null) {
                        objDecodeFromString = null;
                    } else {
                        AppUtils appUtils = AppUtils.INSTANCE;
                        try {
                            Result.Companion companion = Result.Companion;
                            KType kTypeTypeOf = Reflection.typeOf(Boolean.TYPE);
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        if (Result.exceptionOrNull-impl(obj) == null) {
                            path$iv = null;
                        } else {
                            try {
                                Result.Companion companion3 = Result.Companion;
                                try {
                                    path$iv = null;
                                    try {
                                        obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Boolean.class), (List) null, 2, (Object) null));
                                    } catch (Throwable th2) {
                                        th = th2;
                                        try {
                                            Result.Companion companion4 = Result.Companion;
                                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                                        } catch (Exception e) {
                                            objDecodeFromString = null;
                                        }
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    path$iv = null;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                path$iv = null;
                            }
                        }
                        if (Result.isFailure-impl(obj)) {
                            obj = path$iv;
                        }
                        DeserializationStrategy deserializationStrategy = (KSerializer) obj;
                        if (deserializationStrategy != null) {
                            try {
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, string);
                            } catch (SerializationException e2) {
                                ArchComponentExtKt.logError(e2);
                                objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<Boolean>() { // from class: com.DoraBash.DoraBashProvider$Companion$special$$inlined$getKey$4
                                });
                            } catch (Throwable th5) {
                                objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<Boolean>() { // from class: com.DoraBash.DoraBashProvider$Companion$special$$inlined$getKey$4
                                });
                            }
                        } else {
                            objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<Boolean>() { // from class: com.DoraBash.DoraBashProvider$Companion$special$$inlined$getKey$4
                            });
                        }
                    }
                } catch (Exception e3) {
                }
            } else {
                objDecodeFromString = null;
            }
            Boolean bool = (Boolean) objDecodeFromString;
            if (bool != null) {
                return bool.booleanValue();
            }
            return true;
        }

        public final void setCfWebviewEnabled(boolean value) {
            CloudStreamApp.Companion.setKey("DORABASH_CF_WEBVIEW_ENABLED", Boolean.valueOf(value));
        }
    }
}
