package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lagradost.api.Log;
import com.lagradost.cloudstream3.APIHolder;
import com.lagradost.cloudstream3.MainAPI;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: UltimaUtils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Ultima/classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\u0007\b\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\n"}, d2 = {"Lcom/phisher98/UltimaUtils;", "", "<init>", "()V", "getAllProviders", "", "Lcom/lagradost/cloudstream3/MainAPI;", "SectionInfo", "ExtensionInfo", "MediaProviderState", "Ultima"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nUltimaUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UltimaUtils.kt\ncom/phisher98/UltimaUtils\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,229:1\n812#2,12:230\n812#2,12:254\n812#2,12:278\n4253#3,12:242\n4253#3,12:266\n*S KotlinDebug\n*F\n+ 1 UltimaUtils.kt\ncom/phisher98/UltimaUtils\n*L\n29#1:230,12\n43#1:254,12\n57#1:278,12\n32#1:242,12\n46#1:266,12\n*E\n"})
public final class UltimaUtils {

    @NotNull
    public static final UltimaUtils INSTANCE = new UltimaUtils();

    private UltimaUtils() {
    }

    @NotNull
    public final List<MainAPI> getAllProviders() {
        Field instanceField;
        try {
            Class<?> cls = Class.forName("com.lagradost.cloudstream3.APIHolder");
            try {
                instanceField = cls.getDeclaredField("INSTANCE");
            } catch (Exception e) {
                instanceField = null;
            }
            Object instance = instanceField != null ? instanceField.get(null) : null;
            int i = 0;
            for (Method method : cls.getDeclaredMethods()) {
                if (Intrinsics.areEqual(method.getName(), "getAllProviders") || Intrinsics.areEqual(method.getName(), "getProviders") || Intrinsics.areEqual(method.getName(), "getApis")) {
                    method.setAccessible(true);
                    Object result = instance != null ? method.invoke(instance, new Object[0]) : method.invoke(null, new Object[0]);
                    if (result instanceof List) {
                        Iterable $this$filterIsInstance$iv = (Iterable) result;
                        Collection destination$iv$iv = new ArrayList();
                        for (Object element$iv$iv : $this$filterIsInstance$iv) {
                            if (element$iv$iv instanceof MainAPI) {
                                destination$iv$iv.add(element$iv$iv);
                            }
                        }
                        return (List) destination$iv$iv;
                    }
                    if (result instanceof Object[]) {
                        Object[] $this$filterIsInstance$iv2 = (Object[]) result;
                        Collection destination$iv$iv2 = new ArrayList();
                        int length = $this$filterIsInstance$iv2.length;
                        while (i < length) {
                            Object element$iv$iv2 = $this$filterIsInstance$iv2[i];
                            if (element$iv$iv2 instanceof MainAPI) {
                                destination$iv$iv2.add(element$iv$iv2);
                            }
                            i++;
                        }
                        return (List) destination$iv$iv2;
                    }
                }
            }
            for (Field field : cls.getDeclaredFields()) {
                if (Intrinsics.areEqual(field.getName(), "allProviders") || Intrinsics.areEqual(field.getName(), "providers") || Intrinsics.areEqual(field.getName(), "apis")) {
                    field.setAccessible(true);
                    Object result2 = instance != null ? field.get(instance) : field.get(null);
                    if (result2 instanceof List) {
                        Iterable $this$filterIsInstance$iv3 = (Iterable) result2;
                        Collection destination$iv$iv3 = new ArrayList();
                        for (Object element$iv$iv3 : $this$filterIsInstance$iv3) {
                            if (element$iv$iv3 instanceof MainAPI) {
                                destination$iv$iv3.add(element$iv$iv3);
                            }
                        }
                        return (List) destination$iv$iv3;
                    }
                    if (result2 instanceof Object[]) {
                        Object[] $this$filterIsInstance$iv4 = (Object[]) result2;
                        Collection destination$iv$iv4 = new ArrayList();
                        int length2 = $this$filterIsInstance$iv4.length;
                        while (i < length2) {
                            Object element$iv$iv4 = $this$filterIsInstance$iv4[i];
                            if (element$iv$iv4 instanceof MainAPI) {
                                destination$iv$iv4.add(element$iv$iv4);
                            }
                            i++;
                        }
                        return (List) destination$iv$iv4;
                    }
                }
            }
            for (Method method2 : cls.getDeclaredMethods()) {
                if (Intrinsics.areEqual(method2.getName(), "allProviders")) {
                    method2.setAccessible(true);
                    Object result3 = instance != null ? method2.invoke(instance, new Object[0]) : method2.invoke(null, new Object[0]);
                    if (result3 instanceof List) {
                        Collection destination$iv$iv5 = new ArrayList();
                        for (Object element$iv$iv5 : (Iterable) result3) {
                            if (element$iv$iv5 instanceof MainAPI) {
                                destination$iv$iv5.add(element$iv$iv5);
                            }
                        }
                        return (List) destination$iv$iv5;
                    }
                }
            }
        } catch (Exception e2) {
            Log.INSTANCE.e("Ultima", "Failed to retrieve allProviders via reflection: " + e2.getMessage());
        }
        try {
            return APIHolder.INSTANCE.getAllProviders();
        } catch (Throwable th) {
            return CollectionsKt.emptyList();
        }
    }

