package com.anikoto;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
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
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AnikotoUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/AniKoto/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"parseAnimeData", "Lcom/anikoto/MetaAnimeData;", "jsonString", "", "AniKoto"}, k = 2, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAnikotoUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnikotoUtils.kt\ncom/anikoto/AnikotoUtilsKt\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,28:1\n93#2,2:29\n63#2:31\n64#2,15:33\n95#2,2:50\n1#3:32\n50#4:48\n43#4:49\n*S KotlinDebug\n*F\n+ 1 AnikotoUtils.kt\ncom/anikoto/AnikotoUtilsKt\n*L\n6#1:29,2\n6#1:31\n6#1:33,15\n6#1:50,2\n6#1:32\n6#1:48\n6#1:49\n*E\n"})
public final class AnikotoUtilsKt {
    /* JADX WARN: Code duplicated, block: B:19:0x0064  */
    /* JADX WARN: Code duplicated, block: B:28:0x0080 A[Catch: Exception -> 0x0096, TRY_LEAVE, TryCatch #4 {Exception -> 0x0096, blocks: (B:10:0x0030, B:17:0x005e, B:20:0x0065, B:28:0x0080, B:27:0x007a, B:16:0x0053, B:9:0x0026, B:13:0x0037, B:6:0x000d, B:22:0x006b), top: B:36:0x000d, inners: #0, #1, #5 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Nullable
    public static final MetaAnimeData parseAnimeData(@NotNull String jsonString) {
        Object obj;
        DeserializationStrategy deserializationStrategy;
        AppUtils appUtils = AppUtils.INSTANCE;
        Object objDecodeFromString = null;
        if (jsonString != null) {
            try {
                try {
                    Result.Companion companion = Result.Companion;
                    KType kTypeTypeOf = Reflection.typeOf(MetaAnimeData.class);
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (Result.exceptionOrNull-impl(obj) != null) {
                    try {
                        Result.Companion companion3 = Result.Companion;
                        obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(MetaAnimeData.class), (List) null, 2, (Object) null));
                    } catch (Throwable th2) {
                        Result.Companion companion4 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th2));
                    }
                    if (Result.isFailure-impl(obj)) {
                        obj = null;
                    }
                    deserializationStrategy = (KSerializer) obj;
                    if (deserializationStrategy != null) {
                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, jsonString);
                    } else {
                        ObjectMapper $this$readValue$iv$iv$iv = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv$iv.readValue(jsonString, new TypeReference<MetaAnimeData>() { // from class: com.anikoto.AnikotoUtilsKt$parseAnimeData$$inlined$tryParseJson$1
                        });
                    }
                } else {
                    if (Result.isFailure-impl(obj)) {
                        obj = null;
                    }
                    deserializationStrategy = (KSerializer) obj;
                    if (deserializationStrategy != null) {
                        try {
                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, jsonString);
                        } catch (SerializationException e) {
                            ArchComponentExtKt.logError(e);
                            ObjectMapper $this$readValue$iv$iv$iv2 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv$iv2.readValue(jsonString, new TypeReference<MetaAnimeData>() { // from class: com.anikoto.AnikotoUtilsKt$parseAnimeData$$inlined$tryParseJson$1
                            });
                        } catch (Throwable th3) {
                            ObjectMapper $this$readValue$iv$iv$iv3 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv$iv3.readValue(jsonString, new TypeReference<MetaAnimeData>() { // from class: com.anikoto.AnikotoUtilsKt$parseAnimeData$$inlined$tryParseJson$1
                            });
                        }
                    } else {
                        ObjectMapper $this$readValue$iv$iv$iv4 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv$iv4.readValue(jsonString, new TypeReference<MetaAnimeData>() { // from class: com.anikoto.AnikotoUtilsKt$parseAnimeData$$inlined$tryParseJson$1
                        });
                    }
                }
            } catch (Exception e2) {
            }
        }
        return (MetaAnimeData) objDecodeFromString;
    }
}
