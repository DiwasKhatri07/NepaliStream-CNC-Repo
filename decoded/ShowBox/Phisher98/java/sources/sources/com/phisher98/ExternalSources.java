package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ShowBoxparser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/ShowBox/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u008b\u0001\u0010\u0017\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00072\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\tHÆ\u0001J\u0014\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u001cHÖ\u0081\u0004J\n\u0010\u001d\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/phisher98/ExternalSources;", "", "source", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "file", "label", "type", "size", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSource", "()Ljava/lang/String;", "getFile", "getLabel", "getType", "getSize", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "ShowBox"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class ExternalSources {

    @Nullable
    private final String file;

    @Nullable
    private final String label;

    @Nullable
    private final String size;

    @Nullable
    private final String source;

    @Nullable
    private final String type;

    public ExternalSources() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ ExternalSources copy$default(ExternalSources externalSources, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = externalSources.source;
        }
        if ((i & 2) != 0) {
            str2 = externalSources.file;
        }
        if ((i & 4) != 0) {
            str3 = externalSources.label;
        }
        if ((i & 8) != 0) {
            str4 = externalSources.type;
        }
        if ((i & 16) != 0) {
            str5 = externalSources.size;
        }
        String str6 = str5;
        String str7 = str3;
        return externalSources.copy(str, str2, str7, str4, str6);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSource() {
        return this.source;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFile() {
        return this.file;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getSize() {
        return this.size;
    }

    @NotNull
    public final ExternalSources copy(@JsonProperty("source") @Nullable String source, @JsonProperty("file") @Nullable String file, @JsonProperty("label") @Nullable String label, @JsonProperty("type") @Nullable String type, @JsonProperty("size") @Nullable String size) {
        return new ExternalSources(source, file, label, type, size);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExternalSources)) {
            return false;
        }
        ExternalSources externalSources = (ExternalSources) other;
        return Intrinsics.areEqual(this.source, externalSources.source) && Intrinsics.areEqual(this.file, externalSources.file) && Intrinsics.areEqual(this.label, externalSources.label) && Intrinsics.areEqual(this.type, externalSources.type) && Intrinsics.areEqual(this.size, externalSources.size);
    }

    public int hashCode() {
        return ((((((((this.source == null ? 0 : this.source.hashCode()) * 31) + (this.file == null ? 0 : this.file.hashCode())) * 31) + (this.label == null ? 0 : this.label.hashCode())) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.size != null ? this.size.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ExternalSources(source=" + this.source + ", file=" + this.file + ", label=" + this.label + ", type=" + this.type + ", size=" + this.size + ')';
    }

    public ExternalSources(@JsonProperty("source") @Nullable String source, @JsonProperty("file") @Nullable String file, @JsonProperty("label") @Nullable String label, @JsonProperty("type") @Nullable String type, @JsonProperty("size") @Nullable String size) {
        this.source = source;
        this.file = file;
        this.label = label;
        this.type = type;
        this.size = size;
    }

    public /* synthetic */ ExternalSources(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5);
    }

    @Nullable
    public final String getSource() {
        return this.source;
    }

    @Nullable
    public final String getFile() {
        return this.file;
    }

    @Nullable
    public final String getLabel() {
        return this.label;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final String getSize() {
        return this.size;
    }
}