    /* JADX INFO: compiled from: UltimaUtils.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0016\b\u0001\u0010\u0006\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0016\b\u0001\u0010\u0007\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0016\b\u0003\u0010\b\u001a\u00020\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0016\b\u0003\u0010\n\u001a\u00020\u000b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\t\u0010\"\u001a\u00020\u000bHÆ\u0003J\u0081\u0001\u0010#\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0016\b\u0003\u0010\u0006\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0016\b\u0003\u0010\u0007\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00072\u0016\b\u0003\u0010\b\u001a\u00020\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0016\b\u0003\u0010\n\u001a\u00020\u000b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\nHÆ\u0001J\u0014\u0010$\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010&\u001a\u00020\u000bHÖ\u0081\u0004J\n\u0010'\u001a\u00020\u0003HÖ\u0081\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006("}, d2 = {"Lcom/phisher98/UltimaUtils$SectionInfo;", "", "name", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "url", "pluginName", "enabled", "", "priority", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZI)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getUrl", "setUrl", "getPluginName", "setPluginName", "getEnabled", "()Z", "setEnabled", "(Z)V", "getPriority", "()I", "setPriority", "(I)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "Ultima"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class SectionInfo {
        private boolean enabled;

        @NotNull
        private String name;

        @NotNull
        private String pluginName;
        private int priority;

        @NotNull
        private String url;

        public static /* synthetic */ SectionInfo copy$default(SectionInfo sectionInfo, String str, String str2, String str3, boolean z, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = sectionInfo.name;
            }
            if ((i2 & 2) != 0) {
                str2 = sectionInfo.url;
            }
            if ((i2 & 4) != 0) {
                str3 = sectionInfo.pluginName;
            }
            if ((i2 & 8) != 0) {
                z = sectionInfo.enabled;
            }
            if ((i2 & 16) != 0) {
                i = sectionInfo.priority;
            }
            int i3 = i;
            String str4 = str3;
            return sectionInfo.copy(str, str2, str4, z, i3);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getPluginName() {
            return this.pluginName;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getEnabled() {
            return this.enabled;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final int getPriority() {
            return this.priority;
        }

        @NotNull
        public final SectionInfo copy(@JsonProperty("name") @NotNull String name, @JsonProperty("url") @NotNull String url, @JsonProperty("pluginName") @NotNull String pluginName, @JsonProperty("enabled") boolean enabled, @JsonProperty("priority") int priority) {
            return new SectionInfo(name, url, pluginName, enabled, priority);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SectionInfo)) {
                return false;
            }
            SectionInfo sectionInfo = (SectionInfo) other;
            return Intrinsics.areEqual(this.name, sectionInfo.name) && Intrinsics.areEqual(this.url, sectionInfo.url) && Intrinsics.areEqual(this.pluginName, sectionInfo.pluginName) && this.enabled == sectionInfo.enabled && this.priority == sectionInfo.priority;
        }

