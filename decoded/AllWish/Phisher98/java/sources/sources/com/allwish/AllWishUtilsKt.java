package com.allwish;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.ShowStatus;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.StringUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
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

/* JADX INFO: compiled from: AllWishUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/AllWish/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0001\u001a\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001¨\u0006\t"}, d2 = {"generateEpisodeVrf", "", "episodeId", "parseAnimeData", "Lcom/allwish/MetaAnimeData;", "jsonString", "getStatus", "Lcom/lagradost/cloudstream3/ShowStatus;", "t", "AllWish"}, k = 2, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAllWishUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AllWishUtils.kt\ncom/allwish/AllWishUtilsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 6 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 7 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,119:1\n1#2:120\n1#2:145\n990#3:121\n1065#3,3:122\n990#3:125\n1065#3,3:126\n990#3:138\n1065#3,3:139\n1739#4:129\n1814#4,3:130\n12846#5:133\n12963#5,4:134\n93#6,2:142\n63#6:144\n64#6,15:146\n95#6,2:163\n50#7:161\n43#7:162\n*S KotlinDebug\n*F\n+ 1 AllWishUtils.kt\ncom/allwish/AllWishUtilsKt\n*L\n78#1:145\n21#1:121\n21#1:122,3\n22#1:125\n22#1:126,3\n65#1:138\n65#1:139,3\n40#1:129\n40#1:130,3\n46#1:133\n46#1:134,4\n78#1:142,2\n78#1:144\n78#1:146,15\n78#1:163,2\n78#1:161\n78#1:162\n*E\n"})
public final class AllWishUtilsKt {
    @NotNull
    public static final String generateEpisodeVrf(@NotNull String episodeId) {
        char c;
        String secretKey = "ysJhV6U27FVIjjuk";
        StringUtils $this$generateEpisodeVrf_u24lambda_u240 = StringUtils.INSTANCE;
        CharSequence encodedId = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default($this$generateEpisodeVrf_u24lambda_u240.encodeUri(episodeId), "+", "%20", false, 4, (Object) null), "%21", "!", false, 4, (Object) null), "%27", "'", false, 4, (Object) null), "%28", "(", false, 4, (Object) null), "%29", ")", false, 4, (Object) null), "%7E", "~", false, 4, (Object) null), "%2A", "*", false, 4, (Object) null);
        Collection destination$iv$iv = new ArrayList($this$map$iv.length());
        for (int i = 0; i < $this$map$iv.length(); i++) {
            char item$iv$iv = $this$map$iv.charAt(i);
            destination$iv$iv.add(Integer.valueOf(item$iv$iv));
        }
        List keyCodes = (List) destination$iv$iv;
        CharSequence $this$map$iv = encodedId;
        Collection destination$iv$iv2 = new ArrayList($this$map$iv.length());
        for (int i2 = 0; i2 < $this$map$iv.length(); i2++) {
            char item$iv$iv2 = $this$map$iv.charAt(i2);
            destination$iv$iv2.add(Integer.valueOf(item$iv$iv2));
        }
        List dataCodes = (List) destination$iv$iv2;
        int[] n = new int[256];
        for (int i3 = 0; i3 < 256; i3++) {
            n[i3] = i3;
        }
        int a = 0;
        for (int o = 0; o < 256; o++) {
            a = ((n[o] + a) + ((Number) keyCodes.get(o % keyCodes.size())).intValue()) % 256;
            int i4 = n[a];
            n[a] = n[o];
            Unit unit = Unit.INSTANCE;
            n[o] = i4;
        }
        List out = new ArrayList();
        int o2 = 0;
        int a2 = 0;
        int size = dataCodes.size();
        for (int r = 0; r < size; r++) {
            o2 = (o2 + 1) % 256;
            a2 = (n[o2] + a2) % 256;
            int i5 = n[a2];
            n[a2] = n[o2];
            Unit unit2 = Unit.INSTANCE;
            n[o2] = i5;
            int k = n[(n[o2] + n[a2]) % 256];
            out.add(Integer.valueOf(((Number) dataCodes.get(r)).intValue() ^ k));
        }
        List $this$map$iv2 = out;
        Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (Object item$iv$iv3 : $this$map$iv2) {
            int it = ((Number) item$iv$iv3).intValue();
            destination$iv$iv3.add(Byte.valueOf((byte) (it & 255)));
            secretKey = secretKey;
        }
        byte[] step1 = CollectionsKt.toByteArray((List) destination$iv$iv3);
        String base1 = StringsKt.replace$default(StringsKt.replace$default(MainAPIKt.base64Encode(step1), "+", "-", false, 4, (Object) null), "/", "_", false, 4, (Object) null);
        byte[] step2Bytes = StringsKt.encodeToByteArray(base1);
        Collection destination$iv$iv4 = new ArrayList(step2Bytes.length);
        int index$iv$iv = 0;
        int length = step2Bytes.length;
        int i6 = 0;
        while (i6 < length) {
            byte item$iv$iv4 = step2Bytes[i6];
            int index$iv$iv2 = index$iv$iv + 1;
            byte b = 5;
            switch (index$iv$iv % 8) {
                case 0:
                    b = -3;
                    break;
                case 1:
                    b = 3;
                    break;
                case 2:
                    b = -4;
                    break;
                case 3:
                    b = 2;
                    break;
                case 4:
                    b = -2;
                    break;
                case 5:
                case 7:
                    break;
                case 6:
                    b = 4;
                    break;
                default:
                    b = 0;
                    break;
            }
            int i7 = length;
            int s = item$iv$iv4 + b;
            int s2 = i6;
            destination$iv$iv4.add(Byte.valueOf((byte) (s & 255)));
            i6 = s2 + 1;
            index$iv$iv = index$iv$iv2;
            length = i7;
        }
        List transformedList = (List) destination$iv$iv4;
        byte[] transformedBytes = CollectionsKt.toByteArray(transformedList);
        CharSequence base2 = StringsKt.replace$default(StringsKt.replace$default(MainAPIKt.base64Encode(transformedBytes), "+", "-", false, 4, (Object) null), "/", "_", false, 4, (Object) null);
        CharSequence $this$map$iv3 = base2;
        Collection destination$iv$iv5 = new ArrayList($this$map$iv3.length());
        int i8 = 0;
        while (true) {
            byte[] transformedBytes2 = transformedBytes;
            if (i8 < $this$map$iv3.length()) {
                char c2 = $this$map$iv3.charAt(i8);
                int i9 = i8;
                if ('A' <= c2 && c2 < '[') {
                    c = (char) ((((c2 - 'A') + 13) % 26) + 65);
                } else {
                    c = 'a' <= c2 && c2 < '{' ? (char) ((((c2 - 'a') + 13) % 26) + 97) : c2;
                }
                destination$iv$iv5.add(Character.valueOf(c));
                i8 = i9 + 1;
                transformedBytes = transformedBytes2;
            } else {
                return CollectionsKt.joinToString$default((List) destination$iv$iv5, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0066  */
    /* JADX WARN: Code duplicated, block: B:30:0x0082 A[Catch: Exception -> 0x0098, TRY_LEAVE, TryCatch #4 {Exception -> 0x0098, blocks: (B:12:0x0032, B:19:0x0060, B:22:0x0067, B:30:0x0082, B:29:0x007c, B:18:0x0055, B:11:0x0028, B:15:0x0039, B:8:0x000f, B:24:0x006d), top: B:44:0x000f, inners: #1, #3, #6 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Nullable
    public static final MetaAnimeData parseAnimeData(@NotNull String jsonString) {
        Object objDecodeFromString;
        Object obj;
        DeserializationStrategy deserializationStrategy;
        try {
            AppUtils appUtils = AppUtils.INSTANCE;
            if (jsonString == null) {
                objDecodeFromString = null;
            } else {
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
                            objDecodeFromString = $this$readValue$iv$iv$iv.readValue(jsonString, new TypeReference<MetaAnimeData>() { // from class: com.allwish.AllWishUtilsKt$parseAnimeData$$inlined$tryParseJson$1
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
                                objDecodeFromString = $this$readValue$iv$iv$iv2.readValue(jsonString, new TypeReference<MetaAnimeData>() { // from class: com.allwish.AllWishUtilsKt$parseAnimeData$$inlined$tryParseJson$1
                                });
                            } catch (Throwable th3) {
                                ObjectMapper $this$readValue$iv$iv$iv3 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv$iv3.readValue(jsonString, new TypeReference<MetaAnimeData>() { // from class: com.allwish.AllWishUtilsKt$parseAnimeData$$inlined$tryParseJson$1
                                });
                            }
                        } else {
                            ObjectMapper $this$readValue$iv$iv$iv4 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv$iv4.readValue(jsonString, new TypeReference<MetaAnimeData>() { // from class: com.allwish.AllWishUtilsKt$parseAnimeData$$inlined$tryParseJson$1
                            });
                        }
                    }
                } catch (Exception e2) {
                    objDecodeFromString = null;
                }
            }
            return (MetaAnimeData) objDecodeFromString;
        } catch (Exception e3) {
            return null;
        }
    }

    @NotNull
    public static final ShowStatus getStatus(@Nullable String t) {
        if (Intrinsics.areEqual(t, "Finished Airing")) {
            return ShowStatus.Completed;
        }
        return Intrinsics.areEqual(t, "Updating") ? ShowStatus.Ongoing : ShowStatus.Completed;
    }
}
