package com.phisher98;

import android.content.Context;
import com.fasterxml.jackson.core.type.TypeReference;
import com.lagradost.cloudstream3.CloudStreamApp;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainPageData;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.DataStore;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StorageManager.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Ultima/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u001cJ\u000e\u0010\"\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0016\u0010$\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020#J\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020#0'2\u0006\u0010\u001d\u001a\u00020\u001eJ\u001c\u0010(\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020#0'J\u0006\u0010*\u001a\u00020 J\u0011\u0010+\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\u0010\u000fR$\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR0\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0004\u001a\u0004\u0018\u00010\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\b\"\u0004\b\u001a\u0010\n¨\u0006,"}, d2 = {"Lcom/phisher98/UltimaStorageManager;", "", "<init>", "()V", "value", "", "extNameOnHome", "getExtNameOnHome", "()Z", "setExtNameOnHome", "(Z)V", "", "Lcom/phisher98/UltimaUtils$ExtensionInfo;", "currentExtensions", "getCurrentExtensions", "()[Lcom/phisher98/UltimaUtils$ExtensionInfo;", "setCurrentExtensions", "([Lcom/phisher98/UltimaUtils$ExtensionInfo;)V", "Lcom/phisher98/AppSettingsSyncCreds;", "appSettingsSyncCreds", "getAppSettingsSyncCreds", "()Lcom/phisher98/AppSettingsSyncCreds;", "setAppSettingsSyncCreds", "(Lcom/phisher98/AppSettingsSyncCreds;)V", "syncV2Migrated", "getSyncV2Migrated", "setSyncV2Migrated", "getCategoryTimestamp", "", "category", "Lcom/phisher98/SyncCategory;", "setCategoryTimestamp", "", "ts", "getCategoryHash", "", "setCategoryHash", "hash", "getCategorySyncedKeys", "", "setCategorySyncedKeys", "keys", "deleteAllData", "fetchExtensions", "Ultima"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nStorageManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StorageManager.kt\ncom/phisher98/UltimaStorageManager\n+ 2 CloudStreamApp.kt\ncom/lagradost/cloudstream3/CloudStreamApp$Companion\n+ 3 DataStore.kt\ncom/lagradost/cloudstream3/utils/DataStore\n+ 4 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 6 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 7 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 8 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,108:1\n144#2:109\n144#2:135\n144#2:161\n144#2:187\n144#2:213\n144#2:239\n144#2:265\n144#2:297\n231#3:110\n222#3,3:111\n225#3,2:133\n231#3:136\n222#3,3:137\n225#3,2:159\n231#3:162\n222#3,3:163\n225#3,2:185\n231#3:188\n222#3,3:189\n225#3,2:211\n231#3:214\n222#3,3:215\n225#3,2:237\n231#3:240\n222#3,3:241\n225#3,2:263\n231#3:266\n222#3,3:267\n225#3,2:289\n231#3:298\n222#3,3:299\n225#3,2:321\n63#4:114\n64#4,15:116\n63#4:140\n64#4,15:142\n63#4:166\n64#4,15:168\n63#4:192\n64#4,15:194\n63#4:218\n64#4,15:220\n63#4:244\n64#4,15:246\n63#4:270\n64#4,15:272\n63#4:302\n64#4,15:304\n1#5:115\n1#5:141\n1#5:167\n1#5:193\n1#5:219\n1#5:245\n1#5:271\n1#5:303\n1#5:329\n50#6:131\n43#6:132\n50#6:157\n43#6:158\n50#6:183\n43#6:184\n50#6:209\n43#6:210\n50#6:235\n43#6:236\n50#6:261\n43#6:262\n50#6:287\n43#6:288\n50#6:319\n43#6:320\n37#7,2:291\n37#7,2:334\n37#7,2:337\n2068#8,2:293\n2068#8,2:295\n777#8:323\n873#8,2:324\n1739#8:326\n1814#8,2:327\n1739#8:330\n1814#8,3:331\n1816#8:336\n*S KotlinDebug\n*F\n+ 1 StorageManager.kt\ncom/phisher98/UltimaStorageManager\n*L\n15#1:109\n21#1:135\n28#1:161\n34#1:187\n40#1:213\n48#1:239\n56#1:265\n88#1:297\n15#1:110\n15#1:111,3\n15#1:133,2\n21#1:136\n21#1:137,3\n21#1:159,2\n28#1:162\n28#1:163,3\n28#1:185,2\n34#1:188\n34#1:189,3\n34#1:211,2\n40#1:214\n40#1:215,3\n40#1:237,2\n48#1:240\n48#1:241,3\n48#1:263,2\n56#1:266\n56#1:267,3\n56#1:289,2\n88#1:298\n88#1:299,3\n88#1:321,2\n15#1:114\n15#1:116,15\n21#1:140\n21#1:142,15\n28#1:166\n28#1:168,15\n34#1:192\n34#1:194,15\n40#1:218\n40#1:220,15\n48#1:244\n48#1:246,15\n56#1:270\n56#1:272,15\n88#1:302\n88#1:304,15\n15#1:115\n21#1:141\n28#1:167\n34#1:193\n40#1:219\n48#1:245\n56#1:271\n88#1:303\n15#1:131\n15#1:132\n21#1:157\n21#1:158\n28#1:183\n28#1:184\n34#1:209\n34#1:210\n40#1:235\n40#1:236\n48#1:261\n48#1:262\n56#1:287\n56#1:288\n88#1:319\n88#1:320\n60#1:291,2\n102#1:334,2\n104#1:337,2\n75#1:293,2\n77#1:295,2\n89#1:323\n89#1:324,2\n91#1:326\n91#1:327,2\n95#1:330\n95#1:331,3\n91#1:336\n*E\n"})
public final class UltimaStorageManager {

    @NotNull
    public static final UltimaStorageManager INSTANCE = new UltimaStorageManager();

    private UltimaStorageManager() {
    }

    public final boolean getExtNameOnHome() {
        Object objDecodeFromString;
        Object obj;
        String path$iv;
        CloudStreamApp.Companion this_$iv = CloudStreamApp.Companion;
        Context context = this_$iv.getContext();
        if (context != null) {
            try {
                String string = DataStore.INSTANCE.getSharedPrefs(context).getString("ULTIMA_EXT_NAME_ON_HOME", null);
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
                            objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<Boolean>() { // from class: com.phisher98.UltimaStorageManager$special$$inlined$getKey$1
                            });
                        } catch (Throwable th5) {
                            objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<Boolean>() { // from class: com.phisher98.UltimaStorageManager$special$$inlined$getKey$1
                            });
                        }
                    } else {
                        objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<Boolean>() { // from class: com.phisher98.UltimaStorageManager$special$$inlined$getKey$1
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

    public final void setExtNameOnHome(boolean value) {
        CloudStreamApp.Companion.setKey("ULTIMA_EXT_NAME_ON_HOME", Boolean.valueOf(value));
    }

    /* JADX WARN: Code duplicated, block: B:58:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:75:? A[RETURN, SYNTHETIC] */
    @NotNull
    public final UltimaUtils.ExtensionInfo[] getCurrentExtensions() {
        Object objDecodeFromString;
        UltimaUtils.ExtensionInfo[] extensionInfoArr;
        Object obj;
        String path$iv;
        CloudStreamApp.Companion this_$iv = CloudStreamApp.Companion;
        Context context = this_$iv.getContext();
        if (context != null) {
            try {
                String string = DataStore.INSTANCE.getSharedPrefs(context).getString("ULTIMA_EXTENSIONS_LIST", null);
                if (string == null) {
                    objDecodeFromString = null;
                } else {
                    AppUtils appUtils = AppUtils.INSTANCE;
                    try {
                        Result.Companion companion = Result.Companion;
                        try {
                            KType kTypeTypeOf = Reflection.typeOf(UltimaUtils.ExtensionInfo[].class, KTypeProjection.Companion.invariant(Reflection.typeOf(UltimaUtils.ExtensionInfo.class)));
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                        } catch (Throwable th) {
                            th = th;
                            try {
                                Result.Companion companion2 = Result.Companion;
                                obj = Result.constructor-impl(ResultKt.createFailure(th));
                            } catch (Exception e) {
                                objDecodeFromString = null;
                                extensionInfoArr = (UltimaUtils.ExtensionInfo[]) objDecodeFromString;
                                if (extensionInfoArr == null) {
                                    return new UltimaUtils.ExtensionInfo[0];
                                }
                                return extensionInfoArr;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    if (Result.exceptionOrNull-impl(obj) == null) {
                        path$iv = null;
                    } else {
                        try {
                            Result.Companion companion3 = Result.Companion;
                            path$iv = null;
                            try {
                                obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(UltimaUtils.ExtensionInfo[].class), (List) null, 2, (Object) null));
                            } catch (Throwable th3) {
                                th = th3;
                                try {
                                    Result.Companion companion4 = Result.Companion;
                                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                                } catch (Exception e2) {
                                    objDecodeFromString = null;
                                }
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
                        } catch (SerializationException e3) {
                            ArchComponentExtKt.logError(e3);
                            objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<UltimaUtils.ExtensionInfo[]>() { // from class: com.phisher98.UltimaStorageManager$special$$inlined$getKey$2
                            });
                        } catch (Throwable th5) {
                            objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<UltimaUtils.ExtensionInfo[]>() { // from class: com.phisher98.UltimaStorageManager$special$$inlined$getKey$2
                            });
                        }
                    } else {
                        objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<UltimaUtils.ExtensionInfo[]>() { // from class: com.phisher98.UltimaStorageManager$special$$inlined$getKey$2
                        });
                    }
                }
            } catch (Exception e4) {
            }
        } else {
            objDecodeFromString = null;
        }
        extensionInfoArr = (UltimaUtils.ExtensionInfo[]) objDecodeFromString;
        if (extensionInfoArr == null) {
            return new UltimaUtils.ExtensionInfo[0];
        }
        return extensionInfoArr;
    }

    public final void setCurrentExtensions(@NotNull UltimaUtils.ExtensionInfo[] value) {
        CloudStreamApp.Companion.setKey("ULTIMA_EXTENSIONS_LIST", value);
    }

    @Nullable
    public final AppSettingsSyncCreds getAppSettingsSyncCreds() {
        Object objDecodeFromString;
        Object obj;
        String path$iv;
        CloudStreamApp.Companion this_$iv = CloudStreamApp.Companion;
        Context context = this_$iv.getContext();
        if (context != null) {
            try {
                String string = DataStore.INSTANCE.getSharedPrefs(context).getString("ULTIMA_APP_SETTINGS_SYNC_CREDS", null);
                if (string == null) {
                    objDecodeFromString = null;
                } else {
                    AppUtils appUtils = AppUtils.INSTANCE;
                    try {
                        Result.Companion companion = Result.Companion;
                        KType kTypeTypeOf = Reflection.typeOf(AppSettingsSyncCreds.class);
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
                                    obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(AppSettingsSyncCreds.class), (List) null, 2, (Object) null));
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
                            objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<AppSettingsSyncCreds>() { // from class: com.phisher98.UltimaStorageManager$special$$inlined$getKey$3
                            });
                        } catch (Throwable th5) {
                            objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<AppSettingsSyncCreds>() { // from class: com.phisher98.UltimaStorageManager$special$$inlined$getKey$3
                            });
                        }
                    } else {
                        objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<AppSettingsSyncCreds>() { // from class: com.phisher98.UltimaStorageManager$special$$inlined$getKey$3
                        });
                    }
                }
            } catch (Exception e3) {
            }
        } else {
            objDecodeFromString = null;
        }
        return (AppSettingsSyncCreds) objDecodeFromString;
    }

    public final void setAppSettingsSyncCreds(@Nullable AppSettingsSyncCreds value) {
        CloudStreamApp.Companion.setKey("ULTIMA_APP_SETTINGS_SYNC_CREDS", value);
    }

    public final boolean getSyncV2Migrated() {
        Object objDecodeFromString;
        Object obj;
        String path$iv;
        CloudStreamApp.Companion this_$iv = CloudStreamApp.Companion;
        Context context = this_$iv.getContext();
        if (context != null) {
            try {
                String string = DataStore.INSTANCE.getSharedPrefs(context).getString("ULTIMA_SYNC_V2_MIGRATED", null);
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
                            objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<Boolean>() { // from class: com.phisher98.UltimaStorageManager$special$$inlined$getKey$4
                            });
                        } catch (Throwable th5) {
                            objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<Boolean>() { // from class: com.phisher98.UltimaStorageManager$special$$inlined$getKey$4
                            });
                        }
                    } else {
                        objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<Boolean>() { // from class: com.phisher98.UltimaStorageManager$special$$inlined$getKey$4
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
        return false;
    }

    public final void setSyncV2Migrated(boolean value) {
        CloudStreamApp.Companion.setKey("ULTIMA_SYNC_V2_MIGRATED", Boolean.valueOf(value));
    }

    /* JADX WARN: Code duplicated, block: B:54:0x0104  */
    /* JADX WARN: Code duplicated, block: B:55:0x0109 A[ORIG_RETURN, RETURN] */
    public final long getCategoryTimestamp(@NotNull SyncCategory category) {
        Object objDecodeFromString;
        Long l;
        Object obj;
        String path$iv;
        CloudStreamApp.Companion this_$iv = CloudStreamApp.Companion;
        String path$iv2 = "ULTIMA_SYNC_TS_" + category.getKey();
        Context context = this_$iv.getContext();
        if (context != null) {
            try {
                String string = DataStore.INSTANCE.getSharedPrefs(context).getString(path$iv2, null);
                if (string == null) {
                    objDecodeFromString = null;
                } else {
                    AppUtils appUtils = AppUtils.INSTANCE;
                    try {
                        Result.Companion companion = Result.Companion;
                        KType kTypeTypeOf = Reflection.typeOf(Long.TYPE);
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
                                    obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Long.class), (List) null, 2, (Object) null));
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
                            objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<Long>() { // from class: com.phisher98.UltimaStorageManager$getCategoryTimestamp$$inlined$getKey$1
                            });
                        } catch (Throwable th5) {
                            objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<Long>() { // from class: com.phisher98.UltimaStorageManager$getCategoryTimestamp$$inlined$getKey$1
                            });
                        }
                    } else {
                        objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<Long>() { // from class: com.phisher98.UltimaStorageManager$getCategoryTimestamp$$inlined$getKey$1
                        });
                    }
                }
            } catch (Exception e3) {
                objDecodeFromString = null;
                l = (Long) objDecodeFromString;
                if (l != null) {
                    return l.longValue();
                }
                return 0L;
            }
        } else {
            objDecodeFromString = null;
        }
        l = (Long) objDecodeFromString;
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    public final void setCategoryTimestamp(@NotNull SyncCategory category, long ts) {
        CloudStreamApp.Companion.setKey("ULTIMA_SYNC_TS_" + category.getKey(), Long.valueOf(ts));
    }

    /* JADX WARN: Code duplicated, block: B:54:0x0104 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:69:? A[RETURN, SYNTHETIC] */
    @NotNull
    public final String getCategoryHash(@NotNull SyncCategory category) {
        Object objDecodeFromString;
        String str;
        Object obj;
        String path$iv;
        CloudStreamApp.Companion this_$iv = CloudStreamApp.Companion;
        String path$iv2 = "ULTIMA_SYNC_HASH_" + category.getKey();
        Context context = this_$iv.getContext();
        if (context != null) {
            try {
                String string = DataStore.INSTANCE.getSharedPrefs(context).getString(path$iv2, null);
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
                            objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String>() { // from class: com.phisher98.UltimaStorageManager$getCategoryHash$$inlined$getKey$1
                            });
                        } catch (Throwable th5) {
                            objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String>() { // from class: com.phisher98.UltimaStorageManager$getCategoryHash$$inlined$getKey$1
                            });
                        }
                    } else {
                        objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String>() { // from class: com.phisher98.UltimaStorageManager$getCategoryHash$$inlined$getKey$1
                        });
                    }
                }
            } catch (Exception e3) {
                objDecodeFromString = null;
                str = (String) objDecodeFromString;
                if (str == null) {
                    return "";
                }
                return str;
            }
        } else {
            objDecodeFromString = null;
        }
        str = (String) objDecodeFromString;
        if (str == null) {
            return "";
        }
        return str;
    }

    public final void setCategoryHash(@NotNull SyncCategory category, @NotNull String hash) {
        CloudStreamApp.Companion.setKey("ULTIMA_SYNC_HASH_" + category.getKey(), hash);
    }

    @NotNull
    public final Set<String> getCategorySyncedKeys(@NotNull SyncCategory category) {
        Object objDecodeFromString;
        Set<String> set;
        Object obj;
        String path$iv;
        CloudStreamApp.Companion this_$iv = CloudStreamApp.Companion;
        String path$iv2 = "ULTIMA_SYNCED_KEYS_" + category.getKey();
        Context context = this_$iv.getContext();
        if (context != null) {
            try {
                String string = DataStore.INSTANCE.getSharedPrefs(context).getString(path$iv2, null);
                if (string == null) {
                    objDecodeFromString = null;
                } else {
                    AppUtils appUtils = AppUtils.INSTANCE;
                    try {
                        Result.Companion companion = Result.Companion;
                        try {
                            KType kTypeTypeOf = Reflection.typeOf(String[].class, KTypeProjection.Companion.invariant(Reflection.typeOf(String.class)));
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                        } catch (Throwable th) {
                            th = th;
                            try {
                                Result.Companion companion2 = Result.Companion;
                                obj = Result.constructor-impl(ResultKt.createFailure(th));
                            } catch (Exception e) {
                                objDecodeFromString = null;
                                String[] strArr = (String[]) objDecodeFromString;
                                if (strArr != null) {
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    if (Result.exceptionOrNull-impl(obj) == null) {
                        path$iv = null;
                    } else {
                        try {
                            Result.Companion companion3 = Result.Companion;
                            path$iv = null;
                            try {
                                obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(String[].class), (List) null, 2, (Object) null));
                            } catch (Throwable th3) {
                                th = th3;
                                try {
                                    Result.Companion companion4 = Result.Companion;
                                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                                } catch (Exception e2) {
                                    objDecodeFromString = null;
                                }
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
                        } catch (SerializationException e3) {
                            ArchComponentExtKt.logError(e3);
                            objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String[]>() { // from class: com.phisher98.UltimaStorageManager$getCategorySyncedKeys$$inlined$getKey$1
                            });
                        } catch (Throwable th5) {
                            objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String[]>() { // from class: com.phisher98.UltimaStorageManager$getCategorySyncedKeys$$inlined$getKey$1
                            });
                        }
                    } else {
                        objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String[]>() { // from class: com.phisher98.UltimaStorageManager$getCategorySyncedKeys$$inlined$getKey$1
                        });
                    }
                }
            } catch (Exception e4) {
            }
        } else {
            objDecodeFromString = null;
        }
        String[] strArr2 = (String[]) objDecodeFromString;
        return (strArr2 != null || (set = ArraysKt.toSet(strArr2)) == null) ? SetsKt.emptySet() : set;
    }

    public final void setCategorySyncedKeys(@NotNull SyncCategory category, @NotNull Set<String> keys) {
        Set<String> $this$toTypedArray$iv = keys;
        CloudStreamApp.Companion.setKey("ULTIMA_SYNCED_KEYS_" + category.getKey(), $this$toTypedArray$iv.toArray(new String[0]));
    }

    public final void deleteAllData() {
        Iterable $this$forEach$iv = CollectionsKt.listOf(new String[]{"ULTIMA_PROVIDER_LIST", "ULTIMA_EXT_NAME_ON_HOME", "ULTIMA_EXTENSIONS_LIST", "ULTIMA_CURRENT_MEDIA_PROVIDERS", "ULTIMA_APP_SETTINGS_SYNC_CREDS", "ULTIMA_LAST_LOCAL_SYNC_TIME", "ULTIMA_SYNC_V2_MIGRATED"});
        for (Object element$iv : $this$forEach$iv) {
            String it = (String) element$iv;
            CloudStreamApp.Companion.setKey(it, (Object) null);
        }
        Iterable $this$forEach$iv2 = SyncCategory.getEntries();
        for (Object element$iv2 : $this$forEach$iv2) {
            SyncCategory cat = (SyncCategory) element$iv2;
            CloudStreamApp.Companion.setKey("ULTIMA_SYNC_TS_" + cat.getKey(), (Object) null);
            CloudStreamApp.Companion.setKey("ULTIMA_SYNC_HASH_" + cat.getKey(), (Object) null);
            CloudStreamApp.Companion.setKey("ULTIMA_SYNCED_KEYS_" + cat.getKey(), (Object) null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:121:0x013b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:123:0x0121 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:128:0x0189 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:129:0x0183 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x0127 A[Catch: all -> 0x0227, TryCatch #7 {, blocks: (B:5:0x0008, B:7:0x0015, B:9:0x0020, B:68:0x010e, B:69:0x0121, B:71:0x0127, B:73:0x013b, B:74:0x013f, B:75:0x015b, B:77:0x0161, B:79:0x016b, B:81:0x016f, B:87:0x018d, B:88:0x01b0, B:90:0x01b6, B:91:0x01e3, B:93:0x0202, B:84:0x0184, B:94:0x020e, B:12:0x0030, B:23:0x0073, B:35:0x00af, B:38:0x00b6, B:55:0x00de, B:53:0x00d5, B:34:0x00a5, B:22:0x0069), top: B:112:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x0161 A[Catch: all -> 0x0227, TryCatch #7 {, blocks: (B:5:0x0008, B:7:0x0015, B:9:0x0020, B:68:0x010e, B:69:0x0121, B:71:0x0127, B:73:0x013b, B:74:0x013f, B:75:0x015b, B:77:0x0161, B:79:0x016b, B:81:0x016f, B:87:0x018d, B:88:0x01b0, B:90:0x01b6, B:91:0x01e3, B:93:0x0202, B:84:0x0184, B:94:0x020e, B:12:0x0030, B:23:0x0073, B:35:0x00af, B:38:0x00b6, B:55:0x00de, B:53:0x00d5, B:34:0x00a5, B:22:0x0069), top: B:112:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x016b A[Catch: all -> 0x0227, TryCatch #7 {, blocks: (B:5:0x0008, B:7:0x0015, B:9:0x0020, B:68:0x010e, B:69:0x0121, B:71:0x0127, B:73:0x013b, B:74:0x013f, B:75:0x015b, B:77:0x0161, B:79:0x016b, B:81:0x016f, B:87:0x018d, B:88:0x01b0, B:90:0x01b6, B:91:0x01e3, B:93:0x0202, B:84:0x0184, B:94:0x020e, B:12:0x0030, B:23:0x0073, B:35:0x00af, B:38:0x00b6, B:55:0x00de, B:53:0x00d5, B:34:0x00a5, B:22:0x0069), top: B:112:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:81:0x016f A[Catch: all -> 0x0227, TryCatch #7 {, blocks: (B:5:0x0008, B:7:0x0015, B:9:0x0020, B:68:0x010e, B:69:0x0121, B:71:0x0127, B:73:0x013b, B:74:0x013f, B:75:0x015b, B:77:0x0161, B:79:0x016b, B:81:0x016f, B:87:0x018d, B:88:0x01b0, B:90:0x01b6, B:91:0x01e3, B:93:0x0202, B:84:0x0184, B:94:0x020e, B:12:0x0030, B:23:0x0073, B:35:0x00af, B:38:0x00b6, B:55:0x00de, B:53:0x00d5, B:34:0x00a5, B:22:0x0069), top: B:112:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:84:0x0184 A[Catch: all -> 0x0227, LOOP:2: B:80:0x016d->B:84:0x0184, LOOP_END, TryCatch #7 {, blocks: (B:5:0x0008, B:7:0x0015, B:9:0x0020, B:68:0x010e, B:69:0x0121, B:71:0x0127, B:73:0x013b, B:74:0x013f, B:75:0x015b, B:77:0x0161, B:79:0x016b, B:81:0x016f, B:87:0x018d, B:88:0x01b0, B:90:0x01b6, B:91:0x01e3, B:93:0x0202, B:84:0x0184, B:94:0x020e, B:12:0x0030, B:23:0x0073, B:35:0x00af, B:38:0x00b6, B:55:0x00de, B:53:0x00d5, B:34:0x00a5, B:22:0x0069), top: B:112:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x0189 A[EDGE_INSN: B:85:0x0189->B:86:0x018b BREAK  A[LOOP:2: B:80:0x016d->B:84:0x0184]] */
    /* JADX WARN: Code duplicated, block: B:87:0x018d A[Catch: all -> 0x0227, TryCatch #7 {, blocks: (B:5:0x0008, B:7:0x0015, B:9:0x0020, B:68:0x010e, B:69:0x0121, B:71:0x0127, B:73:0x013b, B:74:0x013f, B:75:0x015b, B:77:0x0161, B:79:0x016b, B:81:0x016f, B:87:0x018d, B:88:0x01b0, B:90:0x01b6, B:91:0x01e3, B:93:0x0202, B:84:0x0184, B:94:0x020e, B:12:0x0030, B:23:0x0073, B:35:0x00af, B:38:0x00b6, B:55:0x00de, B:53:0x00d5, B:34:0x00a5, B:22:0x0069), top: B:112:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x01b6 A[Catch: all -> 0x0227, LOOP:3: B:88:0x01b0->B:90:0x01b6, LOOP_END, TryCatch #7 {, blocks: (B:5:0x0008, B:7:0x0015, B:9:0x0020, B:68:0x010e, B:69:0x0121, B:71:0x0127, B:73:0x013b, B:74:0x013f, B:75:0x015b, B:77:0x0161, B:79:0x016b, B:81:0x016f, B:87:0x018d, B:88:0x01b0, B:90:0x01b6, B:91:0x01e3, B:93:0x0202, B:84:0x0184, B:94:0x020e, B:12:0x0030, B:23:0x0073, B:35:0x00af, B:38:0x00b6, B:55:0x00de, B:53:0x00d5, B:34:0x00a5, B:22:0x0069), top: B:112:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:92:0x01fc  */
    @NotNull
    public final UltimaUtils.ExtensionInfo[] fetchExtensions() {
        Object obj;
        UltimaUtils.ExtensionInfo[] cachedExtensions;
        Collection destination$iv$iv;
        Iterable $this$map$iv;
        int $i$f$map;
        Collection destination$iv$iv2;
        MainAPI provider;
        UltimaUtils.ExtensionInfo it;
        UltimaUtils.ExtensionInfo extensionInfo;
        Collection destination$iv$iv3;
        int length;
        int i;
        MainAPI it2;
        Object objDecodeFromString;
        Object obj2;
        String path$iv;
        String str;
        Iterable allProviders = UltimaUtils.INSTANCE.getAllProviders();
        synchronized (allProviders) {
            CloudStreamApp.Companion this_$iv = CloudStreamApp.Companion;
            Context context = this_$iv.getContext();
            if (context != null) {
                obj = null;
                try {
                    String string = DataStore.INSTANCE.getSharedPrefs(context).getString("ULTIMA_EXTENSIONS_LIST", null);
                    if (string != null) {
                        AppUtils appUtils = AppUtils.INSTANCE;
                        try {
                            Result.Companion companion = Result.Companion;
                            try {
                                KType kTypeTypeOf = Reflection.typeOf(UltimaUtils.ExtensionInfo[].class, KTypeProjection.Companion.invariant(Reflection.typeOf(UltimaUtils.ExtensionInfo.class)));
                                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                            } catch (Throwable th) {
                                th = th;
                                try {
                                    Result.Companion companion2 = Result.Companion;
                                    obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                                } catch (Exception e) {
                                    objDecodeFromString = null;
                                    obj = objDecodeFromString;
                                    cachedExtensions = (UltimaUtils.ExtensionInfo[]) obj;
                                    Iterable $this$filter$iv = allProviders;
                                    destination$iv$iv = new ArrayList();
                                    for (Object element$iv$iv : $this$filter$iv) {
                                        it2 = (MainAPI) element$iv$iv;
                                        if (!Intrinsics.areEqual(it2.getName(), "Ultima")) {
                                            destination$iv$iv.add(element$iv$iv);
                                        }
                                    }
                                    Iterable filtered = (List) destination$iv$iv;
                                    $this$map$iv = filtered;
                                    $i$f$map = 0;
                                    destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                    for (Object item$iv$iv : $this$map$iv) {
                                        provider = (MainAPI) item$iv$iv;
                                        if (cachedExtensions != null) {
                                            it = null;
                                            break;
                                        }
                                        length = cachedExtensions.length;
                                        i = 0;
                                        while (true) {
                                            if (i < length) {
                                                it = null;
                                                break;
                                            }
                                            it = cachedExtensions[i];
                                            if (Intrinsics.areEqual(it.getName(), provider.getName())) {
                                                break;
                                            }
                                            i++;
                                        }
                                        if (it == null) {
                                            String name = provider.getName();
                                            Iterable $this$map$iv2 = provider.getMainPage();
                                            int $i$f$map2 = CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10);
                                            destination$iv$iv3 = new ArrayList($i$f$map2);
                                            for (Object item$iv$iv2 : $this$map$iv2) {
                                                MainPageData section = (MainPageData) item$iv$iv2;
                                                destination$iv$iv3.add(new UltimaUtils.SectionInfo(section.getName(), section.getData(), provider.getName(), false, 0, 16, null));
                                            }
                                            Collection $this$toTypedArray$iv = (List) destination$iv$iv3;
                                            extensionInfo = new UltimaUtils.ExtensionInfo(name, (UltimaUtils.SectionInfo[]) $this$toTypedArray$iv.toArray(new UltimaUtils.SectionInfo[0]));
                                        } else {
                                            extensionInfo = it;
                                        }
                                        destination$iv$iv2.add(extensionInfo);
                                        $this$map$iv = $this$map$iv;
                                        $i$f$map = $i$f$map;
                                    }
                                    Collection $this$toTypedArray$iv2 = (List) destination$iv$iv2;
                                    return (UltimaUtils.ExtensionInfo[]) $this$toTypedArray$iv2.toArray(new UltimaUtils.ExtensionInfo[0]);
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                        if (Result.exceptionOrNull-impl(obj2) == null) {
                            path$iv = null;
                        } else {
                            try {
                                Result.Companion companion3 = Result.Companion;
                                path$iv = null;
                                try {
                                    obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(UltimaUtils.ExtensionInfo[].class), (List) null, 2, (Object) null));
                                } catch (Throwable th3) {
                                    th = th3;
                                    try {
                                        Result.Companion companion4 = Result.Companion;
                                        obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                                    } catch (Exception e2) {
                                        objDecodeFromString = null;
                                    }
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                path$iv = null;
                            }
                        }
                        if (Result.isFailure-impl(obj2)) {
                            obj2 = path$iv;
                        }
                        DeserializationStrategy deserializationStrategy = (KSerializer) obj2;
                        if (deserializationStrategy != null) {
                            try {
                                str = string;
                                try {
                                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, str);
                                } catch (SerializationException e3) {
                                    e = e3;
                                    ArchComponentExtKt.logError((Throwable) e);
                                    objDecodeFromString = MainAPIKt.getMapper().readValue(str, new TypeReference<UltimaUtils.ExtensionInfo[]>() { // from class: com.phisher98.UltimaStorageManager$fetchExtensions$lambda$0$$inlined$getKey$1
                                    });
                                } catch (Throwable th5) {
                                    objDecodeFromString = MainAPIKt.getMapper().readValue(str, new TypeReference<UltimaUtils.ExtensionInfo[]>() { // from class: com.phisher98.UltimaStorageManager$fetchExtensions$lambda$0$$inlined$getKey$1
                                    });
                                }
                            } catch (SerializationException e4) {
                                e = e4;
                                str = string;
                            } catch (Throwable th6) {
                                str = string;
                            }
                            obj = objDecodeFromString;
                        } else {
                            str = string;
                        }
                        objDecodeFromString = MainAPIKt.getMapper().readValue(str, new TypeReference<UltimaUtils.ExtensionInfo[]>() { // from class: com.phisher98.UltimaStorageManager$fetchExtensions$lambda$0$$inlined$getKey$1
                        });
                        obj = objDecodeFromString;
                    }
                } catch (Exception e5) {
                }
            } else {
                obj = null;
            }
            cachedExtensions = (UltimaUtils.ExtensionInfo[]) obj;
            Iterable $this$filter$iv2 = allProviders;
            destination$iv$iv = new ArrayList();
            while (r6.hasNext()) {
                it2 = (MainAPI) element$iv$iv;
                if (!Intrinsics.areEqual(it2.getName(), "Ultima")) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            Iterable filtered2 = (List) destination$iv$iv;
            $this$map$iv = filtered2;
            $i$f$map = 0;
            destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            while (r8.hasNext()) {
                provider = (MainAPI) item$iv$iv;
                if (cachedExtensions != null) {
                    it = null;
                    break;
                }
                length = cachedExtensions.length;
                i = 0;
                while (true) {
                    if (i < length) {
                        it = null;
                        break;
                    }
                    it = cachedExtensions[i];
                    if (Intrinsics.areEqual(it.getName(), provider.getName())) {
                        break;
                        break;
                    }
                    i++;
                }
                if (it == null) {
                    String name2 = provider.getName();
                    Iterable $this$map$iv3 = provider.getMainPage();
                    int $i$f$map3 = CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10);
                    destination$iv$iv3 = new ArrayList($i$f$map3);
                    while (r21.hasNext()) {
                        MainPageData section2 = (MainPageData) item$iv$iv2;
                        destination$iv$iv3.add(new UltimaUtils.SectionInfo(section2.getName(), section2.getData(), provider.getName(), false, 0, 16, null));
                    }
                    Collection $this$toTypedArray$iv3 = (List) destination$iv$iv3;
                    extensionInfo = new UltimaUtils.ExtensionInfo(name2, (UltimaUtils.SectionInfo[]) $this$toTypedArray$iv3.toArray(new UltimaUtils.SectionInfo[0]));
                } else {
                    extensionInfo = it;
                }
                destination$iv$iv2.add(extensionInfo);
                $this$map$iv = $this$map$iv;
                $i$f$map = $i$f$map;
            }
            Collection $this$toTypedArray$iv4 = (List) destination$iv$iv2;
        }
        return (UltimaUtils.ExtensionInfo[]) $this$toTypedArray$iv4.toArray(new UltimaUtils.ExtensionInfo[0]);
    }
}