        public int hashCode() {
            return (((((((this.name.hashCode() * 31) + this.url.hashCode()) * 31) + this.pluginName.hashCode()) * 31) + UltimaUtils$SectionInfo$$ExternalSyntheticBackport0.m6m(this.enabled)) * 31) + this.priority;
        }

        @NotNull
        public String toString() {
            return "SectionInfo(name=" + this.name + ", url=" + this.url + ", pluginName=" + this.pluginName + ", enabled=" + this.enabled + ", priority=" + this.priority + ')';
        }

        public SectionInfo(@JsonProperty("name") @NotNull String name, @JsonProperty("url") @NotNull String url, @JsonProperty("pluginName") @NotNull String pluginName, @JsonProperty("enabled") boolean enabled, @JsonProperty("priority") int priority) {
            this.name = name;
            this.url = url;
            this.pluginName = pluginName;
            this.enabled = enabled;
            this.priority = priority;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ SectionInfo(String str, String str2, String str3, boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            int i3;
            z = (i2 & 8) != 0 ? false : z;
            if ((i2 & 16) == 0) {
                i3 = i;
            } else {
                i3 = 0;
            }
            this(str, str2, str3, z, i3);
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        public final void setName(@NotNull String str) {
            this.name = str;
        }

        @NotNull
        public final String getUrl() {
            return this.url;
        }

        public final void setUrl(@NotNull String str) {
            this.url = str;
        }

        @NotNull
        public final String getPluginName() {
            return this.pluginName;
        }

        public final void setPluginName(@NotNull String str) {
            this.pluginName = str;
        }

        public final boolean getEnabled() {
            return this.enabled;
        }

        public final void setEnabled(boolean z) {
            this.enabled = z;
        }

        public final int getPriority() {
            return this.priority;
        }

        public final void setPriority(int i) {
            this.priority = i;
        }
    }

    /* JADX INFO: compiled from: UltimaUtils.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u001e\b\u0003\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\t\u0010\nJ\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J\n\u0010\u0017\u001a\u00020\u0018H\u0096\u0080\u0004J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0016\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0010JH\u0010\u001b\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u001e\b\u0003\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001¢\u0006\u0002\u0010\u001cJ\n\u0010\u001d\u001a\u00020\u0003HÖ\u0081\u0004R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/phisher98/UltimaUtils$ExtensionInfo;", "", "name", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "sections", "", "Lcom/phisher98/UltimaUtils$SectionInfo;", "<init>", "(Ljava/lang/String;[Lcom/phisher98/UltimaUtils$SectionInfo;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getSections", "()[Lcom/phisher98/UltimaUtils$SectionInfo;", "setSections", "([Lcom/phisher98/UltimaUtils$SectionInfo;)V", "[Lcom/phisher98/UltimaUtils$SectionInfo;", "equals", "", "other", "hashCode", "", "component1", "component2", "copy", "(Ljava/lang/String;[Lcom/phisher98/UltimaUtils$SectionInfo;)Lcom/phisher98/UltimaUtils$ExtensionInfo;", "toString", "Ultima"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class ExtensionInfo {

        @Nullable
        private String name;

        @Nullable
        private SectionInfo[] sections;

        /* JADX WARN: Multi-variable type inference failed */
        public ExtensionInfo() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ ExtensionInfo copy$default(ExtensionInfo extensionInfo, String str, SectionInfo[] sectionInfoArr, int i, Object obj) {
            if ((i & 1) != 0) {
                str = extensionInfo.name;
            }
            if ((i & 2) != 0) {
                sectionInfoArr = extensionInfo.sections;
            }
            return extensionInfo.copy(str, sectionInfoArr);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final SectionInfo[] getSections() {
            return this.sections;
        }

        @NotNull
        public final ExtensionInfo copy(@JsonProperty("name") @Nullable String name, @JsonProperty("sections") @Nullable SectionInfo[] sections) {
            return new ExtensionInfo(name, sections);
        }

        @NotNull
        public String toString() {
            return "ExtensionInfo(name=" + this.name + ", sections=" + Arrays.toString(this.sections) + ')';
        }

        public ExtensionInfo(@JsonProperty("name") @Nullable String name, @JsonProperty("sections") @Nullable SectionInfo[] sections) {
            this.name = name;
            this.sections = sections;
        }

        public /* synthetic */ ExtensionInfo(String str, SectionInfo[] sectionInfoArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : sectionInfoArr);
        }

        @Nullable
        public final String getName() {
            return this.name;
        }

        public final void setName(@Nullable String str) {
            this.name = str;
        }

        @Nullable
        public final SectionInfo[] getSections() {
            return this.sections;
        }

        public final void setSections(@Nullable SectionInfo[] sectionInfoArr) {
            this.sections = sectionInfoArr;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.phisher98.UltimaUtils.ExtensionInfo");
            return Intrinsics.areEqual(this.name, ((ExtensionInfo) other).name) && Arrays.equals(this.sections, ((ExtensionInfo) other).sections);
        }

        public int hashCode() {
            String str = this.name;
            int result = str != null ? str.hashCode() : 0;
            int i = result * 31;
            SectionInfo[] sectionInfoArr = this.sections;
            int result2 = i + (sectionInfoArr != null ? Arrays.hashCode(sectionInfoArr) : 0);
            return result2;
        }
    }

