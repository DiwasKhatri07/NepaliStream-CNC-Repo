package com.Animexin;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import com.fasterxml.jackson.core.type.TypeReference;
import com.lagradost.cloudstream3.CloudStreamApp;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.extractors.Dailymotion;
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

/* JADX INFO: compiled from: AnimexinPlugin.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Animexin/classes.dex */
@CloudstreamPlugin
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016Ê\u0001\u0002\b\b¨\u0006\u0007"}, d2 = {"Lcom/Animexin/AnimexinPlugin;", "Lcom/lagradost/cloudstream3/plugins/Plugin;", "<init>", "()V", "load", "", "Companion", "Animexin", "Lcom/lagradost/cloudstream3/plugins/CloudstreamPlugin;"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class AnimexinPlugin extends Plugin {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    public void load() {
        registerMainAPI(new Animexin());
        registerExtractorAPI(new Vtbe());
        registerExtractorAPI((ExtractorApi) new waaw());
        registerExtractorAPI((ExtractorApi) new wishfast());
        registerExtractorAPI((ExtractorApi) new FileMoonSx());
        registerExtractorAPI((ExtractorApi) new Dailymotion());
        setOpenSettings(new Function1() { // from class: com.Animexin.AnimexinPlugin$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return AnimexinPlugin.load$lambda$0(this.f$0, (Context) obj);
            }
        });
    }

    static final Unit load$lambda$0(AnimexinPlugin this$0, Context ctx) {
        Intrinsics.checkNotNull(ctx, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        AppCompatActivity activity = (AppCompatActivity) ctx;
        new BottomFragment(this$0).show(activity.getSupportFragmentManager(), "animexin_settings");
        return Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: AnimexinPlugin.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR$\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00118F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/Animexin/AnimexinPlugin$Companion;", "", "<init>", "()V", "value", "", "cfCookies", "getCfCookies", "()Ljava/lang/String;", "setCfCookies", "(Ljava/lang/String;)V", "cfUserAgent", "getCfUserAgent", "setCfUserAgent", "cfCookieHost", "getCfCookieHost", "setCfCookieHost", "", "cfWebviewEnabled", "getCfWebviewEnabled", "()Z", "setCfWebviewEnabled", "(Z)V", "Animexin"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nAnimexinPlugin.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnimexinPlugin.kt\ncom/Animexin/AnimexinPlugin$Companion\n+ 2 CloudStreamApp.kt\ncom/lagradost/cloudstream3/CloudStreamApp$Companion\n+ 3 DataStore.kt\ncom/lagradost/cloudstream3/utils/DataStore\n+ 4 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 6 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,47:1\n144#2:48\n144#2:74\n144#2:100\n144#2:126\n231#3:49\n222#3,3:50\n225#3,2:72\n231#3:75\n222#3,3:76\n225#3,2:98\n231#3:101\n222#3,3:102\n225#3,2:124\n231#3:127\n222#3,3:128\n225#3,2:150\n63#4:53\n64#4,15:55\n63#4:79\n64#4,15:81\n63#4:105\n64#4,15:107\n63#4:131\n64#4,15:133\n1#5:54\n1#5:80\n1#5:106\n1#5:132\n50#6:70\n43#6:71\n50#6:96\n43#6:97\n50#6:122\n43#6:123\n50#6:148\n43#6:149\n*S KotlinDebug\n*F\n+ 1 AnimexinPlugin.kt\ncom/Animexin/AnimexinPlugin$Companion\n*L\n28#1:48\n33#1:74\n38#1:100\n43#1:126\n28#1:49\n28#1:50,3\n28#1:72,2\n33#1:75\n33#1:76,3\n33#1:98,2\n38#1:101\n38#1:102,3\n38#1:124,2\n43#1:127\n43#1:128,3\n43#1:150,2\n28#1:53\n28#1:55,15\n33#1:79\n33#1:81,15\n38#1:105\n38#1:107,15\n43#1:131\n43#1:133,15\n28#1:54\n33#1:80\n38#1:106\n43#1:132\n28#1:70\n28#1:71\n33#1:96\n33#1:97\n38#1:122\n38#1:123\n43#1:148\n43#1:149\n*E\n"})
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
                    String string = DataStore.INSTANCE.getSharedPrefs(context).getString("ANIMEXIN_CF_COOKIES", null);
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
                                objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String>() { // from class: com.Animexin.AnimexinPlugin$Companion$special$$inlined$getKey$1
                                });
                            } catch (Throwable th5) {
                                objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String>() { // from class: com.Animexin.AnimexinPlugin$Companion$special$$inlined$getKey$1
                                });
                            }
                        } else {
                            objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String>() { // from class: com.Animexin.AnimexinPlugin$Companion$special$$inlined$getKey$1
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
            CloudStreamApp.Companion.setKey("ANIMEXIN_CF_COOKIES", value);
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
                    String string = DataStore.INSTANCE.getSharedPrefs(context).getString("ANIMEXIN_CF_USER_AGENT", null);
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
                                objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String>() { // from class: com.Animexin.AnimexinPlugin$Companion$special$$inlined$getKey$2
                                });
                            } catch (Throwable th5) {
                                objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String>() { // from class: com.Animexin.AnimexinPlugin$Companion$special$$inlined$getKey$2
                                });
                            }
                        } else {
                            objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String>() { // from class: com.Animexin.AnimexinPlugin$Companion$special$$inlined$getKey$2
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
            CloudStreamApp.Companion.setKey("ANIMEXIN_CF_USER_AGENT", value);
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
                    String string = DataStore.INSTANCE.getSharedPrefs(context).getString("ANIMEXIN_CF_COOKIE_HOST", null);
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
                                objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String>() { // from class: com.Animexin.AnimexinPlugin$Companion$special$$inlined$getKey$3
                                });
                            } catch (Throwable th5) {
                                objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String>() { // from class: com.Animexin.AnimexinPlugin$Companion$special$$inlined$getKey$3
                                });
                            }
                        } else {
                            objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String>() { // from class: com.Animexin.AnimexinPlugin$Companion$special$$inlined$getKey$3
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
            CloudStreamApp.Companion.setKey("ANIMEXIN_CF_COOKIE_HOST", value);
        }

        public final boolean getCfWebviewEnabled() {
            Object objDecodeFromString;
            Object obj;
            String path$iv;
            CloudStreamApp.Companion this_$iv = CloudStreamApp.Companion;
            Context context = this_$iv.getContext();
            if (context != null) {
                try {
                    String string = DataStore.INSTANCE.getSharedPrefs(context).getString("ANIMEXIN_CF_WEBVIEW_ENABLED", null);
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
                                objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<Boolean>() { // from class: com.Animexin.AnimexinPlugin$Companion$special$$inlined$getKey$4
                                });
                            } catch (Throwable th5) {
                                objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<Boolean>() { // from class: com.Animexin.AnimexinPlugin$Companion$special$$inlined$getKey$4
                                });
                            }
                        } else {
                            objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<Boolean>() { // from class: com.Animexin.AnimexinPlugin$Companion$special$$inlined$getKey$4
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
            CloudStreamApp.Companion.setKey("ANIMEXIN_CF_WEBVIEW_ENABLED", Boolean.valueOf(value));
        }
    }
}
