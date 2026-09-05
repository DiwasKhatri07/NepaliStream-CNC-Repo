package com.phisher98;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import com.fasterxml.jackson.core.type.TypeReference;
import com.lagradost.cloudstream3.CloudStreamApp;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin;
import com.lagradost.cloudstream3.plugins.Plugin;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.DataStore;
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

/* JADX INFO: compiled from: AnimePahePlugin.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/AnimePahe/classes.dex */
@CloudstreamPlugin
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016Ê\u0001\u0002\b\b¨\u0006\u0007"}, d2 = {"Lcom/phisher98/AnimePaheProviderPlugin;", "Lcom/lagradost/cloudstream3/plugins/Plugin;", "<init>", "()V", "load", "", "Companion", "AnimePahe", "Lcom/lagradost/cloudstream3/plugins/CloudstreamPlugin;"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class AnimePaheProviderPlugin extends Plugin {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    public void load() {
        registerMainAPI(new AnimePahe());
        registerExtractorAPI(new Kwik());
        registerExtractorAPI(new Pahe());
        setOpenSettings(new Function1() { // from class: com.phisher98.AnimePaheProviderPlugin$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return AnimePaheProviderPlugin.load$lambda$0(this.f$0, (Context) obj);
            }
        });
    }

    static final Unit load$lambda$0(AnimePaheProviderPlugin this$0, Context ctx) {
        Intrinsics.checkNotNull(ctx, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        AppCompatActivity activity = (AppCompatActivity) ctx;
        BottomFragment frag = new BottomFragment(this$0);
        frag.show(activity.getSupportFragmentManager(), "");
        return Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: AnimePahePlugin.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR$\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR$\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00148F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/phisher98/AnimePaheProviderPlugin$Companion;", "", "<init>", "()V", "value", "", "currentAnimepaheServer", "getCurrentAnimepaheServer", "()Ljava/lang/String;", "setCurrentAnimepaheServer", "(Ljava/lang/String;)V", "cfCookies", "getCfCookies", "setCfCookies", "cfUserAgent", "getCfUserAgent", "setCfUserAgent", "cfCookieHost", "getCfCookieHost", "setCfCookieHost", "", "cfWebviewEnabled", "getCfWebviewEnabled", "()Z", "setCfWebviewEnabled", "(Z)V", "AnimePahe"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nAnimePahePlugin.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnimePahePlugin.kt\ncom/phisher98/AnimePaheProviderPlugin$Companion\n+ 2 CloudStreamApp.kt\ncom/lagradost/cloudstream3/CloudStreamApp$Companion\n+ 3 DataStore.kt\ncom/lagradost/cloudstream3/utils/DataStore\n+ 4 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 6 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,66:1\n144#2:67\n144#2:93\n144#2:119\n144#2:145\n144#2:171\n231#3:68\n222#3,3:69\n225#3,2:91\n231#3:94\n222#3,3:95\n225#3,2:117\n231#3:120\n222#3,3:121\n225#3,2:143\n231#3:146\n222#3,3:147\n225#3,2:169\n231#3:172\n222#3,3:173\n225#3,2:195\n63#4:72\n64#4,15:74\n63#4:98\n64#4,15:100\n63#4:124\n64#4,15:126\n63#4:150\n64#4,15:152\n63#4:176\n64#4,15:178\n1#5:73\n1#5:99\n1#5:125\n1#5:151\n1#5:177\n50#6:89\n43#6:90\n50#6:115\n43#6:116\n50#6:141\n43#6:142\n50#6:167\n43#6:168\n50#6:193\n43#6:194\n*S KotlinDebug\n*F\n+ 1 AnimePahePlugin.kt\ncom/phisher98/AnimePaheProviderPlugin$Companion\n*L\n33#1:67\n40#1:93\n47#1:119\n54#1:145\n61#1:171\n33#1:68\n33#1:69,3\n33#1:91,2\n40#1:94\n40#1:95,3\n40#1:117,2\n47#1:120\n47#1:121,3\n47#1:143,2\n54#1:146\n54#1:147,3\n54#1:169,2\n61#1:172\n61#1:173,3\n61#1:195,2\n33#1:72\n33#1:74,15\n40#1:98\n40#1:100,15\n47#1:124\n47#1:126,15\n54#1:150\n54#1:152,15\n61#1:176\n61#1:178,15\n33#1:73\n40#1:99\n47#1:125\n54#1:151\n61#1:177\n33#1:89\n33#1:90\n40#1:115\n40#1:116\n47#1:141\n47#1:142\n54#1:167\n54#1:168\n61#1:193\n61#1:194\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final String getCurrentAnimepaheServer() {
            Object objDecodeFromString;
            Object obj;
            String path$iv;
            CloudStreamApp.Companion this_$iv = CloudStreamApp.Companion;
            Context context = this_$iv.getContext();
            if (context != null) {
                try {
                    String string = DataStore.INSTANCE.getSharedPrefs(context).getString("ANIMEPAHE_CURRENT_SERVER", null);
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
                                objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String>() { // from class: com.phisher98.AnimePaheProviderPlugin$Companion$special$$inlined$getKey$1
                                });
                            } catch (Throwable th5) {
                                objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String>() { // from class: com.phisher98.AnimePaheProviderPlugin$Companion$special$$inlined$getKey$1
                                });
                            }
                        } else {
                            objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String>() { // from class: com.phisher98.AnimePaheProviderPlugin$Companion$special$$inlined$getKey$1
                            });
                        }
                    }
                } catch (Exception e3) {
                }
            } else {
                objDecodeFromString = null;
            }
            String str = (String) objDecodeFromString;
            return str == null ? (String) ServerList.BEST.getLink().getFirst() : str;
        }

        public final void setCurrentAnimepaheServer(@NotNull String value) {
            CloudStreamApp.Companion.setKey("ANIMEPAHE_CURRENT_SERVER", value);
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
                    String string = DataStore.INSTANCE.getSharedPrefs(context).getString("ANIMEPAHE_CF_COOKIES", null);
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
                                objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String>() { // from class: com.phisher98.AnimePaheProviderPlugin$Companion$special$$inlined$getKey$2
                                });
                            } catch (Throwable th5) {
                                objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String>() { // from class: com.phisher98.AnimePaheProviderPlugin$Companion$special$$inlined$getKey$2
                                });
                            }
                        } else {
                            objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String>() { // from class: com.phisher98.AnimePaheProviderPlugin$Companion$special$$inlined$getKey$2
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
            CloudStreamApp.Companion.setKey("ANIMEPAHE_CF_COOKIES", value);
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
                    String string = DataStore.INSTANCE.getSharedPrefs(context).getString("ANIMEPAHE_CF_USER_AGENT", null);
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
                                objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String>() { // from class: com.phisher98.AnimePaheProviderPlugin$Companion$special$$inlined$getKey$3
                                });
                            } catch (Throwable th5) {
                                objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String>() { // from class: com.phisher98.AnimePaheProviderPlugin$Companion$special$$inlined$getKey$3
                                });
                            }
                        } else {
                            objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String>() { // from class: com.phisher98.AnimePaheProviderPlugin$Companion$special$$inlined$getKey$3
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
            CloudStreamApp.Companion.setKey("ANIMEPAHE_CF_USER_AGENT", value);
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
                    String string = DataStore.INSTANCE.getSharedPrefs(context).getString("ANIMEPAHE_CF_COOKIE_HOST", null);
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
                                objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String>() { // from class: com.phisher98.AnimePaheProviderPlugin$Companion$special$$inlined$getKey$4
                                });
                            } catch (Throwable th5) {
                                objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String>() { // from class: com.phisher98.AnimePaheProviderPlugin$Companion$special$$inlined$getKey$4
                                });
                            }
                        } else {
                            objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String>() { // from class: com.phisher98.AnimePaheProviderPlugin$Companion$special$$inlined$getKey$4
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
            CloudStreamApp.Companion.setKey("ANIMEPAHE_CF_COOKIE_HOST", value);
        }

        public final boolean getCfWebviewEnabled() {
            Object objDecodeFromString;
            Object obj;
            String path$iv;
            CloudStreamApp.Companion this_$iv = CloudStreamApp.Companion;
            Context context = this_$iv.getContext();
            if (context != null) {
                try {
                    String string = DataStore.INSTANCE.getSharedPrefs(context).getString("ANIMEPAHE_CF_WEBVIEW_ENABLED", null);
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
                                objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<Boolean>() { // from class: com.phisher98.AnimePaheProviderPlugin$Companion$special$$inlined$getKey$5
                                });
                            } catch (Throwable th5) {
                                objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<Boolean>() { // from class: com.phisher98.AnimePaheProviderPlugin$Companion$special$$inlined$getKey$5
                                });
                            }
                        } else {
                            objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<Boolean>() { // from class: com.phisher98.AnimePaheProviderPlugin$Companion$special$$inlined$getKey$5
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
            CloudStreamApp.Companion.setKey("ANIMEPAHE_CF_WEBVIEW_ENABLED", Boolean.valueOf(value));
        }
    }
}
