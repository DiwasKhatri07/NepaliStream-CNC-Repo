package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: UltimaBackupUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Ultima/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001Bó\u0001\u0012$\b\u0001\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012$\b\u0001\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b\u0012$\b\u0001\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\r\u0012$\b\u0001\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0003:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0010\u0012$\b\u0001\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0003:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0013\u0012,\b\u0001\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0015\u0018\u00010\u0003:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003HÆ\u0003J\u0017\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0003HÆ\u0003J\u0017\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0003HÆ\u0003J\u001f\u0010%\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0015\u0018\u00010\u0003HÆ\u0003Jõ\u0001\u0010&\u001a\u00020\u00002$\b\u0003\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b2$\b\u0003\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b2$\b\u0003\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\r2$\b\u0003\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0003:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u00102$\b\u0003\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0003:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u00132,\b\u0003\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0015\u0018\u00010\u0003:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0016HÆ\u0001J\u0014\u0010'\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010)\u001a\u00020\nHÖ\u0081\u0004J\n\u0010*\u001a\u00020\u0004HÖ\u0081\u0004R3\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR3\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR3\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR3\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR3\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR;\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0015\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001a¨\u0006+"}, d2 = {"Lcom/phisher98/BackupVars;", "", "bool", "", "", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "_Bool", "int", "", "_Int", "string", "_String", "float", "", "_Float", "long", "", "_Long", "stringSet", "", "_StringSet", "<init>", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "getBool", "()Ljava/util/Map;", "getInt", "getString", "getFloat", "getLong", "getStringSet", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "Ultima"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class BackupVars {

    @JsonProperty("_Bool")
    @Nullable
    private final Map<String, Boolean> bool;

    @JsonProperty("_Float")
    @Nullable
    private final Map<String, Float> float;

    @JsonProperty("_Int")
    @Nullable
    private final Map<String, Integer> int;

    @JsonProperty("_Long")
    @Nullable
    private final Map<String, Long> long;

    @JsonProperty("_String")
    @Nullable
    private final Map<String, String> string;

    @JsonProperty("_StringSet")
    @Nullable
    private final Map<String, Set<String>> stringSet;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BackupVars copy$default(BackupVars backupVars, Map map, Map map2, Map map3, Map map4, Map map5, Map map6, int i, Object obj) {
        if ((i & 1) != 0) {
            map = backupVars.bool;
        }
        if ((i & 2) != 0) {
            map2 = backupVars.int;
        }
        if ((i & 4) != 0) {
            map3 = backupVars.string;
        }
        if ((i & 8) != 0) {
            map4 = backupVars.float;
        }
        if ((i & 16) != 0) {
            map5 = backupVars.long;
        }
        if ((i & 32) != 0) {
            map6 = backupVars.stringSet;
        }
        Map map7 = map5;
        Map map8 = map6;
        return backupVars.copy(map, map2, map3, map4, map7, map8);
    }

    @Nullable
    public final Map<String, Boolean> component1() {
        return this.bool;
    }

    @Nullable
    public final Map<String, Integer> component2() {
        return this.int;
    }

    @Nullable
    public final Map<String, String> component3() {
        return this.string;
    }

    @Nullable
    public final Map<String, Float> component4() {
        return this.float;
    }

    @Nullable
    public final Map<String, Long> component5() {
        return this.long;
    }

    @Nullable
    public final Map<String, Set<String>> component6() {
        return this.stringSet;
    }

    @NotNull
    public final BackupVars copy(@JsonProperty("_Bool") @Nullable Map<String, Boolean> bool, @JsonProperty("_Int") @Nullable Map<String, Integer> map, @JsonProperty("_String") @Nullable Map<String, String> string, @JsonProperty("_Float") @Nullable Map<String, Float> map2, @JsonProperty("_Long") @Nullable Map<String, Long> map3, @JsonProperty("_StringSet") @Nullable Map<String, ? extends Set<String>> stringSet) {
        return new BackupVars(bool, map, string, map2, map3, stringSet);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BackupVars)) {
            return false;
        }
        BackupVars backupVars = (BackupVars) other;
        return Intrinsics.areEqual(this.bool, backupVars.bool) && Intrinsics.areEqual(this.int, backupVars.int) && Intrinsics.areEqual(this.string, backupVars.string) && Intrinsics.areEqual(this.float, backupVars.float) && Intrinsics.areEqual(this.long, backupVars.long) && Intrinsics.areEqual(this.stringSet, backupVars.stringSet);
    }

    public int hashCode() {
        return ((((((((((this.bool == null ? 0 : this.bool.hashCode()) * 31) + (this.int == null ? 0 : this.int.hashCode())) * 31) + (this.string == null ? 0 : this.string.hashCode())) * 31) + (this.float == null ? 0 : this.float.hashCode())) * 31) + (this.long == null ? 0 : this.long.hashCode())) * 31) + (this.stringSet != null ? this.stringSet.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "BackupVars(bool=" + this.bool + ", int=" + this.int + ", string=" + this.string + ", float=" + this.float + ", long=" + this.long + ", stringSet=" + this.stringSet + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BackupVars(@JsonProperty("_Bool") @Nullable Map<String, Boolean> map, @JsonProperty("_Int") @Nullable Map<String, Integer> map2, @JsonProperty("_String") @Nullable Map<String, String> map3, @JsonProperty("_Float") @Nullable Map<String, Float> map4, @JsonProperty("_Long") @Nullable Map<String, Long> map5, @JsonProperty("_StringSet") @Nullable Map<String, ? extends Set<String>> map6) {
        this.bool = map;
        this.int = map2;
        this.string = map3;
        this.float = map4;
        this.long = map5;
        this.stringSet = map6;
    }

    @Nullable
    public final Map<String, Boolean> getBool() {
        return this.bool;
    }

    @Nullable
    public final Map<String, Integer> getInt() {
        return this.int;
    }

    @Nullable
    public final Map<String, String> getString() {
        return this.string;
    }

    @Nullable
    public final Map<String, Float> getFloat() {
        return this.float;
    }

    @Nullable
    public final Map<String, Long> getLong() {
        return this.long;
    }

    @Nullable
    public final Map<String, Set<String>> getStringSet() {
        return this.stringSet;
    }
}