    /* JADX INFO: compiled from: UltimaUtils.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0016\b\u0003\u0010\u0006\u001a\u00020\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003JS\u0010\u0018\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0016\b\u0003\u0010\u0006\u001a\u00020\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\bHÆ\u0001J\u0014\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u001cHÖ\u0081\u0004J\n\u0010\u001d\u001a\u00020\u0003HÖ\u0081\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/phisher98/UltimaUtils$MediaProviderState;", "", "name", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "enabled", "", "customDomain", "<init>", "(Ljava/lang/String;ZLjava/lang/String;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getEnabled", "()Z", "setEnabled", "(Z)V", "getCustomDomain", "setCustomDomain", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "Ultima"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class MediaProviderState {

        @Nullable
        private String customDomain;
        private boolean enabled;

        @NotNull
        private String name;

        public static /* synthetic */ MediaProviderState copy$default(MediaProviderState mediaProviderState, String str, boolean z, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = mediaProviderState.name;
            }
            if ((i & 2) != 0) {
                z = mediaProviderState.enabled;
            }
            if ((i & 4) != 0) {
                str2 = mediaProviderState.customDomain;
            }
            return mediaProviderState.copy(str, z, str2);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getEnabled() {
            return this.enabled;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getCustomDomain() {
            return this.customDomain;
        }

        @NotNull
        public final MediaProviderState copy(@JsonProperty("name") @NotNull String name, @JsonProperty("enabled") boolean enabled, @JsonProperty("customDomain") @Nullable String customDomain) {
            return new MediaProviderState(name, enabled, customDomain);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MediaProviderState)) {
                return false;
            }
            MediaProviderState mediaProviderState = (MediaProviderState) other;
            return Intrinsics.areEqual(this.name, mediaProviderState.name) && this.enabled == mediaProviderState.enabled && Intrinsics.areEqual(this.customDomain, mediaProviderState.customDomain);
        }

        public int hashCode() {
            return (((this.name.hashCode() * 31) + UltimaUtils$MediaProviderState$$ExternalSyntheticBackport0.m5m(this.enabled)) * 31) + (this.customDomain == null ? 0 : this.customDomain.hashCode());
        }

        @NotNull
        public String toString() {
            return "MediaProviderState(name=" + this.name + ", enabled=" + this.enabled + ", customDomain=" + this.customDomain + ')';
        }

        public MediaProviderState(@JsonProperty("name") @NotNull String name, @JsonProperty("enabled") boolean enabled, @JsonProperty("customDomain") @Nullable String customDomain) {
            this.name = name;
            this.enabled = enabled;
            this.customDomain = customDomain;
        }

        public /* synthetic */ MediaProviderState(String str, boolean z, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? true : z, (i & 4) != 0 ? null : str2);
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        public final void setName(@NotNull String str) {
            this.name = str;
        }

        public final boolean getEnabled() {
            return this.enabled;
        }

        public final void setEnabled(boolean z) {
            this.enabled = z;
        }

        @Nullable
        public final String getCustomDomain() {
            return this.customDomain;
        }

        public final void setCustomDomain(@Nullable String str) {
            this.customDomain = str;
        }
    }
}
